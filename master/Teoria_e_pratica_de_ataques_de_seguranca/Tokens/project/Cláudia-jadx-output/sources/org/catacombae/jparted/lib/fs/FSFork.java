package org.catacombae.jparted.lib.fs;

import java.io.InputStream;
import java.io.OutputStream;
import org.catacombae.io.RandomAccessStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.TruncatableRandomAccessStream;
import org.catacombae.io.WritableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSFork.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSFork.class */
public abstract class FSFork {
    private final FSFile parent;

    public abstract long getLength();

    public abstract boolean isWritable();

    public abstract boolean isTruncatable();

    public abstract String getForkIdentifier();

    public abstract InputStream getInputStream();

    public abstract ReadableRandomAccessStream getReadableRandomAccessStream();

    public abstract WritableRandomAccessStream getWritableRandomAccessStream() throws UnsupportedOperationException;

    public abstract RandomAccessStream getRandomAccessStream() throws UnsupportedOperationException;

    public abstract OutputStream getOutputStream() throws UnsupportedOperationException;

    public abstract TruncatableRandomAccessStream getForkStream() throws UnsupportedOperationException;

    /* JADX INFO: Access modifiers changed from: protected */
    public FSFork(FSFile iParent) {
        this.parent = iParent;
    }
}
