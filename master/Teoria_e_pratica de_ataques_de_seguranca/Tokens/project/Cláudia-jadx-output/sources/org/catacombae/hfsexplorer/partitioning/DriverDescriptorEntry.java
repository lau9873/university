package org.catacombae.hfsexplorer.partitioning;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/partitioning/DriverDescriptorEntry.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/partitioning/DriverDescriptorEntry.class */
public class DriverDescriptorEntry {
    private final byte[] ddBlock = new byte[4];
    private final byte[] ddSize = new byte[2];
    private final byte[] ddType = new byte[2];

    public DriverDescriptorEntry(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.ddBlock, 0, 4);
        System.arraycopy(data, offset + 4, this.ddSize, 0, 2);
        System.arraycopy(data, offset + 6, this.ddType, 0, 2);
    }

    public static int length() {
        return 8;
    }

    public int getDdBlock() {
        return Util.readIntBE(this.ddBlock);
    }

    public short getDdSize() {
        return Util.readShortBE(this.ddSize);
    }

    public short getDdType() {
        return Util.readShortBE(this.ddType);
    }

    public byte[] getData() {
        byte[] result = new byte[length()];
        System.arraycopy(this.ddBlock, 0, result, 0, this.ddBlock.length);
        int offset = 0 + this.ddBlock.length;
        System.arraycopy(this.ddSize, 0, result, offset, this.ddSize.length);
        int offset2 = offset + this.ddSize.length;
        System.arraycopy(this.ddType, 0, result, offset2, this.ddType.length);
        if (offset2 + this.ddType.length != length()) {
            throw new RuntimeException("Internal miscalculation...");
        }
        return result;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " ddBlock: " + getDdBlock());
        ps.println(prefix + " ddSize: " + ((int) getDdSize()));
        ps.println(prefix + " ddType: " + ((int) getDdType()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "DriverDescriptorEntry:");
        printFields(ps, prefix);
    }
}
