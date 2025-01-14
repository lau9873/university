package org.catacombae.hfsexplorer.types.carbon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/carbon/FourCharCode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/carbon/FourCharCode.class */
public class FourCharCode implements StructElements {
    private final byte[] fourCharCode = new byte[4];

    public FourCharCode(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.fourCharCode, 0, 4);
    }

    public int getFourCharCode() {
        return Util.readIntBE(this.fourCharCode);
    }

    public String getFourCharCodeAsString() {
        return Util.toASCIIString(getFourCharCode());
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " fourCharCode: \"" + getFourCharCodeAsString() + "\"");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "FourCharCode:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        return Util.createCopy(this.fourCharCode);
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(FourCharCode.class.getSimpleName());
        db.addEncodedString("fourCharCode", this.fourCharCode, "US-ASCII");
        return db.getResult();
    }
}
