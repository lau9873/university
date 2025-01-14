package defpackage;

import java.util.Scanner;
/* renamed from: ED004  reason: default package */
/* loaded from: ED004.class */
public class ED004 {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner.nextInt());
        game.read(scanner);
        game.check();
    }
}
