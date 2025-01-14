import java.util.*;
//objetivo: contar quantos caminhos se pode fazer para chegar ao topo da montanha com buracos
//ir fazendo a soma dos caminhos possiveis e acumular as somas no objetivo(topo da montanha)
public class daa017 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[][] matrix = new long[N][N];
        int D = in.nextInt();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                matrix[i][j] = 1;
        for (int l = 0; l < D; l++) {
            int C = in.nextInt();
            int P = in.nextInt();
            matrix[N - C][P - 1] = 0;
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = matrix[i + 1][j] + matrix[i + 1][j + 1];
                }
            }
        }
        System.out.println(matrix[0][0]);
    }
}
