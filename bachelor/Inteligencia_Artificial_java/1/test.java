import java.util.Scanner;
import java.util.Arrays;

public class test {
    public static void main(String[] args){
        int[][] configInicial = new int[4][4];
        //int[][] configFinal = new int[4][4];
        Scanner in = new Scanner(System.in);
        configInicial = read(in);
        //configFinal = read(in);
        int[][] p = poss(configInicial);
        System.out.println(Arrays.toString(p[0]));
        System.out.println(Arrays.toString(p[1]));
        System.out.println(Arrays.toString(p[2]));
        System.out.println(Arrays.toString(p[3]));
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
}
