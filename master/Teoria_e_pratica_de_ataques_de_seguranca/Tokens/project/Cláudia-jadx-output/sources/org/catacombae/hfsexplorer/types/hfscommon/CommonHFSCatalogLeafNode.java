package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode.class */
public abstract class CommonHFSCatalogLeafNode extends CommonBTNode<CommonHFSCatalogLeafRecord> {
    protected CommonHFSCatalogLeafNode(byte[] data, int offset, int nodeSize, CommonBTNode.FSType type) {
        super(data, offset, nodeSize, type);
    }

    public CommonHFSCatalogLeafRecord[] getLeafRecords() {
        return (CommonHFSCatalogLeafRecord[]) this.ic.records.toArray(new CommonHFSCatalogLeafRecord[this.ic.records.size()]);
    }

    public static CommonHFSCatalogLeafNode createHFSPlus(byte[] data, int offset, int nodeSize) {
        return new HFSPlusImplementation(data, offset, nodeSize);
    }

    public static CommonHFSCatalogLeafNode createHFSX(byte[] data, int offset, int nodeSize, BTHeaderRec bthr) {
        return new HFSXImplementation(data, offset, nodeSize, bthr).getInternal();
    }

    public static CommonHFSCatalogLeafNode createHFS(byte[] data, int offset, int nodeSize) {
        return new HFSImplementation(data, offset, nodeSize);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode$HFSPlusImplementation.class */
    private static class HFSPlusImplementation extends CommonHFSCatalogLeafNode {
        public HFSPlusImplementation(byte[] data, int offset, int nodeSize) {
            super(data, offset, nodeSize, CommonBTNode.FSType.HFS_PLUS);
        }

        protected HFSPlusCatalogKey createKey(byte[] data, int offset, int length) {
            return new HFSPlusCatalogKey(data, offset);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
        public CommonHFSCatalogLeafRecord createBTRecord(int recordNumber, byte[] data, int offset, int length) {
            return CommonHFSCatalogLeafRecord.createHFSPlus(data, offset, length);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode$HFSXImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode$HFSXImplementation.class */
    public static class HFSXImplementation {
        private final BTHeaderRec bthr;
        private final Internal internal;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
          hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode$HFSXImplementation$Internal.class
         */
        /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode$HFSXImplementation$Internal.class */
        public class Internal extends CommonHFSCatalogLeafNode {
            public Internal(byte[] data, int offset, int nodeSize) {
                super(data, offset, nodeSize, CommonBTNode.FSType.HFS_PLUS);
                if (HFSXImplementation.this.bthr == null) {
                    throw new IllegalArgumentException("bthr == null");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
            public CommonHFSCatalogLeafRecord createBTRecord(int recordNumber, byte[] data, int offset, int length) {
                if (HFSXImplementation.this.bthr == null) {
                    throw new IllegalArgumentException("bthr == null");
                }
                return CommonHFSCatalogLeafRecord.createHFSX(data, offset, length, HFSXImplementation.this.bthr);
            }
        }

        public HFSXImplementation(byte[] data, int offset, int nodeSize, BTHeaderRec bthr) {
            this.bthr = bthr;
            this.internal = new Internal(data, offset, nodeSize);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Internal getInternal() {
            return this.internal;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafNode$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogLeafNode {
        public HFSImplementation(byte[] data, int offset, int nodeSize) {
            super(data, offset, nodeSize, CommonBTNode.FSType.HFS);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
        public CommonHFSCatalogLeafRecord createBTRecord(int recordNumber, byte[] data, int offset, int length) {
            return CommonHFSCatalogLeafRecord.createHFS(data, offset, length);
        }
    }
}
