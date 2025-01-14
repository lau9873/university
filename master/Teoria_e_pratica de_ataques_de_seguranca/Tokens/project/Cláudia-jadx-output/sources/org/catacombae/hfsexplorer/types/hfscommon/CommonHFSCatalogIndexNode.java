package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.hfsexplorer.types.hfs.CatKeyRec;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode.class */
public abstract class CommonHFSCatalogIndexNode extends CommonBTIndexNode<CommonHFSCatalogKey> {
    protected CommonHFSCatalogIndexNode(byte[] data, int offset, int nodeSize, CommonBTNode.FSType type) {
        super(data, offset, nodeSize, type);
    }

    public static CommonHFSCatalogIndexNode createHFS(byte[] data, int offset, int nodeSize) {
        return new HFSImplementation(data, offset, nodeSize).getNode();
    }

    public static CommonHFSCatalogIndexNode createHFSPlus(byte[] data, int offset, int nodeSize) {
        return new HFSPlusImplementation(data, offset, nodeSize).getNode();
    }

    public static CommonHFSCatalogIndexNode createHFSX(byte[] data, int offset, int nodeSize, BTHeaderRec bthr) {
        return new HFSXImplementation(data, offset, nodeSize, bthr).getNode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSImplementation.class */
    public static class HFSImplementation {

        /* renamed from: i  reason: collision with root package name */
        private final Internal f7641i;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
          hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSImplementation$Internal.class
         */
        /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSImplementation$Internal.class */
        public class Internal extends CommonHFSCatalogIndexNode {
            public Internal(byte[] data, int offset, int nodeSize) {
                super(data, offset, nodeSize, CommonBTNode.FSType.HFS);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
            public CommonBTIndexRecord<CommonHFSCatalogKey> createBTRecord(int recordNumber, byte[] data, int offset, int length) {
                CommonHFSCatalogKey currentKey = CommonHFSCatalogKey.create(new CatKeyRec(data, offset));
                return CommonBTIndexRecord.createHFS(currentKey, data, offset);
            }
        }

        public HFSImplementation(byte[] data, int offset, int nodeSize) {
            this.f7641i = new Internal(data, offset, nodeSize);
        }

        public CommonHFSCatalogIndexNode getNode() {
            return this.f7641i;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSPlusImplementation.class */
    private static class HFSPlusImplementation {

        /* renamed from: i  reason: collision with root package name */
        private final Internal f7642i;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
          hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSPlusImplementation$Internal.class
         */
        /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSPlusImplementation$Internal.class */
        public class Internal extends CommonHFSCatalogIndexNode {
            public Internal(byte[] data, int offset, int nodeSize) {
                super(data, offset, nodeSize, CommonBTNode.FSType.HFS_PLUS);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
            public CommonBTIndexRecord<CommonHFSCatalogKey> createBTRecord(int recordNumber, byte[] data, int offset, int length) {
                CommonHFSCatalogKey currentKey = CommonHFSCatalogKey.create(new HFSPlusCatalogKey(data, offset));
                return CommonBTIndexRecord.createHFSPlus(currentKey, data, offset);
            }
        }

        public HFSPlusImplementation(byte[] data, int offset, int nodeSize) {
            this.f7642i = new Internal(data, offset, nodeSize);
        }

        public CommonHFSCatalogIndexNode getNode() {
            return this.f7642i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSXImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSXImplementation.class */
    public static class HFSXImplementation {

        /* renamed from: i  reason: collision with root package name */
        private final Internal f7643i;
        private final BTHeaderRec catalogHeaderRec;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
          hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSXImplementation$Internal.class
         */
        /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogIndexNode$HFSXImplementation$Internal.class */
        public class Internal extends CommonHFSCatalogIndexNode {
            public Internal(byte[] data, int offset, int nodeSize) {
                super(data, offset, nodeSize, CommonBTNode.FSType.HFS_PLUS);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
            public CommonBTIndexRecord<CommonHFSCatalogKey> createBTRecord(int recordNumber, byte[] data, int offset, int length) {
                CommonHFSCatalogKey currentKey = CommonHFSCatalogKey.create(new HFSXCatalogKey(data, offset, HFSXImplementation.this.catalogHeaderRec));
                return CommonBTIndexRecord.createHFSPlus(currentKey, data, offset);
            }
        }

        public HFSXImplementation(byte[] data, int offset, int nodeSize, BTHeaderRec catalogHeaderRec) {
            this.catalogHeaderRec = catalogHeaderRec;
            this.f7643i = new Internal(data, offset, nodeSize);
        }

        public CommonHFSCatalogIndexNode getNode() {
            return this.f7643i;
        }
    }
}
