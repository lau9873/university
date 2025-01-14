package org.catacombae.hfsexplorer.types.applesingle;

import java.io.PrintStream;
import org.catacombae.util.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/applesingle/EntryDescriptor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/applesingle/EntryDescriptor.class */
public class EntryDescriptor {
    public static final int STRUCTSIZE = 12;
    private static final long MAX_UINT = 4294967295L;
    private final byte[] entryId;
    private final byte[] entryOffset;
    private final byte[] entryLength;

    public EntryDescriptor(byte[] data, int offset) {
        this.entryId = new byte[4];
        this.entryOffset = new byte[4];
        this.entryLength = new byte[4];
        System.arraycopy(data, offset + 0, this.entryId, 0, 4);
        System.arraycopy(data, offset + 4, this.entryOffset, 0, 4);
        System.arraycopy(data, offset + 8, this.entryLength, 0, 4);
    }

    public EntryDescriptor(long entryId, long entryOffset, long entryLength) {
        this.entryId = new byte[4];
        this.entryOffset = new byte[4];
        this.entryLength = new byte[4];
        if (entryId < 0 || entryId > 4294967295L) {
            throw new IllegalArgumentException("Illegal value for entryId (" + entryId + ")");
        }
        if (entryOffset < 0 || entryOffset > 4294967295L) {
            throw new IllegalArgumentException("Illegal value for entryOffset (" + entryOffset + ")");
        }
        if (entryLength < 0 || entryLength > 4294967295L) {
            throw new IllegalArgumentException("Illegal value for entryLength (" + entryLength + ")");
        }
        System.arraycopy(Util.toByteArrayBE((int) entryId), 0, this.entryId, 0, 4);
        System.arraycopy(Util.toByteArrayBE((int) entryOffset), 0, this.entryOffset, 0, 4);
        System.arraycopy(Util.toByteArrayBE((int) entryLength), 0, this.entryLength, 0, 4);
    }

    public static int length() {
        return 12;
    }

    public int getEntryId() {
        return Util.readIntBE(this.entryId);
    }

    public int getEntryOffset() {
        return Util.readIntBE(this.entryOffset);
    }

    public int getEntryLength() {
        return Util.readIntBE(this.entryLength);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " entryId: " + getEntryId());
        ps.println(prefix + " entryOffset: " + getEntryOffset());
        ps.println(prefix + " entryLength: " + getEntryLength());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "EntryDescriptor:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[12];
        System.arraycopy(this.entryId, 0, result, 0, this.entryId.length);
        int offset = 0 + this.entryId.length;
        System.arraycopy(this.entryOffset, 0, result, offset, this.entryOffset.length);
        int offset2 = offset + this.entryOffset.length;
        System.arraycopy(this.entryLength, 0, result, offset2, this.entryLength.length);
        int length = offset2 + this.entryLength.length;
        return result;
    }
}
