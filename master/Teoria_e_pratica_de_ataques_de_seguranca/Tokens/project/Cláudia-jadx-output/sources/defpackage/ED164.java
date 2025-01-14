package defpackage;

import java.util.Scanner;
/* renamed from: ED164  reason: default package */
/* loaded from: ED164.class */
public class ED164 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        BSTree bSTree = new BSTree();
        int nextInt = scanner.nextInt();
        scanner.nextLine();
        for (int i2 = 0; i2 < nextInt; i2++) {
            bSTree.insert(scanner.next());
        }
        System.out.println(bSTree.numberNodes());
    }
}
