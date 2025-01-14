package defpackage;

import java.util.Scanner;
/* renamed from: ED202  reason: default package */
/* loaded from: ED202.class */
public class ED202 {
    static int N;
    static float minSoFar = 1000000.0f;
    static float count;

    static float permutations(float[][] fArr, int i2) {
        return goPerm(0, fArr, new boolean[i2], new int[i2], i2);
    }

    static float goPerm(int i2, float[][] fArr, boolean[] zArr, int[] iArr, int i3) {
        if (i2 == i3) {
            count = fArr[iArr[0]][iArr[i3 - 1]];
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                count += fArr[iArr[i4 + 1]][iArr[i4]];
            }
            if (count < minSoFar) {
                minSoFar = count;
            }
        } else {
            for (int i5 = 0; i5 < i3; i5++) {
                if (!zArr[i5]) {
                    zArr[i5] = true;
                    iArr[i2] = i5;
                    goPerm(i2 + 1, fArr, zArr, iArr, i3);
                    zArr[i5] = false;
                }
            }
        }
        return minSoFar;
    }

    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        float[][] fArr = new float[N][N];
        for (int i2 = 0; i2 < N; i2++) {
            for (int i3 = 0; i3 < N; i3++) {
                fArr[i2][i3] = scanner.nextFloat();
            }
        }
        System.out.printf("%.2f%n", Float.valueOf(permutations(fArr, N)));
    }
}
