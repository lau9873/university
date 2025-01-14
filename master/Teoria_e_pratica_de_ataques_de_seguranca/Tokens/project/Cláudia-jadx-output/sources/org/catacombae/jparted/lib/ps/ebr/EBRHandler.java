package org.catacombae.jparted.lib.ps.ebr;

import org.catacombae.hfsexplorer.partitioning.PartitionSystem;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ps.Partition;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.StandardPartition;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRHandler.class */
public class EBRHandler extends PartitionSystemHandler {
    private DataLocator partitionData;

    public EBRHandler(DataLocator partitionData) {
        this.partitionData = partitionData;
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public long getPartitionCount() {
        PartitionSystem ps = readPartitionTable();
        return ps.getUsedPartitionCount();
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public Partition[] getPartitions() {
        EBRPartitionSystem partitionTable = readPartitionTable();
        Partition[] result = new Partition[partitionTable.getUsedPartitionCount()];
        org.catacombae.hfsexplorer.partitioning.Partition[] parts = partitionTable.getUsedPartitionEntries();
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = new StandardPartition(parts[i2].getStartOffset(), parts[i2].getLength(), parts[i2].getType());
        }
        return result;
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public void close() {
    }

    private EBRPartitionSystem readPartitionTable() {
        try {
            ReadableRandomAccessStream llf = this.partitionData.createReadOnlyFile();
            byte[] firstBlock = new byte[512];
            llf.readFully(firstBlock);
            EBRPartitionSystem ebs = new EBRPartitionSystem(llf, 0L, 512);
            if (ebs.isValid()) {
                return ebs;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }
}
