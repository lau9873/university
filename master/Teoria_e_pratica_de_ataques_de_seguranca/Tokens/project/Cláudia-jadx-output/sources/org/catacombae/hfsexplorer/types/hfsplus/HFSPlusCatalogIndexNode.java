package org.catacombae.hfsexplorer.types.hfsplus;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogIndexNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogIndexNode.class */
public class HFSPlusCatalogIndexNode extends BTIndexNode {
    public HFSPlusCatalogIndexNode(byte[] data, int offset, int nodeSize) {
        this(data, offset, nodeSize, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HFSPlusCatalogIndexNode(byte[] data, int offset, int nodeSize, BTHeaderRec catalogHeaderRec) {
        super(data, offset, nodeSize);
        HFSPlusCatalogKey hFSXCatalogKey;
        for (int i2 = 0; i2 < this.records.length; i2++) {
            int currentOffset = Util.unsign(this.offsets[i2]);
            if (catalogHeaderRec == null) {
                hFSXCatalogKey = new HFSPlusCatalogKey(data, offset + currentOffset);
            } else {
                hFSXCatalogKey = new HFSXCatalogKey(data, offset + currentOffset, catalogHeaderRec);
            }
            HFSPlusCatalogKey currentKey = hFSXCatalogKey;
            this.records[i2] = new BTIndexRecord(currentKey, data, offset + currentOffset);
        }
    }
}
