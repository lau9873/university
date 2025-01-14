package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ArrayBuilder;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/ExtDataRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/ExtDataRec.class */
public class ExtDataRec implements StructElements {
    public static final int STRUCTSIZE = 12;
    private final ExtDescriptor[] extDataRecs = new ExtDescriptor[3];

    public ExtDataRec(byte[] data, int offset) {
        int curOff = offset;
        for (int i2 = 0; i2 < this.extDataRecs.length; i2++) {
            this.extDataRecs[i2] = new ExtDescriptor(data, curOff);
            curOff += ExtDescriptor.length();
        }
    }

    public static int length() {
        return 12;
    }

    public ExtDescriptor[] getExtDataRecs() {
        return (ExtDescriptor[]) Util.arrayCopy(this.extDataRecs, new ExtDescriptor[this.extDataRecs.length]);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " extDataRecs: ");
        for (int i2 = 0; i2 < this.extDataRecs.length; i2++) {
            ps.println(prefix + "  [" + i2 + "]: ");
            this.extDataRecs[i2].print(ps, prefix + "   ");
        }
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ExtDataRec:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        int offset = 0;
        ExtDescriptor[] arr$ = this.extDataRecs;
        for (ExtDescriptor extDataRec : arr$) {
            byte[] tempData = extDataRec.getBytes();
            System.arraycopy(tempData, 0, result, offset, tempData.length);
            offset += tempData.length;
        }
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(ExtDataRec.class.getSimpleName());
        ArrayBuilder ab = new ArrayBuilder("ExtDescriptor[" + this.extDataRecs.length + "]");
        for (int i2 = 0; i2 < this.extDataRecs.length; i2 += 4) {
            ab.add(this.extDataRecs[i2].getStructElements());
        }
        db.add("extDataRecs", ab.getResult());
        return db.getResult();
    }
}
