package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.jparted.lib.ps.PartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/APMPartition.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/APMPartition.class */
public class APMPartition implements Partition {
    private final byte[] pmSig = new byte[2];
    private final byte[] pmSigPad = new byte[2];
    private final byte[] pmMapBlkCnt = new byte[4];
    private final byte[] pmPyPartStart = new byte[4];
    private final byte[] pmPartBlkCnt = new byte[4];
    private final byte[] pmPartName = new byte[32];
    private final byte[] pmParType = new byte[32];
    private final byte[] pmLgDataStart = new byte[4];
    private final byte[] pmDataCnt = new byte[4];
    private final byte[] pmPartStatus = new byte[4];
    private final byte[] pmLgBootStart = new byte[4];
    private final byte[] pmBootSize = new byte[4];
    private final byte[] pmBootAddr = new byte[4];
    private final byte[] pmBootAddr2 = new byte[4];
    private final byte[] pmBootEntry = new byte[4];
    private final byte[] pmBootEntry2 = new byte[4];
    private final byte[] pmBootCksum = new byte[4];
    private final byte[] pmProcessor = new byte[16];
    private final byte[] pmPad = new byte[376];
    private final int blockSize;

    public APMPartition(byte[] data, int offset, int blockSize) {
        System.arraycopy(data, offset + 0, this.pmSig, 0, 2);
        System.arraycopy(data, offset + 2, this.pmSigPad, 0, 2);
        System.arraycopy(data, offset + 4, this.pmMapBlkCnt, 0, 4);
        System.arraycopy(data, offset + 8, this.pmPyPartStart, 0, 4);
        System.arraycopy(data, offset + 12, this.pmPartBlkCnt, 0, 4);
        System.arraycopy(data, offset + 16, this.pmPartName, 0, 32);
        System.arraycopy(data, offset + 48, this.pmParType, 0, 32);
        System.arraycopy(data, offset + 80, this.pmLgDataStart, 0, 4);
        System.arraycopy(data, offset + 84, this.pmDataCnt, 0, 4);
        System.arraycopy(data, offset + 88, this.pmPartStatus, 0, 4);
        System.arraycopy(data, offset + 92, this.pmLgBootStart, 0, 4);
        System.arraycopy(data, offset + 96, this.pmBootSize, 0, 4);
        System.arraycopy(data, offset + 100, this.pmBootAddr, 0, 4);
        System.arraycopy(data, offset + 104, this.pmBootAddr2, 0, 4);
        System.arraycopy(data, offset + 108, this.pmBootEntry, 0, 4);
        System.arraycopy(data, offset + 112, this.pmBootEntry2, 0, 4);
        System.arraycopy(data, offset + 116, this.pmBootCksum, 0, 4);
        System.arraycopy(data, offset + 120, this.pmProcessor, 0, 16);
        System.arraycopy(data, offset + 136, this.pmPad, 0, 376);
        this.blockSize = blockSize;
    }

