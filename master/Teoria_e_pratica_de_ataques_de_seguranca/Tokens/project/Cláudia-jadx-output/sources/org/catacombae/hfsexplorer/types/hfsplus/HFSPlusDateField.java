package org.catacombae.hfsexplorer.types.hfsplus;

import java.text.DateFormat;
import org.catacombae.csjc.structelements.FieldType;
import org.catacombae.csjc.structelements.StringRepresentableField;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusDateField.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusDateField.class */
public class HFSPlusDateField extends StringRepresentableField {
    private static final Object dtiSync = new Object();
    private static final DateFormat dti = DateFormat.getDateTimeInstance(3, 3);
    private final byte[] data;
    private final int offset;
    private final int length;
    private final boolean localTime;

    public HFSPlusDateField(byte[] data, boolean localTime) {
        this(data, 0, data.length, localTime);
    }

    public HFSPlusDateField(byte[] data, int offset, int length, boolean localTime) {
        this("HFSDate", data, offset, length, localTime);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HFSPlusDateField(String typeName, byte[] data, int offset, int length, boolean localTime) {
        super(typeName, FieldType.DATE);
        this.data = data;
        this.offset = offset;
        this.length = length;
        this.localTime = localTime;
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String getValueAsString() {
        synchronized (dtiSync) {
            if (this.localTime) {
                return dti.format(HFSPlusDate.localTimestampToDate(Util.readIntBE(this.data, this.offset)));
            }
            return dti.format(HFSPlusDate.gmtTimestampToDate(Util.readIntBE(this.data, this.offset)));
        }
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public void setStringValue(String value) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // org.catacombae.csjc.structelements.StringRepresentableField
    public String validateStringValue(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
