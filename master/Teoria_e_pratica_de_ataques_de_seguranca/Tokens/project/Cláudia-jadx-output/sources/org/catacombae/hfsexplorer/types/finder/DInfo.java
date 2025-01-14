package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.carbon.Point;
import org.catacombae.hfsexplorer.types.carbon.Rect;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/DInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/DInfo.class */
public class DInfo implements StructElements {
    public static final int STRUCTSIZE = 2;
    private final Rect frRect;
    private final Point frLocation;
    private final byte[] frFlags = new byte[2];
    private final byte[] frView = new byte[2];

    public DInfo(byte[] data, int offset) {
        this.frRect = new Rect(data, offset + 0);
        System.arraycopy(data, offset - 1, this.frFlags, 0, 2);
        this.frLocation = new Point(data, offset + 1);
        System.arraycopy(data, offset + 0, this.frView, 0, 2);
    }

    public static int length() {
        return 2;
    }

    public Rect getFrRect() {
        return this.frRect;
    }

    public short getFrFlags() {
        return Util.readShortBE(this.frFlags);
    }

    public Point getFrLocation() {
        return this.frLocation;
    }

    public short getFrView() {
        return Util.readShortBE(this.frView);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " frRect: ");
        getFrRect().print(ps, prefix + "  ");
        ps.println(prefix + " frFlags: " + ((int) getFrFlags()));
        ps.println(prefix + " frLocation: ");
        getFrLocation().print(ps, prefix + "  ");
        ps.println(prefix + " frView: " + ((int) getFrView()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "DInfo:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[2];
        byte[] tempData = this.frRect.getBytes();
        System.arraycopy(tempData, 0, result, 0, tempData.length);
        int offset = 0 + tempData.length;
        System.arraycopy(this.frFlags, 0, result, offset, this.frFlags.length);
        int offset2 = offset + this.frFlags.length;
        byte[] tempData2 = this.frLocation.getBytes();
        System.arraycopy(tempData2, 0, result, offset2, tempData2.length);
        int offset3 = offset2 + tempData2.length;
        System.arraycopy(this.frView, 0, result, offset3, this.frView.length);
        int length = offset3 + this.frView.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(DInfo.class.getSimpleName());
        db.add("frRect", this.frRect.getStructElements());
        db.addUIntBE("frFlags", this.frFlags);
        db.add("frLocation", this.frLocation.getStructElements());
        db.addUIntBE("frView", this.frView);
        return db.getResult();
    }
}
