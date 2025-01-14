package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.jparted.lib.ps.PartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/GeneralPartition.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/GeneralPartition.class */
public class GeneralPartition implements Partition {
    private final long startOffset;
    private final long length;
    private final PartitionType type;

    public GeneralPartition(long startOffset, long length) {
        this(startOffset, length, PartitionType.UNKNOWN);
    }

    public GeneralPartition(long startOffset, long length, PartitionType type) {
        this.startOffset = startOffset;
        this.length = length;
        this.type = type;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public long getStartOffset() {
        return this.startOffset;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public long getLength() {
        return this.length;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public PartitionType getType() {
        return this.type;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " startOffset: " + this.startOffset);
        ps.println(prefix + " length: " + this.length);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "GeneralPartition:");
        printFields(ps, prefix);
    }
}
