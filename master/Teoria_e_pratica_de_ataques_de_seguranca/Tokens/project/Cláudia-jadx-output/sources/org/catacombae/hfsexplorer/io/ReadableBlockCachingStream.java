package org.catacombae.hfsexplorer.io;

import java.util.HashMap;
import org.catacombae.io.ReadableFilterStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/ReadableBlockCachingStream.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/ReadableBlockCachingStream.class */
public class ReadableBlockCachingStream extends ReadableFilterStream {
    private static final long TIME_TO_KEEP_IN_CACHE = 5000;
    private final int blockSize;
    private long virtualFP;
    private final long virtualLength;
    private final HashMap<Long, BlockStore> blockMap;
    private final BlockStore[] cache;
    private boolean closed;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/io/ReadableBlockCachingStream$BlockStore.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/io/ReadableBlockCachingStream$BlockStore.class */
    public static class BlockStore {
        public final long blockNumber;
        public long accessCount = 0;
        public long lastAccessTime = Long.MAX_VALUE;
        public byte[] data = null;

        public BlockStore(long blockNumber) {
            this.blockNumber = blockNumber;
        }
    }

    public ReadableBlockCachingStream(ReadableRandomAccessStream backing, int blockSize, int maxItemCount) {
        super(backing);
        long length;
        this.blockMap = new HashMap<>();
        this.closed = false;
        if (backing == null) {
            throw new IllegalArgumentException("backing can not be null");
        }
        if (blockSize <= 0) {
            throw new IllegalArgumentException("blockSize must be positive and non-zero");
        }
        if (maxItemCount < 1) {
            throw new IllegalArgumentException("maxItemCount must be at least 1");
        }
        this.blockSize = blockSize;
        try {
            length = backing.length();
        } catch (Exception e2) {
            length = -1;
        }
        if (length > 0) {
            this.virtualLength = length;
        } else {
            this.virtualLength = -1L;
        }
        int actualItemCount = maxItemCount;
        if (this.virtualLength > 0 && actualItemCount * blockSize > this.virtualLength) {
            actualItemCount = (int) ((this.virtualLength / blockSize) + (this.virtualLength % ((long) blockSize) != 0 ? 1 : 0));
        }
        this.cache = new BlockStore[actualItemCount];
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.RandomAccess
    public void seek(long pos) {
        if (this.closed) {
            throw new RuntimeException("File is closed.");
        }
        if ((this.virtualLength == -1 || pos < this.virtualLength) && pos >= 0) {
            this.virtualFP = pos;
            return;
        }
        throw new IllegalArgumentException("pos out of range (pos=" + pos + ",virtualLength=" + this.virtualLength + ")");
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.Readable
    public int read() {
        byte[] b2 = new byte[1];
        int res = read(b2, 0, 1);
        if (res == 1) {
            return b2[0] & 255;
        }
        return -1;
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.Readable
    public int read(byte[] data) {
        return read(data, 0, data.length);
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.Readable
    public int read(byte[] data, int pos, int len) {
        if (this.closed) {
            throw new RuntimeException("File is closed.");
        }
        int bytesProcessed = 0;
        while (bytesProcessed < len) {
            byte[] blockData = getCachedBlock(this.virtualFP);
            int posInBlock = (int) (this.virtualFP - ((this.virtualFP / this.blockSize) * this.blockSize));
            int bytesLeftInBlock = blockData.length - posInBlock;
            int bytesLeftInTransfer = len - bytesProcessed;
            int bytesToCopy = bytesLeftInTransfer < bytesLeftInBlock ? bytesLeftInTransfer : bytesLeftInBlock;
            System.arraycopy(blockData, posInBlock, data, pos + bytesProcessed, bytesToCopy);
            bytesProcessed += bytesToCopy;
            this.virtualFP += bytesToCopy;
        }
        return bytesProcessed;
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.Readable
    public void readFully(byte[] data) {
        readFully(data, 0, data.length);
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.Readable
    public void readFully(byte[] data, int offset, int length) {
        int i2 = 0;
        while (true) {
            int bytesRead = i2;
            if (bytesRead < length) {
                int curBytesRead = read(data, offset + bytesRead, length - bytesRead);
                if (curBytesRead <= 0) {
                    throw new RuntimeException("Couldn't read the entire length.");
                }
                i2 = bytesRead + curBytesRead;
            } else {
                return;
            }
        }
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.RandomAccess
    public long length() {
        if (this.closed) {
            throw new RuntimeException("File is closed.");
        }
        return this.virtualLength;
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.RandomAccess
    public long getFilePointer() {
        if (this.closed) {
            throw new RuntimeException("File is closed.");
        }
        return this.virtualFP;
    }

    @Override // org.catacombae.io.ReadableFilterStream, org.catacombae.io.Stream
    public void close() {
        this.closed = true;
        this.backingStore.close();
    }

    private byte[] getCachedBlock(long filePointer) {
        byte[] data;
        long blockNumber = filePointer / this.blockSize;
        BlockStore cur = this.blockMap.get(Long.valueOf(blockNumber));
        if (cur == null) {
            cur = new BlockStore(blockNumber);
            this.blockMap.put(Long.valueOf(blockNumber), cur);
        }
        cur.accessCount++;
        cur.lastAccessTime = System.currentTimeMillis();
        if (cur.data != null) {
            return cur.data;
        }
        BlockStore lastCacheEntry = this.cache[this.cache.length - 1];
        this.cache[this.cache.length - 1] = null;
        byte[] recoveredData = null;
        if (lastCacheEntry != null) {
            recoveredData = lastCacheEntry.data;
            lastCacheEntry.data = null;
            if (recoveredData == null) {
                throw new RuntimeException("Entry in cache had a null array, which should never happen!");
            }
        }
        long blockPos = blockNumber * this.blockSize;
        long remainingSize = length() - blockPos;
        int dataSize = (int) (remainingSize < ((long) this.blockSize) ? remainingSize : this.blockSize);
        if (recoveredData != null && dataSize == recoveredData.length) {
            data = recoveredData;
        } else {
            data = new byte[dataSize <= 0 ? this.blockSize : dataSize];
        }
        this.backingStore.seek(blockPos);
        this.backingStore.read(data, 0, data.length);
        cur.data = data;
        this.cache[this.cache.length - 1] = cur;
        bubbleIntoPosition(this.cache, this.cache.length - 1);
        return cur.data;
    }

    private static void bubbleIntoPosition(BlockStore[] array, int startIndex) {
        long timestamp = System.currentTimeMillis();
        for (int i2 = startIndex; i2 >= 1; i2--) {
            BlockStore low = array[i2];
            BlockStore high = array[i2 - 1];
            if (high == null || low.accessCount > high.accessCount || timestamp - high.lastAccessTime >= 5000) {
                array[i2] = high;
                array[i2 - 1] = low;
            }
        }
    }

    public void preloadBlocks() {
        preloadBlocks(0, this.cache.length);
    }

    private void preloadBlocks(int startBlock, int blockCount) {
        for (int i2 = 0; i2 < blockCount; i2++) {
            System.err.println("Preloading block " + (startBlock + i2) + "...");
            getCachedBlock((startBlock + i2) * this.blockSize);
        }
    }
}
