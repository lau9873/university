///--------A-009,013,014-----------Greedy+Ordenaçao///
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
//009
// ordena as letras pelo numero de vezes que aparece na sequencia
// usa Arrays.sort();
// Classe para guardar um nome/letra com comparador
class Letra implements Comparable<Letra> {
    public int freq;
    public int pos;
    public char letra;

    Letra(char l,int f, int p) {
        freq = f;
        pos = p;
        letra = l;
    }
    Letra(char l) {
        freq = 0;
        pos = 0;
        letra = l;
    }
    // Definir como comparar dois elementos da classe Person
    // compareTo e uma funcao que compara objecto com outro objecto "p"
    // Esta funcao deve devolver:
    //  - numero < 0 se objecto for menor que objecto "p"
    //  - numero > 0 se objecto for maior que objecto "p"
    //  - zero, se objecto for igual ao objecto "p"
    @Override
    public int compareTo(Letra l) {
        if (freq < l.freq) return + 1;
        if (freq > l.freq) return -1;
        else if (pos<l.pos)
            return -1;
        return +1;
    }
}
public class daa009 {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        Letra[] a = new Letra[27];
        for (int i = 0; i < 27; i++) {
            char h = ((char) (i + 'A'));
            a[i] = new Letra(h);
        }
        String n = stdin.next();
        for (int j = 0; j < n.length(); j++) {
            char l = n.charAt(j);
            if (a[l - 'A'].freq == 0)
                a[l - 'A'] = new Letra(l, a[l - 'A'].freq + 1, j);
            else
                a[l - 'A'] = new Letra(l, a[l - 'A'].freq + 1, a[l - 'A'].pos);
        }
        Arrays.sort(a);
        int k = 0;
        while (a[k].freq != 0) {
            System.out.println(a[k].letra + " " + a[k].freq);
            k++;
        }
    }
}
//013
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
//014
//objetivo: saber qual sapato tratar primeiro de modo a dar menos despesa mas a ser mais rapido
//primeiro os mais longos com menos multa depois pela ordem de chegada
class Sapato implements Comparable<Sapato> {
    public double duracao;
    public double multa;
    public int pos;

    Sapato(double d, double m, int p) {
        duracao = d;
        multa = m;
        pos = p;
    }

    public int getPos() {
        return pos;
    }
    @Override
    public int compareTo(Sapato l) {
        if (duracao / multa < l.duracao / l.multa) return -1;
        if (duracao / multa > l.duracao / l.multa) return +1;
        else if (pos < l.pos)
            return -1;
        return +1;
    }
}
public class daa014 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Sapato[] sap = new Sapato[N];
        for (int i = 0; i < N; i++) {
            double d = in.nextInt();
            double m = in.nextInt();
            sap[i] = new Sapato(d, m, i + 1);
        }
        Arrays.sort(sap);
        for (int i = 0; i < N-1; i++)
            System.out.print(sap[i].getPos()+" ");
        System.out.print(sap[N-1].getPos());
        System.out.println();

    }
}
///--------B-010,011-----------Pesquisa Binaria///
//010
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
//011
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

//-----------------Pesquisa binaria num array ordenado---------
bsearch(v, low, high, key)
	while (low ≤ high ) {
	    middle = low + (high − low )/2;
            if (key = v [middle])
	        retorna(middle);
            else if (key < v [middle])
	        high= middle − 1;
            else
	        low= middle + 1;
	}
        return -1;

//---------------Pesquisa binaria para condicao 'condicao'-----
bsearch(low, high, condicao)
        Enquanto (low < high ) fazer
	   middle ← low + (high − low )/2
	   Se (condicao(middle) = sim) high ← middle
	   Senao low ← middle + 1
	Se (condicao(low ) = nao) retorna(-1)
	retorna(low)
//nao nao nao nao nao ->sim<- sim sim sim sim sim


///--------C-017,018-----------Programacao Dinamica///
//017
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
//018
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
