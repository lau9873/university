package org.catacombae.dmgextractor.encodings.encrypted;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/Assert.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/Assert.class */
public class Assert {
    public static void eq(long a2, long b2) {
        eq(a2, b2, null);
    }

    public static void eq(long a2, long b2, String message) {
        if (a2 != b2) {
            throw new InvalidAssertionException("Equality asserion " + a2 + " == " + b2 + " failed!" + (message != null ? " Message: " + message : ""));
        }
    }

    public static void neq(long a2, long b2) {
        neq(a2, b2, null);
    }

    public static void neq(long a2, long b2, String message) {
        if (a2 == b2) {
            throw new InvalidAssertionException("Non-equality asserion " + a2 + " != " + b2 + " failed!" + (message != null ? " Message: " + message : ""));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/Assert$InvalidAssertionException.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/Assert$InvalidAssertionException.class */
    public static class InvalidAssertionException extends RuntimeException {
        public InvalidAssertionException(String message) {
            super(message);
        }
    }
}
