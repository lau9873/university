package org.catacombae.hfsexplorer.testcode;

import org.catacombae.hfsexplorer.fs.AppleSingleHandler;
import org.catacombae.hfsexplorer.types.applesingle.EntryDescriptor;
import org.catacombae.io.ReadableFileStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/AppleSingleDebug.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/AppleSingleDebug.class */
public class AppleSingleDebug {
    public static void main(String[] args) {
        int retval = 1;
        if (args.length != 1) {
            System.err.println("usage: AppleSingleDebug <AppleSingle file>");
        } else {
            ReadableFileStream is = new ReadableFileStream(args[0]);
            AppleSingleHandler handler = new AppleSingleHandler(is);
            System.out.println("Header:");
            handler.getHeader().print(System.out, "  ");
            int i2 = 0;
            EntryDescriptor[] arr$ = handler.getEntryDescriptors();
            for (EntryDescriptor ed : arr$) {
                int i3 = i2;
                i2++;
                System.out.println("EntryDescriptor[" + i3 + "]:");
                ed.print(System.out, "  ");
            }
            retval = 0;
        }
        System.exit(retval);
    }
}
