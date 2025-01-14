package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.csjc.DynamicStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.FastUnicodeCompare;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogKey.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogKey.class */
public class HFSPlusCatalogKey extends BTKey implements DynamicStruct, StructElements {
    private static final int MAX_STRUCTSIZE = 518;
    private final byte[] keyLength;
    private final HFSCatalogNodeID parentID;
    private final HFSUniStr255 nodeName;

    public HFSPlusCatalogKey(byte[] data, int offset) {
        this.keyLength = new byte[2];
        System.arraycopy(data, offset + 0, this.keyLength, 0, 2);
        this.parentID = new HFSCatalogNodeID(data, offset + 2);
        this.nodeName = new HFSUniStr255(data, offset + 6);
    }

    public HFSPlusCatalogKey(HFSCatalogNodeID parentID, HFSUniStr255 nodeName) {
        this.keyLength = new byte[2];
        this.parentID = parentID;
        this.nodeName = nodeName;
        System.arraycopy(Util.toByteArrayBE((short) (4 + nodeName.length())), 0, this.keyLength, 0, 2);
    }

    public HFSPlusCatalogKey(int parentIDInt, String nodeNameString) {
        this.keyLength = new byte[2];
        this.parentID = new HFSCatalogNodeID(parentIDInt);
        this.nodeName = new HFSUniStr255(nodeNameString);
        System.arraycopy(Util.toByteArrayBE((short) (4 + this.nodeName.length())), 0, this.keyLength, 0, 2);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.BTKey
    public short getKeyLength() {
        return Util.readShortBE(this.keyLength);
    }

    public HFSCatalogNodeID getParentID() {
        return this.parentID;
    }

    public HFSUniStr255 getNodeName() {
        return this.nodeName;
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.BTKey, org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.keyLength, 0, result, 0, 2);
        System.arraycopy(Util.toByteArrayBE(this.parentID.toInt()), 0, result, 2, 4);
        System.arraycopy(this.nodeName.getBytes(), 0, result, 6, this.nodeName.length());
        return result;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.catacombae.hfsexplorer.types.hfsplus.BTKey, java.lang.Comparable
    public int compareTo(BTKey btk) {
        if (btk instanceof HFSPlusCatalogKey) {
            HFSPlusCatalogKey catKey = (HFSPlusCatalogKey) btk;
            if (Util.unsign(getParentID().toInt()) == Util.unsign(catKey.getParentID().toInt())) {
                return FastUnicodeCompare.compare(this.nodeName.getUnicode(), catKey.getNodeName().getUnicode());
            }
            if (Util.unsign(getParentID().toInt()) < Util.unsign(catKey.getParentID().toInt())) {
                return -1;
            }
            return 1;
        }
        return super.compareTo(btk);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " keyLength: " + Util.unsign(getKeyLength()));
        ps.println(prefix + " parentID: ");
        getParentID().print(ps, prefix + "  ");
        ps.println(prefix + " nodeName: ");
        getNodeName().print(ps, prefix + "  ");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusCatalogKey:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.BTKey
    public int length() {
        return occupiedSize();
    }

    @Override // org.catacombae.csjc.DynamicStruct
    public int occupiedSize() {
        return 2 + Util.unsign(getKeyLength());
    }

    @Override // org.catacombae.csjc.DynamicStruct
    public int maxSize() {
        return 518;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSPlusCatalogKey.class.getSimpleName());
        db.addUIntBE("keyLength", this.keyLength);
        db.add("parentID", this.parentID.getStructElements());
        db.add("nodeName", this.nodeName.getStructElements());
        return db.getResult();
    }
}
