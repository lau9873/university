package org.catacombae.hfsexplorer.fs;

import org.catacombae.hfsexplorer.fs.AppleSingleBuilder;
import org.catacombae.hfsexplorer.io.ReadableRandomAccessSubstream;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccessStream;
import org.catacombae.hfsexplorer.types.applesingle.AppleSingleHeader;
import org.catacombae.hfsexplorer.types.applesingle.EntryDescriptor;
import org.catacombae.io.ReadableConcatenatedStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.util.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleHandler.class */
public class AppleSingleHandler {
    private final SynchronizedReadableRandomAccessStream stream;

    public AppleSingleHandler(ReadableRandomAccessStream stream) {
        this(new SynchronizedReadableRandomAccessStream(stream));
    }

    public AppleSingleHandler(SynchronizedReadableRandomAccessStream stream) {
        this.stream = stream;
    }

    public AppleSingleHeader getHeader() {
        byte[] headerData = new byte[AppleSingleHeader.length()];
        this.stream.readFullyFrom(0L, headerData);
        return new AppleSingleHeader(headerData, 0);
    }

    public EntryDescriptor[] getEntryDescriptors() {
        AppleSingleHeader header = getHeader();
        long pos = AppleSingleHeader.length();
        EntryDescriptor[] result = new EntryDescriptor[Util.unsign(header.getNumEntries())];
        byte[] descriptorData = new byte[EntryDescriptor.length()];
        for (int i2 = 0; i2 < result.length; i2++) {
            this.stream.readFullyFrom(pos, descriptorData);
            pos += EntryDescriptor.length();
            result[i2] = new EntryDescriptor(descriptorData, 0);
        }
        return result;
    }

    public ReadableRandomAccessStream getEntryStream(EntryDescriptor descriptor) {
        long pos = Util.unsign(descriptor.getEntryOffset());
        long len = Util.unsign(descriptor.getEntryLength());
        return new ReadableConcatenatedStream(new ReadableRandomAccessSubstream(this.stream), pos, len);
    }

    public static AppleSingleBuilder.FileType detectFileFormat(ReadableRandomAccessStream stream, long offset) {
        byte[] magicBytes = new byte[4];
        stream.seek(offset);
        stream.readFully(magicBytes);
        int magic = Util.readIntBE(magicBytes);
        AppleSingleBuilder.FileType[] arr$ = AppleSingleBuilder.FileType.values();
        for (AppleSingleBuilder.FileType f2 : arr$) {
            if (f2.getMagic() == magic) {
                return f2;
            }
        }
        return null;
    }

    public EntryDescriptor getResourceEntryDescriptor() {
        EntryDescriptor[] arr$ = getEntryDescriptors();
        for (EntryDescriptor descriptor : arr$) {
            if (descriptor.getEntryId() == AppleSingleBuilder.EntryType.RESOURCE_FORK.getTypeNumber()) {
                return descriptor;
            }
        }
        return null;
    }
}
