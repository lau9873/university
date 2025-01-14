package org.catacombae.jparted.lib.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSFolder.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSFolder.class */
public abstract class FSFolder extends FSEntry {
    public abstract String[] list();

    public abstract FSEntry[] listEntries();

    public abstract FSEntry getChild(String str);

    public abstract long getValence();

    /* JADX INFO: Access modifiers changed from: protected */
    public FSFolder(FileSystemHandler iParentFileSystem) {
        super(iParentFileSystem);
    }
}
