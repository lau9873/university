package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ASCIIStringField;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CdrFThdRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CdrFThdRec.class */
public class CdrFThdRec extends CatDataRec {
    public static final int STRUCTSIZE = 46;
    private final byte[] fthdResrv;
    private final byte[] fthdParID;
    private final byte[] fthdCNameLen;
    private final byte[] fthdCName;

    public CdrFThdRec(byte[] data, int offset) {
        super(data, offset);
        this.fthdResrv = new byte[8];
        this.fthdParID = new byte[4];
        this.fthdCNameLen = new byte[1];
        this.fthdCName = new byte[31];
        System.arraycopy(data, offset + 2, this.fthdResrv, 0, 8);
        System.arraycopy(data, offset + 10, this.fthdParID, 0, 4);
        System.arraycopy(data, offset + 14, this.fthdCNameLen, 0, 1);
        System.arraycopy(data, offset + 15, this.fthdCName, 0, 31);
    }

    public static int length() {
        return 46;
    }

    public int[] getFthdResrv() {
        return Util.readIntArrayBE(this.fthdResrv);
    }

    public int getFthdParID() {
        return Util.readIntBE(this.fthdParID);
    }

    public byte getFthdCNameLen() {
        return Util.readByteBE(this.fthdCNameLen);
    }

    public byte[] getFthdCName() {
        return Util.readByteArrayBE(this.fthdCName);
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        super.printFields(ps, prefix);
        ps.println(prefix + " fthdResrv: " + getFthdResrv());
        ps.println(prefix + " fthdParID: " + Util.unsign(getFthdParID()));
        ps.println(prefix + " fthdCNameLen: " + ((int) Util.unsign(getFthdCNameLen())));
        ps.println(prefix + " fthdCName: \"" + Util.toASCIIString(getFthdCName()) + "\"");
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CdrFThdRec:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[46];
        byte[] superData = super.getBytes();
        System.arraycopy(superData, 0, result, 0, superData.length);
        int offset = 0 + superData.length;
        System.arraycopy(this.fthdResrv, 0, result, offset, this.fthdResrv.length);
        int offset2 = offset + this.fthdResrv.length;
        System.arraycopy(this.fthdParID, 0, result, offset2, this.fthdParID.length);
        int offset3 = offset2 + this.fthdParID.length;
        System.arraycopy(this.fthdCNameLen, 0, result, offset3, this.fthdCNameLen.length);
        int offset4 = offset3 + this.fthdCNameLen.length;
        System.arraycopy(this.fthdCName, 0, result, offset4, this.fthdCName.length);
        int length = offset4 + this.fthdCName.length;
        return result;
    }

    @Override // org.catacombae.csjc.StaticStruct
    public int size() {
        return length();
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CdrFThdRec.class.getSimpleName());
        super.addSuperStructElements(db);
        db.addIntArray("fthdResrv", this.fthdResrv, BITS_32, UNSIGNED, BIG_ENDIAN, "Reserved", HEXADECIMAL);
        db.addUIntBE("fthdParID", this.fthdParID, "Parent ID");
        db.addUIntBE("fthdCNameLen", this.fthdCNameLen, "Length of record name", "bytes");
        db.add("fthdCName", new ASCIIStringField(this.fthdCName), "Record name");
        return db.getResult();
    }
}
