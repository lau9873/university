package org.catacombae.hfsexplorer.types.hfsplus;

import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTIndexRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTIndexRecord.class */
public class BTIndexRecord {
    private final BTKey key;
    private final byte[] index = new byte[4];

    public BTIndexRecord(BTKey key, byte[] data, int offset) {
        this.key = key;
        System.arraycopy(data, offset + key.length(), this.index, 0, 4);
    }

    public BTKey getKey() {
        return this.key;
    }

    public int getIndex() {
        return Util.readIntBE(this.index);
    }
}
