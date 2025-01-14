package defpackage;

import com.j256.ormlite.stmt.query.SimpleComparison;
/* renamed from: Strings  reason: default package */
/* loaded from: Strings.class */
public class Strings {
    public static void main(String[] strArr) {
        String str = "CC1007";
        String str2 = "CC1007";
        System.out.println("d = " + str);
        System.out.println("e = " + str2);
        System.out.println("d==e? " + (str == str2));
        System.out.println("d.equals(e)? " + str.equals(str2));
        System.out.println("tamanho de d = " + str.length());
        System.out.println("d.charAt(0) = " + str.charAt(0));
        System.out.println("d.charAt(2) = " + str.charAt(2));
        System.out.println("d.substring(1,4) = " + str.substring(1, 4));
        System.out.println("d.indexOf(7) = " + str.indexOf(55));
        System.out.println("abcd" + SimpleComparison.GREATER_THAN_OPERATION + "abcd".toUpperCase());
        System.out.println("AFdhd" + SimpleComparison.GREATER_THAN_OPERATION + "AFdhd".toLowerCase());
        System.out.println("hello?" + isPalindrome("hello"));
        System.out.println("bob?" + isPalindrome("bob"));
    }

    static boolean isPalindrome(String str) {
        String str2 = "";
        for (int length = str.length() - 1; length >= 0; length--) {
            str2 = str2 + str.charAt(length);
        }
        return str.equals(str2);
    }
}
