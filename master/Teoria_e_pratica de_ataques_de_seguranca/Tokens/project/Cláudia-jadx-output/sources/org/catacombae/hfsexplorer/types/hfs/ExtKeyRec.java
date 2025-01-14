package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/ExtKeyRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/ExtKeyRec.class */
public class ExtKeyRec implements StructElements {
    public static final byte FORK_TYPE_DATA = 0;
    public static final byte FORK_TYPE_RESOURCE = -1;
    public static final int STRUCTSIZE = 8;
    private final byte[] xkrKeyLen;
    private final byte[] xkrFkType;
    private final byte[] xkrFNum;
    private final byte[] xkrFABN;

    public ExtKeyRec(byte[] data, int offset) {
        this.xkrKeyLen = new byte[1];
        this.xkrFkType = new byte[1];
        this.xkrFNum = new byte[4];
        this.xkrFABN = new byte[2];
        System.arraycopy(data, offset + 0, this.xkrKeyLen, 0, 1);
        System.arraycopy(data, offset + 1, this.xkrFkType, 0, 1);
        System.arraycopy(data, offset + 2, this.xkrFNum, 0, 4);
        System.arraycopy(data, offset + 6, this.xkrFABN, 0, 2);
    }

    public ExtKeyRec(byte forkType, int fileID, short startBlock) {
        this.xkrKeyLen = new byte[1];
        this.xkrFkType = new byte[1];
        this.xkrFNum = new byte[4];
        this.xkrFABN = new byte[2];
        this.xkrKeyLen[0] = 7;
        this.xkrFkType[0] = forkType;
        System.arraycopy(Util.toByteArrayBE(fileID), 0, this.xkrFNum, 0, this.xkrFNum.length);
        System.arraycopy(Util.toByteArrayBE(startBlock), 0, this.xkrFABN, 0, this.xkrFABN.length);
    }

    public static int length() {
        return 8;
    }

    public byte getXkrKeyLen() {
        return Util.readByteBE(this.xkrKeyLen);
    }

    public byte getXkrFkType() {
        return Util.readByteBE(this.xkrFkType);
    }

    public int getXkrFNum() {
        return Util.readIntBE(this.xkrFNum);
    }

    public short getXkrFABN() {
        return Util.readShortBE(this.xkrFABN);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " xkrKeyLen: " + ((int) getXkrKeyLen()));
        ps.println(prefix + " xkrFkType: " + ((int) getXkrFkType()));
        ps.println(prefix + " xkrFNum: " + getXkrFNum());
        ps.println(prefix + " xkrFABN: " + ((int) getXkrFABN()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ExtKeyRec:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[8];
        System.arraycopy(this.xkrKeyLen, 0, result, 0, this.xkrKeyLen.length);
        int offset = 0 + this.xkrKeyLen.length;
        System.arraycopy(this.xkrFkType, 0, result, offset, this.xkrFkType.length);
        int offset2 = offset + this.xkrFkType.length;
        System.arraycopy(this.xkrFNum, 0, result, offset2, this.xkrFNum.length);
        int offset3 = offset2 + this.xkrFNum.length;
        System.arraycopy(this.xkrFABN, 0, result, offset3, this.xkrFABN.length);
        int length = offset3 + this.xkrFABN.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder("ExtKeyRec", "HFS extent key");
        db.addUIntBE("xkrKeyLen", this.xkrKeyLen, "Key length", "bytes");
        db.addUIntBE("xkrFkType", this.xkrFkType, "Fork type");
        db.addUIntBE("xkrFNum", this.xkrFNum, "File ID");
        db.addUIntBE("xkrFABN", this.xkrFABN, "Start block number");
        return db.getResult();
    }
}
