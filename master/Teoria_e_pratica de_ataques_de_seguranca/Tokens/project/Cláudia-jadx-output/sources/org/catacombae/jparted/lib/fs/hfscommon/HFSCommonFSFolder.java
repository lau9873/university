package org.catacombae.jparted.lib.fs.hfscommon;

import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord;
import org.catacombae.jparted.lib.fs.FSAttributes;
import org.catacombae.jparted.lib.fs.FSEntry;
import org.catacombae.jparted.lib.fs.FSFolder;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSFolder.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSFolder.class */
public class HFSCommonFSFolder extends FSFolder {
    private final HFSCommonFileSystemHandler fsHandler;
    private final CommonHFSCatalogLeafRecord keyRecord;
    private final CommonHFSCatalogFolderRecord folderRecord;
    private final CommonHFSCatalogFolder catalogFolder;
    private final HFSCommonFSAttributes attributes;

    public HFSCommonFSFolder(HFSCommonFileSystemHandler iParent, CommonHFSCatalogFolderRecord iFolderRecord) {
        this(iParent, null, iFolderRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HFSCommonFSFolder(HFSCommonFileSystemHandler iParent, CommonHFSCatalogFileRecord iHardLinkFileRecord, CommonHFSCatalogFolderRecord iFolderRecord) {
        super(iParent);
        if (iParent == null) {
            throw new IllegalArgumentException("iParent must not be null!");
        }
        if (iFolderRecord == null) {
            throw new IllegalArgumentException("iFolderRecord must not be null!");
        }
        this.fsHandler = iParent;
        if (iHardLinkFileRecord != null) {
            this.keyRecord = iHardLinkFileRecord;
        } else {
            this.keyRecord = iFolderRecord;
        }
        this.folderRecord = iFolderRecord;
        this.catalogFolder = this.folderRecord.getData();
        this.attributes = new HFSCommonFSAttributes(this, this.catalogFolder);
    }

    @Override // org.catacombae.jparted.lib.fs.FSFolder
    public String[] list() {
        return this.fsHandler.listNames(this.folderRecord);
    }

    @Override // org.catacombae.jparted.lib.fs.FSFolder
    public FSEntry[] listEntries() {
        return this.fsHandler.listFSEntries(this.folderRecord);
    }

    @Override // org.catacombae.jparted.lib.fs.FSFolder
    public FSEntry getChild(String name) {
        return this.fsHandler.getEntry(this.folderRecord, name);
    }

    @Override // org.catacombae.jparted.lib.fs.FSFolder
    public long getValence() {
        return this.catalogFolder.getValence();
    }

    @Override // org.catacombae.jparted.lib.fs.FSEntry
    public FSAttributes getAttributes() {
        return this.attributes;
    }

    @Override // org.catacombae.jparted.lib.fs.FSEntry
    public String getName() {
        return this.fsHandler.getProperNodeName(this.keyRecord);
    }

    public CommonHFSCatalogFolder getInternalCatalogFolder() {
        return this.catalogFolder;
    }

    CommonHFSCatalogFolderRecord getInternalCatalogFolderRecord() {
        return this.folderRecord;
    }
}
