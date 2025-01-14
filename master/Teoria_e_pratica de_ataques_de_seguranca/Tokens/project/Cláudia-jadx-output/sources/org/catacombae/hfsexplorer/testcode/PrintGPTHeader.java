package org.catacombae.hfsexplorer.testcode;

import java.io.File;
import java.io.RandomAccessFile;
import org.catacombae.hfsexplorer.partitioning.GPTHeader;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/PrintGPTHeader.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/PrintGPTHeader.class */
public class PrintGPTHeader {
    public static void main(String[] args) throws Exception {
        long offset = 0;
        if (args.length > 0) {
            File sourceFile = new File(args[0]);
            if (args.length > 1) {
                offset = Long.parseLong(args[1]);
            }
            byte[] data = new byte[GPTHeader.getSize()];
            RandomAccessFile sourceRaf = new RandomAccessFile(sourceFile, "r");
            sourceRaf.seek(offset);
            sourceRaf.read(data);
            GPTHeader gph = new GPTHeader(data, 0, 512);
            gph.print(System.out, "");
            return;
        }
        System.out.println("usage: PrintGPTHeader <sourceFile> [<offset>]");
        System.exit(1);
    }
}
