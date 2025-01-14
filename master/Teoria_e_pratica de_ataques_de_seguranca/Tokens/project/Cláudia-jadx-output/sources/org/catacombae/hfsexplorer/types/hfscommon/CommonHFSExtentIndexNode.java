package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.hfsexplorer.types.hfs.ExtKeyRec;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentIndexNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentIndexNode.class */
public abstract class CommonHFSExtentIndexNode extends CommonBTIndexNode<CommonHFSExtentKey> {
    protected CommonHFSExtentIndexNode(byte[] data, int offset, int nodeSize, CommonBTNode.FSType type) {
        super(data, offset, nodeSize, type);
    }

    public static CommonHFSExtentIndexNode createHFS(byte[] data, int offset, int nodeSize) {
        return new HFSImplementation(data, offset, nodeSize);
    }

    public static CommonHFSExtentIndexNode createHFSPlus(byte[] data, int offset, int nodeSize) {
        return new HFSPlusImplementation(data, offset, nodeSize);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentIndexNode$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentIndexNode$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSExtentIndexNode {
        public HFSImplementation(byte[] data, int offset, int nodeSize) {
            super(data, offset, nodeSize, CommonBTNode.FSType.HFS);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
        public CommonBTIndexRecord<CommonHFSExtentKey> createBTRecord(int recordNumber, byte[] data, int offset, int length) {
            CommonHFSExtentKey key = CommonHFSExtentKey.create(new ExtKeyRec(data, offset));
            return CommonBTIndexRecord.createHFS(key, data, offset);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentIndexNode$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentIndexNode$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSExtentIndexNode {
        public HFSPlusImplementation(byte[] data, int offset, int nodeSize) {
            super(data, offset, nodeSize, CommonBTNode.FSType.HFS_PLUS);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
        public CommonBTIndexRecord<CommonHFSExtentKey> createBTRecord(int recordNumber, byte[] data, int offset, int length) {
            CommonHFSExtentKey key = CommonHFSExtentKey.create(new HFSPlusExtentKey(data, offset));
            return CommonBTIndexRecord.createHFSPlus(key, data, offset);
        }
    }
}
