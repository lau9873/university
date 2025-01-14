package org.catacombae.jparted.lib.ps.container;

import org.catacombae.jparted.lib.fs.FileSystemMajorType;
import org.catacombae.jparted.lib.ps.PartitionSystemType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/container/ContainerHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/container/ContainerHandler.class */
public abstract class ContainerHandler {
    public abstract boolean containsFileSystem();

    public abstract boolean containsPartitionSystem();

    public abstract boolean containsContainer();

    public abstract FileSystemMajorType detectFileSystemType();

    public abstract PartitionSystemType detectPartitionSystemType();

    public abstract ContainerType detectContainerType();
}
