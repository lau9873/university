//Iterativo em profundidade (não informada)Como chega a configInicial?
//(É melhor que a class seja só para executar a busca, não para fazer o main,
//melhor ter só o main na principal e chamar BuscaIterativa.Start(configInicial, depth))

import java.util.Arrays;

public class BuscaInformada{

    public static void Start(int[][] configInicial, int depth, int[][] configFinal){
        LinkedListStack<Node<int[][]>> pilha = new LinkedListStack<Node<int[][]>>();
        Node<int[][]> node = new Node<int[][]>(configInicial,null,0);

        if (!IA01.solvability(configInicial,configFinal)){
            System.out.println("It is impossible to reach a solution");
            return;
        }

        LinkedListQueue<Node<int[][]>> sonAux = new LinkedListQueue<Node<int[][]>>();
        String s = Search(node,pilha,depth,configFinal,sonAux);

        while (!testeString(s)){
            depth++;
            s = Search(node,pilha,depth,configFinal,sonAux);
        }
        System.out.println("Pesquisa iterativa em profundidade:");
        Pathtosolution(pilha);
    }

    public static boolean testeString (String s){
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == ' ')
                return false;
        }
        return true;
    }

    public static String Search(Node<int[][]> node, LinkedListStack<Node<int[][]>> pilha, int depth, int[][] configFinal, LinkedListQueue<Node<int[][]>> sonAux){
        pilha.push(node);

        if (Arrays.deepEquals(node.getValue(),configFinal)){
            System.out.println("Profundidade = " + node.getDepth());
            return Pathtosolution(pilha);
        }

        String s = " ";
        if (node.getDepth() < depth){
            LinkedListQueue<Node<int[][]>> sonAux1 = new LinkedListQueue<Node<int[][]>>();
            int[][] moves = IA01.poss(node.getValue());

            for (int i=0; i<4; i++){
                if (moves[i][0] == -1 || moves[i][1] == -1) continue;
                Node<int[][]> son = new Node<int[][]>(IA01.suc(node.getValue(), moves[i]), node, node.getDepth()+1);
                sonAux1.enqueue(son);
                //No caso da busca informada reorganizar antes de retirar o primeiro
            }

            for (int i=0; i<sonAux1.size(); i++){
                Node<int[][]> test = sonAux1.dequeue();
                s = s + Search(test,pilha,depth,configFinal,sonAux1);
            }
            return s;
        }

        if (node.getDepth() == depth && !sonAux.isEmpty()) {
            pilha.pop();
            for (int i=0; i<sonAux.size(); i++){
                Node<int[][]> test = sonAux.dequeue();
                s = s + Search(test,pilha,depth,configFinal,sonAux);
            }
            return s;
        }

        return " ";
    }


    public static String Pathtosolution(LinkedListStack<Node<int[][]>> path){
        String out = " ";
        while (path.size() > 1){
            Node<int[][]> node = path.pop();
            out = KindMove(node, path.top().getValue()) + " " + out;
        }
        return out;
    }

    public static String KindMove(Node<int[][]> node, int[][] before){
        int[] z1 = IA01.zero(node.getValue());
        int[] z2 = IA01.zero(before);
        int difx = z1[0] - z2[0], dify = z1[1] - z2[1];
        if (difx != 0){
            if (difx == 1) return "baixo";
            else return "cima";
        }
        else{
            if (dify == 1) return "direita";
        }
        return "esquerda";
    }

}
