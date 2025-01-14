import java.util.*;

class Nuvem {
    int linha;
    int coluna;

    Nuvem(int l, int c) {
        linha = l;
        coluna = c;
    }
}

public class daa031 {
    static int L;
    static int C;
    static char[][] matrix;
    static int[][] mapa;
    static int Nmin;
    static int Nmax;
    static int aeroportos;
    static Queue<Nuvem> q;

    static void adicionarlinhaM1(Nuvem aux) {
        if (aux.linha + 1 < L)
            if (mapa[aux.linha + 1][aux.coluna] == 0) {
                Nuvem nova = new Nuvem(aux.linha+1, aux.coluna);
                q.add(nova);
                mapa[nova.linha][nova.coluna] = mapa[aux.linha][aux.coluna] + 1;
                if (matrix[nova.linha][nova.coluna] == 'A') {
                    aeroportos--;
                    if (mapa[nova.linha][nova.coluna] < Nmin)
                        Nmin = mapa[nova.linha][nova.coluna];
                    if (mapa[nova.linha][nova.coluna] > Nmax)
                        Nmax = mapa[nova.linha][nova.coluna];
                }
            }
    }

    static void adicionarlinham1(Nuvem aux) {
        if (aux.linha - 1 > -1)
            if (mapa[aux.linha - 1][aux.coluna] == 0) {
                Nuvem nova = new Nuvem(aux.linha-1, aux.coluna);
                q.add(nova);
                mapa[nova.linha][nova.coluna] = mapa[aux.linha][aux.coluna] + 1;
                if (matrix[nova.linha][nova.coluna] == 'A') {
                    aeroportos--;
                    if (mapa[nova.linha][nova.coluna] < Nmin)
                        Nmin = mapa[nova.linha][nova.coluna];
                    if (mapa[nova.linha][nova.coluna] > Nmax)
                        Nmax = mapa[nova.linha][nova.coluna];
                }
            }
    }

    static void adicionarcolunaM1(Nuvem aux) {
        if (aux.coluna + 1 < C)
            if (mapa[aux.linha][aux.coluna + 1] == 0) {
                Nuvem nova = new Nuvem(aux.linha, aux.coluna+1);
                q.add(nova);
                mapa[nova.linha][nova.coluna] = mapa[aux.linha][aux.coluna] + 1;
                if (matrix[nova.linha][nova.coluna] == 'A') {
                    aeroportos--;
                    if (mapa[nova.linha][nova.coluna] < Nmin)
                        Nmin = mapa[nova.linha][nova.coluna];
                    if (mapa[nova.linha][nova.coluna] > Nmax)
                        Nmax = mapa[nova.linha][nova.coluna];
                }
            }
    }

    static void adicionarcolunam1(Nuvem aux) {
        if (aux.coluna - 1 > -1)
            if (mapa[aux.linha][aux.coluna - 1] == 0) {
                Nuvem nova = new Nuvem(aux.linha, aux.coluna-1);
                q.add(nova);
                mapa[nova.linha][nova.coluna] = mapa[aux.linha][aux.coluna] + 1;
                if (matrix[nova.linha][nova.coluna] == 'A') {
                    aeroportos--;
                    if (mapa[nova.linha][nova.coluna] < Nmin)
                        Nmin = mapa[nova.linha][nova.coluna];
                    if (mapa[nova.linha][nova.coluna] > Nmax)
                        Nmax = mapa[nova.linha][nova.coluna];
                }
            }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        L = in.nextInt();
        C = in.nextInt();
        matrix = new char[L][C];
        mapa = new int[L][C];
        aeroportos = 0;
        q = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            String g = in.next();
            for (int j = 0; j < C; j++) {
                matrix[i][j] = g.charAt(j);
                if (matrix[i][j] == 'A') {
                    aeroportos++;
                }
                if (matrix[i][j] == '#') {
                    mapa[i][j] = 1;
                    Nuvem n = new Nuvem(i, j);
                    q.add(n);
                }
            }
        }
        Nmin = Integer.MAX_VALUE;
        Nmax = Integer.MIN_VALUE;


        while (!q.isEmpty() && aeroportos > 0) {
            Nuvem aux = q.poll();
            adicionarlinhaM1(aux);
            adicionarlinham1(aux);
            adicionarcolunaM1(aux);
            adicionarcolunam1(aux);
        }
        Nmin--;
        Nmax--;
        System.out.println(Nmin + " " + Nmax);

    }

}

