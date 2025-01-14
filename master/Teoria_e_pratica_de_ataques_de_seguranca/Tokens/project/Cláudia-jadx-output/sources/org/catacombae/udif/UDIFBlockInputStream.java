package org.catacombae.udif;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.tools.bzip2.CBZip2InputStream;
import org.catacombae.dmgextractor.DmgException;
import org.catacombae.dmgextractor.Util;
import org.catacombae.dmgextractor.io.RandomAccessInputStream;
import org.catacombae.dmgextractor.io.SynchronizedRandomAccessStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream.class */
public abstract class UDIFBlockInputStream extends InputStream {
    protected ReadableRandomAccessStream raf;
    protected UDIFBlock block;
    protected final int addInOffset;
    private long globalBytesRead;
    protected final byte[] buffer = new byte[16384];
    protected int bufferPos = 0;
    protected int bufferDataLength = 0;
    private final byte[] skipBuffer = new byte[4096];
    protected int fillSize;

    protected abstract void fillBuffer() throws IOException;

    protected UDIFBlockInputStream(ReadableRandomAccessStream raf, UDIFBlock block, int addInOffset) {
        this.raf = raf;
        this.block = block;
        this.addInOffset = addInOffset;
    }

    public static UDIFBlockInputStream getStream(ReadableRandomAccessStream raf, UDIFBlock block) throws IOException, RuntimeIOException {
        switch (block.getBlockType()) {
            case -2147483644:
            default:
                throw new RuntimeException("No handler for block type " + block.getBlockTypeAsString());
            case -2147483643:
                return new ZlibBlockInputStream(raf, block, 0);
            case -2147483642:
                return new Bzip2BlockInputStream(raf, block, 0);
            case -1:
            case 2147483646:
                throw new RuntimeException("Block type is a marker and contains no data.");
            case 0:
            case 2:
                return new ZeroBlockInputStream(raf, block, 0);
            case 1:
                return new CopyBlockInputStream(raf, block, 0);
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long available = this.block.getOutSize() - this.globalBytesRead;
        if (available > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) available;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] b2 = new byte[1];
        return read(b2, 0, 1);
    }

