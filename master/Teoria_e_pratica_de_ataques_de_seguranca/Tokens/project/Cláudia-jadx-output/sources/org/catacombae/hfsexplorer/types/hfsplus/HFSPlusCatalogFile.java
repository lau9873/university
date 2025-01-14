package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import java.util.Date;
import org.catacombae.csjc.StaticStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.finder.ExtendedFileInfo;
import org.catacombae.hfsexplorer.types.finder.FileInfo;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogFile.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogFile.class */
public class HFSPlusCatalogFile extends HFSPlusCatalogLeafRecordData implements HFSPlusCatalogAttributes, StaticStruct {
    private final HFSCatalogNodeID fileID;
    private final HFSPlusBSDInfo permissions;
    private final FileInfo userInfo;
    private final ExtendedFileInfo finderInfo;
    private final HFSPlusForkData dataFork;
    private final HFSPlusForkData resourceFork;
    private final byte[] recordType = new byte[2];
    private final byte[] flags = new byte[2];
    private final byte[] reserved1 = new byte[4];
    private final byte[] createDate = new byte[4];
    private final byte[] contentModDate = new byte[4];
    private final byte[] attributeModDate = new byte[4];
    private final byte[] accessDate = new byte[4];
    private final byte[] backupDate = new byte[4];
    private final byte[] textEncoding = new byte[4];
    private final byte[] reserved2 = new byte[4];

    public HFSPlusCatalogFile(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.recordType, 0, 2);
        System.arraycopy(data, offset + 2, this.flags, 0, 2);
        System.arraycopy(data, offset + 4, this.reserved1, 0, 4);
        this.fileID = new HFSCatalogNodeID(data, offset + 8);
        System.arraycopy(data, offset + 12, this.createDate, 0, 4);
        System.arraycopy(data, offset + 16, this.contentModDate, 0, 4);
        System.arraycopy(data, offset + 20, this.attributeModDate, 0, 4);
        System.arraycopy(data, offset + 24, this.accessDate, 0, 4);
        System.arraycopy(data, offset + 28, this.backupDate, 0, 4);
        this.permissions = new HFSPlusBSDInfo(data, offset + 32);
        this.userInfo = new FileInfo(data, offset + 48);
        this.finderInfo = new ExtendedFileInfo(data, offset + 64);
        System.arraycopy(data, offset + 80, this.textEncoding, 0, 4);
        System.arraycopy(data, offset + 84, this.reserved2, 0, 4);
        this.dataFork = new HFSPlusForkData(data, offset + 88);
        this.resourceFork = new HFSPlusForkData(data, offset + 168);
    }

    public static int length() {
        return 248;
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecordData, org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public short getRecordType() {
        return Util.readShortBE(this.recordType);
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public short getFlags() {
        return Util.readShortBE(this.flags);
    }

    public int getReserved1() {
        return Util.readIntBE(this.reserved1);
    }

    public HFSCatalogNodeID getFileID() {
        return this.fileID;
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

    public FileInfo getUserInfo() {
        return this.userInfo;
    }

    public ExtendedFileInfo getFinderInfo() {
        return this.finderInfo;
    }

    @Override // org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogAttributes
    public int getTextEncoding() {
        return Util.readIntBE(this.textEncoding);
    }

    public int getReserved2() {
        return Util.readIntBE(this.reserved2);
    }

    public HFSPlusForkData getDataFork() {
        return this.dataFork;
    }

    public HFSPlusForkData getResourceFork() {
        return this.resourceFork;
    }

    public boolean getFileLockedFlag() {
        return (getFlags() & 1) != 0;
    }

    public boolean getThreadExistsFlag() {
        return (getFlags() & 2) != 0;
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

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSPlusCatalogFile.class.getSimpleName());
        db.addFlag("fileLocked", this.flags, 0);
        db.addFlag("threadExists", this.flags, 1);
        db.addUIntBE("reserved1", this.reserved1);
        db.add("fileID", this.fileID.getStructElements());
        db.add("createDate", new HFSPlusDateField(this.createDate, false));
        db.add("contentModDate", new HFSPlusDateField(this.contentModDate, false));
        db.add("attributeModDate", new HFSPlusDateField(this.attributeModDate, false));
        db.add("accessDate", new HFSPlusDateField(this.accessDate, false));
        db.add("backupDate", new HFSPlusDateField(this.backupDate, false));
        db.add("permissions", this.permissions.getStructElements());
        db.add("userInfo", this.userInfo.getStructElements());
        db.add("finderInfo", this.finderInfo.getStructElements());
        db.addUIntBE("textEncoding", this.textEncoding);
        db.addUIntBE("reserved2", this.reserved2);
        db.add("dataFork", this.dataFork.getStructElements());
        db.add("resourceFork", this.resourceFork.getStructElements());
        return db.getResult();
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " recordType: " + ((int) getRecordType()));
        ps.println(prefix + " flags: " + ((int) getFlags()));
        ps.println(prefix + " reserved1: " + getReserved1());
        ps.println(prefix + " fileID: ");
        getFileID().print(ps, prefix + "  ");
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
        ps.println(prefix + " reserved2: " + getReserved2());
        ps.println(prefix + " dataFork: ");
        getDataFork().print(ps, prefix + "  ");
        ps.println(prefix + " resourceFork: ");
        getResourceFork().print(ps, prefix + "  ");
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusCatalogFile:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.recordType, 0, result, 0, this.recordType.length);
        int offset = 0 + this.recordType.length;
        System.arraycopy(this.flags, 0, result, offset, this.flags.length);
        int offset2 = offset + this.flags.length;
        System.arraycopy(this.reserved1, 0, result, offset2, this.reserved1.length);
        int offset3 = offset2 + this.reserved1.length;
        byte[] tempData = this.fileID.getBytes();
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
        System.arraycopy(this.reserved2, 0, result, offset13, this.reserved2.length);
        int offset14 = offset13 + this.reserved2.length;
        byte[] tempData5 = this.dataFork.getBytes();
        System.arraycopy(tempData5, 0, result, offset14, tempData5.length);
        int offset15 = offset14 + tempData5.length;
        byte[] tempData6 = this.resourceFork.getBytes();
        System.arraycopy(tempData6, 0, result, offset15, tempData6.length);
        int length = offset15 + tempData6.length;
        return result;
    }

    @Override // org.catacombae.csjc.StaticStruct
    public int size() {
        return length();
    }
}
