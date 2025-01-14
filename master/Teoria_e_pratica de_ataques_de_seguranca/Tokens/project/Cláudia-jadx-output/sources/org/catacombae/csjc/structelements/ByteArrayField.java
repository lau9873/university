package org.catacombae.csjc.structelements;

import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/ByteArrayField.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/ByteArrayField.class */
public class ByteArrayField extends StringRepresentableField {
    private final byte[] fieldData;
    private final int offset;
    private final int length;

    public ByteArrayField(byte[] fieldData) {
        this(fieldData, 0, fieldData.length);
    }

    public ByteArrayField(byte[] fieldData, int offset, int length) {
        super("Byte[" + fieldData.length + "]", FieldType.BYTEARRAY);
        this.fieldData = fieldData;
        this.offset = offset;
        this.length = length;
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String getValueAsString() {
        return "0x" + Util.byteArrayToHexString(this.fieldData, this.offset, this.length);
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public void setStringValue(String value) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Can't set byte string to string value at this point.");
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String validateStringValue(String s) {
        return "Can't set a byte string to a string value.";
    }
}
