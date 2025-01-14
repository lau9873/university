package defpackage;

import java.util.Scanner;
/* renamed from: ED007  reason: default package */
/* loaded from: ED007.class */
public class ED007 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        scanner.nextLine();
        for (int i2 = 0; i2 < nextInt; i2++) {
            int i3 = 0;
            LinkedListStack linkedListStack = new LinkedListStack();
            Scanner scanner2 = new Scanner(scanner.nextLine());
            boolean z = false;
            while (true) {
                if (!scanner2.hasNext()) {
                    break;
                }
                i3 += 2;
                String next = scanner2.next();
                if (next.equals("(") || next.equals("[")) {
                    linkedListStack.push(next);
                }
                if (next.equals(")")) {
                    if (linkedListStack.isEmpty()) {
                        System.out.println("Erro na posicao " + (i3 - 2));
                        z = true;
                        break;
                    }
                    String str = (String) linkedListStack.pop();
                    if (str.equals("(")) {
                        continue;
                    } else if (!str.equals("(")) {
                        System.out.println("Erro na posicao " + (i3 - 2));
                        z = true;
                        break;
                    }
                }
                if (next.equals("]")) {
                    if (linkedListStack.isEmpty()) {
                        System.out.println("Erro na posicao " + (i3 - 2));
                        z = true;
                        break;
                    } else {
                        String str2 = (String) linkedListStack.pop();
                        if (!str2.equals("[") && !str2.equals("[")) {
                            System.out.println("Erro na posicao " + (i3 - 2));
                            z = true;
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }
            if (!linkedListStack.isEmpty() && !z) {
                System.out.println("Ficam parenteses por fechar");
            }
            if (linkedListStack.isEmpty() && !z) {
                System.out.println("Expressao bem formada");
            }
        }
    }
}
