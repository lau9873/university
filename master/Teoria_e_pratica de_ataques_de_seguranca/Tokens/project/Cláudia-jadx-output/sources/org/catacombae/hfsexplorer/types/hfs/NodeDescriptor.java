package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/NodeDescriptor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/NodeDescriptor.class */
public class NodeDescriptor {
    public static final int STRUCTSIZE = 14;
    public static final byte ndIndxNode = 0;
    public static final byte ndHdrNode = 1;
    public static final byte ndMapNode = 2;
    public static final byte ndLeafNode = -1;
    private final byte[] ndFLink = new byte[4];
    private final byte[] ndBLink = new byte[4];
    private final byte[] ndType = new byte[1];
    private final byte[] ndNHeight = new byte[1];
    private final byte[] ndNRecs = new byte[2];
    private final byte[] ndResv2 = new byte[2];

    public NodeDescriptor(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.ndFLink, 0, 4);
        System.arraycopy(data, offset + 4, this.ndBLink, 0, 4);
        System.arraycopy(data, offset + 8, this.ndType, 0, 1);
        System.arraycopy(data, offset + 9, this.ndNHeight, 0, 1);
        System.arraycopy(data, offset + 10, this.ndNRecs, 0, 2);
        System.arraycopy(data, offset + 12, this.ndResv2, 0, 2);
    }

    public static int length() {
        return 14;
    }

    public int getNdFLink() {
        return Util.readIntBE(this.ndFLink);
    }

    public int getNdBLink() {
        return Util.readIntBE(this.ndBLink);
    }

    public byte getNdType() {
        return Util.readByteBE(this.ndType);
    }

    public byte getNdNHeight() {
        return Util.readByteBE(this.ndNHeight);
    }

    public short getNdNRecs() {
        return Util.readShortBE(this.ndNRecs);
    }

    public short getNdResv2() {
        return Util.readShortBE(this.ndResv2);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " ndFLink: " + getNdFLink());
        ps.println(prefix + " ndBLink: " + getNdBLink());
        ps.println(prefix + " ndType: " + ((int) getNdType()));
        ps.println(prefix + " ndNHeight: " + ((int) getNdNHeight()));
        ps.println(prefix + " ndNRecs: " + ((int) getNdNRecs()));
        ps.println(prefix + " ndResv2: " + ((int) getNdResv2()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "NodeDescriptor:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[14];
        System.arraycopy(this.ndFLink, 0, result, 0, this.ndFLink.length);
        int offset = 0 + this.ndFLink.length;
        System.arraycopy(this.ndBLink, 0, result, offset, this.ndBLink.length);
        int offset2 = offset + this.ndBLink.length;
        System.arraycopy(this.ndType, 0, result, offset2, this.ndType.length);
        int offset3 = offset2 + this.ndType.length;
        System.arraycopy(this.ndNHeight, 0, result, offset3, this.ndNHeight.length);
        int offset4 = offset3 + this.ndNHeight.length;
        System.arraycopy(this.ndNRecs, 0, result, offset4, this.ndNRecs.length);
        int offset5 = offset4 + this.ndNRecs.length;
        System.arraycopy(this.ndResv2, 0, result, offset5, this.ndResv2.length);
        int length = offset5 + this.ndResv2.length;
        return result;
    }
}
