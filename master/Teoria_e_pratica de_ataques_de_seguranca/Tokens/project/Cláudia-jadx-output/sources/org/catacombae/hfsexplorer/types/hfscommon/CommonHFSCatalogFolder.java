package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import java.util.Date;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.CdrDirRec;
import org.catacombae.hfsexplorer.types.hfs.HFSDate;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusBSDInfo;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFolder;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolder.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolder.class */
public abstract class CommonHFSCatalogFolder implements CommonHFSCatalogAttributes, PrintableStruct, StructElements {
    public abstract CommonHFSCatalogNodeID getFolderID();

    public abstract long getValence();

    public abstract int length();

    public abstract byte[] getBytes();

    public static CommonHFSCatalogFolder create(HFSPlusCatalogFolder data) {
        return new HFSPlusImplementation(data);
    }

    public static CommonHFSCatalogFolder create(CdrDirRec data) {
        return new HFSImplementation(data);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogFolder.class.getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolder$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolder$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSCatalogFolder {
        private HFSPlusCatalogFolder data;

        public HFSPlusImplementation(HFSPlusCatalogFolder data) {
            this.data = data;
        }

        public HFSPlusCatalogFolder getUnderlying() {
            return this.data;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder
        public CommonHFSCatalogNodeID getFolderID() {
            return CommonHFSCatalogNodeID.create(this.data.getFolderID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder
        public long getValence() {
            return Util.unsign(this.data.getValence());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder
        public int length() {
            HFSPlusCatalogFolder hFSPlusCatalogFolder = this.data;
            return HFSPlusCatalogFolder.length();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder
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

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "data:");
            this.data.print(ps, prefix + " ");
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
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolder$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolder$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogFolder {
        private CdrDirRec data;

        public HFSImplementation(CdrDirRec data) {
            this.data = data;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder
        public CommonHFSCatalogNodeID getFolderID() {
            return CommonHFSCatalogNodeID.create(this.data.getDirDirID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder
        public long getValence() {
            return Util.unsign(this.data.getDirVal());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder
        public int length() {
            CdrDirRec cdrDirRec = this.data;
            return CdrDirRec.length();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder
        public byte[] getBytes() {
            return this.data.getBytes();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public short getRecordType() {
            return this.data.getCdrType();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public short getFlags() {
            return this.data.getDirFlags();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getCreateDate() {
            return this.data.getDirCrDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getContentModDate() {
            return this.data.getDirMdDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getAttributeModDate() {
            return this.data.getDirMdDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getAccessDate() {
            return this.data.getDirMdDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public int getBackupDate() {
            return this.data.getDirBkDat();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getCreateDateAsDate() {
            return HFSDate.localTimestampToDate(getCreateDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getContentModDateAsDate() {
            return HFSDate.localTimestampToDate(getContentModDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getAttributeModDateAsDate() {
            return HFSDate.localTimestampToDate(getAttributeModDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getAccessDateAsDate() {
            return HFSDate.localTimestampToDate(getAccessDate());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public Date getBackupDateAsDate() {
            return HFSDate.localTimestampToDate(getBackupDate());
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "data:");
            this.data.print(ps, prefix + " ");
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

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasAccessDate() {
            return false;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogAttributes
        public boolean hasBackupDate() {
            return true;
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
    }
}
