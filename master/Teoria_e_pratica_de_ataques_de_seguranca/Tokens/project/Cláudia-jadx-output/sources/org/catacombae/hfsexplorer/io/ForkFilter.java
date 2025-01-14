package org.catacombae.hfsexplorer.io;

import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSForkData;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusForkData;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/ForkFilter.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/ForkFilter.class */
public class ForkFilter implements ReadableRandomAccessStream {
    private final long forkLength;
    private final CommonHFSExtentDescriptor[] extentDescriptors;
    private final ReadableRandomAccessStream sourceFile;
    private final long fsOffset;
    private final long allocationBlockSize;
    private final long firstBlockByteOffset;
    private long logicalPosition;
    private long lastLogicalPos;
    private long lastPhysicalPos;

    public ForkFilter(CommonHFSForkData forkData, CommonHFSExtentDescriptor[] extentDescriptors, ReadableRandomAccessStream sourceFile, long fsOffset, long allocationBlockSize, long firstBlockByteOffset) {
        this(forkData.getLogicalSize(), extentDescriptors, sourceFile, fsOffset, allocationBlockSize, firstBlockByteOffset);
    }

    public ForkFilter(long forkLength, CommonHFSExtentDescriptor[] extentDescriptors, ReadableRandomAccessStream sourceFile, long fsOffset, long allocationBlockSize, long firstBlockByteOffset) {
        this.forkLength = forkLength;
        this.extentDescriptors = (CommonHFSExtentDescriptor[]) Util.arrayCopy(extentDescriptors, new CommonHFSExtentDescriptor[extentDescriptors.length]);
        this.sourceFile = sourceFile;
        this.fsOffset = fsOffset;
        this.allocationBlockSize = allocationBlockSize;
        this.firstBlockByteOffset = firstBlockByteOffset;
        this.logicalPosition = 0L;
        this.lastLogicalPos = -1L;
        this.lastPhysicalPos = 0L;
    }

    @Deprecated
    public ForkFilter(HFSPlusForkData forkData, HFSPlusExtentDescriptor[] extentDescriptors, ReadableRandomAccessStream sourceFile, long fsOffset, long allocationBlockSize, long firstBlockByteOffset) {
        this.forkLength = forkData.getLogicalSize();
        this.extentDescriptors = new CommonHFSExtentDescriptor[extentDescriptors.length];
        for (int i2 = 0; i2 < this.extentDescriptors.length; i2++) {
            this.extentDescriptors[i2] = CommonHFSExtentDescriptor.create(extentDescriptors[i2]);
        }
        this.sourceFile = sourceFile;
        this.fsOffset = fsOffset;
        this.allocationBlockSize = allocationBlockSize;
        this.firstBlockByteOffset = firstBlockByteOffset;
        this.logicalPosition = 0L;
        this.lastLogicalPos = -1L;
        this.lastPhysicalPos = 0L;
    }

    @Override // org.catacombae.io.RandomAccess
    public void seek(long pos) {
        this.logicalPosition = pos;
    }

    @Override // org.catacombae.io.Readable
    public int read() {
        byte[] oneByte = new byte[1];
        if (read(oneByte) == 1) {
            return oneByte[0] & 255;
        }
        return -1;
    }

    @Override // org.catacombae.io.Readable
    public int read(byte[] data) {
        return read(data, 0, data.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0079, code lost:
        if (r7.logicalPosition == r7.lastLogicalPos) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007c, code lost:
        r7.sourceFile.seek(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0098, code lost:
        if (r7.sourceFile.getFilePointer() == r7.lastPhysicalPos) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009b, code lost:
        r7.sourceFile.seek(r7.lastPhysicalPos);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a8, code lost:
        r0 = r7.forkLength - r7.logicalPosition;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b8, code lost:
        if (r0 >= r10) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bb, code lost:
        r0 = (int) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c1, code lost:
        r0 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c2, code lost:
        r20 = r0;
        r21 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cf, code lost:
        if (r15 >= r7.extentDescriptors.length) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d2, code lost:
        r0 = (r7.extentDescriptors[r15].getBlockCount() * r7.allocationBlockSize) - r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f0, code lost:
        if (r0 >= r21) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f3, code lost:
        r0 = (int) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f9, code lost:
        r0 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00fb, code lost:
        r25 = r0;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0100, code lost:
        r26 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0104, code lost:
        if (r26 >= r25) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0107, code lost:
        r0 = r25 - r26;
        r0 = (r9 + (r20 - r21)) + r26;
        r0 = r7.sourceFile.read(r8, r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x012c, code lost:
        if (r0 <= 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x012f, code lost:
        r0 = r26 + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0139, code lost:
        r7.lastPhysicalPos = r7.sourceFile.getFilePointer();
        r0 = r0 - r9;
        r7.logicalPosition += r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x015a, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x015e, code lost:
        r21 = r21 - r26;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x016a, code lost:
        if (r21 != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0170, code lost:
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0176, code lost:
        r7.lastPhysicalPos = r7.sourceFile.getFilePointer();
        r7.logicalPosition += r20 - r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0196, code lost:
        if (r21 >= r20) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01a2, code lost:
        return r20 - r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01a3, code lost:
        return -1;
     */
    @Override // org.catacombae.io.Readable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.catacombae.hfsexplorer.io.ForkFilter.read(byte[], int, int):int");
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data) {
        readFully(data, 0, data.length);
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data, int offset, int length) {
        int i2 = 0;
        while (true) {
            int bytesRead = i2;
            if (bytesRead < length) {
                int curBytesRead = read(data, bytesRead, length - bytesRead);
                if (curBytesRead > 0) {
                    i2 = bytesRead + curBytesRead;
                } else {
                    throw new RuntimeException("Couldn't read the entire length.");
                }
            } else {
                return;
            }
        }
    }

    @Override // org.catacombae.io.RandomAccess
    public long length() {
        return this.forkLength;
    }

    @Override // org.catacombae.io.RandomAccess
    public long getFilePointer() {
        return this.logicalPosition;
    }

    public ReadableRandomAccessStream getUnderlyingStream() {
        return this.sourceFile;
    }

    @Override // org.catacombae.io.Stream
    public void close() {
    }
}
