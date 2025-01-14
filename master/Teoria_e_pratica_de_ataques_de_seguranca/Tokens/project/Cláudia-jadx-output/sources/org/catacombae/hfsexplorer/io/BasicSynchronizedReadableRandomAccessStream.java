package org.catacombae.hfsexplorer.io;

import org.catacombae.io.BasicReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/BasicSynchronizedReadableRandomAccessStream.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/BasicSynchronizedReadableRandomAccessStream.class */
public abstract class BasicSynchronizedReadableRandomAccessStream extends BasicReadableRandomAccessStream implements SynchronizedReadableRandomAccess {
    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadable
    public int readFrom(long pos) throws RuntimeIOException {
        byte[] res = new byte[1];
        if (readFrom(pos, res, 0, 1) == 1) {
            return res[0] & 255;
        }
        return -1;
    }

    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadable
    public int readFrom(long pos, byte[] b2) throws RuntimeIOException {
        return readFrom(pos, b2, 0, b2.length);
    }

    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadable
    public void readFullyFrom(long pos, byte[] data) throws RuntimeIOException {
        readFullyFrom(pos, data, 0, data.length);
    }

    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadable
    public void readFullyFrom(long pos, byte[] data, int offset, int length) throws RuntimeIOException {
        if (length < 0) {
            throw new IllegalArgumentException("length is negative: " + length);
        }
        int i2 = 0;
        while (true) {
            int bytesRead = i2;
            if (bytesRead < length) {
                int curBytesRead = readFrom(pos + bytesRead, data, offset + bytesRead, length - bytesRead);
                if (curBytesRead <= 0) {
                    throw new RuntimeIOException("Couldn't read the entire length.");
                }
                i2 = bytesRead + curBytesRead;
            } else {
                return;
            }
        }
    }
}
