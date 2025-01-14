package org.catacombae.jparted.lib.ps;

import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemRecognizer.class */
public interface PartitionSystemRecognizer {
    boolean detect(ReadableRandomAccessStream readableRandomAccessStream, long j, long j2);
}
