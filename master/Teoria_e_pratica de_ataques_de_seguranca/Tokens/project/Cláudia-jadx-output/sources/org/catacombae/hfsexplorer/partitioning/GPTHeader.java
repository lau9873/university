package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import java.util.zip.CRC32;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ByteArrayField;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.csjc.structelements.IntegerField;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/GPTHeader.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/GPTHeader.class */
public class GPTHeader implements StructElements {
    public static final long GPT_SIGNATURE = 4991757640121012820L;
    protected final byte[] signature;
    protected final byte[] revision;
    protected final byte[] headerSize;
    protected final byte[] crc32Checksum;
    protected final byte[] reserved1;
    protected final byte[] primaryLBA;
    protected final byte[] backupLBA;
    protected final byte[] firstUsableLBA;
    protected final byte[] lastUsableLBA;
    protected final byte[] diskGUID;
    protected final byte[] partitionEntryLBA;
    protected final byte[] numberOfPartitionEntries;
    protected final byte[] sizeOfPartitionEntry;
    protected final byte[] partitionEntryArrayCRC32;
    protected final byte[] reserved2;
    protected int blockSize;
    private final CRC32 crc;

    public GPTHeader(byte[] data, int offset, int blockSize) {
        this.signature = new byte[8];
        this.revision = new byte[4];
        this.headerSize = new byte[4];
        this.crc32Checksum = new byte[4];
        this.reserved1 = new byte[4];
        this.primaryLBA = new byte[8];
        this.backupLBA = new byte[8];
        this.firstUsableLBA = new byte[8];
        this.lastUsableLBA = new byte[8];
        this.diskGUID = new byte[16];
        this.partitionEntryLBA = new byte[8];
        this.numberOfPartitionEntries = new byte[4];
        this.sizeOfPartitionEntry = new byte[4];
        this.partitionEntryArrayCRC32 = new byte[4];
        this.reserved2 = new byte[420];
        this.crc = new CRC32();
        this.blockSize = blockSize;
        System.arraycopy(data, offset + 0, this.signature, 0, 8);
        System.arraycopy(data, offset + 8, this.revision, 0, 4);
        System.arraycopy(data, offset + 12, this.headerSize, 0, 4);
        System.arraycopy(data, offset + 16, this.crc32Checksum, 0, 4);
        System.arraycopy(data, offset + 20, this.reserved1, 0, 4);
        System.arraycopy(data, offset + 24, this.primaryLBA, 0, 8);
        System.arraycopy(data, offset + 32, this.backupLBA, 0, 8);
        System.arraycopy(data, offset + 40, this.firstUsableLBA, 0, 8);
        System.arraycopy(data, offset + 48, this.lastUsableLBA, 0, 8);
        System.arraycopy(data, offset + 56, this.diskGUID, 0, 16);
        System.arraycopy(data, offset + 72, this.partitionEntryLBA, 0, 8);
        System.arraycopy(data, offset + 80, this.numberOfPartitionEntries, 0, 4);
        System.arraycopy(data, offset + 84, this.sizeOfPartitionEntry, 0, 4);
        System.arraycopy(data, offset + 88, this.partitionEntryArrayCRC32, 0, 4);
        System.arraycopy(data, offset + 92, this.reserved2, 0, 420);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v21, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v23, types: [byte[], byte[][]] */
    public GPTHeader(int blockSize) {
        this.signature = new byte[8];
        this.revision = new byte[4];
        this.headerSize = new byte[4];
        this.crc32Checksum = new byte[4];
        this.reserved1 = new byte[4];
        this.primaryLBA = new byte[8];
        this.backupLBA = new byte[8];
        this.firstUsableLBA = new byte[8];
        this.lastUsableLBA = new byte[8];
        this.diskGUID = new byte[16];
        this.partitionEntryLBA = new byte[8];
        this.numberOfPartitionEntries = new byte[4];
        this.sizeOfPartitionEntry = new byte[4];
        this.partitionEntryArrayCRC32 = new byte[4];
        this.reserved2 = new byte[420];
        this.crc = new CRC32();
        this.blockSize = blockSize;
        System.arraycopy(Util.toByteArrayBE(4991757640121012820L), 0, this.signature, 0, 8);
        Util.zero((byte[][]) new byte[]{this.reserved1});
        Util.zero((byte[][]) new byte[]{this.reserved2});
    }

    public GPTHeader(GPTHeader source) {
        this.signature = new byte[8];
        this.revision = new byte[4];
        this.headerSize = new byte[4];
        this.crc32Checksum = new byte[4];
        this.reserved1 = new byte[4];
        this.primaryLBA = new byte[8];
        this.backupLBA = new byte[8];
        this.firstUsableLBA = new byte[8];
        this.lastUsableLBA = new byte[8];
        this.diskGUID = new byte[16];
        this.partitionEntryLBA = new byte[8];
        this.numberOfPartitionEntries = new byte[4];
        this.sizeOfPartitionEntry = new byte[4];
        this.partitionEntryArrayCRC32 = new byte[4];
        this.reserved2 = new byte[420];
        this.crc = new CRC32();
        setFieldsInternal(source);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFieldsInternal(GPTHeader source) {
        this.blockSize = source.blockSize;
        System.arraycopy(source.signature, 0, this.signature, 0, this.signature.length);
        System.arraycopy(source.revision, 0, this.revision, 0, this.revision.length);
        System.arraycopy(source.headerSize, 0, this.headerSize, 0, this.headerSize.length);
        System.arraycopy(source.crc32Checksum, 0, this.crc32Checksum, 0, this.crc32Checksum.length);
        System.arraycopy(source.reserved1, 0, this.reserved1, 0, this.reserved1.length);
        System.arraycopy(source.primaryLBA, 0, this.primaryLBA, 0, this.primaryLBA.length);
        System.arraycopy(source.backupLBA, 0, this.backupLBA, 0, this.backupLBA.length);
        System.arraycopy(source.firstUsableLBA, 0, this.firstUsableLBA, 0, this.firstUsableLBA.length);
        System.arraycopy(source.lastUsableLBA, 0, this.lastUsableLBA, 0, this.lastUsableLBA.length);
        System.arraycopy(source.diskGUID, 0, this.diskGUID, 0, this.diskGUID.length);
        System.arraycopy(source.partitionEntryLBA, 0, this.partitionEntryLBA, 0, this.partitionEntryLBA.length);
        System.arraycopy(source.numberOfPartitionEntries, 0, this.numberOfPartitionEntries, 0, this.numberOfPartitionEntries.length);
        System.arraycopy(source.sizeOfPartitionEntry, 0, this.sizeOfPartitionEntry, 0, this.sizeOfPartitionEntry.length);
        System.arraycopy(source.partitionEntryArrayCRC32, 0, this.partitionEntryArrayCRC32, 0, this.partitionEntryArrayCRC32.length);
        System.arraycopy(source.reserved2, 0, this.reserved2, 0, this.reserved2.length);
    }

    public static int getSize() {
        return 512;
    }

    public long getSignature() {
        return Util.readLongBE(this.signature);
    }

    public int getRevision() {
        return Util.readIntLE(this.revision);
    }

    public int getHeaderSize() {
        return Util.readIntLE(this.headerSize);
    }

    public int getCRC32Checksum() {
        return Util.readIntLE(this.crc32Checksum);
    }

    public int getReserved1() {
        return Util.readIntBE(this.reserved1);
    }

    public long getPrimaryLBA() {
        return Util.readLongLE(this.primaryLBA);
    }

    public long getBackupLBA() {
        return Util.readLongLE(this.backupLBA);
    }

    public long getFirstUsableLBA() {
        return Util.readLongLE(this.firstUsableLBA);
    }

    public long getLastUsableLBA() {
        return Util.readLongLE(this.lastUsableLBA);
    }

    public byte[] getDiskGUID() {
        return Util.createCopy(this.diskGUID);
    }

    public long getPartitionEntryLBA() {
        return Util.readLongLE(this.partitionEntryLBA);
    }

    public int getNumberOfPartitionEntries() {
        return Util.readIntLE(this.numberOfPartitionEntries);
    }

    public int getSizeOfPartitionEntry() {
        return Util.readIntLE(this.sizeOfPartitionEntry);
    }

    public int getPartitionEntryArrayCRC32() {
        return Util.readIntLE(this.partitionEntryArrayCRC32);
    }

    public byte[] getReserved2() {
        return Util.createCopy(this.reserved2);
    }

    public boolean isValid() {
        return getSignature() == 4991757640121012820L && calculateCRC32() == getCRC32Checksum();
    }

    public int calculateCRC32() {
        this.crc.reset();
        this.crc.update(this.signature);
        this.crc.update(this.revision);
        this.crc.update(this.headerSize);
        this.crc.update(0);
        this.crc.update(0);
        this.crc.update(0);
        this.crc.update(0);
        this.crc.update(this.reserved1);
        this.crc.update(this.primaryLBA);
        this.crc.update(this.backupLBA);
        this.crc.update(this.firstUsableLBA);
        this.crc.update(this.lastUsableLBA);
        this.crc.update(this.diskGUID);
        this.crc.update(this.partitionEntryLBA);
        this.crc.update(this.numberOfPartitionEntries);
        this.crc.update(this.sizeOfPartitionEntry);
        this.crc.update(this.partitionEntryArrayCRC32);
        return (int) (this.crc.getValue() & (-1));
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " signature: 0x" + Util.toHexStringBE(getSignature()));
        ps.println(prefix + " revision: 0x" + Util.toHexStringBE(getRevision()));
        ps.println(prefix + " headerSize: " + getHeaderSize());
        ps.println(prefix + " crc32Checksum: 0x" + Util.toHexStringBE(getCRC32Checksum()));
        ps.println(prefix + " reserved1: 0x" + Util.toHexStringBE(getReserved1()));
        ps.println(prefix + " primaryLBA: " + getPrimaryLBA());
        ps.println(prefix + " backupLBA: " + getBackupLBA());
        ps.println(prefix + " firstUsableLBA: " + getFirstUsableLBA());
        ps.println(prefix + " lastUsableLBA: " + getLastUsableLBA());
        ps.println(prefix + " diskGUID: " + GPTEntry.getGUIDAsString(getDiskGUID()));
        ps.println(prefix + " partitionEntryLBA: " + getPartitionEntryLBA());
        ps.println(prefix + " sizeOfPartitionEntry: " + getSizeOfPartitionEntry());
        ps.println(prefix + " numberOfPartitionEntries: " + getNumberOfPartitionEntries());
        ps.println(prefix + " partitionEntryArrayCRC32: 0x" + Util.toHexStringBE(getPartitionEntryArrayCRC32()));
        ps.println(prefix + " reserved2: [too much data to display...]");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "GPTHeader:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[512];
        System.arraycopy(this.signature, 0, result, 0, this.signature.length);
        int offset = 0 + 8;
        System.arraycopy(this.revision, 0, result, offset, this.revision.length);
        int offset2 = offset + 4;
        System.arraycopy(this.headerSize, 0, result, offset2, this.headerSize.length);
        int offset3 = offset2 + 4;
        System.arraycopy(this.crc32Checksum, 0, result, offset3, this.crc32Checksum.length);
        int offset4 = offset3 + 4;
        System.arraycopy(this.reserved1, 0, result, offset4, this.reserved1.length);
        int offset5 = offset4 + 4;
        System.arraycopy(this.primaryLBA, 0, result, offset5, this.primaryLBA.length);
        int offset6 = offset5 + 8;
        System.arraycopy(this.backupLBA, 0, result, offset6, this.backupLBA.length);
        int offset7 = offset6 + 8;
        System.arraycopy(this.firstUsableLBA, 0, result, offset7, this.firstUsableLBA.length);
        int offset8 = offset7 + 8;
        System.arraycopy(this.lastUsableLBA, 0, result, offset8, this.lastUsableLBA.length);
        int offset9 = offset8 + 8;
        System.arraycopy(this.diskGUID, 0, result, offset9, this.diskGUID.length);
        int offset10 = offset9 + 16;
        System.arraycopy(this.partitionEntryLBA, 0, result, offset10, this.partitionEntryLBA.length);
        int offset11 = offset10 + 8;
        System.arraycopy(this.numberOfPartitionEntries, 0, result, offset11, this.numberOfPartitionEntries.length);
        int offset12 = offset11 + 4;
        System.arraycopy(this.sizeOfPartitionEntry, 0, result, offset12, this.sizeOfPartitionEntry.length);
        int offset13 = offset12 + 4;
        System.arraycopy(this.partitionEntryArrayCRC32, 0, result, offset13, this.partitionEntryArrayCRC32.length);
        int offset14 = offset13 + 4;
        System.arraycopy(this.reserved2, 0, result, offset14, this.reserved2.length);
        int i2 = offset14 + 420;
        return result;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GPTHeader) {
            GPTHeader gpth = (GPTHeader) obj;
            return Util.arraysEqual(getBytes(), gpth.getBytes());
        }
        return false;
    }

