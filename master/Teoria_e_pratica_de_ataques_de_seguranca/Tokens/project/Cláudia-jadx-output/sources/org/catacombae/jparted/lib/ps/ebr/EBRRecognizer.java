package org.catacombae.jparted.lib.ps.ebr;

import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRRecognizer.class */
public class EBRRecognizer implements PartitionSystemRecognizer {
    @Override // org.catacombae.jparted.lib.ps.PartitionSystemRecognizer
    public boolean detect(ReadableRandomAccessStream fsStream, long offset, long length) {
        try {
            EBRPartitionSystem ps = new EBRPartitionSystem(fsStream, offset, 512);
            if (ps.isValid()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }
}
