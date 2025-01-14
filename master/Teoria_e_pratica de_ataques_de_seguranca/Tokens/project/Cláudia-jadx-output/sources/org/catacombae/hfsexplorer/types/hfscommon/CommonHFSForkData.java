package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.hfsexplorer.types.hfs.ExtDataRec;
import org.catacombae.hfsexplorer.types.hfs.ExtDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusForkData;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSForkData.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSForkData.class */
public abstract class CommonHFSForkData {
    public abstract long getLogicalSize();

    public abstract CommonHFSExtentDescriptor[] getBasicExtents();

    public static CommonHFSForkData create(ExtDataRec edr, long logicalSize) {
        return new HFSImplementation(edr, logicalSize);
    }

    public static CommonHFSForkData create(HFSPlusForkData hper) {
        return new HFSPlusImplementation(hper);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSForkData$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSForkData$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSForkData {
        private final ExtDataRec edr;
        private final long logicalSize;

        public HFSImplementation(ExtDataRec edr, long logicalSize) {
            this.edr = edr;
            this.logicalSize = logicalSize;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkData
        public long getLogicalSize() {
            return this.logicalSize;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkData
        public CommonHFSExtentDescriptor[] getBasicExtents() {
            ExtDescriptor[] src = this.edr.getExtDataRecs();
            CommonHFSExtentDescriptor[] result = new CommonHFSExtentDescriptor[src.length];
            for (int i2 = 0; i2 < result.length; i2++) {
                result[i2] = CommonHFSExtentDescriptor.create(src[i2]);
            }
            return result;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSForkData$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSForkData$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSForkData {
        private final HFSPlusForkData hper;

        public HFSPlusImplementation(HFSPlusForkData hper) {
            this.hper = hper;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkData
        public long getLogicalSize() {
            return this.hper.getLogicalSize();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkData
        public CommonHFSExtentDescriptor[] getBasicExtents() {
            HFSPlusExtentDescriptor[] src = this.hper.getExtents().getExtentDescriptors();
            CommonHFSExtentDescriptor[] result = new CommonHFSExtentDescriptor[src.length];
            for (int i2 = 0; i2 < result.length; i2++) {
                result[i2] = CommonHFSExtentDescriptor.create(src[i2]);
            }
            return result;
        }
    }
}
