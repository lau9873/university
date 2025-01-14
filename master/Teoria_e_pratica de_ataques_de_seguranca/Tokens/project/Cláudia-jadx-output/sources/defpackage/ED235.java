package defpackage;

import java.util.Scanner;
/* renamed from: ED235  reason: default package */
/* loaded from: ED235.class */
public class ED235 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        for (int i2 = 0; i2 < nextInt; i2++) {
            int nextInt2 = scanner.nextInt();
            for (int i3 = nextInt2; i3 > 0; i3--) {
                for (int i4 = 0; i4 < i3; i4++) {
                    System.out.print('#');
                }
                for (int i5 = 0; i5 < nextInt2 - i3; i5++) {
                    System.out.print('.');
                }
                System.out.println();
            }
        }
    }
}
