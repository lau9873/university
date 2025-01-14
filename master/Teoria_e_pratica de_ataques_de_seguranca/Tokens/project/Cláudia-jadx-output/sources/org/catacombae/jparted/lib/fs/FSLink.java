package org.catacombae.jparted.lib.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSLink.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSLink.class */
public abstract class FSLink extends FSEntry {
    public abstract FSEntry getLinkTarget(String[] strArr);

    public abstract String getLinkTargetString();

    /* JADX INFO: Access modifiers changed from: protected */
    public FSLink(FileSystemHandler parentFileSystem) {
        super(parentFileSystem);
    }
}
