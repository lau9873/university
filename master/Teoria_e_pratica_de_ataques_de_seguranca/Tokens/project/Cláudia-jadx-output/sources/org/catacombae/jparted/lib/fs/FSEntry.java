package org.catacombae.jparted.lib.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSEntry.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSEntry.class */
public abstract class FSEntry {
    protected final FileSystemHandler parentFileSystem;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSEntry$Type.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSEntry$Type.class */
    public enum Type {
        FILE,
        FOLDER,
        SYMLINK,
        CHARACTER_DEVICE,
        BLOCK_DEVICE,
        FIFO,
        SOCKET
    }

    public abstract FSAttributes getAttributes();

    public abstract String getName();

    /* JADX INFO: Access modifiers changed from: protected */
    public FSEntry(FileSystemHandler iParentFileSystem) {
        this.parentFileSystem = iParentFileSystem;
    }

    protected FileSystemHandler getParentFileSystem() {
        return this.parentFileSystem;
    }

    public boolean isFile() {
        return this instanceof FSFile;
    }

    public boolean isFolder() {
        return this instanceof FSFolder;
    }

    public FSFile asFile() {
        if (this instanceof FSFile) {
            return (FSFile) this;
        }
        throw new RuntimeException("Not a file!");
    }

    public FSFolder asFolder() {
        if (this instanceof FSFolder) {
            return (FSFolder) this;
        }
        throw new RuntimeException("Not a folder!");
    }
}
