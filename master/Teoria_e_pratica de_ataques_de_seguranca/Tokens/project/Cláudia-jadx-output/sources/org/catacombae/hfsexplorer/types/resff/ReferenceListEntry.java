package org.catacombae.hfsexplorer.types.resff;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StaticStruct;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/resff/ReferenceListEntry.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/resff/ReferenceListEntry.class */
public class ReferenceListEntry implements StaticStruct, PrintableStruct {
    public static final int STRUCTSIZE = 12;
    private final byte[] resourceID = new byte[2];
    private final byte[] resourceNameOffset = new byte[2];
    private final byte[] resourceAttributes = new byte[1];
    private final byte[] resourceDataOffset = new byte[3];
    private final byte[] reserved1 = new byte[4];

    public ReferenceListEntry(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.resourceID, 0, 2);
        System.arraycopy(data, offset + 2, this.resourceNameOffset, 0, 2);
        System.arraycopy(data, offset + 4, this.resourceAttributes, 0, 1);
        System.arraycopy(data, offset + 5, this.resourceDataOffset, 0, 3);
        System.arraycopy(data, offset + 8, this.reserved1, 0, 4);
    }

    public static int length() {
        return 12;
    }

    public short getResourceID() {
        return Util.readShortBE(this.resourceID);
    }

    public short getResourceNameOffset() {
        return Util.readShortBE(this.resourceNameOffset);
    }

    public byte getResourceAttributes() {
        return Util.readByteBE(this.resourceAttributes);
    }

    public int getResourceDataOffset() {
        byte[] temp = new byte[4];
        temp[0] = 0;
        System.arraycopy(this.resourceDataOffset, 0, temp, 1, this.resourceDataOffset.length);
        return Util.readIntBE(temp);
    }

    public int getReserved1() {
        return Util.readIntBE(this.reserved1);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " resourceID: " + ((int) getResourceID()));
        ps.println(prefix + " resourceNameOffset: " + ((int) getResourceNameOffset()));
        ps.println(prefix + " resourceAttributes: " + ((int) getResourceAttributes()));
        ps.println(prefix + " resourceDataOffset: " + getResourceDataOffset());
        ps.println(prefix + " reserved1: " + getReserved1());
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ReferenceListEntry:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.resourceID, 0, result, 0, this.resourceID.length);
        int offset = 0 + this.resourceID.length;
        System.arraycopy(this.resourceNameOffset, 0, result, offset, this.resourceNameOffset.length);
        int offset2 = offset + this.resourceNameOffset.length;
        System.arraycopy(this.resourceAttributes, 0, result, offset2, this.resourceAttributes.length);
        int offset3 = offset2 + this.resourceAttributes.length;
        System.arraycopy(this.resourceDataOffset, 0, result, offset3, this.resourceDataOffset.length);
        int offset4 = offset3 + this.resourceDataOffset.length;
        System.arraycopy(this.reserved1, 0, result, offset4, this.reserved1.length);
        int length = offset4 + this.reserved1.length;
        return result;
    }

    @Override // org.catacombae.csjc.StaticStruct
    public int size() {
        return length();
    }
}
