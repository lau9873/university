package org.catacombae.hfsexplorer.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/ProgressMonitor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/ProgressMonitor.class */
public interface ProgressMonitor {
    void signalCancel();

    boolean cancelSignaled();

    void confirmCancel();

    void addDataProgress(long j);
}
