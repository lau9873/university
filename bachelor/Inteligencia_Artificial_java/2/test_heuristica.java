import java.util.Scanner;

public class test_heuristica {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] tab = new String[6][7];
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++)
                tab[i][j] = in.next();
        }
        System.out.print("h = " + heuristica(tab, "O"));
    }

    public static int heuristica(String[][] matrix, String Player){
        //Objetivo: de todos os possíveis segmentos de 4 peças seguidas, seja na horizontal, vertical ou diagonal,
        //somar uma dada quantia consoante a quantidade de "X" e "O" em cada um desses segmentos - ver tabela do enunciado
        //para avaliar as quantias corretamente.

        int count = 0;
        if (Player.equals("X")) count += 16;
        else count -= 16;
        System.out.println("Bonus = " + count);

        //contar na vertical e na horizontal:
        for (int j=0; j<7; j++){
            for (int i = 0; i < 3; i++){
                int vX = 0, vO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[i+d][j].equals("X")) vX++;
                    if (matrix[i+d][j].equals("O")) vO++;
                }
                count += evalution(vX,vO);
            }
        }
        System.out.println("Total colunas = " + count);

        for (int j=0; j<6; j++){
            for (int i = 0; i<4; i++) {
                int hX = 0, hO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[j][i+d].equals("X")) hX++;
                    if (matrix[j][i+d].equals("O")) hO++;
                }
                count += evalution(hX,hO);
            }
        }
        System.out.println("Total linhas = " + count);

        //contar na diagonal, sentido esquerda - direita, abaixo da diagonal principal (incluindo):
        for (int j=0; j<=2; j++) {
            for (int i=j; i<=2; i++){
                int dX = 0, dO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[i+d][j+d].equals(("X"))) dX++;
                    if (matrix[i+d][j+d].equals(("O"))) dO++;
                }
                count += evalution(dX,dO);
            }
        }
        System.out.println("Total diagonais esquerda direita abaixo da diagonal principal = " + count);

        for (int i=0; i<=2; i++) {
            int dX = 0, dO = 0;
            for (int j=i+1; j<=3; j++){
                for (int d=0; d<=3; d++) {
                    if (matrix[i+d][j+d].equals(("X"))) dX++;
                    if (matrix[i+d][j+d].equals(("O"))) dO++;
                }
            }
            count += evalution(dX,dO);
        }
        System.out.println("Total diagonais esquerda direita acima da diagonal principal = " + count);

        //contar na diagonal, sentido direita - esquerda, acima da diagonal principal:
        for (int i=0; i<=2; i++) {
            for (int j=i+1; j<=3; j++){
                int dX = 0, dO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[6-j-d][i+d].equals(("X"))) dX++;
                    if (matrix[6-j-d][i+d].equals(("O"))) dO++;
                }
                count += evalution(dX,dO);
            }
        }
        System.out.println("Total diagonais direita esquerda acima da diagonal principal = " + count);

        //contar na diagonal, sentido direita - esquerda, abaixo da diagonal principal inversa (incluindo):
        for (int j=0; j<=2; j++) {
            for (int i=j; i<=2; i++){
                int dX = 0, dO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[i+d][6-j-d].equals(("X"))) dX++;
                    if (matrix[i+d][6-j-d].equals(("O"))) dO++;
                }
                count += evalution(dX,dO);
            }
        }
        System.out.println("Total diagonais direita esquerda abaixo da diagonal principal = " + count);

        return count;
    }

    public static int evalution(int x, int o){
        int c=0;
        if ( x!=0 && o!=0) return c;
        switch (x){
            case 1: c = 1; break;
            case 2: c = 10; break;
            case 3: c = 50; break;
        }
        switch (o){
            case 1: c = -1; break;
            case 2: c = -10; break;
            case 3: c = -50; break;
        }
        return c;
    }
}