    public boolean isValidBackup(GPTHeader backupHeader) {
        return Util.arraysEqual(this.signature, backupHeader.signature) && Util.arraysEqual(this.revision, backupHeader.revision) && Util.arraysEqual(this.headerSize, backupHeader.headerSize) && !Util.arraysEqual(this.crc32Checksum, backupHeader.crc32Checksum) && Util.arraysEqual(this.reserved1, backupHeader.reserved1) && Util.arraysEqual(this.primaryLBA, backupHeader.backupLBA) && Util.arraysEqual(this.backupLBA, backupHeader.primaryLBA) && Util.arraysEqual(this.firstUsableLBA, backupHeader.firstUsableLBA) && Util.arraysEqual(this.lastUsableLBA, backupHeader.lastUsableLBA) && Util.arraysEqual(this.diskGUID, backupHeader.diskGUID) && !Util.arraysEqual(this.partitionEntryLBA, backupHeader.partitionEntryLBA) && Util.arraysEqual(this.numberOfPartitionEntries, backupHeader.numberOfPartitionEntries) && Util.arraysEqual(this.sizeOfPartitionEntry, backupHeader.sizeOfPartitionEntry) && Util.arraysEqual(this.partitionEntryArrayCRC32, backupHeader.partitionEntryArrayCRC32) && Util.arraysEqual(this.reserved2, backupHeader.reserved2);
    }

