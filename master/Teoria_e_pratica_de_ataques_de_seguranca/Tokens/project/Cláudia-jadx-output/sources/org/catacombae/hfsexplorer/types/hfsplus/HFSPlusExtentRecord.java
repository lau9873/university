package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.ArrayBuilder;
import org.catacombae.csjc.structelements.Dictionary;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentRecord.class */
public class HFSPlusExtentRecord implements StructElements {
    private final HFSPlusExtentDescriptor[] array = new HFSPlusExtentDescriptor[8];

    public HFSPlusExtentRecord(byte[] data, int offset) {
        for (int i2 = 0; i2 < this.array.length; i2++) {
            this.array[i2] = new HFSPlusExtentDescriptor(data, offset + (i2 * HFSPlusExtentDescriptor.getSize()));
        }
    }

    public HFSPlusExtentDescriptor getExtentDescriptor(int index) {
        return this.array[index];
    }

    public HFSPlusExtentDescriptor[] getExtentDescriptors() {
        HFSPlusExtentDescriptor[] arrayCopy = new HFSPlusExtentDescriptor[this.array.length];
        for (int i2 = 0; i2 < this.array.length; i2++) {
            arrayCopy[i2] = this.array[i2];
        }
        return arrayCopy;
    }

    public int length() {
        int res = 0;
        HFSPlusExtentDescriptor[] arr$ = this.array;
        for (HFSPlusExtentDescriptor hFSPlusExtentDescriptor : arr$) {
            res += HFSPlusExtentDescriptor.getSize();
        }
        return res;
    }

    public int getNumExtentsInUse() {
        for (int i2 = 0; i2 < this.array.length; i2++) {
            HFSPlusExtentDescriptor cur = this.array[i2];
            if (cur.getBlockCount() == 0 && cur.getStartBlock() == 0) {
                return i2;
            }
        }
        return this.array.length;
    }

    public void print(PrintStream ps, int pregap) {
        String pregapString = "";
        for (int i2 = 0; i2 < pregap; i2++) {
            pregapString = pregapString + " ";
        }
        print(ps, pregapString);
    }

    public void print(PrintStream ps, String prefix) {
        for (int i2 = 0; i2 < this.array.length; i2++) {
            ps.println(prefix + "array[" + i2 + "]:");
            this.array[i2].print(ps, prefix + "  ");
        }
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        int offset = 0;
        HFSPlusExtentDescriptor[] arr$ = this.array;
        for (HFSPlusExtentDescriptor desc : arr$) {
            byte[] tempData = desc.getBytes();
            System.arraycopy(tempData, 0, result, offset, tempData.length);
            offset += tempData.length;
        }
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSPlusExtentRecord.class.getSimpleName());
        ArrayBuilder ab = new ArrayBuilder("HFSPlusExtentDescriptor[8]");
        HFSPlusExtentDescriptor[] arr$ = this.array;
        for (HFSPlusExtentDescriptor descriptor : arr$) {
            ab.add(descriptor.getStructElements());
        }
        db.add("array", ab.getResult());
        return db.getResult();
    }
}
