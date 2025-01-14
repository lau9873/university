package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.hfsexplorer.types.hfs.ExtDataRec;
import org.catacombae.hfsexplorer.types.hfs.ExtKeyRec;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentRecord;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafNode.class */
public abstract class CommonHFSExtentLeafNode extends CommonBTNode<CommonHFSExtentLeafRecord> {
    protected CommonHFSExtentLeafNode(byte[] data, int offset, int nodeSize, CommonBTNode.FSType type) {
        super(data, offset, nodeSize, type);
    }

    public CommonHFSExtentLeafRecord[] getLeafRecords() {
        return (CommonHFSExtentLeafRecord[]) this.ic.records.toArray(new CommonHFSExtentLeafRecord[this.ic.records.size()]);
    }

    public static CommonHFSExtentLeafNode createHFS(byte[] data, int offset, int nodeSize) {
        return new HFSImplementation(data, offset, nodeSize);
    }

    public static CommonHFSExtentLeafNode createHFSPlus(byte[] data, int offset, int nodeSize) {
        return new HFSPlusImplementation(data, offset, nodeSize);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafNode$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafNode$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSExtentLeafNode {
        public HFSPlusImplementation(byte[] data, int offset, int nodeSize) {
            super(data, offset, nodeSize, CommonBTNode.FSType.HFS_PLUS);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
        public CommonHFSExtentLeafRecord createBTRecord(int recordNumber, byte[] data, int offset, int length) {
            HFSPlusExtentKey key = new HFSPlusExtentKey(data, offset);
            HFSPlusExtentRecord recordData = new HFSPlusExtentRecord(data, offset + key.length());
            return CommonHFSExtentLeafRecord.create(key, recordData);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafNode$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafNode$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSExtentLeafNode {
        public HFSImplementation(byte[] data, int offset, int nodeSize) {
            super(data, offset, nodeSize, CommonBTNode.FSType.HFS);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
        public CommonHFSExtentLeafRecord createBTRecord(int recordNumber, byte[] data, int offset, int length) {
            ExtKeyRec key = new ExtKeyRec(data, offset);
            ExtDataRec recordData = new ExtDataRec(data, offset + ExtKeyRec.length());
            return CommonHFSExtentLeafRecord.create(key, recordData);
        }
    }
}
