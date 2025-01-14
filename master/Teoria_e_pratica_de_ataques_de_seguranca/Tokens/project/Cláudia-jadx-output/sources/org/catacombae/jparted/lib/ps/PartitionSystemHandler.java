package org.catacombae.jparted.lib.ps;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemHandler.class */
public abstract class PartitionSystemHandler {
    public abstract long getPartitionCount();

    public abstract Partition[] getPartitions();

    public abstract void close();

    public Partition getPartition(int partitionNumber) {
        Partition[] parts = getPartitions();
        if (partitionNumber >= 0 && partitionNumber < parts.length) {
            return parts[partitionNumber];
        }
        return null;
    }
}
