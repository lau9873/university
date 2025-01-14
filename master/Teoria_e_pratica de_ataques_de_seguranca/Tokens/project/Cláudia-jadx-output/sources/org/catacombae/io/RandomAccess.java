package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/RandomAccess.class
 */
/* loaded from: csframework.jar:org/catacombae/io/RandomAccess.class */
public interface RandomAccess {
    void seek(long j) throws RuntimeIOException;

    long length() throws RuntimeIOException;

    long getFilePointer() throws RuntimeIOException;
}
