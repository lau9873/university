package org.catacombae.jparted.lib.ps.gpt;

import org.catacombae.hfsexplorer.partitioning.GUIDPartitionTable;
import org.catacombae.hfsexplorer.partitioning.PartitionSystem;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ps.Partition;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.StandardPartition;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/gpt/GPTHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/gpt/GPTHandler.class */
public class GPTHandler extends PartitionSystemHandler {
    private DataLocator partitionData;

    public GPTHandler(DataLocator partitionData) {
        this.partitionData = partitionData;
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public long getPartitionCount() {
        GUIDPartitionTable gpt = readPartitionTable();
        return gpt.getUsedPartitionCount();
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public Partition[] getPartitions() {
        PartitionSystem partitionTable = readPartitionTable();
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

    private GUIDPartitionTable readPartitionTable() {
        ReadableRandomAccessStream llf = null;
        try {
            llf = this.partitionData.createReadOnlyFile();
            GUIDPartitionTable gpt = new GUIDPartitionTable(llf, 0);
            if (gpt.isValid()) {
                if (llf != null) {
                    llf.close();
                }
                return gpt;
            }
            if (llf != null) {
                llf.close();
            }
            return null;
        } catch (Throwable th) {
            if (llf != null) {
                llf.close();
            }
            throw th;
        }
    }
}
