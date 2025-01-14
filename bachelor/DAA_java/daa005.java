import java.util.*;
// soma de partes da sequencias definidas à partida sem estar sempre a percorrer a lista toda
// cria lista de somas acumuladas
public class daa005 {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int N = in.nextInt();
        int[] bakugans = new int[N];
        int[] somaac = new int[N];
        bakugans[0] = in.nextInt();
        somaac[0] = bakugans[0];
        for (int i = 1; i < N; i++) {
            bakugans[i] = in.nextInt();
            somaac[i] = somaac[i - 1] + bakugans[i];
        }
        int F = in.nextInt();
        int A, B, soma;
        for (int f = 0; f < F; f++) {
            A = in.nextInt();
            B = in.nextInt();
            if (A == B)
                FastPrint.out.println(bakugans[A - 1]);
            else if (A == 1)
                FastPrint.out.println(somaac[B - 1]);

            else
                FastPrint.out.println(somaac[B - 1] - somaac[A - 2]);
        }

        FastPrint.out.close();
    }
}
