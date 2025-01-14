package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.BTHdrRec;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderRecord.class */
public abstract class CommonBTHeaderRecord extends CommonBTRecord implements PrintableStruct {

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderRecord$CompareType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderRecord$CompareType.class */
    public enum CompareType {
        CASE_FOLDING,
        BINARY_COMPARE
    }

    public abstract int getTreeDepth();

    public abstract long getRootNodeNumber();

    public abstract long getNumberOfLeafRecords();

    public abstract long getFirstLeafNodeNumber();

    public abstract long getLastLeafNodeNumber();

    public abstract int getNodeSize();

    public abstract int getMaximumKeyLength();

    public abstract long getTotalNodes();

    public abstract long getFreeNodes();

    public abstract CompareType getKeyCompareType();

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
    public abstract byte[] getBytes();

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    public static CommonBTHeaderRecord create(BTHeaderRec bthr) {
        return new HFSPlusImplementation(bthr);
    }

    public static CommonBTHeaderRecord create(BTHdrRec bthr) {
        return new HFSImplementation(bthr);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderRecord$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderRecord$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonBTHeaderRecord {
        private BTHeaderRec bthr;

        public HFSPlusImplementation(BTHeaderRec bthr) {
            this.bthr = bthr;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public int getTreeDepth() {
            return Util.unsign(this.bthr.getTreeDepth());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getRootNodeNumber() {
            return Util.unsign(this.bthr.getRootNode());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getNumberOfLeafRecords() {
            return Util.unsign(this.bthr.getLeafRecords());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getFirstLeafNodeNumber() {
            return Util.unsign(this.bthr.getFirstLeafNode());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getLastLeafNodeNumber() {
            return Util.unsign(this.bthr.getLastLeafNode());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public int getNodeSize() {
            return Util.unsign(this.bthr.getNodeSize());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public int getMaximumKeyLength() {
            return Util.unsign(this.bthr.getMaxKeyLength());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getTotalNodes() {
            return Util.unsign(this.bthr.getTotalNodes());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getFreeNodes() {
            return Util.unsign(this.bthr.getFreeNodes());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public CompareType getKeyCompareType() {
            if (this.bthr.getKeyCompareType() == -68) {
                return CompareType.BINARY_COMPARE;
            }
            if (this.bthr.getKeyCompareType() == -49) {
                return CompareType.CASE_FOLDING;
            }
            throw new RuntimeException("Unknown key compare type!");
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord, org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public byte[] getBytes() {
            return this.bthr.getBytes();
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "bthr:");
            this.bthr.print(ps, prefix + " ");
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            BTHeaderRec bTHeaderRec = this.bthr;
            return BTHeaderRec.length();
        }

        public BTHeaderRec getInternal() {
            return this.bthr;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderRecord$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTHeaderRecord$HFSImplementation.class */
    public static class HFSImplementation extends CommonBTHeaderRecord {
        private BTHdrRec bthr;

        public HFSImplementation(BTHdrRec bthr) {
            this.bthr = bthr;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public int getTreeDepth() {
            return Util.unsign(this.bthr.getBthDepth());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getRootNodeNumber() {
            return Util.unsign(this.bthr.getBthRoot());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getNumberOfLeafRecords() {
            return Util.unsign(this.bthr.getBthNRecs());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getFirstLeafNodeNumber() {
            return Util.unsign(this.bthr.getBthFNode());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getLastLeafNodeNumber() {
            return Util.unsign(this.bthr.getBthLNode());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public int getNodeSize() {
            return Util.unsign(this.bthr.getBthNodeSize());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public int getMaximumKeyLength() {
            return Util.unsign(this.bthr.getBthKeyLen());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getTotalNodes() {
            return Util.unsign(this.bthr.getBthNNodes());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public long getFreeNodes() {
            return Util.unsign(this.bthr.getBthFree());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord
        public CompareType getKeyCompareType() {
            return CompareType.BINARY_COMPARE;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTHeaderRecord, org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public byte[] getBytes() {
            return this.bthr.getBytes();
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "bthr:");
            this.bthr.print(ps, prefix + " ");
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
        public int getSize() {
            BTHdrRec bTHdrRec = this.bthr;
            return BTHdrRec.length();
        }
    }
}
