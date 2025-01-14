package org.catacombae.jparted.lib.ps.apm;

import org.catacombae.jparted.lib.ps.PartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/apm/APMPartitionType.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/apm/APMPartitionType.class */
public enum APMPartitionType {
    APPLE_PARTITION_MAP("Apple_partition_map", PartitionType.APPLE_PARTITION_MAP),
    APPLE_DRIVER("Apple_Driver", PartitionType.APPLE_DRIVER),
    APPLE_DRIVER43("Apple_Driver43", PartitionType.APPLE_DRIVER),
    APPLE_MFS("Apple_MFS", PartitionType.APPLE_MFS),
    APPLE_HFS("Apple_HFS", PartitionType.APPLE_HFS_CONTAINER),
    APPLE_HFSX("Apple_HFSX", PartitionType.APPLE_HFSX),
    APPLE_UNIX_SVR2("Apple_Unix_SVR2", PartitionType.APPLE_UNIX_SVR2),
    APPLE_PRODOS("Apple_PRODOS", PartitionType.APPLE_PRODOS),
    APPLE_FREE("Apple_Free", PartitionType.EMPTY),
    APPLE_SCRATCH("Apple_Scratch", PartitionType.EMPTY);
    
    private final String apmName;
    private final PartitionType generalType;

    APMPartitionType(String apmName) {
        this(apmName, null);
    }

    APMPartitionType(String apmName, PartitionType generalType) {
        this.apmName = apmName;
        this.generalType = generalType;
    }

    public String getAPMName() {
        return this.apmName;
    }

    public PartitionType getGeneralType() {
        return this.generalType;
    }
}
