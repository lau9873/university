package org.catacombae.hfsexplorer.types.finder;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.types.carbon.OSType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/finder/FileInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/finder/FileInfo.class */
public class FileInfo extends CommonFinderInfo implements StructElements {
    private final OSType fileType;
    private final OSType fileCreator;

    public FileInfo(byte[] data, int offset) {
        super(data, offset);
        this.fileType = new OSType(data, offset + 0);
        this.fileCreator = new OSType(data, offset + 4);
    }

    public static int length() {
        return 16;
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonFinderInfo
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        byte[] tempData = this.fileType.getBytes();
        System.arraycopy(tempData, 0, result, 0, tempData.length);
        int offset = 0 + tempData.length;
        byte[] tempData2 = this.fileCreator.getBytes();
        System.arraycopy(tempData2, 0, result, offset, tempData2.length);
        int offset2 = offset + tempData2.length;
        byte[] tempData3 = super.getBytes();
        System.arraycopy(tempData3, 0, result, offset2, tempData3.length);
        int length = offset2 + tempData3.length;
        return result;
    }

    public OSType getFileType() {
        return this.fileType;
    }

    public OSType getFileCreator() {
        return this.fileCreator;
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonFinderInfo, org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " fileType: ");
        getFileType().print(ps, prefix + "  ");
        ps.println(prefix + " fileCreator: ");
        getFileCreator().print(ps, prefix + "  ");
        super.printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "FileInfo:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.hfsexplorer.types.finder.CommonFinderInfo, org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(FileInfo.class.getSimpleName());
        db.add("fileType", this.fileType.getStructElements());
        db.add("fileCreator", this.fileCreator.getStructElements());
        db.addAll(super.getStructElements());
        return db.getResult();
    }
}
