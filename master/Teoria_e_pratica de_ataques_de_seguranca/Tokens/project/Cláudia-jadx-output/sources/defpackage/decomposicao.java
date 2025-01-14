package defpackage;
/* renamed from: decomposicao  reason: default package */
/* loaded from: decomposicao.class */
public class decomposicao {
    static boolean isPrime(int i2) {
        for (int i3 = 2; i3 * i3 <= i2; i3++) {
            if (i2 % i3 == 0) {
                return false;
            }
        }
        return true;
    }

    static void decompor(int i2) {
        if (isPrime(i2)) {
            System.out.print(i2 + " é primo!");
        } else {
            System.out.print(i2 + " = ");
            for (int i3 = 2; i3 <= i2; i3++) {
                if (i2 % i3 == 0 && isPrime(i3)) {
                    int i4 = i3;
                    while (true) {
                        int i5 = i4;
                        if (i2 % i5 == 0) {
                            System.out.print(i3 + "*");
                            i4 = i5 + i5;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] strArr) {
        decompor(20);
        decompor(70);
        decompor(7);
    }
}
