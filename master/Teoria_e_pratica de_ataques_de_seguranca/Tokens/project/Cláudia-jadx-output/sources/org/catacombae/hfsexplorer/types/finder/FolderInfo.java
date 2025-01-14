package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.carbon.Rect;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/FolderInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/FolderInfo.class */
public class FolderInfo extends CommonFinderInfo implements StructElements {
    private final Rect windowBounds;

    public FolderInfo(byte[] data, int offset) {
        super(data, offset);
        this.windowBounds = new Rect(data, offset + 0);
    }

    public static int length() {
        return 16;
    }

    public Rect getWindowBounds() {
        return this.windowBounds;
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonFinderInfo
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        byte[] tempData = this.windowBounds.getBytes();
        System.arraycopy(tempData, 0, result, 0, tempData.length);
        int offset = 0 + tempData.length;
        byte[] tempData2 = super.getBytes();
        System.arraycopy(tempData2, 0, result, offset, tempData2.length);
        int length = offset + tempData2.length;
        return result;
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonFinderInfo, org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " windowBounds: ");
        getWindowBounds().print(ps, prefix + "  ");
        super.printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "FolderInfo:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonFinderInfo, org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(FolderInfo.class.getSimpleName());
        db.add("windowBounds", this.windowBounds.getStructElements());
        db.addAll(super.getStructElements());
        return db.getResult();
    }
}
