package org.catacombae.hfsexplorer.types.carbon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/carbon/Point.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/carbon/Point.class */
public class Point implements StructElements {
    public static final int STRUCTSIZE = 4;
    private final byte[] v = new byte[2];

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f7640h = new byte[2];

    public Point(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.v, 0, 2);
        System.arraycopy(data, offset + 2, this.f7640h, 0, 2);
    }

    public static int length() {
        return 4;
    }

    public short getV() {
        return Util.readShortBE(this.v);
    }

    public short getH() {
        return Util.readShortBE(this.f7640h);
    }

    public String toString() {
        return "(" + ((int) getV()) + "," + ((int) getH()) + ")";
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " v: " + ((int) getV()));
        ps.println(prefix + " h: " + ((int) getH()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "Point:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[4];
        System.arraycopy(this.v, 0, result, 0, this.v.length);
        int offset = 0 + this.v.length;
        System.arraycopy(this.f7640h, 0, result, offset, this.f7640h.length);
        int length = offset + this.f7640h.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(Point.class.getSimpleName());
        db.addUIntBE("v", this.v);
        db.addUIntBE("h", this.f7640h);
        return db.getResult();
    }
}
