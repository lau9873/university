package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.hfsexplorer.types.hfs.BTHdrRec;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderNode.class */
public abstract class CommonBTHeaderNode extends CommonBTNode<CommonBTRecord> {
    protected abstract CommonBTHeaderRecord createHeaderRecord(byte[] bArr, int i2, int i3);

    protected CommonBTHeaderNode(byte[] data, int offset, int nodeSize, CommonBTNode.FSType type) {
        super(data, offset, nodeSize, type);
        validate();
    }

    public static CommonBTHeaderNode createHFS(byte[] data, int offset, int nodeSize) {
        return new HFSImplementation(data, offset, nodeSize);
    }

    public static CommonBTHeaderNode createHFSPlus(byte[] data, int offset, int nodeSize) {
        return new HFSPlusImplementation(data, offset, nodeSize);
    }

    private void validate() throws IllegalArgumentException {
        if (this.ic.records.size() != 3) {
            throw new IllegalArgumentException("Illegal length of record array: " + this.ic.records.size() + " (expected 3)");
        }
        if (!(this.ic.records.get(0) instanceof CommonBTHeaderRecord)) {
            throw new IllegalArgumentException("Illegal record type at index 0: " + ((CommonBTRecord) this.ic.records.get(0)).getClass());
        }
        if (!(this.ic.records.get(1) instanceof CommonBTGenericDataRecord)) {
            throw new IllegalArgumentException("Illegal record type at index 0: " + ((CommonBTRecord) this.ic.records.get(1)).getClass());
        }
        if (!(this.ic.records.get(1) instanceof CommonBTGenericDataRecord)) {
            throw new IllegalArgumentException("Illegal record type at index 0: " + ((CommonBTRecord) this.ic.records.get(1)).getClass());
        }
    }

    public CommonBTHeaderRecord getHeaderRecord() {
        CommonBTRecord btr = (CommonBTRecord) this.ic.records.get(0);
        if (btr instanceof CommonBTHeaderRecord) {
            return (CommonBTHeaderRecord) btr;
        }
        throw new RuntimeException("Unexpected type at records[0]: " + btr.getClass());
    }

    public CommonBTGenericDataRecord getUserDataRecord() {
        CommonBTRecord btr = (CommonBTRecord) this.ic.records.get(1);
        if (btr instanceof CommonBTGenericDataRecord) {
            return (CommonBTGenericDataRecord) btr;
        }
        throw new RuntimeException("Unexpected type at records[1]: " + btr.getClass());
    }

    public CommonBTGenericDataRecord getBTreeMapRecord() {
        CommonBTRecord btr = (CommonBTRecord) this.ic.records.get(2);
        if (btr instanceof CommonBTGenericDataRecord) {
            return (CommonBTGenericDataRecord) btr;
        }
        throw new RuntimeException("Unexpected type at records[2]: " + btr.getClass());
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode
    protected CommonBTRecord createBTRecord(int recordNumber, byte[] data, int offset, int length) {
        switch (recordNumber) {
            case 0:
                return createHeaderRecord(data, offset, length);
            case 1:
            case 2:
                return new CommonBTGenericDataRecord(data, offset, length);
            default:
                throw new RuntimeException("Too many records for a header node!");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderNode$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderNode$HFSPlusImplementation.class */
    private static class HFSPlusImplementation extends CommonBTHeaderNode {
        public HFSPlusImplementation(byte[] data, int offset, int nodeSize) {
            super(data, offset, nodeSize, CommonBTNode.FSType.HFS_PLUS);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderNode
        protected CommonBTHeaderRecord createHeaderRecord(byte[] data, int offset, int length) {
            if (length != BTHeaderRec.length()) {
                throw new IllegalArgumentException("length (" + length + ") != BTHeaderRec.length() (" + BTHeaderRec.length() + ")");
            }
            BTHeaderRec bthr = new BTHeaderRec(data, offset);
            return CommonBTHeaderRecord.create(bthr);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderNode$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderNode$HFSImplementation.class */
    private static class HFSImplementation extends CommonBTHeaderNode {
        public HFSImplementation(byte[] data, int offset, int nodeSize) {
            super(data, offset, nodeSize, CommonBTNode.FSType.HFS);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderNode
        protected CommonBTHeaderRecord createHeaderRecord(byte[] data, int offset, int length) {
            if (length != BTHdrRec.length()) {
                throw new IllegalArgumentException("length (" + length + ") != BTHdrRec.length() (" + BTHdrRec.length() + ")");
            }
            BTHdrRec bthr = new BTHdrRec(data, offset);
            return CommonBTHeaderRecord.create(bthr);
        }
    }
}
