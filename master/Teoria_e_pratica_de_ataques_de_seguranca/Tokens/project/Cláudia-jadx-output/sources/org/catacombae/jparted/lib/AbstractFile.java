package org.catacombae.jparted.lib;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/AbstractFile.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/AbstractFile.class */
public interface AbstractFile {
    void seek(long j);

    int read();

    int read(byte[] bArr);

    int read(byte[] bArr, int i2, int i3);

    void readFully(byte[] bArr);

    void readFully(byte[] bArr, int i2, int i3);

    long length();

    long getFilePointer();

    void close();
}
