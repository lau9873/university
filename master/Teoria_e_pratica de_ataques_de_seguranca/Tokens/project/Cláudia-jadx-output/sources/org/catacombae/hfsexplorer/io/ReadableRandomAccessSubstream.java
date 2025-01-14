package org.catacombae.hfsexplorer.io;

import org.catacombae.io.BasicReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/ReadableRandomAccessSubstream.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/ReadableRandomAccessSubstream.class */
public class ReadableRandomAccessSubstream extends BasicReadableRandomAccessStream {
    private SynchronizedReadableRandomAccess sourceStream;
    private long internalFP = 0;

    public ReadableRandomAccessSubstream(SynchronizedReadableRandomAccess iSourceStream) {
        this.sourceStream = iSourceStream;
        this.sourceStream.addReference(this);
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.Stream
    public void close() throws RuntimeIOException {
        this.sourceStream.removeReference(this);
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public void seek(long pos) throws RuntimeIOException {
        this.internalFP = pos;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long length() throws RuntimeIOException {
        return this.sourceStream.length();
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long getFilePointer() throws RuntimeIOException {
        return this.internalFP;
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read(byte[] b2, int pos, int len) throws RuntimeIOException {
        int bytesRead = this.sourceStream.readFrom(this.internalFP, b2, pos, len);
        if (bytesRead > 0) {
            this.internalFP += bytesRead;
            return bytesRead;
        }
        return -1;
    }
}
