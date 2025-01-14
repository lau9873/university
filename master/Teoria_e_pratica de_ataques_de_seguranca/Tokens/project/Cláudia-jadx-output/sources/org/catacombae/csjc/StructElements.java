package org.catacombae.csjc;

import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.csjc.structelements.Endianness;
import org.catacombae.csjc.structelements.FieldType;
import org.catacombae.csjc.structelements.IntegerFieldBits;
import org.catacombae.csjc.structelements.IntegerFieldRepresentation;
import org.catacombae.csjc.structelements.Signedness;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/StructElements.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/StructElements.class */
public interface StructElements {
    public static final Endianness BIG_ENDIAN = Endianness.BIG_ENDIAN;
    public static final Endianness LITTLE_ENDIAN = Endianness.LITTLE_ENDIAN;
    public static final Signedness SIGNED = Signedness.SIGNED;
    public static final Signedness UNSIGNED = Signedness.UNSIGNED;
    public static final FieldType BOOLEAN = FieldType.BOOLEAN;
    public static final FieldType INTEGER = FieldType.INTEGER;
    public static final FieldType BYTEARRAY = FieldType.BYTEARRAY;
    public static final FieldType ASCIISTRING = FieldType.ASCIISTRING;
    public static final FieldType CUSTOM_CHARSET_STRING = FieldType.CUSTOM_CHARSET_STRING;
    public static final FieldType DATE = FieldType.DATE;
    public static final IntegerFieldBits BITS_8 = IntegerFieldBits.BITS_8;
    public static final IntegerFieldBits BITS_16 = IntegerFieldBits.BITS_16;
    public static final IntegerFieldBits BITS_32 = IntegerFieldBits.BITS_32;
    public static final IntegerFieldBits BITS_64 = IntegerFieldBits.BITS_64;
    public static final IntegerFieldRepresentation DECIMAL = IntegerFieldRepresentation.DECIMAL;
    public static final IntegerFieldRepresentation HEXADECIMAL = IntegerFieldRepresentation.HEXADECIMAL;
    public static final IntegerFieldRepresentation OCTAL = IntegerFieldRepresentation.OCTAL;
    public static final IntegerFieldRepresentation BINARY = IntegerFieldRepresentation.BINARY;

    Dictionary getStructElements();

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/StructElements$DictionaryBuilder.class
     */
    /* loaded from: hfsx.jar:org/catacombae/csjc/StructElements$DictionaryBuilder.class */
    public static class DictionaryBuilder extends org.catacombae.csjc.structelements.DictionaryBuilder {
        public DictionaryBuilder(String typeName) {
            super(typeName);
        }

        public DictionaryBuilder(String typeName, String typeDescription) {
            super(typeName, typeDescription);
        }
    }
}
