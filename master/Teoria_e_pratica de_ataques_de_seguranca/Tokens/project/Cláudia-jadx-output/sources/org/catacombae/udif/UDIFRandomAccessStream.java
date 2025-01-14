package org.catacombae.udif;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.catacombae.io.BasicReadableRandomAccessStream;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFRandomAccessStream.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFRandomAccessStream.class */
public class UDIFRandomAccessStream extends BasicReadableRandomAccessStream {
    private UDIFFile dmgFile;
    private UDIFBlock[] allBlocks;
    private UDIFBlock currentBlock;
    private UDIFBlockInputStream currentBlockStream;
    private long length;
    private long logicalFilePointer;
    private boolean seekCalled;

    private static void dbg(String s) {
        System.err.println(s);
    }

    public UDIFRandomAccessStream(RandomAccessFile raf) throws RuntimeIOException {
        this(new ReadableFileStream(raf));
    }

    public UDIFRandomAccessStream(ReadableRandomAccessStream stream) throws RuntimeIOException {
        this(new UDIFFile(stream));
    }

    public UDIFRandomAccessStream(UDIFFile dmgFile) throws RuntimeIOException {
        this.logicalFilePointer = 0L;
        this.seekCalled = false;
        this.dmgFile = dmgFile;
        Plist plist = dmgFile.getView().getPlist();
        try {
            PlistPartition[] partitions = plist.getPartitions();
            int totalBlockCount = 0;
            for (PlistPartition pp : partitions) {
                totalBlockCount += pp.getBlockCount();
            }
            this.allBlocks = new UDIFBlock[totalBlockCount];
            int pos = 0;
            for (PlistPartition pp2 : partitions) {
                UDIFBlock[] blocks = pp2.getBlocks();
                System.arraycopy(blocks, 0, this.allBlocks, pos, blocks.length);
                pos += blocks.length;
                this.length += pp2.getPartitionSize();
            }
            if (totalBlockCount > 0) {
                this.currentBlock = this.allBlocks[0];
                repositionStream();
                return;
            }
            throw new RuntimeException("Could not find any blocks in the DMG file...");
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.Stream
    public void close() throws RuntimeIOException {
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long getFilePointer() throws RuntimeIOException {
        return this.logicalFilePointer;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long length() throws RuntimeIOException {
        return this.length;
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read() throws RuntimeIOException {
        byte[] b2 = new byte[1];
        if (read(b2, 0, 1) != 1) {
            return -1;
        }
        return b2[0] & 255;
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read(byte[] b2) throws RuntimeIOException {
        return read(b2, 0, b2.length);
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read(byte[] b2, int off, int len) throws RuntimeIOException {
        try {
            if (this.seekCalled) {
                this.seekCalled = false;
                try {
                    repositionStream();
                } catch (RuntimeException e2) {
                    return -1;
                }
            }
            int bytesRead = 0;
            while (bytesRead < len) {
                int curBytesRead = this.currentBlockStream.read(b2, off + bytesRead, len - bytesRead);
                if (curBytesRead < 0) {
                    try {
                        repositionStream();
                        curBytesRead = this.currentBlockStream.read(b2, off + bytesRead, len - bytesRead);
                        if (curBytesRead < 0) {
                            throw new RuntimeException("No bytes could be read, and no exception was thrown! Program error...");
                        }
                    } catch (RuntimeException e3) {
                        if (bytesRead == 0) {
                            bytesRead = -1;
                        }
                    }
                }
                bytesRead += curBytesRead;
                this.logicalFilePointer += curBytesRead;
            }
            return bytesRead;
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public void seek(long pos) throws RuntimeIOException {
        if (this.logicalFilePointer != pos) {
            this.seekCalled = true;
            this.logicalFilePointer = pos;
        }
    }

    private void repositionStream() throws RuntimeIOException {
        try {
            if (this.currentBlock.getTrueOutOffset() > this.logicalFilePointer || this.currentBlock.getTrueOutOffset() + this.currentBlock.getOutSize() <= this.logicalFilePointer) {
                UDIFBlock soughtBlock = null;
                UDIFBlock[] arr$ = this.allBlocks;
                int len$ = arr$.length;
                int i$ = 0;
                while (true) {
                    if (i$ >= len$) {
                        break;
                    }
                    UDIFBlock dblk = arr$[i$];
                    long startPos = dblk.getTrueOutOffset();
                    long endPos = startPos + dblk.getOutSize();
                    if (startPos > this.logicalFilePointer || endPos <= this.logicalFilePointer) {
                        i$++;
                    } else {
                        soughtBlock = dblk;
                        break;
                    }
                }
                if (soughtBlock != null) {
                    this.currentBlock = soughtBlock;
                } else {
                    throw new RuntimeException("Trying to seek outside bounds.");
                }
            }
            this.currentBlockStream = UDIFBlockInputStream.getStream(this.dmgFile.getStream(), this.currentBlock);
            long bytesToSkip = this.logicalFilePointer - this.currentBlock.getTrueOutOffset();
            this.currentBlockStream.skip(bytesToSkip);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("UDIFRandomAccessStream simple test program");
        System.out.println("(Simply extracts the contents of a DMG file to a designated output file)");
        if (args.length != 2) {
            System.out.println("  ERROR: You must supply exactly two arguments: 1. the DMG, 2. the output file");
            return;
        }
        byte[] buffer = new byte[4096];
        UDIFRandomAccessStream dras = new UDIFRandomAccessStream(new UDIFFile(new ReadableFileStream(new RandomAccessFile(args[0], "r"))));
        FileOutputStream fos = new FileOutputStream(args[1]);
        long totalBytesRead = 0;
        int read = dras.read(buffer);
        while (true) {
            int bytesRead = read;
            if (bytesRead > 0) {
                totalBytesRead += bytesRead;
                fos.write(buffer, 0, bytesRead);
                read = dras.read(buffer);
            } else {
                System.out.println("Done! Extracted " + totalBytesRead + " bytes.");
                System.out.println("Length: " + dras.length() + " bytes");
                return;
            }
        }
    }
}
