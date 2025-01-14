package org.catacombae.jparted.lib.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/WindowsFileAttributes.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/WindowsFileAttributes.class */
public class WindowsFileAttributes {
    private static final int FILE_ATTRIBUTE_READONLY = 1;
    private static final int FILE_ATTRIBUTE_HIDDEN = 2;
    private static final int FILE_ATTRIBUTE_SYSTEM = 4;
    private static final int FILE_ATTRIBUTE_DIRECTORY = 16;
    private static final int FILE_ATTRIBUTE_ARCHIVE = 32;
    private static final int FILE_ATTRIBUTE_NORMAL = 128;
    private static final int FILE_ATTRIBUTE_TEMPORARY = 256;
    private static final int FILE_ATTRIBUTE_SPARSE_FILE = 512;
    private static final int FILE_ATTRIBUTE_REPARSE_POINT = 1024;
    private static final int FILE_ATTRIBUTE_COMPRESSED = 2048;
    private static final int FILE_ATTRIBUTE_ENCRYPTED = 16384;
    private static final int FILE_ATTRIBUTE_OFFLINE = 4096;
    private static final int FILE_ATTRIBUTE_VIRTUAL = 65536;
    private final int attributeDword;

    public WindowsFileAttributes(int iAttributeDword) {
        this.attributeDword = iAttributeDword;
    }

    public boolean isReadOnly() {
        return (this.attributeDword & 1) != 0;
    }

    public boolean isHidden() {
        return (this.attributeDword & 2) != 0;
    }

    public boolean isSystem() {
        return (this.attributeDword & 4) != 0;
    }

    public boolean isDirectory() {
        return (this.attributeDword & 16) != 0;
    }

    public boolean isArchive() {
        return (this.attributeDword & 32) != 0;
    }

    public boolean isNormal() {
        return (this.attributeDword & 128) != 0;
    }

    public boolean isTemporary() {
        return (this.attributeDword & 256) != 0;
    }

    public boolean isSparseFile() {
        return (this.attributeDword & 512) != 0;
    }

    public boolean isReparsePoint() {
        return (this.attributeDword & 1024) != 0;
    }

    public boolean isCompressed() {
        return (this.attributeDword & 2048) != 0;
    }

    public boolean isEncrypted() {
        return (this.attributeDword & 16384) != 0;
    }

    public boolean isOffline() {
        return (this.attributeDword & 4096) != 0;
    }

    public boolean isVirtual() {
        return (this.attributeDword & 65536) != 0;
    }
}
