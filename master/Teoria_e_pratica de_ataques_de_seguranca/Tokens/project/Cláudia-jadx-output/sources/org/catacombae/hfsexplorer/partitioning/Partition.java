package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.jparted.lib.ps.PartitionType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/Partition.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/Partition.class */
public interface Partition {
    long getStartOffset();

    long getLength();

    PartitionType getType();

    void printFields(PrintStream printStream, String str);

    void print(PrintStream printStream, String str);
}
