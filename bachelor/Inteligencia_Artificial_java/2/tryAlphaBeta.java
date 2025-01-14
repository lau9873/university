import java.util.Arrays;
import java.util.Comparator;

public class tryAlphaBeta {
    static  int nodes; //num de nos expandidos
    static int limit;
    static int col;

    public static int start1(String[][] m, int l){
        //AlphaBeta
        nodes = 1;
        col = -1;
        limit = l;

        boolean[] poss = IA02.suc(m);
        for (int i=0, c=Integer.MIN_VALUE, max=c; i<7; i++){
            if (poss[i]) {
                String[][] new_m = IA02.move(m,i,"X");
                nodes++;
                c = Min1(new_m,1,i,Integer.MIN_VALUE,Integer.MAX_VALUE);
            }
            if (c>max){
                max = c;
                col = i;
            }
        }
        System.out.println("Numero de nos expandidos = "  + nodes);
        return col;
    }
    public static int start(String[][] m, int l){
        //Minimax
        nodes = 1;
        col = -1;
        limit = l;

        boolean[] poss = IA02.suc(m);
        for (int i=0, c=Integer.MIN_VALUE, max=c; i<7; i++){
            if (poss[i]) {
                String[][] new_m = IA02.move(m,i,"X");
                nodes++;
                c = Min(new_m,1,i);
            }
            if (c>max){
                max = c;
                col = i;
            }
        }
        System.out.println("Numero de nos expandidos = "  + nodes);
        return col;
    }

    public static int Min(String[][] m, int Depth, int Move){
        nodes++;
        String terminal = IA02.terminal(m,Move, "X");
        if (!terminal.equals("_"))
            return IA02.util(terminal);
        if (Depth == limit)
            return IA02.heuristica(m,"O");

        //Prosseguir na pesquisa:
        boolean[] poss = IA02.suc(m);
        int v = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                String[][] new_m = IA02.move(m,i,"O");
                v = Math.min(v,Max(new_m,Depth+1,i));
            }
        }

        return v;
    }

    public static int Max(String[][] m, int Depth, int Move){
        nodes++;
        String terminal = IA02.terminal(m,Move, "O");
        if (!terminal.equals("_"))
            return IA02.util(terminal);
        if (Depth == limit)
            return IA02.heuristica(m,"X");

        //Prosseguir na pesquisa:
        boolean[] poss = IA02.suc(m);
        int v = Integer.MIN_VALUE;
        //int[][] util = new int[7][2]; //guarda utilidade dos filhos e respetiva jogada
        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                String[][] new_m = IA02.move(m, i, "X");
                v = Math.max(v, Min(new_m, Depth + 1, i));
            }
        }

        return v;
    }

    public static int Max1(String[][] m, int Depth, int Move, int alpha, int beta) {
        nodes++;
        String terminal = IA02.terminal(m, Move, "O");
        if (!terminal.equals("_"))
            return IA02.util(terminal);
        if (Depth == limit)
            return IA02.heuristica(m, "X");

        //Prosseguir na pesquisa:
        int v = Integer.MIN_VALUE;
        boolean[] poss = IA02.suc(m);
        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                String[][] new_m = IA02.move(m, i, "X");
                int c = Min1(new_m,Depth+1,i, alpha, beta);
                v = Math.max(v,c);
                if (v >= beta) return v;
                alpha = Math.max(alpha,v);
            }
        }

        return v;
    }

    public static int Min1(String[][] m, int Depth, int Move, int alpha, int beta) {
        nodes++;
        String terminal = IA02.terminal(m, Move, "X");
        if (!terminal.equals("_"))
            return IA02.util(terminal);
        if (Depth == limit)
            return IA02.heuristica(m, "O");

        //Prosseguir na pesquisa:
        int v = Integer.MAX_VALUE;
        boolean[] poss = IA02.suc(m);
        for (int i = 0; i < 7; i++) {
            if (poss[i]) {
                String[][] new_m = IA02.move(m, i, "O");
                v = Math.min(v,Max1(new_m,Depth+1,i, alpha, beta));
                if (v <= alpha) return v;
                beta = Math.min(beta,v);
            }
        }
        return v;
    }
}
