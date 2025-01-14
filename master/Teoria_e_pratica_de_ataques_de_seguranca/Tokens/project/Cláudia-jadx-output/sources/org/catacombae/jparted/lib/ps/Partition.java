package org.catacombae.jparted.lib.ps;

import java.io.PrintStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/Partition.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/Partition.class */
public abstract class Partition {
    public abstract long getStartOffset();

    public abstract long getLength();

    public abstract PartitionType getType();

    public abstract void printFields(PrintStream printStream, String str);

    public abstract void print(PrintStream printStream, String str);
}
