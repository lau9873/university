package defpackage;

import java.util.Scanner;
/* JADX WARN: Classes with same name are omitted:
  ED198 2.class
 */
/* renamed from: ED198  reason: default package */
/* loaded from: ED198.class */
public class ED198 {
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
