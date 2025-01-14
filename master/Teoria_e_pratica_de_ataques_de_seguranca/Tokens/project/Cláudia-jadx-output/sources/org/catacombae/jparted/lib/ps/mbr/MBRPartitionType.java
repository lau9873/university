package org.catacombae.jparted.lib.ps.mbr;

import java.util.HashMap;
import org.catacombae.jparted.lib.ps.PartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/mbr/MBRPartitionType.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/mbr/MBRPartitionType.class */
public enum MBRPartitionType {
    UNUSED((byte) 0, PartitionType.EMPTY),
    FAT12((byte) 1, PartitionType.FAT12),
    FAT16_SMALL((byte) 4, PartitionType.FAT16),
    DOS_EXTENDED((byte) 5, PartitionType.DOS_EXTENDED),
    FAT16_LARGE((byte) 6, PartitionType.FAT16),
    NT_INSTALLABLE_FS((byte) 7, PartitionType.NT_OS2_IFS),
    FAT32((byte) 11, PartitionType.FAT32),
    FAT32_INT13HX((byte) 12, PartitionType.FAT32),
    FAT16_LARGE_INT13HX((byte) 14, PartitionType.FAT16),
    DOS_EXTENDED_INT13HX((byte) 15, PartitionType.DOS_EXTENDED),
    EISA_OR_OEM((byte) 18, PartitionType.SPECIAL),
    DYNAMIC_VOLUME((byte) 66, PartitionType.SPECIAL),
    PM_HIBERNATION((byte) -124, PartitionType.SPECIAL),
    NT_MULTIDISK_FAT16((byte) -122, PartitionType.SPECIAL),
    NT_MULTIDISK_NTFS((byte) -121, PartitionType.SPECIAL),
    LAPTOP_HIBERNATION((byte) -96, PartitionType.SPECIAL),
    DELL_OEM((byte) -34, PartitionType.SPECIAL),
    IBM_OEM((byte) -2, PartitionType.SPECIAL),
    GPT_PROTECTIVE((byte) -18, PartitionType.GPT_PROTECTIVE),
    EFI_SYSTEM_ON_MBR((byte) -17, PartitionType.EFI_SYSTEM),
    APPLE_UFS((byte) -88, PartitionType.APPLE_UFS),
    APPLE_HFS((byte) -81, PartitionType.APPLE_HFS_CONTAINER),
    LINUX_SWAP((byte) -126, PartitionType.LINUX_SWAP),
    LINUX_NATIVE((byte) -125, PartitionType.LINUX_NATIVE),
    UNKNOWN;
    
    private static HashMap<Byte, MBRPartitionType> reverseLookupTable;
    private final Byte mbrType;
    private final PartitionType enumType;

    MBRPartitionType(byte mbrType, PartitionType enumType) {
        if (enumType == null) {
            throw new IllegalArgumentException("enumType == null");
        }
        this.mbrType = Byte.valueOf(mbrType);
        this.enumType = enumType;
        addReverseLookupReference(mbrType, this);
    }

    MBRPartitionType() {
        this.mbrType = null;
        this.enumType = null;
    }

    public Byte getMBRType() {
        return this.mbrType;
    }

    public PartitionType getGeneralType() {
        return this.enumType;
    }

    private static void addReverseLookupReference(byte b2, MBRPartitionType t) {
        if (reverseLookupTable == null) {
            reverseLookupTable = new HashMap<>();
        }
        reverseLookupTable.put(Byte.valueOf(b2), t);
    }

    public static MBRPartitionType fromMBRType(byte mbrType) {
        MBRPartitionType type = reverseLookupTable.get(Byte.valueOf(mbrType));
        if (type == null) {
            return UNKNOWN;
        }
        return type;
    }
}
