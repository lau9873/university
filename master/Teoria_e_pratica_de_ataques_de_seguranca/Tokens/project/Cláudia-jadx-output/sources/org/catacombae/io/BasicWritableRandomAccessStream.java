package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/BasicWritableRandomAccessStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/BasicWritableRandomAccessStream.class */
public abstract class BasicWritableRandomAccessStream extends BasicWritable implements WritableRandomAccessStream {
    @Override // org.catacombae.io.Stream
    public abstract void close() throws RuntimeIOException;

    @Override // org.catacombae.io.RandomAccess
    public abstract void seek(long j) throws RuntimeIOException;

    @Override // org.catacombae.io.RandomAccess
    public abstract long length() throws RuntimeIOException;

    @Override // org.catacombae.io.RandomAccess
    public abstract long getFilePointer() throws RuntimeIOException;

    protected BasicWritableRandomAccessStream() {
    }
}
