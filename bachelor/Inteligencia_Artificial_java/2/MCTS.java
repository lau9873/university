import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.AbstractSet;

public class MCTS {
    static int col;
    static MCnode[] tree;
    static int num;
    static MCnode root;

    public static int start(String[][] tab){
        tree = new MCnode[8000]; num = 0;
        boolean[] poss = IA02.suc(tab);
        int c = count(tab,poss);
        root = new MCnode(tab,c); //raiz com c filhos
        tree[num] = root; num++;
        
        algorithm();
        choose();
        System.out.println("Numero de nos expandidos = "  + (num-1));
        return col;
    }


    public static void choose(){
        //escolher o filho da raiz que foi mais vezes visitado
        int max = 0;
        for (int i=0; i<root.filhos.length; i++){
            if (root.filhos[i].times >= max){
                max = root.filhos[i].times;
                col = root.filhos[i].move;
            }
        }
    }

    public static void algorithm(){
        int N = 4000;
        while (N > 0) {
            MCnode leaf = select(root);
            MCnode child = expand(leaf);
            int result = simulate(child);
            backPropagate(child,result);
            N--;
        }
    }


    public static int count(String[][] tab, boolean[] poss){
        int k=0;
        for (int i=0; i<7; i++){
            if (poss[i]) k++;
        }
        return k;
    }

    public static MCnode select(MCnode r){
        if (r.filhos.length == 0 || r.filhos[0] == null) return r; //chegamos a uma folha

        if (r.filhos[r.filhos.length-1] == null){ //ainda nao geramos todos os filhos
            boolean[] poss = IA02.suc(r.tab);
            Random random = new Random();
            int rand = random.nextInt(7); //gera um numero de 0 a 6
            while (!valid(r,rand,poss))
                rand = random.nextInt(7);
            String[][] new_tab = IA02.move(r.tab, rand, "X");
            MCnode n = new MCnode(new_tab, rand, r, "X");
            r.addFilho(n);
            tree[num] = n; num++;
            return n;
        }

        //se ja tivermos gerado todos os filhos da raiz - escolher o que tem ucb maior
        double max = r.filhos[0].getUCB();
        MCnode best = r.filhos[0];
        for (int i=1; i<r.filhos.length; i++){
            if (r.filhos[i].getUCB() > max){
                max = r.filhos[i].getUCB();
                best = r.filhos[i];
            }
        }
        return select(best);

    }

    public static String switchP(String player){
        if (player.equals("X")) return "O";
        return "X";
    }

    public static boolean valid(MCnode r, int rand, boolean[] poss){
        for (int k=0; k<r.filhos.length; k++){
            if (r.filhos[k] != null){
                if (r.filhos[k].move == rand) return false;
            }
        }
        return poss[rand];
    }

    public static MCnode expand(MCnode leaf){
        if (IA02.terminal(leaf.tab, leaf.move,leaf.player).equals(leaf.player)) return leaf;

        boolean[] poss = IA02.suc(leaf.tab);
        String player = switchP(leaf.player);
        Random random = new Random();
        int rand = random.nextInt(7); //gera um numero de 0 a 6
        while (!poss[rand])
            rand = random.nextInt(7);
        String[][] new_tab = IA02.move(leaf.tab,rand,player);
        MCnode n = new MCnode(new_tab,rand,leaf,player);
        leaf.addFilho(n);
        return leaf.filhos[0];

    }

    public static int simulate(MCnode child) {

        String player = switchP(child.player);
       
        String condition = IA02.terminal(child.tab, child.move,child.player);
        String[][] tab = child.tab;
        while (condition.equals("_")) { //significa que ainda nao e terminal
            Random random = new Random();
            int rand = random.nextInt(7); //gera um numero de 0 a 6
            while (!tab[0][rand].equals("_")) //gerar outras opcoes de jogada no caso da coluna estar cheia
                rand = random.nextInt(7);
            tab = IA02.move(tab, rand, player);
            condition = condition(tab,rand);
            player = switchP(player);
        }

        if (IA02.util(condition) == 512){
            return 1;
        }
        return 0;
    }

    public static String condition(String[][] tab, int move){
        String c = IA02.terminal(tab, move, "X");
        if (c.equals("draw") || c.equals("X")) return c;
        return IA02.terminal(tab, move, "O");
    }


    public static void backPropagate(MCnode n, int win){
        //o valor de win e 0 ou 1, consoante houve vitoria ou nao, por isso a atualizacao corresponde precisamente
        //a somar sempre o valor de win a node.wins e incrementar node.times
        n.wins += win; n.times++;
        MCnode cur = n.pai;
        while (cur != null){
            cur.wins += win; cur.times++;
            cur = cur.pai;
        }

        tree[num] = n; num++;
    }

}
