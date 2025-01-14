package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import java.util.LinkedList;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.ebr.ExtendedBootRecord;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/DOSExtendedPartitionSystem.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/DOSExtendedPartitionSystem.class */
public class DOSExtendedPartitionSystem implements PartitionSystem {
    private final ExtendedBootRecord[] extendedBootRecords;

    public DOSExtendedPartitionSystem(ReadableRandomAccessStream llf, long extendedPartitionOffset, long extendedPartitionLength, int sectorSize) {
        LinkedList<ExtendedBootRecord> recordList = new LinkedList<>();
        byte[] block = new byte[sectorSize];
        if (extendedPartitionOffset > extendedPartitionOffset + extendedPartitionLength) {
            throw new RuntimeException("Invalid DOS Extended partition system (seekLocation=" + extendedPartitionOffset + ").");
        }
        llf.seek(extendedPartitionOffset);
        llf.readFully(block);
        ExtendedBootRecord ebr = new ExtendedBootRecord(block, 0, extendedPartitionOffset, extendedPartitionOffset, sectorSize);
        recordList.addLast(ebr);
        while (true) {
            if (ebr.getSecondEntry().getLBAPartitionLength() != 0 || ebr.getSecondEntry().getLBAFirstSector() != 0) {
                long seekLocation = ebr.getSecondEntry().getStartOffset();
                if (seekLocation > extendedPartitionOffset + extendedPartitionLength) {
                    throw new RuntimeException("Invalid DOS Extended partition system (seekLocation=" + seekLocation + ").");
                }
                llf.seek(seekLocation);
                llf.readFully(block);
                ebr = new ExtendedBootRecord(block, 0, extendedPartitionOffset, seekLocation, sectorSize);
                recordList.addLast(ebr);
            } else {
                this.extendedBootRecords = (ExtendedBootRecord[]) recordList.toArray(new ExtendedBootRecord[recordList.size()]);
                return;
            }
        }
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public boolean isValid() {
        ExtendedBootRecord[] arr$ = this.extendedBootRecords;
        for (ExtendedBootRecord ebr : arr$) {
            if (!ebr.isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getPartitionCount() {
        return this.extendedBootRecords.length;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getUsedPartitionCount() {
        return getPartitionCount();
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition getPartitionEntry(int index) {
        return this.extendedBootRecords[index].getFirstEntry();
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getPartitionEntries() {
        Partition[] result = new Partition[this.extendedBootRecords.length];
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = this.extendedBootRecords[i2].getFirstEntry();
        }
        return result;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getUsedPartitionEntries() {
        return getPartitionEntries();
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getLongName() {
        return "DOS Extended";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getShortName() {
        return "EBR";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " extendedBootRecords:");
        for (int i2 = 0; i2 < this.extendedBootRecords.length; i2++) {
            ps.println(prefix + "  [" + i2 + "]:");
            this.extendedBootRecords[i2].print(ps, prefix + "   ");
        }
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + getClass().getSimpleName() + ":");
        printFields(ps, prefix);
    }
}
