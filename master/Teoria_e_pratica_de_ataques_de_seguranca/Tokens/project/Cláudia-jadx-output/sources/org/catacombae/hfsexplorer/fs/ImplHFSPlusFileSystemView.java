package org.catacombae.hfsexplorer.fs;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView;
import org.catacombae.hfsexplorer.io.ForkFilter;
import org.catacombae.hfsexplorer.io.ReadableRandomAccessSubstream;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogIndexNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogKey;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogString;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentIndexNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkData;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkType;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.BTNodeDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusVolumeHeader;
import org.catacombae.hfsexplorer.types.hfsplus.HFSUniStr255;
import org.catacombae.hfsexplorer.types.hfsplus.JournalInfoBlock;
import org.catacombae.io.Readable;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSPlusFileSystemView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSPlusFileSystemView.class */
public class ImplHFSPlusFileSystemView extends BaseHFSFileSystemView {
    private static final CommonHFSCatalogString EMPTY_STRING = CommonHFSCatalogString.createHFSPlus(new HFSUniStr255(""));
    protected static final BaseHFSFileSystemView.CatalogOperations HFS_PLUS_OPERATIONS = new BaseHFSFileSystemView.CatalogOperations() { // from class: org.catacombae.hfsexplorer.fs.ImplHFSPlusFileSystemView.1
        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogIndexNode newCatalogIndexNode(byte[] data, int offset, int nodeSize, CommonBTHeaderRecord bthr) {
            return CommonHFSCatalogIndexNode.createHFSPlus(data, offset, nodeSize);
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogKey newCatalogKey(CommonHFSCatalogNodeID nodeID, CommonHFSCatalogString searchString, CommonBTHeaderRecord bthr) {
            return CommonHFSCatalogKey.create(new HFSPlusCatalogKey(new HFSCatalogNodeID((int) nodeID.toLong()), new HFSUniStr255(searchString.getStructBytes(), 0)));
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogLeafNode newCatalogLeafNode(byte[] data, int offset, int nodeSize, CommonBTHeaderRecord bthr) {
            return CommonHFSCatalogLeafNode.createHFSPlus(data, offset, nodeSize);
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogLeafRecord newCatalogLeafRecord(byte[] data, int offset, CommonBTHeaderRecord bthr) {
            return CommonHFSCatalogLeafRecord.createHFSPlus(data, offset, data.length - offset);
        }
    };

    public ImplHFSPlusFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, boolean cachingEnabled) {
        this(hfsFile, fileReadOffset, HFS_PLUS_OPERATIONS, cachingEnabled);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImplHFSPlusFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, BaseHFSFileSystemView.CatalogOperations catOps, boolean cachingEnabled) {
        super(hfsFile, fsOffset, catOps, cachingEnabled);
    }

    public HFSPlusVolumeHeader getHFSPlusVolumeHeader() {
        byte[] currentBlock = new byte[512];
        this.hfsFile.readFrom(this.fsOffset + 1024, currentBlock);
        return new HFSPlusVolumeHeader(currentBlock);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public CommonHFSVolumeHeader getVolumeHeader() {
        return CommonHFSVolumeHeader.create(getHFSPlusVolumeHeader());
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonBTNodeDescriptor getNodeDescriptor(Readable rd) {
        byte[] data = new byte[BTNodeDescriptor.length()];
        rd.readFully(data);
        BTNodeDescriptor btnd = new BTNodeDescriptor(data, 0);
        return CommonBTNodeDescriptor.create(btnd);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonBTHeaderRecord getHeaderRecord(Readable rd) {
        byte[] data = new byte[BTHeaderRec.length()];
        rd.readFully(data);
        BTHeaderRec bthr = new BTHeaderRec(data, 0);
        return CommonBTHeaderRecord.create(bthr);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonBTNodeDescriptor createCommonBTNodeDescriptor(byte[] currentNodeData, int offset) {
        BTNodeDescriptor btnd = new BTNodeDescriptor(currentNodeData, offset);
        return CommonBTNodeDescriptor.create(btnd);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonHFSExtentIndexNode createCommonHFSExtentIndexNode(byte[] currentNodeData, int offset, int nodeSize) {
        return CommonHFSExtentIndexNode.createHFSPlus(currentNodeData, offset, nodeSize);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonHFSExtentLeafNode createCommonHFSExtentLeafNode(byte[] currentNodeData, int offset, int nodeSize) {
        return CommonHFSExtentLeafNode.createHFSPlus(currentNodeData, offset, nodeSize);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonHFSExtentKey createCommonHFSExtentKey(CommonHFSForkType forkType, CommonHFSCatalogNodeID fileID, int startBlock) {
        byte forkTypeByte;
        switch (forkType) {
            case DATA_FORK:
                forkTypeByte = 0;
                break;
            case RESOURCE_FORK:
                forkTypeByte = -1;
                break;
            default:
                throw new RuntimeException("Invalid fork type");
        }
        HFSPlusExtentKey key = new HFSPlusExtentKey(forkTypeByte, new HFSCatalogNodeID((int) fileID.toLong()), startBlock);
        return CommonHFSExtentKey.create(key);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonHFSCatalogNodeID getCommonHFSCatalogNodeID(CommonHFSCatalogNodeID.ReservedID requestedNodeID) {
        return CommonHFSCatalogNodeID.getHFSPlusReservedID(requestedNodeID);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public JournalInfoBlock getJournalInfoBlock() {
        HFSPlusVolumeHeader vh = getHFSPlusVolumeHeader();
        if (vh.getAttributeVolumeJournaled()) {
            long blockNumber = Util.unsign(vh.getJournalInfoBlock());
            byte[] data = new byte[JournalInfoBlock.getStructSize()];
            this.hfsFile.readFullyFrom(this.fsOffset + (blockNumber * vh.getBlockSize()), data);
            return new JournalInfoBlock(data, 0);
        }
        return null;
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public CommonHFSCatalogString encodeString(String str) {
        return CommonHFSCatalogString.HFSPlusImplementation.createHFSPlus(new HFSUniStr255(str));
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public String decodeString(CommonHFSCatalogString str) {
        if (str instanceof CommonHFSCatalogString.HFSPlusImplementation) {
            CommonHFSCatalogString.HFSPlusImplementation hStr = (CommonHFSCatalogString.HFSPlusImplementation) str;
            return new String(hStr.getInternal().getUnicode());
        }
        throw new RuntimeException("Invalid string type: " + str.getClass());
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonBTHeaderNode createCommonBTHeaderNode(byte[] currentNodeData, int offset, int nodeSize) {
        return CommonBTHeaderNode.createHFSPlus(currentNodeData, offset, nodeSize);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public BaseHFSAllocationFileView getAllocationFileView() {
        HFSPlusVolumeHeader vh = getHFSPlusVolumeHeader();
        CommonHFSForkData allocationFileFork = CommonHFSForkData.create(vh.getAllocationFile());
        CommonHFSExtentDescriptor[] extDescriptors = getAllExtentDescriptors(CommonHFSCatalogNodeID.getHFSPlusReservedID(CommonHFSCatalogNodeID.ReservedID.ALLOCATION_FILE), allocationFileFork, CommonHFSForkType.DATA_FORK);
        ForkFilter allocationFileStream = new ForkFilter(allocationFileFork, extDescriptors, new ReadableRandomAccessSubstream(this.hfsFile), this.fsOffset, Util.unsign(vh.getBlockSize()), 0L);
        return new ImplHFSPlusAllocationFileView(this, allocationFileStream);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public CommonHFSCatalogString getEmptyString() {
        return EMPTY_STRING;
    }
}
