package defpackage;

import java.util.Scanner;
/* renamed from: ED201  reason: default package */
/* loaded from: ED201.class */
public class ED201 {
    static int duracao;
    static int N;
    static int[] list;
    static int playlist;
    static int maxSoFar;

    static int sets(int[] iArr) {
        return goSets(0, iArr, new boolean[iArr.length]);
    }

    static int goSets(int i2, int[] iArr, boolean[] zArr) {
        if (i2 == iArr.length) {
            playlist = 0;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (zArr[i3]) {
                    playlist += iArr[i3];
                }
            }
            if (maxSoFar < playlist && playlist <= duracao) {
                maxSoFar = playlist;
            }
        } else {
            zArr[i2] = true;
            goSets(i2 + 1, iArr, zArr);
            zArr[i2] = false;
            goSets(i2 + 1, iArr, zArr);
        }
        return maxSoFar;
    }

    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        duracao = scanner.nextInt();
        N = scanner.nextInt();
        list = new int[N];
        int i2 = 0;
        maxSoFar = 0;
        for (int i3 = 0; i3 < N; i3++) {
            list[i3] = scanner.nextInt();
            i2 += list[i3];
        }
        if (i2 <= duracao) {
            System.out.println(i2);
        } else {
            System.out.println(sets(list));
        }
    }
}
