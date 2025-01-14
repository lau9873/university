package org.catacombae.hfsexplorer.io;

import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/SynchronizedReadableRandomAccessStream.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/SynchronizedReadableRandomAccessStream.class */
public class SynchronizedReadableRandomAccessStream extends BasicSynchronizedReadableRandomAccessStream implements SynchronizedReadableRandomAccess {
    private ReadableRandomAccessStream ras;
    private long refCount;
    private boolean closed = false;

    public SynchronizedReadableRandomAccessStream(ReadableRandomAccessStream sourceStream) {
        this.ras = sourceStream;
    }

    public ReadableRandomAccessStream getSourceStream() {
        return this.ras;
    }

    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadable
    public synchronized int readFrom(long pos, byte[] b2, int off, int len) throws RuntimeIOException {
        long oldFP = getFilePointer();
        if (oldFP != pos) {
            seek(pos);
        }
        int res = read(b2, off, len);
        if (oldFP != pos) {
            seek(oldFP);
        }
        return res;
    }

    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadable
    public synchronized long skipFrom(long pos, long length) throws RuntimeIOException {
        long res;
        long streamLength = length();
        long newPos = pos + length;
        if (newPos > streamLength) {
            res = streamLength - pos;
        } else {
            res = length;
        }
        return res;
    }

    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadable
    public synchronized long remainingLength() throws RuntimeIOException {
        return length() - getFilePointer();
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.Stream
    public synchronized void close() throws RuntimeIOException {
        if (this.refCount == 0) {
            this.ras.close();
            this.closed = true;
            return;
        }
        throw new RuntimeIOException(this.refCount + " instances are still using this stream!");
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

    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccess
    public synchronized void addReference(Object referrer) {
        if (!this.closed) {
            this.refCount++;
            return;
        }
        throw new RuntimeIOException("Stream is closed!");
    }

    @Override // org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccess
    public synchronized void removeReference(Object referrer) {
        this.refCount--;
    }
}
