import java.util.Arrays;

public class NewA_estrelaB {
    static int[][] ConfigInicial, ConfigFinal;
    static String solution;
    static int cost;

    public static void Start(int[][] configInicial, int[][] configFinal){
        long start = System.currentTimeMillis();
        ConfigInicial = configInicial;
        ConfigFinal = configFinal;
        solution = "";

        InfoNode<int[][]> node = new InfoNode<>(configInicial,null,0);
        heuristicsB(node);
        LinkedListStack<InfoNode<int[][]>> pilha = new LinkedListStack<>();
        int limit = (int)Math.pow(2,15);
        MinHeap<InfoNode<int[][]>> sonAux = new MinHeap<>(limit);

        System.out.println("A* - second heuristic:");
        Search(node,pilha,sonAux);
        System.out.println("Depth = " + cost);
        System.out.println("Path : " + solution);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Tempo de execução em milissegundos:"+ elapsed);
        System.out.println("Número de nós visitados em memória:"+ pilha.size());
        System.out.println();
    }

    public static void Search(InfoNode<int[][]> node, LinkedListStack<InfoNode<int[][]>> pilha, MinHeap<InfoNode<int[][]>> sonAux){
        pilha.push(node);

        //Ver se o nó é solução
        if (Arrays.deepEquals(node.getValue(),ConfigFinal)){
            node.setH(node.getDepth()); //como é solução a heuristica é 0 + depth
            if (sonAux.min().getH() >= node.getH()) {
                //Se o custo estimado de uma possível solução mais adiante, em particular a menor estimativa,
                // é superior ao custo desta solução então esta é a solução ótima.
                solution = Pathtosolution(node);
                cost = node.getDepth();
                return;
            }
            else {
                //Possibilidade de se encontrar uma solução mais baixa
                sonAux.insert(node);
                Search(sonAux.removeMin(), pilha, sonAux);
            }
        }
        if (!solution.equals("")) return;

        int[][] moves = IA01.poss(node.getValue());

        for (int i=0; i<4; i++){
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            InfoNode<int[][]> son = new InfoNode<>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth()+1);
            heuristicsB(son);
            if (!testNode(pilha,son)) {
                sonAux.insert(son);
                //if (son.getH() == node.getH()) Search(son,pilha,sonAux);
            }
        }

        while (!sonAux.isEmpty()){
            InfoNode<int[][]> test = sonAux.removeMin();
            Search(test,pilha,sonAux);
        }
        return;
    }
    public static String Pathtosolution(InfoNode<int[][]> node){
        //Através da referência ao nó pai, determina o caminho entre o nó que já é solução e a configInicial
        String out = " ";
        while (!Arrays.deepEquals(ConfigInicial, node.getBefore().getValue())){
            out = KindMove(node, node.getBefore().getValue()) + " " + out;
            node = node.getBefore();
        }
        out = KindMove(node, node.getBefore().getValue()) + " " + out;
        return out;
    }

    public static String KindMove(InfoNode<int[][]> node, int[][] before){
        //Retorna a descrição do movimento da única peça adjacente à casa vazia que consegue fazer o dado movimento
        int[] z1 = IA01.zero(node.getValue());
        int[] z2 = IA01.zero(before);
        int difx = z1[0] - z2[0], dify = z1[1] - z2[1];
        if (difx != 0){
            if (difx == 1) return "cima";
            else return "baixo";
        }
        else{ if (dify == 1) return "esquerda"; }
        return "direita";
    }

    public static void heuristicsB(InfoNode<int[][]> node){
        //Somar as distancias de cada peça ao seu lugar
        int count = 0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                for (int k=0; k<4; k++){
                    for (int r=0; r<4; r++){
                        if (ConfigFinal[k][r] == node.getValue()[i][j])
                            count += Math.abs(i-k) + Math.abs(j-r);
                    }
                }
            }
        }
        if (node.getDepth() == 0){
            node.setH(count);
            return;
        }
        if (node.getBefore().getH() > count + node.getDepth()) node.setH(node.getBefore().getH());
        else node.setH(count+node.getDepth());
    }


    public static boolean testNode(LinkedListStack<InfoNode<int[][]>> pilha, InfoNode<int[][]> node){
        boolean value = false;
        LinkedListStack<InfoNode<int[][]>> copy = new LinkedListStack<>();
        while (!pilha.isEmpty()){
            InfoNode<int[][]> cur = pilha.pop();
            copy.push(cur);
            if (Arrays.deepEquals(node.getValue(), cur.getValue())){
                value = true;
                break;
            }
        }
        while (!copy.isEmpty()){
            InfoNode<int[][]> n = copy.pop();
            pilha.push(n);
        }
        return value;
    }
}

