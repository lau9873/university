package org.catacombae.csjc.structelements;

import java.util.LinkedList;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/ArrayBuilder.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/ArrayBuilder.class */
public class ArrayBuilder {
    private final String typeName;
    private final LinkedList<StructElement> elements = new LinkedList<>();

    public ArrayBuilder(String typeName) {
        this.typeName = typeName;
    }

    public void add(StructElement... elements) {
        for (StructElement element : elements) {
            this.elements.add(element);
        }
    }

    public void addSIntBE(byte[] data) {
        addSIntBE(data, 0, data.length);
    }

    public void addSIntLE(byte[] data) {
        addSIntLE(data, 0, data.length);
    }

    public void addUIntBE(byte[] data) {
        addUIntBE(data, 0, data.length);
    }

    public void addUIntLE(byte[] data) {
        addUIntLE(data, 0, data.length);
    }

    public void addSIntBE(byte[] data, int offset, int length) {
        addInt(data, offset, length, Signedness.SIGNED, Endianness.BIG_ENDIAN);
    }

    public void addSIntLE(byte[] data, int offset, int length) {
        addInt(data, offset, length, Signedness.SIGNED, Endianness.LITTLE_ENDIAN);
    }

    public void addUIntBE(byte[] data, int offset, int length) {
        addInt(data, offset, length, Signedness.UNSIGNED, Endianness.BIG_ENDIAN);
    }

    public void addUIntLE(byte[] data, int offset, int length) {
        addInt(data, offset, length, Signedness.UNSIGNED, Endianness.LITTLE_ENDIAN);
    }

    private void addInt(byte[] data, int offset, int length, Signedness signedness, Endianness endianness) {
        switch (length) {
            case 1:
                add(new IntegerField(data, offset, IntegerFieldBits.BITS_8, signedness, endianness));
                return;
            case 2:
                add(new IntegerField(data, offset, IntegerFieldBits.BITS_16, signedness, endianness));
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("You supplied a " + (length * 8) + "-bit value. Only 64, 32, 16 and 8-bit values are supported.");
            case 4:
                add(new IntegerField(data, offset, IntegerFieldBits.BITS_32, signedness, endianness));
                return;
            case 8:
                add(new IntegerField(data, offset, IntegerFieldBits.BITS_64, signedness, endianness));
                return;
        }
    }

    public Array getResult() {
        return new Array(this.typeName, (StructElement[]) this.elements.toArray(new StructElement[this.elements.size()]));
    }
}
