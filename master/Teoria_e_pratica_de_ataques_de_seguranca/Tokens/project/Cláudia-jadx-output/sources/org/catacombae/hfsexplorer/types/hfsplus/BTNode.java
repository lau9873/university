package org.catacombae.hfsexplorer.types.hfsplus;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/BTNode.class */
public abstract class BTNode {
    protected final BTNodeDescriptor nodeDescriptor;

    public BTNode(byte[] data, int offset, int nodeSize) {
        this.nodeDescriptor = new BTNodeDescriptor(data, offset);
    }

    public BTNodeDescriptor getNodeDescriptor() {
        return this.nodeDescriptor;
    }
}
