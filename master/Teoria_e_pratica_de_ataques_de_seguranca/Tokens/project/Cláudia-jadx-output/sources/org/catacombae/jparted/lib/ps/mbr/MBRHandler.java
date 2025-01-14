package org.catacombae.jparted.lib.ps.mbr;

import org.catacombae.hfsexplorer.partitioning.MBRPartitionTable;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ps.Partition;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.StandardPartition;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/mbr/MBRHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/mbr/MBRHandler.class */
public class MBRHandler extends PartitionSystemHandler {
    private DataLocator partitionData;

    public MBRHandler(DataLocator partitionData) {
        this.partitionData = partitionData;
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public long getPartitionCount() {
        MBRPartitionTable apm = readPartitionTable();
        return apm.getUsedPartitionCount();
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public Partition[] getPartitions() {
        MBRPartitionTable partitionTable = readPartitionTable();
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

    private MBRPartitionTable readPartitionTable() {
        ReadableRandomAccessStream llf = null;
        try {
            llf = this.partitionData.createReadOnlyFile();
            byte[] firstBlock = new byte[512];
            llf.readFully(firstBlock);
            MBRPartitionTable mbt = new MBRPartitionTable(firstBlock, 0);
            if (mbt.isValid()) {
                if (llf != null) {
                    llf.close();
                }
                return mbt;
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
