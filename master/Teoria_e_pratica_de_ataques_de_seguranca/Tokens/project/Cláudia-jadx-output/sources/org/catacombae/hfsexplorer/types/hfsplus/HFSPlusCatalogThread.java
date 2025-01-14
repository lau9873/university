package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.csjc.DynamicStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogThread.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogThread.class */
public class HFSPlusCatalogThread extends HFSPlusCatalogLeafRecordData implements DynamicStruct {
    private final byte[] recordType = new byte[2];
    private final byte[] reserved = new byte[2];
    private final HFSCatalogNodeID parentID;
    private final HFSUniStr255 nodeName;

    public HFSPlusCatalogThread(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.recordType, 0, 2);
        System.arraycopy(data, offset + 2, this.reserved, 0, 2);
        this.parentID = new HFSCatalogNodeID(data, offset + 4);
        this.nodeName = new HFSUniStr255(data, offset + 8);
    }

    @Override // org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.recordType, 0, result, 0, this.recordType.length);
        int offset = 0 + this.recordType.length;
        System.arraycopy(this.reserved, 0, result, offset, this.reserved.length);
        int offset2 = offset + this.reserved.length;
        byte[] tempData = this.parentID.getBytes();
        System.arraycopy(tempData, 0, result, offset2, tempData.length);
        int offset3 = offset2 + tempData.length;
        byte[] tempData2 = this.nodeName.getBytes();
        System.arraycopy(tempData2, 0, result, offset3, tempData2.length);
        int length = offset3 + tempData2.length;
        return result;
    }

    public int length() {
        HFSCatalogNodeID hFSCatalogNodeID = this.parentID;
        return 4 + HFSCatalogNodeID.length() + this.nodeName.length();
    }

    @Override // org.catacombae.csjc.DynamicStruct
    public int occupiedSize() {
        return length();
    }

    @Override // org.catacombae.csjc.DynamicStruct
    public int maxSize() {
        return 520;
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecordData, org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public short getRecordType() {
        return Util.readShortBE(this.recordType);
    }

    public short getReserved() {
        return Util.readShortBE(this.reserved);
    }

    public HFSCatalogNodeID getParentID() {
        return this.parentID;
    }

    public HFSUniStr255 getNodeName() {
        return this.nodeName;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " recordType: " + ((int) getRecordType()));
        ps.println(prefix + " reserved: " + ((int) getReserved()));
        ps.println(prefix + " parentID: ");
        getParentID().print(ps, prefix + "  ");
        ps.println(prefix + " nodeName: ");
        getNodeName().print(ps, prefix + "  ");
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusCatalogThread:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSPlusCatalogThread.class.getSimpleName());
        db.addUIntBE("recordType", this.recordType);
        db.addUIntBE("reserved", this.reserved);
        db.add("parentID", this.parentID.getStructElements());
        db.add("nodeName", this.nodeName.getStructElements());
        return db.getResult();
    }
}
