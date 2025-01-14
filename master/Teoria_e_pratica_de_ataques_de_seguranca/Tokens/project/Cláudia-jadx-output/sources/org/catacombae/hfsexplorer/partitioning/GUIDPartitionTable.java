package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.zip.CRC32;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ArrayBuilder;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/GUIDPartitionTable.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/GUIDPartitionTable.class */
public class GUIDPartitionTable implements PartitionSystem, StructElements {
    private static final int BLOCK_SIZE = 512;
    protected GPTHeader header;
    protected GPTEntry[] entries;
    protected GPTEntry[] backupEntries;
    protected GPTHeader backupHeader;
    private final LinkedList<GPTEntry> tempList = new LinkedList<>();

    public GUIDPartitionTable(ReadableRandomAccessStream llf, int offset) {
        GPTHeader tBackupHeader;
        GPTEntry[] tBackupEntries;
        byte[] headerData = new byte[512];
        byte[] currentEntryData = new byte[128];
        llf.seek(offset + 512);
        llf.readFully(headerData);
        this.header = new GPTHeader(headerData, 0, 512);
        if (this.header.isValid()) {
            llf.seek(offset + (this.header.getPartitionEntryLBA() * 512));
            this.entries = new GPTEntry[this.header.getNumberOfPartitionEntries()];
            for (int i2 = 0; i2 < this.entries.length; i2++) {
                llf.readFully(currentEntryData);
                this.entries[i2] = new GPTEntry(currentEntryData, 0, 512);
            }
            try {
                llf.seek(offset + (512 * this.header.getBackupLBA()));
                llf.readFully(headerData);
                tBackupHeader = new GPTHeader(headerData, 0, 512);
                if (tBackupHeader.isValid()) {
                    llf.seek(offset + (tBackupHeader.getPartitionEntryLBA() * 512));
                    tBackupEntries = new GPTEntry[tBackupHeader.getNumberOfPartitionEntries()];
                    for (int i3 = 0; i3 < tBackupEntries.length; i3++) {
                        llf.readFully(currentEntryData);
                        tBackupEntries[i3] = new GPTEntry(currentEntryData, 0, 512);
                    }
                } else {
                    tBackupEntries = new GPTEntry[0];
                }
            } catch (Exception e2) {
                tBackupHeader = new GPTHeader(new byte[GPTHeader.getSize()], 0, 512);
                tBackupEntries = new GPTEntry[0];
            }
            this.backupHeader = tBackupHeader;
            this.backupEntries = tBackupEntries;
            return;
        }
        this.entries = new GPTEntry[0];
        this.backupHeader = new GPTHeader(new byte[GPTHeader.getSize()], 0, 512);
        this.backupEntries = new GPTEntry[0];
    }

