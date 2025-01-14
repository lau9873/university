package org.catacombae.hfsexplorer.types.hfsplus;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogLeafRecord;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogLeafNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogLeafNode.class */
public class HFSPlusCatalogLeafNode extends BTLeafNode {
    protected HFSPlusCatalogLeafRecord[] leafRecords;

    public HFSPlusCatalogLeafNode(byte[] data, int offset, int nodeSize) {
        this(data, offset, nodeSize, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HFSPlusCatalogLeafNode(byte[] data, int offset, int nodeSize, BTHeaderRec catalogHeaderRec) {
        super(data, offset, nodeSize);
        short[] offsets = new short[Util.unsign(this.nodeDescriptor.getNumRecords()) + 1];
        for (int i2 = 0; i2 < offsets.length; i2++) {
            offsets[i2] = Util.readShortBE(data, (offset + nodeSize) - ((i2 + 1) * 2));
        }
        this.leafRecords = new HFSPlusCatalogLeafRecord[offsets.length - 1];
        for (int i3 = 0; i3 < this.leafRecords.length; i3++) {
            int currentOffset = Util.unsign(offsets[i3]);
            if (catalogHeaderRec == null) {
                this.leafRecords[i3] = new HFSPlusCatalogLeafRecord(data, offset + currentOffset);
            } else {
                this.leafRecords[i3] = new HFSXCatalogLeafRecord(data, offset + currentOffset, catalogHeaderRec);
            }
        }
    }

    public HFSPlusCatalogLeafRecord getLeafRecord(int index) {
        return this.leafRecords[index];
    }

    public HFSPlusCatalogLeafRecord[] getLeafRecords() {
        HFSPlusCatalogLeafRecord[] copy = new HFSPlusCatalogLeafRecord[this.leafRecords.length];
        for (int i2 = 0; i2 < copy.length; i2++) {
            copy[i2] = this.leafRecords[i2];
        }
        return copy;
    }
}
