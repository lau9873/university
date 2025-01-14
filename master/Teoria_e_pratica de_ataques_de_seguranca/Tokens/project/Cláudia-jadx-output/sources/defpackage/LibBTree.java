package defpackage;

import java.util.Scanner;
/* renamed from: LibBTree  reason: default package */
/* loaded from: LibBTree.class */
public class LibBTree {
    public static BTree<Integer> readIntTree(Scanner scanner) {
        BTree<Integer> bTree = new BTree<>();
        bTree.setRoot(readIntNode(scanner));
        return bTree;
    }

    private static BTNode<Integer> readIntNode(Scanner scanner) {
        String next = scanner.next();
        if (next.equals("N")) {
            return null;
        }
        return new BTNode<>(Integer.valueOf(Integer.parseInt(next)), readIntNode(scanner), readIntNode(scanner));
    }
}
