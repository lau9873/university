package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTNodeDescriptor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTNodeDescriptor.class */
public class BTNodeDescriptor {
    public static final int BT_LEAF_NODE = -1;
    public static final int BT_INDEX_NODE = 0;
    public static final int BT_HEADER_NODE = 1;
    public static final int BT_MAP_NODE = 2;
    private static final int STRUCTSIZE = 14;
    private final byte[] fLink = new byte[4];
    private final byte[] bLink = new byte[4];
    private final byte[] kind = new byte[1];
    private final byte[] height = new byte[1];
    private final byte[] numRecords = new byte[2];
    private final byte[] reserved = new byte[2];

    public BTNodeDescriptor(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.fLink, 0, 4);
        System.arraycopy(data, offset + 4, this.bLink, 0, 4);
        System.arraycopy(data, offset + 8, this.kind, 0, 1);
        System.arraycopy(data, offset + 9, this.height, 0, 1);
        System.arraycopy(data, offset + 10, this.numRecords, 0, 2);
        System.arraycopy(data, offset + 12, this.reserved, 0, 2);
    }

    public static int length() {
        return 14;
    }

    public int getFLink() {
        return Util.readIntBE(this.fLink);
    }

    public int getBLink() {
        return Util.readIntBE(this.bLink);
    }

    public byte getKind() {
        return Util.readByteBE(this.kind);
    }

    public byte getHeight() {
        return Util.readByteBE(this.height);
    }

    public short getNumRecords() {
        return Util.readShortBE(this.numRecords);
    }

    public short getReserved() {
        return Util.readShortBE(this.reserved);
    }

    public String getKindAsString() {
        String result;
        byte kind = getKind();
        if (kind == -1) {
            result = "kBTLeafNode";
        } else if (kind == 0) {
            result = "kBTIndexNode";
        } else if (kind == 1) {
            result = "kBTHeaderNode";
        } else if (kind == 2) {
            result = "kBTMapNode";
        } else {
            result = "UNKNOWN!";
        }
        return result;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " fLink: " + getFLink() + "");
        ps.println(prefix + " bLink: " + getBLink() + "");
        ps.println(prefix + " kind: " + ((int) getKind()) + " (" + getKindAsString() + ")");
        ps.println(prefix + " height: " + ((int) getHeight()) + "");
        ps.println(prefix + " numRecords: " + ((int) getNumRecords()) + "");
        ps.println(prefix + " reserved: 0x" + Util.toHexStringBE(getReserved()) + "");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "BTNodeDescriptor:");
        printFields(ps, prefix);
    }
}
