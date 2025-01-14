package org.catacombae.io;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/BasicReadable.class
 */
/* loaded from: csframework.jar:org/catacombae/io/BasicReadable.class */
public abstract class BasicReadable implements Readable {
    @Override // org.catacombae.io.Readable
    public abstract int read(byte[] bArr, int i2, int i3) throws RuntimeIOException;

    @Override // org.catacombae.io.Readable
    public int read() throws RuntimeIOException {
        byte[] res = new byte[1];
        if (read(res, 0, 1) == 1) {
            return res[0] & 255;
        }
        return -1;
    }

    @Override // org.catacombae.io.Readable
    public int read(byte[] data) throws RuntimeIOException {
        return read(data, 0, data.length);
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data) throws RuntimeIOException {
        readFully(data, 0, data.length);
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data, int offset, int length) throws RuntimeIOException {
        if (length < 0) {
            throw new IllegalArgumentException("length is negative: " + length);
        }
        int i2 = 0;
        while (true) {
            int bytesRead = i2;
            if (bytesRead < length) {
                int curBytesRead = read(data, offset + bytesRead, length - bytesRead);
                if (curBytesRead > 0) {
                    i2 = bytesRead + curBytesRead;
                } else {
                    throw new RuntimeIOException("Couldn't read the entire length.");
                }
            } else {
                return;
            }
        }
    }
}
