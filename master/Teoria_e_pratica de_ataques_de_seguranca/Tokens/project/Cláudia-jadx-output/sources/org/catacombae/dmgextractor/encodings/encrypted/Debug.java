package org.catacombae.dmgextractor.encodings.encrypted;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/Debug.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/Debug.class */
class Debug {
    private static boolean debugEnabled = false;
    public static final PrintStream ps;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/Debug$NullOutputStream.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/Debug$NullOutputStream.class */
    private static class NullOutputStream extends OutputStream {
        private NullOutputStream() {
        }

        @Override // java.io.OutputStream
        public void write(int b2) throws IOException {
        }
    }

    Debug() {
    }

    static {
        if (debugEnabled) {
            ps = System.err;
        } else {
            ps = new PrintStream(new NullOutputStream());
        }
    }

    public static void print(String s) {
        if (debugEnabled) {
            ps.println(s);
        }
    }
}
