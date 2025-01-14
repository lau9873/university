package org.catacombae.jparted.lib.ps.mbr;

import org.catacombae.hfsexplorer.partitioning.MBRPartitionTable;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/mbr/MBRRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/mbr/MBRRecognizer.class */
public class MBRRecognizer implements PartitionSystemRecognizer {
    @Override // org.catacombae.jparted.lib.ps.PartitionSystemRecognizer
    public boolean detect(ReadableRandomAccessStream fsStream, long offset, long length) {
        try {
            byte[] firstBlock = new byte[512];
            fsStream.read(firstBlock);
            MBRPartitionTable mpt = new MBRPartitionTable(firstBlock, 0);
            if (mpt.isValid()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }
}
