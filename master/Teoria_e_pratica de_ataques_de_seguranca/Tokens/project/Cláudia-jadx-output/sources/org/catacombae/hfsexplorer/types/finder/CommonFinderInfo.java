package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.carbon.Point;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/CommonFinderInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/CommonFinderInfo.class */
public abstract class CommonFinderInfo implements StructElements, PrintableStruct {
    public static final int[] COLOR_1 = {169, 169, 169};
    public static final int[] COLOR_2 = {149, 228, 40};
    public static final int[] COLOR_3 = {255, 108, 185};
    public static final int[] COLOR_4 = {0, 176, 229};
    public static final int[] COLOR_5 = {255, 230, 32};
    public static final int[] COLOR_6 = {255, 64, 84};
    public static final int[] COLOR_7 = {255, 184, 31};
    public static final int kIsOnDesk = 1;
    public static final int kColor = 14;
    public static final int kIsShared = 64;
    public static final int kHasNoINITs = 128;
    public static final int kHasBeenInited = 256;
    public static final int kHasCustomIcon = 1024;
    public static final int kIsStationery = 2048;
    public static final int kNameLocked = 4096;
    public static final int kHasBundle = 8192;
    public static final int kIsInvisible = 16384;
    public static final int kIsAlias = 32768;
    protected final Point location;
    protected final byte[] finderFlags = new byte[2];
    protected final byte[] reservedField = new byte[2];

    /* JADX INFO: Access modifiers changed from: protected */
    public CommonFinderInfo(byte[] data, int offset) {
        System.arraycopy(data, offset + 8, this.finderFlags, 0, 2);
        this.location = new Point(data, offset + 10);
        System.arraycopy(data, offset + 14, this.reservedField, 0, 2);
    }

    public static int length() {
        return 8;
    }

    public short getFinderFlags() {
        return Util.readShortBE(this.finderFlags);
    }

    public Point getLocation() {
        return this.location;
    }

    public short getReservedField() {
        return Util.readShortBE(this.reservedField);
    }

    public boolean getFinderFlagIsOnDesk() {
        return (getFinderFlags() & 1) != 0;
    }

    public byte getFinderFlagColor() {
        return (byte) ((getFinderFlags() & 14) >> 1);
    }

    public int[] getFinderFlagColorRGB() {
        int color = getFinderFlagColor();
        switch (color) {
            case 0:
                return null;
            case 1:
                return COLOR_1;
            case 2:
                return COLOR_2;
            case 3:
                return COLOR_3;
            case 4:
                return COLOR_4;
            case 5:
                return COLOR_5;
            case 6:
                return COLOR_6;
            case 7:
                return COLOR_7;
            default:
                throw new RuntimeException("Color out of range! (" + color + ")");
        }
    }

    public boolean getFinderFlagIsShared() {
        return (getFinderFlags() & 64) != 0;
    }

    public boolean getFinderFlagHasNoINITs() {
        return (getFinderFlags() & 128) != 0;
    }

    public boolean getFinderFlagHasBeenInited() {
        return (getFinderFlags() & 256) != 0;
    }

    public boolean getFinderFlagHasCustomIcon() {
        return (getFinderFlags() & 1024) != 0;
    }

    public boolean getFinderFlagIsStationery() {
        return (getFinderFlags() & 2048) != 0;
    }

    public boolean getFinderFlagNameLocked() {
        return (getFinderFlags() & 4096) != 0;
    }

    public boolean getFinderFlagHasBundle() {
        return (getFinderFlags() & 8192) != 0;
    }

    public boolean getFinderFlagIsInvisible() {
        return (getFinderFlags() & 16384) != 0;
    }

    public boolean getFinderFlagIsAlias() {
        return (getFinderFlags() & 32768) != 0;
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.finderFlags, 0, result, 0, this.finderFlags.length);
        int offset = 0 + this.finderFlags.length;
        byte[] tempData = this.location.getBytes();
        System.arraycopy(tempData, 0, result, offset, tempData.length);
        int offset2 = offset + tempData.length;
        System.arraycopy(this.reservedField, 0, result, offset2, this.reservedField.length);
        int length = offset2 + this.reservedField.length;
        return result;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " finderFlags: " + ((int) getFinderFlags()));
        ps.println(prefix + " location: ");
        getLocation().print(ps, prefix + "  ");
        ps.println(prefix + " reservedField: " + ((int) getReservedField()));
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CommonFinderInfo.class.getSimpleName());
        StructElements.DictionaryBuilder dbFinderFlags = new StructElements.DictionaryBuilder("UInt16");
        dbFinderFlags.addFlag("kIsAlias", this.finderFlags, 15);
        dbFinderFlags.addFlag("kIsInvisible", this.finderFlags, 14);
        dbFinderFlags.addFlag("kHasBundle", this.finderFlags, 13);
        dbFinderFlags.addFlag("kNameLocked", this.finderFlags, 12);
        dbFinderFlags.addFlag("kIsStationery", this.finderFlags, 11);
        dbFinderFlags.addFlag("kHasCustomIcon", this.finderFlags, 10);
        dbFinderFlags.addFlag("kHasBeenInited", this.finderFlags, 8);
        dbFinderFlags.addFlag("kHasNoINITs", this.finderFlags, 7);
        dbFinderFlags.addFlag("kIsShared", this.finderFlags, 6);
        dbFinderFlags.addFlag("kIsOnDesk", this.finderFlags, 1);
        Dictionary finderFlagsDictionary = db.getResult();
        db.add("finderFlags", finderFlagsDictionary);
        db.add("location", this.location.getStructElements());
        db.addUIntBE("reservedField", this.reservedField);
        return db.getResult();
    }
}
