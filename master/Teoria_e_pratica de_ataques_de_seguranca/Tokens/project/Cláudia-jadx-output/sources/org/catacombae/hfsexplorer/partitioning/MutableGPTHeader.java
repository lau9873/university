package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableGPTHeader.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableGPTHeader.class */
public class MutableGPTHeader extends GPTHeader {
    public MutableGPTHeader(int blockSize) {
        super(blockSize);
    }

    public MutableGPTHeader(GPTHeader source) {
        super(source);
    }

    public void setFields(GPTHeader source) {
        setFieldsInternal(source);
    }

    public void setSignature(byte[] data, int off) {
        copyData(data, off, this.signature);
    }

    public void setRevision(int i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.revision);
    }

    public void setHeaderSize(int i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.headerSize);
    }

    public void setCRC32Checksum(int i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.crc32Checksum);
    }

    public void setReserved1(int i2) {
        Util.arrayCopy(Util.toByteArrayBE(i2), this.reserved1);
    }

    public void setPrimaryLBA(long i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.primaryLBA);
    }

    public void setBackupLBA(long i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.backupLBA);
    }

    public void setFirstUsableLBA(long i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.firstUsableLBA);
    }

    public void setLastUsableLBA(long i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.lastUsableLBA);
    }

    public void setDiskGUID(byte[] data, int off) {
        copyData(data, off, this.diskGUID);
    }

    public void setPartitionEntryLBA(long i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.partitionEntryLBA);
    }

    public void setNumberOfPartitionEntries(int i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.numberOfPartitionEntries);
    }

    public void setSizeOfPartitionEntry(int i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.sizeOfPartitionEntry);
    }

    public void setPartitionEntryArrayCRC32(int i2) {
        Util.arrayCopy(Util.toByteArrayLE(i2), this.partitionEntryArrayCRC32);
    }

    public void setReserved2(byte[] data, int off) {
        copyData(data, off, this.reserved2);
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

    @Override // org.catacombae.hfsexplorer.partitioning.GPTHeader
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "MutableGPTHeader:");
        printFields(ps, prefix);
    }
}
