package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import java.util.Date;
import org.catacombae.csjc.StaticStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.hfs.CdrFilRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusBSDInfo;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFile;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusDate;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFile.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFile.class */
public abstract class CommonHFSCatalogFile implements StaticStruct, CommonHFSCatalogAttributes, StructElements {
    public abstract CommonHFSCatalogNodeID getFileID();

    public abstract CommonHFSForkData getDataFork();

    public abstract CommonHFSForkData getResourceFork();

    @Override // org.catacombae.csjc.AbstractStruct
    public abstract byte[] getBytes();

    public abstract boolean isHardFileLink();

    public abstract boolean isHardDirectoryLink();

    public abstract boolean isSymbolicLink();

    public abstract int getHardLinkInode();

    public abstract void printFields(PrintStream printStream, String str);

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogFile.class.getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    public static CommonHFSCatalogFile create(HFSPlusCatalogFile data) {
        return new HFSPlusImplementation(data);
    }

    public static CommonHFSCatalogFile create(CdrFilRec data) {
        return new HFSImplementation(data);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFile$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFile$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSCatalogFile {
        private static final int HARD_FILE_LINK_FILE_TYPE = 1751936619;
        private static final int HARD_FILE_LINK_CREATOR = 1751544619;
        private static final int HARD_DIRECTORY_LINK_FILE_TYPE = 1717858928;
        private static final int HARD_DIRECTORY_LINK_CREATOR = 1296122707;
        private HFSPlusCatalogFile data;

        private HFSPlusImplementation(HFSPlusCatalogFile data) {
            this.data = data;
        }

        public HFSPlusCatalogFile getUnderlying() {
            return this.data;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public CommonHFSCatalogNodeID getFileID() {
            return CommonHFSCatalogNodeID.create(this.data.getFileID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public CommonHFSForkData getDataFork() {
            return CommonHFSForkData.create(this.data.getDataFork());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public CommonHFSForkData getResourceFork() {
            return CommonHFSForkData.create(this.data.getResourceFork());
        }

        @Override // org.catacombae.csjc.StaticStruct
        public int size() {
            return this.data.size();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile, org.catacombae.csjc.AbstractStruct
        public byte[] getBytes() {
            return this.data.getBytes();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public short getRecordType() {
            return this.data.getRecordType();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public short getFlags() {
            return this.data.getFlags();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getCreateDate() {
            return this.data.getCreateDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getContentModDate() {
            return this.data.getContentModDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getAttributeModDate() {
            return this.data.getAttributeModDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getAccessDate() {
            return this.data.getAccessDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getBackupDate() {
            return this.data.getBackupDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getCreateDateAsDate() {
            return this.data.getCreateDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getContentModDateAsDate() {
            return this.data.getContentModDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getAttributeModDateAsDate() {
            return this.data.getAttributeModDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getAccessDateAsDate() {
            return this.data.getAccessDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getBackupDateAsDate() {
            return this.data.getBackupDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "data:");
            this.data.print(ps, prefix + " ");
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public boolean isSymbolicLink() {
            return this.data.getPermissions().getFileModeFileType() == 10;
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.data.getStructElements();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasPermissions() {
            return true;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public HFSPlusBSDInfo getPermissions() {
            return this.data.getPermissions();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public boolean isHardFileLink() {
            int fileType = this.data.getUserInfo().getFileType().getOSType().getFourCharCode();
            int creator = this.data.getUserInfo().getFileCreator().getOSType().getFourCharCode();
            return fileType == 1751936619 && creator == 1751544619;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public boolean isHardDirectoryLink() {
            int fileType = this.data.getUserInfo().getFileType().getOSType().getFourCharCode();
            int creator = this.data.getUserInfo().getFileCreator().getOSType().getFourCharCode();
            return fileType == 1717858928 && creator == 1296122707;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public int getHardLinkInode() {
            return this.data.getPermissions().getSpecial();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasCreateDate() {
            return true;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasContentModDate() {
            return true;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasAttributeModDate() {
            return true;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasAccessDate() {
            return true;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasBackupDate() {
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFile$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFile$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogFile {
        private CdrFilRec data;

        private HFSImplementation(CdrFilRec data) {
            this.data = data;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public CommonHFSCatalogNodeID getFileID() {
            return CommonHFSCatalogNodeID.create(this.data.getFilFlNum());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public CommonHFSForkData getDataFork() {
            return CommonHFSForkData.create(this.data.getFilExtRec(), this.data.getFilLgLen());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public CommonHFSForkData getResourceFork() {
            return CommonHFSForkData.create(this.data.getFilRExtRec(), this.data.getFilRLgLen());
        }

        @Override // org.catacombae.csjc.StaticStruct
        public int size() {
            return this.data.size();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile, org.catacombae.csjc.AbstractStruct
        public byte[] getBytes() {
            return this.data.getBytes();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public short getRecordType() {
            return this.data.getCdrType();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public short getFlags() {
            return this.data.getFilFlags();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getCreateDate() {
            return this.data.getFilCrDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getContentModDate() {
            return this.data.getFilMdDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getAttributeModDate() {
            return this.data.getFilMdDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getAccessDate() {
            return this.data.getFilMdDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getBackupDate() {
            return this.data.getFilBkDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getCreateDateAsDate() {
            return HFSPlusDate.localTimestampToDate(getCreateDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getContentModDateAsDate() {
            return HFSPlusDate.localTimestampToDate(getContentModDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getAttributeModDateAsDate() {
            return HFSPlusDate.localTimestampToDate(getAttributeModDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getAccessDateAsDate() {
            return HFSPlusDate.localTimestampToDate(getAccessDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getBackupDateAsDate() {
            return HFSPlusDate.localTimestampToDate(getBackupDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "data:");
            this.data.print(ps, prefix + " ");
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public boolean isSymbolicLink() {
            return false;
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.data.getStructElements();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasPermissions() {
            return false;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public HFSPlusBSDInfo getPermissions() {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public boolean isHardFileLink() {
            return false;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public boolean isHardDirectoryLink() {
            return false;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile
        public int getHardLinkInode() {
            throw new UnsupportedOperationException("Not supported for HFS.");
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasCreateDate() {
            return true;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasContentModDate() {
            return true;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasAttributeModDate() {
            return false;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasAccessDate() {
            return false;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasBackupDate() {
            return true;
        }
    }
}
