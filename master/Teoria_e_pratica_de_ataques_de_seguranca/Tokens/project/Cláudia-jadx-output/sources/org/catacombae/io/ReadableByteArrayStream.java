package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/ReadableByteArrayStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/ReadableByteArrayStream.class */
public class ReadableByteArrayStream extends BasicReadableRandomAccessStream {
    private final byte[] backingArray;
    private final int startOffset;
    private final int length;
    private int filePointer;
    private boolean closed;

    public ReadableByteArrayStream(byte[] array) {
        this(array, 0, array.length);
    }

    public ReadableByteArrayStream(byte[] array, int off, int len) {
        this.closed = false;
        if (off >= array.length || off < 0) {
            throw new IllegalArgumentException("parameter off out of bounds (off=" + off + ")");
        }
        if (off + len > array.length || len < 0) {
            throw new IllegalArgumentException("parameter len out of bounds (len=" + len + ")");
        }
        this.backingArray = array;
        this.startOffset = off;
        this.length = len;
        this.filePointer = 0;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public void seek(long pos) {
        if (this.closed) {
            throw new RuntimeException("File has been closed!");
        }
        if (pos >= this.length || pos < 0) {
            throw new IllegalArgumentException("parameter pos out of bounds");
        }
        this.filePointer = (int) pos;
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read(byte[] data, int pos, int len) {
        if (this.closed) {
            throw new RuntimeException("File has been closed!");
        }
        int remainingBytes = this.length - this.filePointer;
        if (remainingBytes == 0) {
            return -1;
        }
        int trueLen = Math.min(remainingBytes, len);
        System.arraycopy(this.backingArray, this.startOffset + this.filePointer, data, pos, trueLen);
        this.filePointer += trueLen;
        return trueLen;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long length() {
        if (this.closed) {
            throw new RuntimeException("File has been closed!");
        }
        return this.length;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long getFilePointer() {
        if (this.closed) {
            throw new RuntimeException("File has been closed!");
        }
        return this.filePointer;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.Stream
    public void close() {
        if (this.closed) {
            throw new RuntimeException("File has been closed!");
        }
        this.closed = true;
    }
}
