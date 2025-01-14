package org.catacombae.jparted.lib.ps.gpt;

import java.nio.LongBuffer;
import java.util.Hashtable;
import org.catacombae.jparted.lib.ps.PartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/gpt/GPTPartitionType.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/gpt/GPTPartitionType.class */
public enum GPTPartitionType {
    PARTITION_TYPE_UNUSED_ENTRY(0, 0, PartitionType.EMPTY),
    PARTITION_TYPE_EFI_SYSTEM(2914720392792298001L, -5022920268830553797L, PartitionType.EFI_SYSTEM),
    PARTITION_TYPE_MICROSOFT_RESERVED(1649383866886764621L, -9115856095032502866L, PartitionType.SPECIAL),
    PARTITION_TYPE_PRIMARY_PARTITION(-6728148131701509308L, -8664810549094737465L, PartitionType.NT_OS2_IFS),
    PARTITION_TYPE_LDM_METADATA(-6140648915462070206L, -8803725930641698893L, PartitionType.SPECIAL),
    PARTITION_TYPE_LDM_DATA(-6890336253131857329L, -4870586846993028691L, PartitionType.SPECIAL),
    PARTITION_TYPE_APPLE_HFS(23439698118617617L, -6192167804800340820L, PartitionType.APPLE_HFS_CONTAINER),
    UNKNOWN_PARTITION_TYPE;
    
    private static Hashtable<LongBuffer, GPTPartitionType> reverseLookupTable;
    private final Long typeGUIDMsb;
    private final Long typeGUIDLsb;
    private final PartitionType enumType;

    GPTPartitionType(long typeGUIDMsb, long typeGUIDLsb, PartitionType enumType) {
        this.typeGUIDMsb = Long.valueOf(typeGUIDMsb);
        this.typeGUIDLsb = Long.valueOf(typeGUIDLsb);
        this.enumType = enumType;
        addReverseLookupReference(LongBuffer.wrap(new long[]{typeGUIDMsb, typeGUIDLsb}), this);
    }

    GPTPartitionType() {
        this.typeGUIDMsb = null;
        this.typeGUIDLsb = null;
        this.enumType = null;
    }

    private static void addReverseLookupReference(LongBuffer lb, GPTPartitionType t) {
        if (reverseLookupTable == null) {
            reverseLookupTable = new Hashtable<>();
        }
        reverseLookupTable.put(lb, t);
    }

    public static GPTPartitionType getType(long typeGUIDMsb, long typeGUIDLsb) {
        GPTPartitionType type = reverseLookupTable.get(LongBuffer.wrap(new long[]{typeGUIDMsb, typeGUIDLsb}));
        if (type != null) {
            return type;
        }
        return UNKNOWN_PARTITION_TYPE;
    }

    public byte[] getBytes() {
        if (this.typeGUIDMsb != null && this.typeGUIDLsb != null) {
            byte[] result = new byte[16];
            for (int i2 = 0; i2 < 8; i2++) {
                result[i2] = (byte) ((this.typeGUIDMsb.longValue() >> ((7 - i2) * 8)) & 255);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                result[8 + i3] = (byte) ((this.typeGUIDLsb.longValue() >> ((7 - i3) * 8)) & 255);
            }
            return result;
        }
        return null;
    }
}
