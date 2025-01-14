package org.catacombae.hfsexplorer.partitioning;

import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableMasterBootRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableMasterBootRecord.class */
public class MutableMasterBootRecord extends MasterBootRecord {
    public MutableMasterBootRecord(MasterBootRecord mbr) {
        super(mbr);
    }

    public void setOptionalIBMExtendedData1(byte[] data) {
        copyData(data, 0, this.optIBMExtendedData1);
    }

    public void setOptionalIBMExtendedData2(byte[] data) {
        copyData(data, 0, this.optIBMExtendedData2);
    }

    public void setOptionalIBMExtendedData3(byte[] data) {
        copyData(data, 0, this.optIBMExtendedData3);
    }

    public void setOptionalIBMExtendedData4(byte[] data) {
        copyData(data, 0, this.optIBMExtendedData4);
    }

    public void setOptionalDiskSignature(int sig) {
        Util.arrayCopy(Util.toByteArrayBE(sig), this.optDiskSignature);
    }

    public void setPartition(int i2, MBRPartition partition) {
        this.partitions[i2] = partition;
    }

    public void setMBRSignature(short sig) {
        Util.arrayCopy(Util.toByteArrayBE(sig), this.mbrSignature);
    }

    private static void copyData(byte[] data, int off, byte[] dest) {
        copyData(data, off, dest, dest.length);
    }

    private static void copyData(byte[] data, int off, byte[] dest, int len) {
        if (off + len > data.length) {
            throw new IllegalArgumentException("Length of input data must be " + len + ".");
        }
        System.arraycopy(data, off, dest, 0, len);
    }
}
