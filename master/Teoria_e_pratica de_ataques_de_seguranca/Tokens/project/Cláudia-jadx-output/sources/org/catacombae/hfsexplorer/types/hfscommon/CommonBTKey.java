package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.csjc.DynamicStruct;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTKey;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTKey.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTKey.class */
public abstract class CommonBTKey<K extends CommonBTKey> implements Comparable<K>, DynamicStruct, PrintableStruct {
    @Override // org.catacombae.csjc.AbstractStruct
    public abstract byte[] getBytes();
}
