package org.catacombae.io;

import org.catacombae.io.ReadableConcatenatedStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/ConcatenatedStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/ConcatenatedStream.class */
public class ConcatenatedStream extends BasicRandomAccessStream {
    private ReadableConcatenatedStream backingFile;

    public ConcatenatedStream(RandomAccessStream firstPart, long startOffset, long length) {
        this.backingFile = new ReadableConcatenatedStream(firstPart, startOffset, length);
    }

    public void addPart(RandomAccessStream newFile, long off, long len) {
        ReadableConcatenatedStream.Part newPart = new ReadableConcatenatedStream.Part(newFile, off, len);
        this.backingFile.parts.add(newPart);
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public void seek(long pos) {
        this.backingFile.seek(pos);
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read() {
        return this.backingFile.read();
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read(byte[] data) {
        return this.backingFile.read(data);
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read(byte[] data, int pos, int len) {
        return this.backingFile.read(data, pos, len);
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public void readFully(byte[] data) {
        this.backingFile.readFully(data);
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public void readFully(byte[] data, int offset, int length) {
        this.backingFile.readFully(data, offset, length);
    }

    @Override // org.catacombae.io.BasicRandomAccessStream, org.catacombae.io.Writable
    public void write(byte[] data, int off, int len) {
        int bytesWritten = 0;
        RandomAccessStream currentWritableFile = (RandomAccessStream) this.backingFile.currentPart.file;
        while (true) {
            long bytesLeftInFile = this.backingFile.currentPart.length - (currentWritableFile.getFilePointer() - this.backingFile.currentPart.startOffset);
            int bytesLeftToWrite = len - bytesWritten;
            int bytesToWrite = (int) (bytesLeftInFile < ((long) bytesLeftToWrite) ? bytesLeftInFile : bytesLeftToWrite);
            currentWritableFile.write(data, off + bytesWritten, bytesToWrite);
            bytesWritten += bytesToWrite;
            if (bytesWritten >= len) {
                break;
            }
            this.backingFile.currentPartIndex++;
            this.backingFile.currentPart = this.backingFile.parts.get(this.backingFile.currentPartIndex);
            currentWritableFile = (RandomAccessStream) this.backingFile.currentPart.file;
            currentWritableFile.seek(this.backingFile.currentPart.startOffset);
        }
        if (bytesWritten == len) {
            return;
        }
        throw new RuntimeException("Wrote more than I was supposed to! This can't happen.");
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long length() {
        return this.backingFile.length();
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long getFilePointer() {
        return this.backingFile.getFilePointer();
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.Stream
    public void close() {
        this.backingFile.close();
    }
}
