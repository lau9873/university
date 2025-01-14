package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.hfs.CdrFThdRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogThread;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileThread.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileThread.class */
public abstract class CommonHFSCatalogFileThread implements PrintableStruct, StructElements {
    public abstract CommonHFSCatalogNodeID getParentID();

    public abstract CommonHFSCatalogString getNodeName();

    public abstract int length();

    public abstract byte[] getBytes();

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogFileThread.class.getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    public static CommonHFSCatalogFileThread create(HFSPlusCatalogThread data) {
        return new HFSPlusImplementation(data);
    }

    public static CommonHFSCatalogFileThread create(CdrFThdRec data) {
        return new HFSImplementation(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileThread$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileThread$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSCatalogFileThread {
        private final HFSPlusCatalogThread data;

        public HFSPlusImplementation(HFSPlusCatalogThread data) {
            this.data = data;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThread
        public int length() {
            return this.data.length();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThread
        public CommonHFSCatalogNodeID getParentID() {
            return CommonHFSCatalogNodeID.create(this.data.getParentID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThread
        public CommonHFSCatalogString getNodeName() {
            return CommonHFSCatalogString.createHFSPlus(this.data.getNodeName());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThread
        public byte[] getBytes() {
            return this.data.getBytes();
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "data:");
            this.data.print(ps, prefix + " ");
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.data.getStructElements();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileThread$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFileThread$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogFileThread {
        private final CdrFThdRec data;

        public HFSImplementation(CdrFThdRec data) {
            this.data = data;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThread
        public int length() {
            CdrFThdRec cdrFThdRec = this.data;
            return CdrFThdRec.length();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThread
        public CommonHFSCatalogNodeID getParentID() {
            return CommonHFSCatalogNodeID.create(this.data.getFthdParID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThread
        public CommonHFSCatalogString getNodeName() {
            return CommonHFSCatalogString.createHFS(this.data.getFthdCName());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThread
        public byte[] getBytes() {
            return this.data.getBytes();
        }

        @Override // org.catacombae.csjc.PrintableStruct
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + "data:");
            this.data.print(ps, prefix + " ");
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.data.getStructElements();
        }
    }
}
