package org.catacombae.jparted.lib;

import org.catacombae.io.ConcatenatedStream;
import org.catacombae.io.RandomAccessStream;
import org.catacombae.io.ReadableConcatenatedStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/SubDataLocator.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/SubDataLocator.class */
public class SubDataLocator extends DataLocator {
    private DataLocator source;
    private long offset;
    private long length;

    public SubDataLocator(DataLocator source, long offset, long length) {
        this.source = source;
        this.offset = offset;
        this.length = length;
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public ReadableRandomAccessStream createReadOnlyFile() {
        return new ReadableConcatenatedStream(this.source.createReadOnlyFile(), this.offset, this.length);
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public boolean isWritable() {
        return this.source.isWritable();
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public RandomAccessStream createReadWriteFile() throws UnsupportedOperationException {
        return new ConcatenatedStream(this.source.createReadWriteFile(), this.offset, this.length);
    }
}
