package defpackage;

import java.util.Scanner;
/* renamed from: ED005  reason: default package */
/* loaded from: ED005.class */
public class ED005 {
    public static void main(String[] strArr) {
        LinkedListStack linkedListStack = new LinkedListStack();
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        scanner.nextLine();
        for (int i2 = 0; i2 < nextInt; i2++) {
            Scanner scanner2 = new Scanner(scanner.nextLine());
            boolean z = false;
            while (true) {
                if (!scanner2.hasNext()) {
                    break;
                }
                String next = scanner2.next();
                char c2 = ' ';
                for (int i3 = 0; i3 < next.length(); i3++) {
                    c2 = (char) (c2 + next.charAt(i3));
                }
                System.out.println(c2);
                if (Character.isDigit(c2)) {
                    linkedListStack.push(Integer.valueOf(Character.getNumericValue(c2)));
                } else if (linkedListStack.size() < 2) {
                    z = true;
                    break;
                } else {
                    if (c2 == '+') {
                        linkedListStack.push(Integer.valueOf(((Integer) linkedListStack.pop()).intValue() + ((Integer) linkedListStack.pop()).intValue()));
                    }
                    if (c2 == '-') {
                        linkedListStack.push(Integer.valueOf(((Integer) linkedListStack.pop()).intValue() - ((Integer) linkedListStack.pop()).intValue()));
                    }
                    if (c2 == '*') {
                        linkedListStack.push(Integer.valueOf(((Integer) linkedListStack.pop()).intValue() * ((Integer) linkedListStack.pop()).intValue()));
                    }
                    if (c2 == '/') {
                        linkedListStack.push(Integer.valueOf(((Integer) linkedListStack.pop()).intValue() / ((Integer) linkedListStack.pop()).intValue()));
                    }
                }
            }
            if (z || linkedListStack.size() != 1) {
                System.out.println("Expressao Incorrecta");
            } else {
                System.out.println(linkedListStack.pop());
            }
        }
    }
}
