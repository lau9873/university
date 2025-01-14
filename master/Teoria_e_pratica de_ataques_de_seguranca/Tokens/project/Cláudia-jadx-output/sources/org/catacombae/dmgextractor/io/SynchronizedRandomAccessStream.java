package org.catacombae.dmgextractor.io;

import org.catacombae.io.BasicReadableRandomAccessStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/io/SynchronizedRandomAccessStream.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/io/SynchronizedRandomAccessStream.class */
public class SynchronizedRandomAccessStream extends BasicReadableRandomAccessStream {
    private ReadableRandomAccessStream ras;

    public SynchronizedRandomAccessStream(ReadableRandomAccessStream ras) {
        this.ras = ras;
    }

    public synchronized int readFrom(long pos, byte[] b2, int off, int len) throws RuntimeIOException {
        if (getFilePointer() != pos) {
            seek(pos);
        }
        return read(b2, off, len);
    }

    public synchronized long skipFrom(long pos, long length) throws RuntimeIOException {
        long streamLength = length();
        long newPos = pos + length;
        if (newPos > streamLength) {
            seek(streamLength);
            return streamLength - pos;
        }
        seek(newPos);
        return length;
    }

    public synchronized long remainingLength() throws RuntimeIOException {
        return length() - getFilePointer();
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.Stream
    public synchronized void close() throws RuntimeIOException {
        this.ras.close();
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public synchronized long getFilePointer() throws RuntimeIOException {
        return this.ras.getFilePointer();
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public synchronized long length() throws RuntimeIOException {
        return this.ras.length();
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public synchronized int read() throws RuntimeIOException {
        return this.ras.read();
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public synchronized int read(byte[] b2) throws RuntimeIOException {
        return this.ras.read(b2);
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public synchronized int read(byte[] b2, int off, int len) throws RuntimeIOException {
        return this.ras.read(b2, off, len);
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public synchronized void seek(long pos) throws RuntimeIOException {
        this.ras.seek(pos);
    }
}
