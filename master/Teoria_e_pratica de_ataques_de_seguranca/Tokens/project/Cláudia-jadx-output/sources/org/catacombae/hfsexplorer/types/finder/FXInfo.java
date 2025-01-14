package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/FXInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/FXInfo.class */
public class FXInfo implements StructElements {
    public static final int STRUCTSIZE = 16;
    private final byte[] fdIconID = new byte[2];
    private final byte[] fdReserved = new byte[6];
    private final byte[] fdScript = new byte[1];
    private final byte[] fdXFlags = new byte[1];
    private final byte[] fdComment = new byte[2];
    private final byte[] fdPutAway = new byte[4];

    public FXInfo(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.fdIconID, 0, 2);
        System.arraycopy(data, offset + 2, this.fdReserved, 0, 6);
        System.arraycopy(data, offset + 8, this.fdScript, 0, 1);
        System.arraycopy(data, offset + 9, this.fdXFlags, 0, 1);
        System.arraycopy(data, offset + 10, this.fdComment, 0, 2);
        System.arraycopy(data, offset + 12, this.fdPutAway, 0, 4);
    }

    public static int length() {
        return 16;
    }

    public short getFdIconID() {
        return Util.readShortBE(this.fdIconID);
    }

    public short[] getFdReserved() {
        return Util.readShortArrayBE(this.fdReserved);
    }

    public byte getFdScript() {
        return Util.readByteBE(this.fdScript);
    }

    public byte getFdXFlags() {
        return Util.readByteBE(this.fdXFlags);
    }

    public short getFdComment() {
        return Util.readShortBE(this.fdComment);
    }

    public int getFdPutAway() {
        return Util.readIntBE(this.fdPutAway);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " fdIconID: " + ((int) getFdIconID()));
        ps.println(prefix + " fdReserved: " + getFdReserved());
        ps.println(prefix + " fdScript: " + ((int) getFdScript()));
        ps.println(prefix + " fdXFlags: " + ((int) getFdXFlags()));
        ps.println(prefix + " fdComment: " + ((int) getFdComment()));
        ps.println(prefix + " fdPutAway: " + getFdPutAway());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "FXInfo:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[16];
        System.arraycopy(this.fdIconID, 0, result, 0, this.fdIconID.length);
        int offset = 0 + this.fdIconID.length;
        System.arraycopy(this.fdReserved, 0, result, offset, this.fdReserved.length);
        int offset2 = offset + this.fdReserved.length;
        System.arraycopy(this.fdScript, 0, result, offset2, this.fdScript.length);
        int offset3 = offset2 + this.fdScript.length;
        System.arraycopy(this.fdXFlags, 0, result, offset3, this.fdXFlags.length);
        int offset4 = offset3 + this.fdXFlags.length;
        System.arraycopy(this.fdComment, 0, result, offset4, this.fdComment.length);
        int offset5 = offset4 + this.fdComment.length;
        System.arraycopy(this.fdPutAway, 0, result, offset5, this.fdPutAway.length);
        int length = offset5 + this.fdPutAway.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(FXInfo.class.getSimpleName());
        db.addSIntBE("fdIconID", this.fdIconID);
        db.addIntArray("fdReserved", this.fdReserved, BITS_16, UNSIGNED, BIG_ENDIAN);
        db.addSIntBE("fdScript", this.fdScript);
        db.addUIntBE("fdXFlags", this.fdXFlags);
        db.addSIntBE("fdComment", this.fdComment);
        db.addSIntBE("fdPutAway", this.fdPutAway);
        return db.getResult();
    }
}
