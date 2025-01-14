import java.awt.geom.Path2D;
import java.util.Arrays;

public class tryA_estrela {
    static int[][] ConfigInicial, ConfigFinal;
    static int heuristics; //1 se for a heuristicsA e 2 se for a heuristicsB
    //static int cost;
    static String solution;

    public static void Start(int[][] configInicial, int[][] configFinal){
        ConfigInicial = configInicial;
        ConfigFinal = configFinal;
        //heuristics = h;
        //cost = 0;
        solution = "";

        if (!IA01.solvability(ConfigInicial,ConfigFinal)){
            System.out.println("It is impossible to reach a solution");
            return;
        }

        InfoNode<int[][]> node = new InfoNode<>(configInicial,null,0);
        heuristicsA(node);
        LinkedListStack<InfoNode<int[][]>> pilha = new LinkedListStack<>();
        int limit = (int)Math.pow(2,15);
        MinHeap<InfoNode<int[][]>> sonAux = new MinHeap<>(limit);

        System.out.println("Pesquisa A*:");
        Search(node,pilha,sonAux);
        /*while (s.length() == 0){
            depth++;
            s = Search(node,pilha,depth,sonAux);
        }*/
        System.out.println("Caminho : " + solution);
    }

    public static void Search(InfoNode<int[][]> node, LinkedListStack<InfoNode<int[][]>> pilha, MinHeap<InfoNode<int[][]>> sonAux){
        pilha.push(node);
        //if (sonAux.isEmpty()) return;
        //Ver se o nó é solução - retornar se for
        if (Arrays.deepEquals(node.getValue(),ConfigFinal)){System.out.println("ENCONTRAMOS!"); solution = Pathtosolution(pilha); return;}
        //System.out.println("Profundidade = " + node.getDepth());
        //return Pathtosolution(pilha);
            /*if (node.getDepth() < cost && cost != 0){
                cost = node.getDepth();
                solution = Pathtosolution(pilha);
            }
            if (cost == 0){
                cost = node.getDepth();
                solution = Pathtosolution(pilha);
            }
            //pilha.pop();
            //Search(sonAux.removeMin(), pilha, sonAux);
        }*/

        //Se não for solução
        //MinHeap<InfoNode<int[][]>> sonAux1 = new MinHeap<>(4);
        int[][] moves = IA01.poss(node.getValue());

        for (int i=0; i<4; i++){
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            InfoNode<int[][]> son = new InfoNode<>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth()+1);
            heuristicsA(son);
            if (!Arrays.deepEquals(son.getValue(),pilha.top().getValue()) && !greedy.testNode(pilha, son)) {
                sonAux.insert(son);
                if (son.getH() == node.getH()) Search(son,pilha, sonAux);
                //System.out.println("min = " + sonAux.min().getH());
            }
        }

        moves = null;
        //No caso da busca informada reorganizar antes de retirar o primeiro
        //order(sonAux1);
        /*while (!sonAux.isEmpty()){
            InfoNode<int[][]> test = sonAux.removeMin();
            if (node.getDepth() == 0) Search(test,pilha,sonAux);
            if (cost != 0 && test.getH() < cost) Search(test,pilha,sonAux);
            //if (sonAux.size() != 0) System.out.println(sonAux.min().getH());
            if (cost == 0 && sonAux.size() != 0 && test.getH() <= sonAux.min().getH()){
                Search(test,pilha,sonAux);
                pilha.pop();
            }
            if (cost == 0 && sonAux.size() == 0){
                Search(test,pilha, sonAux);
                pilha.pop();
            }
        }

        while (!sonAux.isEmpty()){
            InfoNode<int[][]> test = sonAux.removeMin();
            Search(test,pilha,sonAux);
            pilha.pop();
        }*/
        while (!sonAux.isEmpty()){
            InfoNode<int[][]> test = sonAux.removeMin();
            //pilha = clearStack(test, pilha);
            Search(test,pilha,sonAux);
        }
        return;
    }


    public static String Pathtosolution(LinkedListStack<InfoNode<int[][]>> path){
        String out = " ";
        while (path.size() > 1){
            InfoNode<int[][]> node = path.pop();
            //if (Arrays.deepEquals(node.getValue(),ConfigInicial)) return out;
            out = KindMove(node, path.top().getValue()) + " " + out;
        }
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

    public static void heuristicsA(InfoNode<int[][]> node){
        //Calcular o nº de peças fora do lugar
        int count = 0;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if ( ConfigFinal[i][j] != node.getValue()[i][j]) count++;
            }
        }
        if (node.getDepth() == 0){
            node.setH(count);
            return;
        }
        if (node.getBefore().getH() > count + node.getDepth()) node.setH(node.getBefore().getH());
        else node.setH(count + node.getDepth());
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

    public static LinkedListQueue<InfoNode<int[][]>> order(LinkedListQueue<InfoNode<int[][]>> fila){
        //Reorganizar a fila de acordo com a função heurística
        return fila;
    }

    public static LinkedListStack<InfoNode<int[][]>> clearStack(InfoNode<int[][]> node, LinkedListStack<InfoNode<int[][]>> pilha){
        while (!pilha.isEmpty() && !Arrays.deepEquals(pilha.top().getValue(), node.getBefore().getValue())){
            pilha.pop();
        }
        return pilha;
    }
}
