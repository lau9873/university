package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.csjc.structelements.IntegerFieldRepresentation;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentKey.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentKey.class */
public class HFSPlusExtentKey extends BTKey implements StructElements {
    public static final byte DATA_FORK = 0;
    public static final byte RESOURCE_FORK = -1;
    private final byte[] keyLength;
    private final byte[] forkType;
    private final byte[] pad;
    private final HFSCatalogNodeID fileID;
    private final byte[] startBlock;

    public HFSPlusExtentKey(byte[] data, int offset) {
        this.keyLength = new byte[2];
        this.forkType = new byte[1];
        this.pad = new byte[1];
        this.startBlock = new byte[4];
        System.arraycopy(data, offset + 0, this.keyLength, 0, 2);
        System.arraycopy(data, offset + 2, this.forkType, 0, 1);
        System.arraycopy(data, offset + 3, this.pad, 0, 1);
        this.fileID = new HFSCatalogNodeID(data, offset + 4);
        System.arraycopy(data, offset + 8, this.startBlock, 0, 4);
    }

    public HFSPlusExtentKey(byte forkType, HFSCatalogNodeID fileID, int startBlock) {
        this.keyLength = new byte[2];
        this.forkType = new byte[1];
        this.pad = new byte[1];
        this.startBlock = new byte[4];
        System.arraycopy(Util.toByteArrayBE((short) 12), 0, this.keyLength, 0, 2);
        this.forkType[0] = forkType;
        this.pad[0] = 0;
        this.fileID = fileID;
        System.arraycopy(Util.toByteArrayBE(startBlock), 0, this.startBlock, 0, 4);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.BTKey
    public int length() {
        return 12;
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.BTKey
    public short getKeyLength() {
        return Util.readShortBE(this.keyLength);
    }

    public byte getForkType() {
        return Util.readByteBE(this.forkType);
    }

    public byte getPad() {
        return Util.readByteBE(this.pad);
    }

    public HFSCatalogNodeID getFileID() {
        return this.fileID;
    }

    public int getStartBlock() {
        return Util.readIntBE(this.startBlock);
    }

    public int getUnsignedForkType() {
        return Util.unsign(getForkType());
    }

    public long getUnsignedStartBlock() {
        return Util.unsign(getStartBlock());
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " keyLength: " + ((int) getKeyLength()));
        ps.println(prefix + " forkType: " + ((int) getForkType()));
        ps.println(prefix + " pad: " + ((int) getPad()));
        ps.println(prefix + " fileID: ");
        getFileID().print(ps, prefix + "  ");
        ps.println(prefix + " startBlock: " + getStartBlock());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusExtentKey:");
        printFields(ps, prefix);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.catacombae.hfsexplorer.types.hfsplus.BTKey, java.lang.Comparable
    public int compareTo(BTKey btk) {
        if (btk instanceof HFSPlusExtentKey) {
            HFSPlusExtentKey extKey = (HFSPlusExtentKey) btk;
            if (getFileID().toLong() == extKey.getFileID().toLong()) {
                if (getUnsignedForkType() == extKey.getUnsignedForkType()) {
                    if (getUnsignedStartBlock() == extKey.getUnsignedStartBlock()) {
                        return 0;
                    }
                    if (getUnsignedStartBlock() < extKey.getUnsignedStartBlock()) {
                        return -1;
                    }
                    return 1;
                } else if (getUnsignedForkType() < extKey.getUnsignedForkType()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (getFileID().toLong() < extKey.getFileID().toLong()) {
                return -1;
            } else {
                return 1;
            }
        }
        return super.compareTo(btk);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.BTKey, org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.keyLength, 0, result, 0, 2);
        System.arraycopy(this.forkType, 0, result, 2, 1);
        System.arraycopy(this.pad, 0, result, 3, 1);
        System.arraycopy(Util.toByteArrayBE(this.fileID.toInt()), 0, result, 4, 4);
        System.arraycopy(this.startBlock, 0, result, 8, 4);
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder("HFSPlusExtentKey", "HFS+ extent key");
        db.addUIntBE("keyLength", this.keyLength, "Key length", "bytes");
        db.addUIntBE("forkType", this.forkType, "Fork type");
        db.addUIntBE("pad", this.pad, "Padding", IntegerFieldRepresentation.HEXADECIMAL);
        db.add("fileID", this.fileID.getStructElements(), "File ID");
        db.addUIntBE("startBlock", this.startBlock, "Start block number");
        return db.getResult();
    }
}
