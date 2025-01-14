package org.catacombae.jparted.lib.ps.apm;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.partitioning.ApplePartitionMap;
import org.catacombae.hfsexplorer.partitioning.DriverDescriptorRecord;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ps.Partition;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.StandardPartition;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/apm/APMHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/apm/APMHandler.class */
public class APMHandler extends PartitionSystemHandler {
    private DataLocator partitionData;

    public APMHandler(DataLocator partitionData) {
        this.partitionData = partitionData;
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public long getPartitionCount() {
        ApplePartitionMap apm = readPartitionMap();
        return apm.getUsedPartitionCount();
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public Partition[] getPartitions() {
        ApplePartitionMap apm = readPartitionMap();
        Partition[] result = new Partition[apm.getUsedPartitionCount()];
        org.catacombae.hfsexplorer.partitioning.Partition[] apmParts = apm.getUsedPartitionEntries();
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = new StandardPartition(apmParts[i2].getStartOffset(), apmParts[i2].getLength(), apmParts[i2].getType());
        }
        return result;
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandler
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private ApplePartitionMap readPartitionMap() {
        ReadableRandomAccessStream llf = null;
        try {
            llf = this.partitionData.createReadOnlyFile();
            byte[] firstBlock = new byte[512];
            llf.readFully(firstBlock);
            DriverDescriptorRecord ddr = new DriverDescriptorRecord(firstBlock, 0);
            if (!ddr.isValid()) {
                if (llf != null) {
                    llf.close();
                }
                return null;
            }
            int blockSize = Util.unsign(ddr.getSbBlkSize());
            ApplePartitionMap apm = new ApplePartitionMap(llf, blockSize * 1, blockSize);
            if (apm.getPartitionCount() > 0) {
                if (llf != null) {
                    llf.close();
                }
                return apm;
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
