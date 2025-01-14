package org.catacombae.hfsexplorer.deprecated;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.fs.ProgressMonitor;
import org.catacombae.hfsexplorer.io.ForkFilter;
import org.catacombae.hfsexplorer.io.ReadableBlockCachingStream;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.BTIndexNode;
import org.catacombae.hfsexplorer.types.hfsplus.BTIndexRecord;
import org.catacombae.hfsexplorer.types.hfsplus.BTKey;
import org.catacombae.hfsexplorer.types.hfsplus.BTNode;
import org.catacombae.hfsexplorer.types.hfsplus.BTNodeDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFile;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFolder;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogIndexNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecord;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecordData;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentIndexNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentLeafNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentLeafRecord;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentRecord;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusForkData;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusVolumeHeader;
import org.catacombae.hfsexplorer.types.hfsplus.HFSUniStr255;
import org.catacombae.hfsexplorer.types.hfsplus.JournalInfoBlock;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView.class */
public class HFSPlusFileSystemView {
    public static long fileReadOffset = 0;
    protected static final CatalogOperations HFS_PLUS_OPERATIONS = new CatalogOperations() { // from class: org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.1
        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.CatalogOperations
        public HFSPlusCatalogIndexNode newCatalogIndexNode(byte[] data, int offset, int nodeSize, BTHeaderRec bthr) {
            return new HFSPlusCatalogIndexNode(data, offset, nodeSize);
        }

        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.CatalogOperations
        public HFSPlusCatalogKey newCatalogKey(HFSCatalogNodeID nodeID, HFSUniStr255 searchString, BTHeaderRec bthr) {
            return new HFSPlusCatalogKey(nodeID, searchString);
        }

        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.CatalogOperations
        public HFSPlusCatalogLeafNode newCatalogLeafNode(byte[] data, int offset, int nodeSize, BTHeaderRec bthr) {
            return new HFSPlusCatalogLeafNode(data, offset, nodeSize);
        }

        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.CatalogOperations
        public HFSPlusCatalogLeafRecord newCatalogLeafRecord(byte[] data, int offset, BTHeaderRec bthr) {
            return new HFSPlusCatalogLeafRecord(data, offset);
        }
    };
    private ReadableRandomAccessStream hfsFile;
    private final ReadableRandomAccessStream backingFile;
    private final long fsOffset;
    protected final CatalogOperations catOps;
    private final long staticBlockSize;
    private ReadableBlockCachingStream catalogCache;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView$CatalogOperations.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView$CatalogOperations.class */
    public interface CatalogOperations {
        HFSPlusCatalogIndexNode newCatalogIndexNode(byte[] bArr, int i2, int i3, BTHeaderRec bTHeaderRec);

        HFSPlusCatalogKey newCatalogKey(HFSCatalogNodeID hFSCatalogNodeID, HFSUniStr255 hFSUniStr255, BTHeaderRec bTHeaderRec);

        HFSPlusCatalogLeafNode newCatalogLeafNode(byte[] bArr, int i2, int i3, BTHeaderRec bTHeaderRec);

