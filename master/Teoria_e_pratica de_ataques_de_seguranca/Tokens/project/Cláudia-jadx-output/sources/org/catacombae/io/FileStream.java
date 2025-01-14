package org.catacombae.io;

import java.io.File;
import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/FileStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/FileStream.class */
public class FileStream extends ReadableFileStream implements TruncatableRandomAccessStream {
    public FileStream(String filename) {
        super(new File(filename), "rw");
    }

    public FileStream(File file) {
        super(file, "rw");
    }

    @Override // org.catacombae.io.Writable
    public void write(byte[] b2) {
        try {
            this.raf.write(b2);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Writable
    public void write(byte[] b2, int off, int len) {
        try {
            this.raf.write(b2, off, len);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Writable
    public void write(int b2) {
        try {
            this.raf.write(b2);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.TruncatableRandomAccess
    public void setLength(long newLength) throws RuntimeIOException {
        try {
            this.raf.setLength(newLength);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }
}
