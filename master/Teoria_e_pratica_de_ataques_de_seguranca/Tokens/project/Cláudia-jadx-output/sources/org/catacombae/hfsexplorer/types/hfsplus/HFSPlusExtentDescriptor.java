package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentDescriptor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusExtentDescriptor.class */
public class HFSPlusExtentDescriptor implements StructElements {
    private final byte[] startBlock;
    private final byte[] blockCount;

    public HFSPlusExtentDescriptor(byte[] data, int offset) {
        this.startBlock = new byte[4];
        this.blockCount = new byte[4];
        System.arraycopy(data, offset, this.startBlock, 0, 4);
        System.arraycopy(data, offset + 4, this.blockCount, 0, 4);
    }

    public HFSPlusExtentDescriptor(int startBlock, int blockCount) {
        this.startBlock = new byte[4];
        this.blockCount = new byte[4];
        System.arraycopy(Util.toByteArrayBE(startBlock), 0, this.startBlock, 0, 4);
        System.arraycopy(Util.toByteArrayBE(blockCount), 0, this.blockCount, 0, 4);
    }

    public static int getSize() {
        return 8;
    }

    public int getStartBlock() {
        return Util.readIntBE(this.startBlock);
    }

    public int getBlockCount() {
        return Util.readIntBE(this.blockCount);
    }

    public void print(PrintStream ps, int pregap) {
        String pregapString = "";
        for (int i2 = 0; i2 < pregap; i2++) {
            pregapString = pregapString + " ";
        }
        print(ps, pregapString);
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "startBlock: " + getStartBlock());
        ps.println(prefix + "blockCount: " + getBlockCount());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getBytes() {
        byte[] result = new byte[getSize()];
        System.arraycopy(this.startBlock, 0, result, 0, this.startBlock.length);
        int offset = 0 + this.startBlock.length;
        System.arraycopy(this.blockCount, 0, result, offset, this.blockCount.length);
        int length = offset + this.blockCount.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder sb = new StructElements.DictionaryBuilder(HFSPlusExtentDescriptor.class.getSimpleName());
        sb.addUIntBE("startBlock", this.startBlock);
        sb.addUIntBE("blockCount", this.blockCount);
        return sb.getResult();
    }
}
