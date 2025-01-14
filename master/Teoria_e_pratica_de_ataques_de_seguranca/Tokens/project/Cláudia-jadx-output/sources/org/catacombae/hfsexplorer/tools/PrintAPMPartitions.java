package org.catacombae.hfsexplorer.tools;

import java.io.FileOutputStream;
import org.catacombae.hfsexplorer.partitioning.ApplePartitionMap;
import org.catacombae.hfsexplorer.partitioning.DriverDescriptorRecord;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/tools/PrintAPMPartitions.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/tools/PrintAPMPartitions.class */
public class PrintAPMPartitions {
    public static void main(String[] args) throws Exception {
        ReadableRandomAccessStream llf;
        if (WindowsLowLevelIO.isSystemSupported()) {
            llf = new WindowsLowLevelIO(args[0]);
        } else {
            llf = new ReadableFileStream(args[0]);
        }
        byte[] ddrBlock = new byte[DriverDescriptorRecord.length()];
        int bytesRead = llf.read(ddrBlock);
        if (bytesRead != ddrBlock.length) {
            throw new RuntimeException("Could not read Driver Descriptor Record (read " + bytesRead + "bytes)");
        }
        DriverDescriptorRecord ddr = new DriverDescriptorRecord(ddrBlock, 0);
        ddr.print(System.out, "");
        FileOutputStream ddrFile = new FileOutputStream("ddr.debug");
        ddrFile.write(ddrBlock);
        ddrFile.close();
        System.out.println("Wrote the Driver Descriptor Record to file: ddr.debug");
        System.out.println("Length of file: " + llf.length());
        int blockSize = ddr.getSbBlkSize();
        ApplePartitionMap apm = new ApplePartitionMap(llf, blockSize, blockSize);
        apm.print(System.out, "");
        FileOutputStream apmFile = new FileOutputStream("apm.debug");
        apmFile.write(apm.getData());
        apmFile.close();
        System.out.println("Wrote the raw Apple Partition Map to file: apm.debug");
        llf.close();
    }
}
