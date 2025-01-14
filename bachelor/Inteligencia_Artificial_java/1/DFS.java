import java.util.Arrays;

public class DFS {
    static int[][] ConfigInicial, ConfigFinal;

    public static void Start(int[][] configInicial, int[][] configFinal) {
        long start = System.currentTimeMillis();
        ConfigInicial = configInicial;
        ConfigFinal = configFinal;
        if (!IA01.solvability(configInicial,configFinal)){
            System.out.println("It is impossible to reach a solution");
            return;
        }
        LinkedListStack<Node<int[][]>> pilha = new LinkedListStack<Node<int[][]>>();
        Node<int[][]> node = new Node<int[][]>(configInicial,null,0);
        pilha.push(node);

        LinkedListStack<Node<int[][]>> sonAux = new LinkedListStack<Node<int[][]>>();
        int[][] moves = IA01.poss(node.getValue());
        for (int i=3; i>-1; i--) {
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            Node<int[][]> son = new Node<int[][]>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth() + 1);
            pilha.push(son);
        }

        Node<int[][]> test = pilha.pop();
        String s = Search(test,pilha,sonAux);
        System.out.println("Pesquisa em profundidade:");
        while (s.length() == 0) {
            test=pilha.pop();
            sonAux.push(test);
            //System.out.println(test.getDepth());
            s = Search(test, pilha, sonAux);
        }

        System.out.println("Caminho : " + s);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Tempo de execução em milissegundos:"+ elapsed);
        System.out.println();
    }
    public static String Search(Node<int[][]> node, LinkedListStack<Node<int[][]>> pilha, LinkedListStack<Node<int[][]>> sonAux){
        pilha.push(node);
        //Ver se o nó é solução - retornar se for
        if (Arrays.deepEquals(node.getValue(),ConfigFinal)){
            System.out.println("Profundidade = " + node.getDepth());
            System.out.println("Número de nós visitados em memória:"+ pilha.size());
            return Pathtosolution(pilha);
        }

        //Se não for solução
        String s = "";  
        int flag=0;
        int[][] moves = IA01.poss(node.getValue());
        for (int i = 3; i > -1; i--) {
            if (moves[i][0] == -1 || moves[i][1] == -1) continue;
            Node<int[][]> son = new Node<int[][]>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth() + 1);
            if (!testNode(sonAux,son) && !testNode(pilha,son)) {
                pilha.push(son);
                flag=1;
          }

        }
        if (flag==0) {
            sonAux.push(pilha.pop());
        }
        return "";

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
    public static String Pathtosolution(LinkedListStack<Node<int[][]>> path){
        String out = " ";
        Node<int[][]> node = path.pop();
        while (!Arrays.deepEquals(node.getValue(),ConfigInicial)){
            out = KindMove(node, node.getBefore().getValue()) + " " + out;
            node=node.getBefore();
        }
        return out;
    }
    public static String KindMove(Node<int[][]> node, int[][] before){
        //Retorna o movimento da casa em branco (o contrario da peça movida)
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
}

