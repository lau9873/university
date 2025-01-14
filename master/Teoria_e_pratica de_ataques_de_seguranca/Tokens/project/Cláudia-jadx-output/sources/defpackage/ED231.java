package defpackage;

import java.util.Scanner;
/* renamed from: ED231  reason: default package */
/* loaded from: ED231.class */
public class ED231 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int[] iArr = new int[nextInt];
        int[] iArr2 = new int[nextInt];
        float[] fArr = new float[nextInt];
        int[] iArr3 = new int[nextInt];
        scanner.nextLine();
        iArr[0] = scanner.nextInt();
        for (int i2 = 1; i2 < nextInt; i2++) {
            iArr[i2] = scanner.nextInt();
            iArr2[i2] = iArr[i2] - iArr[i2 - 1];
            fArr[i2] = (iArr2[i2] / iArr[i2 - 1]) * 100.0f;
        }
        int i3 = iArr2[1];
        int i4 = i3;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < nextInt; i7++) {
            if (i3 < iArr2[i7]) {
                i3 = iArr2[i7];
            }
            if (iArr2[i7] < i4) {
                i4 = iArr2[i7];
            }
            if (fArr[i7] <= 5.0f) {
                i5++;
            }
            if (fArr[i7] > 5.0f && i5 != 0) {
                iArr3[i7] = i5;
                i5 = 0;
                i6++;
            }
        }
        if (i5 != 0) {
            i6++;
        }
        iArr3[nextInt - 1] = i5;
        int i8 = 0;
        for (int i9 = 0; i9 < nextInt; i9++) {
            if (iArr3[i9] > i8) {
                i8 = iArr3[i9];
            }
        }
        scanner.nextLine();
        int nextInt2 = scanner.nextInt();
        if (nextInt2 == 1) {
            System.out.print(i4 + " " + i3);
        }
        if (nextInt2 == 2) {
            System.out.print(i6 + " " + i8);
        }
        if (nextInt2 == 3) {
            for (int i10 = iArr[nextInt - 1] / 100; i10 > 0; i10--) {
                for (int i11 = 0; i11 < nextInt; i11++) {
                    if (iArr[i11] / (i10 * 100) != 0) {
                        System.out.print("#");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        }
    }
}
