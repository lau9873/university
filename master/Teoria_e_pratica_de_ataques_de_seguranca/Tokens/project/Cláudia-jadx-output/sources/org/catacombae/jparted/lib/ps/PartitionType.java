package org.catacombae.jparted.lib.ps;

import org.catacombae.jparted.lib.fs.FileSystemMajorType;
import org.catacombae.jparted.lib.ps.container.ContainerType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/PartitionType.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/PartitionType.class */
public enum PartitionType {
    EMPTY(ContentType.OTHER),
    FAT12(ContentType.FILE_SYSTEM, FileSystemMajorType.FAT12),
    FAT16(ContentType.FILE_SYSTEM, FileSystemMajorType.FAT16),
    FAT32(ContentType.FILE_SYSTEM, FileSystemMajorType.FAT32),
    DOS_EXTENDED(ContentType.PARTITION_SYSTEM, PartitionSystemType.DOS_EXTENDED),
    NT_OS2_IFS(ContentType.CONTAINER, ContainerType.NT_OS2_IFS),
    APPLE_PARTITION_MAP(ContentType.OTHER),
    APPLE_DRIVER(ContentType.OTHER),
    APPLE_DRIVER43(ContentType.OTHER),
    APPLE_MFS(ContentType.FILE_SYSTEM, FileSystemMajorType.APPLE_MFS),
    APPLE_HFS_CONTAINER(ContentType.CONTAINER, ContainerType.APPLE_HFS),
    APPLE_HFSX(ContentType.FILE_SYSTEM, FileSystemMajorType.APPLE_HFSX),
    APPLE_UNIX_SVR2(ContentType.CONTAINER, ContainerType.APPLE_UNIX_SVR2),
    APPLE_UFS(ContentType.FILE_SYSTEM, FileSystemMajorType.APPLE_UFS),
    APPLE_PRODOS(ContentType.FILE_SYSTEM, FileSystemMajorType.APPLE_PRODOS),
    LINUX_LVM(ContentType.PARTITION_SYSTEM),
    LINUX_SWAP(ContentType.OTHER),
    LINUX_NATIVE(ContentType.CONTAINER, ContainerType.LINUX_NATIVE),
    GPT_PROTECTIVE(ContentType.PARTITION_SYSTEM),
    EFI_SYSTEM(ContentType.FILE_SYSTEM),
    SPECIAL(ContentType.OTHER),
    UNKNOWN(ContentType.OTHER);
    
    private final ContentType contentType;
    private FileSystemMajorType fsType;
    private PartitionSystemType psType;
    private ContainerType containerType;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/PartitionType$ContentType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/PartitionType$ContentType.class */
    public enum ContentType {
        FILE_SYSTEM,
        PARTITION_SYSTEM,
        CONTAINER,
        OTHER
    }

    PartitionType(ContentType contentType) {
        this.fsType = null;
        this.psType = null;
        this.containerType = null;
        this.contentType = contentType;
    }

    PartitionType(ContentType contentType, FileSystemMajorType fsType) {
        this(contentType);
        if (contentType != ContentType.FILE_SYSTEM) {
            throw new RuntimeException("Wrong content type for constructor.");
        }
        this.fsType = fsType;
    }

    PartitionType(ContentType contentType, PartitionSystemType psType) {
        this(contentType);
        if (contentType != ContentType.PARTITION_SYSTEM) {
            throw new RuntimeException("Wrong content type for constructor.");
        }
        this.psType = psType;
    }

    PartitionType(ContentType contentType, ContainerType containerType) {
        this(contentType);
        if (contentType != ContentType.CONTAINER) {
            throw new RuntimeException("Wrong content type for constructor.");
        }
        this.containerType = containerType;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public FileSystemMajorType getAssociatedFileSystemType() {
        if (this.contentType != ContentType.FILE_SYSTEM) {
            throw new RuntimeException("Trying to get the file system type for non file system content!");
        }
        return this.fsType;
    }

    public PartitionSystemType getAssociatedPartitionSystemType() {
        if (this.contentType != ContentType.PARTITION_SYSTEM) {
            throw new RuntimeException("Trying to get the partition system type for non partition system content!");
        }
        return this.psType;
    }

    public ContainerType getAssociatedContainerType() {
        if (this.contentType != ContentType.CONTAINER) {
            throw new RuntimeException("Trying to get the container type for non container content!");
        }
        return this.containerType;
    }
}
