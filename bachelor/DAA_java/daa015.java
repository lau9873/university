import java.util.*;

public class daa015 {
    public static void main(String args[]) {
        FastScanner in = new FastScanner(System.in);
        int N = in.nextInt();
        int count = N;
        int max = 0;
        int[] seq = new int[N];
        for (int j = 0; j < N; j++) {
            seq[j] = in.nextInt();
            if (seq[j] > max) max = seq[j];
        }
        int[] aux = new int[max + 2];
        for (int i = 0; i < N; i++) {
            aux[seq[i]]++;
            for (int l = seq[i] + 1; l < aux.length; l++)
                if (aux[l] > 0) {
                    count--;
                    aux[l]--;
                    break;
                }
        }
        System.out.println(count);
    }
}
