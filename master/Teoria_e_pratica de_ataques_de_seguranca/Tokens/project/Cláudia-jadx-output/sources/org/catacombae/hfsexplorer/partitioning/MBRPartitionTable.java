package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import java.util.LinkedList;
import org.catacombae.io.ReadableByteArrayStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.mbr.MBRPartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/MBRPartitionTable.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/MBRPartitionTable.class */
public class MBRPartitionTable implements PartitionSystem {
    public static final int DEFAULT_SECTOR_SIZE = 512;
    private final MasterBootRecord masterBootRecord;
    private final PartitionSystem[] embeddedPartitionSystems;

    public MBRPartitionTable(byte[] data, int offset) {
        this((ReadableRandomAccessStream) new ReadableByteArrayStream(data), offset, false);
    }

    public MBRPartitionTable(byte[] data, int offset, int sectorSize) {
        this(new ReadableByteArrayStream(data), offset, sectorSize, false);
    }

    public MBRPartitionTable(ReadableRandomAccessStream raf, int offset) {
        this(raf, offset, true);
    }

    public MBRPartitionTable(ReadableRandomAccessStream raf, int offset, boolean parseEmbeddedPartitionSystems) {
        this(raf, offset, 512, parseEmbeddedPartitionSystems);
    }

    public MBRPartitionTable(ReadableRandomAccessStream raf, int offset, int sectorSize) {
        this(raf, offset, sectorSize, true);
    }

    public MBRPartitionTable(ReadableRandomAccessStream raf, int offset, int sectorSize, boolean parseEmbeddedPartitionSystems) {
        byte[] block = new byte[sectorSize];
        raf.seek(offset);
        raf.readFully(block);
        this.masterBootRecord = new MasterBootRecord(block, 0, sectorSize);
        MBRPartition[] mbrPartitions = this.masterBootRecord.getPartitions();
        this.embeddedPartitionSystems = new PartitionSystem[mbrPartitions.length];
        for (int i2 = 0; i2 < mbrPartitions.length; i2++) {
            MBRPartition p = mbrPartitions[i2];
            PartitionSystem embeddedPS = null;
            if (parseEmbeddedPartitionSystems && (p.getPartitionTypeAsEnum() == MBRPartitionType.DOS_EXTENDED || p.getPartitionTypeAsEnum() == MBRPartitionType.DOS_EXTENDED_INT13HX)) {
                try {
                    embeddedPS = new DOSExtendedPartitionSystem(raf, p.getStartOffset(), p.getLength(), sectorSize);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.embeddedPartitionSystems[i2] = embeddedPS;
        }
    }

    public MasterBootRecord getMasterBootRecord() {
        return this.masterBootRecord;
    }

    public PartitionSystem[] getEmbeddedPartitionSystems() {
        PartitionSystem[] result = new PartitionSystem[this.embeddedPartitionSystems.length];
        System.arraycopy(this.embeddedPartitionSystems, 0, result, 0, result.length);
        return result;
    }

    public PartitionSystem getEmbeddedPartitionSystem(int index) {
        return this.embeddedPartitionSystems[index];
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public boolean isValid() {
        if (this.masterBootRecord.isValid()) {
            PartitionSystem[] arr$ = this.embeddedPartitionSystems;
            for (PartitionSystem ebr : arr$) {
                if (ebr != null && !ebr.isValid()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getPartitionCount() {
        int num = this.masterBootRecord.getPartitionCount();
        PartitionSystem[] arr$ = this.embeddedPartitionSystems;
        for (PartitionSystem ps : arr$) {
            if (ps != null) {
                num += ps.getPartitionCount();
            }
        }
        return num;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getUsedPartitionCount() {
        int num = this.masterBootRecord.getUsedPartitionCount();
        PartitionSystem[] arr$ = this.embeddedPartitionSystems;
        for (PartitionSystem ps : arr$) {
            if (ps != null) {
                num += ps.getUsedPartitionCount();
            }
        }
        return num;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getUsedPartitionEntries() {
        LinkedList<Partition> tempList = new LinkedList<>();
        Partition[] arr$ = this.masterBootRecord.getUsedPartitionEntries();
        for (Partition p : arr$) {
            tempList.addLast(p);
        }
        PartitionSystem[] arr$2 = this.embeddedPartitionSystems;
        for (PartitionSystem ps : arr$2) {
            if (ps != null) {
                Partition[] arr$3 = ps.getUsedPartitionEntries();
                for (Partition p2 : arr$3) {
                    tempList.addLast(p2);
                }
            }
        }
        return (Partition[]) tempList.toArray(new Partition[tempList.size()]);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition getPartitionEntry(int index) {
        if (index >= 0 && index < 4) {
            return this.masterBootRecord.getPartitionEntry(index);
        }
        if (index >= 4) {
            int curIndex = 4;
            PartitionSystem[] arr$ = this.embeddedPartitionSystems;
            for (PartitionSystem ps : arr$) {
                int psPartitions = ps.getPartitionCount();
                if (index < curIndex + psPartitions) {
                    return ps.getPartitionEntry(index - curIndex);
                }
                curIndex += psPartitions;
            }
        }
        throw new IllegalArgumentException("index out of bounds (index=" + index + ")");
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getPartitionEntries() {
        LinkedList<Partition> tempList = new LinkedList<>();
        Partition[] arr$ = this.masterBootRecord.getPartitionEntries();
        for (Partition p : arr$) {
            tempList.addLast(p);
        }
        PartitionSystem[] arr$2 = this.embeddedPartitionSystems;
        for (PartitionSystem ps : arr$2) {
            if (ps != null) {
                Partition[] arr$3 = ps.getPartitionEntries();
                for (Partition p2 : arr$3) {
                    tempList.addLast(p2);
                }
            }
        }
        return (Partition[]) tempList.toArray(new Partition[tempList.size()]);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getLongName() {
        return "Master Boot Record";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getShortName() {
        return "MBR";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " masterBootRecord:");
        this.masterBootRecord.print(ps, prefix + "  ");
        ps.println(prefix + " embeddedPartitionSystems:");
        for (int i2 = 0; i2 < this.embeddedPartitionSystems.length; i2++) {
            PartitionSystem partSys = this.embeddedPartitionSystems[i2];
            ps.print(prefix + "  [" + i2 + "]:");
            if (partSys == null) {
                ps.println(" null");
            } else {
                ps.println();
                partSys.print(ps, prefix + "   ");
            }
        }
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix);
    }
}