        HFSPlusCatalogLeafRecord newCatalogLeafRecord(byte[] bArr, int i2, BTHeaderRec bTHeaderRec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView$InitProcedure.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView$InitProcedure.class */
    public abstract class InitProcedure {
        public final HFSPlusVolumeHeader header;
        public final ReadableRandomAccessStream forkFilterFile;
        public final BTNodeDescriptor btnd;
        public final BTHeaderRec bthr;

        protected abstract ReadableRandomAccessStream getForkFilterFile(HFSPlusVolumeHeader hFSPlusVolumeHeader);

        public InitProcedure() {
            this.header = HFSPlusFileSystemView.this.getVolumeHeader();
            this.forkFilterFile = getForkFilterFile(this.header);
            this.forkFilterFile.seek(0L);
            byte[] nodeDescriptorData = new byte[14];
            if (this.forkFilterFile.read(nodeDescriptorData) != nodeDescriptorData.length) {
                System.out.println("ERROR: Did not read nodeDescriptor completely.");
            }
            this.btnd = new BTNodeDescriptor(nodeDescriptorData, 0);
            byte[] headerRec = new byte[BTHeaderRec.length()];
            this.forkFilterFile.readFully(headerRec);
            this.bthr = new BTHeaderRec(headerRec, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView$CatalogInitProcedure.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView$CatalogInitProcedure.class */
    public class CatalogInitProcedure extends InitProcedure {
        public ReadableRandomAccessStream catalogFile;

        public CatalogInitProcedure() {
            super();
            this.catalogFile = this.forkFilterFile;
        }

        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.InitProcedure
        protected ReadableRandomAccessStream getForkFilterFile(HFSPlusVolumeHeader header) {
            if (HFSPlusFileSystemView.this.catalogCache != null) {
                return HFSPlusFileSystemView.this.catalogCache;
            }
            HFSPlusExtentDescriptor[] allCatalogFileDescriptors = HFSPlusFileSystemView.this.getAllDataExtentDescriptors(HFSCatalogNodeID.kHFSCatalogFileID, header.getCatalogFile());
            return new ForkFilter(header.getCatalogFile(), allCatalogFileDescriptors, HFSPlusFileSystemView.this.hfsFile, HFSPlusFileSystemView.this.fsOffset, header.getBlockSize(), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView$ExtentsInitProcedure.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/deprecated/HFSPlusFileSystemView$ExtentsInitProcedure.class */
    public class ExtentsInitProcedure extends InitProcedure {
        public ReadableRandomAccessStream extentsFile;

        public ExtentsInitProcedure() {
            super();
            this.extentsFile = this.forkFilterFile;
        }

        @Override // org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.InitProcedure
        protected ReadableRandomAccessStream getForkFilterFile(HFSPlusVolumeHeader header) {
            return new ForkFilter(header.getExtentsFile(), header.getExtentsFile().getExtents().getExtentDescriptors(), HFSPlusFileSystemView.this.hfsFile, HFSPlusFileSystemView.this.fsOffset, header.getBlockSize(), 0L);
        }
    }

    public HFSPlusFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset) {
        this(hfsFile, fsOffset, HFS_PLUS_OPERATIONS, false);
    }

    public HFSPlusFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, boolean cachingEnabled) {
        this(hfsFile, fsOffset, HFS_PLUS_OPERATIONS, cachingEnabled);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HFSPlusFileSystemView(ReadableRandomAccessStream hfsFile, long fsOffset, CatalogOperations ops, boolean cachingEnabled) {
        this.catalogCache = null;
        this.hfsFile = hfsFile;
        this.backingFile = hfsFile;
        this.fsOffset = fsOffset;
        this.catOps = ops;
        this.staticBlockSize = Util.unsign(getVolumeHeader().getBlockSize());
        if (cachingEnabled) {
            enableFileSystemCaching();
        }
    }

    public boolean isFileSystemCachingEnabled() {
        return this.hfsFile != this.backingFile && (this.backingFile instanceof ReadableBlockCachingStream);
    }

    public void enableFileSystemCaching() {
        enableFileSystemCaching(262144, 64);
    }

    public void enableFileSystemCaching(int blockSize, int blocksInCache) {
        this.hfsFile = new ReadableBlockCachingStream(this.backingFile, blockSize, blocksInCache);
    }

    public void disableFileSystemCaching() {
        this.hfsFile = this.backingFile;
    }

    public void retainCatalogFile() {
        CatalogInitProcedure init = new CatalogInitProcedure();
        ReadableRandomAccessStream ff = init.forkFilterFile;
        this.catalogCache = new ReadableBlockCachingStream(ff, 524288, 32);
        this.catalogCache.preloadBlocks();
    }

    public void releaseCatalogFile() {
        this.catalogCache = null;
    }

    public ReadableRandomAccessStream getStream() {
        return this.hfsFile;
    }

    public HFSPlusVolumeHeader getVolumeHeader() {
        byte[] currentBlock = new byte[512];
        this.hfsFile.seek(this.fsOffset + 1024);
        this.hfsFile.read(currentBlock);
        return new HFSPlusVolumeHeader(currentBlock);
    }

    public HFSPlusCatalogLeafRecord getRoot() {
        BTNodeDescriptor nodeDescriptor;
        CatalogInitProcedure init = new CatalogInitProcedure();
        HFSCatalogNodeID parentID = new HFSCatalogNodeID(1);
        int currentNodeNumber = init.bthr.getRootNode();
        byte[] currentNodeData = new byte[init.bthr.getNodeSize()];
        init.catalogFile.seek(Util.unsign(currentNodeNumber) * init.bthr.getNodeSize());
        init.catalogFile.readFully(currentNodeData);
        BTNodeDescriptor bTNodeDescriptor = new BTNodeDescriptor(currentNodeData, 0);
        while (true) {
            nodeDescriptor = bTNodeDescriptor;
            if (nodeDescriptor.getKind() != 0) {
                break;
            }
            HFSPlusCatalogIndexNode currentNode = this.catOps.newCatalogIndexNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
            BTIndexRecord matchingRecord = findKey(currentNode, parentID);
            int currentNodeNumber2 = matchingRecord.getIndex();
            init.catalogFile.seek(Util.unsign(currentNodeNumber2) * init.bthr.getNodeSize());
            init.catalogFile.readFully(currentNodeData);
            bTNodeDescriptor = new BTNodeDescriptor(currentNodeData, 0);
        }
        if (nodeDescriptor.getKind() == -1) {
            HFSPlusCatalogLeafNode leaf = this.catOps.newCatalogLeafNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
            HFSPlusCatalogLeafRecord[] recs = leaf.getLeafRecords();
            for (HFSPlusCatalogLeafRecord rec : recs) {
                if (rec.getKey().getParentID().toInt() == parentID.toInt()) {
                    return rec;
                }
            }
            return null;
        }
        throw new RuntimeException("Expected leaf node. Found other kind: " + ((int) nodeDescriptor.getKind()));
    }

    public BTNode getCatalogNode(int nodeNumber) {
        int currentNodeNumber;
        CatalogInitProcedure init = new CatalogInitProcedure();
        if (nodeNumber < 0) {
            currentNodeNumber = init.bthr.getRootNode();
        } else {
            currentNodeNumber = nodeNumber;
        }
        init.bthr.getNodeSize();
        byte[] currentNodeData = new byte[init.bthr.getNodeSize()];
        init.catalogFile.seek(Util.unsign(currentNodeNumber) * Util.unsign(init.bthr.getNodeSize()));
        init.catalogFile.readFully(currentNodeData);
        BTNodeDescriptor nodeDescriptor = new BTNodeDescriptor(currentNodeData, 0);
        if (nodeDescriptor.getKind() == 0) {
            return this.catOps.newCatalogIndexNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
        }
        if (nodeDescriptor.getKind() == -1) {
            return this.catOps.newCatalogLeafNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
        }
        return null;
    }

    public LinkedList<HFSPlusCatalogLeafRecord> getPathTo(HFSCatalogNodeID leafID) {
        HFSPlusCatalogLeafRecord leafRec = getRecord(leafID, new HFSUniStr255(""));
        if (leafRec != null) {
            return getPathTo(leafRec);
        }
        throw new RuntimeException("No folder thread found!");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
        if (r0.getRecordType() != 4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
        if ((r0 instanceof org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogThread) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
        throw new java.lang.RuntimeException("Tried to get folder thread (" + r9 + ",\"\") but found a file thread!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e2, code lost:
        throw new java.lang.RuntimeException("Tried to get folder thread (" + r9 + ",\"\") but found a " + r0.getClass() + "!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.LinkedList<org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecord> getPathTo(org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecord r7) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView.getPathTo(org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecord):java.util.LinkedList");
    }

    public HFSPlusCatalogLeafRecord getRecord(HFSCatalogNodeID parentID, HFSUniStr255 nodeName) {
        BTNodeDescriptor nodeDescriptor;
        CatalogInitProcedure init = new CatalogInitProcedure();
        init.bthr.getNodeSize();
        int currentNodeNumber = init.bthr.getRootNode();
        byte[] currentNodeData = new byte[init.bthr.getNodeSize()];
        init.catalogFile.seek(Util.unsign(currentNodeNumber) * Util.unsign(init.bthr.getNodeSize()));
        init.catalogFile.readFully(currentNodeData);
        BTNodeDescriptor bTNodeDescriptor = new BTNodeDescriptor(currentNodeData, 0);
        while (true) {
            nodeDescriptor = bTNodeDescriptor;
            if (nodeDescriptor.getKind() != 0) {
                break;
            }
            HFSPlusCatalogIndexNode currentNode = this.catOps.newCatalogIndexNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
            BTIndexRecord matchingRecord = findLEKey(currentNode, this.catOps.newCatalogKey(parentID, nodeName, init.bthr));
            int currentNodeNumber2 = matchingRecord.getIndex();
            init.catalogFile.seek(Util.unsign(currentNodeNumber2) * Util.unsign(init.bthr.getNodeSize()));
            init.catalogFile.readFully(currentNodeData);
            bTNodeDescriptor = new BTNodeDescriptor(currentNodeData, 0);
        }
        if (nodeDescriptor.getKind() == -1) {
            HFSPlusCatalogLeafNode leaf = this.catOps.newCatalogLeafNode(currentNodeData, 0, init.bthr.getNodeSize(), init.bthr);
            HFSPlusCatalogLeafRecord[] recs = leaf.getLeafRecords();
            for (HFSPlusCatalogLeafRecord rec : recs) {
                if (rec.getKey().compareTo((BTKey) this.catOps.newCatalogKey(parentID, nodeName, init.bthr)) == 0) {
                    return rec;
                }
            }
            return null;
        }
        throw new RuntimeException("Expected leaf node. Found other kind: " + ((int) nodeDescriptor.getKind()));
    }

    public HFSPlusCatalogLeafRecord[] listRecords(HFSPlusCatalogLeafRecord folderRecord) {
        if (folderRecord.getData().getRecordType() == 1 && (folderRecord.getData() instanceof HFSPlusCatalogFolder)) {
            HFSPlusCatalogFolder folder = (HFSPlusCatalogFolder) folderRecord.getData();
            return listRecords(folder.getFolderID());
        }
        throw new RuntimeException("Invalid input (not a folder record).");
    }

    public HFSPlusCatalogLeafRecord[] listRecords(HFSCatalogNodeID folderID) {
        CatalogInitProcedure init = new CatalogInitProcedure();
        ReadableRandomAccessStream catalogFile = init.forkFilterFile;
        return collectFilesInDir(folderID, init.bthr.getRootNode(), this.hfsFile, this.fsOffset, init.header, init.bthr, catalogFile, this.catOps);
    }

    public long extractDataForkToStream(HFSPlusCatalogLeafRecord fileRecord, OutputStream os, ProgressMonitor pm) throws IOException {
        HFSPlusCatalogLeafRecordData recData = fileRecord.getData();
        if (recData.getRecordType() == 2 && (recData instanceof HFSPlusCatalogFile)) {
            HFSPlusCatalogFile catFile = (HFSPlusCatalogFile) recData;
            HFSPlusForkData dataFork = catFile.getDataFork();
            return extractForkToStream(dataFork, getAllDataExtentDescriptors(fileRecord), os, pm);
        }
        throw new IllegalArgumentException("fileRecord.getData() it not of type RECORD_TYPE_FILE");
    }

    public long extractResourceForkToStream(HFSPlusCatalogLeafRecord fileRecord, OutputStream os, ProgressMonitor pm) throws IOException {
        HFSPlusCatalogLeafRecordData recData = fileRecord.getData();
        if (recData.getRecordType() == 2 && (recData instanceof HFSPlusCatalogFile)) {
            HFSPlusCatalogFile catFile = (HFSPlusCatalogFile) recData;
            HFSPlusForkData resFork = catFile.getResourceFork();
            return extractForkToStream(resFork, getAllResourceExtentDescriptors(fileRecord), os, pm);
        }
        throw new IllegalArgumentException("fileRecord.getData() it not of type RECORD_TYPE_FILE");
    }

    public long extractForkToStream(HFSPlusForkData forkData, HFSPlusExtentDescriptor[] extentDescriptors, OutputStream os, ProgressMonitor pm) throws IOException {
        HFSPlusVolumeHeader header = getVolumeHeader();
        ForkFilter forkFilter = new ForkFilter(forkData, extentDescriptors, this.hfsFile, this.fsOffset, header.getBlockSize(), 0L);
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

    public ReadableRandomAccessStream getReadableDataForkStream(HFSPlusCatalogLeafRecord fileRecord) {
        HFSPlusCatalogLeafRecordData recData = fileRecord.getData();
        if (recData.getRecordType() == 2 && (recData instanceof HFSPlusCatalogFile)) {
            HFSPlusCatalogFile catFile = (HFSPlusCatalogFile) recData;
            HFSPlusForkData fork = catFile.getDataFork();
            return getReadableForkStream(fork, getAllDataExtentDescriptors(fileRecord));
        }
        throw new IllegalArgumentException("fileRecord.getData() it not of type RECORD_TYPE_FILE");
    }

    public ReadableRandomAccessStream getReadableResourceForkStream(HFSPlusCatalogLeafRecord fileRecord) {
        HFSPlusCatalogLeafRecordData recData = fileRecord.getData();
        if (recData.getRecordType() == 2 && (recData instanceof HFSPlusCatalogFile)) {
            HFSPlusCatalogFile catFile = (HFSPlusCatalogFile) recData;
            HFSPlusForkData fork = catFile.getResourceFork();
            return getReadableForkStream(fork, getAllResourceExtentDescriptors(fileRecord));
        }
        throw new IllegalArgumentException("fileRecord.getData() it not of type RECORD_TYPE_FILE");
    }

    private ReadableRandomAccessStream getReadableForkStream(HFSPlusForkData forkData, HFSPlusExtentDescriptor[] extentDescriptors) {
        HFSPlusVolumeHeader header = getVolumeHeader();
        return new ForkFilter(forkData, extentDescriptors, this.hfsFile, this.fsOffset + fileReadOffset, header.getBlockSize(), 0L);
    }

    public HFSPlusExtentLeafRecord getOverflowExtent(HFSPlusExtentKey key) {
        BTNodeDescriptor nodeDescriptor;
        ExtentsInitProcedure init = new ExtentsInitProcedure();
        init.bthr.getNodeSize();
        int currentNodeNumber = init.bthr.getRootNode();
        byte[] currentNodeData = new byte[init.bthr.getNodeSize()];
        init.extentsFile.seek(Util.unsign(currentNodeNumber) * Util.unsign(init.bthr.getNodeSize()));
        init.extentsFile.readFully(currentNodeData);
        BTNodeDescriptor bTNodeDescriptor = new BTNodeDescriptor(currentNodeData, 0);
        while (true) {
            nodeDescriptor = bTNodeDescriptor;
            if (nodeDescriptor.getKind() != 0) {
                break;
            }
            BTIndexNode currentNode = new HFSPlusExtentIndexNode(currentNodeData, 0, init.bthr.getNodeSize());
            BTIndexRecord matchingRecord = findLEKey(currentNode, key);
            int currentNodeNumber2 = matchingRecord.getIndex();
            init.extentsFile.seek(Util.unsign(currentNodeNumber2) * Util.unsign(init.bthr.getNodeSize()));
            init.extentsFile.readFully(currentNodeData);
            bTNodeDescriptor = new BTNodeDescriptor(currentNodeData, 0);
        }
        if (nodeDescriptor.getKind() == -1) {
            HFSPlusExtentLeafNode leaf = new HFSPlusExtentLeafNode(currentNodeData, 0, init.bthr.getNodeSize());
            HFSPlusExtentLeafRecord[] recs = leaf.getLeafRecords();
            for (HFSPlusExtentLeafRecord rec : recs) {
                if (rec.getKey().compareTo((BTKey) key) == 0) {
                    return rec;
                }
            }
            return null;
        }
        throw new RuntimeException("Expected leaf node. Found other kind: " + ((int) nodeDescriptor.getKind()));
    }

    public HFSPlusExtentRecord[] getAllExtentRecords(HFSPlusCatalogLeafRecord requestFile, byte forkType) {
        HFSPlusForkData forkData;
        HFSPlusCatalogLeafRecordData recData = requestFile.getData();
        if (recData.getRecordType() == 2 && (recData instanceof HFSPlusCatalogFile)) {
            HFSPlusCatalogFile catFile = (HFSPlusCatalogFile) recData;
            if (forkType == 0) {
                forkData = catFile.getDataFork();
            } else if (forkType == -1) {
                forkData = catFile.getResourceFork();
            } else {
                throw new IllegalArgumentException("Illegal fork type!");
            }
            return getAllExtentRecords(catFile.getFileID(), forkData, forkType);
        }
        throw new IllegalArgumentException("Not a file record!");
    }

    public HFSPlusExtentRecord[] getAllExtentRecords(HFSCatalogNodeID fileID, HFSPlusForkData forkData, byte forkType) {
        HFSPlusExtentRecord[] result;
        long basicExtentsBlockCount = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            basicExtentsBlockCount += Util.unsign(forkData.getExtents().getExtentDescriptor(i2).getBlockCount());
        }
        if (basicExtentsBlockCount == forkData.getTotalBlocks()) {
            result = new HFSPlusExtentRecord[]{forkData.getExtents()};
        } else if (basicExtentsBlockCount > forkData.getTotalBlocks()) {
            throw new RuntimeException("Weird programming error. (basicExtentsBlockCount > forkData.getTotalBlocks()) (" + basicExtentsBlockCount + " > " + forkData.getTotalBlocks() + ")");
        } else {
            LinkedList<HFSPlusExtentRecord> resultList = new LinkedList<>();
            resultList.add(forkData.getExtents());
            long currentBlock = basicExtentsBlockCount;
            while (currentBlock < forkData.getTotalBlocks()) {
                HFSPlusExtentKey extentKey = new HFSPlusExtentKey(forkType, fileID, (int) currentBlock);
                HFSPlusExtentLeafRecord currentRecord = getOverflowExtent(extentKey);
                if (currentRecord == null) {
                    System.err.println("WARNING: currentRecord == null!!");
                }
                HFSPlusExtentRecord currentRecordData = currentRecord.getRecordData();
                resultList.addLast(currentRecordData);
                for (int i3 = 0; i3 < 8; i3++) {
                    currentBlock += Util.unsign(currentRecordData.getExtentDescriptor(i3).getBlockCount());
                }
            }
            result = (HFSPlusExtentRecord[]) resultList.toArray(new HFSPlusExtentRecord[resultList.size()]);
        }
        return result;
    }

    public HFSPlusExtentDescriptor[] getAllExtentDescriptors(HFSPlusCatalogLeafRecord requestFile, byte forkType) {
        return getAllExtentDescriptors(getAllExtentRecords(requestFile, forkType));
    }

    public HFSPlusExtentDescriptor[] getAllExtentDescriptors(HFSCatalogNodeID fileID, HFSPlusForkData forkData, byte forkType) {
        return getAllExtentDescriptors(getAllExtentRecords(fileID, forkData, forkType));
    }

    protected HFSPlusExtentDescriptor[] getAllExtentDescriptors(HFSPlusExtentRecord[] records) {
        LinkedList<HFSPlusExtentDescriptor> descTmp = new LinkedList<>();
        loop0: for (HFSPlusExtentRecord rec : records) {
            for (int i2 = 0; i2 < 8; i2++) {
                HFSPlusExtentDescriptor desc = rec.getExtentDescriptor(i2);
                if (desc.getStartBlock() == 0 && desc.getBlockCount() == 0) {
                    break loop0;
                }
                descTmp.addLast(desc);
            }
        }
        return (HFSPlusExtentDescriptor[]) descTmp.toArray(new HFSPlusExtentDescriptor[descTmp.size()]);
    }

    public HFSPlusExtentDescriptor[] getAllDataExtentDescriptors(HFSCatalogNodeID fileID, HFSPlusForkData forkData) {
        return getAllExtentDescriptors(fileID, forkData, (byte) 0);
    }

    public HFSPlusExtentDescriptor[] getAllDataExtentDescriptors(HFSPlusCatalogLeafRecord requestFile) {
        return getAllExtentDescriptors(requestFile, (byte) 0);
    }

    public HFSPlusExtentDescriptor[] getAllResourceExtentDescriptors(HFSCatalogNodeID fileID, HFSPlusForkData forkData) {
        return getAllExtentDescriptors(fileID, forkData, (byte) -1);
    }

    public HFSPlusExtentDescriptor[] getAllResourceExtentDescriptors(HFSPlusCatalogLeafRecord requestFile) {
        return getAllExtentDescriptors(requestFile, (byte) -1);
    }

    public JournalInfoBlock getJournalInfoBlock() {
        HFSPlusVolumeHeader vh = getVolumeHeader();
        if (vh.getAttributeVolumeJournaled()) {
            long blockNumber = Util.unsign(vh.getJournalInfoBlock());
            this.hfsFile.seek(this.fsOffset + (blockNumber * this.staticBlockSize));
            byte[] data = new byte[JournalInfoBlock.getStructSize()];
            this.hfsFile.readFully(data);
            return new JournalInfoBlock(data, 0);
        }
        return null;
    }

    public static HFSPlusCatalogLeafRecord[] collectFilesInDir(HFSCatalogNodeID dirID, int currentNodeNumber, ReadableRandomAccessStream hfsFile, long fsOffset, HFSPlusVolumeHeader header, BTHeaderRec bthr, ReadableRandomAccessStream catalogFile) {
        return collectFilesInDir(dirID, currentNodeNumber, hfsFile, fsOffset, header, bthr, catalogFile, HFS_PLUS_OPERATIONS);
    }

    private static HFSPlusCatalogLeafRecord[] collectFilesInDir(HFSCatalogNodeID dirID, int currentNodeNumber, ReadableRandomAccessStream hfsFile, long fsOffset, HFSPlusVolumeHeader header, BTHeaderRec bthr, ReadableRandomAccessStream catalogFile, CatalogOperations catOps) {
        byte[] currentNodeData = new byte[bthr.getNodeSize()];
        catalogFile.seek(Util.unsign(currentNodeNumber) * bthr.getNodeSize());
        catalogFile.readFully(currentNodeData);
        BTNodeDescriptor nodeDescriptor = new BTNodeDescriptor(currentNodeData, 0);
        if (nodeDescriptor.getKind() == 0) {
            BTIndexNode currentNode = catOps.newCatalogIndexNode(currentNodeData, 0, bthr.getNodeSize(), bthr);
            BTIndexRecord[] matchingRecords = findLEChildKeys(currentNode, dirID);
            LinkedList<HFSPlusCatalogLeafRecord> results = new LinkedList<>();
            for (BTIndexRecord bir : matchingRecords) {
                HFSPlusCatalogLeafRecord[] partResult = collectFilesInDir(dirID, bir.getIndex(), hfsFile, fsOffset, header, bthr, catalogFile, catOps);
                for (HFSPlusCatalogLeafRecord curRes : partResult) {
                    results.addLast(curRes);
                }
            }
            return (HFSPlusCatalogLeafRecord[]) results.toArray(new HFSPlusCatalogLeafRecord[results.size()]);
        } else if (nodeDescriptor.getKind() == -1) {
            HFSPlusCatalogLeafNode currentNode2 = catOps.newCatalogLeafNode(currentNodeData, 0, Util.unsign(bthr.getNodeSize()), bthr);
            return getChildrenTo(currentNode2, dirID);
        } else {
            throw new RuntimeException("Illegal type for node! (" + ((int) nodeDescriptor.getKind()) + ")");
        }
    }

    private static BTIndexRecord[] findLEChildKeys(BTIndexNode indexNode, HFSCatalogNodeID rootFolderID) {
        LinkedList<BTIndexRecord> result = new LinkedList<>();
        BTIndexRecord[] records = indexNode.getIndexRecords();
        BTIndexRecord largestMatchingRecord = null;
        HFSPlusCatalogKey largestMatchingKey = null;
        for (int i2 = 0; i2 < records.length; i2++) {
            if (records[i2].getKey() instanceof HFSPlusCatalogKey) {
                HFSPlusCatalogKey key = (HFSPlusCatalogKey) records[i2].getKey();
                if (key.getParentID().toLong() < rootFolderID.toLong() && (largestMatchingKey == null || key.compareTo((BTKey) largestMatchingKey) > 0)) {
                    largestMatchingKey = key;
                    largestMatchingRecord = records[i2];
                } else if (key.getParentID().toLong() == rootFolderID.toLong()) {
                    result.addLast(records[i2]);
                }
            } else {
                throw new RuntimeException("UNKNOWN KEY TYPE IN findLEChildKeys");
            }
        }
        if (largestMatchingKey != null) {
            result.addFirst(largestMatchingRecord);
        }
        return (BTIndexRecord[]) result.toArray(new BTIndexRecord[result.size()]);
    }

    private static BTIndexRecord findKey(HFSPlusCatalogIndexNode indexNode, HFSCatalogNodeID parentID) {
        BTIndexRecord[] arr$ = indexNode.getIndexRecords();
        for (BTIndexRecord rec : arr$) {
            BTKey btKey = rec.getKey();
            if (btKey instanceof HFSPlusCatalogKey) {
                HFSPlusCatalogKey key = (HFSPlusCatalogKey) btKey;
                if (key.getParentID().toInt() == parentID.toInt()) {
                    return rec;
                }
            } else {
                throw new RuntimeException("Unexpected key in HFSPlusCatalogIndexNode record.");
            }
        }
        return null;
    }

    private static BTIndexRecord findLEKey(BTIndexNode indexNode, BTKey searchKey) {
        BTIndexRecord[] records = indexNode.getIndexRecords();
        BTIndexRecord largestMatchingRecord = null;
        for (int i2 = 0; i2 < records.length; i2++) {
            if (records[i2].getKey().compareTo(searchKey) <= 0 && (largestMatchingRecord == null || records[i2].getKey().compareTo(largestMatchingRecord.getKey()) > 0)) {
                largestMatchingRecord = records[i2];
            }
        }
        return largestMatchingRecord;
    }

    private static HFSPlusCatalogLeafRecord[] getChildrenTo(HFSPlusCatalogLeafNode leafNode, HFSCatalogNodeID nodeID) {
        LinkedList<HFSPlusCatalogLeafRecord> children = new LinkedList<>();
        HFSPlusCatalogLeafRecord[] records = leafNode.getLeafRecords();
        for (HFSPlusCatalogLeafRecord curRec : records) {
            if (curRec.getKey().getParentID().toInt() == nodeID.toInt()) {
                children.addLast(curRec);
            }
        }
        return (HFSPlusCatalogLeafRecord[]) children.toArray(new HFSPlusCatalogLeafRecord[children.size()]);
    }

    protected long calculateDataForkSizeRecursive(HFSPlusCatalogLeafRecord[] recs) {
        return calculateForkSizeRecursive(recs, false);
    }

    protected long calculateDataForkSizeRecursive(HFSPlusCatalogLeafRecord rec) {
        return calculateForkSizeRecursive(rec, false);
    }

    protected long calculateResourceForkSizeRecursive(HFSPlusCatalogLeafRecord[] recs) {
        return calculateForkSizeRecursive(recs, true);
    }

    protected long calculateResourceForkSizeRecursive(HFSPlusCatalogLeafRecord rec) {
        return calculateForkSizeRecursive(rec, true);
    }

    protected long calculateForkSizeRecursive(HFSPlusCatalogLeafRecord[] recs, boolean resourceFork) {
        long totalSize = 0;
        for (HFSPlusCatalogLeafRecord rec : recs) {
            totalSize += calculateForkSizeRecursive(rec, resourceFork);
        }
        return totalSize;
    }

    protected long calculateForkSizeRecursive(HFSPlusCatalogLeafRecord rec, boolean resourceFork) {
        HFSPlusCatalogLeafRecordData recData = rec.getData();
        if (recData.getRecordType() == 2 && (recData instanceof HFSPlusCatalogFile)) {
            if (!resourceFork) {
                return ((HFSPlusCatalogFile) recData).getDataFork().getLogicalSize();
            }
            return ((HFSPlusCatalogFile) recData).getResourceFork().getLogicalSize();
        } else if (recData.getRecordType() == 1 && (recData instanceof HFSPlusCatalogFolder)) {
            HFSCatalogNodeID requestedID = ((HFSPlusCatalogFolder) recData).getFolderID();
            HFSPlusCatalogLeafRecord[] contents = listRecords(requestedID);
            long totalSize = 0;
            for (HFSPlusCatalogLeafRecord outRec : contents) {
                totalSize += calculateForkSizeRecursive(outRec, resourceFork);
            }
            return totalSize;
        } else {
            return 0L;
        }
    }
}
