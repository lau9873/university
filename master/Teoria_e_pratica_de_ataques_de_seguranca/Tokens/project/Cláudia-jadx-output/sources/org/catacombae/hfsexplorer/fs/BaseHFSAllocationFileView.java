package org.catacombae.hfsexplorer.fs;

import java.util.Iterator;
import java.util.LinkedList;
import org.catacombae.hfsexplorer.ObjectContainer;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSAllocationFileView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSAllocationFileView.class */
public abstract class BaseHFSAllocationFileView {
    protected final BaseHFSFileSystemView parentView;
    protected final ReadableRandomAccessStream allocationFileStream;

    protected abstract CommonHFSExtentDescriptor createExtentDescriptor(long j, long j2) throws IllegalArgumentException;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseHFSAllocationFileView(BaseHFSFileSystemView parentView, ReadableRandomAccessStream allocationFileStream) {
        this.parentView = parentView;
        this.allocationFileStream = allocationFileStream;
        if (this.parentView == null) {
            throw new IllegalArgumentException("parentView == null");
        }
    }

    public synchronized boolean isAllocationBlockUsed(long blockNumber) throws IllegalArgumentException {
        CommonHFSVolumeHeader vh = this.parentView.getVolumeHeader();
        return isAllocationBlockUsed(blockNumber, vh);
    }

