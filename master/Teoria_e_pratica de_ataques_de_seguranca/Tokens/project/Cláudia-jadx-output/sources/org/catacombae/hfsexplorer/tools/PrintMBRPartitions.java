package org.catacombae.hfsexplorer.tools;

import java.io.FileOutputStream;
import org.catacombae.hfsexplorer.partitioning.MBRPartitionTable;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/tools/PrintMBRPartitions.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/tools/PrintMBRPartitions.class */
public class PrintMBRPartitions {
    public static void main(String[] args) throws Exception {
        ReadableRandomAccessStream llf;
        if (WindowsLowLevelIO.isSystemSupported()) {
            llf = new WindowsLowLevelIO(args[0]);
        } else {
            llf = new ReadableFileStream(args[0]);
        }
        byte[] referencetable = new byte[512];
        llf.seek(0L);
        llf.readFully(referencetable);
        FileOutputStream refFile = new FileOutputStream("mbr_table.debug");
        refFile.write(referencetable);
        refFile.close();
        System.out.println("Wrote the raw MBR table to file: mbr_table.debug");
        System.out.println("Length of file: " + llf.length());
        MBRPartitionTable mbr = new MBRPartitionTable(llf, 0);
        mbr.print(System.out, "");
        System.out.println("Is this parititon table valid? " + mbr.isValid() + ".");
        llf.close();
    }
}
