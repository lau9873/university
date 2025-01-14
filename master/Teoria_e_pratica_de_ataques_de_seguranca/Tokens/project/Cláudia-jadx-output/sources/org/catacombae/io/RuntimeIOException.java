package org.catacombae.io;

import java.io.IOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/RuntimeIOException.class
 */
/* loaded from: csframework.jar:org/catacombae/io/RuntimeIOException.class */
public class RuntimeIOException extends RuntimeException {
    private final IOException ioCause;

    public RuntimeIOException(String s) {
        super(s);
        this.ioCause = null;
    }

    public RuntimeIOException(IOException iIoCause) {
        super(iIoCause);
        if (iIoCause == null) {
            throw new IllegalArgumentException("RuntimeIOExceptions can not be thrown without an underlying IOException");
        }
        this.ioCause = iIoCause;
    }

    public RuntimeIOException(String message, IOException iIoCause) {
        super(message, iIoCause);
        if (iIoCause == null) {
            throw new IllegalArgumentException("RuntimeIOExceptions can not be thrown without an underlying IOException");
        }
        this.ioCause = iIoCause;
    }

    public IOException getIOCause() {
        return this.ioCause;
    }
}
