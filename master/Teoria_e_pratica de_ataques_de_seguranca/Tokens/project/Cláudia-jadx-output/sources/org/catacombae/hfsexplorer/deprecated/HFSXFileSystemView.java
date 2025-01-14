package org.catacombae.hfsexplorer.deprecated;

import org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogIndexNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecord;
import org.catacombae.hfsexplorer.types.hfsplus.HFSUniStr255;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogIndexNode;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogKey;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogLeafNode;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogLeafRecord;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSXFileSystemView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSXFileSystemView.class */
public class HFSXFileSystemView extends HFSPlusFileSystemView {
    protected static final HFSPlusFileSystemView.CatalogOperations HFSX_OPERATIONS = new HFSPlusFileSystemView.CatalogOperations() { // from class: org.catacombae.hfsexplorer.deprecated.HFSXFileSystemView.1
        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.CatalogOperations
        public HFSPlusCatalogIndexNode newCatalogIndexNode(byte[] data, int offset, int nodeSize, BTHeaderRec bthr) {
            return new HFSXCatalogIndexNode(data, offset, nodeSize, bthr);
        }

        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.CatalogOperations
        public HFSPlusCatalogKey newCatalogKey(HFSCatalogNodeID nodeID, HFSUniStr255 searchString, BTHeaderRec bthr) {
            return new HFSXCatalogKey(nodeID, searchString, bthr);
        }

        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.CatalogOperations
        public HFSPlusCatalogLeafNode newCatalogLeafNode(byte[] data, int offset, int nodeSize, BTHeaderRec bthr) {
            return new HFSXCatalogLeafNode(data, offset, nodeSize, bthr);
        }

        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.CatalogOperations
        public HFSPlusCatalogLeafRecord newCatalogLeafRecord(byte[] data, int offset, BTHeaderRec bthr) {
            return new HFSXCatalogLeafRecord(data, offset, bthr);
        }
    };

    public HFSXFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, boolean cachingEnabled) {
        super(hfsFile, fsOffset, HFSX_OPERATIONS, cachingEnabled);
    }
}
