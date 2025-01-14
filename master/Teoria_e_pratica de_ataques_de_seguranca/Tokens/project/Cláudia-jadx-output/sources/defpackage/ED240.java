package defpackage;
/* renamed from: ED240  reason: default package */
/* loaded from: ED240.class */
class ED240 {
    static String[] path;
    static int min;
    static int count;
    static int pos;

    ED240() {
    }

    public static String[] paths(BTree<Integer> bTree) {
        min = bTree.getRoot().getValue().intValue();
        count = 0;
        min(bTree.getRoot());
        path = new String[count];
        pos = 0;
        paths(bTree, bTree.getRoot(), "");
        return path;
    }

    public static void min(BTNode<Integer> bTNode) {
        if (bTNode == null) {
            return;
        }
        if (bTNode.getValue().intValue() < min) {
            min = bTNode.getValue().intValue();
            count = 0;
        }
        if (bTNode.getValue().intValue() == min) {
            count++;
        }
        min(bTNode.getLeft());
        min(bTNode.getRight());
    }

    public static void paths(BTree<Integer> bTree, BTNode<Integer> bTNode, String str) {
        if (bTNode == null) {
            return;
        }
        paths(bTree, bTNode.getLeft(), str + "E");
        if (bTNode != bTree.getRoot() && bTNode.getValue().intValue() == min) {
            path[pos] = str;
            pos++;
        }
        paths(bTree, bTNode.getRight(), str + "D");
        if (bTNode == bTree.getRoot() && bTNode.getValue().intValue() == min) {
            path[pos] = "R";
            pos++;
        }
    }
}
