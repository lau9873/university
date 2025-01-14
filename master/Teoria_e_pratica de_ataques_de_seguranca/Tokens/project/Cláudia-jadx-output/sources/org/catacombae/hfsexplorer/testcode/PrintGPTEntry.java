package org.catacombae.hfsexplorer.testcode;

import java.io.File;
import java.io.RandomAccessFile;
import org.catacombae.hfsexplorer.partitioning.GPTEntry;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/PrintGPTEntry.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/PrintGPTEntry.class */
public class PrintGPTEntry {
    public static void main(String[] args) throws Exception {
        long offset = 0;
        if (args.length > 0) {
            File sourceFile = new File(args[0]);
            if (args.length > 1) {
                offset = Long.parseLong(args[1]);
            }
            byte[] data = new byte[GPTEntry.getSize()];
            RandomAccessFile sourceRaf = new RandomAccessFile(sourceFile, "r");
            sourceRaf.seek(offset);
            sourceRaf.read(data);
            GPTEntry gph = new GPTEntry(data, 0, 512);
            gph.print(System.out, "");
            return;
        }
        System.out.println("usage: PrintGPTEntry <sourceFile> [<offset>]");
        System.exit(1);
    }
}
