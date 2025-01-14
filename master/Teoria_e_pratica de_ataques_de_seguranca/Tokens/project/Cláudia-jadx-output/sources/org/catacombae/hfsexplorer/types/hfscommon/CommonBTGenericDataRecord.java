package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTGenericDataRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTGenericDataRecord.class */
public class CommonBTGenericDataRecord extends CommonBTRecord {
    private final byte[] data;

    public CommonBTGenericDataRecord(byte[] data, int offset, int length) {
        this.data = new byte[length];
        System.arraycopy(data, offset, this.data, 0, length);
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
    public int getSize() {
        return this.data.length;
    }

    @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord
    public byte[] getBytes() {
        return Util.createCopy(this.data);
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CommonBTGenericDataRecord:");
        printFields(ps, prefix + " ");
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + "data: byte[" + this.data.length + "] (" + this.data + ")");
    }
}
