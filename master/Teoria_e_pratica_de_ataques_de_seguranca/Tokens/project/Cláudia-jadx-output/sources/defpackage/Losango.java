package defpackage;

import java.util.Scanner;
/* renamed from: Losango  reason: default package */
/* loaded from: Losango.class */
public class Losango {
    public static void main(String[] strArr) {
        linha(new Scanner(System.in).nextInt());
    }

    static void linha(int i2) {
        if (i2 % 2 == 0) {
            System.out.println(i2 + "???? Isso não é ímpar.....");
            return;
        }
        for (int i3 = 1; i3 <= (i2 - 1) / 2; i3++) {
            for (int i4 = 1; i4 <= ((i2 + 1) / 2) - i3; i4++) {
                System.out.print(".");
            }
            for (int i5 = 1; i5 <= (2 * i3) - 1; i5++) {
                System.out.print("#");
            }
            for (int i6 = 1; i6 < ((i2 + 1) / 2) - i3; i6++) {
                System.out.print(".");
            }
            System.out.println(".");
        }
        for (int i7 = 1; i7 < i2; i7++) {
            System.out.print("#");
        }
        System.out.println("#");
        for (int i8 = (i2 - 1) / 2; i8 > 0; i8--) {
            for (int i9 = 1; i9 <= ((i2 + 1) / 2) - i8; i9++) {
                System.out.print(".");
            }
            for (int i10 = 1; i10 <= (2 * i8) - 1; i10++) {
                System.out.print("#");
            }
            for (int i11 = 1; i11 < ((i2 + 1) / 2) - i8; i11++) {
                System.out.print(".");
            }
            System.out.println(".");
        }
    }
}
