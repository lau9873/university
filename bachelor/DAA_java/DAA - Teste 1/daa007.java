import java.util.*;
//sequencia contigua com a maior soma
//usando divide and conquer.
public class daa007 {
    public static void main(String args[]) {
        FastScanner in = new FastScanner(System.in);
        int N = in.nextInt();
        int[] seq = new int[N];
        for (int i = 0; i < N; i++)
            seq[i] = in.nextInt();
        int result = sms(seq, 0, N - 1);
        FastPrint.out.println(result);
        FastPrint.out.close();
    }

    public static int sms(int[] v, int a, int b) {
        if (a == b)
            return v[a];
        int meio = (a + b) / 2;
        int best1 = sms(v, a, meio);
        int best2 = sms(v, meio + 1, b);
        int best3 = melhor(v, a, meio, 0) + melhor(v, meio + 1, b, 1);
        return Math.max(Math.max(best1, best2), best3);

    }

    public static int melhor(int[] v, int a, int b, int lado) {
        int max = 0;
        if (lado == 0) {
            int soma = 0;
            for (int i = b; i >= a; i--) {
                soma += v[i];
                if (soma >= max) max = soma;
            }
        }
        if (lado == 1) {
            int soma = 0;
            for (int i = a; i <= b; i++) {
                soma += v[i];
                if (soma >= max) max = soma;
            }
        }
        return max;
    }

}
