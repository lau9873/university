package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.hfs.ExtDataRec;
import org.catacombae.hfsexplorer.types.hfs.ExtDescriptor;
import org.catacombae.hfsexplorer.types.hfs.ExtKeyRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentRecord;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafRecord.class */
public abstract class CommonHFSExtentLeafRecord extends CommonBTRecord implements StructElements {
    public abstract CommonHFSExtentKey getKey();

    public abstract CommonHFSExtentDescriptor[] getRecordData();

    public static CommonHFSExtentLeafRecord create(ExtKeyRec key, ExtDataRec recordData) {
        return new HFSImplementation(key, recordData);
    }

    public static CommonHFSExtentLeafRecord create(HFSPlusExtentKey key, HFSPlusExtentRecord recordData) {
        return new HFSPlusImplementation(key, recordData);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafRecord$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafRecord$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSExtentLeafRecord {
        private final ExtKeyRec key;
        private final ExtDataRec recordData;

        public HFSImplementation(ExtKeyRec key, ExtDataRec recordData) {
            this.key = key;
            this.recordData = recordData;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafRecord
        public CommonHFSExtentKey getKey() {
            return CommonHFSExtentKey.create(this.key);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafRecord
        public CommonHFSExtentDescriptor[] getRecordData() {
            ExtDescriptor[] extDescs = this.recordData.getExtDataRecs();
            CommonHFSExtentDescriptor[] res = new CommonHFSExtentDescriptor[extDescs.length];
            for (int i2 = 0; i2 < res.length; i2++) {
                res[i2] = CommonHFSExtentDescriptor.create(extDescs[i2]);
            }
            return res;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            ExtKeyRec extKeyRec = this.key;
            int length = ExtKeyRec.length();
            ExtDataRec extDataRec = this.recordData;
            return length + ExtDataRec.length();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public byte[] getBytes() {
            byte[] res = new byte[getSize()];
            byte[] tempArray = this.key.getBytes();
            System.arraycopy(tempArray, 0, res, 0, tempArray.length);
            int i2 = 0 + tempArray.length;
            byte[] tempArray2 = this.recordData.getBytes();
            System.arraycopy(tempArray2, 0, res, 0, tempArray2.length);
            if (i2 + tempArray2.length != res.length) {
                throw new RuntimeException("Internal error. See stacktrace.");
            }
            return res;
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "key:");
            this.key.print(ps, prefix + " ");
            ps.println(prefix + "recordData:");
            this.recordData.print(ps, prefix + " ");
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder("CommonHFSExtentLeafRecord.HFSImplementation", "HFS extents overflow file leaf record");
            db.add("key", this.key.getStructElements(), "Key");
            db.add("recordData", this.recordData.getStructElements(), "Record data");
            return db.getResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafRecord$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentLeafRecord$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSExtentLeafRecord {
        private final HFSPlusExtentKey key;
        private final HFSPlusExtentRecord recordData;

        public HFSPlusImplementation(HFSPlusExtentKey key, HFSPlusExtentRecord recordData) {
            this.key = key;
            this.recordData = recordData;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafRecord
        public CommonHFSExtentKey getKey() {
            return CommonHFSExtentKey.create(this.key);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafRecord
        public CommonHFSExtentDescriptor[] getRecordData() {
            HFSPlusExtentDescriptor[] extDescs = this.recordData.getExtentDescriptors();
            CommonHFSExtentDescriptor[] res = new CommonHFSExtentDescriptor[extDescs.length];
            for (int i2 = 0; i2 < res.length; i2++) {
                res[i2] = CommonHFSExtentDescriptor.create(extDescs[i2]);
            }
            return res;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            return this.key.length() + this.recordData.length();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public byte[] getBytes() {
            byte[] res = new byte[getSize()];
            byte[] tempArray = this.key.getBytes();
            System.arraycopy(tempArray, 0, res, 0, tempArray.length);
            int i2 = 0 + tempArray.length;
            byte[] tempArray2 = this.recordData.getBytes();
            System.arraycopy(tempArray2, 0, res, 0, tempArray2.length);
            if (i2 + tempArray2.length != res.length) {
                throw new RuntimeException("Internal error. See stacktrace.");
            }
            return res;
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "key:");
            this.key.print(ps, prefix + " ");
            ps.println(prefix + "recordData:");
            this.recordData.print(ps, prefix + " ");
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder("CommonHFSExtentLeafRecord.HFSPlusImplementation", "HFS+ extents overflow file leaf record");
            db.add("key", this.key.getStructElements(), "Key");
            db.add("recordData", this.recordData.getStructElements(), "Record data");
            return db.getResult();
        }
    }
}
