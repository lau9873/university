package org.catacombae.hfsexplorer.types.hfsplus;

import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import org.catacombae.csjc.MutableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ASCIIStringField;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusVolumeHeader.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusVolumeHeader.class */
public class HFSPlusVolumeHeader extends MutableStruct implements StructElements {
    public static final short SIGNATURE_HFS_PLUS = 18475;
    public static final short SIGNATURE_HFSX = 18520;
    private final byte[] signature;
    private final byte[] version;
    private final byte[] attributes;
    private final byte[] lastMountedVersion;
    private final byte[] journalInfoBlock;
    private final byte[] createDate;
    private final byte[] modifyDate;
    private final byte[] backupDate;
    private final byte[] checkedDate;
    private final byte[] fileCount;
    private final byte[] folderCount;
    private final byte[] blockSize;
    private final byte[] totalBlocks;
    private final byte[] freeBlocks;
    private final byte[] nextAllocation;
    private final byte[] rsrcClumpSize;
    private final byte[] dataClumpSize;
    private final HFSCatalogNodeID nextCatalogID;
    private final byte[] writeCount;
    private final byte[] encodingsBitmap;
    private final byte[] finderInfo;
    private final HFSPlusForkData allocationFile;
    private final HFSPlusForkData extentsFile;
    private final HFSPlusForkData catalogFile;
    private final HFSPlusForkData attributesFile;
    private final HFSPlusForkData startupFile;

    public HFSPlusVolumeHeader(byte[] data) {
        this(data, 0);
    }

    public HFSPlusVolumeHeader(byte[] data, int offset) {
        this.signature = new byte[2];
        this.version = new byte[2];
        this.attributes = new byte[4];
        this.lastMountedVersion = new byte[4];
        this.journalInfoBlock = new byte[4];
        this.createDate = new byte[4];
        this.modifyDate = new byte[4];
        this.backupDate = new byte[4];
        this.checkedDate = new byte[4];
        this.fileCount = new byte[4];
        this.folderCount = new byte[4];
        this.blockSize = new byte[4];
        this.totalBlocks = new byte[4];
        this.freeBlocks = new byte[4];
        this.nextAllocation = new byte[4];
        this.rsrcClumpSize = new byte[4];
        this.dataClumpSize = new byte[4];
        this.writeCount = new byte[4];
        this.encodingsBitmap = new byte[8];
        this.finderInfo = new byte[32];
        System.arraycopy(data, offset + 0, this.signature, 0, 2);
        System.arraycopy(data, offset + 2, this.version, 0, 2);
        System.arraycopy(data, offset + 4, this.attributes, 0, 4);
        System.arraycopy(data, offset + 8, this.lastMountedVersion, 0, 4);
        System.arraycopy(data, offset + 12, this.journalInfoBlock, 0, 4);
        System.arraycopy(data, offset + 16, this.createDate, 0, 4);
        System.arraycopy(data, offset + 20, this.modifyDate, 0, 4);
        System.arraycopy(data, offset + 24, this.backupDate, 0, 4);
        System.arraycopy(data, offset + 28, this.checkedDate, 0, 4);
        System.arraycopy(data, offset + 32, this.fileCount, 0, 4);
        System.arraycopy(data, offset + 36, this.folderCount, 0, 4);
        System.arraycopy(data, offset + 40, this.blockSize, 0, 4);
        System.arraycopy(data, offset + 44, this.totalBlocks, 0, 4);
        System.arraycopy(data, offset + 48, this.freeBlocks, 0, 4);
        System.arraycopy(data, offset + 52, this.nextAllocation, 0, 4);
        System.arraycopy(data, offset + 56, this.rsrcClumpSize, 0, 4);
        System.arraycopy(data, offset + 60, this.dataClumpSize, 0, 4);
        this.nextCatalogID = new HFSCatalogNodeID(data, offset + 64);
        System.arraycopy(data, offset + 68, this.writeCount, 0, 4);
        System.arraycopy(data, offset + 72, this.encodingsBitmap, 0, 4);
        System.arraycopy(data, offset + 80, this.finderInfo, 0, 32);
        this.allocationFile = new HFSPlusForkData(data, offset + 112);
        this.extentsFile = new HFSPlusForkData(data, offset + 192);
        this.catalogFile = new HFSPlusForkData(data, offset + 272);
        this.attributesFile = new HFSPlusForkData(data, offset + 352);
        this.startupFile = new HFSPlusForkData(data, offset + 432);
    }

    public HFSPlusVolumeHeader(InputStream is) throws IOException {
        this(Util.fillBuffer(is, new byte[_getSize()]), 0);
    }

    private static int _getSize() {
        return 512;
    }

    public short getSignature() {
        return Util.readShortBE(this.signature);
    }

    public short getVersion() {
        return Util.readShortBE(this.version);
    }

    public int getAttributes() {
        return Util.readIntBE(this.attributes);
    }

    public int getLastMountedVersion() {
        return Util.readIntBE(this.lastMountedVersion);
    }

