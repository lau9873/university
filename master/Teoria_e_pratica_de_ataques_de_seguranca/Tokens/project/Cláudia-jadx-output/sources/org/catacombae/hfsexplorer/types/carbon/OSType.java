package org.catacombae.hfsexplorer.types.carbon;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/carbon/OSType.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/carbon/OSType.class */
public class OSType implements StructElements {
    private FourCharCode osType;

    public OSType(byte[] data, int offset) {
        this.osType = new FourCharCode(data, offset);
    }

    public FourCharCode getOSType() {
        return this.osType;
    }

    public String toString() {
        return this.osType.getFourCharCodeAsString();
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " osType: ");
        this.osType.print(ps, prefix + "  ");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "OSType:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        return this.osType.getBytes();
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(OSType.class.getSimpleName());
        db.add("osType", this.osType.getStructElements());
        return db.getResult();
    }
}
