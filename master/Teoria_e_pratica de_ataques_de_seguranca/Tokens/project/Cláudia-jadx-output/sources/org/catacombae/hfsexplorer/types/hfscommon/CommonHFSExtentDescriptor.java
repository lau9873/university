package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.ExtDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentDescriptor;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentDescriptor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentDescriptor.class */
public abstract class CommonHFSExtentDescriptor implements StructElements {
    public abstract long getStartBlock();

    public abstract long getBlockCount();

    public abstract void print(PrintStream printStream, String str);

    public static CommonHFSExtentDescriptor create(HFSPlusExtentDescriptor hped) {
        return new HFSPlusImplementation(hped);
    }

    public static CommonHFSExtentDescriptor create(ExtDescriptor hped) {
        return new HFSImplementation(hped);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentDescriptor$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentDescriptor$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSExtentDescriptor {
        private final HFSPlusExtentDescriptor hped;

        public HFSPlusImplementation(HFSPlusExtentDescriptor hped) {
            this.hped = hped;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor
        public long getStartBlock() {
            return Util.unsign(this.hped.getStartBlock());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor
        public long getBlockCount() {
            return Util.unsign(this.hped.getBlockCount());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor
        public void print(PrintStream ps, String prefix) {
            this.hped.print(ps, prefix);
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.hped.getStructElements();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentDescriptor$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSExtentDescriptor$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSExtentDescriptor {
        private final ExtDescriptor hped;

        public HFSImplementation(ExtDescriptor hped) {
            this.hped = hped;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor
        public long getStartBlock() {
            return Util.unsign(this.hped.getXdrStABN());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor
        public long getBlockCount() {
            return Util.unsign(this.hped.getXdrNumABlks());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor
        public void print(PrintStream ps, String prefix) {
            this.hped.print(ps, prefix);
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.hped.getStructElements();
        }
    }
}
