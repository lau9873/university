package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import java.util.Hashtable;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.jparted.lib.ps.PartitionType;
import org.catacombae.jparted.lib.ps.mbr.MBRPartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/MBRPartition.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/MBRPartition.class */
public class MBRPartition implements Partition {
    protected static final byte PARTITION_NOT_BOOTABLE = 0;
    protected static final byte PARTITION_BOOTABLE = Byte.MIN_VALUE;
    private static final Hashtable<Byte, MBRPartitionType> byteMap = new Hashtable<>();
    protected final byte[] status;
    protected final byte[] firstSector;
    protected final byte[] partitionType;
    protected final byte[] lastSector;
    protected final byte[] lbaFirstSector;
    protected final byte[] lbaPartitionLength;
    private final int sectorSize;

    public MBRPartition(byte[] data, int offset, int sectorSize) {
        this(sectorSize);
        System.arraycopy(data, offset + 0, this.status, 0, 1);
        System.arraycopy(data, offset + 1, this.firstSector, 0, 3);
        System.arraycopy(data, offset + 4, this.partitionType, 0, 1);
        System.arraycopy(data, offset + 5, this.lastSector, 0, 3);
        System.arraycopy(data, offset + 8, this.lbaFirstSector, 0, 4);
        System.arraycopy(data, offset + 12, this.lbaPartitionLength, 0, 4);
    }

    protected MBRPartition(int sectorSize) {
        this.status = new byte[1];
        this.firstSector = new byte[3];
        this.partitionType = new byte[1];
        this.lastSector = new byte[3];
        this.lbaFirstSector = new byte[4];
        this.lbaPartitionLength = new byte[4];
        this.sectorSize = sectorSize;
    }

    public MBRPartition(MBRPartition source) {
        this(source, source.sectorSize);
    }

    public MBRPartition(MBRPartition source, int sectorSize) {
        this(sectorSize);
        System.arraycopy(source.status, 0, this.status, 0, 1);
        System.arraycopy(source.firstSector, 0, this.firstSector, 0, 3);
        System.arraycopy(source.partitionType, 0, this.partitionType, 0, 1);
        System.arraycopy(source.lastSector, 0, this.lastSector, 0, 3);
        System.arraycopy(source.lbaFirstSector, 0, this.lbaFirstSector, 0, 4);
        System.arraycopy(source.lbaPartitionLength, 0, this.lbaPartitionLength, 0, 4);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public long getStartOffset() {
        return Util.unsign(getLBAFirstSector()) * this.sectorSize;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public long getLength() {
        return Util.unsign(getLBAPartitionLength()) * this.sectorSize;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public PartitionType getType() {
        return getPartitionTypeAsEnum().getGeneralType();
    }

    public byte getStatus() {
        return Util.readByteLE(this.status);
    }

    public byte[] getFirstSector() {
        return Util.createCopy(this.firstSector);
    }

    public byte getPartitionType() {
        return Util.readByteLE(this.partitionType);
    }

    public byte[] getLastSector() {
        return Util.createCopy(this.lastSector);
    }

    public int getLBAFirstSector() {
        return Util.readIntLE(this.lbaFirstSector);
    }

    public int getLBAPartitionLength() {
        return Util.readIntLE(this.lbaPartitionLength);
    }

    public MBRPartitionType getPartitionTypeAsEnum() {
        return MBRPartitionType.fromMBRType(getPartitionType());
    }

    public boolean isBootable() {
        return getStatus() == Byte.MIN_VALUE;
    }

    public boolean isValid() {
        int beginLBA = getLBAFirstSector();
        byte[] beginCHS = getFirstSector();
        int i2 = beginCHS[1] & 63;
        byte b2 = beginCHS[0];
        int i3 = (((beginCHS[1] & 192) >> 6) * 255) + beginCHS[2];
        int lBAPartitionLength = (beginLBA + getLBAPartitionLength()) - 1;
        byte[] endCHS = getLastSector();
        int i4 = endCHS[1] & 63;
        byte b3 = endCHS[0];
        int i5 = (((endCHS[1] & 192) >> 6) * 255) + endCHS[2];
        byte statusByte = getStatus();
        return statusByte == 0 || statusByte == Byte.MIN_VALUE;
    }

    public boolean isUsed() {
        return isValid() && getPartitionTypeAsEnum() != MBRPartitionType.UNUSED;
    }

    public String toString() {
        MBRPartitionType mpt = getPartitionTypeAsEnum();
        return (isBootable() ? "Bootable " : "") + "MBR Partition (" + mpt + (mpt == null ? " [0x" + Util.toHexStringBE(getPartitionType()) + "]" : "") + ")";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " status: 0x" + Util.toHexStringBE(getStatus()));
        ps.println(prefix + " firstSector: 0x" + Util.byteArrayToHexString(getFirstSector()));
        ps.println(prefix + " partitionType: 0x" + Util.toHexStringBE(getPartitionType()) + " (" + getPartitionTypeAsEnum().toString() + ")");
        ps.println(prefix + " lastSector: 0x" + Util.byteArrayToHexString(getLastSector()));
        ps.println(prefix + " lbaFirstSector: " + Util.unsign(getLBAFirstSector()));
        ps.println(prefix + " lbaPartitionLength: " + Util.unsign(getLBAPartitionLength()));
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[16];
        System.arraycopy(this.status, 0, result, 0, this.status.length);
        int i2 = 0 + this.status.length;
        System.arraycopy(this.firstSector, 0, result, i2, this.firstSector.length);
        int i3 = i2 + this.firstSector.length;
        System.arraycopy(this.partitionType, 0, result, i3, this.partitionType.length);
        int i4 = i3 + this.partitionType.length;
        System.arraycopy(this.lastSector, 0, result, i4, this.lastSector.length);
        int i5 = i4 + this.lastSector.length;
        System.arraycopy(this.lbaFirstSector, 0, result, i5, this.lbaFirstSector.length);
        int i6 = i5 + this.lbaFirstSector.length;
        System.arraycopy(this.lbaPartitionLength, 0, result, i6, this.lbaPartitionLength.length);
        if (i6 + this.lbaPartitionLength.length != result.length) {
            throw new RuntimeException("Internal error!");
        }
        return result;
    }
}
