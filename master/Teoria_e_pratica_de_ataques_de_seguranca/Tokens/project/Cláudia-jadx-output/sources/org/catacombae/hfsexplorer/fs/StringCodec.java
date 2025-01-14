package org.catacombae.hfsexplorer.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/StringCodec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/StringCodec.class */
public interface StringCodec {
    String decode(byte[] bArr);

    String decode(byte[] bArr, int i2, int i3);

    byte[] encode(String str);

    byte[] encode(String str, int i2, int i3);
}
