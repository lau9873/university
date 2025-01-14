package org.catacombae.udif;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import org.catacombae.dmgextractor.Debug;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/PlistPartition.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/udif/PlistPartition.class */
public class PlistPartition {
    private String name;
    private String id;
    private String attributes;
    private UDIFBlock[] blockList;
    private long partitionSize;
    private final long previousOutOffset;
    private final long previousInOffset;
    private long finalOutOffset;
    private long finalInOffset;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/PlistPartition$BlockIterator.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/udif/PlistPartition$BlockIterator.class */
    private class BlockIterator implements Iterator<UDIFBlock> {
        private UDIFBlock[] blocks;
        private int pointer;
        private int endOffset;

        public BlockIterator(PlistPartition plistPartition, UDIFBlock[] blocks) {
            this(blocks, 0, blocks.length);
        }

        public BlockIterator(UDIFBlock[] blocks, int offset, int length) {
            this.blocks = blocks;
            this.pointer = offset;
            this.endOffset = offset + length;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pointer < this.endOffset;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public UDIFBlock next() {
            UDIFBlock[] uDIFBlockArr = this.blocks;
            int i2 = this.pointer;
            this.pointer = i2 + 1;
            return uDIFBlockArr[i2];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public PlistPartition(String name, String id, String attributes, byte[] data, long previousOutOffset, long previousInOffset) throws IOException {
        this(name, id, attributes, new ByteArrayInputStream(data), previousOutOffset, previousInOffset);
    }

    public PlistPartition(String name, String id, String attributes, InputStream data, long previousOutOffset, long previousInOffset) throws IOException {
        this.finalOutOffset = -1L;
        this.finalInOffset = -1L;
        this.name = name;
        this.id = id;
        this.attributes = attributes;
        this.previousOutOffset = previousOutOffset;
        this.previousInOffset = previousInOffset;
        this.blockList = parseBlocks(data);
        this.partitionSize = calculatePartitionSize(this.blockList);
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    public String getAttributes() {
        return this.attributes;
    }

    public long getPartitionSize() {
        return this.partitionSize;
    }

    public UDIFBlock[] getBlocks() {
        UDIFBlock[] res = new UDIFBlock[this.blockList.length];
        for (int i2 = 0; i2 < res.length; i2++) {
            res[i2] = this.blockList[i2];
        }
        return res;
    }

    public Iterator<UDIFBlock> getBlockIterator() {
        return new BlockIterator(this, this.blockList);
    }

    public int getBlockCount() {
        return this.blockList.length;
    }

    public long getFinalOutOffset() {
        if (this.finalOutOffset < 0) {
            throw new RuntimeException("parseBlocks has not yet been called!");
        }
        return this.finalOutOffset;
    }

    public long getFinalInOffset() {
        if (this.finalInOffset < 0) {
            throw new RuntimeException("parseBlocks has not yet been called!");
        }
        return this.finalInOffset;
    }

    private UDIFBlock[] parseBlocks(InputStream is) throws IOException {
        UDIFBlock currentBlock;
        long bytesSkipped = is.read(new byte[204]);
        if (bytesSkipped != 204) {
            throw new RuntimeException("Could not skip the desired amount of bytes...");
        }
        int blockNumber = 0;
        long lastByteReadInBlock = -1;
        boolean addInOffset = false;
        byte[] blockData = new byte[UDIFBlock.structSize()];
        LinkedList<UDIFBlock> blocks = new LinkedList<>();
        do {
            int bytesRead = is.read(blockData);
            if (bytesRead != -1) {
                if (bytesRead != blockData.length) {
                    throw new RuntimeException("Could not read the desired amount of bytes... (desired: " + blockData.length + " read: " + bytesRead + ")");
                }
                long inOffset = UDIFBlock.peekInOffset(blockData, 0);
                long inSize = UDIFBlock.peekInSize(blockData, 0);
                long outOffsetCompensation = this.previousOutOffset;
                if (lastByteReadInBlock == -1) {
                    lastByteReadInBlock = inOffset;
                }
                lastByteReadInBlock += inSize;
                if (inOffset == 0 && blockNumber == 0) {
                    Debug.notification("Detected inOffset == 0, setting addInOffset flag.");
                    addInOffset = true;
                }
                long inOffsetCompensation = 0;
                if (addInOffset) {
                    Debug.notification("addInOffset mode: inOffset tranformation " + inOffset + "->" + (inOffset + this.previousInOffset));
                    inOffsetCompensation = this.previousInOffset;
                }
                currentBlock = new UDIFBlock(blockData, 0, outOffsetCompensation, inOffsetCompensation);
                blocks.add(currentBlock);
                blockNumber++;
            } else {
                throw new RuntimeException("No BT_END block found!");
            }
        } while (currentBlock.getBlockType() != -1);
        this.finalOutOffset = currentBlock.getTrueOutOffset();
        this.finalInOffset = this.previousInOffset + lastByteReadInBlock;
        if (is.read() != -1) {
            Debug.warning("Encountered additional data in blkx blob.");
        }
        return (UDIFBlock[]) blocks.toArray(new UDIFBlock[blocks.size()]);
    }

    public static long calculatePartitionSize(UDIFBlock[] data) throws IOException {
        long partitionSize = 0;
        for (UDIFBlock db : data) {
            partitionSize += db.getOutSize();
        }
        return partitionSize;
    }
}
