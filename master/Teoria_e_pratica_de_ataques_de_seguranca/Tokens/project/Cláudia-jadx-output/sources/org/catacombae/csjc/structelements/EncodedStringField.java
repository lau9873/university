package org.catacombae.csjc.structelements;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/EncodedStringField.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/EncodedStringField.class */
public class EncodedStringField extends StringRepresentableField {
    private final byte[] fieldData;
    private final Charset charset;
    private final int offset;
    private final int length;

    public EncodedStringField(byte[] fieldData, String encoding) {
        this(fieldData, 0, fieldData.length, encoding);
    }

    public EncodedStringField(byte[] fieldData, int offset, int length, String encoding) {
        super("Byte[" + length + "]", FieldType.CUSTOM_CHARSET_STRING);
        this.fieldData = fieldData;
        this.offset = offset;
        this.length = length;
        this.charset = Charset.forName(encoding);
        String validateMsg = validate(this.fieldData, offset, length);
        if (validateMsg != null) {
            throw new IllegalArgumentException("Invalid value passed to constructor! Message: " + validateMsg);
        }
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String validateStringValue(String s) {
        try {
            CharsetEncoder enc = this.charset.newEncoder();
            ByteBuffer bb = enc.encode(CharBuffer.wrap(s));
            byte[] array = bb.array();
            return validate(array, 0, array.length);
        } catch (CharacterCodingException cce) {
            return "Exception while encoding string data: " + cce.toString();
        }
    }

    private String validate(byte[] data, int offset, int length) {
        if (length != this.fieldData.length) {
            return "Invalid length for string. Was: " + length + " Should be: " + this.fieldData.length;
        }
        try {
            CharsetDecoder dec = this.charset.newDecoder();
            dec.decode(ByteBuffer.wrap(data, offset, length));
            return null;
        } catch (Exception e2) {
            return "Decode operation failed! Exception: " + e2.toString();
        }
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String getValueAsString() {
        try {
            CharsetDecoder dec = this.charset.newDecoder();
            return dec.decode(ByteBuffer.wrap(this.fieldData, this.offset, this.length)).toString();
        } catch (CharacterCodingException cce) {
            throw new RuntimeException("Exception while decoding data...", cce);
        }
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public void setStringValue(String value) throws IllegalArgumentException {
        String validateMsg = validateStringValue(value);
        if (validateMsg == null) {
            try {
                CharsetEncoder enc = this.charset.newEncoder();
                ByteBuffer bb = enc.encode(CharBuffer.wrap(value));
                byte[] encodedData = bb.array();
                if (encodedData.length != this.length) {
                    throw new RuntimeException("You should not see this.");
                }
                System.arraycopy(encodedData, 0, this.fieldData, this.offset, this.length);
                return;
            } catch (CharacterCodingException cce) {
                throw new RuntimeException("Exception while encoding string data: ", cce);
            }
        }
        throw new IllegalArgumentException("Invalid string value! Message: " + validateMsg);
    }
}
