package defpackage;

import java.util.Scanner;
/* compiled from: ED004.java */
/* renamed from: Game  reason: default package */
/* loaded from: Game.class */
class Game {
    private int n;
    private char[][] m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Game(int i2) {
        this.n = i2;
        this.m = new char[i2][i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void read(Scanner scanner) {
        for (int i2 = 0; i2 < this.n; i2++) {
            String next = scanner.next();
            for (int i3 = 0; i3 < this.n; i3++) {
                this.m[i2][i3] = next.charAt(i3);
            }
        }
    }

    void win(char c2) {
        System.out.println("Ganhou o " + c2);
        System.exit(0);
    }

    void verify(int i2, int i3, int i4, int i5) {
        if (this.m[i2][i3] == '.') {
            return;
        }
        int i6 = 0;
        int i7 = i2;
        int i8 = i3;
        while (true) {
            int i9 = i8;
            if (i6 < this.n) {
                if (this.m[i2][i3] != this.m[i7][i9]) {
                    return;
                }
                i6++;
                i7 += i4;
                i8 = i9 + i5;
            } else {
                win(this.m[i2][i3]);
                return;
            }
        }
    }

    boolean finished() {
        for (int i2 = 0; i2 < this.n; i2++) {
            for (int i3 = 0; i3 < this.n; i3++) {
                if (this.m[i2][i3] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void check() {
        for (int i2 = 0; i2 < this.n; i2++) {
            verify(i2, 0, 0, 1);
        }
        for (int i3 = 0; i3 < this.n; i3++) {
            verify(0, i3, 1, 0);
        }
        verify(0, 0, 1, 1);
        verify(0, this.n - 1, 1, -1);
        if (finished()) {
            System.out.println("Empate");
        } else {
            System.out.println("Jogo incompleto");
        }
    }
}
