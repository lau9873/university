package defpackage;

import java.util.Scanner;
/* renamed from: ED006  reason: default package */
/* loaded from: ED006.class */
public class ED006 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        for (int i2 = 0; i2 < nextInt; i2++) {
            scanner.nextLine();
            int length = scanner.nextLine().split(" ").length;
            int nextInt2 = scanner.nextInt();
            CircularLinkedList circularLinkedList = new CircularLinkedList();
            for (int i3 = 0; i3 < nextInt2; i3++) {
                circularLinkedList.addLast(scanner.next());
            }
            for (int i4 = 0; i4 < nextInt2 - 1; i4++) {
                for (int i5 = 0; i5 < length - 1; i5++) {
                    circularLinkedList.rotate();
                }
                circularLinkedList.removeFirst();
            }
            String str = (String) circularLinkedList.getFirst();
            if (!str.equals("Carlos")) {
                System.out.printf("O Carlos livrou-se (coitado do %s!)%n", str);
            }
            if (str.equals("Carlos")) {
                System.out.println("O Carlos nao se livrou");
            }
        }
    }
}
