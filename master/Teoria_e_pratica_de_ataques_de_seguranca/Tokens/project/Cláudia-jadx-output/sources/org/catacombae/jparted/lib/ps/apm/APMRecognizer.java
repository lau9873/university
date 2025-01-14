package org.catacombae.jparted.lib.ps.apm;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.partitioning.ApplePartitionMap;
import org.catacombae.hfsexplorer.partitioning.DriverDescriptorRecord;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/apm/APMRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/apm/APMRecognizer.class */
public class APMRecognizer implements PartitionSystemRecognizer {
    @Override // org.catacombae.jparted.lib.ps.PartitionSystemRecognizer
    public boolean detect(ReadableRandomAccessStream fsStream, long offset, long length) {
        try {
            byte[] firstBlock = new byte[512];
            fsStream.seek(0L);
            fsStream.readFully(firstBlock);
            DriverDescriptorRecord ddr = new DriverDescriptorRecord(firstBlock, 0);
            if (ddr.isValid()) {
                int blockSize = Util.unsign(ddr.getSbBlkSize());
                ApplePartitionMap apm = new ApplePartitionMap(fsStream, blockSize * 1, blockSize);
                if (apm.getUsedPartitionCount() > 0) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }
}
