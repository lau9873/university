package org.catacombae.hfsexplorer.types.hfsplus;

import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentIndexNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentIndexNode.class */
public class HFSPlusExtentIndexNode extends BTIndexNode {
    public HFSPlusExtentIndexNode(byte[] data, int offset, int nodeSize) {
        super(data, offset, nodeSize);
        for (int i2 = 0; i2 < this.records.length; i2++) {
            int currentOffset = Util.unsign(this.offsets[i2]);
            HFSPlusExtentKey currentKey = new HFSPlusExtentKey(data, offset + currentOffset);
            this.records[i2] = new BTIndexRecord(currentKey, data, offset + currentOffset);
        }
    }
}