    public int getJournalInfoBlock() {
        return Util.readIntBE(this.journalInfoBlock);
    }

    public int getCreateDate() {
        return Util.readIntBE(this.createDate);
    }

    public int getModifyDate() {
        return Util.readIntBE(this.modifyDate);
    }

    public int getBackupDate() {
        return Util.readIntBE(this.backupDate);
    }

    public int getCheckedDate() {
        return Util.readIntBE(this.checkedDate);
    }

    public int getFileCount() {
        return Util.readIntBE(this.fileCount);
    }

    public int getFolderCount() {
        return Util.readIntBE(this.folderCount);
    }

    public int getBlockSize() {
        return Util.readIntBE(this.blockSize);
    }

    public int getTotalBlocks() {
        return Util.readIntBE(this.totalBlocks);
    }

    public int getFreeBlocks() {
        return Util.readIntBE(this.freeBlocks);
    }

    public int getNextAllocation() {
        return Util.readIntBE(this.nextAllocation);
    }

    public int getRsrcClumpSize() {
        return Util.readIntBE(this.rsrcClumpSize);
    }

    public int getDataClumpSize() {
        return Util.readIntBE(this.dataClumpSize);
    }

    public HFSCatalogNodeID getNextCatalogID() {
        return this.nextCatalogID;
    }

    public int getWriteCount() {
        return Util.readIntBE(this.writeCount);
    }

    public long getEncodingsBitmap() {
        return Util.readLongBE(this.encodingsBitmap);
    }

    public int[] getFinderInfo() {
        return Util.readIntArrayBE(this.finderInfo);
    }

    public HFSPlusForkData getAllocationFile() {
        return this.allocationFile;
    }

    public HFSPlusForkData getExtentsFile() {
        return this.extentsFile;
    }

    public HFSPlusForkData getCatalogFile() {
        return this.catalogFile;
    }

    public HFSPlusForkData getAttributesFile() {
        return this.attributesFile;
    }

    public HFSPlusForkData getStartupFile() {
        return this.startupFile;
    }

    public Date getCreateDateAsDate() {
        return HFSPlusDate.localTimestampToDate(getCreateDate());
    }

    public Date getModifyDateAsDate() {
        return HFSPlusDate.localTimestampToDate(getModifyDate());
    }

    public Date getBackupDateAsDate() {
        return HFSPlusDate.localTimestampToDate(getBackupDate());
    }

    public Date getCheckedDateAsDate() {
        return HFSPlusDate.localTimestampToDate(getCheckedDate());
    }

    public boolean getAttributeVolumeHardwareLock() {
        return ((getAttributes() >> 7) & 1) != 0;
    }

    public boolean getAttributeVolumeUnmounted() {
        return ((getAttributes() >> 8) & 1) != 0;
    }

    public boolean getAttributeVolumeSparedBlocks() {
        return ((getAttributes() >> 9) & 1) != 0;
    }

    public boolean getAttributeVolumeNoCacheRequired() {
        return ((getAttributes() >> 10) & 1) != 0;
    }

    public boolean getAttributeBootVolumeInconsistent() {
        return ((getAttributes() >> 11) & 1) != 0;
    }

    public boolean getAttributeCatalogNodeIDsReused() {
        return ((getAttributes() >> 12) & 1) != 0;
    }

    public boolean getAttributeVolumeJournaled() {
        return ((getAttributes() >> 13) & 1) != 0;
    }

