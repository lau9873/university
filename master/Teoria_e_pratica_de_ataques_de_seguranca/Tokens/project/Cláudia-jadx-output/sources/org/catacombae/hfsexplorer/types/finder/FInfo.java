package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.carbon.OSType;
import org.catacombae.hfsexplorer.types.carbon.Point;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/FInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/FInfo.class */
public class FInfo implements StructElements {
    public static final int STRUCTSIZE = 16;
    private final OSType fdType;
    private final OSType fdCreator;
    private final Point fdLocation;
    private final byte[] fdFlags = new byte[2];
    private final byte[] fdFldr = new byte[2];

    public FInfo(byte[] data, int offset) {
        this.fdType = new OSType(data, offset + 0);
        this.fdCreator = new OSType(data, offset + 4);
        System.arraycopy(data, offset + 8, this.fdFlags, 0, 2);
        this.fdLocation = new Point(data, offset + 10);
        System.arraycopy(data, offset + 14, this.fdFldr, 0, 2);
    }

    public static int length() {
        return 16;
    }

    public OSType getFdType() {
        return this.fdType;
    }

    public OSType getFdCreator() {
        return this.fdCreator;
    }

    public short getFdFlags() {
        return Util.readShortBE(this.fdFlags);
    }

    public Point getFdLocation() {
        return this.fdLocation;
    }

    public short getFdFldr() {
        return Util.readShortBE(this.fdFldr);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " fdType: ");
        getFdType().print(ps, prefix + "  ");
        ps.println(prefix + " fdCreator: ");
        getFdCreator().print(ps, prefix + "  ");
        ps.println(prefix + " fdFlags: " + ((int) getFdFlags()));
        ps.println(prefix + " fdLocation: ");
        getFdLocation().print(ps, prefix + "  ");
        ps.println(prefix + " fdFldr: " + ((int) getFdFldr()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "FInfo:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        byte[] tempData = this.fdType.getBytes();
        System.arraycopy(tempData, 0, result, 0, tempData.length);
        int offset = 0 + tempData.length;
        byte[] tempData2 = this.fdCreator.getBytes();
        System.arraycopy(tempData2, 0, result, offset, tempData2.length);
        int offset2 = offset + tempData2.length;
        System.arraycopy(this.fdFlags, 0, result, offset2, this.fdFlags.length);
        int offset3 = offset2 + this.fdFlags.length;
        byte[] tempData3 = this.fdLocation.getBytes();
        System.arraycopy(tempData3, 0, result, offset3, tempData3.length);
        int offset4 = offset3 + tempData3.length;
        System.arraycopy(this.fdFldr, 0, result, offset4, this.fdFldr.length);
        int length = offset4 + this.fdFldr.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(FInfo.class.getSimpleName());
        db.add("fdType", this.fdType.getStructElements());
        db.add("fdCreator", this.fdCreator.getStructElements());
        db.addUIntBE("fdFlags", this.fdFlags);
        db.add("fdLocation", this.fdLocation.getStructElements());
        db.addSIntBE("fdFldr", this.fdFldr);
        return db.getResult();
    }
}
