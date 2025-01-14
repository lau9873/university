package org.catacombae.hfsexplorer.partitioning;

import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableMBRPartition.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableMBRPartition.class */
public class MutableMBRPartition extends MBRPartition {
    public MutableMBRPartition(MBRPartition source) {
        super(source);
    }

    public void setStatus(byte b2) {
        this.status[0] = b2;
    }

    public void setFirstSector(byte[] chs, int off) {
        copyData(chs, off, this.firstSector);
    }

    public void setPartitionType(byte b2) {
        this.partitionType[0] = b2;
    }

    public void setLastSector(byte[] chs, int off) {
        copyData(chs, off, this.lastSector);
    }

    public void setLBAFirstSector(int lba) {
        Util.arrayCopy(Util.toByteArrayLE(lba), this.lbaFirstSector);
    }

    public void setLBAPartitionLength(int lba) {
        Util.arrayCopy(Util.toByteArrayLE(lba), this.lbaPartitionLength);
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
}