    public GPTHeader createValidBackupHeader() {
        GPTHeader newHeader = new GPTHeader(this);
        byte[] primaryLBA = Util.createCopy(newHeader.primaryLBA);
        byte[] backupLBA = Util.createCopy(newHeader.backupLBA);
        Util.arrayCopy(primaryLBA, newHeader.backupLBA);
        Util.arrayCopy(backupLBA, newHeader.primaryLBA);
        long peByteLen = newHeader.getNumberOfPartitionEntries() * newHeader.getSizeOfPartitionEntry();
        long peLBALen = (peByteLen / this.blockSize) + (peByteLen % ((long) this.blockSize) != 0 ? 1 : 0);
        long pePos = newHeader.getPrimaryLBA() - peLBALen;
        byte[] pePosBytes = Util.toByteArrayLE(pePos);
        if (pePosBytes.length != newHeader.partitionEntryLBA.length) {
            throw new RuntimeException("Assertion pePosBytes.length(" + pePosBytes.length + ") == newHeader.partitionEntryLBA.length(" + newHeader.partitionEntryLBA.length + ") failed.");
        }
        System.arraycopy(pePosBytes, 0, newHeader.partitionEntryLBA, 0, newHeader.partitionEntryLBA.length);
        int crc = newHeader.calculateCRC32();
        byte[] crcBytes = Util.toByteArrayLE(crc);
        if (crcBytes.length != newHeader.crc32Checksum.length) {
            throw new RuntimeException("Assertion crcBytes.length(" + crcBytes.length + ") == newHeader.crc32Checksum.length(" + newHeader.crc32Checksum.length + ") failed.");
        }
        System.arraycopy(crcBytes, 0, newHeader.crc32Checksum, 0, newHeader.crc32Checksum.length);
        return newHeader;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder dbStruct = new StructElements.DictionaryBuilder(getClass().getSimpleName());
        dbStruct.add("signature", new IntegerField(this.signature, BITS_64, UNSIGNED, BIG_ENDIAN));
        dbStruct.add("revision", new IntegerField(this.revision, BITS_32, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("headerSize", new IntegerField(this.headerSize, BITS_32, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("crc32Checksum", new IntegerField(this.crc32Checksum, BITS_32, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("reserved1", new IntegerField(this.reserved1, BITS_32, UNSIGNED, BIG_ENDIAN));
        dbStruct.add("primaryLBA", new IntegerField(this.primaryLBA, BITS_64, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("backupLBA", new IntegerField(this.backupLBA, BITS_64, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("firstUsableLBA", new IntegerField(this.firstUsableLBA, BITS_64, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("lastUsableLBA", new IntegerField(this.lastUsableLBA, BITS_64, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("diskGUID", new ByteArrayField(this.diskGUID));
        dbStruct.add("partitionEntryLBA", new IntegerField(this.partitionEntryLBA, BITS_64, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("numberOfPartitionEntries", new IntegerField(this.numberOfPartitionEntries, BITS_32, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("sizeOfPartitionEntry", new IntegerField(this.sizeOfPartitionEntry, BITS_32, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("partitionEntryArrayCRC32", new IntegerField(this.partitionEntryArrayCRC32, BITS_32, UNSIGNED, LITTLE_ENDIAN));
        dbStruct.add("reserved2", new ByteArrayField(this.reserved2));
        return dbStruct.getResult();
    }
}
