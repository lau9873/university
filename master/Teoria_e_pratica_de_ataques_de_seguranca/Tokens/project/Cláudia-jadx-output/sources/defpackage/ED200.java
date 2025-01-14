package defpackage;

import java.util.Scanner;
/* renamed from: ED200  reason: default package */
/* loaded from: ED200.class */
public class ED200 {
    static int L;
    static int C;
    static char[][] placa;
    static boolean[][] visited;

    static int t(int i2, int i3) {
        if (i2 < 0 || i2 >= L || i3 < 0 || i3 >= C || visited[i2][i3] || placa[i2][i3] == '.') {
            return 0;
        }
        visited[i2][i3] = true;
        return 1 + t(i2 - 1, i3 + 1) + t(i2 - 1, i3) + t(i2 - 1, i3 - 1) + t(i2, i3 + 1) + t(i2, i3 - 1) + t(i2 + 1, i3) + t(i2 + 1, i3 + 1) + t(i2 + 1, i3 - 1);
    }

    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        for (int i2 = 0; i2 < nextInt; i2++) {
            L = scanner.nextInt();
            C = scanner.nextInt();
            scanner.nextLine();
            placa = new char[L][C];
            visited = new boolean[L][C];
            for (int i3 = 0; i3 < L; i3++) {
                placa[i3] = scanner.nextLine().toCharArray();
            }
            int i4 = 0;
            for (int i5 = 0; i5 < L; i5++) {
                for (int i6 = 0; i6 < C; i6++) {
                    int t = t(i5, i6);
                    if (i4 < t) {
                        i4 = t;
                    }
                }
            }
            System.out.println(i4);
        }
    }
}
