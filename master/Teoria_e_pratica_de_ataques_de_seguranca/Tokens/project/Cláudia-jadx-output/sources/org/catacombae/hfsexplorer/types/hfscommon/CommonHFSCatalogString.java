package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfsplus.HFSUniStr255;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogString.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogString.class */
public abstract class CommonHFSCatalogString {
    public abstract byte[] getStringBytes();

    public abstract byte[] getStructBytes();

    public static CommonHFSCatalogString createHFSPlus(HFSUniStr255 nodeName) {
        return new HFSPlusImplementation(nodeName);
    }

    public static CommonHFSCatalogString createHFS(byte[] ckrCName) {
        return new HFSImplementation(ckrCName);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogString$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogString$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSCatalogString {
        private HFSUniStr255 nodeName;

        private HFSPlusImplementation(HFSUniStr255 nodeName) {
            this.nodeName = nodeName;
        }

        public HFSUniStr255 getInternal() {
            return this.nodeName;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogString
        public byte[] getStringBytes() {
            return this.nodeName.getRawUnicode();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogString
        public byte[] getStructBytes() {
            return this.nodeName.getBytes();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogString$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogString$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogString {
        private final byte[] ckrCName;

        private HFSImplementation(byte[] ckrCName) {
            this.ckrCName = ckrCName;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogString
        public byte[] getStringBytes() {
            return Util.createCopy(this.ckrCName);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogString
        public byte[] getStructBytes() {
            return Util.createCopy(this.ckrCName);
        }
    }
}
