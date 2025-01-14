package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/PartitionSystem.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/PartitionSystem.class */
public interface PartitionSystem {
    boolean isValid();

    int getPartitionCount();

    Partition getPartitionEntry(int i2);

    Partition[] getPartitionEntries();

    int getUsedPartitionCount();

    Partition[] getUsedPartitionEntries();

    String getLongName();

    String getShortName();

    void printFields(PrintStream printStream, String str);

    void print(PrintStream printStream, String str);
}
