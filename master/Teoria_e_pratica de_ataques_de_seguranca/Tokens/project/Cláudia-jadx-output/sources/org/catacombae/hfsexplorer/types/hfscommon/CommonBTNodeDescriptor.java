package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.NodeDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.BTNodeDescriptor;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNodeDescriptor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNodeDescriptor.class */
public abstract class CommonBTNodeDescriptor {

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNodeDescriptor$NodeType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNodeDescriptor$NodeType.class */
    public enum NodeType {
        INDEX,
        HEADER,
        MAP,
        LEAF
    }

    public abstract long getForwardLink();

    public abstract long getBackwardLink();

    public abstract NodeType getNodeType();

    public abstract short getHeight();

    public abstract int getNumberOfRecords();

    public abstract void printFields(PrintStream printStream, String str);

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CommonBTNodeDescriptor:");
        printFields(ps, prefix);
    }

    public static CommonBTNodeDescriptor create(BTNodeDescriptor btnd) {
        return new HFSPlusImplementation(btnd);
    }

    public static CommonBTNodeDescriptor create(NodeDescriptor nd) {
        return new HFSImplementation(nd);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNodeDescriptor$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNodeDescriptor$HFSPlusImplementation.class */
    private static class HFSPlusImplementation extends CommonBTNodeDescriptor {
        private final BTNodeDescriptor btnd;

        public HFSPlusImplementation(BTNodeDescriptor btnd) {
            this.btnd = btnd;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public long getForwardLink() {
            return Util.unsign(this.btnd.getFLink());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public long getBackwardLink() {
            return Util.unsign(this.btnd.getBLink());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public NodeType getNodeType() {
            byte b2 = this.btnd.getKind();
            switch (b2) {
                case -1:
                    return NodeType.LEAF;
                case 0:
                    return NodeType.INDEX;
                case 1:
                    return NodeType.HEADER;
                case 2:
                    return NodeType.MAP;
                default:
                    throw new RuntimeException("Unknown node type: " + ((int) b2));
            }
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public short getHeight() {
            return Util.unsign(this.btnd.getHeight());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public int getNumberOfRecords() {
            return Util.unsign(this.btnd.getNumRecords());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + " btnd:");
            this.btnd.print(ps, prefix + "  ");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNodeDescriptor$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNodeDescriptor$HFSImplementation.class */
    public static class HFSImplementation extends CommonBTNodeDescriptor {
        private final NodeDescriptor nd;

        public HFSImplementation(NodeDescriptor nd) {
            this.nd = nd;
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public long getForwardLink() {
            return Util.unsign(this.nd.getNdFLink());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public long getBackwardLink() {
            return Util.unsign(this.nd.getNdBLink());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public NodeType getNodeType() {
            byte b2 = this.nd.getNdType();
            switch (b2) {
                case -1:
                    return NodeType.LEAF;
                case 0:
                    return NodeType.INDEX;
                case 1:
                    return NodeType.HEADER;
                case 2:
                    return NodeType.MAP;
                default:
                    throw new RuntimeException("Unknown node type: " + ((int) b2));
            }
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public short getHeight() {
            return Util.unsign(this.nd.getNdNHeight());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public int getNumberOfRecords() {
            return Util.unsign(this.nd.getNdNRecs());
        }

        @Override // org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor
        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + " nd:");
            this.nd.print(ps, prefix + "  ");
        }
    }
}
