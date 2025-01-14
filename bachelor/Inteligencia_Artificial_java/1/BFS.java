import java.util.Arrays;

public class BFS {
    static int[][] ConfigInicial, ConfigFinal;

    public static void Start(int[][] configInicial, int[][] configFinal) {
        long start = System.currentTimeMillis();
        ConfigInicial = configInicial;
        ConfigFinal = configFinal;
        LinkedListStack<Node<int[][]>> pilha = new LinkedListStack<Node<int[][]>>();
        Node<int[][]> node = new Node<>(configInicial, null, 0);
        pilha.push(node);

        LinkedListQueue<Node<int[][]>> sonAux = new LinkedListQueue<Node<int[][]>>();
        int[][] moves = IA01.poss(node.getValue());
        for (int i = 0; i < 4; i++) {
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            Node<int[][]> son = new Node<>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth() + 1);
            sonAux.enqueue(son);
        }

        Node<int[][]> test = sonAux.dequeue();

        System.out.println("Breath First Search:");
        String s = Search(test, pilha, sonAux);
        while (s.length() == 0) {
            test = sonAux.dequeue();
            s = Search(test, pilha, sonAux);
        }
        System.out.println("Caminho : " + s);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Tempo de execução em milissegundos:"+ elapsed);
        System.out.println();
    }

    public static String Search(Node<int[][]> node, LinkedListStack<Node<int[][]>> pilha, LinkedListQueue<Node<int[][]>> sonAux) {
        pilha.push(node);
        //Ver se o nó é solução - retornar se for
        if (Arrays.deepEquals(node.getValue(), ConfigFinal)) {
            System.out.println("Profundidade = " + node.getDepth());
            System.out.println("Número de nós visitados em memória:"+ pilha.size());
            return Pathtosolution(node);
        }

        //Se não for solução
        int[][] moves = IA01.poss(node.getValue());
        //Gerar sucessores do nós
        for (int i = 0; i < 4; i++) {
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            Node<int[][]> son = new Node<>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth() + 1);
            //Testa se não é um nó igual ao avô, não faz sentido mover uma peça num sentido
            // e movê-la de imediato no sentido contrário
            if (!Arrays.deepEquals(son.getValue(),pilha.top().getBefore().getValue()))
                sonAux.enqueue(son);
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

    public static String KindMove(Node<int[][]> node, int[][] before) {
        //Retorna a descrição do movimento da única peça adjacente à casa vazia que consegue fazer o dado movimento
        int[] z1 = IA01.zero(node.getValue());
        int[] z2 = IA01.zero(before);
        int difx = z1[0] - z2[0], dify = z1[1] - z2[1];
        if (difx != 0) {
            if (difx == 1) return "cima";
            else return "baixo";
        } else {
            if (dify == 1) return "esquerda";
        }
        return "direita";
    }
}
