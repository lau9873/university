package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentLeafRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentLeafRecord.class */
public class HFSPlusExtentLeafRecord {
    private final HFSPlusExtentKey key;
    private final HFSPlusExtentRecord recordData;

    public HFSPlusExtentLeafRecord(byte[] data, int offset) {
        this.key = new HFSPlusExtentKey(data, offset + 0);
        this.recordData = new HFSPlusExtentRecord(data, offset + 12);
    }

    public static int length() {
        return 76;
    }

    public HFSPlusExtentKey getKey() {
        return this.key;
    }

    public HFSPlusExtentRecord getRecordData() {
        return this.recordData;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " key: ");
        getKey().print(ps, prefix + "  ");
        ps.println(prefix + " recordData: ");
        getRecordData().print(ps, prefix + "  ");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusExtentLeafRecord:");
        printFields(ps, prefix);
    }
}
