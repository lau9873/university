package org.catacombae.io;

import java.io.IOException;
import java.io.InputStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/InputStreamReadable.class
 */
/* loaded from: csframework.jar:org/catacombae/io/InputStreamReadable.class */
public class InputStreamReadable extends BasicReadable implements Stream {
    private final InputStream is;

    public InputStreamReadable(InputStream is) {
        this.is = is;
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read(byte[] data, int pos, int len) throws RuntimeIOException {
        try {
            return this.is.read(data, pos, len);
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }

    @Override // org.catacombae.io.Stream
    public void close() throws RuntimeIOException {
        try {
            this.is.close();
        } catch (IOException ex) {
            throw new RuntimeIOException(ex);
        }
    }
}
