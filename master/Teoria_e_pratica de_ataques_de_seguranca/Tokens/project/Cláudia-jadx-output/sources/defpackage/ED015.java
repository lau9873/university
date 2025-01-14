package defpackage;

import java.util.Scanner;
/* renamed from: ED015  reason: default package */
/* loaded from: ED015.class */
public class ED015 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int nextInt2 = scanner.nextInt();
        int i2 = 0;
        while (true) {
            if (nextInt != 0 || nextInt2 != 0) {
                i2++;
                Game game = new Game(nextInt, nextInt2);
                game.read(scanner);
                int nextInt3 = scanner.nextInt();
                Game game2 = new Game(nextInt, nextInt2);
                for (int i3 = 1; i3 <= nextInt3; i3++) {
                    game.check(scanner.next(), game2);
                }
                game.change(game2);
                System.out.println("Input #" + i2);
                game.write();
                nextInt = scanner.nextInt();
                nextInt2 = scanner.nextInt();
            } else {
                return;
            }
        }
    }
}
