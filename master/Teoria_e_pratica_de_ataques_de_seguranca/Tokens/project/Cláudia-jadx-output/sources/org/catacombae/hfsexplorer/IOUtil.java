package org.catacombae.hfsexplorer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.catacombae.io.InputStreamReadable;
import org.catacombae.io.OutputStreamWritable;
import org.catacombae.io.Readable;
import org.catacombae.io.RuntimeIOException;
import org.catacombae.io.Writable;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/IOUtil.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/IOUtil.class */
public class IOUtil extends org.catacombae.util.IOUtil {
    public static long streamCopy(InputStream is, OutputStream os, int bufferSize) throws IOException {
        try {
            return streamCopy(new InputStreamReadable(is), new OutputStreamWritable(os), bufferSize);
        } catch (RuntimeIOException e2) {
            IOException cause = e2.getIOCause();
            if (cause != null) {
                throw cause;
            }
            throw e2;
        }
    }

    public static long streamCopy(Readable is, OutputStream os, int bufferSize) throws IOException {
        try {
            return streamCopy(is, new OutputStreamWritable(os), bufferSize);
        } catch (RuntimeIOException e2) {
            IOException cause = e2.getIOCause();
            if (cause != null) {
                throw cause;
            }
            throw e2;
        }
    }

    public static long streamCopy(InputStream is, Writable os, int bufferSize) throws IOException {
        try {
            return streamCopy(new InputStreamReadable(is), os, bufferSize);
        } catch (RuntimeIOException e2) {
            IOException cause = e2.getIOCause();
            if (cause != null) {
                throw cause;
            }
            throw e2;
        }
    }

    public static long streamCopy(Readable is, Writable os, int bufferSize) throws RuntimeIOException {
        byte[] buffer = new byte[bufferSize];
        long j = 0;
        while (true) {
            long totalBytesCopied = j;
            int bytesRead = is.read(buffer);
            if (bytesRead > 0) {
                os.write(buffer, 0, bytesRead);
                j = totalBytesCopied + bytesRead;
            } else {
                return totalBytesCopied;
            }
        }
    }
}
