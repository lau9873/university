package org.catacombae.jparted.lib.fs.hfscommon;

import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.fs.FSAttributes;
import org.catacombae.jparted.lib.fs.FSFile;
import org.catacombae.jparted.lib.fs.FSFork;
import org.catacombae.jparted.lib.fs.FSForkType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSFile.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSFile.class */
public class HFSCommonFSFile extends FSFile {
    private final HFSCommonFileSystemHandler parent;
    private final CommonHFSCatalogLeafRecord keyRecord;
    private final CommonHFSCatalogFileRecord fileRecord;
    private final CommonHFSCatalogFile catalogFile;
    private final HFSCommonFSAttributes attributes;
    private final FSFork dataFork;
    private final FSFork resourceFork;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HFSCommonFSFile(HFSCommonFileSystemHandler iParent, CommonHFSCatalogFileRecord iFileRecord) {
        this(iParent, null, iFileRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HFSCommonFSFile(HFSCommonFileSystemHandler iParent, CommonHFSCatalogLeafRecord iHardLinkRecord, CommonHFSCatalogFileRecord iFileRecord) {
        super(iParent);
        if (iParent == null) {
            throw new IllegalArgumentException("iParent must not be null!");
        }
        if (iFileRecord == null) {
            throw new IllegalArgumentException("iFileRecord must not be null!");
        }
        this.parent = iParent;
        this.fileRecord = iFileRecord;
        if (iHardLinkRecord != null) {
            this.keyRecord = iHardLinkRecord;
        } else {
            this.keyRecord = iFileRecord;
        }
        this.catalogFile = this.fileRecord.getData();
        this.attributes = new HFSCommonFSAttributes(this, this.catalogFile);
        this.dataFork = new HFSCommonFSFork(this, FSForkType.DATA, this.catalogFile.getDataFork());
        this.resourceFork = new HFSCommonFSFork(this, FSForkType.MACOS_RESOURCE, this.catalogFile.getResourceFork());
    }

    @Override // org.catacombae.jparted.lib.fs.FSEntry
    public FSAttributes getAttributes() {
        return this.attributes;
    }

    @Override // org.catacombae.jparted.lib.fs.FSEntry
    public String getName() {
        return this.parent.getProperNodeName(this.keyRecord);
    }

    @Override // org.catacombae.jparted.lib.fs.FSFile
    public FSFork getMainFork() {
        return getForkByType(FSForkType.DATA);
    }

    @Override // org.catacombae.jparted.lib.fs.FSFile
    public FSFork[] getAllForks() {
        return new FSFork[]{this.dataFork, this.resourceFork};
    }

    @Override // org.catacombae.jparted.lib.fs.FSFile
    public FSFork getForkByType(FSForkType type) {
        switch (type) {
            case DATA:
                return this.dataFork;
            case MACOS_RESOURCE:
                return this.resourceFork;
            default:
                return null;
        }
    }

    @Override // org.catacombae.jparted.lib.fs.FSFile
    public long getCombinedLength() {
        return this.dataFork.getLength() + this.resourceFork.getLength();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadableRandomAccessStream getReadableDataForkStream() {
        return this.parent.getReadableDataForkStream(this.fileRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadableRandomAccessStream getReadableResourceForkStream() {
        return this.parent.getReadableResourceForkStream(this.fileRecord);
    }

    HFSCommonFileSystemHandler getFileSystemHandler() {
        return this.parent;
    }

    public CommonHFSCatalogFile getInternalCatalogFile() {
        return this.catalogFile;
    }
}
