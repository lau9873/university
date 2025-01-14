package org.catacombae.hfsexplorer.types.hfsx;

import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafNode;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsx/HFSXCatalogLeafNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsx/HFSXCatalogLeafNode.class */
public class HFSXCatalogLeafNode extends HFSPlusCatalogLeafNode {
    public HFSXCatalogLeafNode(byte[] data, int offset, int nodeSize, BTHeaderRec catalogHeaderRec) {
        super(data, offset, nodeSize, catalogHeaderRec);
    }
}
