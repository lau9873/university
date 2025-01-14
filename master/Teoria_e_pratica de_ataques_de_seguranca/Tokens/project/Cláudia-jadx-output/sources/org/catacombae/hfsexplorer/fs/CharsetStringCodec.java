package org.catacombae.hfsexplorer.fs;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/CharsetStringCodec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/CharsetStringCodec.class */
public class CharsetStringCodec implements StringCodec {
    private final String charsetName;
    private final CharsetDecoder decoder;
    private final CharsetEncoder encoder;

    public CharsetStringCodec(String charsetName) throws IllegalCharsetNameException, UnsupportedCharsetException {
        this.charsetName = charsetName;
        Charset cs = Charset.forName(charsetName);
        this.decoder = cs.newDecoder();
        this.encoder = cs.newEncoder();
    }

    @Override // org.catacombae.hfsexplorer.fs.StringCodec
    public String decode(byte[] data) {
        return decode(data, 0, data.length);
    }

    @Override // org.catacombae.hfsexplorer.fs.StringCodec
    public String decode(byte[] data, int off, int len) {
        try {
            return this.decoder.decode(ByteBuffer.wrap(data, off, len)).toString();
        } catch (CharacterCodingException e2) {
            throw new RuntimeException("Could not decode data!", e2);
        }
    }

    @Override // org.catacombae.hfsexplorer.fs.StringCodec
    public byte[] encode(String str) {
        return encode(str, 0, str.length());
    }

    @Override // org.catacombae.hfsexplorer.fs.StringCodec
    public byte[] encode(String str, int off, int len) {
        try {
            return this.encoder.encode(CharBuffer.wrap(str.toCharArray(), off, len)).array();
        } catch (CharacterCodingException e2) {
            throw new RuntimeException("Could not encode data!", e2);
        }
    }

    public String getCharsetName() {
        return this.charsetName;
    }
}