    public static int structSize() {
        return 512;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public long getStartOffset() {
        return (Util.unsign(getPmPyPartStart()) + Util.unsign(getPmLgDataStart())) * this.blockSize;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public long getLength() {
        return Util.unsign(getPmDataCnt()) * this.blockSize;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public PartitionType getType() {
        return convertPartitionType(getPmParType());
    }

    public short getPmSig() {
        return Util.readShortBE(this.pmSig);
    }

    public short getPmSigPad() {
        return Util.readShortBE(this.pmSigPad);
    }

    public int getPmMapBlkCnt() {
        return Util.readIntBE(this.pmMapBlkCnt);
    }

    public int getPmPyPartStart() {
        return Util.readIntBE(this.pmPyPartStart);
    }

    public int getPmPartBlkCnt() {
        return Util.readIntBE(this.pmPartBlkCnt);
    }

    public byte[] getPmPartName() {
        return Util.createCopy(this.pmPartName);
    }

    public byte[] getPmParType() {
        return Util.createCopy(this.pmParType);
    }

    public int getPmLgDataStart() {
        return Util.readIntBE(this.pmLgDataStart);
    }

    public int getPmDataCnt() {
        return Util.readIntBE(this.pmDataCnt);
    }

    public int getPmPartStatus() {
        return Util.readIntBE(this.pmPartStatus);
    }

    public int getPmLgBootStart() {
        return Util.readIntBE(this.pmLgBootStart);
    }

    public int getPmBootSize() {
        return Util.readIntBE(this.pmBootSize);
    }

    public int getPmBootAddr() {
        return Util.readIntBE(this.pmBootAddr);
    }

    public int getPmBootAddr2() {
        return Util.readIntBE(this.pmBootAddr2);
    }

    public int getPmBootEntry() {
        return Util.readIntBE(this.pmBootEntry);
    }

    public int getPmBootEntry2() {
        return Util.readIntBE(this.pmBootEntry2);
    }

    public int getPmBootCksum() {
        return Util.readIntBE(this.pmBootCksum);
    }

    public byte[] getPmProcessor() {
        return Util.createCopy(this.pmProcessor);
    }

    public short[] getPmPad() {
        return Util.readShortArrayBE(this.pmPad);
    }

    public String getPmSigAsString() {
        return Util.toASCIIString(this.pmSig);
    }

    public String getPmPartNameAsString() {
        return Util.readNullTerminatedASCIIString(this.pmPartName);
    }

    public String getPmParTypeAsString() {
        return Util.readNullTerminatedASCIIString(this.pmParType);
    }

    public String getPmProcessorAsString() {
        return Util.readNullTerminatedASCIIString(this.pmProcessor);
    }

    public boolean isValid() {
        int pmSigInt = getPmSig() & 65535;
        if (pmSigInt != 20557 && pmSigInt != 21587) {
            return false;
        }
        return true;
    }

    public void printPartitionInfo(PrintStream ps) {
        printPartitionInfo(ps, "");
    }

    public void printPartitionInfo(PrintStream ps, String prefix) {
        ps.println(prefix + "pmSig: \"" + getPmSigAsString() + "\"");
        ps.println(prefix + "pmSigPad: " + ((int) getPmSigPad()));
        ps.println(prefix + "pmMapBlkCnt: " + getPmMapBlkCnt());
        ps.println(prefix + "pmPyPartStart: " + getPmPyPartStart());
        ps.println(prefix + "pmPartBlkCnt: " + getPmPartBlkCnt());
        ps.println(prefix + "pmPartName: \"" + getPmPartNameAsString() + "\"");
        ps.println(prefix + "pmParType: \"" + getPmParTypeAsString() + "\"");
        ps.println(prefix + "pmLgDataStart: " + getPmLgDataStart());
        ps.println(prefix + "pmDataCnt: " + getPmDataCnt());
        ps.println(prefix + "pmPartStatus: " + getPmPartStatus());
        ps.println(prefix + "pmLgBootStart: " + getPmLgBootStart());
        ps.println(prefix + "pmBootSize: " + getPmBootSize());
        ps.println(prefix + "pmBootAddr: " + getPmBootAddr());
        ps.println(prefix + "pmBootAddr2: " + getPmBootAddr2());
        ps.println(prefix + "pmBootEntry: " + getPmBootEntry());
        ps.println(prefix + "pmBootEntry2: " + getPmBootEntry2());
        ps.println(prefix + "pmBootCksum: " + getPmBootCksum());
        ps.println(prefix + "pmProcessor: \"" + getPmProcessorAsString() + "\"");
        ps.println(prefix + "pmPad: " + getPmPad());
    }

    public byte[] getData() {
        byte[] result = new byte[structSize()];
        System.arraycopy(this.pmSig, 0, result, 0, this.pmSig.length);
        int offset = 0 + this.pmSig.length;
        System.arraycopy(this.pmSigPad, 0, result, offset, this.pmSigPad.length);
        int offset2 = offset + this.pmSigPad.length;
        System.arraycopy(this.pmMapBlkCnt, 0, result, offset2, this.pmMapBlkCnt.length);
        int offset3 = offset2 + this.pmMapBlkCnt.length;
        System.arraycopy(this.pmPyPartStart, 0, result, offset3, this.pmPyPartStart.length);
        int offset4 = offset3 + this.pmPyPartStart.length;
        System.arraycopy(this.pmPartBlkCnt, 0, result, offset4, this.pmPartBlkCnt.length);
        int offset5 = offset4 + this.pmPartBlkCnt.length;
        System.arraycopy(this.pmPartName, 0, result, offset5, this.pmPartName.length);
        int offset6 = offset5 + this.pmPartName.length;
        System.arraycopy(this.pmParType, 0, result, offset6, this.pmParType.length);
        int offset7 = offset6 + this.pmParType.length;
        System.arraycopy(this.pmLgDataStart, 0, result, offset7, this.pmLgDataStart.length);
        int offset8 = offset7 + this.pmLgDataStart.length;
        System.arraycopy(this.pmDataCnt, 0, result, offset8, this.pmDataCnt.length);
        int offset9 = offset8 + this.pmDataCnt.length;
        System.arraycopy(this.pmPartStatus, 0, result, offset9, this.pmPartStatus.length);
        int offset10 = offset9 + this.pmPartStatus.length;
        System.arraycopy(this.pmLgBootStart, 0, result, offset10, this.pmLgBootStart.length);
        int offset11 = offset10 + this.pmLgBootStart.length;
        System.arraycopy(this.pmBootSize, 0, result, offset11, this.pmBootSize.length);
        int offset12 = offset11 + this.pmBootSize.length;
        System.arraycopy(this.pmBootAddr, 0, result, offset12, this.pmBootAddr.length);
        int offset13 = offset12 + this.pmBootAddr.length;
        System.arraycopy(this.pmBootAddr2, 0, result, offset13, this.pmBootAddr2.length);
        int offset14 = offset13 + this.pmBootAddr2.length;
        System.arraycopy(this.pmBootEntry, 0, result, offset14, this.pmBootEntry.length);
        int offset15 = offset14 + this.pmBootEntry.length;
        System.arraycopy(this.pmBootEntry2, 0, result, offset15, this.pmBootEntry2.length);
        int offset16 = offset15 + this.pmBootEntry2.length;
        System.arraycopy(this.pmBootCksum, 0, result, offset16, this.pmBootCksum.length);
        int offset17 = offset16 + this.pmBootCksum.length;
        System.arraycopy(this.pmProcessor, 0, result, offset17, this.pmProcessor.length);
        int offset18 = offset17 + this.pmProcessor.length;
        System.arraycopy(this.pmPad, 0, result, offset18, this.pmPad.length);
        if (offset18 + this.pmPad.length != result.length) {
            throw new RuntimeException("Internal miscalculation...");
        }
        return result;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public void printFields(PrintStream ps, String prefix) {
        printPartitionInfo(ps, prefix + " ");
        ps.println(prefix + " Partition methods: ");
        ps.println(prefix + "  getStartOffset(): " + getStartOffset());
        ps.println(prefix + "  getLength(): " + getLength());
        ps.println(prefix + "  getType(): " + getType());
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "APMPartition:");
        printFields(ps, prefix);
    }

    public String toString() {
        return "\"" + getPmPartNameAsString() + "\" (" + getPmParTypeAsString() + ")";
    }

    public PartitionType convertPartitionType(byte[] parTypeData) {
        String typeString = Util.readNullTerminatedASCIIString(parTypeData);
        if (typeString.equals("Apple_partition_map")) {
            return PartitionType.APPLE_PARTITION_MAP;
        }
        if (typeString.equals("Apple_Driver")) {
            return PartitionType.APPLE_DRIVER;
        }
        if (typeString.equals("Apple_Driver43")) {
            return PartitionType.APPLE_DRIVER43;
        }
        if (typeString.equals("Apple_MFS")) {
            return PartitionType.APPLE_MFS;
        }
        if (typeString.equals("Apple_HFS")) {
            return PartitionType.APPLE_HFS_CONTAINER;
        }
        if (typeString.equals("Apple_HFSX")) {
            return PartitionType.APPLE_HFSX;
        }
        if (typeString.equals("Apple_Unix_SVR2")) {
            return PartitionType.APPLE_UNIX_SVR2;
        }
        if (typeString.equals("Apple_PRODOS")) {
            return PartitionType.APPLE_PRODOS;
        }
        if (typeString.equals("Apple_Free")) {
            return PartitionType.EMPTY;
        }
        if (typeString.equals("Apple_Scratch")) {
            return PartitionType.EMPTY;
        }
        return PartitionType.UNKNOWN;
    }
}
