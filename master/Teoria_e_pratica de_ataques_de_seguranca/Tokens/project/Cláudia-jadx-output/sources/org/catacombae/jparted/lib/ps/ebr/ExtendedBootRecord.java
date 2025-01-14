package org.catacombae.jparted.lib.ps.ebr;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/ebr/ExtendedBootRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/ebr/ExtendedBootRecord.class */
public class ExtendedBootRecord {
    public static final short MBR_SIGNATURE = 21930;
    protected final byte[] reserved1;
    protected final byte[] optIBMBootmgrEntry;
    protected final byte[] reserved2;
    protected final byte[] optDiskSignature;
    protected final byte[] reserved3;
    protected final EBRPartition firstEntry;
    protected final EBRPartition secondEntry;
    protected final byte[] reserved4;
    protected final byte[] mbrSignature;

    public ExtendedBootRecord(byte[] data, int offset, long extendedPartitionOffset, long thisRecordOffset, int sectorSize) {
        this.reserved1 = new byte[394];
        this.optIBMBootmgrEntry = new byte[9];
        this.reserved2 = new byte[37];
        this.optDiskSignature = new byte[4];
        this.reserved3 = new byte[2];
        this.reserved4 = new byte[32];
        this.mbrSignature = new byte[2];
        System.arraycopy(data, offset + 0, this.reserved1, 0, this.reserved1.length);
        System.arraycopy(data, offset + 394, this.optIBMBootmgrEntry, 0, this.optIBMBootmgrEntry.length);
        System.arraycopy(data, offset + 403, this.reserved2, 0, this.reserved2.length);
        System.arraycopy(data, offset + 440, this.optDiskSignature, 0, this.optDiskSignature.length);
        System.arraycopy(data, offset + 444, this.reserved3, 0, this.reserved3.length);
        this.firstEntry = new EBRPartition(data, offset + 446, thisRecordOffset, sectorSize);
        this.secondEntry = new EBRPartition(data, offset + 462, extendedPartitionOffset, sectorSize);
        System.arraycopy(data, offset + 478, this.reserved4, 0, this.reserved4.length);
        System.arraycopy(data, offset + 510, this.mbrSignature, 0, this.mbrSignature.length);
        if (!Util.arrayRegionsEqual(getBytes(), 0, getStructSize(), data, offset, getStructSize())) {
            throw new RuntimeException("Internal error!");
        }
    }

    public ExtendedBootRecord(ExtendedBootRecord source) {
        this.reserved1 = new byte[394];
        this.optIBMBootmgrEntry = new byte[9];
        this.reserved2 = new byte[37];
        this.optDiskSignature = new byte[4];
        this.reserved3 = new byte[2];
        this.reserved4 = new byte[32];
        this.mbrSignature = new byte[2];
        System.arraycopy(source.reserved1, 0, this.reserved1, 0, this.reserved1.length);
        System.arraycopy(source.optIBMBootmgrEntry, 0, this.optIBMBootmgrEntry, 0, this.optIBMBootmgrEntry.length);
        System.arraycopy(source.reserved2, 0, this.reserved2, 0, this.reserved2.length);
        System.arraycopy(source.optDiskSignature, 0, this.optDiskSignature, 0, this.optDiskSignature.length);
        System.arraycopy(source.reserved3, 0, this.reserved3, 0, this.reserved3.length);
        this.firstEntry = new EBRPartition(source.firstEntry);
        this.secondEntry = new EBRPartition(source.secondEntry);
        System.arraycopy(source.reserved4, 0, this.reserved3, 0, this.reserved4.length);
        System.arraycopy(source.mbrSignature, 0, this.mbrSignature, 0, this.mbrSignature.length);
    }

    public static int getStructSize() {
        return 512;
    }

    public byte[] getOptionalIBMBootManagerEntry() {
        return Util.createCopy(this.optIBMBootmgrEntry);
    }

    public int getOptionalDiskSignature() {
        return Util.readIntBE(this.optDiskSignature);
    }

    public EBRPartition getFirstEntry() {
        return this.firstEntry;
    }

    public EBRPartition getSecondEntry() {
        return this.secondEntry;
    }

    public short getMBRSignature() {
        return Util.readShortBE(this.mbrSignature);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " diskSignature: 0x" + Util.toHexStringBE(getOptionalDiskSignature()) + " (optional, and possibly incorrect)");
        ps.println(prefix + " firstEntry:");
        if (this.firstEntry.isValid()) {
            this.firstEntry.print(ps, prefix + "  ");
        } else {
            ps.println(prefix + "  [Invalid data]");
        }
        ps.println(prefix + " secondEntry:");
        if (this.secondEntry.isValid()) {
            this.secondEntry.print(ps, prefix + "  ");
        } else {
            ps.println(prefix + "  [Invalid data]");
        }
        ps.println(prefix + " mbrSignature: 0x" + Util.toHexStringBE(getMBRSignature()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix);
    }

    public boolean isValid() {
        return getMBRSignature() == 21930 && isPartitionInfoValid();
    }

    public boolean isPartitionInfoValid() {
        if (!this.firstEntry.isValid() || !this.secondEntry.isValid()) {
            return false;
        }
        return true;
    }

    public byte[] getBytes() {
        byte[] result = new byte[512];
        System.arraycopy(this.reserved1, 0, result, 0, this.reserved1.length);
        int i2 = 0 + this.reserved1.length;
        System.arraycopy(this.optIBMBootmgrEntry, 0, result, i2, this.optIBMBootmgrEntry.length);
        int i3 = i2 + this.optIBMBootmgrEntry.length;
        System.arraycopy(this.reserved2, 0, result, i3, this.reserved2.length);
        int i4 = i3 + this.reserved2.length;
        System.arraycopy(this.optDiskSignature, 0, result, i4, this.optDiskSignature.length);
        int i5 = i4 + this.optDiskSignature.length;
        System.arraycopy(this.reserved3, 0, result, i5, this.reserved3.length);
        int i6 = i5 + this.reserved3.length;
        byte[] curData = this.firstEntry.getBytes();
        System.arraycopy(curData, 0, result, i6, curData.length);
        int i7 = i6 + curData.length;
        byte[] curData2 = this.secondEntry.getBytes();
        System.arraycopy(curData2, 0, result, i7, curData2.length);
        int i8 = i7 + curData2.length;
        System.arraycopy(this.reserved4, 0, result, i8, this.reserved4.length);
        int i9 = i8 + this.reserved4.length;
        System.arraycopy(this.mbrSignature, 0, result, i9, this.mbrSignature.length);
        if (i9 + this.mbrSignature.length != result.length) {
            throw new RuntimeException("Internal error!");
        }
        return result;
    }

    public boolean isTerminator() {
        return this.secondEntry.getLBAFirstSector() == 0 && this.secondEntry.getLBAPartitionLength() == 0;
    }
}
