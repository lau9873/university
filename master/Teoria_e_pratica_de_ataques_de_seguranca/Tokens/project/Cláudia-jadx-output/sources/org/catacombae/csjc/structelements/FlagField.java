package org.catacombae.csjc.structelements;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/FlagField.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/FlagField.class */
public class FlagField extends BooleanRepresentableField {
    private final byte[] fieldData;
    private final int offset;
    private final int length;
    private final int bitNumber;

    public FlagField(byte[] fieldData, int bitNumber) {
        this(fieldData, 0, fieldData.length, bitNumber);
    }

    public FlagField(byte[] fieldData, int offset, int length, int bitNumber) {
        super("Bit[1]", FieldType.BOOLEAN);
        this.fieldData = fieldData;
        this.offset = offset;
        this.length = length;
        this.bitNumber = bitNumber;
        if (bitNumber < 0 || bitNumber > length * 8) {
            throw new IllegalArgumentException("Illegal bit address! Valid addresses are in the range 0 to " + ((length * 8) - 1));
        }
    }

    @Override // org.catacombae.csjc.structelements.BooleanRepresentableField
    public boolean getValueAsBoolean() {
        int byteNumber = (this.length - 1) - (this.bitNumber / 8);
        byte flagByte = this.fieldData[this.offset + byteNumber];
        int flag = (flagByte >> (this.bitNumber % 8)) & 1;
        return flag != 0;
    }

    @Override // org.catacombae.csjc.structelements.BooleanRepresentableField
    public void setBooleanValue(boolean b2) {
        byte modifiedFlagByte;
        int byteNumber = (this.length - 1) - (this.bitNumber / 8);
        byte flagByte = this.fieldData[this.offset + byteNumber];
        int bitmask = 1 << (this.bitNumber % 8);
        if (b2) {
            modifiedFlagByte = (byte) (flagByte | bitmask);
        } else {
            modifiedFlagByte = (byte) (((flagByte ^ (-1)) | bitmask) ^ (-1));
        }
        this.fieldData[this.offset + byteNumber] = modifiedFlagByte;
    }
}
