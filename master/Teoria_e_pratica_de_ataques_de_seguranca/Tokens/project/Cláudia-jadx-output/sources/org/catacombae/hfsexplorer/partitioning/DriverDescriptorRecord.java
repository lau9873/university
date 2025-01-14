package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/DriverDescriptorRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/DriverDescriptorRecord.class */
public class DriverDescriptorRecord {
    public static final short DDR_SIGNATURE = 17746;
    private final byte[] sbSig;
    private final byte[] sbBlkSize;
    private final byte[] sbBlkCount;
    private final byte[] reserved1;
    private final byte[] reserved2;
    private final byte[] reserved3;
    private final byte[] sbDrvrCount;
    private final DriverDescriptorEntry[] entries;
    private final byte[] ddPad;

    public DriverDescriptorRecord(ReadableRandomAccessStream llf, long offset) {
        this(readData(llf, offset), 0);
    }

    public DriverDescriptorRecord(byte[] data, int offset) {
        this.sbSig = new byte[2];
        this.sbBlkSize = new byte[2];
        this.sbBlkCount = new byte[4];
        this.reserved1 = new byte[2];
        this.reserved2 = new byte[2];
        this.reserved3 = new byte[4];
        this.sbDrvrCount = new byte[2];
        System.arraycopy(data, offset + 0, this.sbSig, 0, 2);
        System.arraycopy(data, offset + 2, this.sbBlkSize, 0, 2);
        System.arraycopy(data, offset + 4, this.sbBlkCount, 0, 4);
        System.arraycopy(data, offset + 8, this.reserved1, 0, 2);
        System.arraycopy(data, offset + 10, this.reserved2, 0, 2);
        System.arraycopy(data, offset + 12, this.reserved3, 0, 4);
        System.arraycopy(data, offset + 16, this.sbDrvrCount, 0, 2);
        int numEntries = Util.unsign(getSbDrvrCount());
        this.entries = new DriverDescriptorEntry[numEntries > 31 ? 31 : numEntries];
        int i2 = 0;
        while (i2 < this.entries.length) {
            this.entries[i2] = new DriverDescriptorEntry(data, offset + 18 + (DriverDescriptorEntry.length() * i2));
            i2++;
        }
        int padOffset = offset + 18 + (DriverDescriptorEntry.length() * i2);
        this.ddPad = new byte[length() - padOffset];
        System.arraycopy(data, padOffset, this.ddPad, 0, this.ddPad.length);
    }

    private static byte[] readData(ReadableRandomAccessStream llf, long offset) {
        byte[] data = new byte[length()];
        llf.seek(offset);
        if (llf.read(data) != data.length) {
            throw new RuntimeException("Could not read enough bytes from LowLevelFile!");
        }
        return data;
    }

    public static int length() {
        return 269;
    }

    public short getSbSig() {
        return Util.readShortBE(this.sbSig);
    }

    public short getSbBlkSize() {
        return Util.readShortBE(this.sbBlkSize);
    }

    public int getSbBlkCount() {
        return Util.readIntBE(this.sbBlkCount);
    }

    public short getReserved1() {
        return Util.readShortBE(this.reserved1);
    }

    public short getReserved2() {
        return Util.readShortBE(this.reserved2);
    }

    public int getReserved3() {
        return Util.readIntBE(this.reserved3);
    }

    public short getSbDrvrCount() {
        return Util.readShortBE(this.sbDrvrCount);
    }

    public DriverDescriptorEntry[] getDriverDecriptorEntries() {
        DriverDescriptorEntry[] result = new DriverDescriptorEntry[this.entries.length];
        System.arraycopy(this.entries, 0, result, 0, this.entries.length);
        return result;
    }

    public byte[] getDdPad() {
        return Util.createCopy(this.ddPad);
    }

    public String getSbSigAsString() {
        return Util.toASCIIString(this.sbSig);
    }

    public boolean isValid() {
        int driverCount = Util.unsign(getSbDrvrCount());
        return getSbSig() == 17746 && driverCount <= 31 && this.entries.length == driverCount;
    }

    public byte[] getData() {
        byte[] result = new byte[length()];
        System.arraycopy(this.sbSig, 0, result, 0, this.sbSig.length);
        int offset = 0 + this.sbSig.length;
        System.arraycopy(this.sbBlkSize, 0, result, offset, this.sbBlkSize.length);
        int offset2 = offset + this.sbBlkSize.length;
        System.arraycopy(this.sbBlkCount, 0, result, offset2, this.sbBlkCount.length);
        int offset3 = offset2 + this.sbBlkCount.length;
        System.arraycopy(this.reserved1, 0, result, offset3, this.reserved1.length);
        int offset4 = offset3 + this.reserved1.length;
        System.arraycopy(this.reserved2, 0, result, offset4, this.reserved2.length);
        int offset5 = offset4 + this.reserved2.length;
        System.arraycopy(this.reserved3, 0, result, offset5, this.reserved3.length);
        int offset6 = offset5 + this.reserved3.length;
        System.arraycopy(this.sbDrvrCount, 0, result, offset6, this.sbDrvrCount.length);
        int offset7 = offset6 + this.sbDrvrCount.length;
        DriverDescriptorEntry[] arr$ = this.entries;
        for (DriverDescriptorEntry dde : arr$) {
            byte[] tmp = dde.getData();
            System.arraycopy(tmp, 0, result, offset7, tmp.length);
            offset7 += tmp.length;
        }
        System.arraycopy(this.ddPad, 0, result, offset7, this.ddPad.length);
        if (offset7 + this.ddPad.length != length()) {
            throw new RuntimeException("Internal miscalculation...");
        }
        return result;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " sbSig: \"" + getSbSigAsString() + "\"");
        ps.println(prefix + " sbBlkSize: " + ((int) getSbBlkSize()));
        ps.println(prefix + " sbBlkCount: " + getSbBlkCount());
        ps.println(prefix + " reserved1: " + ((int) getReserved1()));
        ps.println(prefix + " reserved2: " + ((int) getReserved2()));
        ps.println(prefix + " reserved3: " + getReserved3());
        ps.println(prefix + " sbDrvrCount: " + ((int) getSbDrvrCount()));
        ps.println(prefix + " entries (" + this.entries.length + " elements):");
        for (int i2 = 0; i2 < this.entries.length; i2++) {
            ps.println(prefix + "  entries[" + i2 + "]: ");
            this.entries[i2].print(ps, prefix + "   ");
        }
        if (this.entries.length == 0) {
            ps.println(prefix + "  <empty>");
        }
        ps.println(prefix + " ddPad: {" + this.ddPad.length + " bytes...}");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "DriverDescriptorRecord:");
        printFields(ps, prefix);
    }
}
