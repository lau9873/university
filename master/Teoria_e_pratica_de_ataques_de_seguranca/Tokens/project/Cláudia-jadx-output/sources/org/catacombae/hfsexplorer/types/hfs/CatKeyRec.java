package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.DynamicStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ASCIIStringField;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CatKeyRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CatKeyRec.class */
public class CatKeyRec implements DynamicStruct, StructElements {
    private static final int MAX_STRUCTSIZE = 38;
    private final byte[] ckrKeyLen;
    private final byte[] ckrResrv1;
    private final byte[] ckrParID;
    private final byte[] ckrCNameLen;
    private final byte[] ckrCName;
    private final byte[] ckrPad;

    public CatKeyRec(byte[] data, int offset) {
        this.ckrKeyLen = new byte[1];
        this.ckrResrv1 = new byte[1];
        this.ckrParID = new byte[4];
        System.arraycopy(data, offset + 0, this.ckrKeyLen, 0, 1);
        System.arraycopy(data, offset + 1, this.ckrResrv1, 0, 1);
        System.arraycopy(data, offset + 2, this.ckrParID, 0, 4);
        int structSize = 1 + Util.unsign(getCkrKeyLen());
        if (structSize >= 6 && structSize <= 38) {
            if (structSize >= 7) {
                this.ckrCNameLen = new byte[1];
                System.arraycopy(data, offset + 6, this.ckrCNameLen, 0, 1);
                int trailingBytes = structSize - 7;
                int cNameLen = Util.unsign(getCkrCNameLen());
                if (cNameLen > trailingBytes) {
                    throw new RuntimeException("Malformed CatKeyRec: ckrCNameLen=" + cNameLen + " > trailingBytes=" + trailingBytes);
                }
                this.ckrCName = new byte[cNameLen];
                System.arraycopy(data, offset + 7, this.ckrCName, 0, this.ckrCName.length);
                int remainingBytes = trailingBytes - cNameLen;
                this.ckrPad = new byte[remainingBytes];
                System.arraycopy(data, offset + 7 + cNameLen, this.ckrPad, 0, remainingBytes);
                return;
            }
            this.ckrCNameLen = new byte[0];
            this.ckrCName = new byte[0];
            this.ckrPad = new byte[0];
            return;
        }
        throw new RuntimeException("Incorrect value for ckrKeyLen: " + ((int) Util.unsign(getCkrKeyLen())));
    }

    public CatKeyRec(int parID, byte[] cName) {
        this.ckrKeyLen = new byte[1];
        this.ckrResrv1 = new byte[1];
        this.ckrParID = new byte[4];
        if (cName.length < 0 || cName.length > 32) {
            throw new IllegalArgumentException("String too large for a catalog file key! (size: " + cName.length + ")");
        }
        byte[] parIDBytes = Util.toByteArrayBE(parID);
        if (parIDBytes.length != 4) {
            throw new RuntimeException("Internal error! int array not 4 bytes but " + parIDBytes.length);
        }
        this.ckrCName = new byte[cName.length];
        this.ckrPad = new byte[0];
        this.ckrKeyLen[0] = (byte) (5 + cName.length);
        this.ckrResrv1[0] = 0;
        System.arraycopy(parIDBytes, 0, this.ckrParID, 0, this.ckrParID.length);
        if (cName.length > 0) {
            this.ckrCNameLen = new byte[1];
            this.ckrCNameLen[0] = (byte) cName.length;
            System.arraycopy(cName, 0, this.ckrCName, 0, this.ckrCName.length);
            return;
        }
        this.ckrCNameLen = new byte[0];
    }

    public byte getCkrKeyLen() {
        return Util.readByteBE(this.ckrKeyLen);
    }

    public byte getCkrResrv1() {
        return Util.readByteBE(this.ckrResrv1);
    }

    public int getCkrParID() {
        return Util.readIntBE(this.ckrParID);
    }

    public byte getCkrCNameLen() {
        return Util.readByteBE(this.ckrCNameLen);
    }

    public byte[] getCkrCName() {
        return Util.createCopy(this.ckrCName);
    }

    public byte[] getCkrPad() {
        return Util.createCopy(this.ckrPad);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " ckrKeyLen: " + ((int) getCkrKeyLen()));
        ps.println(prefix + " ckrResrv1: " + ((int) getCkrResrv1()));
        ps.println(prefix + " ckrParID: " + getCkrParID());
        ps.println(prefix + " ckrCNameLen: " + ((int) getCkrCNameLen()));
        ps.println(prefix + " ckrCName: \"" + Util.toASCIIString(getCkrCName()) + "\" (0x" + Util.byteArrayToHexString(getCkrCName()) + ")");
        ps.println(prefix + " ckrPad: byte[" + this.ckrPad.length + "]");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CatKeyRec:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[occupiedSize()];
        System.arraycopy(this.ckrKeyLen, 0, result, 0, this.ckrKeyLen.length);
        int offset = 0 + this.ckrKeyLen.length;
        System.arraycopy(this.ckrResrv1, 0, result, offset, this.ckrResrv1.length);
        int offset2 = offset + this.ckrResrv1.length;
        System.arraycopy(this.ckrParID, 0, result, offset2, this.ckrParID.length);
        int offset3 = offset2 + this.ckrParID.length;
        System.arraycopy(this.ckrCNameLen, 0, result, offset3, this.ckrCNameLen.length);
        int offset4 = offset3 + this.ckrCNameLen.length;
        System.arraycopy(this.ckrCName, 0, result, offset4, this.ckrCName.length);
        int offset5 = offset4 + this.ckrCName.length;
        System.arraycopy(this.ckrPad, 0, result, offset5, this.ckrPad.length);
        int length = offset5 + this.ckrPad.length;
        return result;
    }

    @Override // org.catacombae.csjc.DynamicStruct
    public int maxSize() {
        return 38;
    }

    @Override // org.catacombae.csjc.DynamicStruct
    public int occupiedSize() {
        return 1 + Util.unsign(getCkrKeyLen());
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CatKeyRec.class.getSimpleName());
        db.addUIntBE("ckrKeyLen", this.ckrKeyLen, "Key length", "bytes");
        db.addUIntBE("ckrResrv1", this.ckrResrv1, "Reserved", HEXADECIMAL);
        db.addUIntBE("ckrParID", this.ckrParID, "Parent ID");
        db.addUIntBE("ckrCNameLen", this.ckrCNameLen, "Length of record name", "bytes");
        db.add("ckrCName", new ASCIIStringField(this.ckrCName), "Record name");
        return db.getResult();
    }
}
