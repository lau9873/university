package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/ReadableFilterStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/ReadableFilterStream.class */
public class ReadableFilterStream implements ReadableRandomAccessStream {
    protected ReadableRandomAccessStream backingStore;

    public ReadableFilterStream(ReadableRandomAccessStream backing) {
        this.backingStore = backing;
    }

    public void seek(long pos) {
        this.backingStore.seek(pos);
    }

    public int read() {
        return this.backingStore.read();
    }

    public int read(byte[] data) {
        return this.backingStore.read(data);
    }

    public int read(byte[] data, int pos, int len) {
        return this.backingStore.read(data, pos, len);
    }

    public void readFully(byte[] data) {
        this.backingStore.readFully(data);
    }

    public void readFully(byte[] data, int offset, int length) {
        this.backingStore.readFully(data, offset, length);
    }

    public long length() {
        return this.backingStore.length();
    }

    public long getFilePointer() {
        return this.backingStore.getFilePointer();
    }

    @Override // org.catacombae.io.Stream
    public void close() {
        this.backingStore.close();
    }
}
