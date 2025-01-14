package defpackage;

import java.util.Scanner;
/* renamed from: Activator  reason: default package */
/* loaded from: activator.jar:Activator.class */
public class Activator {
    private static Boolean isValidSerialNumber(String str) {
        String[] split = str.split("-");
        if (split.length != 4) {
            return false;
        }
        Integer valueOf = Integer.valueOf(Integer.parseInt(split[0], 16));
        Integer valueOf2 = Integer.valueOf(Integer.parseInt(split[1], 16));
        Integer valueOf3 = Integer.valueOf(Integer.parseInt(split[2], 16));
        Integer valueOf4 = Integer.valueOf(Integer.parseInt(split[3], 16));
        if (valueOf2.intValue() == 4919 && valueOf.intValue() + 1337 == 12248 && valueOf3.intValue() == valueOf2.intValue() + 33479 && valueOf4.intValue() == Integer.parseInt("d34d", 16)) {
            return true;
        }
        return false;
    }

    public static void main(String[] strArr) {
        System.out.print("Enter Serial Number: ");
        String nextLine = new Scanner(System.in).nextLine();
        if (isValidSerialNumber(nextLine).booleanValue()) {
            System.out.println("Success! Here is your flag: TPAS{" + nextLine + "}");
        } else {
            System.out.println("Invalid Serial Number");
        }
    }
}
