package defpackage;
/* renamed from: Primes  reason: default package */
/* loaded from: Primes.class */
public class Primes {
    static boolean isPrime(int i2) {
        for (int i3 = 2; i3 * i3 <= i2; i3++) {
            if (i2 % i3 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] strArr) {
        for (int i2 = 2; i2 <= 1000; i2++) {
            if (isPrime(i2)) {
                System.out.println(i2);
            }
        }
    }
}
