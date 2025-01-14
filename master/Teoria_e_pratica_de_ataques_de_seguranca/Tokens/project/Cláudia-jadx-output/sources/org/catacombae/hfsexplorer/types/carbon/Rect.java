package org.catacombae.hfsexplorer.types.carbon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/carbon/Rect.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/carbon/Rect.class */
public class Rect implements StructElements {
    public static final int STRUCTSIZE = 8;
    private final byte[] top = new byte[2];
    private final byte[] left = new byte[2];
    private final byte[] bottom = new byte[2];
    private final byte[] right = new byte[2];

    public Rect(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.top, 0, 2);
        System.arraycopy(data, offset + 2, this.left, 0, 2);
        System.arraycopy(data, offset + 4, this.bottom, 0, 2);
        System.arraycopy(data, offset + 6, this.right, 0, 2);
    }

    public static int length() {
        return 8;
    }

    public short getTop() {
        return Util.readShortBE(this.top);
    }

    public short getLeft() {
        return Util.readShortBE(this.left);
    }

    public short getBottom() {
        return Util.readShortBE(this.bottom);
    }

    public short getRight() {
        return Util.readShortBE(this.right);
    }

    public String toString() {
        return "(" + ((int) getTop()) + "," + ((int) getLeft()) + "," + ((int) getBottom()) + "," + ((int) getRight()) + ")";
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " top: " + ((int) getTop()));
        ps.println(prefix + " left: " + ((int) getLeft()));
        ps.println(prefix + " bottom: " + ((int) getBottom()));
        ps.println(prefix + " right: " + ((int) getRight()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "Rect:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[8];
        System.arraycopy(this.top, 0, result, 0, this.top.length);
        int offset = 0 + this.top.length;
        System.arraycopy(this.left, 0, result, offset, this.left.length);
        int offset2 = offset + this.left.length;
        System.arraycopy(this.bottom, 0, result, offset2, this.bottom.length);
        int offset3 = offset2 + this.bottom.length;
        System.arraycopy(this.right, 0, result, offset3, this.right.length);
        int length = offset3 + this.right.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(Rect.class.getSimpleName());
        db.addUIntBE("top", this.top);
        db.addUIntBE("left", this.left);
        db.addUIntBE("bottom", this.bottom);
        db.addUIntBE("right", this.right);
        return db.getResult();
    }
}
