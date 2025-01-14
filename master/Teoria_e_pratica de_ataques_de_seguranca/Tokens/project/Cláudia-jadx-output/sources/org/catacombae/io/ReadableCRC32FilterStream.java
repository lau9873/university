package org.catacombae.io;

import java.util.zip.CRC32;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/ReadableCRC32FilterStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/ReadableCRC32FilterStream.class */
public class ReadableCRC32FilterStream implements ReadableRandomAccessStream {
    private ReadableRandomAccessStream source;
    private CRC32 checksum = new CRC32();

    public ReadableCRC32FilterStream(ReadableRandomAccessStream source) {
        this.source = source;
    }

    public int getChecksumValue() {
        return (int) (this.checksum.getValue() & (-1));
    }

    public void resetChecksum() {
        this.checksum.reset();
    }

    @Override // org.catacombae.io.RandomAccess
    public void seek(long pos) {
        this.source.seek(pos);
    }

    @Override // org.catacombae.io.Readable
    public int read() {
        int res = this.source.read();
        if (res > 0) {
            this.checksum.update(res);
        }
        return res;
    }

    @Override // org.catacombae.io.Readable
    public int read(byte[] data) {
        int res = this.source.read(data);
        if (res > 0) {
            this.checksum.update(data, 0, res);
        }
        return res;
    }

    @Override // org.catacombae.io.Readable
    public int read(byte[] data, int pos, int len) {
        int res = this.source.read(data);
        if (res > 0) {
            this.checksum.update(data, pos, res);
        }
        return res;
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data) {
        this.source.readFully(data);
        this.checksum.update(data);
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data, int offset, int length) {
        this.source.readFully(data, offset, length);
        this.checksum.update(data, offset, length);
    }

    @Override // org.catacombae.io.RandomAccess
    public long length() {
        return this.source.length();
    }

    @Override // org.catacombae.io.RandomAccess
    public long getFilePointer() {
        return this.source.getFilePointer();
    }

    @Override // org.catacombae.io.Stream
    public void close() {
        this.source.close();
    }
}
