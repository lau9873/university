package org.catacombae.hfsexplorer;

import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/UDIFRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/UDIFRecognizer.class */
public class UDIFRecognizer {
    private static final int SIGNATURE = 1802464377;

    public static boolean isUDIF(ReadableRandomAccessStream llf) {
        if (llf.length() < 512) {
            return false;
        }
        llf.seek(llf.length() - 512);
        byte[] signature = new byte[4];
        llf.readFully(signature);
        int sigAsInt = Util.readIntBE(signature);
        return sigAsInt == 1802464377;
    }
}
