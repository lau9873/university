package org.catacombae.hfsexplorer.io;

import org.catacombae.io.RandomAccess;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/SynchronizedReadableRandomAccess.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/SynchronizedReadableRandomAccess.class */
public interface SynchronizedReadableRandomAccess extends SynchronizedReadable, RandomAccess {
    void addReference(Object obj);

    void removeReference(Object obj);
}
