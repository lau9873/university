package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/BasicWritable.class
 */
/* loaded from: csframework.jar:org/catacombae/io/BasicWritable.class */
public abstract class BasicWritable implements Writable {
    @Override // org.catacombae.io.Writable
    public abstract void write(byte[] bArr, int i2, int i3) throws RuntimeIOException;

    @Override // org.catacombae.io.Writable
    public void write(byte[] b2) throws RuntimeIOException {
        defaultWrite(this, b2);
    }

    @Override // org.catacombae.io.Writable
    public void write(int b2) throws RuntimeIOException {
        defaultWrite(this, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void defaultWrite(Writable w, byte[] b2) throws RuntimeIOException {
        w.write(b2, 0, b2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void defaultWrite(Writable w, int b2) throws RuntimeIOException {
        w.write(new byte[]{(byte) (b2 & 255)}, 0, 1);
    }
}
