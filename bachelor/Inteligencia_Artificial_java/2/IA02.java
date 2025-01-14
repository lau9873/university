import java.util.*;

public class IA02 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Qual o algoritmo a usar?");
        System.out.println("MINMAX=0; ALPHABETA=1; MCTS=2");
        int alg = in.nextInt();
        System.out.println("Prefere jogar primeiro?");
        System.out.println("SIM=1; NAO=0");
        int flag = in.nextInt();

        String[][] tab = new String[6][7];
        for (int i=0; i<6; i++)
            Arrays.fill(tab[i],"_");

        boolean value = true;
        int c=-1;
        while (value) {
            c++;
            if (flag == 0) {
                // computador - joga com X
                int m = 3; //jogada pre determinada se o tabuleiro estiver vazio
                if (c>0) {  //se nao for uma jogada num tabuleiro vazio
                    int l = Math.min(3 * c, 8); //limite de profundidade maximo - para minimax e alphabeta
                    if (alg == 0){
                        long start = System.currentTimeMillis();
                        //Inicia Minimax
                        m = tryAlphaBeta.start(tab, l);
                        long elapsed = System.currentTimeMillis() - start;
                        System.out.println("Tempo de decisao em milissegundos:"+ elapsed);
                    }
                    if (alg == 1) {
                        long start = System.currentTimeMillis();
                        //Inicia AlphaBeta
                        m = tryAlphaBeta.start1(tab, l);
                        long elapsed = System.currentTimeMillis() - start;
                        System.out.println("Tempo de decisao em milissegundos:"+ elapsed);
                    }
                    if (alg == 2) {
                        long start = System.currentTimeMillis();
                        //Inicia MCTS
                        m = MCTS.start(tab);
                        long elapsed = System.currentTimeMillis() - start;
                        System.out.println("Tempo de decisao em milissegundos:"+ elapsed);
                    }
                }
                tab = move(tab, m, "X");
                print(tab);
                if (terminal(tab,m,"X").equals("X")) {
                    System.out.println("Perdeu... Mas tente outra vez!");
                    value = false;
                }
                else {
                    flag = 1;
                }
            }
            if (flag == 1) {
                //pessoa - joga com O
                int m = in.nextInt(); //vem o numero da coluna
                boolean[] poss = suc(tab);
                while (m < 0 || m > 6 || !poss[m]) {
                    System.out.println("Jogada invalida! Jogue outra vez!!");
                    m = in.nextInt();
                }
                tab = move(tab, m, "O");
                //print(tab.getMatrix());
                if (terminal(tab,m, "O").equals("O")) {
                    System.out.println("PARABENS!!Ganhou!");
                    print(tab);
                    value = false;
                }
                else {
                    flag = 0; //para o ciclo executar na vez do pc
                }
            }
        }
    }


    public static boolean[] suc(String[][] t) {
        boolean[] sucessores = new boolean[7];
        for (int i = 0; i < 7; i++) {
            if (t[0][i].equals("_"))
                sucessores[i] = true;
        }
        return sucessores;
    }

    public static void print(String[][] t) {
        System.out.println();
        System.out.println("0 1 2 3 4 5 6");
        for (int j=0; j<6; j++) {
            for (int i = 0; i < 7; i++) {
                System.out.print(t[j][i] + " ");
            }
            System.out.println();
        }
    }

 
    public static boolean ganhou(String[][] matrix,int move, String X) {
        //recebe tb a move que lhe deu origem
        if (move == -1) return false; //raiz da arvore de pesquisa
  
        //Unica possiblidade de vitoria nas colunas neste momento e a coluna que sofreu alteracoes
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

        //Unica possiblidade de vitoria nas linhas neste momento e a linha que sofreu alteracoes
        c=0;
        for (int j=0; j<7; j++){
            if (matrix[line][j].equals(X)) c++;
            else c=0;
            if (c == 4)
                return true;
        }


        //diagonais
        //ignorar teste de diagonais se a casa da jogada (line,move) nao se enquadrar em nenhuma das diagonais
        if (!(line <=2 && move >= 4)) {
            for (int i = 2; i > -1; i--) {
                int dec = 0;
                int count = 0;
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
            for (int j = 1; j < 4; j++) {
                int dec = 0;
                int count = 0;
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
            for (int j = 3; j < 7; j++) {
                int dec = 0;
                int count = 0;
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
            for (int i = 1; i < 3; i++) {
                int dec = 0;
                int count = 0;
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


    //ver se e possivel continuar o jogo
    public static String terminal(String[][] t, int move, String p) {
        //recebe tb a move que lhe deu origem
        if (ganhou(t,move ,p)) return p;
        for (int i=0; i<7; i++){
            //Se existe pelo menos uma coluna que nao esta totalmente preenchida entao o jogo ainda nao acabou
            if (t[0][i].equals("_")) return "_";
        }
        return "draw"; //empate
    }

    public static String[][] move(String[][] m, int move, String player){
        String[][] New = new String[6][7];
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                New[i][j] = m[i][j];
            }
        }

        for (int i=5; i>=0; i--){
            if (m[i][move].equals("_")){
                New[i][move] = player;
                break;
            }
        }
        return New;
    }

    //funcao utilidade - so entra aqui se o tab for um terminal (ou seja IA02.terminal() retorna algo diferente de "_")
    public static int util(String terminal) {
        if (terminal.equals("X")) return 512;
        if (terminal.equals("O")) return -512;
        return 0;

    }

    public static int heuristica(String[][] matrix, String Player){
        //Objetivo: de todos os possiveis segmentos de 4 pecas seguidas, seja na horizontal, vertical ou diagonal,
        //somar uma dada quantia consoante a quantidade de "X" e "O" em cada um desses segmentos - ver tabela do enunciado
        //para avaliar as quantias corretamente.

        int count = 0;

        //contar na vertical e na horizontal:
        for (int j=0; j<7; j++){
            for (int i = 0; i < 3; i++){
                int vX = 0, vO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[i+d][j].equals("X")) vX++;
                    if (matrix[i+d][j].equals("O")) vO++;
                }
                count += evaluation(vX,vO);
            }
        }

        for (int j=0; j<6; j++){
            for (int i = 0; i<4; i++) {
                int hX = 0, hO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[j][i+d].equals("X")) hX++;
                    if (matrix[j][i+d].equals("O")) hO++;
                }
                count += evaluation(hX,hO);
            }
        }

        //contar na diagonal, sentido esquerda - direita, abaixo da diagonal principal (incluindo):
        for (int j=0; j<=2; j++) {
            for (int i=j; i<=2; i++){
                int dX = 0, dO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[i+d][j+d].equals(("X"))) dX++;
                    if (matrix[i+d][j+d].equals(("O"))) dO++;
                }
                count += evaluation(dX,dO);
            }
        }

        for (int i=0; i<=2; i++) {
            int dX = 0, dO = 0;
            for (int j=i+1; j<=3; j++){
                for (int d=0; d<=3; d++) {
                    if (matrix[i+d][j+d].equals(("X"))) dX++;
                    if (matrix[i+d][j+d].equals(("O"))) dO++;
                }
            }
            count += evaluation(dX,dO);
        }

        //contar na diagonal, sentido direita - esquerda, acima da diagonal principal:
        for (int i=0; i<=2; i++) {
            for (int j=i+1; j<=3; j++){
                int dX = 0, dO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[6-j-d][i+d].equals(("X"))) dX++;
                    if (matrix[6-j-d][i+d].equals(("O"))) dO++;
                }
                count += evaluation(dX,dO);
            }
        }

        //contar na diagonal, sentido direita - esquerda, abaixo da diagonal principal inversa (incluindo):
        for (int j=0; j<=2; j++) {
            for (int i=j; i<=2; i++){
                int dX = 0, dO = 0;
                for (int d=0; d<=3; d++) {
                    if (matrix[i+d][6-j-d].equals(("X"))) dX++;
                    if (matrix[i+d][6-j-d].equals(("O"))) dO++;
                }
                count += evaluation(dX,dO);
            }
        }

        return count;
    }

    public static int evaluation(int x, int o){
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


