package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/CommonExtendedFinderInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/CommonExtendedFinderInfo.class */
public abstract class CommonExtendedFinderInfo implements StructElements, PrintableStruct {
    public static final int kExtendedFlagsAreInvalid = 32768;
    public static final int kExtendedFlagHasCustomBadge = 256;
    public static final int kExtendedFlagHasRoutingInfo = 4;
    protected final byte[] extendedFinderFlags = new byte[2];
    protected final byte[] reserved2 = new byte[2];
    protected final byte[] putAwayFolderID = new byte[4];

    /* JADX INFO: Access modifiers changed from: protected */
    public CommonExtendedFinderInfo(byte[] data, int offset) {
        System.arraycopy(data, offset + 8, this.extendedFinderFlags, 0, 2);
        System.arraycopy(data, offset + 10, this.reserved2, 0, 2);
        System.arraycopy(data, offset + 12, this.putAwayFolderID, 0, 4);
    }

    private static final int length() {
        return 8;
    }

    public short getExtendedFinderFlags() {
        return Util.readShortBE(this.extendedFinderFlags);
    }

    public short getReserved2() {
        return Util.readShortBE(this.reserved2);
    }

    public int getPutAwayFolderID() {
        return Util.readIntBE(this.putAwayFolderID);
    }

    public boolean getExtendedFinderFlagExtendedFlagsAreInvalid() {
        return (getExtendedFinderFlags() & 32768) != 0;
    }

    public boolean getExtendedFinderFlagExtendedFlagHasCustomBadge() {
        return (getExtendedFinderFlags() & 256) != 0;
    }

    public boolean getExtendedFinderFlagExtendedFlagHasRoutingInfo() {
        return (getExtendedFinderFlags() & 4) != 0;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " extendedFinderFlags: " + ((int) getExtendedFinderFlags()));
        ps.println(prefix + " reserved2: " + ((int) getReserved2()));
        ps.println(prefix + " putAwayFolderID: " + getPutAwayFolderID());
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CommonExtendedFinderInfo.class.getName());
        StructElements.DictionaryBuilder dbExtendedFinderFlags = new StructElements.DictionaryBuilder("UInt16");
        dbExtendedFinderFlags.addFlag("kExtendedFlagsAreInvalid", this.extendedFinderFlags, 15);
        dbExtendedFinderFlags.addFlag("kExtendedFlagHasCustomBadge", this.extendedFinderFlags, 8);
        dbExtendedFinderFlags.addFlag("kExtendedFlagHasRoutingInfo", this.extendedFinderFlags, 3);
        Dictionary extendedFinderFlagsDict = dbExtendedFinderFlags.getResult();
        db.add("extendedFinderFlags", extendedFinderFlagsDict);
        db.addUIntBE("reserved2", this.reserved2);
        db.addUIntBE("putAwayFolderID", this.putAwayFolderID);
        return db.getResult();
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.extendedFinderFlags, 0, result, 0, this.extendedFinderFlags.length);
        int offset = 0 + this.extendedFinderFlags.length;
        System.arraycopy(this.reserved2, 0, result, offset, this.reserved2.length);
        int offset2 = offset + this.reserved2.length;
        System.arraycopy(this.putAwayFolderID, 0, result, offset2, this.putAwayFolderID.length);
        int length = offset2 + this.putAwayFolderID.length;
        return result;
    }
}
