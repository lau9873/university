package org.catacombae.hfsexplorer.types.hfsx;

import org.catacombae.hfsexplorer.FastUnicodeCompare;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.BTKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSUniStr255;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsx/HFSXCatalogKey.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsx/HFSXCatalogKey.class */
public class HFSXCatalogKey extends HFSPlusCatalogKey {
    private final byte keyCompareType;

    public HFSXCatalogKey(byte[] data, int offset, BTHeaderRec catalogHeaderRec) {
        super(data, offset);
        if (catalogHeaderRec == null) {
            throw new IllegalArgumentException("catalogHeaderRec == null");
        }
        this.keyCompareType = catalogHeaderRec.getKeyCompareType();
        if (this.keyCompareType != -68 && this.keyCompareType != -49) {
            throw new IllegalArgumentException("Illegal key compare type: " + ((int) this.keyCompareType));
        }
    }

    public HFSXCatalogKey(HFSCatalogNodeID parentID, HFSUniStr255 nodeName, BTHeaderRec catalogHeaderRec) {
        super(parentID, nodeName);
        if (catalogHeaderRec == null) {
            throw new IllegalArgumentException("catalogHeaderRec == null");
        }
        this.keyCompareType = catalogHeaderRec.getKeyCompareType();
        if (this.keyCompareType != -68 && this.keyCompareType != -49) {
            throw new IllegalArgumentException("Illegal key compare type: " + ((int) this.keyCompareType));
        }
    }

    public HFSXCatalogKey(int parentIDInt, String nodeNameString, BTHeaderRec catalogHeaderRec) {
        super(parentIDInt, nodeNameString);
        if (catalogHeaderRec == null) {
            throw new IllegalArgumentException("catalogHeaderRec == null");
        }
        this.keyCompareType = catalogHeaderRec.getKeyCompareType();
        if (this.keyCompareType != -68 && this.keyCompareType != -49) {
            throw new IllegalArgumentException("Illegal key compare type: " + ((int) this.keyCompareType));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey, org.catacombae.hfsexplorer.types.hfsplus.BTKey, java.lang.Comparable
    public int compareTo(BTKey btk) {
        if (btk instanceof HFSPlusCatalogKey) {
            HFSPlusCatalogKey catKey = (HFSPlusCatalogKey) btk;
            if (Util.unsign(getParentID().toInt()) == Util.unsign(catKey.getParentID().toInt())) {
                switch (this.keyCompareType) {
                    case -68:
                        return Util.unsignedArrayCompareLex(getNodeName().getUnicode(), catKey.getNodeName().getUnicode());
                    case -49:
                        return FastUnicodeCompare.compare(getNodeName().getUnicode(), catKey.getNodeName().getUnicode());
                    default:
                        throw new RuntimeException("Invalid value in file system structure! keyCompareType = " + ((int) this.keyCompareType));
                }
            }
            return super.compareTo(btk);
        }
        return super.compareTo(btk);
    }
}
