package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/ExtendedFileInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/ExtendedFileInfo.class */
public class ExtendedFileInfo extends CommonExtendedFinderInfo implements StructElements {
    private final byte[] reserved1;

    public ExtendedFileInfo(byte[] data, int offset) {
        super(data, offset);
        this.reserved1 = new byte[8];
        System.arraycopy(data, offset + 0, this.reserved1, 0, 8);
    }

    public static int length() {
        return 16;
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonExtendedFinderInfo
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.reserved1, 0, result, 0, this.reserved1.length);
        int offset = 0 + this.reserved1.length;
        byte[] tempData = super.getBytes();
        System.arraycopy(tempData, 0, result, offset, tempData.length);
        int length = offset + tempData.length;
        return result;
    }

    public short[] getReserved1() {
        return Util.readShortArrayBE(this.reserved1);
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonExtendedFinderInfo, org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " reserved1: " + getReserved1());
        super.printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ExtendedFileInfo:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonExtendedFinderInfo, org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(ExtendedFileInfo.class.getName());
        db.addIntArray("reserved1", this.reserved1, BITS_16, UNSIGNED, BIG_ENDIAN);
        db.addAll(super.getStructElements());
        return db.getResult();
    }
}
