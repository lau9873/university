package defpackage;

import java.util.Iterator;
import java.util.Scanner;
/* renamed from: ED172  reason: default package */
/* loaded from: ED172.class */
public class ED172 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        BSTMap bSTMap = new BSTMap();
        while (scanner.hasNextLine()) {
            Scanner scanner2 = new Scanner(scanner.nextLine());
            while (scanner2.hasNext()) {
                String next = scanner2.next();
                if (bSTMap.get(next) == null) {
                    bSTMap.put(next, 1);
                } else {
                    bSTMap.put(next, Integer.valueOf(((Integer) bSTMap.get(next)).intValue() + 1));
                }
            }
        }
        Iterator it = bSTMap.keys().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            System.out.printf("%s: %d%n", str, bSTMap.get(str));
        }
    }
}
