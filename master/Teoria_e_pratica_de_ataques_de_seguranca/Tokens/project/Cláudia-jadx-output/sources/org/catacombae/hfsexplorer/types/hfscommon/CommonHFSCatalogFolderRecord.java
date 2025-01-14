package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.hfs.CatKeyRec;
import org.catacombae.hfsexplorer.types.hfs.CdrDirRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFolder;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderRecord.class */
public abstract class CommonHFSCatalogFolderRecord extends CommonHFSCatalogLeafRecord {
    protected final CommonHFSCatalogKey key;
    protected final CommonHFSCatalogFolder data;

    protected CommonHFSCatalogFolderRecord(CommonHFSCatalogKey key, CommonHFSCatalogFolder data) {
        this.key = key;
        this.data = data;
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord
    public CommonHFSCatalogKey getKey() {
        return this.key;
    }

    public CommonHFSCatalogFolder getData() {
        return this.data;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogFolderRecord.class.getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + "key:");
        getKey().print(ps, prefix + " ");
        ps.println(prefix + "data:");
        getData().print(ps, prefix + " ");
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(CommonHFSCatalogFolderRecord.class.getSimpleName(), "Folder record");
        db.add("key", this.key.getStructElements(), "Catalog key");
        db.add("data", this.data.getStructElements(), "Folder data");
        return db.getResult();
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

    public static CommonHFSCatalogFolderRecord create(HFSPlusCatalogKey key, HFSPlusCatalogFolder data) {
        return new HFSPlusImplementation(key, data);
    }

    public static CommonHFSCatalogFolderRecord create(CatKeyRec key, CdrDirRec data) {
        return new HFSImplementation(key, data);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderRecord$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderRecord$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSCatalogFolderRecord {
        public HFSPlusImplementation(HFSPlusCatalogKey key, HFSPlusCatalogFolder data) {
            super(CommonHFSCatalogKey.create(key), CommonHFSCatalogFolder.create(data));
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            return this.key.occupiedSize() + this.data.length();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderRecord$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderRecord$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogFolderRecord {
        public HFSImplementation(CatKeyRec key, CdrDirRec data) {
            super(CommonHFSCatalogKey.create(key), CommonHFSCatalogFolder.create(data));
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            return this.key.occupiedSize() + this.data.length();
        }
    }
}
