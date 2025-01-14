//Iterativo em profundidade (não informada)Como chega a configInicial?
//(É melhor que a class seja só para executar a busca, não para fazer o main,
//melhor ter só o main na principal e chamar BuscaIterativa.Start(configInicial, depth))

import java.util.Arrays;

public class NotInformed{
    static int[][] ConfigInicial, ConfigFinal;

    public static void Start(int[][] configInicial, int depth, int[][] configFinal){
        ConfigInicial = configInicial;
        ConfigFinal = configFinal;
        LinkedListStack<Node<int[][]>> pilha = new LinkedListStack<Node<int[][]>>();
        Node<int[][]> node = new Node<int[][]>(configInicial,null,0);
        pilha.push(node);
        if (!IA01.solvability(ConfigInicial,ConfigFinal)){
            System.out.println("It is impossible to reach a solution");
            return;
        }

        LinkedListQueue<Node<int[][]>> sonAux = new LinkedListQueue<Node<int[][]>>();
        int[][] moves = IA01.poss(node.getValue());
        for (int i=0; i<4; i++) {
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            Node<int[][]> son = new Node<int[][]>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth() + 1);
            sonAux.enqueue(son);
        }

        Node<int[][]> test = sonAux.dequeue();
        String s = Search(test,pilha,depth,sonAux);
        System.out.println("Pesquisa iterativa em profundidade:");
        while (s.length() == 0){
            depth++;
            s = Search(node,pilha,depth,sonAux);
        }
       System.out.println("Caminho : " + s);
    }

    public static String Search(Node<int[][]> node, LinkedListStack<Node<int[][]>> pilha, int depth, LinkedListQueue<Node<int[][]>> sonAux){
        pilha.push(node);
        //Ver se o nó é solução - retornar se for
        if (Arrays.deepEquals(node.getValue(),ConfigFinal)){
            System.out.println("Profundidade = " + node.getDepth());
            return Pathtosolution(pilha);
        }

        //Se não for solução
        String s = "";
        if (node.getDepth() < depth){
            LinkedListQueue<Node<int[][]>> sonAux1 = new LinkedListQueue<Node<int[][]>>();
            int[][] moves = IA01.poss(node.getValue());

            for (int i=0; i<4; i++){
                if (moves[i][0] == -1 || moves[i][1] == -1) continue;
                Node<int[][]> son = new Node<int[][]>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth()+1);
                if (!Arrays.deepEquals(son.getValue(),pilha.top().getValue()))
                    sonAux1.enqueue(son);
                //No caso da busca informada reorganizar antes de retirar o primeiro
            }

            while (!sonAux1.isEmpty() && s.length() == 0){
                Node<int[][]> test = sonAux1.dequeue();
                s = s + Search(test,pilha,depth,sonAux1);
                pilha.pop();
            }
            return s;
        }

        if (node.getDepth() == depth && !sonAux.isEmpty()) {
            while (!sonAux.isEmpty() && s.length() == 0){
                pilha.pop();
                Node<int[][]> test = sonAux.dequeue();
                s = s + Search(test,pilha,depth,sonAux);
            }
            return s;
        }

        LinkedListStack<Node<int[][]>> p = new LinkedListStack<>();
        LinkedListQueue<Node<int[][]>> f = new LinkedListQueue<>();
        pilha = p; sonAux = f; //FAZ FALTA?? testar tempo de execução para ver se sim!
        return "";

    }


    public static String Pathtosolution(LinkedListStack<Node<int[][]>> path){
        String out = " ";
        while (path.size() > 1){
            Node<int[][]> node = path.pop();
            if (Arrays.deepEquals(node.getValue(),ConfigInicial)) return out;
            out = KindMove(node, path.top().getValue()) + " " + out;
        }
        return out;
    }

    public static String KindMove(Node<int[][]> node, int[][] before){
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
}
