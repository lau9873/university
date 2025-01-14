package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.carbon.Point;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/ExtendedFolderInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/ExtendedFolderInfo.class */
public class ExtendedFolderInfo extends CommonExtendedFinderInfo {
    private final Point scrollPosition;
    private final byte[] reserved1;

    public ExtendedFolderInfo(byte[] data, int offset) {
        super(data, offset);
        this.reserved1 = new byte[4];
        this.scrollPosition = new Point(data, offset + 0);
        System.arraycopy(data, offset + 4, this.reserved1, 0, 4);
    }

    public static int length() {
        return 16;
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonExtendedFinderInfo
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        byte[] tempData = this.scrollPosition.getBytes();
        System.arraycopy(tempData, 0, result, 0, tempData.length);
        int offset = 0 + tempData.length;
        System.arraycopy(this.reserved1, 0, result, offset, this.reserved1.length);
        int offset2 = offset + this.reserved1.length;
        byte[] tempData2 = super.getBytes();
        System.arraycopy(tempData2, 0, result, offset2, tempData2.length);
        int length = offset2 + tempData2.length;
        return result;
    }

    public Point getScrollPosition() {
        return this.scrollPosition;
    }

    public int getReserved1() {
        return Util.readIntBE(this.reserved1);
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonExtendedFinderInfo, org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " scrollPosition: ");
        getScrollPosition().print(ps, prefix + "  ");
        ps.println(prefix + " reserved1: " + getReserved1());
        super.printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ExtendedFolderInfo:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonExtendedFinderInfo, org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(ExtendedFolderInfo.class.getName());
        db.add("scrollPosition", this.scrollPosition.getStructElements());
        db.addUIntBE("reserved1", this.reserved1);
        db.addAll(super.getStructElements());
        return db.getResult();
    }
}
