package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import java.util.Date;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.MasterDirectoryBlock;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusVolumeHeader;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSVolumeHeader.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSVolumeHeader.class */
public abstract class CommonHFSVolumeHeader implements StructElements {
    public abstract short getSignature();

    public abstract long getAllocationBlockStart();

    public abstract long getAllocationBlockSize();

    public abstract long getFileSystemEnd();

    public abstract long getTotalBlocks();

    public abstract long getFreeBlocks();

    public abstract Date getCreateDate();

    public abstract Date getModifyDate();

    public abstract Date getBackupDate();

    public abstract CommonHFSCatalogNodeID getNextCatalogNodeID();

    public abstract CommonHFSForkData getCatalogFile();

    public abstract CommonHFSForkData getExtentsOverflowFile();

    public abstract void print(PrintStream printStream, String str);

    public static CommonHFSVolumeHeader create(HFSPlusVolumeHeader hdr) {
        return new HFSPlusImplementation(hdr);
    }

    public static CommonHFSVolumeHeader create(MasterDirectoryBlock hdr) {
        return new HFSImplementation(hdr);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSVolumeHeader$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSVolumeHeader$HFSPlusImplementation.class */
    public static class HFSPlusImplementation extends CommonHFSVolumeHeader {
        private final HFSPlusVolumeHeader hdr;

        public HFSPlusImplementation(HFSPlusVolumeHeader hdr) {
            this.hdr = hdr;
        }

        @Deprecated
        public HFSPlusVolumeHeader getUnderlying() {
            return this.hdr;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public short getSignature() {
            return this.hdr.getSignature();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getAllocationBlockSize() {
            return Util.unsign(this.hdr.getBlockSize());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getTotalBlocks() {
            return Util.unsign(this.hdr.getTotalBlocks());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getFreeBlocks() {
            return Util.unsign(this.hdr.getFreeBlocks());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public Date getCreateDate() {
            return this.hdr.getCreateDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public Date getModifyDate() {
            return this.hdr.getModifyDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public Date getBackupDate() {
            return this.hdr.getBackupDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public CommonHFSCatalogNodeID getNextCatalogNodeID() {
            return CommonHFSCatalogNodeID.create(this.hdr.getNextCatalogID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public CommonHFSForkData getCatalogFile() {
            return CommonHFSForkData.create(this.hdr.getCatalogFile());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public CommonHFSForkData getExtentsOverflowFile() {
            return CommonHFSForkData.create(this.hdr.getExtentsFile());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public void print(PrintStream err, String prefix) {
            this.hdr.print(err, prefix);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getAllocationBlockStart() {
            return 0L;
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.hdr.getStructElements();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getFileSystemEnd() {
            return getTotalBlocks() * getAllocationBlockSize();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSVolumeHeader$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonHFSVolumeHeader$HFSImplementation.class */
    public static class HFSImplementation extends CommonHFSVolumeHeader {
        private final MasterDirectoryBlock hdr;

        public HFSImplementation(MasterDirectoryBlock hdr) {
            this.hdr = hdr;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public short getSignature() {
            return this.hdr.getDrSigWord();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getAllocationBlockSize() {
            return Util.unsign(this.hdr.getDrAlBlkSiz());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getTotalBlocks() {
            return Util.unsign(this.hdr.getDrNmAlBlks());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getFreeBlocks() {
            return Util.unsign(this.hdr.getDrFreeBks());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public Date getCreateDate() {
            return this.hdr.getDrCrDateAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public Date getModifyDate() {
            return this.hdr.getDrLsModAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public Date getBackupDate() {
            return this.hdr.getDrVolBkUpAsDate();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public CommonHFSCatalogNodeID getNextCatalogNodeID() {
            return CommonHFSCatalogNodeID.create(this.hdr.getDrNxtCNID());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public CommonHFSForkData getCatalogFile() {
            return CommonHFSForkData.create(this.hdr.getDrCTExtRec(), Util.unsign(this.hdr.getDrCTFlSize()));
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public CommonHFSForkData getExtentsOverflowFile() {
            return CommonHFSForkData.create(this.hdr.getDrXTExtRec(), Util.unsign(this.hdr.getDrXTFlSize()));
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public void print(PrintStream err, String prefix) {
            this.hdr.print(err, prefix);
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getAllocationBlockStart() {
            return Util.unsign(this.hdr.getDrAlBlSt());
        }

        @Override // org.catacombae.csjc.StructElements
        public Dictionary getStructElements() {
            return this.hdr.getStructElements();
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader
        public long getFileSystemEnd() {
            return (getAllocationBlockStart() * 512) + (getTotalBlocks() * getAllocationBlockSize()) + 1024;
        }
    }
}
