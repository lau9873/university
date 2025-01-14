package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import java.util.Date;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.finder.ExtendedFolderInfo;
import org.catacombae.hfsexplorer.types.finder.FolderInfo;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogFolder.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogFolder.class */
public class HFSPlusCatalogFolder extends HFSPlusCatalogLeafRecordData implements HFSPlusCatalogAttributes, StructElements {
    private final HFSCatalogNodeID folderID;
    private final HFSPlusBSDInfo permissions;
    private final FolderInfo userInfo;
    private final ExtendedFolderInfo finderInfo;
    private final byte[] recordType = new byte[2];
    private final byte[] flags = new byte[2];
    private final byte[] valence = new byte[4];
    private final byte[] createDate = new byte[4];
    private final byte[] contentModDate = new byte[4];
    private final byte[] attributeModDate = new byte[4];
    private final byte[] accessDate = new byte[4];
    private final byte[] backupDate = new byte[4];
    private final byte[] textEncoding = new byte[4];
    private final byte[] reserved = new byte[4];

    public HFSPlusCatalogFolder(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.recordType, 0, 2);
        System.arraycopy(data, offset + 2, this.flags, 0, 2);
        System.arraycopy(data, offset + 4, this.valence, 0, 4);
        this.folderID = new HFSCatalogNodeID(data, offset + 8);
        System.arraycopy(data, offset + 12, this.createDate, 0, 4);
        System.arraycopy(data, offset + 16, this.contentModDate, 0, 4);
        System.arraycopy(data, offset + 20, this.attributeModDate, 0, 4);
        System.arraycopy(data, offset + 24, this.accessDate, 0, 4);
        System.arraycopy(data, offset + 28, this.backupDate, 0, 4);
        this.permissions = new HFSPlusBSDInfo(data, offset + 32);
        this.userInfo = new FolderInfo(data, offset + 48);
        this.finderInfo = new ExtendedFolderInfo(data, offset + 64);
        System.arraycopy(data, offset + 80, this.textEncoding, 0, 4);
        System.arraycopy(data, offset + 84, this.reserved, 0, 4);
    }

    public static int length() {
        return 88;
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecordData, org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public short getRecordType() {
        return Util.readShortBE(this.recordType);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public short getFlags() {
        return Util.readShortBE(this.flags);
    }

    public int getValence() {
        return Util.readIntBE(this.valence);
    }

    public HFSCatalogNodeID getFolderID() {
        return this.folderID;
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public int getCreateDate() {
        return Util.readIntBE(this.createDate);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public int getContentModDate() {
        return Util.readIntBE(this.contentModDate);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public int getAttributeModDate() {
        return Util.readIntBE(this.attributeModDate);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public int getAccessDate() {
        return Util.readIntBE(this.accessDate);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public int getBackupDate() {
        return Util.readIntBE(this.backupDate);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public HFSPlusBSDInfo getPermissions() {
        return this.permissions;
    }

    public FolderInfo getUserInfo() {
        return this.userInfo;
    }

    public ExtendedFolderInfo getFinderInfo() {
        return this.finderInfo;
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public int getTextEncoding() {
        return Util.readIntBE(this.textEncoding);
    }

    public int getReserved() {
        return Util.readIntBE(this.reserved);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public Date getCreateDateAsDate() {
        return HFSPlusDate.gmtTimestampToDate(getCreateDate());
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public Date getContentModDateAsDate() {
        return HFSPlusDate.gmtTimestampToDate(getContentModDate());
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public Date getAttributeModDateAsDate() {
        return HFSPlusDate.gmtTimestampToDate(getAttributeModDate());
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public Date getAccessDateAsDate() {
        return HFSPlusDate.gmtTimestampToDate(getAccessDate());
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public Date getBackupDateAsDate() {
        return HFSPlusDate.gmtTimestampToDate(getBackupDate());
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " recordType: " + ((int) getRecordType()));
        ps.println(prefix + " flags: " + ((int) getFlags()));
        ps.println(prefix + " valence: " + getValence());
        ps.println(prefix + " folderID: ");
        getFolderID().print(ps, prefix + "  ");
        ps.println(prefix + " createDate: " + getCreateDateAsDate());
        ps.println(prefix + " contentModDate: " + getContentModDateAsDate());
        ps.println(prefix + " attributeModDate: " + getAttributeModDateAsDate());
        ps.println(prefix + " accessDate: " + getAccessDateAsDate());
        ps.println(prefix + " backupDate: " + getBackupDateAsDate());
        ps.println(prefix + " permissions: ");
        getPermissions().print(ps, prefix + "  ");
        ps.println(prefix + " userInfo: ");
        getUserInfo().print(ps, prefix + "  ");
        ps.println(prefix + " finderInfo: ");
        getFinderInfo().print(ps, prefix + "  ");
        ps.println(prefix + " textEncoding: " + getTextEncoding());
        ps.println(prefix + " reserved: " + getReserved());
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusCatalogFolder:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.recordType, 0, result, 0, this.recordType.length);
        int offset = 0 + this.recordType.length;
        System.arraycopy(this.flags, 0, result, offset, this.flags.length);
        int offset2 = offset + this.flags.length;
        System.arraycopy(this.valence, 0, result, offset2, this.valence.length);
        int offset3 = offset2 + this.valence.length;
        byte[] tempData = this.folderID.getBytes();
        System.arraycopy(tempData, 0, result, offset3, tempData.length);
        int offset4 = offset3 + tempData.length;
        System.arraycopy(this.createDate, 0, result, offset4, this.createDate.length);
        int offset5 = offset4 + this.createDate.length;
        System.arraycopy(this.contentModDate, 0, result, offset5, this.contentModDate.length);
        int offset6 = offset5 + this.contentModDate.length;
        System.arraycopy(this.attributeModDate, 0, result, offset6, this.attributeModDate.length);
        int offset7 = offset6 + this.attributeModDate.length;
        System.arraycopy(this.accessDate, 0, result, offset7, this.accessDate.length);
        int offset8 = offset7 + this.accessDate.length;
        System.arraycopy(this.backupDate, 0, result, offset8, this.backupDate.length);
        int offset9 = offset8 + this.backupDate.length;
        byte[] tempData2 = this.permissions.getBytes();
        System.arraycopy(tempData2, 0, result, offset9, tempData2.length);
        int offset10 = offset9 + tempData2.length;
        byte[] tempData3 = this.userInfo.getBytes();
        System.arraycopy(tempData3, 0, result, offset10, tempData3.length);
        int offset11 = offset10 + tempData3.length;
        byte[] tempData4 = this.finderInfo.getBytes();
        System.arraycopy(tempData4, 0, result, offset11, tempData4.length);
        int offset12 = offset11 + tempData4.length;
        System.arraycopy(this.textEncoding, 0, result, offset12, this.textEncoding.length);
        int offset13 = offset12 + this.textEncoding.length;
        System.arraycopy(this.reserved, 0, result, offset13, this.reserved.length);
        int length = offset13 + this.reserved.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSPlusCatalogFolder.class.getSimpleName());
        db.addUIntBE("recordType", this.recordType);
        db.addUIntBE("flags", this.flags);
        db.addUIntBE("valence", this.valence);
        db.add("folderID", this.folderID.getStructElements());
        db.add("createDate", new HFSPlusDateField(this.createDate, false));
        db.add("contentModDate", new HFSPlusDateField(this.contentModDate, false));
        db.add("attributeModDate", new HFSPlusDateField(this.attributeModDate, false));
        db.add("accessDate", new HFSPlusDateField(this.accessDate, false));
        db.add("backupDate", new HFSPlusDateField(this.backupDate, false));
        db.add("permissions", this.permissions.getStructElements());
        db.add("userInfo", this.userInfo.getStructElements());
        db.add("finderInfo", this.finderInfo.getStructElements());
        db.addUIntBE("textEncoding", this.textEncoding);
        db.addUIntBE("reserved", this.reserved);
        return db.getResult();
    }
}
