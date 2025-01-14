package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentLeafNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentLeafNode.class */
public class HFSPlusExtentLeafNode extends BTLeafNode {
    protected HFSPlusExtentLeafRecord[] leafRecords;
    protected short[] leafRecordOffsets;

    public HFSPlusExtentLeafNode(byte[] data, int offset, int nodeSize) {
        super(data, offset, nodeSize);
        this.leafRecordOffsets = new short[Util.unsign(this.nodeDescriptor.getNumRecords()) + 1];
        for (int i2 = 0; i2 < this.leafRecordOffsets.length; i2++) {
            this.leafRecordOffsets[i2] = Util.readShortBE(data, (offset + nodeSize) - ((i2 + 1) * 2));
        }
        this.leafRecords = new HFSPlusExtentLeafRecord[this.leafRecordOffsets.length - 1];
        for (int i3 = 0; i3 < this.leafRecords.length; i3++) {
            int currentOffset = Util.unsign(this.leafRecordOffsets[i3]);
            this.leafRecords[i3] = new HFSPlusExtentLeafRecord(data, offset + currentOffset);
        }
    }

    public short[] getLeafRecordOffsets() {
        short[] offsets = new short[this.leafRecordOffsets.length];
        for (int i2 = 0; i2 < offsets.length; i2++) {
            offsets[i2] = this.leafRecordOffsets[i2];
        }
        return offsets;
    }

    public HFSPlusExtentLeafRecord getLeafRecord(int index) {
        return this.leafRecords[index];
    }

    public HFSPlusExtentLeafRecord[] getLeafRecords() {
        HFSPlusExtentLeafRecord[] copy = new HFSPlusExtentLeafRecord[this.leafRecords.length];
        for (int i2 = 0; i2 < copy.length; i2++) {
            copy[i2] = this.leafRecords[i2];
        }
        return copy;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " nodeDescriptor:");
        this.nodeDescriptor.printFields(ps, prefix + "  ");
        for (int i2 = 0; i2 < this.leafRecords.length; i2++) {
            ps.println(prefix + " leafRecords[" + i2 + "]:");
            this.leafRecords[i2].printFields(ps, prefix + "  ");
        }
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusExtentLeafNode:");
        printFields(ps, prefix);
    }
}
