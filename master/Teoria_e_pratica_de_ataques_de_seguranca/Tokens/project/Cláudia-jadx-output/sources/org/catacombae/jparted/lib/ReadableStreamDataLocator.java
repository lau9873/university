package org.catacombae.jparted.lib;

import org.catacombae.hfsexplorer.io.ReadableRandomAccessSubstream;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccessStream;
import org.catacombae.io.RandomAccessStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ReadableStreamDataLocator.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ReadableStreamDataLocator.class */
public class ReadableStreamDataLocator extends DataLocator {
    private SynchronizedReadableRandomAccessStream backingStream;

    public ReadableStreamDataLocator(ReadableRandomAccessStream sourceStream) {
        this.backingStream = new SynchronizedReadableRandomAccessStream(sourceStream);
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public ReadableRandomAccessStream createReadOnlyFile() {
        return new ReadableRandomAccessSubstream(this.backingStream);
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public RandomAccessStream createReadWriteFile() {
        throw new UnsupportedOperationException("Not supported for this implementation.");
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public boolean isWritable() {
        return false;
    }

    public SynchronizedReadableRandomAccessStream getBackingStream() {
        return this.backingStream;
    }
}
