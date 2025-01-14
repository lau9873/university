package org.catacombae.csjc.structelements;

import java.util.Hashtable;
import java.util.LinkedList;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/DictionaryBuilder.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/DictionaryBuilder.class */
public class DictionaryBuilder {
    private final String typeName;
    private final String typeDescription;
    private final LinkedList<String> keys;
    private final Hashtable<String, StructElement> mappings;
    private final Hashtable<String, String> descriptions;

    public DictionaryBuilder(String typeName) {
        this(typeName, null);
    }

    public DictionaryBuilder(String typeName, String typeDescription) {
        this.keys = new LinkedList<>();
        this.mappings = new Hashtable<>();
        this.descriptions = new Hashtable<>();
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public void addIntArray(String key, byte[] data, IntegerFieldBits bits, Signedness signedness, Endianness endianness) {
        addIntArray(key, data, 0, data.length, bits, signedness, endianness);
    }

    public void addIntArray(String key, byte[] data, IntegerFieldBits bits, Signedness signedness, Endianness endianness, String description, IntegerFieldRepresentation rep) {
        addIntArray(key, data, 0, data.length, bits, signedness, endianness, description, rep);
    }

    public void addIntArray(String key, byte[] data, int offset, int length, IntegerFieldBits bits, Signedness signedness, Endianness endianness) {
        addIntArray(key, data, offset, length, bits, signedness, endianness, null, IntegerFieldRepresentation.DECIMAL);
    }

    public void addIntArray(String key, byte[] data, int offset, int length, IntegerFieldBits bits, Signedness signedness, Endianness endianness, String description, IntegerFieldRepresentation rep) {
        String arrayTypeName;
        if (length % bits.getBytes() != 0) {
            throw new RuntimeException("Supplied data is not aligned to size of type.");
        }
        switch (signedness) {
            case SIGNED:
                arrayTypeName = "S";
                break;
            case UNSIGNED:
                arrayTypeName = "U";
                break;
            default:
                throw new IllegalArgumentException("signedness == null!");
        }
        ArrayBuilder ab = new ArrayBuilder(arrayTypeName + "Int" + bits.getBits() + "[" + (length / bits.getBytes()) + "]");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < length) {
                ab.add(new IntegerField(data, offset + i3, bits, signedness, endianness, rep, null));
                i2 = i3 + bits.getBytes();
            } else {
                add(key, ab.getResult(), description);
                return;
            }
        }
    }

    public Dictionary getResult() {
        return new Dictionary(this.typeName, this.typeDescription, (String[]) this.keys.toArray(new String[this.keys.size()]), this.mappings, this.descriptions);
    }

    public void add(String key, StructElement mapping) {
        add(key, mapping, null);
    }

    public void add(String key, StructElement mapping, String description) {
        if (this.mappings.get(key) != null) {
            throw new IllegalArgumentException("A mapping already exists for key \"" + key + "\"!");
        }
        this.mappings.put(key, mapping);
        if (description != null) {
            this.descriptions.put(key, description);
        }
        this.keys.add(key);
    }

    public void addSIntBE(String key, byte[] data) {
        addSIntBE(key, data, null);
    }

    public void addSIntLE(String key, byte[] data) {
        addSIntLE(key, data, null);
    }

    public void addUIntBE(String key, byte[] data) {
        addUIntBE(key, data, null);
    }

    public void addUIntLE(String key, byte[] data) {
        addUIntLE(key, data, null);
    }

    public void addSIntBE(String key, byte[] data, String description) {
        addSIntBE(key, data, 0, data.length, description, null, IntegerFieldRepresentation.DECIMAL);
    }

    public void addSIntLE(String key, byte[] data, String description) {
        addSIntLE(key, data, 0, data.length, description, null, IntegerFieldRepresentation.DECIMAL);
    }

    public void addUIntBE(String key, byte[] data, String description) {
        addUIntBE(key, data, 0, data.length, description, null, IntegerFieldRepresentation.DECIMAL);
    }

    public void addUIntLE(String key, byte[] data, String description) {
        addUIntLE(key, data, 0, data.length, description, null, IntegerFieldRepresentation.DECIMAL);
    }

    public void addSIntBE(String key, byte[] data, String description, String unit) {
        addSIntBE(key, data, 0, data.length, description, unit, IntegerFieldRepresentation.DECIMAL);
    }

    public void addSIntLE(String key, byte[] data, String description, String unit) {
        addSIntLE(key, data, 0, data.length, description, unit, IntegerFieldRepresentation.DECIMAL);
    }

    public void addUIntBE(String key, byte[] data, String description, String unit) {
        addUIntBE(key, data, 0, data.length, description, unit, IntegerFieldRepresentation.DECIMAL);
    }

    public void addUIntLE(String key, byte[] data, String description, String unit) {
        addUIntLE(key, data, 0, data.length, description, unit, IntegerFieldRepresentation.DECIMAL);
    }

    public void addSIntBE(String key, byte[] data, String description, IntegerFieldRepresentation rep) {
        addSIntBE(key, data, 0, data.length, description, null, rep);
    }

    public void addSIntLE(String key, byte[] data, String description, IntegerFieldRepresentation rep) {
        addSIntLE(key, data, 0, data.length, description, null, rep);
    }

    public void addUIntBE(String key, byte[] data, String description, IntegerFieldRepresentation rep) {
        addUIntBE(key, data, 0, data.length, description, null, rep);
    }

    public void addUIntLE(String key, byte[] data, String description, IntegerFieldRepresentation rep) {
        addUIntLE(key, data, 0, data.length, description, null, rep);
    }

    public void addSIntBE(String key, byte[] data, int offset, int length, String description, String unit, IntegerFieldRepresentation rep) {
        addInt(key, data, offset, length, Signedness.SIGNED, Endianness.BIG_ENDIAN, description, unit, rep);
    }

    public void addSIntLE(String key, byte[] data, int offset, int length, String description, String unit, IntegerFieldRepresentation rep) {
        addInt(key, data, offset, length, Signedness.SIGNED, Endianness.LITTLE_ENDIAN, description, unit, rep);
    }

    public void addUIntBE(String key, byte[] data, int offset, int length, String description, String unit, IntegerFieldRepresentation rep) {
        addInt(key, data, offset, length, Signedness.UNSIGNED, Endianness.BIG_ENDIAN, description, unit, rep);
    }

    public void addUIntLE(String key, byte[] data, int offset, int length, String description, String unit, IntegerFieldRepresentation rep) {
        addInt(key, data, offset, length, Signedness.UNSIGNED, Endianness.LITTLE_ENDIAN, description, unit, rep);
    }

    private void addInt(String key, byte[] data, int offset, int length, Signedness signedness, Endianness endianness, String description, String unit, IntegerFieldRepresentation rep) {
        switch (length) {
            case 1:
                add(key, new IntegerField(data, offset, IntegerFieldBits.BITS_8, signedness, endianness, rep, unit), description);
                return;
            case 2:
                add(key, new IntegerField(data, offset, IntegerFieldBits.BITS_16, signedness, endianness, rep, unit), description);
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("You supplied a " + (length * 8) + "-bit value. Only 64, 32, 16 and 8-bit values are supported.");
            case 4:
                add(key, new IntegerField(data, offset, IntegerFieldBits.BITS_32, signedness, endianness, rep, unit), description);
                return;
            case 8:
                add(key, new IntegerField(data, offset, IntegerFieldBits.BITS_64, signedness, endianness, rep, unit), description);
                return;
        }
    }

    public void addByteArray(String key, byte[] data) {
        addByteArray(key, data, 0, data.length);
    }

    public void addByteArray(String key, byte[] data, int offset, int length) {
        addByteArray(key, data, offset, length, null);
    }

    public void addByteArray(String key, byte[] data, int offset, int length, String description) {
        add(key, new ByteArrayField(data, offset, length), description);
    }

    public void addFlag(String key, byte[] data, int bitOffset, String description) {
        addFlag(key, data, 0, data.length, bitOffset, description);
    }

    public void addFlag(String key, byte[] data, int bitOffset) {
        addFlag(key, data, 0, data.length, bitOffset);
    }

    public void addFlag(String key, byte[] data, int offset, int length, int bitOffset) {
        addFlag(key, data, offset, length, bitOffset, null);
    }

    public void addFlag(String key, byte[] data, int offset, int length, int bitOffset, String description) {
        add(key, new FlagField(data, offset, length, bitOffset), description);
    }

    public void addEncodedString(String key, byte[] data, String encoding) {
        addEncodedString(key, data, 0, data.length, encoding);
    }

    public void addEncodedString(String key, byte[] data, int offset, int length, String encoding) {
        add(key, new EncodedStringField(data, offset, length, encoding));
    }

    public void addAll(Dictionary d2) {
        String[] arr$ = d2.getKeys();
        for (String key : arr$) {
            String description = d2.getDescription(key);
            if (description != null) {
                add(key, d2.getElement(key), description);
            } else {
                add(key, d2.getElement(key));
            }
        }
    }
}
