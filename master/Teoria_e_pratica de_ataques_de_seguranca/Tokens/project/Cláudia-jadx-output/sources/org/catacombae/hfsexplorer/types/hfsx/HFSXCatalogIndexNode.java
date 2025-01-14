package org.catacombae.hfsexplorer.types.hfsx;

import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogIndexNode;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsx/HFSXCatalogIndexNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsx/HFSXCatalogIndexNode.class */
public class HFSXCatalogIndexNode extends HFSPlusCatalogIndexNode {
    public HFSXCatalogIndexNode(byte[] data, int offset, int nodeSize, BTHeaderRec catalogHeaderRec) {
        super(data, offset, nodeSize, catalogHeaderRec);
    }
}
