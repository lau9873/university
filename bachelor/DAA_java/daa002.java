import java.util.Scanner;

public class daa002 {
    public static int soma(int n) {
        int soma = 0;
        while (n != 0) {
            soma = soma + n % 10;
            n = n / 10;
        }
        return soma;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int N, K, S;
        for (int i = 0; i < T; i++) {
            N = in.nextInt();
            K = in.nextInt();
            S = 0;
            while (S != K) {
                S = 0;
                N = N + 1;
                S = soma(N);
            }
            System.out.println(N);

        }


    }
}
