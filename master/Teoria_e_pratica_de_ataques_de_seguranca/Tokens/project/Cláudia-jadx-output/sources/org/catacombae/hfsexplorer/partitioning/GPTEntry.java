package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.csjc.structelements.EncodedStringField;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.jparted.lib.ps.PartitionType;
import org.catacombae.jparted.lib.ps.gpt.GPTPartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/GPTEntry.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/GPTEntry.class */
public class GPTEntry implements Partition, StructElements {
    protected final byte[] partitionTypeGUID;
    protected final byte[] uniquePartitionGUID;
    protected final byte[] startingLBA;
    protected final byte[] endingLBA;
    protected final byte[] attributeBits;
    protected final byte[] partitionName;
    private final int blockSize;

    public GPTEntry(byte[] data, int offset, int blockSize) {
        this(blockSize);
        System.arraycopy(data, offset + 0, this.partitionTypeGUID, 0, 16);
        System.arraycopy(data, offset + 16, this.uniquePartitionGUID, 0, 16);
        System.arraycopy(data, offset + 32, this.startingLBA, 0, 8);
        System.arraycopy(data, offset + 40, this.endingLBA, 0, 8);
        System.arraycopy(data, offset + 48, this.attributeBits, 0, 8);
        System.arraycopy(data, offset + 56, this.partitionName, 0, 72);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GPTEntry(int blockSize) {
        this.partitionTypeGUID = new byte[16];
        this.uniquePartitionGUID = new byte[16];
        this.startingLBA = new byte[8];
        this.endingLBA = new byte[8];
        this.attributeBits = new byte[8];
        this.partitionName = new byte[72];
        this.blockSize = blockSize;
    }

    public GPTEntry(GPTEntry source) {
        this(source.blockSize);
        copyFields(source);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void copyFields(GPTEntry source) {
        System.arraycopy(source.partitionTypeGUID, 0, this.partitionTypeGUID, 0, this.partitionTypeGUID.length);
        System.arraycopy(source.uniquePartitionGUID, 0, this.uniquePartitionGUID, 0, this.uniquePartitionGUID.length);
        System.arraycopy(source.startingLBA, 0, this.startingLBA, 0, this.startingLBA.length);
        System.arraycopy(source.endingLBA, 0, this.endingLBA, 0, this.endingLBA.length);
        System.arraycopy(source.attributeBits, 0, this.attributeBits, 0, this.attributeBits.length);
        System.arraycopy(source.partitionName, 0, this.partitionName, 0, this.partitionName.length);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public long getStartOffset() {
        return getStartingLBA() * this.blockSize;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public long getLength() {
        return (getEndingLBA() * this.blockSize) - getStartOffset();
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public PartitionType getType() {
        return convertPartitionType(getPartitionTypeGUIDAsEnum());
    }

    public static int getSize() {
        return 128;
    }

    public byte[] getPartitionTypeGUID() {
        return Util.createCopy(this.partitionTypeGUID);
    }

    public byte[] getUniquePartitionGUID() {
        return Util.createCopy(this.uniquePartitionGUID);
    }

    public long getStartingLBA() {
        return Util.readLongLE(this.startingLBA);
    }

    public long getEndingLBA() {
        return Util.readLongLE(this.endingLBA);
    }

    public long getAttributeBits() {
        return Util.readLongBE(this.attributeBits);
    }

    public byte[] getPartitionName() {
        return Util.createCopy(this.partitionName);
    }

    public GPTPartitionType getPartitionTypeGUIDAsEnum() {
        return GPTPartitionType.getType(Util.readLongBE(this.partitionTypeGUID, 0), Util.readLongBE(this.partitionTypeGUID, 8));
    }

    public String getPartitionNameAsString() {
        int stringLength = 0;
        for (int i2 = 0; i2 < this.partitionName.length && (this.partitionName[i2] != 0 || this.partitionName[i2 + 1] != 0); i2 += 2) {
            stringLength += 2;
        }
        return Util.readString(this.partitionName, 0, stringLength, "UTF-16LE");
    }

    public boolean isUsed() {
        return getPartitionTypeGUIDAsEnum() != GPTPartitionType.PARTITION_TYPE_UNUSED_ENTRY;
    }

    public String toString() {
        return "\"" + getPartitionNameAsString() + "\" (" + getPartitionTypeGUIDAsEnum() + ")";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " partitionTypeGUID: " + getGUIDAsString(getPartitionTypeGUID()) + " (" + getPartitionTypeGUIDAsEnum() + ")");
        ps.println(prefix + " uniquePartitionGUID: " + getGUIDAsString(getUniquePartitionGUID()));
        ps.println(prefix + " startingLBA: " + getStartingLBA());
        ps.println(prefix + " endingLBA: " + getEndingLBA());
        ps.println(prefix + " attributeBits: " + getAttributeBits());
        ps.println(prefix + " partitionName: " + getPartitionNameAsString());
    }

    @Override // org.catacombae.hfsexplorer.partitioning.Partition
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "GPTEntry:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[128];
        System.arraycopy(this.partitionTypeGUID, 0, result, 0, this.partitionTypeGUID.length);
        int offset = 0 + 16;
        System.arraycopy(this.uniquePartitionGUID, 0, result, offset, this.uniquePartitionGUID.length);
        int offset2 = offset + 16;
        System.arraycopy(this.startingLBA, 0, result, offset2, this.startingLBA.length);
        int offset3 = offset2 + 8;
        System.arraycopy(this.endingLBA, 0, result, offset3, this.endingLBA.length);
        int offset4 = offset3 + 8;
        System.arraycopy(this.attributeBits, 0, result, offset4, this.attributeBits.length);
        int offset5 = offset4 + 8;
        System.arraycopy(this.partitionName, 0, result, offset5, this.partitionName.length);
        int i2 = offset5 + 72;
        return result;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GPTEntry) {
            GPTEntry gpte = (GPTEntry) obj;
            return Util.arraysEqual(getBytes(), gpte.getBytes());
        }
        return false;
    }

    public static String getGUIDAsString(byte[] guid) {
        String res = "{" + Util.toHexStringLE(Util.readIntBE(guid, 0)) + "-";
        return ((((res + Util.toHexStringLE(Util.readShortBE(guid, 4)) + "-") + Util.toHexStringLE(Util.readShortBE(guid, 6)) + "-") + Util.byteArrayToHexString(guid, 8, 2) + "-") + Util.byteArrayToHexString(guid, 10, 6) + "}").toUpperCase();
    }

    public static PartitionType convertPartitionType(GPTPartitionType gpt) {
        switch (gpt) {
            case PARTITION_TYPE_APPLE_HFS:
                return PartitionType.APPLE_HFS_CONTAINER;
            case PARTITION_TYPE_PRIMARY_PARTITION:
                return PartitionType.NT_OS2_IFS;
            default:
                return PartitionType.UNKNOWN;
        }
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(GPTEntry.class.getSimpleName());
        db.addByteArray("partitionTypeGUID", this.partitionTypeGUID);
        db.addByteArray("uniquePartitionGUID", this.uniquePartitionGUID);
        db.addUIntLE("startingLBA", this.startingLBA);
        db.addUIntLE("endingLBA", this.endingLBA);
        db.add("partitionName", new EncodedStringField(this.partitionName, "UTF-16LE"));
        return db.getResult();
    }
}
