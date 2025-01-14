import java.util.Scanner;
import java.util.Arrays;

public class IA01{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int[][] configInicial = read(in);
        int[][] configFinal = read(in);
        if (!solvability(configInicial,configFinal))
            System.out.println("It is impossible to reach a solution");
        else{
            BFS.Start(configInicial,configFinal);
            tryNotInformed.Start(configInicial,5,configFinal);
            greedyA.Start(configInicial,configFinal);
            greedyB.Start(configInicial,configFinal);
            NewA_estrelaA.Start(configInicial,configFinal);
            NewA_estrelaB.Start(configInicial,configFinal);
            //DFS.Start(configInicial,configFinal); // não para, não aconselhamos a correr...

        }
    }

    public static int[][] read (Scanner in){
        int[][] tab = new int[4][4];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                tab[i][j] = in.nextInt();
            }
        }
        return tab;
    }

    public static int[] vector (int[][] tab){
        //transforma o tabuleiro em matriz para um vetor, facilita determinadas funções
        int[] v = new int[16];
        int count = 0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                v[count] = tab[i][j];
                count++;
            }
        }
        return v;
    }

    public static int inversions (int[] v){
        //calcula o nº de inversões do tabuleiro que vem em forma de vetor
        int inv = 0;
        for (int i=0; i<16; i++){
            for (int j=i; j<16; j++){
                if (v[i] > v[j] && v[j] != 0)
                    inv++;
            }
        }
        return inv;
    }

    public static int blankRow (int[][] tab){
        //retorna a linha da casa em branco
        int l = 0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (tab[i][j] == 0){
                    l=i;
                    i=4;
                    j=4;
                }
            }
        }
        return l;
    }

    public static boolean solvability(int[][] tab1, int[][] tab2){
        //testa a solvabilidade do problema
        int in1 = inversions(vector(tab1)), in2 = inversions(vector(tab2));
        int l1 = blankRow(tab1), l2 = blankRow(tab2);
        return (((in1%2==0) == (l1%2==1)) == ((in2%2==0) == (l2%2==1)));
    }

    public static int[][] suc(int[][] tab, int[] a){
        int[][] new_tab = new int[4][4];
        int[] z = zero(tab);
        //retorna o tabuleiro após execução de uma jogada - troca da casa a com z (vazia)
        int aux = tab[a[0]][a[1]];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (i==a[0] && j==a[1])
                    new_tab[i][j] = 0;
                else{
                    if (i==z[0] && j==z[1])
                        new_tab[z[0]][z[1]] = aux;
                    else new_tab[i][j] = tab[i][j];
                }
            }
        }
        return new_tab;
    }
    public static int[][] poss(int[][] tab){
        int[] zero = zero(tab);
        int[] aux = {-1,-1};
        int[][] poss=new int[4][2];
        int[] l1 = new int[2]; l1[0] = zero[0]; l1[1] = zero[1]-1;
        int[] l2 = new int[2]; l2[0] = zero[0]; l2[1] = zero[1]+1;
        int[] l3 = new int[2]; l3[0] = zero[0]-1; l3[1] = zero[1];
        int[] l4 = new int[2]; l4[0] = zero[0]+1; l4[1] = zero[1];
        poss[0] = l1; poss[1] = l2; poss[2] = l3; poss[3] = l4;
        for (int i=0; i<4; i++){
            if ( poss[i][0] < 0 || poss[i][1] < 0 || poss[i][0] > 3 || poss[i][1] > 3) poss[i]=aux;
        }
        zero = null; aux = null;
        l1 = null; l2 = null; l3 = null; l4 = null;
        return poss;
    }


    public static int[] zero (int[][] tab){
        //determina a posição da casa vazia - útil para várias funções
        int[] out = new int[2];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if (tab[i][j] == 0){
                    out[0] = i;
                    out[1] = j;
                    i=4;
                    j=4;
                }
            }
        }
        return out;
    }

    //falta descobrir quais as soluções válidas
}
