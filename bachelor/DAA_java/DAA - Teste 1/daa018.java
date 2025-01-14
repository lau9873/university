import java.util.*;
// troco de moedas para quantias de dinheiro
public class daa018 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] moedas = new int[N];
        for (int i = 0; i < N; i++)
            moedas[i] = in.nextInt();
        int P = in.nextInt();
        for (int p = 0; p < P; p++) {
            int Q = in.nextInt();
            int[][] matrix = new int[2][Q + 1];
            matrix[0][0] = 0;
            matrix[1][0] = 0;
            for (int i = 1; i <= Q; i++) {
                int countmoeda = Integer.MAX_VALUE;
                int lugar=0;
                for (int l = 0; l < N; l++) {
                    if (i - moedas[l] >= 0 && matrix[0][i - moedas[l]] < countmoeda) {
                        countmoeda = matrix[0][i - moedas[l]];
                        lugar = i - moedas[l];
                    }

                }
                matrix[0][i]=countmoeda+1;
                matrix[1][i]=lugar;
            }
            System.out.print(Q+": [" + matrix[0][Q] + "]");
            int atual = Q;
            for (int i = 0; i < matrix[0][Q]; i++) {
                int proxima = matrix[1][atual];
                int resposta = atual - proxima;
                System.out.print(" " + resposta);
                atual = proxima;
            }
            System.out.println();
        }
    }
}
