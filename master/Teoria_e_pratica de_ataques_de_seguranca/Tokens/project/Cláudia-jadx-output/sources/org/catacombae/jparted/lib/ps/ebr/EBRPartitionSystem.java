package org.catacombae.jparted.lib.ps.ebr;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.partitioning.MBRPartitionTable;
import org.catacombae.hfsexplorer.partitioning.Partition;
import org.catacombae.hfsexplorer.partitioning.PartitionSystem;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.PartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRPartitionSystem.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRPartitionSystem.class */
public class EBRPartitionSystem implements PartitionSystem {
    private final ExtendedBootRecord[] bootRecords;

    public EBRPartitionSystem(ReadableRandomAccessStream psStream, long ebrPartitionOffset, int sectorSize) {
        this(psStream, ebrPartitionOffset, -1L, sectorSize);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00bb, code lost:
        if (r0.isValid() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00e1, code lost:
        throw new java.lang.RuntimeException("Invalid extended partition table at index " + r0.size() + ".");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e2, code lost:
        r10.bootRecords = (org.catacombae.jparted.lib.ps.ebr.ExtendedBootRecord[]) r0.toArray(new org.catacombae.jparted.lib.ps.ebr.ExtendedBootRecord[r0.size()]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public EBRPartitionSystem(org.catacombae.io.ReadableRandomAccessStream r11, long r12, long r14, int r16) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.catacombae.jparted.lib.ps.ebr.EBRPartitionSystem.<init>(org.catacombae.io.ReadableRandomAccessStream, long, long, int):void");
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public boolean isValid() {
        return true;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getPartitionCount() {
        return this.bootRecords.length;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition getPartitionEntry(int index) {
        return this.bootRecords[index].getFirstEntry();
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getPartitionEntries() {
        Partition[] result = new Partition[this.bootRecords.length];
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = this.bootRecords[i2].getFirstEntry();
        }
        return result;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getUsedPartitionCount() {
        return getPartitionCount();
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getUsedPartitionEntries() {
        return getPartitionEntries();
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getLongName() {
        return "Extended Boot Record";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getShortName() {
        return "EBR";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " bootRecords:");
        for (int i2 = 0; i2 < this.bootRecords.length; i2++) {
            ExtendedBootRecord ebr = this.bootRecords[i2];
            ps.print(prefix + "  [" + i2 + "]:");
            ebr.print(ps, prefix + "   ");
        }
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix);
    }

    public static void main(String[] args) {
        ReadableRandomAccessStream inputStream;
        System.err.println("Test code for Extended Boot Record");
        String inputFilename = args[0];
        if (WindowsLowLevelIO.isSystemSupported()) {
            inputStream = new WindowsLowLevelIO(inputFilename);
        } else {
            inputStream = new ReadableFileStream(inputFilename);
        }
        MBRPartitionTable mpt = new MBRPartitionTable(inputStream, 0);
        if (!mpt.isValid()) {
            throw new RuntimeException("Invalid MBR.");
        }
        int i2 = 0;
        Partition[] arr$ = mpt.getUsedPartitionEntries();
        for (Partition p : arr$) {
            if (p.getType() == PartitionType.DOS_EXTENDED) {
                System.err.println("Found extended partition system at MBR partition " + i2 + ":");
                EBRPartitionSystem ebt = new EBRPartitionSystem(inputStream, p.getStartOffset(), p.getLength(), 512);
                ebt.print(System.err, "  ");
            }
            i2++;
        }
        inputStream.close();
    }
}
