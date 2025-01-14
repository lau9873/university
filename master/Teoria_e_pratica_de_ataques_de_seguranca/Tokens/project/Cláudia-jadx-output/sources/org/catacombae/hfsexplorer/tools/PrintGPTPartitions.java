package org.catacombae.hfsexplorer.tools;

import java.io.FileOutputStream;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.partitioning.GUIDPartitionTable;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/tools/PrintGPTPartitions.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/tools/PrintGPTPartitions.class */
public class PrintGPTPartitions {
    public static void main(String[] args) throws Exception {
        ReadableRandomAccessStream llf;
        if (WindowsLowLevelIO.isSystemSupported()) {
            llf = new WindowsLowLevelIO(args[0]);
        } else {
            llf = new ReadableFileStream(args[0]);
        }
        byte[] referencetable = new byte[16896];
        llf.seek(512L);
        llf.readFully(referencetable);
        FileOutputStream refFile = new FileOutputStream("gpt_table_ref.debug");
        refFile.write(referencetable);
        refFile.close();
        System.out.println("Wrote the raw GPT table to file: gpt_table_ref.debug");
        System.out.println("Length of file: " + llf.length());
        GUIDPartitionTable gpt = new GUIDPartitionTable(llf, 0);
        System.out.println("Calculated checksum for header: 0x" + Util.toHexStringBE(gpt.calculatePrimaryHeaderChecksum()));
        System.out.println("Calculated checksum for entries: 0x" + Util.toHexStringBE(gpt.calculatePrimaryEntriesChecksum()));
        gpt.print(System.out, "");
        System.out.println("Is this parititon table valid? " + gpt.isValid() + ".");
        FileOutputStream debug = new FileOutputStream("gpt_table.debug");
        debug.write(gpt.getPrimaryTableBytes());
        debug.close();
        System.out.println("Wrote the leading GPT table to file: gpt_table.debug");
        llf.close();
    }
}