    @Override // java.io.InputStream
    public int read(byte[] b2) throws IOException {
        return read(b2, 0, b2.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b2, int off, int len) throws IOException {
        int bytesRead = 0;
        int outPos = off;
        while (true) {
            if (bytesRead >= len) {
                break;
            }
            int bytesRemainingInBuffer = this.bufferDataLength - this.bufferPos;
            if (bytesRemainingInBuffer == 0) {
                fillBuffer();
                bytesRemainingInBuffer = this.bufferDataLength - this.bufferPos;
                if (bytesRemainingInBuffer == 0) {
                    if (bytesRead == 0) {
                        return -1;
                    }
                }
            }
            int bytesToReadFromBuffer = len - bytesRead < bytesRemainingInBuffer ? len - bytesRead : bytesRemainingInBuffer;
            System.arraycopy(this.buffer, this.bufferPos, b2, outPos, bytesToReadFromBuffer);
            outPos += bytesToReadFromBuffer;
            this.bufferPos += bytesToReadFromBuffer;
            bytesRead += bytesToReadFromBuffer;
        }
        this.globalBytesRead += bytesRead;
        return bytesRead;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        long bytesSkipped;
        long j = 0;
        while (true) {
            bytesSkipped = j;
            if (bytesSkipped < n) {
                int curSkip = n - bytesSkipped < ((long) this.skipBuffer.length) ? (int) (n - bytesSkipped) : this.skipBuffer.length;
                int res = read(this.skipBuffer, 0, curSkip);
                if (res <= 0) {
                    break;
                }
                j = bytesSkipped + res;
            } else {
                break;
            }
        }
        return bytesSkipped;
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream$ZlibBlockInputStream.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream$ZlibBlockInputStream.class */
    public static class ZlibBlockInputStream extends UDIFBlockInputStream {
        private final Inflater inflater;
        private final byte[] inBuffer;
        private long inPos;

        public ZlibBlockInputStream(ReadableRandomAccessStream raf, UDIFBlock block, int addInOffset) throws IOException {
            super(raf, block, addInOffset);
            this.inflater = new Inflater();
            this.inBuffer = new byte[4096];
            this.inPos = 0L;
            feedInflater();
        }

        private void feedInflater() throws IOException {
            long seekPos = this.addInOffset + this.inPos + this.block.getTrueInOffset();
            this.raf.seek(seekPos);
            long bytesLeftToRead = this.block.getInSize() - this.inPos;
            int bytesToFeed = ((long) this.inBuffer.length) < bytesLeftToRead ? this.inBuffer.length : (int) bytesLeftToRead;
            int curBytesRead = this.raf.read(this.inBuffer, 0, bytesToFeed);
            this.inPos += curBytesRead;
            this.inflater.setInput(this.inBuffer, 0, curBytesRead);
        }

        @Override // org.catacombae.udif.UDIFBlockInputStream
        protected void fillBuffer() throws RuntimeIOException, IOException {
            if (this.inflater.finished()) {
                this.bufferPos = 0;
                this.bufferDataLength = 0;
            }
            int bytesInflated = 0;
            while (bytesInflated < this.buffer.length && !this.inflater.finished()) {
                try {
                    if (this.inflater.needsInput()) {
                        feedInflater();
                    }
                    int res = this.inflater.inflate(this.buffer, bytesInflated, this.buffer.length - bytesInflated);
                    if (res >= 0) {
                        bytesInflated += res;
                    } else {
                        throw new DmgException("Negative return value when inflating");
                    }
                } catch (DataFormatException e2) {
                    DmgException re = new DmgException("Invalid zlib data!");
                    re.initCause(e2);
                    throw re;
                }
            }
            this.bufferPos = 0;
            this.bufferDataLength = bytesInflated;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream$CopyBlockInputStream.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream$CopyBlockInputStream.class */
    public static class CopyBlockInputStream extends UDIFBlockInputStream {
        private long inPos;

        public CopyBlockInputStream(ReadableRandomAccessStream raf, UDIFBlock block, int addInOffset) throws RuntimeIOException {
            super(raf, block, addInOffset);
            this.inPos = 0L;
        }

        @Override // org.catacombae.udif.UDIFBlockInputStream
        protected void fillBuffer() throws IOException {
            int bytesRead;
            this.raf.seek(this.addInOffset + this.inPos + this.block.getTrueInOffset());
            int bytesToRead = (int) Math.min(this.block.getInSize() - this.inPos, this.buffer.length);
            int totalBytesRead = 0;
            while (totalBytesRead < bytesToRead && (bytesRead = this.raf.read(this.buffer, totalBytesRead, bytesToRead - totalBytesRead)) >= 0) {
                totalBytesRead += bytesRead;
                this.inPos += bytesRead;
            }
            this.bufferPos = 0;
            this.bufferDataLength = totalBytesRead;
        }

        @Override // org.catacombae.udif.UDIFBlockInputStream, java.io.InputStream
        public long skip(long n) throws IOException {
            int bytesToSkip = (int) Math.min(this.block.getInSize() - this.inPos, n);
            this.inPos += bytesToSkip;
            this.bufferPos = 0;
            this.bufferDataLength = 0;
            return bytesToSkip;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream$ZeroBlockInputStream.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream$ZeroBlockInputStream.class */
    public static class ZeroBlockInputStream extends UDIFBlockInputStream {
        private long outPos;

        public ZeroBlockInputStream(ReadableRandomAccessStream raf, UDIFBlock block, int addInOffset) throws RuntimeIOException {
            super(raf, block, addInOffset);
            this.outPos = 0L;
        }

        @Override // org.catacombae.udif.UDIFBlockInputStream
        protected void fillBuffer() throws IOException {
            int bytesToWrite = (int) Math.min(this.block.getOutSize() - this.outPos, this.buffer.length);
            Util.zero(this.buffer, 0, bytesToWrite);
            this.outPos += bytesToWrite;
            this.bufferPos = 0;
            this.bufferDataLength = bytesToWrite;
        }

        @Override // org.catacombae.udif.UDIFBlockInputStream, java.io.InputStream
        public long skip(long n) throws IOException {
            int bytesToSkip = (int) Math.min(this.block.getOutSize() - this.outPos, n);
            this.outPos += bytesToSkip;
            this.bufferPos = 0;
            this.bufferDataLength = 0;
            return bytesToSkip;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream$Bzip2BlockInputStream.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFBlockInputStream$Bzip2BlockInputStream.class */
    public static class Bzip2BlockInputStream extends UDIFBlockInputStream {
        private final byte[] BZIP2_SIGNATURE;
        private InputStream bzip2DataStream;
        private CBZip2InputStream decompressingStream;
        private long outPos;

        public Bzip2BlockInputStream(ReadableRandomAccessStream raf, UDIFBlock block, int addInOffset) throws IOException, RuntimeIOException {
            super(raf, block, addInOffset);
            this.BZIP2_SIGNATURE = new byte[]{66, 90};
            this.outPos = 0L;
            this.bzip2DataStream = new RandomAccessInputStream(new SynchronizedRandomAccessStream(raf), block.getTrueInOffset(), block.getInSize());
            byte[] signature = new byte[2];
            if (this.bzip2DataStream.read(signature) != signature.length) {
                throw new RuntimeException("Read error!");
            }
            if (!Util.arraysEqual(signature, this.BZIP2_SIGNATURE)) {
                throw new RuntimeException("Invalid bzip2 block!");
            }
            this.decompressingStream = new CBZip2InputStream(new BufferedInputStream(this.bzip2DataStream));
        }

        @Override // org.catacombae.udif.UDIFBlockInputStream
        protected void fillBuffer() throws IOException {
            int bytesRead;
            int bytesToRead = (int) Math.min(this.block.getOutSize() - this.outPos, this.buffer.length);
            int totalBytesRead = 0;
            while (totalBytesRead < bytesToRead && (bytesRead = this.decompressingStream.read(this.buffer, totalBytesRead, bytesToRead - totalBytesRead)) >= 0) {
                totalBytesRead += bytesRead;
                this.outPos += bytesRead;
            }
            this.bufferPos = 0;
            this.bufferDataLength = totalBytesRead;
        }

        @Override // org.catacombae.udif.UDIFBlockInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.decompressingStream.close();
            this.bzip2DataStream.close();
        }
    }
}
