package org.catacombae.hfsexplorer.testcode;

import java.io.RandomAccessFile;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentLeafNode;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/ParseExtentLeafNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/ParseExtentLeafNode.class */
public class ParseExtentLeafNode {
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(args[0], "r");
        byte[] data = new byte[(int) raf.length()];
        raf.readFully(data);
        raf.close();
        HFSPlusExtentLeafNode node = new HFSPlusExtentLeafNode(data, 0, data.length);
        node.print(System.out, "");
        System.out.println("Leaf record offsets:");
        short[] offsets = node.getLeafRecordOffsets();
        for (short s : offsets) {
            System.out.println("  " + (s & 65535));
        }
    }
}
