package org.catacombae.hfsexplorer.types.resff;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StaticStruct;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/resff/ResourceType.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/resff/ResourceType.class */
public class ResourceType implements StaticStruct, PrintableStruct {
    public static final int STRUCTSIZE = 8;
    private final byte[] type = new byte[4];
    private final byte[] instanceCount = new byte[2];
    private final byte[] referenceListOffset = new byte[2];

    public ResourceType(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.type, 0, 4);
        System.arraycopy(data, offset + 4, this.instanceCount, 0, 2);
        System.arraycopy(data, offset + 6, this.referenceListOffset, 0, 2);
    }

    public static int length() {
        return 8;
    }

    public byte[] getType() {
        return Util.readByteArrayBE(this.type);
    }

    public short getInstanceCount() {
        return Util.readShortBE(this.instanceCount);
    }

    public short getReferenceListOffset() {
        return Util.readShortBE(this.referenceListOffset);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " type: " + Util.toASCIIString(getType()));
        ps.println(prefix + " instanceCount: " + ((int) getInstanceCount()));
        ps.println(prefix + " referenceListOffset: " + ((int) getReferenceListOffset()));
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ResourceType:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.type, 0, result, 0, this.type.length);
        int offset = 0 + this.type.length;
        System.arraycopy(this.instanceCount, 0, result, offset, this.instanceCount.length);
        int offset2 = offset + this.instanceCount.length;
        System.arraycopy(this.referenceListOffset, 0, result, offset2, this.referenceListOffset.length);
        int length = offset2 + this.referenceListOffset.length;
        return result;
    }

    @Override // org.catacombae.csjc.StaticStruct
    public int size() {
        return length();
    }
}
