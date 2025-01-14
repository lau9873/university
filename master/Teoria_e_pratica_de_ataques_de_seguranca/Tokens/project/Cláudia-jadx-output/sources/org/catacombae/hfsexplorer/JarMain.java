package org.catacombae.hfsexplorer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/JarMain.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/JarMain.class */
public class JarMain {
    private static final String CONSOLE_ARG = "-dbgconsole";

    public static void main(String[] args) {
        String[] fsbArgs;
        if (args.length <= 0 || !args[0].equals("-dbgconsole")) {
            fsbArgs = new String[args.length + 1];
            fsbArgs[0] = "-dbgconsole";
            for (int i2 = 0; i2 < args.length; i2++) {
                fsbArgs[i2 + 1] = args[i2];
            }
        } else {
            fsbArgs = args;
        }
        FileSystemBrowserWindow.main(fsbArgs);
    }
}
