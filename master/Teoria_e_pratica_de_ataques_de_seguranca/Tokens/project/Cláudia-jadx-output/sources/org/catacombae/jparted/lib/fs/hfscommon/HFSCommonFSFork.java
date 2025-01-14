package org.catacombae.jparted.lib.fs.hfscommon;

import java.io.InputStream;
import java.io.OutputStream;
import org.catacombae.hfsexplorer.io.ReadableRandomAccessInputStream;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccessStream;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkData;
import org.catacombae.io.RandomAccessStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.TruncatableRandomAccessStream;
import org.catacombae.io.WritableRandomAccessStream;
import org.catacombae.jparted.lib.fs.FSFork;
import org.catacombae.jparted.lib.fs.FSForkType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSFork.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSFork.class */
public class HFSCommonFSFork extends FSFork {
    private final HFSCommonFSFile parent;
    private final FSForkType type;
    private final CommonHFSForkData forkData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HFSCommonFSFork(HFSCommonFSFile iParent, FSForkType iType, CommonHFSForkData iForkData) {
        super(iParent);
        if (iParent == null) {
            throw new IllegalArgumentException("iParent must not be null!");
        }
        if (iType == null) {
            throw new IllegalArgumentException("iType must not be null!");
        }
        if (iType != FSForkType.DATA && iType != FSForkType.MACOS_RESOURCE) {
            throw new IllegalArgumentException("iType is unsupported!");
        }
        if (iForkData == null) {
            throw new IllegalArgumentException("iForkData must not be null!");
        }
        this.parent = iParent;
        this.type = iType;
        this.forkData = iForkData;
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public long getLength() {
        return this.forkData.getLogicalSize();
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public boolean isWritable() {
        return false;
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public boolean isTruncatable() {
        return false;
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public String getForkIdentifier() {
        switch (this.type) {
            case DATA:
                return "Data fork";
            case MACOS_RESOURCE:
                return "Resource fork";
            default:
                throw new RuntimeException("INTERNAL ERROR: Incorrect fork type: " + this.type);
        }
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public InputStream getInputStream() {
        return new ReadableRandomAccessInputStream(new SynchronizedReadableRandomAccessStream(getReadableRandomAccessStream()));
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public ReadableRandomAccessStream getReadableRandomAccessStream() {
        switch (this.type) {
            case DATA:
                return this.parent.getReadableDataForkStream();
            case MACOS_RESOURCE:
                return this.parent.getReadableResourceForkStream();
            default:
                throw new RuntimeException("INTERNAL ERROR: Incorrect fork type: " + this.type);
        }
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public WritableRandomAccessStream getWritableRandomAccessStream() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public RandomAccessStream getRandomAccessStream() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public OutputStream getOutputStream() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // org.catacombae.jparted.lib.fs.FSFork
    public TruncatableRandomAccessStream getForkStream() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
