package org.catacombae.hfsexplorer;

import org.catacombae.hfsexplorer.partitioning.ApplePartitionMap;
import org.catacombae.hfsexplorer.partitioning.DriverDescriptorRecord;
import org.catacombae.hfsexplorer.partitioning.GPTHeader;
import org.catacombae.hfsexplorer.partitioning.GUIDPartitionTable;
import org.catacombae.hfsexplorer.partitioning.MBRPartitionTable;
import org.catacombae.hfsexplorer.partitioning.PartitionSystem;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/PartitionSystemRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/PartitionSystemRecognizer.class */
public class PartitionSystemRecognizer {
    private ReadableRandomAccessStream bitstream;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/PartitionSystemRecognizer$PartitionSystemType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/PartitionSystemRecognizer$PartitionSystemType.class */
    public enum PartitionSystemType {
        APPLE_PARTITION_MAP,
        MASTER_BOOT_RECORD,
        GUID_PARTITION_TABLE,
        NONE_FOUND
    }

    public PartitionSystemRecognizer(ReadableRandomAccessStream bitstream) {
        this.bitstream = bitstream;
    }

    public PartitionSystemType detectPartitionSystem() {
        byte[] piece1;
        byte[] piece2;
        try {
            try {
                this.bitstream.seek(0L);
                piece1 = new byte[512];
                this.bitstream.readFully(piece1);
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            piece1 = null;
        }
        try {
            this.bitstream.seek(512L);
            piece2 = new byte[512];
            this.bitstream.readFully(piece2);
        } catch (Exception e4) {
            piece2 = null;
        }
        if (piece1 != null) {
            try {
                DriverDescriptorRecord ddr = new DriverDescriptorRecord(piece1, 0);
                if (ddr.isValid()) {
                    int blockSize = Util.unsign(ddr.getSbBlkSize());
                    ApplePartitionMap apm = new ApplePartitionMap(this.bitstream, blockSize * 1, blockSize);
                    if (apm.getUsedPartitionCount() > 0) {
                        return PartitionSystemType.APPLE_PARTITION_MAP;
                    }
                }
            } catch (Exception e5) {
            }
        }
        if (piece2 != null) {
            try {
                GPTHeader gh = new GPTHeader(piece2, 0, 512);
                if (gh.isValid()) {
                    return PartitionSystemType.GUID_PARTITION_TABLE;
                }
            } catch (Exception e6) {
            }
        }
        if (piece1 != null) {
            try {
                MBRPartitionTable mpt = new MBRPartitionTable(piece1, 0);
                if (mpt.isValid()) {
                    return PartitionSystemType.MASTER_BOOT_RECORD;
                }
            } catch (Exception e7) {
            }
        }
        return PartitionSystemType.NONE_FOUND;
    }

    public PartitionSystem getPartitionSystem() {
        PartitionSystemType type = detectPartitionSystem();
        switch (type) {
            case APPLE_PARTITION_MAP:
                byte[] ddrData = new byte[512];
                this.bitstream.seek(0L);
                this.bitstream.readFully(ddrData);
                DriverDescriptorRecord ddr = new DriverDescriptorRecord(ddrData, 0);
                int blockSize = Util.unsign(ddr.getSbBlkSize());
                return new ApplePartitionMap(this.bitstream, blockSize * 1, blockSize);
            case GUID_PARTITION_TABLE:
                return new GUIDPartitionTable(this.bitstream, 0);
            case MASTER_BOOT_RECORD:
                return new MBRPartitionTable(this.bitstream, 0);
            default:
                return null;
        }
    }
}
