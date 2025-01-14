package org.catacombae.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/ReadableFileStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/ReadableFileStream.class */
public class ReadableFileStream implements ReadableRandomAccessStream {
    protected final RandomAccessFile raf;

    public ReadableFileStream(String filename) {
        this(new File(filename));
    }

    public ReadableFileStream(File file) {
        this(file, "r");
    }

    public ReadableFileStream(RandomAccessFile iRaf) {
        if (iRaf == null) {
            throw new IllegalArgumentException("iRaf may NOT be null");
        }
        this.raf = iRaf;
    }

    protected ReadableFileStream(String filename, String mode) {
        this(new File(filename), mode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReadableFileStream(File file, String mode) {
        try {
            this.raf = new RandomAccessFile(file, mode);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.RandomAccess
    public void seek(long pos) {
        try {
            this.raf.seek(pos);
        } catch (IOException ioe) {
            throw new RuntimeIOException("pos=" + pos + "," + ioe.toString(), ioe);
        }
    }

    @Override // org.catacombae.io.Readable
    public int read() {
        try {
            return this.raf.read();
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Readable
    public int read(byte[] data) {
        try {
            return this.raf.read(data);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Readable
    public int read(byte[] data, int pos, int len) {
        try {
            return this.raf.read(data, pos, len);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data) {
        try {
            this.raf.readFully(data);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data, int offset, int length) {
        try {
            this.raf.readFully(data, offset, length);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.RandomAccess
    public long length() {
        try {
            return this.raf.length();
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.RandomAccess
    public long getFilePointer() {
        try {
            return this.raf.getFilePointer();
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Stream
    public void close() {
        try {
            this.raf.close();
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }
}
