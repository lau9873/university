package defpackage;
/* renamed from: ED213  reason: default package */
/* loaded from: ED213.class */
public class ED213 {
    static int maxSoFar;
    static String bestPath;

    public static String maxSum(BTree<Integer> bTree) {
        maxSoFar = 0;
        maxSum(bTree.getRoot(), 0, "");
        return bestPath;
    }

    public static void maxSum(BTNode<Integer> bTNode, int i2, String str) {
        if (bTNode == null) {
            return;
        }
        int intValue = i2 + bTNode.getValue().intValue();
        if (bTNode.getLeft() == null && bTNode.getRight() == null && maxSoFar < intValue) {
            maxSoFar = intValue;
            bestPath = str;
        }
        maxSum(bTNode.getLeft(), intValue, str + "E");
        maxSum(bTNode.getRight(), intValue, str + "D");
    }
}
