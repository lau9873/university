package org.catacombae.hfsexplorer.types.hfs;

import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusDateField;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/HFSDateField.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/HFSDateField.class */
public class HFSDateField extends HFSPlusDateField {
    public HFSDateField(byte[] data) {
        this(data, 0, data.length);
    }

    public HFSDateField(byte[] data, int offset, int length) {
        super("HFSDate", data, offset, length, true);
    }
}
