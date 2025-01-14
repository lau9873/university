package org.catacombae.hfsexplorer.io;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/WritableRandomAccessChannel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/WritableRandomAccessChannel.class */
public interface WritableRandomAccessChannel extends RandomAccessChannel, WritableByteChannel {
    FileChannel truncate(long j) throws IOException;
}
