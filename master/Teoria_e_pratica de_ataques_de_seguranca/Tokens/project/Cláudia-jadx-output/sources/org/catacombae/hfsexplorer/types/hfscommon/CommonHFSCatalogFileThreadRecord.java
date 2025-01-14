package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.hfs.CatKeyRec;
import org.catacombae.hfsexplorer.types.hfs.CdrFThdRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogThread;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileThreadRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileThreadRecord.class */
public class CommonHFSCatalogFileThreadRecord extends CommonHFSCatalogLeafRecord implements PrintableStruct {
    private CommonHFSCatalogKey key;
    private CommonHFSCatalogFileThread data;

    private CommonHFSCatalogFileThreadRecord(CommonHFSCatalogKey key, CommonHFSCatalogFileThread data) {
        this.key = key;
        this.data = data;
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord
    public CommonHFSCatalogKey getKey() {
        return this.key;
    }

    public CommonHFSCatalogFileThread getData() {
        return this.data;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogFileThreadRecord.class.getSimpleName() + ":");
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
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CommonHFSCatalogFileThreadRecord.class.getSimpleName(), "File thread record");
        db.add("key", this.key.getStructElements(), "Catalog key");
        db.add("data", this.data.getStructElements(), "File thread data");
        return db.getResult();
    }

    public static CommonHFSCatalogFileThreadRecord create(HFSPlusCatalogKey key, HFSPlusCatalogThread data) {
        return new CommonHFSCatalogFileThreadRecord(CommonHFSCatalogKey.create(key), CommonHFSCatalogFileThread.create(data));
    }

    public static CommonHFSCatalogFileThreadRecord create(CatKeyRec key, CdrFThdRec data) {
        return new CommonHFSCatalogFileThreadRecord(CommonHFSCatalogKey.create(key), CommonHFSCatalogFileThread.create(data));
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
