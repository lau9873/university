package defpackage;

import java.util.Scanner;
/* renamed from: ED198c  reason: default package */
/* loaded from: ED198c.class */
public class ED198c {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int[] iArr = new int[nextInt];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = scanner.nextInt();
        }
        int[] iArr2 = new int[nextInt];
        iArr2[0] = iArr[0];
        int i3 = iArr[0];
        for (int i4 = 0; i4 < nextInt - 1; i4++) {
            if (iArr2[i4] >= 0) {
                iArr2[i4 + 1] = iArr2[i4] + iArr[i4 + 1];
            } else {
                iArr2[i4 + 1] = iArr[i4 + 1];
            }
            if (i3 < iArr2[i4]) {
                i3 = iArr2[i4];
            }
        }
        System.out.println(i3);
    }
}
