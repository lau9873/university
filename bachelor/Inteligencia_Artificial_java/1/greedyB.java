import java.util.Arrays;

public class greedyB {
    static int[][] ConfigInicial, ConfigFinal;
    static String solution;

    public static void Start(int[][] configInicial, int[][] configFinal){
        long start = System.currentTimeMillis();
        ConfigInicial = configInicial;
        ConfigFinal = configFinal;
        solution = "";

        InfoNode<int[][]> node = new InfoNode<>(configInicial,null,0);
        heuristicsB(node);
        LinkedListStack<InfoNode<int[][]>> pilha = new LinkedListStack<>();
        MinHeap<InfoNode<int[][]>> sonAux = new MinHeap<>((int)Math.pow(2,12));

        System.out.println("Greedy - second heuristic:");
        solution = Search(node,pilha,sonAux);
        System.out.println("Path : " + solution);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Tempo de execução em milissegundos:"+ elapsed);
        System.out.println("Número de nós visitados em memória:"+ pilha.size());
        System.out.println();
    }

    public static String Search(InfoNode<int[][]> node, LinkedListStack<InfoNode<int[][]>> pilha, MinHeap<InfoNode<int[][]>> sonAux){
        pilha.push(node);

        //Ver se o nó é solução - retornar se for
        if (Arrays.deepEquals(node.getValue(),ConfigFinal)){
            System.out.println("Depth = " + node.getDepth());
            return Pathtosolution(node);
        }

        //Se não for solução
        String s = "";
        int[][] moves = IA01.poss(node.getValue());

        //Gerar sucessores do nó
        for (int i=0; i<4; i++){
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            InfoNode<int[][]> son = new InfoNode<>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth()+1);
            heuristicsB(son);
            //Testa se já visitou um nó igual
            if (!testNode(pilha,son))
                sonAux.insert(son);
        }

        //Visita o nó mais prioritário, até a solução ser encontrada
        while (!sonAux.isEmpty() && s.length() == 0){
            InfoNode<int[][]> test = sonAux.removeMin();
            s = Search(test,pilha,sonAux);
        }

        return s;
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
        node.setH(count);
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
