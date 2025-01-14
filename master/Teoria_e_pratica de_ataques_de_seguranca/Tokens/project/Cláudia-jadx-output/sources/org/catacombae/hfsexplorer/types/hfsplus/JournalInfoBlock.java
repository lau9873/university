package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/JournalInfoBlock.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/JournalInfoBlock.class */
public class JournalInfoBlock {
    public static final int kJIJournalInFSMask = 1;
    public static final int kJIJournalOnOtherDeviceMask = 2;
    public static final int kJIJournalNeedInitMask = 4;
    private final byte[] flags = new byte[4];
    private final byte[] deviceSignature = new byte[32];
    private final byte[] offset = new byte[8];
    private final byte[] size = new byte[8];
    private final byte[] reserved = new byte[128];

    public JournalInfoBlock(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.flags, 0, 4);
        System.arraycopy(data, offset + 4, this.deviceSignature, 0, 32);
        System.arraycopy(data, offset + 36, this.offset, 0, 8);
        System.arraycopy(data, offset + 44, this.size, 0, 8);
        System.arraycopy(data, offset + 52, this.reserved, 0, 128);
    }

    public static int length() {
        return 180;
    }

    public int getFlags() {
        return Util.readIntBE(this.flags);
    }

    public int[] getDeviceSignature() {
        return Util.readIntArrayBE(this.deviceSignature);
    }

    public long getOffset() {
        return Util.readLongBE(this.offset);
    }

    public long getSize() {
        return Util.readLongBE(this.size);
    }

    public int[] getReserved() {
        return Util.readIntArrayBE(this.reserved);
    }

    public static int getStructSize() {
        return 180;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " flags: " + getFlags());
        ps.println(prefix + " deviceSignature: " + getDeviceSignature());
        ps.println(prefix + " offset: " + getOffset());
        ps.println(prefix + " size: " + getSize());
        ps.println(prefix + " reserved: " + getReserved());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "JournalInfoBlock:");
        printFields(ps, prefix);
    }
}
