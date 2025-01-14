package org.catacombae.jparted.lib.ps.gpt;

import org.catacombae.hfsexplorer.partitioning.GPTHeader;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/gpt/GPTRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/gpt/GPTRecognizer.class */
public class GPTRecognizer implements PartitionSystemRecognizer {
    @Override // org.catacombae.jparted.lib.ps.PartitionSystemRecognizer
    public boolean detect(ReadableRandomAccessStream fsStream, long offset, long length) {
        try {
            byte[] secondBlock = new byte[512];
            fsStream.seek(512L);
            fsStream.readFully(secondBlock);
            GPTHeader gh = new GPTHeader(secondBlock, 0, 512);
            if (gh.isValid()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }
}
