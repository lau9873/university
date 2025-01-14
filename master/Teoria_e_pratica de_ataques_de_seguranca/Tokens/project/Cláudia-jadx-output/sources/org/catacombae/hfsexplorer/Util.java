package org.catacombae.hfsexplorer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/Util.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/Util.class */
public class Util extends org.catacombae.util.Util {
    public static <A> boolean contains(A[] array, A element) {
        for (A a2 : array) {
            if (a2 == element) {
                return true;
            }
        }
        return false;
    }
}
