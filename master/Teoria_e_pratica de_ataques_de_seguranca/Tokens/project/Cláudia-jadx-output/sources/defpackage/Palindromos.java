package defpackage;

import java.util.Scanner;
/* renamed from: Palindromos  reason: default package */
/* loaded from: Palindromos.class */
public class Palindromos {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        System.out.println(nextInt);
        scanner.nextLine();
        for (int i2 = 0; i2 < nextInt; i2++) {
            System.out.println(isPalindrome(scanner.nextLine()));
        }
    }

    static String isPalindrome(String str) {
        String str2 = "";
        String str3 = "";
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (Character.isLetter(str.charAt(i2))) {
                str3 = str3 + str.charAt(i2);
            }
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (Character.isLetter(str.charAt(length))) {
                str2 = str2 + str.charAt(length);
            }
        }
        if (str3.toUpperCase().equals(str2.toUpperCase())) {
            return "sim";
        }
        return "nao";
    }
}
