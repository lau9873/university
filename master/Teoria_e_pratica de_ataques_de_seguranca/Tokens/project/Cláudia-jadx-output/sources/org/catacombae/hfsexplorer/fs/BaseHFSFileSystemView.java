package org.catacombae.hfsexplorer.fs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.catacombae.hfsexplorer.io.ForkFilter;
import org.catacombae.hfsexplorer.io.ReadableBlockCachingStream;
import org.catacombae.hfsexplorer.io.ReadableRandomAccessSubstream;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccess;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccessStream;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTIndexNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTIndexRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTKey;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThreadRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThreadRecord;
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
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkData;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkType;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader;
import org.catacombae.hfsexplorer.types.hfsplus.JournalInfoBlock;
import org.catacombae.io.Readable;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView.class */
public abstract class BaseHFSFileSystemView {
    public static volatile long fileReadOffset = 0;
    protected volatile SynchronizedReadableRandomAccess hfsFile;
    private volatile SynchronizedReadableRandomAccessStream hfsStream;
    private final ReadableRandomAccessStream sourceStream;
    protected final long fsOffset;
    protected final CatalogOperations catOps;
    protected final int physicalBlockSize = 512;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView$CatalogOperations.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView$CatalogOperations.class */
    public interface CatalogOperations {
        CommonHFSCatalogIndexNode newCatalogIndexNode(byte[] bArr, int i2, int i3, CommonBTHeaderRecord commonBTHeaderRecord);

        CommonHFSCatalogKey newCatalogKey(CommonHFSCatalogNodeID commonHFSCatalogNodeID, CommonHFSCatalogString commonHFSCatalogString, CommonBTHeaderRecord commonBTHeaderRecord);

        CommonHFSCatalogLeafNode newCatalogLeafNode(byte[] bArr, int i2, int i3, CommonBTHeaderRecord commonBTHeaderRecord);

        CommonHFSCatalogLeafRecord newCatalogLeafRecord(byte[] bArr, int i2, CommonBTHeaderRecord commonBTHeaderRecord);
    }

    public abstract CommonHFSVolumeHeader getVolumeHeader();

    protected abstract CommonBTHeaderNode createCommonBTHeaderNode(byte[] bArr, int i2, int i3);

    protected abstract CommonBTNodeDescriptor getNodeDescriptor(Readable readable);

    protected abstract CommonBTHeaderRecord getHeaderRecord(Readable readable);

    protected abstract CommonBTNodeDescriptor createCommonBTNodeDescriptor(byte[] bArr, int i2);

    protected abstract CommonHFSExtentIndexNode createCommonHFSExtentIndexNode(byte[] bArr, int i2, int i3);

    protected abstract CommonHFSExtentLeafNode createCommonHFSExtentLeafNode(byte[] bArr, int i2, int i3);

    protected abstract CommonHFSExtentKey createCommonHFSExtentKey(CommonHFSForkType commonHFSForkType, CommonHFSCatalogNodeID commonHFSCatalogNodeID, int i2);

    protected abstract CommonHFSCatalogNodeID getCommonHFSCatalogNodeID(CommonHFSCatalogNodeID.ReservedID reservedID);

    public abstract BaseHFSAllocationFileView getAllocationFileView();

    public abstract CommonHFSCatalogString getEmptyString();

    public abstract String decodeString(CommonHFSCatalogString commonHFSCatalogString);

    public abstract CommonHFSCatalogString encodeString(String str);

    public abstract JournalInfoBlock getJournalInfoBlock();

    public void close() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView$InitProcedure.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView$InitProcedure.class */
    public abstract class InitProcedure {
        public final CommonHFSVolumeHeader header;
        public final ReadableRandomAccessStream forkFilterFile;
        public final CommonBTNodeDescriptor btnd;
        public final CommonBTHeaderRecord bthr;

        protected abstract ReadableRandomAccessStream getForkFilterFile(CommonHFSVolumeHeader commonHFSVolumeHeader);

