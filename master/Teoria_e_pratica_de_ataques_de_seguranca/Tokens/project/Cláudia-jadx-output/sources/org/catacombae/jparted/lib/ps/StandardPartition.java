package org.catacombae.jparted.lib.ps;

import java.io.PrintStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/StandardPartition.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/StandardPartition.class */
public class StandardPartition extends Partition {
    private final long startOffset;
    private final long length;
    private final PartitionType type;

    public StandardPartition(long startOffset, long length, PartitionType type) {
        this.startOffset = startOffset;
        this.length = length;
        this.type = type;
    }

    @Override // org.catacombae.jparted.lib.ps.Partition
    public long getStartOffset() {
        return this.startOffset;
    }

    @Override // org.catacombae.jparted.lib.ps.Partition
    public long getLength() {
        return this.length;
    }

    @Override // org.catacombae.jparted.lib.ps.Partition
    public PartitionType getType() {
        return this.type;
    }

    @Override // org.catacombae.jparted.lib.ps.Partition
    public void printFields(PrintStream ps, String prefix) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // org.catacombae.jparted.lib.ps.Partition
    public void print(PrintStream ps, String prefix) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
