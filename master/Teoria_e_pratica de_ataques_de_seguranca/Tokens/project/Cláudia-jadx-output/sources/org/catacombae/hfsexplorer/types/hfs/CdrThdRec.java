package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ASCIIStringField;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CdrThdRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CdrThdRec.class */
public class CdrThdRec extends CatDataRec {
    public static final int STRUCTSIZE = 46;
    private final byte[] thdResrv;
    private final byte[] thdParID;
    private final byte[] thdCNameLen;
    private final byte[] thdCName;

    public CdrThdRec(byte[] data, int offset) {
        super(data, offset);
        this.thdResrv = new byte[8];
        this.thdParID = new byte[4];
        this.thdCNameLen = new byte[1];
        this.thdCName = new byte[31];
        System.arraycopy(data, offset + 2, this.thdResrv, 0, 8);
        System.arraycopy(data, offset + 10, this.thdParID, 0, 4);
        System.arraycopy(data, offset + 14, this.thdCNameLen, 0, 1);
        System.arraycopy(data, offset + 15, this.thdCName, 0, 31);
    }

    public static int length() {
        return 46;
    }

    public int[] getThdResrv() {
        return Util.readIntArrayBE(this.thdResrv);
    }

    public int getThdParID() {
        return Util.readIntBE(this.thdParID);
    }

    public byte getThdCNameLen() {
        return Util.readByteBE(this.thdCNameLen);
    }

    public byte[] getThdCName() {
        return Util.readByteArrayBE(this.thdCName);
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        super.printFields(ps, prefix);
        ps.println(prefix + " thdResrv: " + getThdResrv());
        ps.println(prefix + " thdParID: " + Util.unsign(getThdParID()));
        ps.println(prefix + " thdCNameLen: " + ((int) Util.unsign(getThdCNameLen())));
        ps.println(prefix + " thdCName: \"" + Util.toASCIIString(getThdCName()) + "\"");
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CdrThdRec:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.hfs.CatDataRec, org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[46];
        byte[] superData = super.getBytes();
        System.arraycopy(superData, 0, result, 0, superData.length);
        int offset = 0 + superData.length;
        System.arraycopy(this.thdResrv, 0, result, offset, this.thdResrv.length);
        int offset2 = offset + this.thdResrv.length;
        System.arraycopy(this.thdParID, 0, result, offset2, this.thdParID.length);
        int offset3 = offset2 + this.thdParID.length;
        System.arraycopy(this.thdCNameLen, 0, result, offset3, this.thdCNameLen.length);
        int offset4 = offset3 + this.thdCNameLen.length;
        System.arraycopy(this.thdCName, 0, result, offset4, this.thdCName.length);
        int length = offset4 + this.thdCName.length;
        return result;
    }

    @Override // org.catacombae.csjc.StaticStruct
    public int size() {
        return length();
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CdrThdRec.class.getSimpleName());
        super.addSuperStructElements(db);
        db.addIntArray("thdResrv", this.thdResrv, BITS_32, UNSIGNED, BIG_ENDIAN, "Reserved", HEXADECIMAL);
        db.addUIntBE("thdParID", this.thdParID, "Parent ID");
        db.addUIntBE("thdCNameLen", this.thdCNameLen, "Length of record name");
        db.add("thdCName", new ASCIIStringField(this.thdCName), "Record name");
        return db.getResult();
    }
}
