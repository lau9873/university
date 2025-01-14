package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/TruncatableRandomAccess.class
 */
/* loaded from: csframework.jar:org/catacombae/io/TruncatableRandomAccess.class */
public interface TruncatableRandomAccess extends RandomAccess {
    void setLength(long j) throws RuntimeIOException;
}
