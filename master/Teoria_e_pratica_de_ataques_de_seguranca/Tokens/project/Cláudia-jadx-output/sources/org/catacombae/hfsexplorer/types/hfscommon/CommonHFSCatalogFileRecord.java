package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.hfs.CatKeyRec;
import org.catacombae.hfsexplorer.types.hfs.CdrFilRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFile;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileRecord.class */
public abstract class CommonHFSCatalogFileRecord extends CommonHFSCatalogLeafRecord {
    protected CommonHFSCatalogKey key;
    protected CommonHFSCatalogFile data;

    private CommonHFSCatalogFileRecord(CommonHFSCatalogKey key, CommonHFSCatalogFile data) {
        this.key = key;
        this.data = data;
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord
    public CommonHFSCatalogKey getKey() {
        return this.key;
    }

    public CommonHFSCatalogFile getData() {
        return this.data;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogFileRecord.class.getSimpleName() + ":");
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
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CommonHFSCatalogFileRecord.class.getSimpleName(), "File record");
        db.add("key", this.key.getStructElements(), "Catalog key");
        db.add("data", this.data.getStructElements(), "File data");
        return db.getResult();
    }

    public static CommonHFSCatalogFileRecord create(HFSPlusCatalogKey key, HFSPlusCatalogFile data) {
        return new HFSPlusImplementation(key, data);
    }

    public static CommonHFSCatalogFileRecord create(CatKeyRec key, CdrFilRec data) {
        return new HFSImplementation(key, data);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileRecord$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileRecord$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogFileRecord {
        public HFSImplementation(CatKeyRec key, CdrFilRec data) {
            super(CommonHFSCatalogKey.create(key), CommonHFSCatalogFile.create(data));
        }

        protected HFSImplementation(CommonHFSCatalogKey key, CommonHFSCatalogFile data) {
            super(key, data);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            return this.key.occupiedSize() + this.data.size();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public byte[] getBytes() {
            byte[] result = new byte[getSize()];
            byte[] tempData = this.key.getBytes();
            System.arraycopy(tempData, 0, result, 0, tempData.length);
            int offset = 0 + tempData.length;
            byte[] tempData2 = this.data.getBytes();
            System.arraycopy(tempData2, 0, result, offset, tempData2.length);
            int length = offset + tempData2.length;
            return result;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileRecord$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileRecord$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends HFSImplementation {
        public HFSPlusImplementation(HFSPlusCatalogKey key, HFSPlusCatalogFile data) {
            super(CommonHFSCatalogKey.create(key), CommonHFSCatalogFile.create(data));
        }
    }
}
