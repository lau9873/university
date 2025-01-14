package defpackage;

import java.util.Scanner;
/* renamed from: ED198a  reason: default package */
/* loaded from: ED198a.class */
public class ED198a {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int[] iArr = new int[nextInt];
        scanner.nextLine();
        for (int i2 = 0; i2 < nextInt; i2++) {
            iArr[i2] = scanner.nextInt();
        }
        int[] iArr2 = new int[nextInt];
        int i3 = iArr[0];
        iArr2[0] = iArr[0];
        for (int i4 = 1; i4 < nextInt; i4++) {
            if (iArr2[i4 - 1] > 0) {
                iArr2[i4] = iArr2[i4 - 1] + iArr[i4];
            }
            if (iArr2[i4 - 1] <= 0) {
                iArr2[i4] = iArr[i4];
            }
            if (iArr2[i4] > i3) {
                i3 = iArr2[i4];
            }
        }
        System.out.println(i3);
    }
}
