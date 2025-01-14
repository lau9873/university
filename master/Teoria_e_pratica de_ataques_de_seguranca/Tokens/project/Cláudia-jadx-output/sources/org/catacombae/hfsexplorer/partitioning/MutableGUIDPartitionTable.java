package org.catacombae.hfsexplorer.partitioning;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableGUIDPartitionTable.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/MutableGUIDPartitionTable.class */
public class MutableGUIDPartitionTable extends GUIDPartitionTable {
    protected MutableGPTHeader mutableHeader;
    protected MutableGPTEntry[] mutableEntries;
    protected MutableGPTHeader mutableBackupHeader;
    protected MutableGPTEntry[] mutableBackupEntries;

    public MutableGUIDPartitionTable(GUIDPartitionTable source) {
        super(new MutableGPTHeader(source.header), new MutableGPTHeader(source.backupHeader), source.entries.length, source.backupEntries.length);
        this.mutableHeader = (MutableGPTHeader) this.header;
        this.mutableEntries = new MutableGPTEntry[source.entries.length];
        for (int i2 = 0; i2 < this.entries.length; i2++) {
            this.mutableEntries[i2] = new MutableGPTEntry(source.entries[i2]);
            this.entries[i2] = this.mutableEntries[i2];
        }
        this.mutableBackupHeader = (MutableGPTHeader) this.backupHeader;
        this.mutableBackupEntries = new MutableGPTEntry[source.backupEntries.length];
        for (int i3 = 0; i3 < this.backupEntries.length; i3++) {
            this.mutableBackupEntries[i3] = new MutableGPTEntry(source.backupEntries[i3]);
            this.backupEntries[i3] = this.mutableBackupEntries[i3];
        }
    }

    public MutableGPTHeader getMutablePrimaryHeader() {
        return this.mutableHeader;
    }

    public MutableGPTHeader getMutableBackupHeader() {
        return this.mutableBackupHeader;
    }

    public MutableGPTEntry getMutablePrimaryEntry(int index) {
        return this.mutableEntries[index];
    }

    public MutableGPTEntry getMutableBackupEntry(int index) {
        return this.mutableBackupEntries[index];
    }

    public MutableGPTEntry[] getMutablePrimaryEntries() {
        return this.mutableEntries;
    }

    public MutableGPTEntry[] getMutableBackupEntries() {
        return this.mutableBackupEntries;
    }

    public void setMutablePrimaryHeader(MutableGPTHeader mutableHeader) {
        this.mutableHeader = mutableHeader;
        this.header = mutableHeader;
    }

    public void setMutableBackupHeader(MutableGPTHeader mutableBackupHeader) {
        this.mutableBackupHeader = mutableBackupHeader;
        this.backupHeader = mutableBackupHeader;
    }

    public void setMutablePrimaryEntries(MutableGPTEntry[] mutableEntries) {
        this.mutableEntries = mutableEntries;
        this.entries = mutableEntries;
    }

    public void setMutableBackupEntries(MutableGPTEntry[] mutableBackupEntries) {
        this.mutableBackupEntries = mutableBackupEntries;
        this.backupEntries = mutableBackupEntries;
    }
}
