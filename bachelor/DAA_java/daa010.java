import java.util.*;

//objetivo: encontrar a soma de numeros mais proxima do nuemro pedido em questions.
//criei array com todas as somas possíveis
//verifiquei se o numero esta nas somas e depois os numeros q estavam nas suas proximidades.
public class daa010 {
    //binary search retorna -1 se o numero n estiver no array da somas e n se estiver.
    //apenas verifica se o numero está no array...
    public static int search(int[] v, int key) {
        int low = 0;
        int high = v.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (key == v[middle]) return key;
            else if (key < v[middle]) high = middle - 1;
            else low = middle + 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int[] v = new int[N];
        for (int i = 0; i < N; i++)
            v[i] = stdin.nextInt();
        int Q = stdin.nextInt();
        int[] questions = new int[Q];
        for (int i = 0; i < Q; i++)
            questions[i] = stdin.nextInt();

        int[] somas = new int[N * (N - 1)];
        int l = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (k != j) {
                    somas[l] = v[j] + v[k];
                    l++;
                }
            }
        }
        Arrays.sort(somas);
        for (int i = 0; i < Q; i++) {
            int s = search(somas, questions[i]);
            if (s != -1)
                System.out.print(s);
            else {
                int o = 1;
                int s1 = -1;
                int s2 = -1;
                while (s1 == -1 && s2 == -1) {
                    s1 = search(somas, questions[i] - o);
                    s2 = search(somas, questions[i] + o);
                    if (s1 != -1 && s2 != -1)
                        System.out.print(s1 + " " + s2);
                    else if (s1 != -1)
                        System.out.print(s1);
                    else if (s2 != -1)
                        System.out.print(s2);
                    o++;
                }
            }
            System.out.println();

        }
    }
}
