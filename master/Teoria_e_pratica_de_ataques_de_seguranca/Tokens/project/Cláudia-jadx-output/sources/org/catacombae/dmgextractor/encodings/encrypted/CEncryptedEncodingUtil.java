package org.catacombae.dmgextractor.encodings.encrypted;

import org.catacombae.dmgextractor.Util;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CEncryptedEncodingUtil.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CEncryptedEncodingUtil.class */
class CEncryptedEncodingUtil {
    private static final String V1_SIGNATURE = "cdsaencr";
    private static final String V2_SIGNATURE = "encrcdsa";

    CEncryptedEncodingUtil() {
    }

    public static int detectVersion(ReadableRandomAccessStream stream) {
        byte[] signatureBytes = new byte[8];
        try {
            stream.seek(0L);
            stream.readFully(signatureBytes);
            if (Util.toASCIIString(signatureBytes).equals("encrcdsa")) {
                return 2;
            }
        } catch (Exception e2) {
            System.err.println("Non-critical exception while detecting version 2 CEncryptedEncoding header:");
            e2.printStackTrace();
        }
        try {
            stream.seek(stream.length() - signatureBytes.length);
            stream.readFully(signatureBytes);
            if (Util.toASCIIString(signatureBytes).equals("cdsaencr")) {
                return 1;
            }
            return -1;
        } catch (Exception e3) {
            System.err.println("Non-critical exception while detecting version 1 CEncryptedEncoding header:");
            e3.printStackTrace();
            return -1;
        }
    }
}
