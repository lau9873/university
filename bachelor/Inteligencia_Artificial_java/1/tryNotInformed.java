import java.util.Arrays;

public class tryNotInformed{
    static int[][] ConfigInicial, ConfigFinal;

    public static void Start(int[][] configInicial, int depth, int[][] configFinal){
        long start = System.currentTimeMillis();
        ConfigInicial = configInicial;
        ConfigFinal = configFinal;

        LinkedListStack<Node<int[][]>> pilha = new LinkedListStack<>();
        Node<int[][]> node = new Node<>(configInicial,null,0);
        LinkedListStack<Node<int[][]>> sonAux = new LinkedListStack<>();

        System.out.println("Iterative Depth First Search:");
        String s = Search(node,pilha,depth,sonAux);
        while (s.length() == 0){
            //Enquanto que não encontramos a solução devemos incrementar o limite da profundidade
            depth++;
            s = Search(node,pilha,depth,sonAux);
        }
        System.out.println("Path : " + s);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Tempo de execução em milissegundos:"+ elapsed);
        System.out.println();
    }

    public static String Search(Node<int[][]> node, LinkedListStack<Node<int[][]>> pilha, int depth, LinkedListStack<Node<int[][]>> sonAux){
        pilha.push(node);
        //Ver se o nó é solução - retornar se for
        if (Arrays.deepEquals(node.getValue(),ConfigFinal)){
            System.out.println("Depth = " + node.getDepth());
            System.out.println("Número de nós visitados em memória:"+ pilha.size());
            return Pathtosolution(node);
        }

        //Se não for solução
        String s = "";
        if (node.getDepth() < depth){
            LinkedListStack<Node<int[][]>> sonAux1 = new LinkedListStack<>();
            int[][] moves = IA01.poss(node.getValue());

            //Gerar sucessores do nó
            for (int i=0; i<4; i++){
                if (moves[i][0] == -1 || moves[i][1] == -1) continue;
                Node<int[][]> son = new Node<>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth()+1);

                //Testa se não é um nó igual ao avô, não faz sentido mover uma peça num sentido
                // e movê-la de imediato no sentido contrário. No caso de pilha.top().getBefore() == null, ou seja
                // estamos ainda com os filhos da raiz prossegue.
                if (pilha.top().getBefore() == null || !Arrays.deepEquals(son.getValue(),pilha.top().getBefore().getValue()))
                    sonAux1.push(son);
            }

            while (!sonAux1.isEmpty() && s.length() == 0){
                Node<int[][]> test = sonAux1.pop();
                s = s + Search(test,pilha,depth,sonAux1);
                pilha.pop();
            }
            return s;
        }

        if (node.getDepth() == depth && !sonAux.isEmpty()) {
            while (!sonAux.isEmpty() && s.length() == 0){
                pilha.pop();
                Node<int[][]> test = sonAux.pop();
                s = s + Search(test,pilha,depth,sonAux);
            }
            return s;
        }
        return "";
    }


    public static String Pathtosolution(Node<int[][]> node){
        //Através da referência ao nó pai, determina o caminho entre o nó que já é solução e a configInicial
        String out = " ";
        while (!Arrays.deepEquals(ConfigInicial, node.getBefore().getValue())){
            out = KindMove(node, node.getBefore().getValue()) + " " + out;
            node = node.getBefore();
        }
        out = KindMove(node, node.getBefore().getValue()) + " " + out;
        return out;
    }

    public static String KindMove(Node<int[][]> node, int[][] before){
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

    public static boolean testNode(LinkedListStack<Node<int[][]>> pilha, Node<int[][]> node){
        boolean value = false;
        LinkedListStack<Node<int[][]>> copy = new LinkedListStack<>();
        while (!pilha.isEmpty()){
            Node<int[][]> cur = pilha.pop();
            copy.push(cur);
            if (Arrays.deepEquals(node.getValue(), cur.getValue())){
                value = true;
                break;
            }
        }
        while (!copy.isEmpty()){
            pilha.push(copy.pop());
        }
        return value;
    }
}
