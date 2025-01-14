package org.catacombae.hfsexplorer.tools;

import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.catacombae.hfsexplorer.GUIUtil;
import org.catacombae.hfsexplorer.PartitionSystemRecognizer;
import org.catacombae.hfsexplorer.SelectWindowsDeviceDialog;
import org.catacombae.hfsexplorer.partitioning.ApplePartitionMap;
import org.catacombae.hfsexplorer.partitioning.GUIDPartitionTable;
import org.catacombae.hfsexplorer.partitioning.MBRPartitionTable;
import org.catacombae.hfsexplorer.partitioning.Partition;
import org.catacombae.hfsexplorer.partitioning.PartitionSystem;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.PartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/tools/DumpFSInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/tools/DumpFSInfo.class */
public class DumpFSInfo {
    public static void main(String[] args) throws Throwable {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable th) {
        }
        try {
            dumpInfo(args);
            System.exit(0);
        } catch (Exception e2) {
            GUIUtil.displayExceptionDialog(e2, 25, null);
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
        System.exit(1);
    }

    public static void dumpInfo(String[] args) throws Exception {
        ReadableRandomAccessStream fsFile;
        long fsOffset;
        long fsLength;
        File first64File;
        File last64File;
        long runTimestamp = System.currentTimeMillis();
        if (WindowsLowLevelIO.isSystemSupported()) {
            if (args.length == 1) {
                fsFile = new WindowsLowLevelIO(args[0]);
            } else if (args.length == 0) {
                SelectWindowsDeviceDialog swdd = new SelectWindowsDeviceDialog(null, true, "Select device to extract info from");
                swdd.setVisible(true);
                fsFile = swdd.getPartitionStream();
                if (fsFile == null) {
                    System.exit(0);
                }
            } else {
                System.out.println("Usage: java DumpFSInfo <filename>");
                System.out.println("        for reading directly from a specified file, or...");
                System.out.println("       java DumpFSInfo");
                System.out.println("        to pop up a Windows device dialog where you can choose which device to read");
                return;
            }
        } else if (args.length == 1) {
            fsFile = new ReadableFileStream(args[0]);
        } else {
            System.out.println("Usage: java DumpFSInfo <filename>");
            return;
        }
        LinkedList<File> generatedFiles = new LinkedList<>();
        int partNum = -1;
        PartitionSystemRecognizer psr = new PartitionSystemRecognizer(fsFile);
        PartitionSystem partSys = psr.getPartitionSystem();
        if (partSys != null) {
            Partition[] partitions = partSys.getUsedPartitionEntries();
            if (partitions.length == 0) {
                fsOffset = 0;
                try {
                    fsLength = fsFile.length();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    fsLength = -1;
                }
            } else {
                if (partSys instanceof ApplePartitionMap) {
                    ApplePartitionMap apm = (ApplePartitionMap) partSys;
                    File ddrFile = new File("fsdump-" + runTimestamp + "_ddr.dat");
                    byte[] ddrData = new byte[512];
                    FileOutputStream fos = new FileOutputStream(ddrFile);
                    fsFile.seek(0L);
                    fsFile.readFully(ddrData);
                    fos.write(ddrData);
                    fos.close();
                    generatedFiles.add(ddrFile);
                    File apmFile = new File("fsdump-" + runTimestamp + "_apm.dat");
                    FileOutputStream fos2 = new FileOutputStream(apmFile);
                    fos2.write(apm.getData());
                    fos2.close();
                    generatedFiles.add(apmFile);
                } else if (partSys instanceof GUIDPartitionTable) {
                    GUIDPartitionTable gpt = (GUIDPartitionTable) partSys;
                    File mbrFile = new File("fsdump-" + runTimestamp + "_protectivembr.dat");
                    byte[] mbrData = new byte[512];
                    FileOutputStream fos3 = new FileOutputStream(mbrFile);
                    fsFile.seek(0L);
                    fsFile.readFully(mbrData);
                    fos3.write(mbrData);
                    fos3.close();
                    generatedFiles.add(mbrFile);
                    File gptBeginFile = new File("fsdump-" + runTimestamp + "_gptprimary.dat");
                    FileOutputStream fos4 = new FileOutputStream(gptBeginFile);
                    fos4.write(gpt.getPrimaryTableBytes());
                    fos4.close();
                    generatedFiles.add(gptBeginFile);
                    File gptEndFile = new File("fsdump-" + runTimestamp + "_gptbackup.dat");
                    FileOutputStream fos5 = new FileOutputStream(gptEndFile);
                    fos5.write(gpt.getBackupTableBytes());
                    fos5.close();
                    generatedFiles.add(gptEndFile);
                } else if (partSys instanceof MBRPartitionTable) {
                    MBRPartitionTable mbr = (MBRPartitionTable) partSys;
                    File mbrFile2 = new File("fsdump-" + runTimestamp + "_mbr.dat");
                    FileOutputStream fos6 = new FileOutputStream(mbrFile2);
                    fos6.write(mbr.getMasterBootRecord().getBytes());
                    fos6.close();
                    generatedFiles.add(mbrFile2);
                } else {
                    throw new RuntimeException("Unknown partition system type!");
                }
                int firstPreferredPartition = 0;
                for (int i2 = 0; i2 < partitions.length; i2++) {
                    Partition p = partitions[i2];
                    PartitionType pt2 = p.getType();
                    if (pt2 == PartitionType.APPLE_HFS_CONTAINER || pt2 == PartitionType.APPLE_HFSX) {
                        firstPreferredPartition = i2;
                        break;
                    }
                }
                Object selectedValue = JOptionPane.showInputDialog((Component) null, "Select which partition to read", "Choose " + partSys.getLongName() + " partition", 3, (Icon) null, partitions, partitions[firstPreferredPartition]);
                int i3 = 0;
                while (true) {
                    if (i3 < partitions.length) {
                        if (partitions[i3] != selectedValue) {
                            i3++;
                        } else {
                            partNum = i3;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (selectedValue instanceof Partition) {
                    Partition selectedPartition = (Partition) selectedValue;
                    fsOffset = selectedPartition.getStartOffset();
                    fsLength = selectedPartition.getLength();
                } else {
                    throw new RuntimeException("Impossible error!");
                }
            }
        } else {
            fsOffset = 0;
            try {
                fsLength = fsFile.length();
            } catch (Exception e3) {
                e3.printStackTrace();
                fsLength = -1;
            }
        }
        byte[] buffer = new byte[65536];
        if (partNum == -1) {
            first64File = new File("fsdump-" + runTimestamp + "_first64.dat");
            last64File = new File("fsdump-" + runTimestamp + "_last64.dat");
        } else {
            first64File = new File("fsdump-" + runTimestamp + "_p" + partNum + "_first64.dat");
            last64File = new File("fsdump-" + runTimestamp + "_p" + partNum + "_last64.dat");
        }
        if (extractDataToFile(fsFile, fsOffset, first64File, 65536)) {
            generatedFiles.add(first64File);
        }
        long pos = (fsOffset + fsLength) - buffer.length;
        if (pos > fsOffset && extractDataToFile(fsFile, pos, last64File, 65536)) {
            generatedFiles.add(last64File);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Dumped FS info to directory:\n    ");
        File firstFile = generatedFiles.getFirst().getAbsoluteFile();
        File firstParent = firstFile.getParentFile();
        sb.append(firstParent.getAbsolutePath());
        sb.append("\nThe following files were generated:\n    ");
        Iterator i$ = generatedFiles.iterator();
        while (i$.hasNext()) {
            File f2 = i$.next();
            sb.append(f2.toString() + "\n    ");
        }
        JOptionPane.showMessageDialog((Component) null, sb.toString(), "Result", 1);
    }

    private static boolean extractDataToFile(ReadableRandomAccessStream fsFile, long pos, File outFile, int dataSize) {
        try {
            byte[] buffer = new byte[dataSize];
            fsFile.seek(pos);
            int bytesRead = fsFile.read(buffer);
            FileOutputStream fileOut = new FileOutputStream(outFile);
            fileOut.write(buffer, 0, bytesRead);
            fileOut.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
