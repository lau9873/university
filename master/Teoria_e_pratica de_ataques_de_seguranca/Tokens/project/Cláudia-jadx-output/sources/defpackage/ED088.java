package defpackage;

import java.util.Scanner;
/* renamed from: ED088  reason: default package */
/* loaded from: ED088.class */
public class ED088 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int nextInt2 = scanner.nextInt();
        int nextInt3 = scanner.nextInt();
        Game game = new Game(nextInt, nextInt2);
        game.read(scanner);
        for (int i2 = 0; i2 < nextInt3; i2++) {
            game = game.iterate();
        }
        game.write();
    }
}
