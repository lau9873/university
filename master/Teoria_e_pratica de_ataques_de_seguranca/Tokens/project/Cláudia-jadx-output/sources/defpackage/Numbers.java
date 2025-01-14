package defpackage;
/* renamed from: Numbers  reason: default package */
/* loaded from: Numbers.class */
public class Numbers {
    public static void main(String[] strArr) {
        System.out.print("Numeros de 1 a 500: ");
        for (int i2 = 1; i2 <= 500 - 1; i2++) {
            System.out.print(i2 + ",");
        }
        System.out.println(500);
        int i3 = 0;
        for (int i4 = 1; i4 <= 500; i4++) {
            i3 += i4;
        }
        System.out.println("Soma = " + i3);
    }
}
