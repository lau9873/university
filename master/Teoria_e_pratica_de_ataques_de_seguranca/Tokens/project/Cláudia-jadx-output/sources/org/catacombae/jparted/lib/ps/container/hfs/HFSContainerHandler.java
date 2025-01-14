package org.catacombae.jparted.lib.ps.container.hfs;

import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.fs.FileSystemMajorType;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFileSystemRecognizer;
import org.catacombae.jparted.lib.ps.PartitionSystemType;
import org.catacombae.jparted.lib.ps.container.ContainerHandler;
import org.catacombae.jparted.lib.ps.container.ContainerType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/container/hfs/HFSContainerHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/container/hfs/HFSContainerHandler.class */
public class HFSContainerHandler extends ContainerHandler {
    private static final short SIGNATURE_HFS = 16964;
    private static final short SIGNATURE_HFS_PLUS = 18475;
    private static final short SIGNATURE_HFSX = 18520;
    private DataLocator partitionData;

    public HFSContainerHandler(DataLocator partitionData) {
        this.partitionData = partitionData;
    }

    @Override // org.catacombae.jparted.lib.ps.container.ContainerHandler
    public boolean containsFileSystem() {
        return true;
    }

    @Override // org.catacombae.jparted.lib.ps.container.ContainerHandler
    public boolean containsPartitionSystem() {
        return false;
    }

    @Override // org.catacombae.jparted.lib.ps.container.ContainerHandler
    public boolean containsContainer() {
        return false;
    }

    @Override // org.catacombae.jparted.lib.ps.container.ContainerHandler
    public FileSystemMajorType detectFileSystemType() {
        this.partitionData.createReadOnlyFile();
        switch (HFSCommonFileSystemRecognizer.detectFileSystem(bitstream, 0L)) {
            case HFS:
                return FileSystemMajorType.APPLE_HFS;
            case HFS_PLUS:
            case HFS_WRAPPED_HFS_PLUS:
                return FileSystemMajorType.APPLE_HFS_PLUS;
            case HFSX:
                return FileSystemMajorType.APPLE_HFSX;
            case MFS:
            default:
                return FileSystemMajorType.UNKNOWN;
        }
    }

    @Override // org.catacombae.jparted.lib.ps.container.ContainerHandler
    public PartitionSystemType detectPartitionSystemType() {
        throw new UnsupportedOperationException("An HFS container does not contain partition systems.");
    }

    @Override // org.catacombae.jparted.lib.ps.container.ContainerHandler
    public ContainerType detectContainerType() {
        throw new UnsupportedOperationException("An HFS container does not contain other containers.");
    }
}
