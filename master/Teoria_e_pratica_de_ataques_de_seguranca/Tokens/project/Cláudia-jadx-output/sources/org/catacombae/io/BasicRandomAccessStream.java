package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/BasicRandomAccessStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/BasicRandomAccessStream.class */
public abstract class BasicRandomAccessStream extends BasicReadableRandomAccessStream implements RandomAccessStream {
    @Override // org.catacombae.io.Writable
    public abstract void write(byte[] bArr, int i2, int i3);

    @Override // org.catacombae.io.Writable
    public void write(byte[] b2) {
        BasicWritableRandomAccessStream.defaultWrite(this, b2);
    }

    @Override // org.catacombae.io.Writable
    public void write(int b2) {
        BasicWritableRandomAccessStream.defaultWrite(this, b2);
    }
}
