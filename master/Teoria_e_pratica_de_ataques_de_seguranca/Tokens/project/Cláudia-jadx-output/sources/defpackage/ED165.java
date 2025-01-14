package defpackage;

import java.util.Scanner;
/* renamed from: ED165  reason: default package */
/* loaded from: ED165.class */
public class ED165 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        BSTree bSTree = new BSTree();
        int[] iArr = new int[nextInt];
        for (int i2 = 0; i2 < nextInt; i2++) {
            iArr[i2] = scanner.nextInt();
        }
        for (int i3 = 0; i3 < nextInt; i3++) {
            for (int i4 = 0; i4 < nextInt; i4++) {
                bSTree.insert(Integer.valueOf(iArr[i3] + iArr[i4]));
            }
        }
        int nextInt2 = scanner.nextInt();
        for (int i5 = 0; i5 < nextInt2; i5++) {
            int nextInt3 = scanner.nextInt();
            System.out.print(nextInt3);
            if (bSTree.contains(Integer.valueOf(nextInt3))) {
                System.out.println(" :sim");
            } else {
                System.out.println(" :nao");
            }
        }
    }
}
