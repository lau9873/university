package org.catacombae.dmgextractor;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/Debug.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/Debug.class */
public class Debug {
    public static boolean debug = false;

    public static void warning(String message) {
        if (debug) {
            System.err.println(message);
        }
    }

    public static void notification(String message) {
        if (debug) {
            System.out.println("------->NOTE: " + message);
        }
    }
}
