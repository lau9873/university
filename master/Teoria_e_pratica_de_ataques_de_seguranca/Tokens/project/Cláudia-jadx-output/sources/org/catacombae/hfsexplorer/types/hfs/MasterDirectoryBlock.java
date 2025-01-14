package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import java.util.Date;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ASCIIStringField;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/MasterDirectoryBlock.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/MasterDirectoryBlock.class */
public class MasterDirectoryBlock implements StructElements {
    public static final int STRUCTSIZE = 162;
    private final ExtDataRec drXTExtRec;
    private final ExtDataRec drCTExtRec;
    private final byte[] drSigWord = new byte[2];
    private final byte[] drCrDate = new byte[4];
    private final byte[] drLsMod = new byte[4];
    private final byte[] drAtrb = new byte[2];
    private final byte[] drNmFls = new byte[2];
    private final byte[] drVBMSt = new byte[2];
    private final byte[] drAllocPtr = new byte[2];
    private final byte[] drNmAlBlks = new byte[2];
    private final byte[] drAlBlkSiz = new byte[4];
    private final byte[] drClpSiz = new byte[4];
    private final byte[] drAlBlSt = new byte[2];
    private final byte[] drNxtCNID = new byte[4];
    private final byte[] drFreeBks = new byte[2];
    private final byte[] drVNLength = new byte[1];
    private final byte[] drVN = new byte[28];
    private final byte[] drVolBkUp = new byte[4];
    private final byte[] drVSeqNum = new byte[2];
    private final byte[] drWrCnt = new byte[4];
    private final byte[] drXTClpSiz = new byte[4];
    private final byte[] drCTClpSiz = new byte[4];
    private final byte[] drNmRtDirs = new byte[2];
    private final byte[] drFilCnt = new byte[4];
    private final byte[] drDirCnt = new byte[4];
    private final byte[] drFndrInfo = new byte[32];
    private final byte[] drVCSize = new byte[2];
    private final byte[] drVBMCSize = new byte[2];
    private final byte[] drCtlCSize = new byte[2];
    private final byte[] drXTFlSize = new byte[4];
    private final byte[] drCTFlSize = new byte[4];

