package org.catacombae.util;

import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/util/IOUtil.class
 */
/* loaded from: csframework.jar:org/catacombae/util/IOUtil.class */
public class IOUtil {
    public static byte[] readFully(ReadableRandomAccessStream s) throws RuntimeIOException {
        if (s.length() < 0 || s.length() > 2147483647L) {
            throw new IllegalArgumentException("Length of s is out of range: " + s.length());
        }
        byte[] res = new byte[(int) (s.length() - s.getFilePointer())];
        s.readFully(res);
        return res;
    }
}
