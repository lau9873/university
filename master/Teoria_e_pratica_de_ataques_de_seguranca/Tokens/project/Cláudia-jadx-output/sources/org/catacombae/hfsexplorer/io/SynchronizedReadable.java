package org.catacombae.hfsexplorer.io;

import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/SynchronizedReadable.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/SynchronizedReadable.class */
public interface SynchronizedReadable {
    int readFrom(long j) throws RuntimeIOException;

    int readFrom(long j, byte[] bArr) throws RuntimeIOException;

    int readFrom(long j, byte[] bArr, int i2, int i3) throws RuntimeIOException;

    void readFullyFrom(long j, byte[] bArr) throws RuntimeIOException;

    void readFullyFrom(long j, byte[] bArr, int i2, int i3) throws RuntimeIOException;

    long skipFrom(long j, long j2) throws RuntimeIOException;

    long remainingLength() throws RuntimeIOException;
}