    public MasterDirectoryBlock(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.drSigWord, 0, 2);
        System.arraycopy(data, offset + 2, this.drCrDate, 0, 4);
        System.arraycopy(data, offset + 6, this.drLsMod, 0, 4);
        System.arraycopy(data, offset + 10, this.drAtrb, 0, 2);
        System.arraycopy(data, offset + 12, this.drNmFls, 0, 2);
        System.arraycopy(data, offset + 14, this.drVBMSt, 0, 2);
        System.arraycopy(data, offset + 16, this.drAllocPtr, 0, 2);
        System.arraycopy(data, offset + 18, this.drNmAlBlks, 0, 2);
        System.arraycopy(data, offset + 20, this.drAlBlkSiz, 0, 4);
        System.arraycopy(data, offset + 24, this.drClpSiz, 0, 4);
        System.arraycopy(data, offset + 28, this.drAlBlSt, 0, 2);
        System.arraycopy(data, offset + 30, this.drNxtCNID, 0, 4);
        System.arraycopy(data, offset + 34, this.drFreeBks, 0, 2);
        System.arraycopy(data, offset + 36, this.drVNLength, 0, 1);
        System.arraycopy(data, offset + 37, this.drVN, 0, 28);
        System.arraycopy(data, offset + 64, this.drVolBkUp, 0, 4);
        System.arraycopy(data, offset + 68, this.drVSeqNum, 0, 2);
        System.arraycopy(data, offset + 70, this.drWrCnt, 0, 4);
        System.arraycopy(data, offset + 74, this.drXTClpSiz, 0, 4);
        System.arraycopy(data, offset + 78, this.drCTClpSiz, 0, 4);
        System.arraycopy(data, offset + 82, this.drNmRtDirs, 0, 2);
        System.arraycopy(data, offset + 84, this.drFilCnt, 0, 4);
        System.arraycopy(data, offset + 88, this.drDirCnt, 0, 4);
        System.arraycopy(data, offset + 92, this.drFndrInfo, 0, 32);
        System.arraycopy(data, offset + 124, this.drVCSize, 0, 2);
        System.arraycopy(data, offset + 126, this.drVBMCSize, 0, 2);
        System.arraycopy(data, offset + 128, this.drCtlCSize, 0, 2);
        System.arraycopy(data, offset + 130, this.drXTFlSize, 0, 4);
        this.drXTExtRec = new ExtDataRec(data, offset + 134);
        System.arraycopy(data, offset + 146, this.drCTFlSize, 0, 4);
        this.drCTExtRec = new ExtDataRec(data, offset + 150);
    }

    public static int length() {
        return 162;
    }

    public short getDrSigWord() {
        return Util.readShortBE(this.drSigWord);
    }

    public int getDrCrDate() {
        return Util.readIntBE(this.drCrDate);
    }

    public int getDrLsMod() {
        return Util.readIntBE(this.drLsMod);
    }

    public short getDrAtrb() {
        return Util.readShortBE(this.drAtrb);
    }

    public short getDrNmFls() {
        return Util.readShortBE(this.drNmFls);
    }

    public short getDrVBMSt() {
        return Util.readShortBE(this.drVBMSt);
    }

    public short getDrAllocPtr() {
        return Util.readShortBE(this.drAllocPtr);
    }

    public short getDrNmAlBlks() {
        return Util.readShortBE(this.drNmAlBlks);
    }

    public int getDrAlBlkSiz() {
        return Util.readIntBE(this.drAlBlkSiz);
    }

    public int getDrClpSiz() {
        return Util.readIntBE(this.drClpSiz);
    }

    public short getDrAlBlSt() {
        return Util.readShortBE(this.drAlBlSt);
    }

    public int getDrNxtCNID() {
        return Util.readIntBE(this.drNxtCNID);
    }

    public short getDrFreeBks() {
        return Util.readShortBE(this.drFreeBks);
    }

    public byte getDrVNLength() {
        return Util.readByteBE(this.drVNLength);
    }

    public byte[] getDrVN() {
        return Util.createCopy(this.drVN);
    }

    public int getDrVolBkUp() {
        return Util.readIntBE(this.drVolBkUp);
    }

    public short getDrVSeqNum() {
        return Util.readShortBE(this.drVSeqNum);
    }

    public int getDrWrCnt() {
        return Util.readIntBE(this.drWrCnt);
    }

    public int getDrXTClpSiz() {
        return Util.readIntBE(this.drXTClpSiz);
    }

    public int getDrCTClpSiz() {
        return Util.readIntBE(this.drCTClpSiz);
    }

    public short getDrNmRtDirs() {
        return Util.readShortBE(this.drNmRtDirs);
    }

    public int getDrFilCnt() {
        return Util.readIntBE(this.drFilCnt);
    }

    public int getDrDirCnt() {
        return Util.readIntBE(this.drDirCnt);
    }

    public int[] getDrFndrInfo() {
        return Util.readIntArrayBE(this.drFndrInfo);
    }

    public short getDrVCSize() {
        return Util.readShortBE(this.drVCSize);
    }

    public short getDrVBMCSize() {
        return Util.readShortBE(this.drVBMCSize);
    }

    public short getDrCtlCSize() {
        return Util.readShortBE(this.drCtlCSize);
    }

    public int getDrXTFlSize() {
        return Util.readIntBE(this.drXTFlSize);
    }

    public ExtDataRec getDrXTExtRec() {
        return this.drXTExtRec;
    }

    public int getDrCTFlSize() {
        return Util.readIntBE(this.drCTFlSize);
    }

    public ExtDataRec getDrCTExtRec() {
        return this.drCTExtRec;
    }

    public Date getDrCrDateAsDate() {
        return HFSDate.localTimestampToDate(getDrCrDate());
    }

    public Date getDrLsModAsDate() {
        return HFSDate.localTimestampToDate(getDrLsMod());
    }

    public Date getDrVolBkUpAsDate() {
        return HFSDate.localTimestampToDate(getDrVolBkUp());
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " drSigWord: " + Util.unsign(getDrSigWord()) + " (\"" + Util.toASCIIString(getDrSigWord()) + "\")");
        ps.println(prefix + " drCrDate: " + Util.unsign(getDrCrDate()) + " (" + getDrCrDateAsDate() + ")");
        ps.println(prefix + " drLsMod: " + Util.unsign(getDrLsMod()) + " (" + getDrLsModAsDate() + ")");
        ps.println(prefix + " drAtrb: 0x" + Util.toHexStringBE(getDrAtrb()));
        ps.println(prefix + " drNmFls: " + Util.unsign(getDrNmFls()));
        ps.println(prefix + " drVBMSt: " + Util.unsign(getDrVBMSt()));
        ps.println(prefix + " drAllocPtr: " + Util.unsign(getDrAllocPtr()));
        ps.println(prefix + " drNmAlBlks: " + Util.unsign(getDrNmAlBlks()));
        ps.println(prefix + " drAlBlkSiz: " + Util.unsign(getDrAlBlkSiz()));
        ps.println(prefix + " drClpSiz: " + Util.unsign(getDrClpSiz()));
        ps.println(prefix + " drAlBlSt: " + Util.unsign(getDrAlBlSt()));
        ps.println(prefix + " drNxtCNID: " + Util.unsign(getDrNxtCNID()));
        ps.println(prefix + " drFreeBks: " + Util.unsign(getDrFreeBks()));
        ps.println(prefix + " drVNLength: " + ((int) Util.unsign(getDrVNLength())));
        ps.println(prefix + " drVN: \"" + Util.toASCIIString(getDrVN()) + "\"");
        ps.println(prefix + " drVolBkUp: " + Util.unsign(getDrVolBkUp()) + " (" + getDrVolBkUpAsDate() + ")");
        ps.println(prefix + " drVSeqNum: " + Util.unsign(getDrVSeqNum()));
        ps.println(prefix + " drWrCnt: " + Util.unsign(getDrWrCnt()));
        ps.println(prefix + " drXTClpSiz: " + Util.unsign(getDrXTClpSiz()));
        ps.println(prefix + " drCTClpSiz: " + Util.unsign(getDrCTClpSiz()));
        ps.println(prefix + " drNmRtDirs: " + Util.unsign(getDrNmRtDirs()));
        ps.println(prefix + " drFilCnt: " + Util.unsign(getDrFilCnt()));
        ps.println(prefix + " drDirCnt: " + Util.unsign(getDrDirCnt()));
        ps.println(prefix + " drFndrInfo: int[" + getDrFndrInfo().length + "]");
        ps.println(prefix + " drVCSize: " + Util.unsign(getDrVCSize()));
        ps.println(prefix + " drVBMCSize: " + Util.unsign(getDrVBMCSize()));
        ps.println(prefix + " drCtlCSize: " + Util.unsign(getDrCtlCSize()));
        ps.println(prefix + " drXTFlSize: " + Util.unsign(getDrXTFlSize()));
        ps.println(prefix + " drXTExtRec: ");
        getDrXTExtRec().print(ps, prefix + "  ");
        ps.println(prefix + " drCTFlSize: " + Util.unsign(getDrCTFlSize()));
        ps.println(prefix + " drCTExtRec: ");
        getDrCTExtRec().print(ps, prefix + "  ");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "MasterDirectoryBlock:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.drSigWord, 0, result, 0, this.drSigWord.length);
        int offset = 0 + this.drSigWord.length;
        System.arraycopy(this.drCrDate, 0, result, offset, this.drCrDate.length);
        int offset2 = offset + this.drCrDate.length;
        System.arraycopy(this.drLsMod, 0, result, offset2, this.drLsMod.length);
        int offset3 = offset2 + this.drLsMod.length;
        System.arraycopy(this.drAtrb, 0, result, offset3, this.drAtrb.length);
        int offset4 = offset3 + this.drAtrb.length;
        System.arraycopy(this.drNmFls, 0, result, offset4, this.drNmFls.length);
        int offset5 = offset4 + this.drNmFls.length;
        System.arraycopy(this.drVBMSt, 0, result, offset5, this.drVBMSt.length);
        int offset6 = offset5 + this.drVBMSt.length;
        System.arraycopy(this.drAllocPtr, 0, result, offset6, this.drAllocPtr.length);
        int offset7 = offset6 + this.drAllocPtr.length;
        System.arraycopy(this.drNmAlBlks, 0, result, offset7, this.drNmAlBlks.length);
        int offset8 = offset7 + this.drNmAlBlks.length;
        System.arraycopy(this.drAlBlkSiz, 0, result, offset8, this.drAlBlkSiz.length);
        int offset9 = offset8 + this.drAlBlkSiz.length;
        System.arraycopy(this.drClpSiz, 0, result, offset9, this.drClpSiz.length);
        int offset10 = offset9 + this.drClpSiz.length;
        System.arraycopy(this.drAlBlSt, 0, result, offset10, this.drAlBlSt.length);
        int offset11 = offset10 + this.drAlBlSt.length;
        System.arraycopy(this.drNxtCNID, 0, result, offset11, this.drNxtCNID.length);
        int offset12 = offset11 + this.drNxtCNID.length;
        System.arraycopy(this.drFreeBks, 0, result, offset12, this.drFreeBks.length);
        int offset13 = offset12 + this.drFreeBks.length;
        System.arraycopy(this.drVNLength, 0, result, offset13, this.drVNLength.length);
        int offset14 = offset13 + this.drVNLength.length;
        System.arraycopy(this.drVN, 0, result, offset14, this.drVN.length);
        int offset15 = offset14 + this.drVN.length;
        System.arraycopy(this.drVolBkUp, 0, result, offset15, this.drVolBkUp.length);
        int offset16 = offset15 + this.drVolBkUp.length;
        System.arraycopy(this.drVSeqNum, 0, result, offset16, this.drVSeqNum.length);
        int offset17 = offset16 + this.drVSeqNum.length;
        System.arraycopy(this.drWrCnt, 0, result, offset17, this.drWrCnt.length);
        int offset18 = offset17 + this.drWrCnt.length;
        System.arraycopy(this.drXTClpSiz, 0, result, offset18, this.drXTClpSiz.length);
        int offset19 = offset18 + this.drXTClpSiz.length;
        System.arraycopy(this.drCTClpSiz, 0, result, offset19, this.drCTClpSiz.length);
        int offset20 = offset19 + this.drCTClpSiz.length;
        System.arraycopy(this.drNmRtDirs, 0, result, offset20, this.drNmRtDirs.length);
        int offset21 = offset20 + this.drNmRtDirs.length;
        System.arraycopy(this.drFilCnt, 0, result, offset21, this.drFilCnt.length);
        int offset22 = offset21 + this.drFilCnt.length;
        System.arraycopy(this.drDirCnt, 0, result, offset22, this.drDirCnt.length);
        int offset23 = offset22 + this.drDirCnt.length;
        System.arraycopy(this.drFndrInfo, 0, result, offset23, this.drFndrInfo.length);
        int offset24 = offset23 + this.drFndrInfo.length;
        System.arraycopy(this.drVCSize, 0, result, offset24, this.drVCSize.length);
        int offset25 = offset24 + this.drVCSize.length;
        System.arraycopy(this.drVBMCSize, 0, result, offset25, this.drVBMCSize.length);
        int offset26 = offset25 + this.drVBMCSize.length;
        System.arraycopy(this.drCtlCSize, 0, result, offset26, this.drCtlCSize.length);
        int offset27 = offset26 + this.drCtlCSize.length;
        System.arraycopy(this.drXTFlSize, 0, result, offset27, this.drXTFlSize.length);
        int offset28 = offset27 + this.drXTFlSize.length;
        byte[] tempData = this.drXTExtRec.getBytes();
        System.arraycopy(tempData, 0, result, offset28, tempData.length);
        int offset29 = offset28 + tempData.length;
        System.arraycopy(this.drCTFlSize, 0, result, offset29, this.drCTFlSize.length);
        int offset30 = offset29 + this.drCTFlSize.length;
        byte[] tempData2 = this.drCTExtRec.getBytes();
        System.arraycopy(tempData2, 0, result, offset30, tempData2.length);
        int length = offset30 + tempData2.length;
        return result;
    }

    private Dictionary getAttributeElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder("Attributes");
        db.addFlag("kHFSVolumeHardwareLockBit", this.drAtrb, 7);
        db.addFlag("kHFSVolumeUnmountedBit", this.drAtrb, 8);
        db.addFlag("kHFSVolumeSparedBlocksBit", this.drAtrb, 9);
        db.addFlag("kHFSVolumeSoftwareLockBit", this.drAtrb, 15);
        return db.getResult();
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(MasterDirectoryBlock.class.getSimpleName());
        db.add("drSigWord", new ASCIIStringField(this.drSigWord), "Signature");
        db.add("drCrDate", new HFSDateField(this.drCrDate), "Creation date");
        db.add("drLsMod", new HFSDateField(this.drLsMod), "Last modified date");
        db.add("drAtrb", getAttributeElements(), "Volume attributes");
        db.addUIntBE("drNmFls", this.drNmFls, "Number of files in root directory");
        db.addUIntBE("drVBMSt", this.drVBMSt, "Start of volume bitmap");
        db.addUIntBE("drAllocPtr", this.drAllocPtr, "Start of next allocation search");
        db.addUIntBE("drNmAlBlks", this.drNmAlBlks, "Number of allocation blocks in volume");
        db.addUIntBE("drAlBlkSiz", this.drAlBlkSiz, "Allocation block size", "bytes");
        db.addUIntBE("drClpSiz", this.drClpSiz, "Default clump size", "bytes");
        db.addUIntBE("drAlBlSt", this.drAlBlSt, "Start of the allocation blocks");
        db.addUIntBE("drNxtCNID", this.drNxtCNID, "Next catalog node ID");
        db.addUIntBE("drFreeBks", this.drFreeBks, "Number of unused allocation blocks");
        db.addUIntBE("drVNLength", this.drVNLength, "Length of volume name");
        db.add("drVN", new ASCIIStringField(this.drVN), "Volume name");
        db.add("drVolBkUp", new HFSDateField(this.drVolBkUp), "Last backup date");
        db.addUIntBE("drVSeqNum", this.drVSeqNum, "Volume backup sequence number");
        db.addUIntBE("drWrCnt", this.drWrCnt, "Volume write count");
        db.addUIntBE("drXTClpSiz", this.drXTClpSiz, "Extents overflow file clump size", "bytes");
        db.addUIntBE("drCTClpSiz", this.drCTClpSiz, "Catalog file clump size", "bytes");
        db.addUIntBE("drNmRtDirs", this.drNmRtDirs, "Number of directories in root dir");
        db.addUIntBE("drFilCnt", this.drFilCnt, "Volume file count");
        db.addUIntBE("drDirCnt", this.drDirCnt, "Volume directory count");
        db.addIntArray("drFndrInfo", this.drFndrInfo, BITS_32, UNSIGNED, BIG_ENDIAN, "Finder info", HEXADECIMAL);
        db.addUIntBE("drVCSize", this.drVCSize, "Volume cache size", "blocks");
        db.addUIntBE("drVBMCSize", this.drVBMCSize, "Volume bitmap cache size", "blocks");
        db.addUIntBE("drCtlCSize", this.drCtlCSize, "Common volume cache size", "blocks");
        db.addUIntBE("drXTFlSize", this.drXTFlSize, "Size of extents overflow file", "bytes");
        db.add("drXTExtRec", this.drXTExtRec.getStructElements(), "Extent record for extents overflow file");
        db.addUIntBE("drCTFlSize", this.drCTFlSize, "Size of catalog file", "bytes");
        db.add("drCTExtRec", this.drCTExtRec.getStructElements(), "Extent record for catalog file");
        return db.getResult();
    }
}
