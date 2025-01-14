package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.finder.DInfo;
import org.catacombae.hfsexplorer.types.finder.DXInfo;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CdrDirRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CdrDirRec.class */
public class CdrDirRec extends CatDataRec {
    public static final int STRUCTSIZE = 70;
    private final byte[] dirFlags;
    private final byte[] dirVal;
    private final byte[] dirDirID;
    private final byte[] dirCrDat;
    private final byte[] dirMdDat;
    private final byte[] dirBkDat;
    private final DInfo dirUsrInfo;
    private final DXInfo dirFndrInfo;
    private final byte[] dirResrv;

    public CdrDirRec(byte[] data, int offset) {
        super(data, offset);
        this.dirFlags = new byte[2];
        this.dirVal = new byte[2];
        this.dirDirID = new byte[4];
        this.dirCrDat = new byte[4];
        this.dirMdDat = new byte[4];
        this.dirBkDat = new byte[4];
        this.dirResrv = new byte[16];
        System.arraycopy(data, offset + 2, this.dirFlags, 0, 2);
        System.arraycopy(data, offset + 4, this.dirVal, 0, 2);
        System.arraycopy(data, offset + 6, this.dirDirID, 0, 4);
        System.arraycopy(data, offset + 10, this.dirCrDat, 0, 4);
        System.arraycopy(data, offset + 14, this.dirMdDat, 0, 4);
        System.arraycopy(data, offset + 18, this.dirBkDat, 0, 4);
        this.dirUsrInfo = new DInfo(data, offset + 22);
        this.dirFndrInfo = new DXInfo(data, offset + 38);
        System.arraycopy(data, offset + 54, this.dirResrv, 0, 16);
    }

    public static int length() {
        return 70;
    }

    public short getDirFlags() {
        return Util.readShortBE(this.dirFlags);
    }

    public short getDirVal() {
        return Util.readShortBE(this.dirVal);
    }

    public int getDirDirID() {
        return Util.readIntBE(this.dirDirID);
    }

    public int getDirCrDat() {
        return Util.readIntBE(this.dirCrDat);
    }

    public int getDirMdDat() {
        return Util.readIntBE(this.dirMdDat);
    }

    public int getDirBkDat() {
        return Util.readIntBE(this.dirBkDat);
    }

    public DInfo getDirUsrInfo() {
        return this.dirUsrInfo;
    }

    public DXInfo getDirFndrInfo() {
        return this.dirFndrInfo;
    }

    public int[] getDirResrv() {
        return Util.readIntArrayBE(this.dirResrv);
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CdrDirRec.class.getSimpleName());
        super.addSuperStructElements(db);
        db.addUIntBE("dirFlags", this.dirFlags, "Directory flags", BINARY);
        db.addUIntBE("dirVal", this.dirVal, "Valence");
        db.addUIntBE("dirDirID", this.dirDirID, "Directory ID");
        db.add("dirCrDat", new HFSDateField(this.dirCrDat), "Creation date");
        db.add("dirMdDat", new HFSDateField(this.dirMdDat), "Modification date");
        db.add("dirBkDat", new HFSDateField(this.dirBkDat), "Backup date");
        db.add("dirUsrInfo", this.dirUsrInfo.getStructElements(), "Finder info");
        db.add("dirFndrInfo", this.dirFndrInfo.getStructElements(), "Extended Finder info");
        db.addIntArray("dirResrv", this.dirResrv, BITS_32, UNSIGNED, BIG_ENDIAN, "Reserved", HEXADECIMAL);
        return db.getResult();
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        super.printFields(ps, prefix);
        ps.println(prefix + " cdrType: " + ((int) getCdrType()));
        ps.println(prefix + " cdrResrv2: " + ((int) getCdrResrv2()));
        ps.println(prefix + " dirFlags: " + ((int) getDirFlags()));
        ps.println(prefix + " dirVal: " + ((int) getDirVal()));
        ps.println(prefix + " dirDirID: " + getDirDirID());
        ps.println(prefix + " dirCrDat: " + getDirCrDat());
        ps.println(prefix + " dirMdDat: " + getDirMdDat());
        ps.println(prefix + " dirBkDat: " + getDirBkDat());
        ps.println(prefix + " dirUsrInfo: ");
        getDirUsrInfo().print(ps, prefix + "  ");
        ps.println(prefix + " dirFndrInfo: ");
        getDirFndrInfo().print(ps, prefix + "  ");
        ps.println(prefix + " dirResrv: " + getDirResrv());
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CdrDirRec:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[size()];
        byte[] superData = super.getBytes();
        System.arraycopy(superData, 0, result, 0, superData.length);
        int offset = 0 + superData.length;
        System.arraycopy(this.dirFlags, 0, result, offset, this.dirFlags.length);
        int offset2 = offset + this.dirFlags.length;
        System.arraycopy(this.dirVal, 0, result, offset2, this.dirVal.length);
        int offset3 = offset2 + this.dirVal.length;
        System.arraycopy(this.dirDirID, 0, result, offset3, this.dirDirID.length);
        int offset4 = offset3 + this.dirDirID.length;
        System.arraycopy(this.dirCrDat, 0, result, offset4, this.dirCrDat.length);
        int offset5 = offset4 + this.dirCrDat.length;
        System.arraycopy(this.dirMdDat, 0, result, offset5, this.dirMdDat.length);
        int offset6 = offset5 + this.dirMdDat.length;
        System.arraycopy(this.dirBkDat, 0, result, offset6, this.dirBkDat.length);
        int offset7 = offset6 + this.dirBkDat.length;
        byte[] tempData = this.dirUsrInfo.getBytes();
        System.arraycopy(tempData, 0, result, offset7, tempData.length);
        int offset8 = offset7 + tempData.length;
        byte[] tempData2 = this.dirFndrInfo.getBytes();
        System.arraycopy(tempData2, 0, result, offset8, tempData2.length);
        int offset9 = offset8 + tempData2.length;
        System.arraycopy(this.dirResrv, 0, result, offset9, this.dirResrv.length);
        int length = offset9 + this.dirResrv.length;
        return result;
    }

    @Override // org.catacombae.csjc.StaticStruct
    public int size() {
        return length();
    }
}
