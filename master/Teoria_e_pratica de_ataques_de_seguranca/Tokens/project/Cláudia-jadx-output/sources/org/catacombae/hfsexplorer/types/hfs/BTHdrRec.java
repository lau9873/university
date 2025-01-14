package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/BTHdrRec.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/BTHdrRec.class */
public class BTHdrRec {
    public static final int STRUCTSIZE = 106;
    private final byte[] bthDepth = new byte[2];
    private final byte[] bthRoot = new byte[4];
    private final byte[] bthNRecs = new byte[4];
    private final byte[] bthFNode = new byte[4];
    private final byte[] bthLNode = new byte[4];
    private final byte[] bthNodeSize = new byte[2];
    private final byte[] bthKeyLen = new byte[2];
    private final byte[] bthNNodes = new byte[4];
    private final byte[] bthFree = new byte[4];
    private final byte[] bthResv = new byte[76];

    public BTHdrRec(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.bthDepth, 0, 2);
        System.arraycopy(data, offset + 2, this.bthRoot, 0, 4);
        System.arraycopy(data, offset + 6, this.bthNRecs, 0, 4);
        System.arraycopy(data, offset + 10, this.bthFNode, 0, 4);
        System.arraycopy(data, offset + 14, this.bthLNode, 0, 4);
        System.arraycopy(data, offset + 18, this.bthNodeSize, 0, 2);
        System.arraycopy(data, offset + 20, this.bthKeyLen, 0, 2);
        System.arraycopy(data, offset + 22, this.bthNNodes, 0, 4);
        System.arraycopy(data, offset + 26, this.bthFree, 0, 4);
        System.arraycopy(data, offset + 30, this.bthResv, 0, 76);
    }

    public static int length() {
        return 106;
    }

    public short getBthDepth() {
        return Util.readShortBE(this.bthDepth);
    }

    public int getBthRoot() {
        return Util.readIntBE(this.bthRoot);
    }

    public int getBthNRecs() {
        return Util.readIntBE(this.bthNRecs);
    }

    public int getBthFNode() {
        return Util.readIntBE(this.bthFNode);
    }

    public int getBthLNode() {
        return Util.readIntBE(this.bthLNode);
    }

    public short getBthNodeSize() {
        return Util.readShortBE(this.bthNodeSize);
    }

    public short getBthKeyLen() {
        return Util.readShortBE(this.bthKeyLen);
    }

    public int getBthNNodes() {
        return Util.readIntBE(this.bthNNodes);
    }

    public int getBthFree() {
        return Util.readIntBE(this.bthFree);
    }

    public byte[] getBthResv() {
        return Util.readByteArrayBE(this.bthResv);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " bthDepth: " + ((int) getBthDepth()));
        ps.println(prefix + " bthRoot: " + getBthRoot());
        ps.println(prefix + " bthNRecs: " + getBthNRecs());
        ps.println(prefix + " bthFNode: " + getBthFNode());
        ps.println(prefix + " bthLNode: " + getBthLNode());
        ps.println(prefix + " bthNodeSize: " + ((int) getBthNodeSize()));
        ps.println(prefix + " bthKeyLen: " + ((int) getBthKeyLen()));
        ps.println(prefix + " bthNNodes: " + getBthNNodes());
        ps.println(prefix + " bthFree: " + getBthFree());
        ps.println(prefix + " bthResv: " + getBthResv());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "BTHdrRec:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[106];
        System.arraycopy(this.bthDepth, 0, result, 0, this.bthDepth.length);
        int offset = 0 + this.bthDepth.length;
        System.arraycopy(this.bthRoot, 0, result, offset, this.bthRoot.length);
        int offset2 = offset + this.bthRoot.length;
        System.arraycopy(this.bthNRecs, 0, result, offset2, this.bthNRecs.length);
        int offset3 = offset2 + this.bthNRecs.length;
        System.arraycopy(this.bthFNode, 0, result, offset3, this.bthFNode.length);
        int offset4 = offset3 + this.bthFNode.length;
        System.arraycopy(this.bthLNode, 0, result, offset4, this.bthLNode.length);
        int offset5 = offset4 + this.bthLNode.length;
        System.arraycopy(this.bthNodeSize, 0, result, offset5, this.bthNodeSize.length);
        int offset6 = offset5 + this.bthNodeSize.length;
        System.arraycopy(this.bthKeyLen, 0, result, offset6, this.bthKeyLen.length);
        int offset7 = offset6 + this.bthKeyLen.length;
        System.arraycopy(this.bthNNodes, 0, result, offset7, this.bthNNodes.length);
        int offset8 = offset7 + this.bthNNodes.length;
        System.arraycopy(this.bthFree, 0, result, offset8, this.bthFree.length);
        int offset9 = offset8 + this.bthFree.length;
        System.arraycopy(this.bthResv, 0, result, offset9, this.bthResv.length);
        int length = offset9 + this.bthResv.length;
        return result;
    }
}
