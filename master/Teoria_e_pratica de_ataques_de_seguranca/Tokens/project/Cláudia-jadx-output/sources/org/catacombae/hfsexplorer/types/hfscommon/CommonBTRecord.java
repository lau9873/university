package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.csjc.PrintableStruct;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTRecord.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTRecord.class */
public abstract class CommonBTRecord implements PrintableStruct {
    public abstract int getSize();

    public abstract byte[] getBytes();
}