    public boolean getAttributeVolumeSoftwareLock() {
        return ((getAttributes() >> 15) & 1) != 0;
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "signature: \"" + Util.toASCIIString(getSignature()) + "\"");
        ps.println(prefix + "version: " + ((int) getVersion()));
        ps.println(prefix + "attributes: " + getAttributes());
        printAttributes(ps, prefix + "  ");
        ps.println(prefix + "lastMountedVersion: " + getLastMountedVersion());
        ps.println(prefix + "journalInfoBlock: " + getJournalInfoBlock());
        ps.println(prefix + "createDate: " + getCreateDateAsDate());
        ps.println(prefix + "modifyDate: " + getModifyDateAsDate());
        ps.println(prefix + "backupDate: " + getBackupDateAsDate());
        ps.println(prefix + "checkedDate: " + getCheckedDateAsDate());
        ps.println(prefix + "fileCount: " + getFileCount());
        ps.println(prefix + "folderCount: " + getFolderCount());
        ps.println(prefix + "blockSize: " + getBlockSize());
        ps.println(prefix + "totalBlocks: " + getTotalBlocks());
        ps.println(prefix + "freeBlocks: " + getFreeBlocks());
        ps.println(prefix + "nextAllocation: " + getNextAllocation());
        ps.println(prefix + "rsrcClumpSize: " + getRsrcClumpSize());
        ps.println(prefix + "dataClumpSize: " + getDataClumpSize());
        ps.println(prefix + "nextCatalogID: " + getNextCatalogID().toString());
        ps.println(prefix + "writeCount: " + getWriteCount());
        ps.println(prefix + "encodingsBitmap: " + getEncodingsBitmap());
        ps.println(prefix + "encodingsBitmap (hex): 0x" + Util.toHexStringBE(getEncodingsBitmap()));
        int[] finderInfoInts = getFinderInfo();
        for (int i2 = 0; i2 < finderInfoInts.length; i2++) {
            ps.println(prefix + "finderInfo[" + i2 + "]: " + finderInfoInts[i2]);
        }
        ps.println(prefix + "allocationFile: ");
        this.allocationFile.print(ps, prefix + "  ");
        ps.println(prefix + "extentsFile: ");
        this.extentsFile.print(ps, prefix + "  ");
        ps.println(prefix + "catalogFile: ");
        this.catalogFile.print(ps, prefix + "  ");
        ps.println(prefix + "attributesFile: ");
        this.attributesFile.print(ps, prefix + "  ");
        ps.println(prefix + "startupFile: ");
        this.startupFile.print(ps, prefix + "  ");
    }

    public void printAttributes(PrintStream ps, int pregap) {
        String pregapString = "";
        for (int i2 = 0; i2 < pregap; i2++) {
            pregapString = pregapString + " ";
        }
    }

    public void printAttributes(PrintStream ps, String prefix) {
        int attributesInt = getAttributes();
        ps.println(prefix + "kHFSVolumeHardwareLockBit = " + ((attributesInt >> 7) & 1));
        ps.println(prefix + "kHFSVolumeUnmountedBit = " + ((attributesInt >> 8) & 1));
        ps.println(prefix + "kHFSVolumeSparedBlocksBit = " + ((attributesInt >> 9) & 1));
        ps.println(prefix + "kHFSVolumeNoCacheRequiredBit = " + ((attributesInt >> 10) & 1));
        ps.println(prefix + "kHFSBootVolumeInconsistentBit = " + ((attributesInt >> 11) & 1));
        ps.println(prefix + "kHFSCatalogNodeIDsReusedBit = " + ((attributesInt >> 12) & 1));
        ps.println(prefix + "kHFSVolumeJournaledBit = " + ((attributesInt >> 13) & 1));
        ps.println(prefix + "kHFSVolumeSoftwareLockBit = " + ((attributesInt >> 15) & 1));
    }

    private Dictionary getAttributeElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder("Attributes");
        db.addFlag("kHFSVolumeHardwareLockBit", this.attributes, 7);
        db.addFlag("kHFSVolumeUnmountedBit", this.attributes, 8);
        db.addFlag("kHFSVolumeSparedBlocksBit", this.attributes, 9);
        db.addFlag("kHFSVolumeNoCacheRequiredBit", this.attributes, 10);
        db.addFlag("kHFSBootVolumeInconsistentBit", this.attributes, 11);
        db.addFlag("kHFSCatalogNodeIDsReusedBit", this.attributes, 12);
        db.addFlag("kHFSVolumeJournaledBit", this.attributes, 13);
        db.addFlag("kHFSVolumeSoftwareLockBit", this.attributes, 15);
        return db.getResult();
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSPlusVolumeHeader.class.getSimpleName());
        db.add("signature", new ASCIIStringField(this.signature));
        db.addUIntBE(DatabaseFieldConfigLoader.FIELD_NAME_VERSION, this.version);
        db.add("attributes", getAttributeElements());
        db.addUIntBE("lastMountedVersion", this.lastMountedVersion);
        db.addUIntBE("journalInfoBlock", this.journalInfoBlock);
        db.add("createDate", new HFSPlusDateField(this.createDate, true));
        db.add("modifyDate", new HFSPlusDateField(this.modifyDate, true));
        db.add("backupDate", new HFSPlusDateField(this.backupDate, true));
        db.add("checkedDate", new HFSPlusDateField(this.checkedDate, true));
        db.addUIntBE("fileCount", this.fileCount);
        db.addUIntBE("folderCount", this.folderCount);
        db.addUIntBE("blockSize", this.blockSize);
        db.addUIntBE("totalBlocks", this.totalBlocks);
        db.addUIntBE("freeBlocks", this.freeBlocks);
        db.addUIntBE("nextAllocation", this.nextAllocation);
        db.addUIntBE("rsrcClumpSize", this.rsrcClumpSize);
        db.addUIntBE("dataClumpSize", this.dataClumpSize);
        db.add("nextCatalogID", this.nextCatalogID.getStructElements());
        db.addUIntBE("writeCount", this.writeCount);
        db.addUIntBE("encodingsBitmap", this.encodingsBitmap);
        db.addIntArray("finderInfo", this.finderInfo, BITS_32, SIGNED, BIG_ENDIAN);
        db.add("allocationFile", this.allocationFile.getStructElements());
        db.add("extentsFile", this.extentsFile.getStructElements());
        db.add("catalogFile", this.catalogFile.getStructElements());
        db.add("attributesFile", this.attributesFile.getStructElements());
        db.add("startupFile", this.startupFile.getStructElements());
        return db.getResult();
    }
}
