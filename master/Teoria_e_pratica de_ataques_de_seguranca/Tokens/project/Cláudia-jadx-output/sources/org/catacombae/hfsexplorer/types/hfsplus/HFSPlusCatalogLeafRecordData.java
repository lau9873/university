package org.catacombae.hfsexplorer.types.hfsplus;

import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogLeafRecordData.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusCatalogLeafRecordData.class */
public abstract class HFSPlusCatalogLeafRecordData implements PrintableStruct, StructElements {
    public static final int RECORD_TYPE_FOLDER = 1;
    public static final int RECORD_TYPE_FILE = 2;
    public static final int RECORD_TYPE_FOLDER_THREAD = 3;
    public static final int RECORD_TYPE_FILE_THREAD = 4;

    public abstract short getRecordType();

    public String getRecordTypeAsString() {
        int recordType = Util.unsign(getRecordType());
        return recordType == 1 ? "kHFSPlusFolderRecord" : recordType == 2 ? "kHFSPlusFileRecord" : recordType == 3 ? "kHFSPlusFolderThreadRecord" : recordType == 4 ? "kHFSPlusFileThreadRecord" : "UNKNOWN!";
    }
}
