package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.ExtKeyRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentKey.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentKey.class */
public abstract class CommonHFSExtentKey extends CommonBTKey<CommonHFSExtentKey> implements StructElements {
    public abstract int getForkType();

    public abstract CommonHFSCatalogNodeID getFileID();

    public abstract long getStartBlock();

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    public static CommonHFSExtentKey create(HFSPlusExtentKey key) {
        return new HFSPlusImplementation(key);
    }

    public static CommonHFSExtentKey create(ExtKeyRec key) {
        return new HFSImplementation(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int commonCompare(CommonHFSExtentKey k1, CommonHFSExtentKey k2) {
        int forkType1 = k1.getForkType();
        int forkType2 = k2.getForkType();
        if (forkType1 == forkType2) {
            long fileID1 = k1.getFileID().toLong();
            long fileID2 = k2.getFileID().toLong();
            if (fileID1 == fileID2) {
                long startBlock1 = k1.getStartBlock();
                long startBlock2 = k2.getStartBlock();
                if (startBlock1 == startBlock2) {
                    return 0;
                }
                if (startBlock1 < startBlock2) {
                    return -1;
                }
                return 1;
            } else if (fileID1 < fileID2) {
                return -1;
            } else {
                return 1;
            }
        } else if (forkType1 < forkType2) {
            return -1;
        } else {
            return 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentKey$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentKey$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSExtentKey {
        private final HFSPlusExtentKey key;

        public HFSPlusImplementation(HFSPlusExtentKey key) {
            this.key = key;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey
        public int getForkType() {
            return this.key.getUnsignedForkType();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey
        public CommonHFSCatalogNodeID getFileID() {
            return CommonHFSCatalogNodeID.create(this.key.getFileID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey
        public long getStartBlock() {
            return this.key.getUnsignedStartBlock();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTKey, org.catacombae.csjc.AbstractStruct
        public byte[] getBytes() {
            return this.key.getBytes();
        }

        @Override // org.catacombae.csjc.DynamicStruct
        public int maxSize() {
            return this.key.length();
        }

        @Override // org.catacombae.csjc.DynamicStruct
        public int occupiedSize() {
            return this.key.length();
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "key:");
            this.key.print(ps, prefix + " ");
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.key.getStructElements();
        }

        @Override // java.lang.Comparable
        public int compareTo(CommonHFSExtentKey o) {
            if (o instanceof HFSPlusImplementation) {
                return CommonHFSExtentKey.commonCompare(this, o);
            }
            if (o != null) {
                throw new RuntimeException("Can't compare a " + o.getClass() + " with a " + getClass());
            }
            throw new RuntimeException("o == null !!");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentKey$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentKey$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSExtentKey {
        private final ExtKeyRec key;

        public HFSImplementation(ExtKeyRec key) {
            this.key = key;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey
        public int getForkType() {
            return Util.unsign(this.key.getXkrFkType());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey
        public CommonHFSCatalogNodeID getFileID() {
            return CommonHFSCatalogNodeID.create(this.key.getXkrFNum());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey
        public long getStartBlock() {
            return Util.unsign(this.key.getXkrFABN());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTKey, org.catacombae.csjc.AbstractStruct
        public byte[] getBytes() {
            return this.key.getBytes();
        }

        @Override // org.catacombae.csjc.DynamicStruct
        public int maxSize() {
            ExtKeyRec extKeyRec = this.key;
            return ExtKeyRec.length();
        }

        @Override // org.catacombae.csjc.DynamicStruct
        public int occupiedSize() {
            ExtKeyRec extKeyRec = this.key;
            return ExtKeyRec.length();
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "key:");
            this.key.print(ps, prefix + " ");
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.key.getStructElements();
        }

        @Override // java.lang.Comparable
        public int compareTo(CommonHFSExtentKey o) {
            if (o instanceof HFSImplementation) {
                return CommonHFSExtentKey.commonCompare(this, o);
            }
            if (o != null) {
                throw new RuntimeException("Can't compare a " + o.getClass() + " with a " + getClass());
            }
            throw new RuntimeException("o == null !!");
        }
    }
}
