package defpackage;

import java.util.Arrays;
import java.util.Scanner;
/* renamed from: Cardinais  reason: default package */
/* loaded from: Cardinais.class */
public class Cardinais {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int nextInt2 = scanner.nextInt();
        scanner.nextLine();
        String[] strArr2 = new String[nextInt];
        char[][] cArr = new char[nextInt][nextInt2];
        int[] iArr = new int[nextInt2 * 4 * nextInt];
        int i2 = 0;
        for (int i3 = 0; i3 < nextInt; i3++) {
            strArr2[i3] = scanner.nextLine();
        }
        for (int i4 = 0; i4 < nextInt; i4++) {
            for (int i5 = 0; i5 < nextInt2; i5++) {
                cArr[i4][i5] = strArr2[i4].charAt(i5);
            }
        }
        for (int i6 = 0; i6 < nextInt; i6++) {
            for (int i7 = 0; i7 < nextInt2; i7++) {
                if (cArr[i6][i7] == '.') {
                    i2++;
                }
                if (cArr[i6][i7] == '#') {
                    int i8 = i2;
                    iArr[i8] = iArr[i8] + 1;
                }
            }
            i2++;
        }
        for (int i9 = 0; i9 < nextInt2; i9++) {
            for (int i10 = 0; i10 < nextInt; i10++) {
                if (cArr[i10][i9] == '.') {
                    i2++;
                }
                if (cArr[i10][i9] == '#') {
                    int i11 = i2;
                    iArr[i11] = iArr[i11] + 1;
                }
            }
            i2++;
        }
        Arrays.sort(iArr);
        int i12 = iArr[((nextInt2 * nextInt) * 4) - 1];
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i14 < nextInt2 * nextInt * 4) {
                if (iArr[i14] != i12) {
                    i14++;
                } else {
                    i13 = i14;
                    break;
                }
            } else {
                break;
            }
        }
        System.out.print(i12 + " " + (((nextInt2 * nextInt) * 4) - i13));
        System.out.println();
    }
}
