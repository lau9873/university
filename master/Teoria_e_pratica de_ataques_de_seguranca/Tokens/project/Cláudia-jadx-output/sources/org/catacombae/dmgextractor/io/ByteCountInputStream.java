package org.catacombae.dmgextractor.io;

import java.io.IOException;
import java.io.InputStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/io/ByteCountInputStream.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/io/ByteCountInputStream.class */
public class ByteCountInputStream extends InputStream {
    private long bytePos = 0;
    private InputStream is;

    public ByteCountInputStream(InputStream is) {
        this.is = is;
    }

    public long getBytesRead() {
        return this.bytePos;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.is.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.is.close();
    }

    @Override // java.io.InputStream
    public void mark(int readLimit) {
        throw new RuntimeException("Mark/reset not supported");
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int res = this.is.read();
        if (res > 0) {
            this.bytePos++;
        }
        return res;
    }

    @Override // java.io.InputStream
    public int read(byte[] b2) throws IOException {
        int res = this.is.read(b2);
        if (res > 0) {
            this.bytePos += res;
        }
        return res;
    }

    @Override // java.io.InputStream
    public int read(byte[] b2, int off, int len) throws IOException {
        int res = this.is.read(b2, off, len);
        if (res > 0) {
            this.bytePos += res;
        }
        return res;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        throw new RuntimeException("Mark/reset not supported");
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        System.out.println("skip(" + n + ");");
        long res = this.is.skip(n);
        if (res > 0) {
            this.bytePos += res;
        }
        return res;
    }
}
