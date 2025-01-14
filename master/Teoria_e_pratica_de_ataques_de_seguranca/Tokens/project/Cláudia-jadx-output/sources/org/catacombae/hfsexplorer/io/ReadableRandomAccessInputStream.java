package org.catacombae.hfsexplorer.io;

import java.io.IOException;
import java.io.InputStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/ReadableRandomAccessInputStream.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/ReadableRandomAccessInputStream.class */
public class ReadableRandomAccessInputStream extends InputStream {
    private final SynchronizedReadableRandomAccessStream ras;
    private long streamPos;
    private final long endPos;

    public ReadableRandomAccessInputStream(SynchronizedReadableRandomAccessStream ras, long offset, long length) {
        try {
            long rasLength = ras.length();
            length = length == -1 ? rasLength : length;
            if (offset > rasLength || offset < 0) {
                throw new IllegalArgumentException("offset out of bounds (offset=" + offset + " length=" + length + ")");
            }
            if (length > rasLength - offset || length < 0) {
                throw new IllegalArgumentException("length out of bounds (offset=" + offset + " length=" + length + ")");
            }
            this.ras = ras;
            this.streamPos = offset;
            this.endPos = offset + length;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public ReadableRandomAccessInputStream(SynchronizedReadableRandomAccessStream ras) {
        this(ras, 0L, -1L);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long remaining = this.endPos - this.streamPos;
        if (remaining > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (remaining < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) remaining;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] tmp = new byte[1];
        int res = read(tmp, 0, 1);
        if (res == 1) {
            return tmp[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b2) throws IOException {
        return read(b2, 0, b2.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b2, int off, int len) throws IOException {
        try {
            int bytesToRead = (int) (this.streamPos + ((long) len) > this.endPos ? this.endPos - this.streamPos : len);
            if (bytesToRead == 0) {
                return -1;
            }
            int res = this.ras.readFrom(this.streamPos, b2, off, bytesToRead);
            if (res > 0) {
                this.streamPos += res;
            }
            return res;
        } catch (RuntimeIOException ex) {
            IOException ioe = ex.getIOCause();
            if (ioe != null) {
                ex.printStackTrace();
                throw ioe;
            }
            throw ex;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        try {
            long res = this.ras.skipFrom(this.streamPos, n);
            if (res > 0) {
                this.streamPos += res;
            }
            return res;
        } catch (RuntimeIOException ex) {
            IOException ioe = ex.getIOCause();
            if (ioe != null) {
                ex.printStackTrace();
                throw ioe;
            }
            throw ex;
        }
    }
}
