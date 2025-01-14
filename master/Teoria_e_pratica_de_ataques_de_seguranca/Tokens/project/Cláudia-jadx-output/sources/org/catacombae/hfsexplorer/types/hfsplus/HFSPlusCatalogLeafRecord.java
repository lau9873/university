package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogLeafRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogLeafRecord.class */
public class HFSPlusCatalogLeafRecord {
    public static final int HFS_PLUS_FOLDER_RECORD = 1;
    public static final int HFS_PLUS_FILE_RECORD = 2;
    public static final int HFS_PLUS_FOLDER_THREAD_RECORD = 3;
    public static final int HFS_PLUS_FILE_THREAD_RECORD = 4;
    protected final HFSPlusCatalogKey key;
    protected final HFSPlusCatalogLeafRecordData recordData;

    public HFSPlusCatalogLeafRecord(byte[] data, int offset) {
        this(data, offset, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HFSPlusCatalogLeafRecord(byte[] data, int offset, BTHeaderRec catalogHeaderRec) {
        if (catalogHeaderRec == null) {
            this.key = new HFSPlusCatalogKey(data, offset);
        } else {
            this.key = new HFSXCatalogKey(data, offset, catalogHeaderRec);
        }
        short recordType = Util.readShortBE(data, offset + this.key.length());
        if (recordType == 1) {
            this.recordData = new HFSPlusCatalogFolder(data, offset + this.key.length());
        } else if (recordType == 2) {
            this.recordData = new HFSPlusCatalogFile(data, offset + this.key.length());
        } else if (recordType == 3) {
            this.recordData = new HFSPlusCatalogThread(data, offset + this.key.length());
        } else if (recordType == 4) {
            this.recordData = new HFSPlusCatalogThread(data, offset + this.key.length());
        } else {
            throw new RuntimeException("Ivalid record type!");
        }
    }

    public HFSPlusCatalogKey getKey() {
        return this.key;
    }

    public HFSPlusCatalogLeafRecordData getData() {
        return this.recordData;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " key:");
        this.key.printFields(ps, prefix + "  ");
        ps.println(prefix + " recordData:");
        this.recordData.printFields(ps, prefix + "  ");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusCatalogLeafRecord:");
        printFields(ps, prefix);
    }
}
