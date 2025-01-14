package defpackage;

import java.util.Scanner;
/* renamed from: ED243  reason: default package */
/* loaded from: ED243.class */
public class ED243 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int i2 = 0;
        int[] iArr = new int[nextInt];
        for (int i3 = 0; i3 < nextInt; i3++) {
            iArr[i3] = scanner.nextInt();
        }
        scanner.nextLine();
        int nextInt2 = scanner.nextInt();
        scanner.nextLine();
        boolean z = false;
        for (int i4 = 0; i4 < nextInt2; i4++) {
            int nextInt3 = scanner.nextInt();
            for (int i5 = 0; i5 < nextInt3; i5++) {
                int nextInt4 = scanner.nextInt();
                for (int i6 = 0; i6 < nextInt; i6++) {
                    if (iArr[i6] == nextInt4) {
                        z = true;
                    }
                }
            }
            if (z) {
                z = false;
                i2++;
            }
        }
        System.out.println(nextInt2 - i2);
    }
}