    private synchronized boolean isAllocationBlockUsed(long blockNumber, CommonHFSVolumeHeader vh) {
        long numAllocationBlocks = vh.getTotalBlocks();
        if (blockNumber >= numAllocationBlocks) {
            throw new IllegalArgumentException("Block number (" + blockNumber + ") is beyond the highest block of the volume (" + (numAllocationBlocks - 1) + ").");
        }
        long byteIndex = blockNumber / 8;
        this.allocationFileStream.seek(byteIndex);
        int currentByte = this.allocationFileStream.read();
        if (currentByte >= 0) {
            return (currentByte & (1 << ((int) (7 - (blockNumber % 8))))) != 0;
        }
        throw new RuntimeException("No data left in stream! allocationFileStream.getFilePointer()=" + this.allocationFileStream.getFilePointer() + " allocationFileStream.length()=" + this.allocationFileStream.length());
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [A, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v7, types: [A, java.lang.Long] */
    public long countBlocks(ObjectContainer<Long> oFreeBlocks, ObjectContainer<Long> oUsedBlocks, ObjectContainer<Boolean> stop) {
        CommonHFSVolumeHeader vh = this.parentView.getVolumeHeader();
        byte[] currentBlock = new byte[131072];
        long totalBlocks = vh.getTotalBlocks();
        long blockCount = 0;
        long usedBlockCount = 0;
        if (stop == null) {
            stop = new ObjectContainer<>(false);
        }
        this.allocationFileStream.seek(0L);
        while (blockCount < totalBlocks && !stop.o.booleanValue()) {
            int bytesRead = this.allocationFileStream.read(currentBlock);
            if (bytesRead >= 0) {
                for (int i2 = 0; i2 < bytesRead && blockCount < totalBlocks && !stop.o.booleanValue(); i2++) {
                    byte currentByte = currentBlock[i2];
                    for (int j = 0; j < 8 && blockCount < totalBlocks && !stop.o.booleanValue(); j++) {
                        blockCount++;
                        if (((currentByte >> (7 - j)) & 1) == 1) {
                            usedBlockCount++;
                        }
                    }
                }
            } else {
                throw new RuntimeException("Could not read all blocks from allocation file!");
            }
        }
        if (blockCount != totalBlocks) {
            throw new RuntimeException("[INTERNAL ERROR] blockCount(" + blockCount + ") != totalBlocks(" + totalBlocks + ")");
        }
        if (oFreeBlocks != null) {
            oFreeBlocks.o = Long.valueOf(blockCount - usedBlockCount);
        }
        if (oUsedBlocks != null) {
            oUsedBlocks.o = Long.valueOf(usedBlockCount);
        }
        return totalBlocks;
    }

    public synchronized CommonHFSExtentDescriptor[] findFreeSpace(long fileSize) {
        if (fileSize < 0) {
            throw new IllegalArgumentException("Negative file size: " + fileSize);
        }
        CommonHFSVolumeHeader vh = this.parentView.getVolumeHeader();
        long blockSize = vh.getAllocationBlockSize();
        long totalBlocks = vh.getTotalBlocks();
        long blocksToAllocate = (fileSize / blockSize) + (fileSize % blockSize != 0 ? 1 : 0);
        long blocksLeft = blocksToAllocate;
        ByteRegion closestMatchAbove = new ByteRegion();
        ByteRegion closestMatchBelow = new ByteRegion();
        LinkedList<ByteRegion> allocations = new LinkedList<>();
        while (blocksLeft > 0) {
            if (closestMatchAbove == null) {
                closestMatchAbove = new ByteRegion();
            }
            if (closestMatchBelow == null) {
                closestMatchBelow = new ByteRegion();
            }
            closestMatchAbove.reset();
            closestMatchBelow.reset();
            long regionStart = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= totalBlocks) {
                    break;
                }
                int j = 0;
                Iterator i$ = allocations.iterator();
                while (i$.hasNext()) {
                    ByteRegion br = i$.next();
                    if (i2 >= br.offset && i2 < br.offset + br.length) {
                        break;
                    }
                    j++;
                }
                if (j == allocations.size()) {
                    if (!isAllocationBlockUsed(i2, vh)) {
                        if (regionStart == -1) {
                            regionStart = i2;
                        }
                    } else {
                        if (regionStart != -1) {
                            long length = i2 - regionStart;
                            if (length > blocksLeft) {
                                if (closestMatchAbove.length < 0 || closestMatchAbove.length > length) {
                                    closestMatchAbove.offset = regionStart;
                                    closestMatchAbove.length = length;
                                }
                            } else if (length < blocksLeft) {
                                if (closestMatchBelow.length < 0 || closestMatchBelow.length < length) {
                                    closestMatchBelow.offset = regionStart;
                                    closestMatchBelow.length = length;
                                }
                            } else {
                                closestMatchAbove.offset = regionStart;
                                closestMatchAbove.length = length;
                                break;
                            }
                        }
                        regionStart = -1;
                    }
                }
                i2++;
            }
            if (closestMatchAbove.isValid()) {
                closestMatchAbove.length = blocksLeft;
                allocations.add(closestMatchAbove);
                blocksLeft = 0;
                closestMatchAbove = null;
            } else if (closestMatchBelow.isValid()) {
                allocations.add(closestMatchBelow);
                blocksLeft -= closestMatchBelow.length;
                closestMatchBelow = null;
            } else {
                return null;
            }
        }
        if (blocksLeft != 0) {
            throw new RuntimeException("[INTERNAL ERROR] blocksLeft(" + blocksLeft + ") != 0 [closestMatchAbove.offset=" + closestMatchAbove.offset + ",closestMatchAbove.length=" + closestMatchAbove.length + "]");
        }
        CommonHFSExtentDescriptor[] result = new CommonHFSExtentDescriptor[allocations.size()];
        int i3 = 0;
        Iterator i$2 = allocations.iterator();
        while (i$2.hasNext()) {
            ByteRegion br2 = i$2.next();
            int i4 = i3;
            i3++;
            result[i4] = createExtentDescriptor(br2.offset, br2.length);
        }
        return result;
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSAllocationFileView$ByteRegion.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/BaseHFSAllocationFileView$ByteRegion.class */
    private class ByteRegion {
        public long offset;
        public long length;

        private ByteRegion() {
        }

        public void reset() {
            this.offset = -1L;
            this.length = -1L;
        }

        public boolean isValid() {
            return this.offset > 0 && this.length > 0;
        }
    }
}
