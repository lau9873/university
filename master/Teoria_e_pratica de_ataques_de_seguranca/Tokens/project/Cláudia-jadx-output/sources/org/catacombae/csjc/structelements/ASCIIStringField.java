package org.catacombae.csjc.structelements;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/ASCIIStringField.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/ASCIIStringField.class */
public class ASCIIStringField extends StringRepresentableField {
    private final byte[] fieldData;

    public ASCIIStringField(byte[] fieldData) {
        super("Char[" + fieldData.length + "]", FieldType.ASCIISTRING);
        this.fieldData = fieldData;
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String validateStringValue(String s) {
        char[] sArray = s.toCharArray();
        byte[] asciiArray = new byte[sArray.length];
        for (int i2 = 0; i2 < asciiArray.length; i2++) {
            char curChar = sArray[i2];
            if (curChar < 0 || curChar > 127) {
                return "Invalid ASCII character at position " + i2;
            }
            asciiArray[i2] = (byte) curChar;
        }
        return validate(asciiArray);
    }

    private String validate(byte[] data) {
        if (data.length != this.fieldData.length) {
            return "Invalid length for string. Was: " + data.length + " Should be: " + this.fieldData.length;
        }
        for (int i2 = 0; i2 < data.length; i2++) {
            if (data[i2] < 0 || data[i2] > Byte.MAX_VALUE) {
                return "Invalid ASCII character at position " + i2;
            }
        }
        return null;
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String getValueAsString() {
        int[] codepoints = new int[this.fieldData.length];
        for (int i2 = 0; i2 < codepoints.length; i2++) {
            int cp = this.fieldData[i2] & Byte.MAX_VALUE;
            if (cp != this.fieldData[i2]) {
                cp = 63;
            }
            codepoints[i2] = cp;
        }
        return new String(codepoints, 0, codepoints.length);
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public void setStringValue(String value) throws IllegalArgumentException {
        String validateMsg = validateStringValue(value);
        if (validateMsg == null) {
            char[] valueArray = value.toCharArray();
            if (valueArray.length != this.fieldData.length) {
                throw new RuntimeException("You should not see this.");
            }
            byte[] asciiChars = new byte[this.fieldData.length];
            for (int i2 = 0; i2 < asciiChars.length; i2++) {
                asciiChars[i2] = (byte) (valueArray[i2] & 127);
            }
            System.arraycopy(asciiChars, 0, this.fieldData, 0, this.fieldData.length);
            return;
        }
        throw new IllegalArgumentException("Invalid string value! Message: " + validateMsg);
    }
}
