package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import java.util.LinkedList;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/MasterBootRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/MasterBootRecord.class */
public class MasterBootRecord {
    public static final short MBR_SIGNATURE = 21930;
    public static final int IBM_EXTENDED_DATA_OFFSET = 394;
    public static final int OPTIONAL_DISK_SIGNATURE_OFFSET = 440;
    public static final int MBR_PARTITIONS_OFFSET = 446;
    protected final byte[] reserved1;
    protected final byte[] optIBMExtendedData1;
    protected final byte[] optIBMExtendedData2;
    protected final byte[] optIBMExtendedData3;
    protected final byte[] optIBMExtendedData4;
    protected final byte[] reserved2;
    protected final byte[] optDiskSignature;
    protected final byte[] reserved3;
    protected final MBRPartition[] partitions;
    protected final byte[] mbrSignature;
    private final LinkedList<Partition> tempList;

    public MasterBootRecord(byte[] data, int offset, int sectorSize) {
        this.reserved1 = new byte[394];
        this.optIBMExtendedData1 = new byte[9];
        this.optIBMExtendedData2 = new byte[9];
        this.optIBMExtendedData3 = new byte[9];
        this.optIBMExtendedData4 = new byte[9];
        this.reserved2 = new byte[10];
        this.optDiskSignature = new byte[4];
        this.reserved3 = new byte[2];
        this.partitions = new MBRPartition[4];
        this.mbrSignature = new byte[2];
        this.tempList = new LinkedList<>();
        System.arraycopy(data, offset + 0, this.reserved1, 0, this.reserved1.length);
        System.arraycopy(data, offset + 394 + 0, this.optIBMExtendedData1, 0, 9);
        System.arraycopy(data, offset + 394 + 9, this.optIBMExtendedData2, 0, 9);
        System.arraycopy(data, offset + 394 + 18, this.optIBMExtendedData3, 0, 9);
        System.arraycopy(data, offset + 394 + 27, this.optIBMExtendedData4, 0, 9);
        System.arraycopy(data, offset + 430, this.reserved2, 0, this.reserved2.length);
        System.arraycopy(data, offset + 440, this.optDiskSignature, 0, 4);
        System.arraycopy(data, offset + 444, this.reserved3, 0, this.reserved3.length);
        for (int i2 = 0; i2 < 4; i2++) {
            this.partitions[i2] = new MBRPartition(data, offset + 446 + (i2 * 16), sectorSize);
        }
        System.arraycopy(data, offset + 446 + 64, this.mbrSignature, 0, 2);
        if (!Util.arrayRegionsEqual(getBytes(), 0, getStructSize(), data, offset, getStructSize())) {
            throw new RuntimeException("Internal error!");
        }
    }

    public MasterBootRecord(MasterBootRecord source) {
        this.reserved1 = new byte[394];
        this.optIBMExtendedData1 = new byte[9];
        this.optIBMExtendedData2 = new byte[9];
        this.optIBMExtendedData3 = new byte[9];
        this.optIBMExtendedData4 = new byte[9];
        this.reserved2 = new byte[10];
        this.optDiskSignature = new byte[4];
        this.reserved3 = new byte[2];
        this.partitions = new MBRPartition[4];
        this.mbrSignature = new byte[2];
        this.tempList = new LinkedList<>();
        System.arraycopy(source.reserved1, 0, this.reserved1, 0, this.reserved1.length);
        System.arraycopy(source.optIBMExtendedData1, 0, this.optIBMExtendedData1, 0, this.optIBMExtendedData1.length);
        System.arraycopy(source.optIBMExtendedData2, 0, this.optIBMExtendedData2, 0, this.optIBMExtendedData2.length);
        System.arraycopy(source.optIBMExtendedData3, 0, this.optIBMExtendedData3, 0, this.optIBMExtendedData3.length);
        System.arraycopy(source.optIBMExtendedData4, 0, this.optIBMExtendedData4, 0, this.optIBMExtendedData4.length);
        System.arraycopy(source.reserved2, 0, this.reserved2, 0, this.reserved2.length);
        System.arraycopy(source.optDiskSignature, 0, this.optDiskSignature, 0, this.optDiskSignature.length);
        System.arraycopy(source.reserved3, 0, this.reserved3, 0, this.reserved3.length);
        for (int i2 = 0; i2 < 4; i2++) {
            this.partitions[i2] = new MBRPartition(source.partitions[i2]);
        }
        System.arraycopy(source.mbrSignature, 0, this.mbrSignature, 0, this.mbrSignature.length);
    }

