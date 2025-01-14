package defpackage;

import java.util.Arrays;
import java.util.Scanner;
/* renamed from: TestBTree  reason: default package */
/* loaded from: TestBTree.class */
public class TestBTree {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        for (int i2 = 0; i2 < nextInt; i2++) {
            BTree<Integer> readIntTree = LibBTree.readIntTree(scanner);
            System.out.println("numberNodes = " + readIntTree.numberNodes());
            System.out.println("depth = " + readIntTree.depth());
            System.out.println("contains(2) = " + readIntTree.contains(2));
            System.out.println("contains(3) = " + readIntTree.contains(3));
            System.out.println(Arrays.toString(ED240.paths(readIntTree)));
        }
    }
}
