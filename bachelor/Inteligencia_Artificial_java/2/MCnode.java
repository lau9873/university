import java.util.Arrays;

class MCnode implements Comparable<MCnode> {
    String[][] tab;
    int move;
    int times, wins;
    String player;
    MCnode pai;
    MCnode[] filhos;

    MCnode (String[][] t, int m, MCnode dad, String p){
        tab = t;
        pai = dad;
        move = m;
        player = p;
        inicializeFilhos();
    }

    MCnode (String[][] t, int k){
        //construtor da raiz
        tab = t;
        player = "O";
        move = -1;
        filhos = new MCnode[k];
    }

    MCnode (){
        tab = null;
    }

    public void inicializeFilhos (){
        int k = MCTS.count(tab,IA02.suc(tab)); //numero de filhos validos
        filhos = new MCnode[k];
    }

    public void addFilho (MCnode filho){
        int i=0;
        while (filhos[i] != null) i++;
        filhos[i] = filho;
    }

    public Double getUCB(){
        if (times == 0) return (double)Integer.MAX_VALUE;
        if (pai != null)
            return (double)wins/times + (double)5*Math.sqrt(Math.log(pai.times) / times);
        //No caso de querer alterar a constante c, basta mudar o fator que multiplica
        //por Math.sqrt(Math.log(pai.times) / times) (=5)
        return (double)wins/times;
    }

    @Override
    public int compareTo(MCnode n){
        if (this.tab == null && n.tab == null) return 0;
        if (this.tab == null) return Integer.MAX_VALUE-100;
        if (n.tab == null) return Integer.MIN_VALUE+100;
        if (getUCB() >= n.getUCB()) return -1;
        return 1;
    }

    @Override
    public String toString(){
        if (tab == null) return "";
        //return Arrays.deepToString(tab) + " | " + getUCB();
        return getUCB().toString();
    }
}