        public InitProcedure() {
            this.header = BaseHFSFileSystemView.this.getVolumeHeader();
            this.forkFilterFile = getForkFilterFile(this.header);
            this.forkFilterFile.seek(0L);
            this.btnd = BaseHFSFileSystemView.this.getNodeDescriptor(this.forkFilterFile);
            this.bthr = BaseHFSFileSystemView.this.getHeaderRecord(this.forkFilterFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView$CatalogInitProcedure.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView$CatalogInitProcedure.class */
    public class CatalogInitProcedure extends InitProcedure {
        public final ReadableRandomAccessStream catalogFile;

        public CatalogInitProcedure() {
            super();
            this.catalogFile = this.forkFilterFile;
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.InitProcedure
        protected ReadableRandomAccessStream getForkFilterFile(CommonHFSVolumeHeader header) {
            CommonHFSExtentDescriptor[] allCatalogFileDescriptors = BaseHFSFileSystemView.this.getAllDataExtentDescriptors(BaseHFSFileSystemView.this.getCommonHFSCatalogNodeID(CommonHFSCatalogNodeID.ReservedID.CATALOG_FILE), header.getCatalogFile());
            return new ForkFilter(header.getCatalogFile(), allCatalogFileDescriptors, new ReadableRandomAccessSubstream(BaseHFSFileSystemView.this.hfsFile), BaseHFSFileSystemView.this.fsOffset, header.getAllocationBlockSize(), header.getAllocationBlockStart() * BaseHFSFileSystemView.this.physicalBlockSize);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView$ExtentsInitProcedure.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSFileSystemView$ExtentsInitProcedure.class */
    public class ExtentsInitProcedure extends InitProcedure {
        public final ReadableRandomAccessStream extentsFile;

        public ExtentsInitProcedure() {
            super();
            this.extentsFile = this.forkFilterFile;
        }

        @Override // org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView.InitProcedure
        protected ReadableRandomAccessStream getForkFilterFile(CommonHFSVolumeHeader header) {
            return new ForkFilter(header.getExtentsOverflowFile(), header.getExtentsOverflowFile().getBasicExtents(), new ReadableRandomAccessSubstream(BaseHFSFileSystemView.this.hfsFile), BaseHFSFileSystemView.this.fsOffset, header.getAllocationBlockSize(), header.getAllocationBlockStart() * BaseHFSFileSystemView.this.physicalBlockSize);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseHFSFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, CatalogOperations ops, boolean cachingEnabled) {
        this.sourceStream = hfsFile;
        this.hfsStream = new SynchronizedReadableRandomAccessStream(this.sourceStream);
        this.hfsFile = this.hfsStream;
        this.fsOffset = fsOffset;
        this.catOps = ops;
        if (cachingEnabled) {
            enableFileSystemCaching();
        }
    }

    public void enableFileSystemCaching() {
        enableFileSystemCaching(262144, 64);
    }

    public void enableFileSystemCaching(int blockSize, int blocksInCache) {
        this.hfsStream = new SynchronizedReadableRandomAccessStream(new ReadableBlockCachingStream(this.sourceStream, blockSize, blocksInCache));
        this.hfsFile = this.hfsStream;
    }

    public void disableFileSystemCaching() {
        this.hfsStream = new SynchronizedReadableRandomAccessStream(this.sourceStream);
        this.hfsFile = this.hfsStream;
    }

    public CommonHFSCatalogFolderRecord getRoot() {
        CommonBTNodeDescriptor nodeDescriptor;
        CatalogInitProcedure init = new CatalogInitProcedure();
        CommonHFSCatalogNodeID parentID = getCommonHFSCatalogNodeID(CommonHFSCatalogNodeID.ReservedID.ROOT_PARENT);
        int nodeSize = init.bthr.getNodeSize();
        long currentNodeOffset = init.bthr.getRootNodeNumber() * init.bthr.getNodeSize();
        byte[] currentNodeData = new byte[nodeSize];
        init.catalogFile.seek(currentNodeOffset);
        init.catalogFile.readFully(currentNodeData);
        CommonBTNodeDescriptor createCommonBTNodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
        while (true) {
            nodeDescriptor = createCommonBTNodeDescriptor;
            if (nodeDescriptor.getNodeType() != CommonBTNodeDescriptor.NodeType.INDEX) {
                break;
            }
            CommonHFSCatalogIndexNode currentNode = this.catOps.newCatalogIndexNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
            CommonBTIndexRecord matchingRecord = findKey(currentNode, parentID);
            long currentNodeOffset2 = matchingRecord.getIndex() * nodeSize;
            init.catalogFile.seek(currentNodeOffset2);
            init.catalogFile.readFully(currentNodeData);
            createCommonBTNodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
        }
        if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.LEAF) {
            CommonHFSCatalogLeafNode leaf = this.catOps.newCatalogLeafNode(currentNodeData, 0, nodeSize, init.bthr);
            CommonHFSCatalogLeafRecord[] recs = leaf.getLeafRecords();
            for (CommonHFSCatalogLeafRecord rec : recs) {
                if (rec.getKey().getParentID().toLong() == parentID.toLong()) {
                    if (rec instanceof CommonHFSCatalogFolderRecord) {
                        return (CommonHFSCatalogFolderRecord) rec;
                    } else {
                        throw new RuntimeException("Error in internal structures:  root node is not a folder record, but a " + rec.getClass());
                    }
                }
            }
            return null;
        }
        throw new RuntimeException("Expected leaf node. Found other kind: " + nodeDescriptor.getNodeType());
    }

    public CommonBTHeaderNode getCatalogHeaderNode() {
        CommonBTNode firstNode = getCatalogNode(0L);
        if (firstNode instanceof CommonBTHeaderNode) {
            return (CommonBTHeaderNode) firstNode;
        }
        throw new RuntimeException("Unexpected node type at catalog node 0: " + firstNode.getClass());
    }

    public CommonBTNode getCatalogNode(long nodeNumber) {
        long currentNodeNumber;
        CatalogInitProcedure init = new CatalogInitProcedure();
        if (nodeNumber < 0) {
            currentNodeNumber = init.bthr.getRootNodeNumber();
            if (currentNodeNumber == 0) {
                return null;
            }
        } else {
            currentNodeNumber = nodeNumber;
        }
        int nodeSize = init.bthr.getNodeSize();
        byte[] currentNodeData = new byte[nodeSize];
        try {
            init.catalogFile.seek(currentNodeNumber * nodeSize);
            init.catalogFile.readFully(currentNodeData);
            CommonBTNodeDescriptor nodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
            if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.HEADER) {
                return createCommonBTHeaderNode(currentNodeData, 0, init.bthr.getNodeSize());
            }
            if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.INDEX) {
                return this.catOps.newCatalogIndexNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
            }
            if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.LEAF) {
                return this.catOps.newCatalogLeafNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
            }
            return null;
        } catch (RuntimeException e2) {
            System.err.println("RuntimeException in getCatalogNode. Printing additional information:");
            System.err.println("  nodeNumber=" + nodeNumber);
            System.err.println("  currentNodeNumber=" + currentNodeNumber);
            System.err.println("  nodeSize=" + nodeSize);
            System.err.println("  init.catalogFile.length()=" + init.catalogFile.length());
            System.err.println("  (currentNodeNumber * nodeSize)=" + (currentNodeNumber * nodeSize));
            throw e2;
        }
    }

    public CommonBTNode getExtentsOverflowNode(long nodeNumber) {
        long currentNodeNumber;
        ExtentsInitProcedure init = new ExtentsInitProcedure();
        if (nodeNumber < 0) {
            currentNodeNumber = init.bthr.getRootNodeNumber();
            if (currentNodeNumber == 0) {
                return null;
            }
        } else {
            currentNodeNumber = nodeNumber;
        }
        int nodeSize = init.bthr.getNodeSize();
        byte[] currentNodeData = new byte[nodeSize];
        try {
            init.extentsFile.seek(currentNodeNumber * nodeSize);
            init.extentsFile.readFully(currentNodeData);
            CommonBTNodeDescriptor nodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
            if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.HEADER) {
                return createCommonBTHeaderNode(currentNodeData, 0, nodeSize);
            }
            if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.INDEX) {
                return createCommonHFSExtentIndexNode(currentNodeData, 0, nodeSize);
            }
            if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.LEAF) {
                return createCommonHFSExtentLeafNode(currentNodeData, 0, nodeSize);
            }
            return null;
        } catch (RuntimeException e2) {
            System.err.println("RuntimeException in getCatalogNode. Printing additional information:");
            System.err.println("  nodeNumber=" + nodeNumber);
            System.err.println("  currentNodeNumber=" + currentNodeNumber);
            System.err.println("  nodeSize=" + nodeSize);
            System.err.println("  init.extentsFile.length()=" + init.extentsFile.length());
            System.err.println("  (currentNodeNumber * nodeSize)=" + (currentNodeNumber * nodeSize));
            throw e2;
        }
    }

