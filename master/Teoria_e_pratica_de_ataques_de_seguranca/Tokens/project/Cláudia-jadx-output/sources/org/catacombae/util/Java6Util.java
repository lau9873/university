package org.catacombae.util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/util/Java6Util.class
 */
/* loaded from: csframework.jar:org/catacombae/util/Java6Util.class */
public class Java6Util {
    public static boolean isJava6OrHigher() {
        return System.getProperty("java.vm.version").compareTo("1.6") >= 0;
    }
}
