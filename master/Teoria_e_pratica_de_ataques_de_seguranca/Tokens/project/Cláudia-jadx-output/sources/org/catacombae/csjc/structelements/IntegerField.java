package org.catacombae.csjc.structelements;

import java.math.BigInteger;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/IntegerField.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/IntegerField.class */
public class IntegerField extends StringRepresentableField {
    private final byte[] fieldData;
    private final int offset;
    private final IntegerFieldBits bits;
    private final Signedness signedness;
    private final Endianness endianness;
    private final BigInteger maxValue;
    private final BigInteger minValue;
    private final IntegerFieldRepresentation representation;

    public IntegerField(byte[] fieldData, IntegerFieldBits bits, Signedness signedness, Endianness endianness) {
        this(fieldData, 0, bits, signedness, endianness);
    }

    public IntegerField(byte[] fieldData, int offset, IntegerFieldBits bits, Signedness signedness, Endianness endianness) {
        this(fieldData, offset, bits, signedness, endianness, IntegerFieldRepresentation.DECIMAL, null);
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [byte[], byte[][]] */
    public IntegerField(byte[] fieldData, int offset, IntegerFieldBits bits, Signedness signedness, Endianness endianness, IntegerFieldRepresentation representation, String unitComponent) {
        super((signedness == Signedness.SIGNED ? "S" : "U") + "Int" + bits.getBits(), FieldType.INTEGER, unitComponent);
        if (fieldData == null) {
            throw new IllegalArgumentException("fieldData == null");
        }
        if (bits == null) {
            throw new IllegalArgumentException("bits == null");
        }
        if (signedness == null) {
            throw new IllegalArgumentException("signedness == null");
        }
        if (endianness == null) {
            throw new IllegalArgumentException("endianness == null");
        }
        if (representation == null) {
            throw new IllegalArgumentException("representation == null");
        }
        if (fieldData.length - offset < bits.getBytes()) {
            throw new IllegalArgumentException("Not enough data left in fieldData!");
        }
        this.fieldData = fieldData;
        this.offset = offset;
        this.bits = bits;
        this.signedness = signedness;
        this.endianness = endianness;
        this.representation = representation;
        byte[] maxValueBytes = new byte[bits.getBytes()];
        byte[] minValueBytes = new byte[bits.getBytes()];
        Util.set(maxValueBytes, (byte) -1);
        Util.zero((byte[][]) new byte[]{minValueBytes});
        if (signedness == Signedness.SIGNED) {
            maxValueBytes[0] = (byte) (maxValueBytes[0] & Byte.MAX_VALUE);
            minValueBytes[0] = Byte.MIN_VALUE;
        }
        this.maxValue = new BigInteger(1, maxValueBytes);
        this.minValue = new BigInteger(minValueBytes);
        String validateMsg = validateData();
        if (validateMsg != null) {
            throw new IllegalArgumentException("Invalid value passed to constructor! Message: " + validateMsg);
        }
    }

    private String validateData() {
        return validate(getValueAsBigInteger());
    }

    private String validate(BigInteger bi) {
        if (this.signedness != Signedness.SIGNED && bi.signum() == -1) {
            return "Tried to insert negative value into unsigned field.";
        }
        if (bi.compareTo(this.maxValue) > 0) {
            return "Value too large for field! Maximum value is " + this.maxValue.toString() + ".";
        }
        if (bi.compareTo(this.minValue) < 0) {
            return "Value too small for this field. Minimum value is " + this.minValue.toString() + ".";
        }
        return null;
    }

    public BigInteger getValueAsBigInteger() {
        byte[] data;
        if (this.endianness == Endianness.LITTLE_ENDIAN) {
            data = Util.createReverseCopy(this.fieldData, this.offset, this.bits.getBytes());
        } else if (this.endianness == Endianness.BIG_ENDIAN) {
            data = Util.createCopy(this.fieldData, this.offset, this.bits.getBytes());
        } else {
            throw new RuntimeException("Illegal endianness value: " + this.endianness);
        }
        if (this.signedness == Signedness.SIGNED) {
            return new BigInteger(data);
        }
        if (this.signedness == Signedness.UNSIGNED) {
            return new BigInteger(1, data);
        }
        throw new RuntimeException("Illegal signedness value: " + this.signedness);
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String getValueAsString() {
        return this.representation.getPrefix() + getValueAsBigInteger().toString(this.representation.getRadix());
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public void setStringValue(String value) throws IllegalArgumentException {
        byte[] trueContents;
        String validateMsg = validateStringValue(value);
        if (validateMsg == null) {
            BigInteger bi = new BigInteger(value);
            byte[] ba = bi.toByteArray();
            if (this.signedness == Signedness.SIGNED && ba.length != this.bits.getBytes()) {
                throw new RuntimeException("UNEXPECTED: ba.length (" + ba.length + ") != bits.getBytes()(" + this.bits.getBytes() + ")");
            }
            if (this.signedness == Signedness.UNSIGNED && ba.length != this.bits.getBytes() + 1) {
                throw new RuntimeException("UNEXPECTED: ba.length (" + ba.length + ") != bits.getBytes()+1(" + this.bits.getBytes() + "+1=" + (this.bits.getBytes() + 1) + ")");
            }
            if (this.endianness == Endianness.LITTLE_ENDIAN) {
                trueContents = Util.createReverseCopy(ba, ba.length - this.bits.getBytes(), this.bits.getBytes());
            } else if (this.endianness == Endianness.BIG_ENDIAN) {
                trueContents = Util.createCopy(ba, ba.length - this.bits.getBytes(), this.bits.getBytes());
            } else {
                throw new RuntimeException("Illegal endianness value: " + this.endianness);
            }
            System.arraycopy(trueContents, 0, this.fieldData, this.offset, this.bits.getBytes());
            return;
        }
        throw new IllegalArgumentException("Invalid string value! Message: " + validateMsg);
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String validateStringValue(String s) {
        try {
            BigInteger bi = new BigInteger(s);
            return validate(bi);
        } catch (NumberFormatException e2) {
            return "Invalid integer string.";
        }
    }
}
