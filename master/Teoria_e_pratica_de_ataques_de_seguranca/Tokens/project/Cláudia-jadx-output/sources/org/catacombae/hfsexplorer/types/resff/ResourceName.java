package org.catacombae.hfsexplorer.types.resff;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.catacombae.csjc.DynamicStruct;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccess;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/resff/ResourceName.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/resff/ResourceName.class */
public class ResourceName implements DynamicStruct, PrintableStruct {
    private final byte nameLength;
    private final byte[] name;

    public ResourceName(SynchronizedReadableRandomAccess stream, long offset) {
        byte[] nameLengthArray = new byte[1];
        stream.readFullyFrom(offset, nameLengthArray);
        this.nameLength = nameLengthArray[0];
        this.name = new byte[getNameLength()];
        stream.readFullyFrom(offset + 1, this.name);
    }

    public short getNameLength() {
        return Util.unsign(this.nameLength);
    }

    public byte[] getName() {
        return Util.readByteArrayBE(this.name);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " nameLength: " + ((int) getNameLength()));
        try {
            ps.println(prefix + " name: " + new String(getName(), "MacRoman"));
        } catch (UnsupportedEncodingException e2) {
            ps.println(prefix + " name: 0x" + Util.byteArrayToHexString(getName()) + " (non-decodable)");
        }
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ResourceName:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[occupiedSize()];
        result[0] = this.nameLength;
        int offset = 0 + 1;
        System.arraycopy(this.name, 0, result, offset, this.name.length);
        int length = offset + this.name.length;
        return result;
    }

    @Override // org.catacombae.csjc.DynamicStruct
    public int maxSize() {
        return 255;
    }

    @Override // org.catacombae.csjc.DynamicStruct
    public int occupiedSize() {
        return 1 + this.name.length;
    }
}
