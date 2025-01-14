package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/BasicReadableRandomAccessStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/BasicReadableRandomAccessStream.class */
public abstract class BasicReadableRandomAccessStream extends BasicReadable implements ReadableRandomAccessStream {
    public abstract void close() throws RuntimeIOException;

    public abstract void seek(long j) throws RuntimeIOException;

    public abstract long length() throws RuntimeIOException;

    public abstract long getFilePointer() throws RuntimeIOException;
}
