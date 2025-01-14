package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusForkData.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusForkData.class */
public class HFSPlusForkData implements StructElements {
    private final byte[] logicalSize = new byte[8];
    private final byte[] clumpSize = new byte[4];
    private final byte[] totalBlocks = new byte[4];
    private final HFSPlusExtentRecord extents;

    public HFSPlusForkData(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.logicalSize, 0, 8);
        System.arraycopy(data, offset + 8, this.clumpSize, 0, 4);
        System.arraycopy(data, offset + 12, this.totalBlocks, 0, 4);
        this.extents = new HFSPlusExtentRecord(data, offset + 16);
    }

    public static int length() {
        return 80;
    }

    public long getLogicalSize() {
        return Util.readLongBE(this.logicalSize);
    }

    public long getClumpSize() {
        return Util.readIntBE(this.clumpSize);
    }

    public long getTotalBlocks() {
        return Util.readIntBE(this.totalBlocks);
    }

    public HFSPlusExtentRecord getExtents() {
        return this.extents;
    }

    public void print(PrintStream ps, int pregap) {
        String pregapString = "";
        for (int i2 = 0; i2 < pregap; i2++) {
            pregapString = pregapString + " ";
        }
        print(ps, pregapString);
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "logicalSize: " + getLogicalSize());
        ps.println(prefix + "clumpSize: " + getClumpSize());
        ps.println(prefix + "totalBlocks: " + getTotalBlocks());
        ps.println(prefix + "extents:");
        this.extents.print(ps, prefix + "  ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.logicalSize, 0, result, 0, this.logicalSize.length);
        int offset = 0 + this.logicalSize.length;
        System.arraycopy(this.clumpSize, 0, result, offset, this.clumpSize.length);
        int offset2 = offset + this.clumpSize.length;
        System.arraycopy(this.totalBlocks, 0, result, offset2, this.totalBlocks.length);
        int offset3 = offset2 + this.totalBlocks.length;
        byte[] tempData = this.extents.getBytes();
        System.arraycopy(tempData, 0, result, offset3, tempData.length);
        int length = offset3 + tempData.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSPlusForkData.class.getSimpleName());
        db.addUIntBE("logicalSize", this.logicalSize);
        db.addUIntBE("clumpSize", this.clumpSize);
        db.addUIntBE("totalBlocks", this.totalBlocks);
        db.add("extents", this.extents.getStructElements());
        return db.getResult();
    }
}
