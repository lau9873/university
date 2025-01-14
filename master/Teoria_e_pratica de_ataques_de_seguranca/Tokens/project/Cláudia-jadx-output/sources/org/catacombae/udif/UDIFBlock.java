package org.catacombae.udif;

import org.catacombae.dmgextractor.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFBlock.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFBlock.class */
public class UDIFBlock implements Comparable<UDIFBlock> {
    public static final int BT_ADC = -2147483644;
    public static final int BT_ZLIB = -2147483643;
    public static final int BT_BZIP2 = -2147483642;
    public static final int BT_COPY = 1;
    public static final int BT_ZERO = 2;
    public static final int BT_ZERO2 = 0;
    public static final int BT_END = -1;
    public static final int BT_UNKNOWN = 2147483646;
    private static final String BT_ADC_STRING = "BT_ADC";
    private static final String BT_ZLIB_STRING = "BT_ZLIB";
    private static final String BT_BZIP2_STRING = "BT_BZIP2";
    private static final String BT_COPY_STRING = "BT_COPY";
    private static final String BT_ZERO_STRING = "BT_ZERO";
    private static final String BT_ZERO2_STRING = "BT_ZERO2";
    private static final String BT_END_STRING = "BT_END";
    private static final String BT_UNKNOWN_STRING = "BT_UNKNOWN";
    private final int blockType;
    private final int skipped;
    private final long outOffset;
    private final long outSize;
    private final long inOffset;
    private final long inSize;
    private final long outOffsetComp;
    private final long inOffsetComp;

    public UDIFBlock(byte[] data, int offset, long outOffsetComp, long inOffsetComp) {
        this(Util.readIntBE(data, offset + 0), Util.readIntBE(data, offset + 4), Util.readLongBE(data, offset + 8) * 512, Util.readLongBE(data, offset + 16) * 512, Util.readLongBE(data, offset + 24), Util.readLongBE(data, offset + 32), outOffsetComp, inOffsetComp);
    }

    public UDIFBlock(int blockType, int skipped, long outOffset, long outSize, long inOffset, long inSize, long outOffsetComp, long inOffsetComp) {
        this.blockType = blockType;
        this.skipped = skipped;
        this.outOffset = outOffset;
        this.outSize = outSize;
        this.inOffset = inOffset;
        this.inSize = inSize;
        this.outOffsetComp = outOffsetComp;
        this.inOffsetComp = inOffsetComp;
    }

    public static int structSize() {
        return 40;
    }

    public int getBlockType() {
        return this.blockType;
    }

    public int getSkipped() {
        return this.skipped;
    }

    public long getOutOffset() {
        return this.outOffset;
    }

    public long getOutSize() {
        return this.outSize;
    }

    public long getInOffset() {
        return this.inOffset;
    }

    public long getInSize() {
        return this.inSize;
    }

    public String getBlockTypeAsString() {
        switch (this.blockType) {
            case -2147483644:
                return "BT_ADC";
            case -2147483643:
                return "BT_ZLIB";
            case -2147483642:
                return "BT_BZIP2";
            case -1:
                return "BT_END";
            case 0:
                return "BT_ZERO2";
            case 1:
                return "BT_COPY";
            case 2:
                return "BT_ZERO";
            case 2147483646:
                return "BT_UNKNOWN";
            default:
                return "[Unknown block type! ID=0x" + Integer.toHexString(this.blockType) + "]";
        }
    }

    public long getOutOffsetCompensation() {
        return this.outOffsetComp;
    }

    public long getInOffsetCompensation() {
        return this.inOffsetComp;
    }

    public long getTrueOutOffset() {
        return this.outOffset + this.outOffsetComp;
    }

    public long getTrueInOffset() {
        return this.inOffset + this.inOffsetComp;
    }

    public String toString() {
        return getBlockTypeAsString() + "(skipped=0x" + Integer.toHexString(this.skipped) + ",outOffset=" + this.outOffset + ",outSize=" + this.outSize + ",inOffset=" + this.inOffset + ",inSize=" + this.inSize + ",outOffsetComp=" + this.outOffsetComp + ",inOffsetComp=" + this.inOffsetComp + ")";
    }

    public static long peekInOffset(byte[] data, int offset) {
        return Util.readLongBE(data, offset + 24);
    }

    public static long peekInSize(byte[] data, int offset) {
        return Util.readLongBE(data, offset + 32);
    }

    @Override // java.lang.Comparable
    public int compareTo(UDIFBlock db) {
        long res = getTrueInOffset() - db.getTrueInOffset();
        if (res > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (res < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
