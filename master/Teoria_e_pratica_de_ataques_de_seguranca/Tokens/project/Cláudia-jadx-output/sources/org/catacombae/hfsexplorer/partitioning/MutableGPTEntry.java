package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableGPTEntry.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableGPTEntry.class */
public class MutableGPTEntry extends GPTEntry {
    public MutableGPTEntry(int blockSize) {
        super(blockSize);
    }

    public MutableGPTEntry(GPTEntry source) {
        super(source);
    }

    public void setPartitionTypeGUID(byte[] data, int off) {
        copyData(data, off, this.partitionTypeGUID);
    }

    public void setUniquePartitionGUID(byte[] data, int off) {
        copyData(data, off, this.uniquePartitionGUID);
    }

    public void setStartingLBA(long i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.startingLBA);
    }

    public void setEndingLBA(long i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.endingLBA);
    }

    public void setAttributeBits(long i2) {
        Util.arrayCopy(Util.toByteArrayBE(i2), this.attributeBits);
    }

    public void setPartitionName(byte[] data, int off) {
        copyData(data, off, this.partitionName);
    }

    public void setFields(GPTEntry gptEntry) {
        super.copyFields(gptEntry);
    }

    private static void copyData(byte[] data, int off, byte[] dest) {
        copyData(data, off, dest, dest.length);
    }

    private static void copyData(byte[] data, int off, byte[] dest, int len) {
        if (off + len > data.length) {
            throw new IllegalArgumentException("Length of input data must be " + len + ".");
        }
        System.arraycopy(data, off, dest, 0, len);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.GPTEntry, org.catacombae.hfsexplorer.partitioning.Partition
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "MutableGPTEntry:");
        printFields(ps, prefix);
    }
}
