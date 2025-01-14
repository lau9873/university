package org.catacombae.jparted.lib.ps;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemImplementationInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemImplementationInfo.class */
public class PartitionSystemImplementationInfo {
    private String partitionSystemName;
    private String implementationName;
    private String implementationVersion;
    private String author;

    public PartitionSystemImplementationInfo(String partitionSystemName, String implementationName, String implementationVersion, String author) {
        this.partitionSystemName = partitionSystemName;
        this.implementationName = implementationName;
        this.implementationVersion = implementationVersion;
        this.author = author;
    }

    public String getPartitionSystemName() {
        return this.partitionSystemName;
    }

    public String getImplementationName() {
        return this.implementationName;
    }

    public String getImplementationVersion() {
        return this.implementationVersion;
    }

    public String getAuthor() {
        return this.author;
    }
}
