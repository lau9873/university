package org.catacombae.jparted.lib;

import java.io.File;
import org.catacombae.io.ConcatenatedStream;
import org.catacombae.io.FileStream;
import org.catacombae.io.RandomAccessStream;
import org.catacombae.io.ReadableConcatenatedStream;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/RandomAccessFileDataLocator.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/RandomAccessFileDataLocator.class */
public class RandomAccessFileDataLocator extends DataLocator {
    private final File file;
    private final Long pos;
    private final Long len;

    public RandomAccessFileDataLocator(String pPath) {
        this(new File(pPath));
    }

    public RandomAccessFileDataLocator(String pPath, long pPos, long pLen) {
        this(new File(pPath), pPos, pLen);
    }

    public RandomAccessFileDataLocator(File pFile) {
        this(pFile, (Long) null, (Long) null);
    }

    public RandomAccessFileDataLocator(File pFile, long pPos, long pLen) {
        this(pFile, new Long(pPos), new Long(pLen));
    }

    private RandomAccessFileDataLocator(File pFile, Long pPos, Long pLen) {
        if (!pFile.canRead()) {
            throw new RuntimeException("Can not read from file!");
        }
        this.file = pFile;
        this.pos = pPos;
        this.len = pLen;
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public ReadableRandomAccessStream createReadOnlyFile() {
        ReadableRandomAccessStream llf = new ReadableFileStream(this.file);
        if (this.pos != null && this.len != null) {
            return new ReadableConcatenatedStream(llf, this.pos.longValue(), this.len.longValue());
        }
        return llf;
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public RandomAccessStream createReadWriteFile() {
        RandomAccessStream wllf = new FileStream(this.file);
        if (this.pos != null && this.len != null) {
            return new ConcatenatedStream(wllf, this.pos.longValue(), this.len.longValue());
        }
        return wllf;
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public boolean isWritable() {
        return true;
    }
}
