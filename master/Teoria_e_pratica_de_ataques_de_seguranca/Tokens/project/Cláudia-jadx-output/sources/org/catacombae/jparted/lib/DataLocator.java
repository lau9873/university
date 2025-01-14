package org.catacombae.jparted.lib;

import org.catacombae.io.RandomAccessStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/DataLocator.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/DataLocator.class */
public abstract class DataLocator {
    public abstract ReadableRandomAccessStream createReadOnlyFile();

    public abstract boolean isWritable();

    public abstract RandomAccessStream createReadWriteFile() throws UnsupportedOperationException;
}
