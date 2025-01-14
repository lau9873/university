package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTHeaderRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTHeaderRec.class */
public class BTHeaderRec {
    public static final byte kHFSCaseFolding = -49;
    public static final byte kHFSBinaryCompare = -68;
    private final byte[] treeDepth = new byte[2];
    private final byte[] rootNode = new byte[4];
    private final byte[] leafRecords = new byte[4];
    private final byte[] firstLeafNode = new byte[4];
    private final byte[] lastLeafNode = new byte[4];
    private final byte[] nodeSize = new byte[2];
    private final byte[] maxKeyLength = new byte[2];
    private final byte[] totalNodes = new byte[4];
    private final byte[] freeNodes = new byte[4];
    private final byte[] reserved1 = new byte[2];
    private final byte[] clumpSize = new byte[4];
    private final byte[] btreeType = new byte[1];
    private final byte[] keyCompareType = new byte[1];
    private final byte[] attributes = new byte[4];
    private final byte[] reserved3 = new byte[64];

    public BTHeaderRec(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.treeDepth, 0, 2);
        System.arraycopy(data, offset + 2, this.rootNode, 0, 4);
        System.arraycopy(data, offset + 6, this.leafRecords, 0, 4);
        System.arraycopy(data, offset + 10, this.firstLeafNode, 0, 4);
        System.arraycopy(data, offset + 14, this.lastLeafNode, 0, 4);
        System.arraycopy(data, offset + 18, this.nodeSize, 0, 2);
        System.arraycopy(data, offset + 20, this.maxKeyLength, 0, 2);
        System.arraycopy(data, offset + 22, this.totalNodes, 0, 4);
        System.arraycopy(data, offset + 26, this.freeNodes, 0, 4);
        System.arraycopy(data, offset + 30, this.reserved1, 0, 2);
        System.arraycopy(data, offset + 32, this.clumpSize, 0, 4);
        System.arraycopy(data, offset + 36, this.btreeType, 0, 1);
        System.arraycopy(data, offset + 37, this.keyCompareType, 0, 1);
        System.arraycopy(data, offset + 38, this.attributes, 0, 4);
        System.arraycopy(data, offset + 42, this.reserved3, 0, 64);
    }

    public short getTreeDepth() {
        return Util.readShortBE(this.treeDepth);
    }

    public int getRootNode() {
        return Util.readIntBE(this.rootNode);
    }

    public int getLeafRecords() {
        return Util.readIntBE(this.leafRecords);
    }

    public int getFirstLeafNode() {
        return Util.readIntBE(this.firstLeafNode);
    }

    public int getLastLeafNode() {
        return Util.readIntBE(this.lastLeafNode);
    }

    public short getNodeSize() {
        return Util.readShortBE(this.nodeSize);
    }

    public short getMaxKeyLength() {
        return Util.readShortBE(this.maxKeyLength);
    }

    public int getTotalNodes() {
        return Util.readIntBE(this.totalNodes);
    }

    public int getFreeNodes() {
        return Util.readIntBE(this.freeNodes);
    }

    public short getReserved1() {
        return Util.readShortBE(this.reserved1);
    }

    public int getClumpSize() {
        return Util.readIntBE(this.clumpSize);
    }

    public byte getBtreeType() {
        return Util.readByteBE(this.btreeType);
    }

    public byte getKeyCompareType() {
        return Util.readByteBE(this.keyCompareType);
    }

    public int getAttributes() {
        return Util.readIntBE(this.attributes);
    }

    public int[] getReserved3() {
        return Util.readIntArrayBE(this.reserved3);
    }

    public boolean isBTBadCloseSet() {
        return Util.getBit(getAttributes(), 0);
    }

    public boolean isBTBigKeysSet() {
        return Util.getBit(getAttributes(), 1);
    }

    public boolean isBTVariableIndexKeysSet() {
        return Util.getBit(getAttributes(), 2);
    }

    public static int length() {
        return 106;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " treeDepth: " + ((int) getTreeDepth()));
        ps.println(prefix + " rootNode: " + getRootNode());
        ps.println(prefix + " leafRecords: " + getLeafRecords());
        ps.println(prefix + " firstLeafNode: " + getFirstLeafNode());
        ps.println(prefix + " lastLeafNode: " + getLastLeafNode());
        ps.println(prefix + " nodeSize: " + ((int) getNodeSize()));
        ps.println(prefix + " maxKeyLength: " + ((int) getMaxKeyLength()));
        ps.println(prefix + " totalNodes: " + getTotalNodes());
        ps.println(prefix + " freeNodes: " + getFreeNodes());
        ps.println(prefix + " reserved1: " + ((int) getReserved1()));
        ps.println(prefix + " clumpSize: " + getClumpSize());
        ps.println(prefix + " btreeType: " + ((int) getBtreeType()));
        ps.println(prefix + " keyCompareType: " + ((int) getKeyCompareType()));
        ps.println(prefix + " attributes: " + getAttributes());
        ps.println(prefix + " reserved3: " + getReserved3());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "BTHeaderRec:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.treeDepth, 0, result, 0, this.treeDepth.length);
        int offset = 0 + this.treeDepth.length;
        System.arraycopy(this.rootNode, 0, result, offset, this.rootNode.length);
        int offset2 = offset + this.rootNode.length;
        System.arraycopy(this.leafRecords, 0, result, offset2, this.leafRecords.length);
        int offset3 = offset2 + this.leafRecords.length;
        System.arraycopy(this.firstLeafNode, 0, result, offset3, this.firstLeafNode.length);
        int offset4 = offset3 + this.firstLeafNode.length;
        System.arraycopy(this.lastLeafNode, 0, result, offset4, this.lastLeafNode.length);
        int offset5 = offset4 + this.lastLeafNode.length;
        System.arraycopy(this.nodeSize, 0, result, offset5, this.nodeSize.length);
        int offset6 = offset5 + this.nodeSize.length;
        System.arraycopy(this.maxKeyLength, 0, result, offset6, this.maxKeyLength.length);
        int offset7 = offset6 + this.maxKeyLength.length;
        System.arraycopy(this.totalNodes, 0, result, offset7, this.totalNodes.length);
        int offset8 = offset7 + this.totalNodes.length;
        System.arraycopy(this.freeNodes, 0, result, offset8, this.freeNodes.length);
        int offset9 = offset8 + this.freeNodes.length;
        System.arraycopy(this.reserved1, 0, result, offset9, this.reserved1.length);
        int offset10 = offset9 + this.reserved1.length;
        System.arraycopy(this.clumpSize, 0, result, offset10, this.clumpSize.length);
        int offset11 = offset10 + this.clumpSize.length;
        System.arraycopy(this.btreeType, 0, result, offset11, this.btreeType.length);
        int offset12 = offset11 + this.btreeType.length;
        System.arraycopy(this.keyCompareType, 0, result, offset12, this.keyCompareType.length);
        int offset13 = offset12 + this.keyCompareType.length;
        System.arraycopy(this.attributes, 0, result, offset13, this.attributes.length);
        int offset14 = offset13 + this.attributes.length;
        System.arraycopy(this.reserved3, 0, result, offset14, this.reserved3.length);
        int length = offset14 + this.reserved3.length;
        return result;
    }
}
