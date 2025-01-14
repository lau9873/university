package org.catacombae.hfsexplorer.fs;

import org.catacombae.hfsexplorer.fs.StringCodec;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/MutableStringCodec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/MutableStringCodec.class */
public class MutableStringCodec<A extends StringCodec> implements StringCodec {
    private A underlying;

    public MutableStringCodec(A initialDecoder) {
        if (initialDecoder == null) {
            throw new IllegalArgumentException("Can not construct a MutableStringDecoder with a null initial decoder.");
        }
        this.underlying = initialDecoder;
    }

    @Override // org.catacombae.hfsexplorer.fs.StringCodec
    public String decode(byte[] data) {
        return this.underlying.decode(data);
    }

    @Override // org.catacombae.hfsexplorer.fs.StringCodec
    public String decode(byte[] data, int off, int len) {
        return this.underlying.decode(data, off, len);
    }

    @Override // org.catacombae.hfsexplorer.fs.StringCodec
    public byte[] encode(String str) {
        return this.underlying.encode(str);
    }

    @Override // org.catacombae.hfsexplorer.fs.StringCodec
    public byte[] encode(String str, int off, int len) {
        return this.underlying.encode(str, off, len);
    }

    public void setDecoder(A newDecoder) {
        this.underlying = newDecoder;
    }

    public A getDecoder() {
        return this.underlying;
    }
}
