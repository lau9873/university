package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.hfs.CatKeyRec;
import org.catacombae.hfsexplorer.types.hfs.CdrThdRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogThread;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderThreadRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderThreadRecord.class */
public class CommonHFSCatalogFolderThreadRecord extends CommonHFSCatalogLeafRecord implements PrintableStruct {
    private CommonHFSCatalogKey key;
    private CommonHFSCatalogFolderThread data;

    private CommonHFSCatalogFolderThreadRecord(CommonHFSCatalogKey key, CommonHFSCatalogFolderThread data) {
        this.key = key;
        this.data = data;
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord
    public CommonHFSCatalogKey getKey() {
        return this.key;
    }

    public CommonHFSCatalogFolderThread getData() {
        return this.data;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogFolderThreadRecord.class.getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + "key:");
        this.key.print(ps, prefix + " ");
        ps.println(prefix + "data:");
        this.data.print(ps, prefix + " ");
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CommonHFSCatalogFolderThreadRecord.class.getSimpleName(), "Folder thread record");
        db.add("key", this.key.getStructElements(), "Catalog key");
        db.add("data", this.data.getStructElements(), "Folder thread data");
        return db.getResult();
    }

    public static CommonHFSCatalogFolderThreadRecord create(HFSPlusCatalogKey key, HFSPlusCatalogThread data) {
        return new CommonHFSCatalogFolderThreadRecord(CommonHFSCatalogKey.create(key), CommonHFSCatalogFolderThread.create(data));
    }

    public static CommonHFSCatalogFolderThreadRecord create(CatKeyRec key, CdrThdRec data) {
        return new CommonHFSCatalogFolderThreadRecord(CommonHFSCatalogKey.create(key), CommonHFSCatalogFolderThread.create(data));
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
    public int getSize() {
        return this.key.occupiedSize() + this.data.length();
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
    public byte[] getBytes() {
        byte[] result = new byte[getSize()];
        byte[] tempData = getKey().getBytes();
        System.arraycopy(tempData, 0, result, 0, tempData.length);
        int offset = 0 + tempData.length;
        byte[] tempData2 = this.data.getBytes();
        System.arraycopy(tempData2, 0, result, offset, tempData2.length);
        int length = offset + tempData2.length;
        return result;
    }
}
