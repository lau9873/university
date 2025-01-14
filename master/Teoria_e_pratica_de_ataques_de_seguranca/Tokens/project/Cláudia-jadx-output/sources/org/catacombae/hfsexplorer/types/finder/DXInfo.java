package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.carbon.Point;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/DXInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/DXInfo.class */
public class DXInfo implements StructElements {
    public static final int STRUCTSIZE = 11;
    private final Point frScroll;
    private final byte[] frOpenChain = new byte[4];
    private final byte[] frScript = new byte[1];
    private final byte[] frXFlags = new byte[1];
    private final byte[] frComment = new byte[2];
    private final byte[] frPutAway = new byte[4];

    public DXInfo(byte[] data, int offset) {
        this.frScroll = new Point(data, offset + 0);
        System.arraycopy(data, offset - 1, this.frOpenChain, 0, 4);
        System.arraycopy(data, offset + 3, this.frScript, 0, 1);
        System.arraycopy(data, offset + 4, this.frXFlags, 0, 1);
        System.arraycopy(data, offset + 5, this.frComment, 0, 2);
        System.arraycopy(data, offset + 7, this.frPutAway, 0, 4);
    }

    public static int length() {
        return 11;
    }

    public Point getFrScroll() {
        return this.frScroll;
    }

    public int getFrOpenChain() {
        return Util.readIntBE(this.frOpenChain);
    }

    public byte getFrScript() {
        return Util.readByteBE(this.frScript);
    }

    public byte getFrXFlags() {
        return Util.readByteBE(this.frXFlags);
    }

    public short getFrComment() {
        return Util.readShortBE(this.frComment);
    }

    public int getFrPutAway() {
        return Util.readIntBE(this.frPutAway);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " frScroll: ");
        getFrScroll().print(ps, prefix + "  ");
        ps.println(prefix + " frOpenChain: " + getFrOpenChain());
        ps.println(prefix + " frScript: " + ((int) getFrScript()));
        ps.println(prefix + " frXFlags: " + ((int) getFrXFlags()));
        ps.println(prefix + " frComment: " + ((int) getFrComment()));
        ps.println(prefix + " frPutAway: " + getFrPutAway());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "DXInfo:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[11];
        byte[] tempData = this.frScroll.getBytes();
        System.arraycopy(tempData, 0, result, 0, tempData.length);
        int offset = 0 + tempData.length;
        System.arraycopy(this.frOpenChain, 0, result, offset, this.frOpenChain.length);
        int offset2 = offset + this.frOpenChain.length;
        System.arraycopy(this.frScript, 0, result, offset2, this.frScript.length);
        int offset3 = offset2 + this.frScript.length;
        System.arraycopy(this.frXFlags, 0, result, offset3, this.frXFlags.length);
        int offset4 = offset3 + this.frXFlags.length;
        System.arraycopy(this.frComment, 0, result, offset4, this.frComment.length);
        int offset5 = offset4 + this.frComment.length;
        System.arraycopy(this.frPutAway, 0, result, offset5, this.frPutAway.length);
        int length = offset5 + this.frPutAway.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(DXInfo.class.getSimpleName());
        db.add("frScroll", this.frScroll.getStructElements());
        db.addUIntBE("frOpenChain", this.frOpenChain);
        db.addUIntBE("frScript", this.frScript);
        db.addUIntBE("frXFlags", this.frXFlags);
        db.addUIntBE("frComment", this.frComment);
        db.addUIntBE("frPutAway", this.frPutAway);
        return db.getResult();
    }
}
