package org.catacombae.jparted.lib.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSFile.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSFile.class */
public abstract class FSFile extends FSEntry {
    public abstract FSFork getMainFork();

    public abstract FSFork[] getAllForks();

    public abstract FSFork getForkByType(FSForkType fSForkType);

    public abstract long getCombinedLength();

    /* JADX INFO: Access modifiers changed from: protected */
    public FSFile(FileSystemHandler iParentFileSystem) {
        super(iParentFileSystem);
    }
}