    public static int getStructSize() {
        return 512;
    }

    public byte[] getOptionalIBMExtendedData1() {
        return Util.createCopy(this.optIBMExtendedData1);
    }

    public byte[] getOptionalIBMExtendedData2() {
        return Util.createCopy(this.optIBMExtendedData2);
    }

    public byte[] getOptionalIBMExtendedData3() {
        return Util.createCopy(this.optIBMExtendedData3);
    }

    public byte[] getOptionalIBMExtendedData4() {
        return Util.createCopy(this.optIBMExtendedData4);
    }

    public int getOptionalDiskSignature() {
        return Util.readIntBE(this.optDiskSignature);
    }

    public MBRPartition[] getPartitions() {
        MBRPartition[] result = new MBRPartition[this.partitions.length];
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = this.partitions[i2];
        }
        return result;
    }

    public short getMBRSignature() {
        return Util.readShortBE(this.mbrSignature);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " diskSignature: 0x" + Util.toHexStringBE(getOptionalDiskSignature()) + " (optional, and possibly incorrect)");
        ps.println(prefix + " partitions:");
        for (int i2 = 0; i2 < this.partitions.length; i2++) {
            ps.println(prefix + "  [" + i2 + "]:");
            if (this.partitions[i2].isValid()) {
                this.partitions[i2].print(ps, prefix + "   ");
            } else {
                ps.println(prefix + "   [Invalid data]");
            }
        }
        ps.println(prefix + " mbrSignature: 0x" + Util.toHexStringBE(getMBRSignature()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix);
    }

    public boolean isValid() {
        return getMBRSignature() == 21930 && getValidPartitionCount() == 4;
    }

    public int getPartitionCount() {
        return this.partitions.length;
    }

    public int getValidPartitionCount() {
        int num = 0;
        MBRPartition[] arr$ = getPartitions();
        for (MBRPartition mp : arr$) {
            if (mp.isValid()) {
                num++;
            }
        }
        return num;
    }

    public int getUsedPartitionCount() {
        int num = 0;
        MBRPartition[] arr$ = getPartitions();
        for (MBRPartition mp : arr$) {
            if (mp.isUsed()) {
                num++;
            }
        }
        return num;
    }

    public Partition[] getPartitionEntries() {
        return getPartitions();
    }

    public Partition getPartitionEntry(int index) {
        MBRPartition p = this.partitions[index];
        if (p.isValid()) {
            return p;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public Partition[] getUsedPartitionEntries() {
        this.tempList.clear();
        MBRPartition[] arr$ = getPartitions();
        for (MBRPartition mp : arr$) {
            if (mp.isUsed()) {
                this.tempList.addLast(mp);
            }
        }
        return (Partition[]) this.tempList.toArray(new Partition[this.tempList.size()]);
    }

    public byte[] getBytes() {
        byte[] result = new byte[512];
        System.arraycopy(this.reserved1, 0, result, 0, this.reserved1.length);
        int i2 = 0 + this.reserved1.length;
        System.arraycopy(this.optIBMExtendedData1, 0, result, i2, this.optIBMExtendedData1.length);
        int i3 = i2 + this.optIBMExtendedData1.length;
        System.arraycopy(this.optIBMExtendedData2, 0, result, i3, this.optIBMExtendedData2.length);
        int i4 = i3 + this.optIBMExtendedData2.length;
        System.arraycopy(this.optIBMExtendedData3, 0, result, i4, this.optIBMExtendedData3.length);
        int i5 = i4 + this.optIBMExtendedData3.length;
        System.arraycopy(this.optIBMExtendedData4, 0, result, i5, this.optIBMExtendedData4.length);
        int i6 = i5 + this.optIBMExtendedData4.length;
        System.arraycopy(this.reserved2, 0, result, i6, this.reserved2.length);
        int i7 = i6 + this.reserved2.length;
        System.arraycopy(this.optDiskSignature, 0, result, i7, this.optDiskSignature.length);
        int i8 = i7 + this.optDiskSignature.length;
        System.arraycopy(this.reserved3, 0, result, i8, this.reserved3.length);
        int i9 = i8 + this.reserved3.length;
        for (int j = 0; j < this.partitions.length; j++) {
            byte[] curData = this.partitions[j].getBytes();
            System.arraycopy(curData, 0, result, i9, curData.length);
            i9 += curData.length;
        }
        System.arraycopy(this.mbrSignature, 0, result, i9, this.mbrSignature.length);
        if (i9 + this.mbrSignature.length != result.length) {
            throw new RuntimeException("Internal error!");
        }
        return result;
    }
}
