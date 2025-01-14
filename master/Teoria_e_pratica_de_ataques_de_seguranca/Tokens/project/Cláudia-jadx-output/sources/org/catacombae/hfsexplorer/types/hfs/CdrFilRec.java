package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.finder.FInfo;
import org.catacombae.hfsexplorer.types.finder.FXInfo;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CdrFilRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CdrFilRec.class */
public class CdrFilRec extends CatDataRec {
    public static final int STRUCTSIZE = 102;
    private final byte[] filFlags;
    private final byte[] filTyp;
    private final FInfo filUsrWds;
    private final byte[] filFlNum;
    private final byte[] filStBlk;
    private final byte[] filLgLen;
    private final byte[] filPyLen;
    private final byte[] filRStBlk;
    private final byte[] filRLgLen;
    private final byte[] filRPyLen;
    private final byte[] filCrDat;
    private final byte[] filMdDat;
    private final byte[] filBkDat;
    private final FXInfo filFndrInfo;
    private final byte[] filClpSize;
    private final ExtDataRec filExtRec;
    private final ExtDataRec filRExtRec;
    private final byte[] filResrv;

    public CdrFilRec(byte[] data, int offset) {
        super(data, offset);
        this.filFlags = new byte[1];
        this.filTyp = new byte[1];
        this.filFlNum = new byte[4];
        this.filStBlk = new byte[2];
        this.filLgLen = new byte[4];
        this.filPyLen = new byte[4];
        this.filRStBlk = new byte[2];
        this.filRLgLen = new byte[4];
        this.filRPyLen = new byte[4];
        this.filCrDat = new byte[4];
        this.filMdDat = new byte[4];
        this.filBkDat = new byte[4];
        this.filClpSize = new byte[2];
        this.filResrv = new byte[4];
        System.arraycopy(data, offset + 2, this.filFlags, 0, 1);
        System.arraycopy(data, offset + 3, this.filTyp, 0, 1);
        this.filUsrWds = new FInfo(data, offset + 4);
        System.arraycopy(data, offset + 20, this.filFlNum, 0, 4);
        System.arraycopy(data, offset + 24, this.filStBlk, 0, 2);
        System.arraycopy(data, offset + 26, this.filLgLen, 0, 4);
        System.arraycopy(data, offset + 30, this.filPyLen, 0, 4);
        System.arraycopy(data, offset + 34, this.filRStBlk, 0, 2);
        System.arraycopy(data, offset + 36, this.filRLgLen, 0, 4);
        System.arraycopy(data, offset + 40, this.filRPyLen, 0, 4);
        System.arraycopy(data, offset + 44, this.filCrDat, 0, 4);
        System.arraycopy(data, offset + 48, this.filMdDat, 0, 4);
        System.arraycopy(data, offset + 52, this.filBkDat, 0, 4);
        this.filFndrInfo = new FXInfo(data, offset + 56);
        System.arraycopy(data, offset + 72, this.filClpSize, 0, 2);
        this.filExtRec = new ExtDataRec(data, offset + 74);
        this.filRExtRec = new ExtDataRec(data, offset + 86);
        System.arraycopy(data, offset + 98, this.filResrv, 0, 4);
    }

    public static int length() {
        return 102;
    }

    @Override // org.catacombae.csjc.StaticStruct
    public int size() {
        return length();
    }

    public byte getFilFlags() {
        return Util.readByteBE(this.filFlags);
    }

    public byte getFilTyp() {
        return Util.readByteBE(this.filTyp);
    }

    public FInfo getFilUsrWds() {
        return this.filUsrWds;
    }

    public int getFilFlNum() {
        return Util.readIntBE(this.filFlNum);
    }

    public short getFilStBlk() {
        return Util.readShortBE(this.filStBlk);
    }

    public int getFilLgLen() {
        return Util.readIntBE(this.filLgLen);
    }

    public int getFilPyLen() {
        return Util.readIntBE(this.filPyLen);
    }

    public short getFilRStBlk() {
        return Util.readShortBE(this.filRStBlk);
    }

    public int getFilRLgLen() {
        return Util.readIntBE(this.filRLgLen);
    }

    public int getFilRPyLen() {
        return Util.readIntBE(this.filRPyLen);
    }

    public int getFilCrDat() {
        return Util.readIntBE(this.filCrDat);
    }

    public int getFilMdDat() {
        return Util.readIntBE(this.filMdDat);
    }

    public int getFilBkDat() {
        return Util.readIntBE(this.filBkDat);
    }

    public FXInfo getFilFndrInfo() {
        return this.filFndrInfo;
    }

    public short getFilClpSize() {
        return Util.readShortBE(this.filClpSize);
    }

    public ExtDataRec getFilExtRec() {
        return this.filExtRec;
    }

    public ExtDataRec getFilRExtRec() {
        return this.filRExtRec;
    }

