package org.catacombae.hfsexplorer.fs;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView;
import org.catacombae.hfsexplorer.io.ReadableRandomAccessSubstream;
import org.catacombae.hfsexplorer.types.hfs.BTHdrRec;
import org.catacombae.hfsexplorer.types.hfs.CatKeyRec;
import org.catacombae.hfsexplorer.types.hfs.ExtKeyRec;
import org.catacombae.hfsexplorer.types.hfs.MasterDirectoryBlock;
import org.catacombae.hfsexplorer.types.hfs.NodeDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogIndexNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogKey;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogString;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentIndexNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkType;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader;
import org.catacombae.hfsexplorer.types.hfsplus.JournalInfoBlock;
import org.catacombae.io.Readable;
import org.catacombae.io.ReadableConcatenatedStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSFileSystemView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSFileSystemView.class */
public class ImplHFSFileSystemView extends BaseHFSFileSystemView {
    private static final CommonHFSCatalogString EMPTY_STRING = CommonHFSCatalogString.createHFS(new byte[0]);
    protected static final BaseHFSFileSystemView.CatalogOperations HFS_OPERATIONS = new BaseHFSFileSystemView.CatalogOperations() { // from class: org.catacombae.hfsexplorer.fs.ImplHFSFileSystemView.1
        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogIndexNode newCatalogIndexNode(byte[] data, int offset, int nodeSize, CommonBTHeaderRecord bthr) {
            return CommonHFSCatalogIndexNode.createHFS(data, offset, nodeSize);
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogKey newCatalogKey(CommonHFSCatalogNodeID nodeID, CommonHFSCatalogString searchString, CommonBTHeaderRecord bthr) {
            return CommonHFSCatalogKey.create(new CatKeyRec((int) nodeID.toLong(), searchString.getStringBytes()));
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogLeafNode newCatalogLeafNode(byte[] data, int offset, int nodeSize, CommonBTHeaderRecord bthr) {
            return CommonHFSCatalogLeafNode.createHFS(data, offset, nodeSize);
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.CatalogOperations
        public CommonHFSCatalogLeafRecord newCatalogLeafRecord(byte[] data, int offset, CommonBTHeaderRecord bthr) {
            return CommonHFSCatalogLeafRecord.createHFS(data, offset, data.length - offset);
        }
    };
    private final MutableStringCodec<CharsetStringCodec> stringCodec;

    public ImplHFSFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, boolean cachingEnabled, String encodingName) {
        this(hfsFile, fileReadOffset, HFS_OPERATIONS, cachingEnabled, encodingName);
    }

    protected ImplHFSFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, BaseHFSFileSystemView.CatalogOperations catOps, boolean cachingEnabled, String encodingName) {
        super(hfsFile, fsOffset, catOps, cachingEnabled);
        this.stringCodec = new MutableStringCodec<>(new CharsetStringCodec(encodingName));
    }

    public MasterDirectoryBlock getMasterDirectoryBlock() {
        byte[] currentBlock = new byte[512];
        this.hfsFile.readFrom(this.fsOffset + 1024, currentBlock);
        return new MasterDirectoryBlock(currentBlock, 0);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public CommonHFSVolumeHeader getVolumeHeader() {
        return CommonHFSVolumeHeader.create(getMasterDirectoryBlock());
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonBTNodeDescriptor getNodeDescriptor(Readable rd) {
        byte[] data = new byte[NodeDescriptor.length()];
        rd.readFully(data);
        return createCommonBTNodeDescriptor(data, 0);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonBTHeaderRecord getHeaderRecord(Readable rd) {
        byte[] data = new byte[BTHdrRec.length()];
        rd.readFully(data);
        BTHdrRec bthr = new BTHdrRec(data, 0);
        return CommonBTHeaderRecord.create(bthr);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonBTNodeDescriptor createCommonBTNodeDescriptor(byte[] currentNodeData, int i2) {
        NodeDescriptor nd = new NodeDescriptor(currentNodeData, i2);
        return CommonBTNodeDescriptor.create(nd);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonHFSExtentIndexNode createCommonHFSExtentIndexNode(byte[] currentNodeData, int i2, int nodeSize) {
        return CommonHFSExtentIndexNode.createHFS(currentNodeData, i2, nodeSize);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonHFSExtentLeafNode createCommonHFSExtentLeafNode(byte[] currentNodeData, int i2, int nodeSize) {
        return CommonHFSExtentLeafNode.createHFS(currentNodeData, i2, nodeSize);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonHFSExtentKey createCommonHFSExtentKey(CommonHFSForkType forkType, CommonHFSCatalogNodeID fileID, int startBlock) {
        byte forkTypeByte;
        if (startBlock < -32768 || startBlock > 32767) {
            throw new IllegalArgumentException("start block out of range for short (signed 16-bit integer)");
        }
        short startBlockShort = (short) startBlock;
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
        ExtKeyRec key = new ExtKeyRec(forkTypeByte, (int) fileID.toLong(), startBlockShort);
        return CommonHFSExtentKey.create(key);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonHFSCatalogNodeID getCommonHFSCatalogNodeID(CommonHFSCatalogNodeID.ReservedID requestedNodeID) {
        return CommonHFSCatalogNodeID.getHFSReservedID(requestedNodeID);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public JournalInfoBlock getJournalInfoBlock() {
        return null;
    }

    public void setStringEncoding(String encodingName) {
        this.stringCodec.setDecoder(new CharsetStringCodec(encodingName));
    }

    public String getStringEncoding() {
        return this.stringCodec.getDecoder().getCharsetName();
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public CommonHFSCatalogString encodeString(String str) {
        byte[] bytes = this.stringCodec.encode(str);
        return CommonHFSCatalogString.createHFS(bytes);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public String decodeString(CommonHFSCatalogString str) {
        if (str instanceof CommonHFSCatalogString.HFSImplementation) {
            return this.stringCodec.decode(str.getStringBytes());
        }
        throw new RuntimeException("Invalid string type: " + str.getClass());
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    protected CommonBTHeaderNode createCommonBTHeaderNode(byte[] currentNodeData, int offset, int nodeSize) {
        return CommonBTHeaderNode.createHFS(currentNodeData, offset, nodeSize);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public BaseHFSAllocationFileView getAllocationFileView() {
        MasterDirectoryBlock mdb = getMasterDirectoryBlock();
        int numAllocationBlocks = Util.unsign(mdb.getDrNmAlBlks());
        int volumeBitmapSize = (numAllocationBlocks / 8) + (numAllocationBlocks % 8 != 0 ? 1 : 0);
        ReadableConcatenatedStream volumeBitmapStream = new ReadableConcatenatedStream(new ReadableRandomAccessSubstream(this.hfsFile), this.fsOffset + (512 * Util.unsign(mdb.getDrVBMSt())), volumeBitmapSize);
        return new ImplHFSAllocationFileView(this, volumeBitmapStream);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView
    public CommonHFSCatalogString getEmptyString() {
        return EMPTY_STRING;
    }
}
