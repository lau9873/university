package org.catacombae.io;

import java.io.IOException;
import java.io.OutputStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/OutputStreamWritable.class
 */
/* loaded from: csframework.jar:org/catacombae/io/OutputStreamWritable.class */
public class OutputStreamWritable extends BasicWritable implements Stream {
    private final OutputStream os;

    public OutputStreamWritable(OutputStream os) {
        this.os = os;
    }

    @Override // org.catacombae.io.BasicWritable, org.catacombae.io.Writable
    public void write(byte[] b2, int off, int len) throws RuntimeIOException {
        try {
            this.os.write(b2, off, len);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Stream
    public void close() throws RuntimeIOException {
        try {
            this.os.close();
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }
}