    public int getFilResrv() {
        return Util.readIntBE(this.filResrv);
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        super.printFields(ps, prefix);
        ps.println(prefix + " filFlags: " + ((int) getFilFlags()));
        ps.println(prefix + " filTyp: " + ((int) getFilTyp()));
        ps.println(prefix + " filUsrWds: ");
        getFilUsrWds().print(ps, prefix + "  ");
        ps.println(prefix + " filFlNum: " + getFilFlNum());
        ps.println(prefix + " filStBlk: " + ((int) getFilStBlk()));
        ps.println(prefix + " filLgLen: " + getFilLgLen());
        ps.println(prefix + " filPyLen: " + getFilPyLen());
        ps.println(prefix + " filRStBlk: " + ((int) getFilRStBlk()));
        ps.println(prefix + " filRLgLen: " + getFilRLgLen());
        ps.println(prefix + " filRPyLen: " + getFilRPyLen());
        ps.println(prefix + " filCrDat: " + getFilCrDat());
        ps.println(prefix + " filMdDat: " + getFilMdDat());
        ps.println(prefix + " filBkDat: " + getFilBkDat());
        ps.println(prefix + " filFndrInfo: ");
        getFilFndrInfo().print(ps, prefix + "  ");
        ps.println(prefix + " filClpSize: " + ((int) getFilClpSize()));
        ps.println(prefix + " filExtRec: ");
        getFilExtRec().print(ps, prefix + "  ");
        ps.println(prefix + " filRExtRec: ");
        getFilRExtRec().print(ps, prefix + "  ");
        ps.println(prefix + " filResrv: " + getFilResrv());
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CdrFilRec:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[102];
        byte[] superData = super.getBytes();
        System.arraycopy(superData, 0, result, 0, superData.length);
        int offset = 0 + superData.length;
        System.arraycopy(this.filFlags, 0, result, offset, this.filFlags.length);
        int offset2 = offset + this.filFlags.length;
        System.arraycopy(this.filTyp, 0, result, offset2, this.filTyp.length);
        int offset3 = offset2 + this.filTyp.length;
        byte[] tempData = this.filUsrWds.getBytes();
        System.arraycopy(tempData, 0, result, offset3, tempData.length);
        int offset4 = offset3 + tempData.length;
        System.arraycopy(this.filFlNum, 0, result, offset4, this.filFlNum.length);
        int offset5 = offset4 + this.filFlNum.length;
        System.arraycopy(this.filStBlk, 0, result, offset5, this.filStBlk.length);
        int offset6 = offset5 + this.filStBlk.length;
        System.arraycopy(this.filLgLen, 0, result, offset6, this.filLgLen.length);
        int offset7 = offset6 + this.filLgLen.length;
        System.arraycopy(this.filPyLen, 0, result, offset7, this.filPyLen.length);
        int offset8 = offset7 + this.filPyLen.length;
        System.arraycopy(this.filRStBlk, 0, result, offset8, this.filRStBlk.length);
        int offset9 = offset8 + this.filRStBlk.length;
        System.arraycopy(this.filRLgLen, 0, result, offset9, this.filRLgLen.length);
        int offset10 = offset9 + this.filRLgLen.length;
        System.arraycopy(this.filRPyLen, 0, result, offset10, this.filRPyLen.length);
        int offset11 = offset10 + this.filRPyLen.length;
        System.arraycopy(this.filCrDat, 0, result, offset11, this.filCrDat.length);
        int offset12 = offset11 + this.filCrDat.length;
        System.arraycopy(this.filMdDat, 0, result, offset12, this.filMdDat.length);
        int offset13 = offset12 + this.filMdDat.length;
        System.arraycopy(this.filBkDat, 0, result, offset13, this.filBkDat.length);
        int offset14 = offset13 + this.filBkDat.length;
        byte[] tempData2 = this.filFndrInfo.getBytes();
        System.arraycopy(tempData2, 0, result, offset14, tempData2.length);
        int offset15 = offset14 + tempData2.length;
        System.arraycopy(this.filClpSize, 0, result, offset15, this.filClpSize.length);
        int offset16 = offset15 + this.filClpSize.length;
        byte[] tempData3 = this.filExtRec.getBytes();
        System.arraycopy(tempData3, 0, result, offset16, tempData3.length);
        int offset17 = offset16 + tempData3.length;
        byte[] tempData4 = this.filRExtRec.getBytes();
        System.arraycopy(tempData4, 0, result, offset17, tempData4.length);
        int offset18 = offset17 + tempData4.length;
        System.arraycopy(this.filResrv, 0, result, offset18, this.filResrv.length);
        int length = offset18 + this.filResrv.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CdrThdRec.class.getSimpleName());
        super.addSuperStructElements(db);
        db.addUIntBE("filFlags", this.filFlags, "File flags");
        db.addUIntBE("filTyp", this.filTyp, "File type");
        db.add("filUsrWds", this.filUsrWds.getStructElements(), "Finder info");
        db.addUIntBE("filFlNum", this.filFlNum, "File ID");
        db.addUIntBE("filStBlk", this.filStBlk, "First allocation block in data fork");
        db.addUIntBE("filLgLen", this.filLgLen, "Logical length of data fork", "bytes");
        db.addUIntBE("filPyLen", this.filPyLen, "Physical length of data fork", "bytes");
        db.addUIntBE("filRStBlk", this.filRStBlk, "First allocation block in resource fork");
        db.addUIntBE("filRLgLen", this.filRLgLen, "Logical length of resource fork", "bytes");
        db.addUIntBE("filRPyLen", this.filRPyLen, "Physical length of resource fork", "bytes");
        db.add("filCrDat", new HFSDateField(this.filCrDat), "Creation date");
        db.add("filMdDat", new HFSDateField(this.filMdDat), "Modify date");
        db.add("filBkDat", new HFSDateField(this.filBkDat), "Backup date");
        db.add("filFndrInfo", this.filFndrInfo.getStructElements(), "Extended Finder info");
        db.addUIntBE("filClpSize", this.filClpSize, "File clump size");
        db.add("filExtRec", this.filExtRec.getStructElements(), "First data fork extent record");
        db.add("filRExtRec", this.filRExtRec.getStructElements(), "First resource fork extent record");
        db.addUIntBE("filResrv", this.filResrv, "Reserved", HEXADECIMAL);
        return db.getResult();
    }
}
