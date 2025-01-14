package defpackage;

import java.util.Scanner;
/* renamed from: Count  reason: default package */
/* loaded from: Count.class */
public class Count {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int i2 = 0;
        while (scanner.hasNext()) {
            i2++;
            System.out.println(i2 + ": " + scanner.next());
        }
    }
}
