package defpackage;
/* renamed from: ED212  reason: default package */
/* loaded from: ED212.class */
class ED212 {
    ED212() {
    }

    public static int[] sumLevels(BTree<Integer> bTree) {
        int depth = bTree.depth() + 1;
        int[] iArr = new int[depth];
        for (int i2 = 0; i2 < depth; i2++) {
            iArr[i2] = sumLevel(bTree, i2, bTree.getRoot(), 0);
        }
        return iArr;
    }

    public static int sumLevel(BTree<Integer> bTree, int i2, BTNode<Integer> bTNode, int i3) {
        if (bTNode == bTree.getRoot()) {
            i3 = 0;
        }
        if (bTNode == null) {
            return 0;
        }
        if (i3 == i2) {
            return bTNode.getValue().intValue();
        }
        return sumLevel(bTree, i2, bTNode.getLeft(), i3 + 1) + sumLevel(bTree, i2, bTNode.getRight(), i3 + 1);
    }
}
