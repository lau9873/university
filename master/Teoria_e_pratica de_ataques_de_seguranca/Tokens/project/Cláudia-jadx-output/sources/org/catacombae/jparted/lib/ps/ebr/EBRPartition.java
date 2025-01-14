package org.catacombae.jparted.lib.ps.ebr;

import org.catacombae.hfsexplorer.partitioning.MBRPartition;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRPartition.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRPartition.class */
public class EBRPartition extends MBRPartition {
    private final long baseOffset;

    public EBRPartition(byte[] data, int offset, long baseOffset, int sectorSize) {
        super(data, offset, sectorSize);
        this.baseOffset = baseOffset;
    }

    public EBRPartition(EBRPartition source) {
        super(source);
        this.baseOffset = source.baseOffset;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.MBRPartition, org.catacombae.hfsexplorer.partitioning.Partition
    public long getStartOffset() {
        return super.getStartOffset() + this.baseOffset;
    }
}
