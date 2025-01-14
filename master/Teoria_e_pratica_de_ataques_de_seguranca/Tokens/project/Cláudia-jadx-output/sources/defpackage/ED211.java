package defpackage;
/* renamed from: ED211  reason: default package */
/* loaded from: ED211.class */
class ED211 {
    static int count;

    ED211() {
    }

    public static int countEven(BTree<Integer> bTree) {
        count = 0;
        countEven(bTree.getRoot());
        return count;
    }

    public static void countEven(BTNode<Integer> bTNode) {
        if (bTNode == null) {
            return;
        }
        if (bTNode.getValue().intValue() % 2 == 0) {
            count++;
        }
        countEven(bTNode.getLeft());
        countEven(bTNode.getRight());
    }
}
