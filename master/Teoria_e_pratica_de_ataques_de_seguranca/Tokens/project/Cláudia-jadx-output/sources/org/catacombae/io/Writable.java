package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/Writable.class
 */
/* loaded from: csframework.jar:org/catacombae/io/Writable.class */
public interface Writable {
    void write(byte[] bArr) throws RuntimeIOException;

    void write(byte[] bArr, int i2, int i3) throws RuntimeIOException;

    void write(int i2) throws RuntimeIOException;
}
