package org.catacombae.hfsexplorer.fs;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.io.ReadableRandomAccessSubstream;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccess;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccessStream;
import org.catacombae.hfsexplorer.types.resff.ReferenceListEntry;
import org.catacombae.hfsexplorer.types.resff.ResourceHeader;
import org.catacombae.hfsexplorer.types.resff.ResourceMap;
import org.catacombae.io.ReadableConcatenatedStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/ResourceForkReader.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/ResourceForkReader.class */
public class ResourceForkReader {
    private final SynchronizedReadableRandomAccessStream trueForkStream;
    private final SynchronizedReadableRandomAccess forkStream;

    public ResourceForkReader(ReadableRandomAccessStream forkStream) {
        this.trueForkStream = new SynchronizedReadableRandomAccessStream(forkStream);
        this.forkStream = this.trueForkStream;
    }

    public void close() {
        this.trueForkStream.close();
    }

    public ResourceHeader getHeader() {
        byte[] headerData = new byte[ResourceHeader.length()];
        this.forkStream.readFullyFrom(0L, headerData);
        return new ResourceHeader(headerData, 0);
    }

    public ResourceMap getResourceMap() {
        ResourceHeader header = getHeader();
        return new ResourceMap(this.forkStream, Util.unsign(header.getMapOffset()));
    }

    public long getDataLength(ReferenceListEntry entry) {
        long dataPos = getDataPos(entry);
        return getDataLength(dataPos);
    }

    private long getDataPos(ReferenceListEntry entry) {
        ResourceHeader header = getHeader();
        return Util.unsign(header.getDataOffset()) + entry.getResourceDataOffset();
    }

    private long getDataLength(long dataPos) {
        byte[] dataLengthBytes = new byte[4];
        this.forkStream.readFrom(dataPos, dataLengthBytes);
        return Util.unsign(Util.readIntBE(dataLengthBytes));
    }

    public ReadableRandomAccessStream getResourceStream(ReferenceListEntry entry) {
        long dataPos = getDataPos(entry);
        long dataLength = getDataLength(dataPos);
        return new ReadableConcatenatedStream(new ReadableRandomAccessSubstream(this.forkStream), dataPos + 4, dataLength);
    }
}