    protected GUIDPartitionTable(GUIDPartitionTable source) {
        this.header = new GPTHeader(source.header);
        this.entries = new GPTEntry[source.entries.length];
        for (int i2 = 0; i2 < this.entries.length; i2++) {
            this.entries[i2] = new GPTEntry(source.entries[i2]);
        }
        this.backupHeader = new GPTHeader(source.backupHeader);
        this.backupEntries = new GPTEntry[source.backupEntries.length];
        for (int i3 = 0; i3 < this.backupEntries.length; i3++) {
            this.backupEntries[i3] = new GPTEntry(source.backupEntries[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GUIDPartitionTable(GPTHeader header, GPTHeader backupHeader, int numberOfPrimaryEntries, int numberOfBackupEntries) {
        this.header = header;
        this.backupHeader = backupHeader;
        this.entries = new GPTEntry[numberOfPrimaryEntries];
        this.backupEntries = new GPTEntry[numberOfBackupEntries];
    }

    public GPTHeader getHeader() {
        return this.header;
    }

    public GPTHeader getBackupHeader() {
        return this.backupHeader;
    }

    public GPTEntry getEntry(int index) {
        return this.entries[index];
    }

    public GPTEntry[] getEntries() {
        return (GPTEntry[]) Util.arrayCopy(this.entries, new GPTEntry[this.entries.length]);
    }

    public GPTEntry getBackupEntry(int index) {
        return this.backupEntries[index];
    }

    public GPTEntry[] getBackupEntries() {
        return (GPTEntry[]) Util.arrayCopy(this.backupEntries, new GPTEntry[this.backupEntries.length]);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getPartitionCount() {
        return this.entries.length;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public int getUsedPartitionCount() {
        int count = 0;
        GPTEntry[] arr$ = this.entries;
        for (GPTEntry ge : arr$) {
            if (ge.isUsed()) {
                count++;
            }
        }
        return count;
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition getPartitionEntry(int index) {
        return getEntry(index);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getPartitionEntries() {
        return getEntries();
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public Partition[] getUsedPartitionEntries() {
        this.tempList.clear();
        GPTEntry[] arr$ = this.entries;
        for (GPTEntry ge : arr$) {
            if (ge.isUsed()) {
                this.tempList.addLast(ge);
            }
        }
        return (Partition[]) this.tempList.toArray(new GPTEntry[this.tempList.size()]);
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public boolean isValid() {
        boolean primaryTableValid = this.header.isValid() && this.header.getCRC32Checksum() == calculatePrimaryHeaderChecksum() && this.header.getPartitionEntryArrayCRC32() == calculatePrimaryEntriesChecksum();
        boolean backupTableValid = this.backupHeader.isValid() && this.backupHeader.getCRC32Checksum() == calculateBackupHeaderChecksum() && this.backupHeader.getPartitionEntryArrayCRC32() == calculateBackupEntriesChecksum();
        boolean entryTablesEqual = true;
        if (this.backupEntries.length != this.entries.length) {
            entryTablesEqual = false;
        } else {
            int i2 = 0;
            while (true) {
                if (i2 >= this.entries.length) {
                    break;
                } else if (this.entries[i2].equals(this.backupEntries[i2])) {
                    i2++;
                } else {
                    entryTablesEqual = false;
                    break;
                }
            }
        }
        boolean validBackupHeader = this.header.isValidBackup(this.backupHeader) && this.backupHeader.isValidBackup(this.header);
        return primaryTableValid && backupTableValid && entryTablesEqual && validBackupHeader;
    }

    public int calculatePrimaryHeaderChecksum() {
        return this.header.calculateCRC32();
    }

    public int calculatePrimaryEntriesChecksum() {
        CRC32 checksum = new CRC32();
        GPTEntry[] arr$ = this.entries;
        for (GPTEntry entry : arr$) {
            checksum.update(entry.getBytes());
        }
        return (int) (checksum.getValue() & (-1));
    }

    public int calculateBackupHeaderChecksum() {
        return this.backupHeader.calculateCRC32();
    }

    public int calculateBackupEntriesChecksum() {
        CRC32 checksum = new CRC32();
        GPTEntry[] arr$ = this.backupEntries;
        for (GPTEntry entry : arr$) {
            checksum.update(entry.getBytes());
        }
        return (int) (checksum.getValue() & (-1));
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getLongName() {
        return "GUID Partition Table";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public String getShortName() {
        return "GPT";
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void printFields(PrintStream ps, String prefix) {
        printPrimaryFields(ps, prefix);
        printBackupFields(ps, prefix);
    }

    public void printPrimaryFields(PrintStream ps, String prefix) {
        ps.println(prefix + " header:");
        this.header.print(ps, prefix + "  ");
        for (int i2 = 0; i2 < this.entries.length; i2++) {
            if (this.entries[i2].isUsed()) {
                ps.println(prefix + " entries[" + i2 + "]:");
                this.entries[i2].print(ps, prefix + "  ");
            }
        }
    }

    public void printBackupFields(PrintStream ps, String prefix) {
        for (int i2 = 0; i2 < this.backupEntries.length; i2++) {
            if (this.backupEntries[i2].isUsed()) {
                ps.println(prefix + " backupEntries[" + i2 + "]:");
                this.backupEntries[i2].print(ps, prefix + "  ");
            }
        }
        ps.println(prefix + " backupHeader:");
        this.backupHeader.print(ps, prefix + "  ");
    }

    @Override // org.catacombae.hfsexplorer.partitioning.PartitionSystem
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "GUIDPartitionTable:");
        printFields(ps, prefix);
    }

    public long getPrimaryTableBytesOffset() {
        return 512L;
    }

    public long getBackupTableBytesOffset() {
        return this.backupHeader.getPartitionEntryLBA() * 512;
    }

    public byte[] getPrimaryTableBytes() {
        byte[] result = new byte[GPTHeader.getSize() + (GPTEntry.getSize() * this.entries.length)];
        byte[] headerData = this.header.getBytes();
        System.arraycopy(headerData, 0, result, 0, GPTHeader.getSize());
        int offset = 0 + GPTHeader.getSize();
        GPTEntry[] arr$ = this.entries;
        for (GPTEntry ge : arr$) {
            byte[] entryData = ge.getBytes();
            System.arraycopy(entryData, 0, result, offset, entryData.length);
            offset += GPTEntry.getSize();
        }
        return result;
    }

    public byte[] getBackupTableBytes() {
        int offset = 0;
        byte[] result = new byte[(GPTEntry.getSize() * this.entries.length) + GPTHeader.getSize()];
        GPTEntry[] arr$ = this.backupEntries;
        for (GPTEntry ge : arr$) {
            byte[] entryData = ge.getBytes();
            System.arraycopy(entryData, 0, result, offset, entryData.length);
            offset += GPTEntry.getSize();
        }
        byte[] headerData = this.backupHeader.getBytes();
        System.arraycopy(headerData, 0, result, offset, GPTHeader.getSize());
        int size = offset + GPTHeader.getSize();
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder dbStruct = new StructElements.DictionaryBuilder(getClass().getSimpleName());
        dbStruct.add("header", this.header.getStructElements());
        ArrayBuilder ab = new ArrayBuilder(GPTEntry.class.getSimpleName());
        for (int i2 = 0; i2 < this.entries.length; i2++) {
            GPTEntry ge = this.entries[i2];
            ab.add(ge.getStructElements());
        }
        dbStruct.add("entries", ab.getResult());
        dbStruct.add("backupHeader", this.backupHeader.getStructElements());
        ArrayBuilder ab2 = new ArrayBuilder(GPTEntry.class.getSimpleName());
        for (int i3 = 0; i3 < this.backupEntries.length; i3++) {
            GPTEntry ge2 = this.backupEntries[i3];
            ab2.add(ge2.getStructElements());
        }
        dbStruct.add("backupEntries", ab2.getResult());
        return dbStruct.getResult();
    }

    public boolean equals(Object obj) {
        if (obj instanceof GUIDPartitionTable) {
            GUIDPartitionTable gpt = (GUIDPartitionTable) obj;
            return Util.arraysEqual(getPrimaryTableBytes(), gpt.getPrimaryTableBytes()) && Util.arraysEqual(getBackupTableBytes(), gpt.getBackupTableBytes());
        }
        return false;
    }
}
