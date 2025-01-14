import java.util.*;
//objetivo:cobrir ate M com o minimo de seguementos possiveis.
//barra é a posicao atual ...|.......;
// vai aumentando a barra c os seguementos mais compridos.

public class daa013 {
    public static int[][] seg;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        seg = new int[3][N];
        for (int i = 0; i < N; i++) {
            seg[0][i] = in.nextInt();
            seg[1][i] = in.nextInt();
        }
        int barra = 0;
        int count = 0;
        while (barra < M) {
            barra = avalia(barra, N);
            count++;
        }
        System.out.println(count);

    }

    public static int avalia(int barra, int N) {
        int novabarra = 0;
        for (int i = 0; i < N; i++) {
            if (seg[0][i] <= barra && seg[1][i] > novabarra) {
                novabarra = seg[1][i];
            }
        }
        return novabarra;
    }
}
