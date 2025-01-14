package org.catacombae.jparted.lib.fs;

import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemRecognizer.class */
public interface FileSystemRecognizer {
    boolean detect(ReadableRandomAccessStream readableRandomAccessStream, long j, long j2);
}
