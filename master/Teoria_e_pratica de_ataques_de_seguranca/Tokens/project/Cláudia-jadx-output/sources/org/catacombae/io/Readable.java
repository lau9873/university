package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/Readable.class
 */
/* loaded from: csframework.jar:org/catacombae/io/Readable.class */
public interface Readable {
    int read() throws RuntimeIOException;

    int read(byte[] bArr) throws RuntimeIOException;

    int read(byte[] bArr, int i2, int i3) throws RuntimeIOException;

    void readFully(byte[] bArr) throws RuntimeIOException;

    void readFully(byte[] bArr, int i2, int i3) throws RuntimeIOException;
}
