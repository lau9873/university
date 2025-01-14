package org.catacombae.udif;

import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import org.catacombae.dmgextractor.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/Koly.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/udif/Koly.class */
public class Koly {
    private static final int KOLY_FOURCC = 1802464377;
    private final byte[] fourCC = new byte[4];
    private final byte[] unknown1 = new byte[28];
    private final byte[] plistBegin1 = new byte[8];
    private final byte[] plistEndSometimes = new byte[8];
    private final byte[] unknown2 = new byte[8];
    private final byte[] unknown3 = new byte[8];
    private final byte[] unknown4 = new byte[8];
    private final byte[] unknown5 = new byte[8];
    private final byte[] possibleChecksumType = new byte[8];
    private final byte[] unknown6 = new byte[4];
    private final byte[] possibleUnitSize = new byte[4];
    private final byte[] unknown7 = new byte[120];
    private final byte[] plistBegin2 = new byte[8];
    private final byte[] plistSize = new byte[8];
    private final byte[] unknown8 = new byte[120];
    private final byte[] checksumAlgorithm = new byte[4];
    private final byte[] checksumSize = new byte[4];
    private final byte[] checksumData = new byte[152];

    public Koly(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.fourCC, 0, 4);
        System.arraycopy(data, offset + 4, this.unknown1, 0, 28);
        System.arraycopy(data, offset + 32, this.plistBegin1, 0, 8);
        System.arraycopy(data, offset + 40, this.plistEndSometimes, 0, 8);
        System.arraycopy(data, offset + 48, this.unknown2, 0, 8);
        System.arraycopy(data, offset + 56, this.unknown3, 0, 8);
        System.arraycopy(data, offset + 64, this.unknown4, 0, 8);
        System.arraycopy(data, offset + 72, this.unknown5, 0, 8);
        System.arraycopy(data, offset + 80, this.possibleChecksumType, 0, 8);
        System.arraycopy(data, offset + 88, this.unknown6, 0, 4);
        System.arraycopy(data, offset + 92, this.possibleUnitSize, 0, 4);
        System.arraycopy(data, offset + 96, this.unknown7, 0, 120);
        System.arraycopy(data, offset + 216, this.plistBegin2, 0, 8);
        System.arraycopy(data, offset + 224, this.plistSize, 0, 8);
        System.arraycopy(data, offset + 232, this.unknown8, 0, 120);
        System.arraycopy(data, offset + 352, this.checksumAlgorithm, 0, 4);
        System.arraycopy(data, offset + 356, this.checksumSize, 0, 4);
        System.arraycopy(data, offset + 360, this.checksumData, 0, 152);
    }

    public static int length() {
        return 512;
    }

    public int getFourCC() {
        return Util.readIntBE(this.fourCC);
    }

    public byte[] getUnknown1() {
        return Util.createCopy(this.unknown1);
    }

    public long getPlistBegin1() {
        return Util.readLongBE(this.plistBegin1);
    }

    public long getPlistEndSometimes() {
        return Util.readLongBE(this.plistEndSometimes);
    }

    public long getUnknown2() {
        return Util.readLongBE(this.unknown2);
    }

    public long getUnknown3() {
        return Util.readLongBE(this.unknown3);
    }

    public long getUnknown4() {
        return Util.readLongBE(this.unknown4);
    }

    public long getUnknown5() {
        return Util.readLongBE(this.unknown5);
    }

    public long getPossibleChecksumType() {
        return Util.readLongBE(this.possibleChecksumType);
    }

    public int getUnknown6() {
        return Util.readIntBE(this.unknown6);
    }

    public int getPossibleUnitSize() {
        return Util.readIntBE(this.possibleUnitSize);
    }

    public byte[] getUnknown7() {
        return Util.createCopy(this.unknown7);
    }

    public long getPlistBegin2() {
        return Util.readLongBE(this.plistBegin2);
    }

    public long getPlistSize() {
        return Util.readLongBE(this.plistSize);
    }

    public byte[] getUnknown8() {
        return Util.createCopy(this.unknown8);
    }

    public int getChecksumAlgorithm() {
        return Util.readIntBE(this.checksumAlgorithm);
    }

    public int getChecksumSize() {
        return Util.readIntBE(this.checksumSize);
    }

    public byte[] getChecksumData() {
        return Util.createCopy(this.checksumData);
    }

    public boolean isValid() {
        return getFourCC() == 1802464377;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " fourCC: \"" + Util.toASCIIString(getFourCC()) + "\"");
        ps.println(prefix + " unknown1: 0x" + Util.byteArrayToHexString(getUnknown1()));
        ps.println(prefix + " plistBegin1: " + getPlistBegin1());
        ps.println(prefix + " plistEndSometimes: " + getPlistEndSometimes());
        ps.println(prefix + " unknown2: " + getUnknown2());
        ps.println(prefix + " unknown3: " + getUnknown3());
        ps.println(prefix + " unknown4: " + getUnknown4());
        ps.println(prefix + " unknown5: " + getUnknown5());
        ps.println(prefix + " possibleChecksumType: " + getPossibleChecksumType());
        ps.println(prefix + " unknown6: " + getUnknown6());
        ps.println(prefix + " possibleUnitSize: " + getPossibleUnitSize());
        ps.println(prefix + " unknown7: 0x" + Util.byteArrayToHexString(getUnknown7()));
        ps.println(prefix + " plistBegin2: " + getPlistBegin2());
        ps.println(prefix + " plistSize: " + getPlistSize());
        ps.println(prefix + " unknown8: 0x" + Util.byteArrayToHexString(getUnknown8()));
        ps.println(prefix + " checksumAlgorithm: " + getChecksumAlgorithm());
        int checksumSize = getChecksumSize() / 8;
        byte[] checksumData = getChecksumData();
        ps.println(prefix + " checksumSize: " + checksumSize);
        ps.println(prefix + " checksumData: 0x" + Util.byteArrayToHexString(checksumData, 0, checksumSize));
        int i2 = 0;
        while (i2 + 4 <= checksumData.length - checksumSize) {
            ps.println(prefix + " trailing data[" + i2 + "]: 0x " + Util.byteArrayToHexString(checksumData, checksumSize + i2, 4));
            i2 += 4;
        }
        int bytesLeft = (i2 + 4) - (checksumData.length - checksumSize);
        if (bytesLeft > 0 && bytesLeft < 4) {
            System.err.println("bytes left: " + bytesLeft);
            ps.println(prefix + " trailing data[" + i2 + "]: 0x " + Util.byteArrayToHexString(checksumData, checksumSize + i2, (i2 + 4) - (checksumData.length - checksumSize)));
        }
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "Koly:");
        printFields(ps, prefix);
    }

    public static void main(String[] args) throws IOException {
        byte[] kolyData = new byte[512];
        RandomAccessFile raf = new RandomAccessFile(args[0], "r");
        raf.seek(raf.length() - 512);
        if (raf.read(kolyData) != kolyData.length) {
            throw new RuntimeException("Could not read entire koly...");
        }
        raf.close();
        Koly k = new Koly(kolyData, 0);
        k.print(System.out, "");
    }
}
