package defpackage;
/* renamed from: Square  reason: default package */
/* loaded from: Square.class */
public class Square {
    static void line(char c2, char c3, int i2) {
        System.out.print(c2);
        for (int i3 = 1; i3 <= i2 - 2; i3++) {
            System.out.print(c3);
        }
        System.out.println(c2);
    }

    public static void main(String[] strArr) {
        square(6);
    }

    static void square(int i2) {
        line('*', '-', i2);
        for (int i3 = 1; i3 <= i2 - 2; i3++) {
            line('|', '.', i2);
        }
        line('*', '-', i2);
    }
}
