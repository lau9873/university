package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.hfs.CdrThdRec;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogThread;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderThread.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderThread.class */
public abstract class CommonHFSCatalogFolderThread implements PrintableStruct, StructElements {
    public abstract CommonHFSCatalogNodeID getParentID();

    public abstract CommonHFSCatalogString getNodeName();

    public abstract int length();

    public abstract byte[] getBytes();

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + CommonHFSCatalogFolderThread.class.getSimpleName() + ":");
        printFields(ps, prefix + " ");
    }

    public static CommonHFSCatalogFolderThread create(HFSPlusCatalogThread data) {
        return new HFSPlusImplementation(data);
    }

    public static CommonHFSCatalogFolderThread create(CdrThdRec data) {
        return new HFSImplementation(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderThread$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderThread$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSCatalogFolderThread {
        private final HFSPlusCatalogThread data;

        public HFSPlusImplementation(HFSPlusCatalogThread data) {
            this.data = data;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread
        public CommonHFSCatalogNodeID getParentID() {
            return CommonHFSCatalogNodeID.create(this.data.getParentID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread
        public CommonHFSCatalogString getNodeName() {
            return CommonHFSCatalogString.createHFSPlus(this.data.getNodeName());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread
        public int length() {
            return this.data.length();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread
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
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderThread$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSCatalogFolderThread$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSCatalogFolderThread {
        private final CdrThdRec data;

        public HFSImplementation(CdrThdRec data) {
            this.data = data;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread
        public CommonHFSCatalogNodeID getParentID() {
            return CommonHFSCatalogNodeID.create(this.data.getThdParID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread
        public CommonHFSCatalogString getNodeName() {
            return CommonHFSCatalogString.createHFS(this.data.getThdCName());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread
        public int length() {
            CdrThdRec cdrThdRec = this.data;
            return CdrThdRec.length();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread
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
