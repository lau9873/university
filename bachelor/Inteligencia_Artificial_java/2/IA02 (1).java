import java.util.*;

public class IA02 {
    //static LinkedListStack<String>[] tab;
    //static GameNode tab;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int flag = in.nextInt();

        //GameNode tab = new GameNode();
        //if (flag == 0) tab.setPlayer("X");
        //else tab.setPlayer("O");

        /*boolean value = true;
        while (value) {
            if (flag == 0) {
                // computador - joga com X
                //tab.setPlayer("X");
                int m = MiniMax.start(tab.getMatrix(),3); //vem o nº da coluna
                tab.setPlayer("X");
                tab.setMove(m);
                tab.move(tab.getMatrix(),m);
                //tab = move(tab, m, "X");
                print(tab.getMatrix());
                if (terminal(tab).equals("X")) {
                    System.out.println("You lost!");
                    value = false;
                }
                else {
                    flag = 1;
                }

            }
            if (flag == 1) {
                //pessoa - joga com O
                int m = in.nextInt(); //vem o nº da coluna
                tab.setPlayer("O");
                tab.setMove(m);
                tab.move(tab.getMatrix(),m);
                //tab = move(tab, m, "O");
                //print(tab.getMatrix());
                if (terminal(tab).equals("O")) {
                    System.out.println("You won!");
                    value = false;
                }
                else {
                    //simulação
                    flag = 0; //para o ciclo executar na vez do pc
                }
            }
        }*/
        String[][] tab = new String[6][7];
        for (int i=0; i<6; i++)
            Arrays.fill(tab[i],"_");

        boolean value = true;
        int c=-1;
        while (value) {
            c++;
            if (flag == 0) {
                // computador - joga com X
                int m = 3;
                if (c>0) {  //se não for uma jogada num tabuleiro vazio
                    int l = Math.min(3 * c, 10);
                    System.out.println("Vamos tentar com um limite de " + l);
                    m = try_minimax.start(tab, l); //vem o nº da coluna
                    //m = AlphaBeta.start(tab,l);
                }
                tab = try_minimax.move(tab, m, "X"); //o move do alpha beta está correto tb
                print(tab);
                if (terminal(tab,m,"X").equals("X")) {
                    System.out.println("You lost!");
                    value = false;
                }
                else {
                    flag = 1;
                }
            }
            if (flag == 1) {
                //pessoa - joga com O
                int m = in.nextInt(); //vem o nº da coluna
                tab = try_minimax.move(tab, m, "O");
                //print(tab.getMatrix());
                if (terminal(tab,m, "O").equals("O")) {
                    System.out.println("You won!");
                    print(tab);
                    value = false;
                }
                else {
                    //simulação
                    flag = 0; //para o ciclo executar na vez do pc
                }
            }
        }
    }

    /*public static GameNode move(GameNode tab, int m, String player){
        //LinkedListStack<String>[] aux = tab.getValue();
        for (int i=0; i<=m; i++){
            if (i==m) tab.getValue()[i].push(player);
        }
        tab.passtomatriz();
        return tab;
    }*/

    public static boolean[] suc(String[][] t) {
        boolean[] sucessores = new boolean[7];
        for (int i = 0; i < 7; i++) {
            if (t[0][i].equals("_"))
                sucessores[i] = true;
        }
        return sucessores;
    }

    public static void print(String[][] t) {
        for (int j=0; j<6; j++) {
            for (int i = 0; i < 7; i++) {
                System.out.print(t[j][i] + " ");
            }
            System.out.println();
        }
    }

    //MODIFICAR ESTA FUNCAO - passamos ater acesso á versão matrix do tab!
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


    //ver se é possível continuar o jogo
    public static String terminal(String[][] t, int move, String p) { //recebe tb a move que lhe deu origem
        //Se alguem já ganhou o jogo então o
        //if (ganhou(t.getMatrix(),"X")) return "X";
        //if (ganhou(t.getMatrix(),"O")) return "O";
        if (ganhou(t,move ,p)) return p;
        for (int i=0; i<7; i++){
            //Se existe pelo menos uma coluna que não está totalmente preenchida então o jogo ainda não acabou
            if (t[0][i].equals("_")) return "_";
        }
        return "draw"; //empate
    }

}


