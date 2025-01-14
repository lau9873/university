package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.CatKeyRec;
import org.catacombae.hfsexplorer.types.hfsplus.BTKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogKey.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogKey.class */
public abstract class CommonHFSCatalogKey extends CommonBTKey<CommonHFSCatalogKey> implements StructElements {
    public abstract CommonHFSCatalogNodeID getParentID();

    public abstract CommonHFSCatalogString getNodeName();

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogKey.class.getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    public static CommonHFSCatalogKey create(HFSPlusCatalogKey key) {
        return new HFSPlusImplementation(key);
    }

    public static CommonHFSCatalogKey create(CatKeyRec key) {
        return new HFSImplementation(key);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogKey$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogKey$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSCatalogKey {
        private final HFSPlusCatalogKey key;

        public HFSPlusImplementation(HFSPlusCatalogKey key) {
            this.key = key;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogKey
        public CommonHFSCatalogNodeID getParentID() {
            return CommonHFSCatalogNodeID.create(this.key.getParentID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogKey
        public CommonHFSCatalogString getNodeName() {
            return CommonHFSCatalogString.createHFSPlus(this.key.getNodeName());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTKey, org.catacombae.csjc.AbstractStruct
        public byte[] getBytes() {
            return this.key.getBytes();
        }

        @Override // java.lang.Comparable
        public int compareTo(CommonHFSCatalogKey o) {
            if (o instanceof HFSPlusImplementation) {
                HFSPlusImplementation k = (HFSPlusImplementation) o;
                return this.key.compareTo((BTKey) k.key);
            }
            throw new RuntimeException("Can't compare a " + o.getClass() + " with a " + getClass());
        }

        @Override // org.catacombae.csjc.DynamicStruct
        public int maxSize() {
            return this.key.maxSize();
        }

        @Override // org.catacombae.csjc.DynamicStruct
        public int occupiedSize() {
            return this.key.occupiedSize();
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
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogKey$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogKey$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogKey {
        private final CatKeyRec key;

        public HFSImplementation(CatKeyRec key) {
            this.key = key;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogKey
        public CommonHFSCatalogNodeID getParentID() {
            return CommonHFSCatalogNodeID.create(this.key.getCkrParID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogKey
        public CommonHFSCatalogString getNodeName() {
            return CommonHFSCatalogString.createHFS(this.key.getCkrCName());
        }

        @Override // org.catacombae.csjc.DynamicStruct
        public int maxSize() {
            return this.key.maxSize();
        }

        @Override // org.catacombae.csjc.DynamicStruct
        public int occupiedSize() {
            return this.key.occupiedSize();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTKey, org.catacombae.csjc.AbstractStruct
        public byte[] getBytes() {
            return this.key.getBytes();
        }

        @Override // java.lang.Comparable
        public int compareTo(CommonHFSCatalogKey o) {
            if (o instanceof HFSImplementation) {
                HFSImplementation k = (HFSImplementation) o;
                long res = getParentID().toLong() - k.getParentID().toLong();
                if (res == 0) {
                    int res2 = Util.unsignedArrayCompareLex(this.key.getCkrCName(), k.key.getCkrCName());
                    if (res2 == 0) {
                        return 0;
                    }
                    if (res2 > 0) {
                        return 1;
                    }
                    return -1;
                } else if (res > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
            throw new RuntimeException("Can't compare a " + o.getClass() + " with a " + getClass());
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
    }
}
