import java.util.Arrays;

public class greedy {
    static int[][] ConfigInicial, ConfigFinal;
    static int cost;
    static String solution;
    //static int heuristics; //1 se for a heuristicsA e 2 se for a heuristicsB

    public static void Start(int[][] configInicial, int[][] configFinal){
        ConfigInicial = configInicial;
        ConfigFinal = configFinal;
        //heuristics = h;
        if (!IA01.solvability(ConfigInicial,ConfigFinal)){
            System.out.println("It is impossible to reach a solution");
            return;
        }

        InfoNode<int[][]> node = new InfoNode<>(configInicial,null,0);
        LinkedListStack<InfoNode<int[][]>> pilha = new LinkedListStack<>();
        MinHeap<InfoNode<int[][]>> sonAux = new MinHeap<>(4);

        System.out.println("Pesquisa Gulosa:");
        Search(node,pilha,sonAux);

        /*while (s.length() == 0){
            depth++;
            s = Search(node,pilha,depth,sonAux);
        }*/
        System.out.println("Caminho : " + solution);
    }

    public static void Search(InfoNode<int[][]> node, LinkedListStack<InfoNode<int[][]>> pilha, MinHeap<InfoNode<int[][]>> sonAux){
        pilha.push(node);
        clearHeap(sonAux);

        //if (sonAux.isEmpty()) return "";
        //Ver se o nó é solução - retornar se for
        if (Arrays.deepEquals(node.getValue(),ConfigFinal)){
            cost = node.getDepth();
            System.out.println("Profundidade = " + node.getDepth());
            solution = Pathtosolution(node);
            return;
        }

        //Se não for solução
        //MinHeap<InfoNode<int[][]>> sonAux1 = new MinHeap<>(4);
        int[][] moves = IA01.poss(node.getValue());

        for (int i=0; i<4; i++){
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            InfoNode<int[][]> son = new InfoNode<>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth()+1);
            heuristicsA(son);
            if (!testNode(pilha,son))
                sonAux.insert(son);
        }
        //No caso da busca informada reorganizar antes de retirar o primeiro
        while (!sonAux.isEmpty()){
            InfoNode<int[][]> test = sonAux.removeMin();
            Search(test,pilha,sonAux);
            //pilha.pop();
        }

        /*while (!sonAux.isEmpty()){
            pilha.pop();
            InfoNode<int[][]> test = sonAux.removeMin();
            Search(test,pilha,sonAux);
        }*/
        return;
    }


    public static String Pathtosolution(InfoNode<int[][]> node){
        String out = " ";
        while (!Arrays.deepEquals(ConfigInicial, node.getBefore().getValue())){
            out = KindMove(node, node.getBefore().getValue()) + " " + out;
            node = node.getBefore();
        }
        out = KindMove(node, node.getBefore().getValue()) + " " + out;
        return out;
    }

    public static String KindMove(InfoNode<int[][]> node, int[][] before){
        //Retorna o movimento da casa em branco (o contrario da peça movida)
        int[] z1 = IA01.zero(node.getValue());
        int[] z2 = IA01.zero(before);
        int difx = z1[0] - z2[0], dify = z1[1] - z2[1];
        if (difx != 0){
            if (difx == 1) return "baixo";
            else return "cima";
        }
        else{ if (dify == 1) return "direita"; }
        return "esquerda";
    }

    public static void clearHeap(MinHeap<InfoNode<int[][]>> p){
        while (!p.isEmpty()){
            p.removeMin();
        }
    }

    public static void heuristicsA(InfoNode<int[][]> node){
        //Calcular o nº de peças fora do lugar
        int count = 0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if ( ConfigFinal[i][j] == node.getValue()[i][j]) count++;
            }
        }
        node.setH(count);
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
        node.setH(count);
    }

    public static LinkedListQueue<InfoNode<int[][]>> order(LinkedListQueue<InfoNode<int[][]>> fila){
        //Reorganizar a fila de acordo com a função heurística
        return fila;
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
