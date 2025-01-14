package defpackage;

import java.util.Scanner;
/* renamed from: ReadNumbers  reason: default package */
/* loaded from: ReadNumbers.class */
public class ReadNumbers {
    static void writeArray(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            System.out.println("v[" + i2 + "] = " + iArr[i2]);
        }
    }

    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int[] iArr = new int[10];
        int nextInt = scanner.nextInt();
        for (int i2 = 0; i2 < nextInt; i2++) {
            iArr[i2] = scanner.nextInt();
        }
        writeArray(iArr);
    }
}
