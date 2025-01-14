package org.catacombae.hfsexplorer.io;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/RandomAccessChannel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/RandomAccessChannel.class */
public interface RandomAccessChannel extends ReadableByteChannel {
    long position() throws IOException;

    FileChannel position(long j) throws IOException;

    long size() throws IOException;
}
