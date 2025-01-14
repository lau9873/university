package org.catacombae.hfsexplorer.types.hfsplus;

import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTIndexNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTIndexNode.class */
public abstract class BTIndexNode extends BTNode {
    protected final BTIndexRecord[] records;
    protected final short[] offsets;

    /* JADX INFO: Access modifiers changed from: protected */
    public BTIndexNode(byte[] data, int offset, int nodeSize) {
        super(data, offset, nodeSize);
        this.offsets = new short[Util.unsign(this.nodeDescriptor.getNumRecords()) + 1];
        for (int i2 = 0; i2 < this.offsets.length; i2++) {
            this.offsets[i2] = Util.readShortBE(data, (offset + nodeSize) - ((i2 + 1) * 2));
        }
        this.records = new BTIndexRecord[this.offsets.length - 1];
    }

    public BTIndexRecord getIndexRecord(int index) {
        return this.records[index];
    }

    public BTIndexRecord[] getIndexRecords() {
        BTIndexRecord[] copy = new BTIndexRecord[this.records.length];
        for (int i2 = 0; i2 < copy.length; i2++) {
            copy[i2] = this.records[i2];
        }
        return copy;
    }
}
