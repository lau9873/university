package org.catacombae.hfsexplorer.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/NullProgressMonitor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/NullProgressMonitor.class */
public class NullProgressMonitor implements ProgressMonitor {
    private static final NullProgressMonitor INSTANCE = new NullProgressMonitor();

    public static NullProgressMonitor getInstance() {
        return INSTANCE;
    }

    @Override // org.catacombae.hfsexplorer.fs.ProgressMonitor
    public void signalCancel() {
    }

    @Override // org.catacombae.hfsexplorer.fs.ProgressMonitor
    public boolean cancelSignaled() {
        return false;
    }

    @Override // org.catacombae.hfsexplorer.fs.ProgressMonitor
    public void confirmCancel() {
    }

    @Override // org.catacombae.hfsexplorer.fs.ProgressMonitor
    public void addDataProgress(long dataSize) {
    }
}
