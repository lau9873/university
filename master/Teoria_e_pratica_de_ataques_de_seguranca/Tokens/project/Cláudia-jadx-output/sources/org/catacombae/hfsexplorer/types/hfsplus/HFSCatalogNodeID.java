package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSCatalogNodeID.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSCatalogNodeID.class */
public class HFSCatalogNodeID implements StructElements {
    public static final HFSCatalogNodeID kHFSRootParentID = new HFSCatalogNodeID(1);
    public static final HFSCatalogNodeID kHFSRootFolderID = new HFSCatalogNodeID(2);
    public static final HFSCatalogNodeID kHFSExtentsFileID = new HFSCatalogNodeID(3);
    public static final HFSCatalogNodeID kHFSCatalogFileID = new HFSCatalogNodeID(4);
    public static final HFSCatalogNodeID kHFSBadBlockFileID = new HFSCatalogNodeID(5);
    public static final HFSCatalogNodeID kHFSAllocationFileID = new HFSCatalogNodeID(6);
    public static final HFSCatalogNodeID kHFSStartupFileID = new HFSCatalogNodeID(7);
    public static final HFSCatalogNodeID kHFSAttributesFileID = new HFSCatalogNodeID(8);
    public static final HFSCatalogNodeID kHFSRepairCatalogFileID = new HFSCatalogNodeID(14);
    public static final HFSCatalogNodeID kHFSBogusExtentFileID = new HFSCatalogNodeID(15);
    public static final HFSCatalogNodeID kHFSFirstUserCatalogNodeID = new HFSCatalogNodeID(16);
    private final byte[] hfsCatalogNodeID;

    public HFSCatalogNodeID(byte[] data, int offset) {
        this.hfsCatalogNodeID = new byte[4];
        System.arraycopy(data, offset, this.hfsCatalogNodeID, 0, 4);
    }

    public HFSCatalogNodeID(int nodeID) {
        this.hfsCatalogNodeID = new byte[4];
        System.arraycopy(Util.toByteArrayBE(nodeID), 0, this.hfsCatalogNodeID, 0, 4);
    }

    public static int length() {
        return 4;
    }

    public int toInt() {
        return Util.readIntBE(this.hfsCatalogNodeID);
    }

    public long toLong() {
        return Util.unsign(toInt());
    }

    public String getDescription() {
        String result;
        switch (toInt()) {
            case 1:
                result = "kHFSRootParentID";
                break;
            case 2:
                result = "kHFSRootFolderID";
                break;
            case 3:
                result = "kHFSExtentsFileID";
                break;
            case 4:
                result = "kHFSCatalogFileID";
                break;
            case 5:
                result = "kHFSBadBlockFileID";
                break;
            case 6:
                result = "kHFSAllocationFileID";
                break;
            case 7:
                result = "kHFSStartupFileID";
                break;
            case 8:
                result = "kHFSAttributesFileID";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                result = "User Defined ID";
                break;
            case 14:
                result = "kHFSRepairCatalogFileID";
                break;
            case 15:
                result = "kHFSBogusExtentFileID";
                break;
            case 16:
                result = "kHFSFirstUserCatalogNodeID";
                break;
        }
        return result;
    }

    public String toString() {
        return "" + Util.unsign(toInt());
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " hfsCatalogNodeID: " + toString() + " (" + getDescription() + ")");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSCatalogNodeID:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        return Util.createCopy(this.hfsCatalogNodeID);
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSCatalogNodeID.class.getSimpleName());
        db.addUIntBE("hfsCatalogNodeID", this.hfsCatalogNodeID);
        return db.getResult();
    }
}
