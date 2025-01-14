import java.util.Arrays;
import java.util.Comparator;

public class try_minimax {
    static int limit;
    static int col;

    public static int start(String[][] m, int l){
        //escrever sucessores com X e retornar o max entre a utlidade destes sucessores
        //chamar minimax com player = X
        limit = l;
        Max(m,"X",0,-1);
        /*boolean[] poss = IA02.suc(m);
        int max = Integer.MIN_VALUE; //para não inteferir na procura do max
        for (int i=0; i<7; i++){
            if (poss[i]) {
                String[][] new_m = move(m,i,"X");
                int[] test = Min(new_m,"O",1,i);
                //int[] test = minimax(m, "X", 1, i);
                System.out.println("Já percorremos um dos ramos da raiz!");
                if (test[0] > max) col = test[1];
            }
        }*/
        return col;
    }

    public static int[] minimax(String[][] m, String Player, int Depth, int Move) {
        String[][] new_m = new String[6][7];
        new_m = move(m, Move, Player);

        String terminal = IA02.terminal(new_m,Move, Player);
        if (!terminal.equals("_")) {
            int[] out = {util(terminal),Move};
            return out;
        }
        if (Depth == limit){
            int[] out = {heuristica(new_m, Player), Move};
            return out;
        }

        if (Player.equals("X")) Player = "O";
        else Player = "X";

        boolean[] poss = IA02.suc(new_m);
        int[][] util = new int[7][2]; //guarda utilidade dos filhos e respetiva jogada
        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                util[i] = minimax(new_m,Player, Depth+1,i);
                //util[i][1] = i;
            }
            else{
                if (Player.equals("O")) util[i][0] = Integer.MAX_VALUE; //para não interferir na escolha
                else util[i][0] = Integer.MIN_VALUE;
            }
        }

        //ordenar os filhos
        Arrays.sort(util, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                return 1;
            }
        });

        if (Player.equals("X")){
            //col = util[util.length][1];
            return util[util.length-1];
        }
        else {
            //col = util[0][1];
            return util[0];
        }

    }

    public static int Min(String[][] m, String Player, int Depth, int Move){
        String terminal = IA02.terminal(m,Move, "X");
        if (!terminal.equals("_")) {
            //int[] out = {util(terminal),Move};
            //return out;
            //col = Move;
            return util(terminal);
        }
        if (Depth == limit){
            //int[] out = {heuristica(m, Player), Move};
            //return out;
            //col = Move;
            return heuristica(m,"O");
        }

        //Prosseguir na pesquisa:
        //if (Player.equals("X")) Player = "O";
        //else Player = "X";
        boolean[] poss = IA02.suc(m);
        int[][] util = new int[7][2]; //guarda utilidade dos filhos e respetiva jogada
        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                String[][] new_m = move(m,i,"O");
                util[i][0] = Max(new_m,"O", Depth+1,i);
                util[i][1] = i;
            }
            else{ util[i][0] = Integer.MAX_VALUE;
                //if (Player.equals("O")) util[i][0] = Integer.MAX_VALUE; //para não interferir na escolha
                //else util[i][0] = Integer.MIN_VALUE;
            }
        }

        //ordenar os filhos - corresponde a fazer pesquisa binária no fundo
        Arrays.sort(util, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                return 1;
            }
        });
        col = util[0][1];
        return util[0][0];
    }

    public static int Max(String[][] m, String Player, int Depth, int Move){
        String terminal = IA02.terminal(m,Move, "O");
        if (!terminal.equals("_")) {
            //col = Move;
            return util(terminal);
        }
        if (Depth == limit){ ;
            //col = Move;
            return heuristica(m,"X");
        }

        //Prosseguir na pesquisa:
        boolean[] poss = IA02.suc(m);
        int[][] util = new int[7][2]; //guarda utilidade dos filhos e respetiva jogada
        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                String[][] new_m = move(m,i,"X");
                util[i][0] = Min(new_m,"O", Depth+1,i);
                util[i][1] = i;
            }
            else{ util[i][0] = Integer.MIN_VALUE;
                //if (Player.equals("O")) util[i][0] = Integer.MAX_VALUE; //para não interferir na escolha
                //else util[i][0] = Integer.MIN_VALUE;
            }
        }

        //ordenar os filhos - corresponde a fazer pesquisa binária no fundo
        Arrays.sort(util, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                return 1;
            }
        });
        col = util[util.length-1][1];
        return util[util.length-1][0];
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

    //função utilidade - só entra aqui se o tab for um terminal (ou seja IA02.terminal() retorna algo diferente de "_")
    public static int util(String terminal) {
        if (terminal.equals("X")) return 512;
        if (terminal.equals("O")) return -512;
        return 0;

    }

    public static int heuristica(String[][] matrix, String Player){
        //Objetivo: de todos os possíveis segmentos de 4 peças seguidas, seja na horizontal, vertical ou diagonal,
        //somar uma dada quantia consoante a quantidade de "X" e "O" em cada um desses segmentos - ver tabela do enunciado
        //para avaliar as quantias corretamente.

        int count = 0;
        //if (Player.equals("X")) count += 16;
        //else count -= 16;

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

/* INTERFACE COM O USER:

//iniciar tab vazio
tab = new String[6][7];
for (int i=0; i<6; i++)
    Arrays.fill(matrix[i],"_");

boolean value = true;
     while (value) {
          if (flag == 0) {
             // computador - joga com X
             int m = try_minimax.start(tab,8); //vem o nº da coluna
             tab = move(tab, m, "X");
             print(tab);
             if (terminal(tab,"X").equals("X")) {
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
             tab = move(tab, m, "O");
             //print(tab.getMatrix());
             if (terminal(tab, "O").equals("O")) {
                 System.out.println("You won!");
                 value = false;
             }
             else {
                 //simulação
                 flag = 0; //para o ciclo executar na vez do pc
             }
          }
     }*/