    public LinkedList<CommonHFSCatalogLeafRecord> getPathTo(CommonHFSCatalogNodeID leafID) {
        CommonHFSCatalogLeafRecord leafRec = getRecord(leafID, getEmptyString());
        if (leafRec != null) {
            return getPathTo(leafRec);
        }
        throw new RuntimeException("No folder thread found for leaf id " + leafID.toLong() + "!");
    }

    public LinkedList<CommonHFSCatalogLeafRecord> getPathTo(CommonHFSCatalogLeafRecord leaf) {
        if (leaf == null) {
            throw new IllegalArgumentException("argument \"leaf\" must not be null!");
        }
        LinkedList<CommonHFSCatalogLeafRecord> pathList = new LinkedList<>();
        pathList.addLast(leaf);
        CommonHFSCatalogNodeID parentID = leaf.getKey().getParentID();
        while (true) {
            CommonHFSCatalogNodeID parentID2 = parentID;
            if (!parentID2.equals(parentID2.getReservedID(CommonHFSCatalogNodeID.ReservedID.ROOT_PARENT))) {
                CommonHFSCatalogLeafRecord parent = getRecord(parentID2, getEmptyString());
                if (parent == null) {
                    throw new RuntimeException("No folder thread found!");
                }
                if (parent instanceof CommonHFSCatalogFolderThreadRecord) {
                    CommonHFSCatalogFolderThreadRecord threadRec = (CommonHFSCatalogFolderThreadRecord) parent;
                    CommonHFSCatalogFolderThread thread = threadRec.getData();
                    pathList.addFirst(getRecord(thread.getParentID(), thread.getNodeName()));
                    parentID = thread.getParentID();
                } else if (parent instanceof CommonHFSCatalogFileThreadRecord) {
                    throw new RuntimeException("Tried to get folder thread (" + parentID2 + ",\"\") but found a file thread!");
                } else {
                    throw new RuntimeException("Tried to get folder thread (" + parentID2 + ",\"\") but found a " + parent.getClass() + "!");
                }
            } else {
                return pathList;
            }
        }
    }

