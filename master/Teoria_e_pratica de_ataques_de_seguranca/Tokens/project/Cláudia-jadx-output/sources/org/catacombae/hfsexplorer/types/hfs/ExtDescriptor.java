package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/ExtDescriptor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/ExtDescriptor.class */
public class ExtDescriptor implements StructElements {
    public static final int STRUCTSIZE = 4;
    private final byte[] xdrStABN;
    private final byte[] xdrNumABlks;

    public ExtDescriptor(byte[] data, int offset) {
        this.xdrStABN = new byte[2];
        this.xdrNumABlks = new byte[2];
        System.arraycopy(data, offset + 0, this.xdrStABN, 0, 2);
        System.arraycopy(data, offset + 2, this.xdrNumABlks, 0, 2);
    }

    public ExtDescriptor(short xdrStABN, short xdrNumABlks) {
        this.xdrStABN = new byte[2];
        this.xdrNumABlks = new byte[2];
        System.arraycopy(Util.toByteArrayBE(xdrStABN), 0, this.xdrStABN, 0, 2);
        System.arraycopy(Util.toByteArrayBE(xdrNumABlks), 0, this.xdrNumABlks, 0, 2);
    }

    public static int length() {
        return 4;
    }

    public short getXdrStABN() {
        return Util.readShortBE(this.xdrStABN);
    }

    public short getXdrNumABlks() {
        return Util.readShortBE(this.xdrNumABlks);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " xdrStABN: " + Util.unsign(getXdrStABN()));
        ps.println(prefix + " xdrNumABlks: " + Util.unsign(getXdrNumABlks()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ExtDescriptor:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[4];
        System.arraycopy(this.xdrStABN, 0, result, 0, this.xdrStABN.length);
        int offset = 0 + this.xdrStABN.length;
        System.arraycopy(this.xdrNumABlks, 0, result, offset, this.xdrNumABlks.length);
        int length = offset + this.xdrNumABlks.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(ExtDescriptor.class.getName());
        db.addUIntBE("xdrStABN", this.xdrStABN, "Start block");
        db.addUIntBE("xdrNumABlks", this.xdrNumABlks, "Number of blocks");
        return db.getResult();
    }
}
