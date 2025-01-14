package org.catacombae.hfsexplorer.fs;

import org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogIndexNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogKey;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogString;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfsplus.HFSUniStr255;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogKey;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSXFileSystemView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSXFileSystemView.class */
public class ImplHFSXFileSystemView extends ImplHFSPlusFileSystemView {
    protected static final BaseHFSFileSystemView.CatalogOperations HFSX_OPERATIONS = new BaseHFSFileSystemView.CatalogOperations() { // from class: org.catacombae.hfsexplorer.fs.ImplHFSXFileSystemView.1
        private BTHeaderRec getBTHeaderRec(CommonBTHeaderRecord bthr) {
            if (bthr instanceof CommonBTHeaderRecord.HFSPlusImplementation) {
                return ((CommonBTHeaderRecord.HFSPlusImplementation) bthr).getInternal();
            }
            throw new IllegalArgumentException("Invalid type of bthr: " + bthr);
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogIndexNode newCatalogIndexNode(byte[] data, int offset, int nodeSize, CommonBTHeaderRecord bthr) {
            BTHeaderRec trueBthr = getBTHeaderRec(bthr);
            return CommonHFSCatalogIndexNode.createHFSX(data, offset, nodeSize, trueBthr);
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogKey newCatalogKey(CommonHFSCatalogNodeID nodeID, CommonHFSCatalogString searchString, CommonBTHeaderRecord bthr) {
            BTHeaderRec trueBthr = getBTHeaderRec(bthr);
            return CommonHFSCatalogKey.create(new HFSXCatalogKey(new HFSCatalogNodeID((int) nodeID.toLong()), new HFSUniStr255(searchString.getStructBytes(), 0), trueBthr));
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogLeafNode newCatalogLeafNode(byte[] data, int offset, int nodeSize, CommonBTHeaderRecord bthr) {
            BTHeaderRec trueBthr = getBTHeaderRec(bthr);
            return CommonHFSCatalogLeafNode.createHFSX(data, offset, nodeSize, trueBthr);
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogLeafRecord newCatalogLeafRecord(byte[] data, int offset, CommonBTHeaderRecord bthr) {
            BTHeaderRec trueBthr = getBTHeaderRec(bthr);
            return CommonHFSCatalogLeafRecord.createHFSX(data, offset, offset + data.length, trueBthr);
        }
    };

    public ImplHFSXFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, boolean cachingEnabled) {
        super(hfsFile, fsOffset, HFSX_OPERATIONS, cachingEnabled);
    }
}
