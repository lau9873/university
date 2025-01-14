package org.catacombae.hfsexplorer.types.hfsx;

import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecord;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsx/HFSXCatalogLeafRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsx/HFSXCatalogLeafRecord.class */
public class HFSXCatalogLeafRecord extends HFSPlusCatalogLeafRecord {
    public HFSXCatalogLeafRecord(byte[] data, int offset, BTHeaderRec catalogHeaderRec) {
        super(data, offset, catalogHeaderRec);
    }
}
