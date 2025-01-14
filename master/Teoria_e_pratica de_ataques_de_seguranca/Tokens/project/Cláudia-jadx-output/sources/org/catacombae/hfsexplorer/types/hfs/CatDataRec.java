package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StaticStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CatDataRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/CatDataRec.class */
public abstract class CatDataRec implements StaticStruct, PrintableStruct, StructElements {
    public static final byte HFS_DIRECTORY_RECORD = 1;
    public static final byte HFS_FILE_RECORD = 2;
    public static final byte HFS_DIRECTORY_THREAD_RECORD = 3;
    public static final byte HFS_FILE_THREAD_RECORD = 4;
    public static final int STRUCTSIZE = 2;
    private final byte[] cdrType = new byte[1];
    private final byte[] cdrResrv2 = new byte[1];

    /* JADX INFO: Access modifiers changed from: protected */
    public CatDataRec(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.cdrType, 0, 1);
        System.arraycopy(data, offset + 1, this.cdrResrv2, 0, 1);
    }

    public static int length() {
        return 2;
    }

    public byte getCdrType() {
        return Util.readByteBE(this.cdrType);
    }

    public byte getCdrResrv2() {
        return Util.readByteBE(this.cdrResrv2);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " cdrType: " + ((int) Util.unsign(getCdrType())));
        ps.println(prefix + " cdrResrv2: " + ((int) Util.unsign(getCdrResrv2())));
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CatDataRec:");
        printFields(ps, prefix);
    }

    @Override // org.catacombae.csjc.AbstractStruct
    public byte[] getBytes() {
        byte[] result = new byte[2];
        System.arraycopy(this.cdrType, 0, result, 0, this.cdrType.length);
        int offset = 0 + this.cdrType.length;
        System.arraycopy(this.cdrResrv2, 0, result, offset, this.cdrResrv2.length);
        int length = offset + this.cdrResrv2.length;
        return result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSuperStructElements(StructElements.DictionaryBuilder db) {
        db.addUIntBE("cdrType", this.cdrType, "Record type", HEXADECIMAL);
        db.addUIntBE("cdrResrv2", this.cdrResrv2, "Reserved", HEXADECIMAL);
    }
}