    public CommonHFSCatalogLeafRecord getRecord(CommonHFSCatalogNodeID parentID, CommonHFSCatalogString nodeName) {
        CatalogInitProcedure init = new CatalogInitProcedure();
        int nodeSize = init.bthr.getNodeSize();
        long currentNodeOffset = init.bthr.getRootNodeNumber() * nodeSize;
        byte[] currentNodeData = new byte[init.bthr.getNodeSize()];
        init.catalogFile.seek(currentNodeOffset);
        init.catalogFile.readFully(currentNodeData);
        CommonBTNodeDescriptor createCommonBTNodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
        while (true) {
            CommonBTNodeDescriptor nodeDescriptor = createCommonBTNodeDescriptor;
            if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.INDEX) {
                CommonHFSCatalogIndexNode currentNode = this.catOps.newCatalogIndexNode(currentNodeData, 0, nodeSize, init.bthr);
                CommonBTIndexRecord matchingRecord = findLEKey(currentNode, this.catOps.newCatalogKey(parentID, nodeName, init.bthr));
                if (matchingRecord == null) {
                    return null;
                }
                long currentNodeOffset2 = matchingRecord.getIndex() * nodeSize;
                init.catalogFile.seek(currentNodeOffset2);
                init.catalogFile.readFully(currentNodeData);
                createCommonBTNodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
            } else if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.LEAF) {
                CommonHFSCatalogLeafNode leaf = this.catOps.newCatalogLeafNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
                CommonHFSCatalogLeafRecord[] recs = leaf.getLeafRecords();
                for (CommonHFSCatalogLeafRecord rec : recs) {
                    if (rec.getKey().compareTo(this.catOps.newCatalogKey(parentID, nodeName, init.bthr)) == 0) {
                        return rec;
                    }
                }
                return null;
            } else {
                throw new RuntimeException("Expected leaf node. Found other kind: " + nodeDescriptor.getNodeType());
            }
        }
    }

    public CommonHFSCatalogLeafRecord[] listRecords(CommonHFSCatalogLeafRecord folderRecord) {
        if (folderRecord instanceof CommonHFSCatalogFolderRecord) {
            CommonHFSCatalogFolder folder = ((CommonHFSCatalogFolderRecord) folderRecord).getData();
            return listRecords(folder.getFolderID());
        }
        throw new RuntimeException("Invalid input (not a folder record).");
    }

    public CommonHFSCatalogLeafRecord[] listRecords(CommonHFSCatalogNodeID folderID) {
        CatalogInitProcedure init = new CatalogInitProcedure();
        ReadableRandomAccessStream catalogFile = init.forkFilterFile;
        return collectFilesInDir(folderID, init.bthr.getRootNodeNumber(), new ReadableRandomAccessSubstream(this.hfsFile), this.fsOffset, init.header, init.bthr, catalogFile);
    }

    public long extractDataForkToStream(CommonHFSCatalogLeafRecord fileRecord, OutputStream os, ProgressMonitor pm) throws IOException {
        if (fileRecord instanceof CommonHFSCatalogFileRecord) {
            CommonHFSCatalogFile catFile = ((CommonHFSCatalogFileRecord) fileRecord).getData();
            CommonHFSForkData dataFork = catFile.getDataFork();
            return extractForkToStream(dataFork, getAllDataExtentDescriptors(fileRecord), os, pm);
        }
        throw new IllegalArgumentException("fileRecord.getData() it not of type RECORD_TYPE_FILE");
    }

    public long extractResourceForkToStream(CommonHFSCatalogLeafRecord fileRecord, OutputStream os, ProgressMonitor pm) throws IOException {
        if (fileRecord instanceof CommonHFSCatalogFileRecord) {
            CommonHFSCatalogFile catFile = ((CommonHFSCatalogFileRecord) fileRecord).getData();
            CommonHFSForkData resFork = catFile.getResourceFork();
            return extractForkToStream(resFork, getAllResourceExtentDescriptors(fileRecord), os, pm);
        }
        throw new IllegalArgumentException("fileRecord.getData() it not of type RECORD_TYPE_FILE");
    }

    public long extractForkToStream(CommonHFSForkData forkData, CommonHFSExtentDescriptor[] extentDescriptors, OutputStream os, ProgressMonitor pm) throws IOException {
        CommonHFSVolumeHeader header = getVolumeHeader();
        ForkFilter forkFilter = new ForkFilter(forkData, extentDescriptors, new ReadableRandomAccessSubstream(this.hfsFile), this.fsOffset, header.getAllocationBlockSize(), header.getAllocationBlockStart() * this.physicalBlockSize);
        long bytesToRead = forkData.getLogicalSize();
        byte[] buffer = new byte[4096];
        while (bytesToRead > 0 && !pm.cancelSignaled()) {
            int bytesRead = forkFilter.read(buffer, 0, bytesToRead < ((long) buffer.length) ? (int) bytesToRead : buffer.length);
            if (bytesRead < 0) {
                break;
            }
            pm.addDataProgress(bytesRead);
            os.write(buffer, 0, bytesRead);
            bytesToRead -= bytesRead;
        }
        return forkData.getLogicalSize() - bytesToRead;
    }

    public ReadableRandomAccessStream getReadableDataForkStream(CommonHFSCatalogLeafRecord fileRecord) {
        if (fileRecord instanceof CommonHFSCatalogFileRecord) {
            CommonHFSCatalogFile catFile = ((CommonHFSCatalogFileRecord) fileRecord).getData();
            CommonHFSForkData fork = catFile.getDataFork();
            return getReadableForkStream(fork, getAllDataExtentDescriptors(fileRecord));
        }
        throw new IllegalArgumentException("fileRecord.getData() it not of type RECORD_TYPE_FILE");
    }

    public ReadableRandomAccessStream getReadableResourceForkStream(CommonHFSCatalogLeafRecord fileRecord) {
        if (fileRecord instanceof CommonHFSCatalogFileRecord) {
            CommonHFSCatalogFile catFile = ((CommonHFSCatalogFileRecord) fileRecord).getData();
            CommonHFSForkData fork = catFile.getResourceFork();
            return getReadableForkStream(fork, getAllResourceExtentDescriptors(fileRecord));
        }
        throw new IllegalArgumentException("fileRecord.getData() it not of type RECORD_TYPE_FILE");
    }

    private ReadableRandomAccessStream getReadableForkStream(CommonHFSForkData forkData, CommonHFSExtentDescriptor[] extentDescriptors) {
        CommonHFSVolumeHeader header = getVolumeHeader();
        return new ForkFilter(forkData, extentDescriptors, new ReadableRandomAccessSubstream(this.hfsFile), this.fsOffset + fileReadOffset, header.getAllocationBlockSize(), header.getAllocationBlockStart() * this.physicalBlockSize);
    }

    private static String getDebugString(CommonHFSExtentKey key) {
        return key.getForkType() + ":" + key.getFileID().toLong() + ":" + key.getStartBlock();
    }

    public CommonHFSExtentLeafRecord getOverflowExtent(CommonHFSExtentKey key) {
        CommonBTNodeDescriptor nodeDescriptor;
        ExtentsInitProcedure init = new ExtentsInitProcedure();
        int nodeSize = init.bthr.getNodeSize();
        long currentNodeOffset = init.bthr.getRootNodeNumber() * nodeSize;
        byte[] currentNodeData = new byte[nodeSize];
        init.extentsFile.seek(currentNodeOffset);
        init.extentsFile.readFully(currentNodeData);
        CommonBTNodeDescriptor createCommonBTNodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
        while (true) {
            nodeDescriptor = createCommonBTNodeDescriptor;
            if (nodeDescriptor.getNodeType() != CommonBTNodeDescriptor.NodeType.INDEX) {
                break;
            }
            CommonBTIndexNode<CommonHFSExtentKey> currentNode = createCommonHFSExtentIndexNode(currentNodeData, 0, nodeSize);
            CommonBTIndexRecord<CommonHFSExtentKey> matchingRecord = findLEKey(currentNode, key);
            long currentNodeOffset2 = matchingRecord.getIndex() * nodeSize;
            init.extentsFile.seek(currentNodeOffset2);
            init.extentsFile.readFully(currentNodeData);
            createCommonBTNodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
        }
        if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.LEAF) {
            CommonHFSExtentLeafNode leaf = createCommonHFSExtentLeafNode(currentNodeData, 0, nodeSize);
            CommonHFSExtentLeafRecord[] recs = leaf.getLeafRecords();
            for (CommonHFSExtentLeafRecord rec : recs) {
                CommonHFSExtentKey curKey = rec.getKey();
                if (curKey.compareTo(key) == 0) {
                    return rec;
                }
            }
            return null;
        }
        throw new RuntimeException("Expected leaf node. Found other kind: " + nodeDescriptor.getNodeType());
    }

    public CommonHFSExtentDescriptor[] getAllExtents(CommonHFSCatalogLeafRecord requestFile, CommonHFSForkType forkType) {
        CommonHFSForkData forkData;
        if (requestFile instanceof CommonHFSCatalogFileRecord) {
            CommonHFSCatalogFile catFile = ((CommonHFSCatalogFileRecord) requestFile).getData();
            if (forkType == CommonHFSForkType.DATA_FORK) {
                forkData = catFile.getDataFork();
            } else if (forkType == CommonHFSForkType.RESOURCE_FORK) {
                forkData = catFile.getResourceFork();
            } else {
                throw new IllegalArgumentException("Illegal fork type!");
            }
            return getAllExtents(catFile.getFileID(), forkData, forkType);
        }
        throw new IllegalArgumentException("Not a file record!");
    }

    public CommonHFSExtentDescriptor[] getAllExtents(CommonHFSCatalogNodeID fileID, CommonHFSForkData forkData, CommonHFSForkType forkType) {
        CommonHFSExtentDescriptor[] result;
        if (fileID == null) {
            throw new IllegalArgumentException("fileID == null");
        }
        if (forkData == null) {
            throw new IllegalArgumentException("forkData == null");
        }
        if (forkType == null) {
            throw new IllegalArgumentException("forkType == null");
        }
        long allocationBlockSize = getVolumeHeader().getAllocationBlockSize();
        long basicExtentsBlockCount = 0;
        CommonHFSExtentDescriptor[] basicExtents = forkData.getBasicExtents();
        for (CommonHFSExtentDescriptor commonHFSExtentDescriptor : basicExtents) {
            basicExtentsBlockCount += commonHFSExtentDescriptor.getBlockCount();
        }
        if (basicExtentsBlockCount * allocationBlockSize >= forkData.getLogicalSize()) {
            result = forkData.getBasicExtents();
        } else {
            LinkedList<CommonHFSExtentDescriptor> resultList = new LinkedList<>();
            CommonHFSExtentDescriptor[] arr$ = forkData.getBasicExtents();
            for (CommonHFSExtentDescriptor descriptor : arr$) {
                resultList.add(descriptor);
            }
            long totalBlockCount = basicExtentsBlockCount;
            while (totalBlockCount * allocationBlockSize < forkData.getLogicalSize()) {
                CommonHFSExtentKey extentKey = createCommonHFSExtentKey(forkType, fileID, (int) totalBlockCount);
                CommonHFSExtentLeafRecord currentRecord = getOverflowExtent(extentKey);
                if (currentRecord == null) {
                    System.err.println("ERROR: currentRecord == null!!");
                    System.err.print("       extentKey");
                    if (extentKey != null) {
                        System.err.println(":");
                        extentKey.print(System.err, "         ");
                    } else {
                        System.err.println(" == null!!");
                    }
                }
                CommonHFSExtentDescriptor[] currentRecordData = currentRecord.getRecordData();
                for (CommonHFSExtentDescriptor cur : currentRecordData) {
                    resultList.add(cur);
                    totalBlockCount += cur.getBlockCount();
                }
            }
            result = (CommonHFSExtentDescriptor[]) resultList.toArray(new CommonHFSExtentDescriptor[resultList.size()]);
        }
        return result;
    }

    public CommonHFSExtentDescriptor[] getAllExtentDescriptors(CommonHFSCatalogLeafRecord requestFile, CommonHFSForkType forkType) {
        return getAllExtentDescriptors(getAllExtents(requestFile, forkType));
    }

    public CommonHFSExtentDescriptor[] getAllExtentDescriptors(CommonHFSCatalogNodeID fileID, CommonHFSForkData forkData, CommonHFSForkType forkType) {
        return getAllExtentDescriptors(getAllExtents(fileID, forkData, forkType));
    }

    protected CommonHFSExtentDescriptor[] getAllExtentDescriptors(CommonHFSExtentDescriptor[] descriptors) {
        LinkedList<CommonHFSExtentDescriptor> descTmp = new LinkedList<>();
        for (CommonHFSExtentDescriptor desc : descriptors) {
            if (desc.getStartBlock() == 0 && desc.getBlockCount() == 0) {
                break;
            }
            descTmp.addLast(desc);
        }
        return (CommonHFSExtentDescriptor[]) descTmp.toArray(new CommonHFSExtentDescriptor[descTmp.size()]);
    }

    public CommonHFSExtentDescriptor[] getAllDataExtentDescriptors(CommonHFSCatalogNodeID fileID, CommonHFSForkData forkData) {
        return getAllExtentDescriptors(fileID, forkData, CommonHFSForkType.DATA_FORK);
    }

    public CommonHFSExtentDescriptor[] getAllDataExtentDescriptors(CommonHFSCatalogLeafRecord requestFile) {
        return getAllExtentDescriptors(requestFile, CommonHFSForkType.DATA_FORK);
    }

    public CommonHFSExtentDescriptor[] getAllResourceExtentDescriptors(CommonHFSCatalogNodeID fileID, CommonHFSForkData forkData) {
        return getAllExtentDescriptors(fileID, forkData, CommonHFSForkType.RESOURCE_FORK);
    }

    public CommonHFSExtentDescriptor[] getAllResourceExtentDescriptors(CommonHFSCatalogLeafRecord requestFile) {
        return getAllExtentDescriptors(requestFile, CommonHFSForkType.RESOURCE_FORK);
    }

    private CommonHFSCatalogLeafRecord[] collectFilesInDir(CommonHFSCatalogNodeID dirID, long currentNodeIndex, ReadableRandomAccessStream hfsFile, long fsOffset, CommonHFSVolumeHeader header, CommonBTHeaderRecord bthr, ReadableRandomAccessStream catalogFile) {
        int nodeSize = bthr.getNodeSize();
        byte[] currentNodeData = new byte[nodeSize];
        catalogFile.seek(currentNodeIndex * nodeSize);
        catalogFile.readFully(currentNodeData);
        CommonBTNodeDescriptor nodeDescriptor = createCommonBTNodeDescriptor(currentNodeData, 0);
        if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.INDEX) {
            CommonBTIndexNode<CommonHFSCatalogKey> currentNode = this.catOps.newCatalogIndexNode(currentNodeData, 0, nodeSize, bthr);
            List<CommonBTIndexRecord<CommonHFSCatalogKey>> matchingRecords = findLEChildKeys(currentNode, dirID);
            LinkedList<CommonHFSCatalogLeafRecord> results = new LinkedList<>();
            for (CommonBTIndexRecord<CommonHFSCatalogKey> bir : matchingRecords) {
                CommonHFSCatalogLeafRecord[] partResult = collectFilesInDir(dirID, bir.getIndex(), hfsFile, fsOffset, header, bthr, catalogFile);
                for (CommonHFSCatalogLeafRecord curRes : partResult) {
                    results.addLast(curRes);
                }
            }
            return (CommonHFSCatalogLeafRecord[]) results.toArray(new CommonHFSCatalogLeafRecord[results.size()]);
        } else if (nodeDescriptor.getNodeType() == CommonBTNodeDescriptor.NodeType.LEAF) {
            CommonHFSCatalogLeafNode currentNode2 = this.catOps.newCatalogLeafNode(currentNodeData, 0, nodeSize, bthr);
            return getChildrenTo(currentNode2, dirID);
        } else {
            throw new RuntimeException("Illegal type for node! (" + nodeDescriptor.getNodeType() + ")");
        }
    }

    private static List<CommonBTIndexRecord<CommonHFSCatalogKey>> findLEChildKeys(CommonBTIndexNode<CommonHFSCatalogKey> indexNode, CommonHFSCatalogNodeID rootFolderID) {
        LinkedList<CommonBTIndexRecord<CommonHFSCatalogKey>> result = new LinkedList<>();
        CommonBTIndexRecord<CommonHFSCatalogKey> largestMatchingRecord = null;
        CommonHFSCatalogKey largestMatchingKey = null;
        Iterator i$ = indexNode.getBTRecords().iterator();
        while (i$.hasNext()) {
            CommonBTIndexRecord<CommonHFSCatalogKey> record = (CommonBTIndexRecord) i$.next();
            CommonHFSCatalogKey key = record.getKey();
            if (key.getParentID().toLong() < rootFolderID.toLong() && (largestMatchingKey == null || key.compareTo(largestMatchingKey) > 0)) {
                largestMatchingKey = key;
                largestMatchingRecord = record;
            } else if (key.getParentID().toLong() == rootFolderID.toLong()) {
                result.addLast(record);
            }
        }
        if (largestMatchingKey != null) {
            result.addFirst(largestMatchingRecord);
        }
        return result;
    }

    private static CommonBTIndexRecord<CommonHFSCatalogKey> findKey(CommonHFSCatalogIndexNode indexNode, CommonHFSCatalogNodeID parentID) {
        Iterator i$ = indexNode.getBTRecords().iterator();
        while (i$.hasNext()) {
            CommonBTIndexRecord<CommonHFSCatalogKey> rec = (CommonBTIndexRecord) i$.next();
            CommonHFSCatalogKey key = rec.getKey();
            if (key.getParentID().toLong() == parentID.toLong()) {
                return rec;
            }
        }
        return null;
    }

    private static <K extends CommonBTKey<K>> CommonBTIndexRecord<K> findLEKey(CommonBTIndexNode<K> indexNode, K searchKey) {
        CommonBTIndexRecord<K> largestMatchingRecord = null;
        Iterator i$ = indexNode.getBTRecords().iterator();
        while (i$.hasNext()) {
            CommonBTIndexRecord<K> record = (CommonBTIndexRecord) i$.next();
            K recordKey = record.getKey();
            if (recordKey.compareTo(searchKey) <= 0 && (largestMatchingRecord == null || recordKey.compareTo(largestMatchingRecord.getKey()) > 0)) {
                largestMatchingRecord = record;
            }
        }
        return largestMatchingRecord;
    }

    private static CommonHFSCatalogLeafRecord[] getChildrenTo(CommonHFSCatalogLeafNode leafNode, CommonHFSCatalogNodeID nodeID) {
        LinkedList<CommonHFSCatalogLeafRecord> children = new LinkedList<>();
        CommonHFSCatalogLeafRecord[] records = leafNode.getLeafRecords();
        for (CommonHFSCatalogLeafRecord curRec : records) {
            if (curRec.getKey().getParentID().toLong() == nodeID.toLong()) {
                children.addLast(curRec);
            }
        }
        return (CommonHFSCatalogLeafRecord[]) children.toArray(new CommonHFSCatalogLeafRecord[children.size()]);
    }

    protected long calculateDataForkSizeRecursive(CommonHFSCatalogLeafRecord[] recs) {
        return calculateForkSizeRecursive(recs, false);
    }

    protected long calculateDataForkSizeRecursive(CommonHFSCatalogLeafRecord rec) {
        return calculateForkSizeRecursive(rec, false);
    }

    protected long calculateResourceForkSizeRecursive(CommonHFSCatalogLeafRecord[] recs) {
        return calculateForkSizeRecursive(recs, true);
    }

    protected long calculateResourceForkSizeRecursive(CommonHFSCatalogLeafRecord rec) {
        return calculateForkSizeRecursive(rec, true);
    }

    protected long calculateForkSizeRecursive(CommonHFSCatalogLeafRecord[] recs, boolean resourceFork) {
        long totalSize = 0;
        for (CommonHFSCatalogLeafRecord rec : recs) {
            totalSize += calculateForkSizeRecursive(rec, resourceFork);
        }
        return totalSize;
    }

    protected long calculateForkSizeRecursive(CommonHFSCatalogLeafRecord rec, boolean resourceFork) {
        if (rec instanceof CommonHFSCatalogFileRecord) {
            if (!resourceFork) {
                return ((CommonHFSCatalogFileRecord) rec).getData().getDataFork().getLogicalSize();
            }
            return ((CommonHFSCatalogFileRecord) rec).getData().getResourceFork().getLogicalSize();
        } else if (rec instanceof CommonHFSCatalogFolderRecord) {
            CommonHFSCatalogNodeID requestedID = ((CommonHFSCatalogFolderRecord) rec).getData().getFolderID();
            CommonHFSCatalogLeafRecord[] contents = listRecords(requestedID);
            long totalSize = 0;
            for (CommonHFSCatalogLeafRecord outRec : contents) {
                totalSize += calculateForkSizeRecursive(outRec, resourceFork);
            }
            return totalSize;
        } else {
            return 0L;
        }
    }
}
