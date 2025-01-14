import java.util.Arrays;
import java.util.Comparator;

public class AlphaBeta {
    static int limit;
    static int col;

    public static int start(String[][] m, int l){
        limit = l;
        Max(m,"X",0,-1,Integer.MIN_VALUE, Integer.MAX_VALUE);
        return col;
    }

    public static int Min(String[][] m, String Player,int Depth, int Move, int alpha, int beta){
        String terminal = IA02.terminal(m,Move, "X");
        if (!terminal.equals("_")) {
            //int[] out = {util(terminal),Move};
            //return out;
            col = Move;
            return util(terminal);
        }

        //Prosseguir na pesquisa:
        int v = Integer.MAX_VALUE;
        boolean[] poss = IA02.suc(m);
        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                String[][] new_m = move(m,i,"O");
                int c = Integer.MAX_VALUE;
                if (Depth == limit) c = heuristica(new_m,"X");
                else c = Max(new_m,"X",Depth+1,i, alpha, beta);
                if (c <= v){
                    v=c;
                    if (v <= alpha) return v; //corte na arvore
                    if (v <= beta){ //melhor jogada até ao momento para O
                        col = i;
                        beta = v;
                    }
                }
                else {
                    if (v <= alpha) return v; //corte na arvore
                    beta = Math.min(beta, v);
                }
            }
        }
        return v;
    }

    public static int Max(String[][] m, String Player,int Depth, int Move, int alpha, int beta){
        String terminal = IA02.terminal(m,Move, "O");
        if (!terminal.equals("_")) {
            //col = Move;
            return util(terminal);
        }

        //Prosseguir na pesquisa:
        int v = Integer.MIN_VALUE;
        boolean[] poss = IA02.suc(m);
        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                String[][] new_m = move(m,i,"X");
                int c = Integer.MIN_VALUE;
                if (Depth == limit) c = heuristica(new_m,"O");
                else c = Min(new_m,"O",Depth+1,i, alpha, beta);
                if (c > v){
                    v = c;
                    if (v >= beta) return v; //corte na arvore
                    if (v >= alpha){ //melhor jogada para o X ate ao momento
                        col = i;
                        alpha = v;
                    }
                }
                else {
                    if (v >= beta) return v; //corte na arvore
                    alpha = Math.max(alpha,v);
                }
            }
        }
        return v;
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
