import java.util.*;
//objetivo: andar o minimo possivel entre cada paragem. resultado é minimo valor
// que se consegue para o maximo das distancias entre paragens


//poss()=ver se é possivel partir em k bocados c somas menores que x.
//o primeiro x possivel é a resposta pois depois é sempre possivel.
//logo comeca se com high=soma de todos os valores do arrray D. que é o pior possivel

public class daa011 {
    //binary search generalizada
    public static int search(int[] d, int h, int k) {
        int low = 1;
        int high = h;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (poss(d, k, middle)) {
                high = middle;
            } else low = middle + 1;
        }
        if (!poss(d, k, low)) return -1;
        return (low);
    }

    public static int soma(int[] d) {
        int soma = 0;
        for (int i = 0; i < d.length; i++)
            soma = soma + d[i];
        return soma;
    }

    public static boolean poss(int[] d, int parti, int min) {
        int soma = 0;
        int particoes = 1;
        for (int j = 0; j < d.length; j++)
            if (d[j] > min)
                return false;
        for (int i = 0; i < d.length; i++) {
            if (particoes > parti)
                return false;
            if (soma + d[i] <= min) {
                soma = soma + d[i];
            } else {
                particoes++;
                soma = d[i];
            }
        }
        if (particoes > parti)
            return false;
        return true;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] D = new int[N];
        for (int i = 0; i < N; i++)
            D[i] = in.nextInt();
        int P = in.nextInt();
        int h = soma(D);
        for (int j = 0; j < P; j++)
            System.out.println(search(D, h, in.nextInt()));

    }
}
