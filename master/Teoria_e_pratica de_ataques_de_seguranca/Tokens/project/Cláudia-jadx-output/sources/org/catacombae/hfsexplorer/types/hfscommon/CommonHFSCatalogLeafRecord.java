package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.csjc.StructElements;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.CatDataRec;
import org.catacombae.hfsexplorer.types.hfs.CatKeyRec;
import org.catacombae.hfsexplorer.types.hfs.CdrDirRec;
import org.catacombae.hfsexplorer.types.hfs.CdrFThdRec;
import org.catacombae.hfsexplorer.types.hfs.CdrFilRec;
import org.catacombae.hfsexplorer.types.hfs.CdrThdRec;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFile;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFolder;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecordData;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogThread;
import org.catacombae.hfsexplorer.types.hfsx.HFSXCatalogKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogLeafRecord.class */
public abstract class CommonHFSCatalogLeafRecord extends CommonBTRecord implements StructElements {
    public abstract CommonHFSCatalogKey getKey();

    public static CommonHFSCatalogLeafRecord createHFS(byte[] data, int offset, int length) {
        CatDataRec recordData;
        CatKeyRec key = new CatKeyRec(data, offset);
        int recordOffset = offset + key.occupiedSize();
        if (recordOffset % 2 != 0) {
            recordOffset++;
        }
        byte recordType = data[recordOffset];
        switch (recordType) {
            case 1:
                recordData = new CdrDirRec(data, recordOffset);
                break;
            case 2:
                recordData = new CdrFilRec(data, recordOffset);
                break;
            case 3:
                recordData = new CdrThdRec(data, recordOffset);
                break;
            case 4:
                recordData = new CdrFThdRec(data, recordOffset);
                break;
            default:
                System.err.println("key:");
                key.print(System.err, " ");
                System.err.println("data: " + Util.byteArrayToHexString(data, offset, length));
                throw new RuntimeException("Invalid HFS record type: " + ((int) recordType));
        }
        return create(key, recordData);
    }

    public static CommonHFSCatalogLeafRecord createHFSPlus(byte[] data, int offset, int length) {
        HFSPlusCatalogLeafRecordData recordData;
        HFSPlusCatalogKey key = new HFSPlusCatalogKey(data, offset);
        short recordType = Util.readShortBE(data, offset + key.length());
        switch (recordType) {
            case 1:
                recordData = new HFSPlusCatalogFolder(data, offset + key.length());
                break;
            case 2:
                recordData = new HFSPlusCatalogFile(data, offset + key.length());
                break;
            case 3:
            case 4:
                recordData = new HFSPlusCatalogThread(data, offset + key.length());
                break;
            default:
                throw new RuntimeException("Ivalid record type!");
        }
        return create(key, recordData);
    }

    public static CommonHFSCatalogLeafRecord createHFSX(byte[] data, int offset, int length, BTHeaderRec bthr) {
        HFSPlusCatalogLeafRecordData recordData;
        if (bthr == null) {
            throw new IllegalArgumentException("bthr == null");
        }
        HFSXCatalogKey key = new HFSXCatalogKey(data, offset, bthr);
        short recordType = Util.readShortBE(data, offset + key.length());
        switch (recordType) {
            case 1:
                recordData = new HFSPlusCatalogFolder(data, offset + key.length());
                break;
            case 2:
                recordData = new HFSPlusCatalogFile(data, offset + key.length());
                break;
            case 3:
            case 4:
                recordData = new HFSPlusCatalogThread(data, offset + key.length());
                break;
            default:
                throw new RuntimeException("Ivalid record type!");
        }
        return create(key, recordData);
    }

    public static CommonHFSCatalogLeafRecord create(HFSPlusCatalogKey key, HFSPlusCatalogLeafRecordData data) {
        if (data instanceof HFSPlusCatalogFolder) {
            return CommonHFSCatalogFolderRecord.create(key, (HFSPlusCatalogFolder) data);
        }
        if (data instanceof HFSPlusCatalogFile) {
            return CommonHFSCatalogFileRecord.create(key, (HFSPlusCatalogFile) data);
        }
        if (data instanceof HFSPlusCatalogThread) {
            if (data.getRecordType() == 4) {
                return CommonHFSCatalogFileThreadRecord.create(key, (HFSPlusCatalogThread) data);
            }
            if (data.getRecordType() == 3) {
                return CommonHFSCatalogFolderThreadRecord.create(key, (HFSPlusCatalogThread) data);
            }
            throw new RuntimeException("Unknown catalog thread type: " + ((int) data.getRecordType()));
        }
        throw new RuntimeException("Unknown type of HFSPlusCatalogLeafRecordData: " + data.getClass());
    }

    public static CommonHFSCatalogLeafRecord create(CatKeyRec key, CatDataRec data) {
        if (data instanceof CdrDirRec) {
            return CommonHFSCatalogFolderRecord.create(key, (CdrDirRec) data);
        }
        if (data instanceof CdrFilRec) {
            return CommonHFSCatalogFileRecord.create(key, (CdrFilRec) data);
        }
        if (data instanceof CdrFThdRec) {
            return CommonHFSCatalogFileThreadRecord.create(key, (CdrFThdRec) data);
        }
        if (data instanceof CdrThdRec) {
            return CommonHFSCatalogFolderThreadRecord.create(key, (CdrThdRec) data);
        }
        throw new RuntimeException("Unknown type of CatDataRec: " + data.getClass());
    }
}
