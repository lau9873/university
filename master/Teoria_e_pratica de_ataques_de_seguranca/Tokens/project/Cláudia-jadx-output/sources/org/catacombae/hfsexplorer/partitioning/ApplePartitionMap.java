package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.io.ReadableByteArrayStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/ApplePartitionMap.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/ApplePartitionMap.class */
public class ApplePartitionMap implements PartitionSystem {
    private final APMPartition[] partitions;

    /* JADX WARN: Code restructure failed: missing block: B:26:0x010a, code lost:
        throw new java.lang.RuntimeException("Redundant fields mismatch at index: " + r0.size() + " (curPmSig=" + ((int) r0) + " pmSig=" + r13 + " curPmSigPad=" + ((int) r0) + " pmSigPad=" + r14 + " curPmMapBlkCnt=" + r0 + " pmMapBlkCnt=" + r15 + ")");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ApplePartitionMap(org.catacombae.io.ReadableRandomAccessStream r7, long r8, int r10) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.catacombae.hfsexplorer.partitioning.ApplePartitionMap.<init>(org.catacombae.io.ReadableRandomAccessStream, long, int):void");
    }

    public ApplePartitionMap(byte[] data, int off, int blockSize) {
        this(new ReadableByteArrayStream(data, 0, data.length), off, blockSize);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public boolean isValid() {
        if (this.partitions.length > 0) {
            APMPartition[] arr$ = this.partitions;
            for (APMPartition p : arr$) {
                if (!p.isValid()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getPartitionCount() {
        return this.partitions.length;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getUsedPartitionCount() {
        return getPartitionCount();
    }

    public APMPartition getAPMPartition(int index) {
        return this.partitions[index];
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public APMPartition[] getPartitionEntries() {
        APMPartition[] copy = new APMPartition[this.partitions.length];
        for (int i2 = 0; i2 < this.partitions.length; i2++) {
            copy[i2] = this.partitions[i2];
        }
        return copy;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getUsedPartitionEntries() {
        return getPartitionEntries();
    }

    public byte[] getData() {
        byte[] result = new byte[this.partitions.length * APMPartition.structSize()];
        int offset = 0;
        APMPartition[] arr$ = this.partitions;
        for (APMPartition ap : arr$) {
            byte[] tmp = ap.getData();
            System.arraycopy(tmp, 0, result, offset, tmp.length);
            offset += tmp.length;
        }
        if (offset != result.length) {
            throw new RuntimeException("Internal miscalculation...");
        }
        return result;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void printFields(PrintStream ps, String prefix) {
        for (int i2 = 0; i2 < this.partitions.length; i2++) {
            ps.println(prefix + " partitions[" + i2 + "]:");
            this.partitions[i2].print(ps, prefix + "  ");
        }
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void print(PrintStream ps, String prefix) {
        ps.println("Apple Partition Map:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition getPartitionEntry(int index) {
        return getAPMPartition(index);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getLongName() {
        return "Apple Partition Map";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getShortName() {
        return "APM";
    }
}
