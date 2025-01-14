package org.catacombae.hfsexplorer;

import org.catacombae.hfsexplorer.fs.NullProgressMonitor;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/BasicExtractProgressMonitor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/BasicExtractProgressMonitor.class */
public abstract class BasicExtractProgressMonitor extends NullProgressMonitor implements ExtractProgressMonitor {
    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void updateTotalProgress(double fraction, String message) {
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void updateCurrentDir(String dirname) {
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void updateCurrentFile(String filename, long fileSize) {
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void setDataSize(long totalSize) {
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void updateCalculateDir(String dirname) {
    }
}
