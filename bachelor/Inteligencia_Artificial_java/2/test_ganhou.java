import java.util.Scanner;

public class test_ganhou {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] tab = new String[6][7];
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++)
                tab[i][j] = in.next();
        }
        System.out.println("Qual a coluna em que se realizou a última jogada deste tabuleiro?");
        int j = in.nextInt();
        System.out.print("h = " + ganhou(tab, j,"O"));
    }

    public static boolean ganhou(String[][] matrix,int move, String X) { //recebe tb a move que lhe deu origem
        if (move == -1) return false; //raiz da arvore de pesquisa
        //vertical
        /*for (int i = 0; i < 7; i++) {
            int count = 0;
            for (int j = 0; j < 6; j++) {
                if (matrix[j][i].equals(X)) count++;
                else count=0;
                if (count == 4)
                    return true;
            }
        }*/
        //Unica possiblidade de vitoria nas colunas neste momento é a coluna que sofreu alterações
        int c = 0, line = 0;
        for (int i=5; i>=0; i--){
            if (matrix[i][move].equals("_")){
                line = i+1; //i indica a casa vazia imediatamente acima da que jogamos
                break;
            }
            if (matrix[i][move].equals(X)) c++;
            else c=0;
            if (c == 4)
                return true;
        }

        //horizontal
        /*for (int i = 0; i < 6; i++) {
            int count = 0;
            for (int j=0; j<7; j++){
                if (matrix[i][j].equals(X)) count++;
                else count=0;
                if (count == 4)
                    return true;
            }
        }*/

        //Unica possiblidade de vitoria nas linhas neste momento é a linha que sofreu alterações
        c=0;
        for (int j=0; j<7; j++){
            if (matrix[line][j].equals(X)) c++;
            else c=0;
            if (c == 4)
                return true;
        }


        //diagonais
        //ignorar teste de diagonais se a casa jogada (line,move) não se enquadrar em nenhuma das diagonais
        if (!(line <=2 && move >= 4)) {
            int count = 0;
            //esquerda -> direita
            //tres da vertical
            for (int i = 2; i > -1; i--) {
                int dec = 0;
                while (i + dec <= 5 && dec <= 6) {
                    if (matrix[i + dec][dec].equals(X))
                        count++;
                    else
                        count = 0;
                    dec++;
                    if (count == 4)
                        return true;
                }
            }
        }
        if (!(line >= 3 && move <= 2)){
            //restantes da horizontal
            int count = 0;
            for (int j = 1; j < 4; j++) {
                int dec = 0;
                while (dec <= 5 && j + dec <= 6) {
                    if (matrix[dec][j + dec].equals(X))
                        count++;
                    else
                        count = 0;
                    dec++;
                    if (count == 4)
                        return true;
                }
            }
        }


        if (!(line >= 3 && move >= 4)) {
            //direita -> esquerda
            //quatro da horizontal
            int count = 0;
            for (int j = 3; j < 7; j++) {
                int dec = 0;
                while (dec <= 5 && j - dec > -1) {
                    if (matrix[dec][j - dec].equals(X))
                        count++;
                    else
                        count = 0;
                    dec++;
                    if (count == 4)
                        return true;
                }
            }
        }
        if (!(line <= 2 && move <= 2)){
            //restantes da horizontal
            int count = 0;
            for (int i = 1; i < 3; i++) {
                int dec = 0;
                while (i + dec <= 5 && 6 - dec > -1) {
                    if (matrix[i + dec][6 - dec].equals(X))
                        count++;
                    else
                        count = 0;
                    dec++;
                    if (count == 4)
                        return true;
                }
            }
        }
        return false;
    }
}