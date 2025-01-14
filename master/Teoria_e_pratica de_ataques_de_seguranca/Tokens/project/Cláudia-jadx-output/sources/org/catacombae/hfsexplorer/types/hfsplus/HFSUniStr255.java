package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.UnicodeNormalizationToolkit;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSUniStr255.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSUniStr255.class */
public class HFSUniStr255 implements StructElements {
    private final byte[] length;
    private final byte[] unicode;

    public HFSUniStr255(byte[] data, int offset) {
        this.length = new byte[2];
        System.arraycopy(data, offset + 0, this.length, 0, 2);
        this.unicode = new byte[2 * Util.unsign(getLength())];
        System.arraycopy(data, offset + 2, this.unicode, 0, this.unicode.length);
    }

    public HFSUniStr255(String unicodeString) {
        this.length = new byte[2];
        char[] unicodeChars = unicodeString.toCharArray();
        if (unicodeChars.length > 255) {
            throw new RuntimeException("String too large.");
        }
        System.arraycopy(Util.toByteArrayBE((short) unicodeChars.length), 0, this.length, 0, 2);
        this.unicode = Util.readByteArrayBE(unicodeChars);
    }

    public int length() {
        return 2 + this.unicode.length;
    }

    public short getLength() {
        return Util.readShortBE(this.length);
    }

    public byte[] getRawUnicode() {
        return Util.createCopy(this.unicode);
    }

    public char[] getUnicode() {
        return Util.readCharArrayBE(this.unicode);
    }

    public String getUnicodeAsDecomposedString() {
        return new String(getUnicode());
    }

    public String getUnicodeAsComposedString() {
        return UnicodeNormalizationToolkit.getDefaultInstance().compose(getUnicodeAsDecomposedString());
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.length, 0, result, 0, 2);
        System.arraycopy(this.unicode, 0, result, 2, this.unicode.length);
        return result;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " length: " + Util.unsign(getLength()));
        ps.println(prefix + " unicode (decomposed): \"" + getUnicodeAsDecomposedString() + "\"");
        ps.println(prefix + "           (composed): \"" + getUnicodeAsComposedString() + "\"");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSUniStr255:");
        printFields(ps, prefix);
    }

    public String toString() {
        return getUnicodeAsComposedString();
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSUniStr255.class.getSimpleName());
        db.addUIntBE("length", this.length);
        db.addEncodedString("unicode", this.unicode, "UTF-16BE");
        return db.getResult();
    }
}
