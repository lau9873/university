package org.catacombae.hfsexplorer.types.resff;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StaticStruct;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/resff/ResourceHeader.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/resff/ResourceHeader.class */
public class ResourceHeader implements StaticStruct, PrintableStruct {
    public static final int STRUCTSIZE = 16;
    private final byte[] dataOffset = new byte[4];
    private final byte[] mapOffset = new byte[4];
    private final byte[] dataLength = new byte[4];
    private final byte[] mapLength = new byte[4];

    public ResourceHeader(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.dataOffset, 0, 4);
        System.arraycopy(data, offset + 4, this.mapOffset, 0, 4);
        System.arraycopy(data, offset + 8, this.dataLength, 0, 4);
        System.arraycopy(data, offset + 12, this.mapLength, 0, 4);
    }

    public static int length() {
        return 16;
    }

    public int getDataOffset() {
        return Util.readIntBE(this.dataOffset);
    }

    public int getMapOffset() {
        return Util.readIntBE(this.mapOffset);
    }

    public int getDataLength() {
        return Util.readIntBE(this.dataLength);
    }

    public int getMapLength() {
        return Util.readIntBE(this.mapLength);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " dataOffset: " + getDataOffset());
        ps.println(prefix + " mapOffset: " + getMapOffset());
        ps.println(prefix + " dataLength: " + getDataLength());
        ps.println(prefix + " mapLength: " + getMapLength());
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ResourceHeader:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.dataOffset, 0, result, 0, this.dataOffset.length);
        int offset = 0 + this.dataOffset.length;
        System.arraycopy(this.mapOffset, 0, result, offset, this.mapOffset.length);
        int offset2 = offset + this.mapOffset.length;
        System.arraycopy(this.dataLength, 0, result, offset2, this.dataLength.length);
        int offset3 = offset2 + this.dataLength.length;
        System.arraycopy(this.mapLength, 0, result, offset3, this.mapLength.length);
        int length = offset3 + this.mapLength.length;
        return result;
    }

    @Override // org.catacombae.csjc.StaticStruct
    public int size() {
        return length();
    }
}
