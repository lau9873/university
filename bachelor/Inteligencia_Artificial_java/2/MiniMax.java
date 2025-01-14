import java.util.Arrays;
import java.util.Comparator;

public class MiniMax {
    static int col;
    //Não testar se alguem ganhou até á setima jogada, antes disso ninguem consegue fazer 4 em linha.


    //testar se cada nó é terminal, se for retornar a utilidade, se não retonar o max/min da utlidade dos filhos
    //se já atingimos o limite max de profundidade, então retornar a heuristica do nó
    public static int start(GameNode node, int limit){
        String terminal = IA02.terminal(node);
        if (!terminal.equals("_")){
            return util(terminal);
        }

        if (node.getDepth() != limit){
            boolean[] poss = IA02.suc(node.getValue());
            for (int i=0; i<7; i++){
                if (poss[i]){
                    String p = " ";
                    if (node.getPlayer().equals("X")) p = "O";
                    else p = "X";
                    //GameNode n = move(node, i, p);
                    GameNode n = new GameNode(copy(node.getValue()), p);
                    n.setMove(i);
                    n.move(i);
                    n.setDepth(node.getDepth()+1);
                    node.setNext(n);
                }
            }

            int K = node.getNext().size();
            int[][] v = new int[K][2];
            for (int i=0; i<K; i++){
                GameNode cur = node.getNext().dequeue();
                v[i][0] = start(cur, limit);
                v[i][1] = cur.getMove();
                node.setNext(cur);
            }
            Arrays.sort(v, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] < o2[0]) return -1;
                    return 1;
                }
            });
            if (node.getPlayer().equals("X")){
                col = v[K-1][1];
                return v[K-1][0];
            }
            if (node.getPlayer().equals("O")){
                col = v[0][1];
                return v[0][0];
            }
        }

        return heuristica(node);
    }


    public static GameNode move(GameNode node, int m, String player){
        /*LinkedListStack<String>[] aux = new LinkedListStack[];
        for (int i=0; i<7; i++)
            aux[i]*/
        GameNode n = new GameNode(node.getValue(), player);
        for (int i=0; i<=m; i++){
            if (i==m){
                LinkedListStack<String> aux1, aux2;
                aux1 = new LinkedListStack<>();
                while (node.getValue()[i].size() != 0)
                    aux1.push(node.getValue()[i].pop());
                aux2 = new LinkedListStack<>();
                while (aux1.size() != 0)
                    aux2.push(aux1.pop());
                aux2.push(player);

                //node.getValue()[i].push(player);
                //n.setValue(aux2);
                //node.getValue()[i].pop();
            }
        }
        return n;
    }

    public static LinkedListStack<String>[] copy(LinkedListStack<String>[] t){
        LinkedListStack<String>[] copy = new LinkedListStack[7];
        for (int i=0; i<7; i++){
            if (t[i].size() == 0) copy[i] = new LinkedListStack<>();
            else copy[i] = t[i].copy(); //metodo novo na classe das linkedlists
        }
        return copy;
    }

    //função utilidade - só entra aqui se o tab for um terminal (ou seja IA02.terminal() retorna algo diferente de "_")
    public static int util(String terminal) {
        if (terminal.equals("X")) return 512;
        if (terminal.equals("O")) return -512;
        return 0;

    }

    public static int heuristica(GameNode node){
        //Objetivo: de todos os possíveis segmentos de 4 peças seguidas, seja na horizontal, vertical ou diagonal,
        //somar uma dada quantia consoante a quantidade de "X" e "O" em cada um desses segmentos - ver tabela do enunciado
        //para avaliar as quantias corretamente.

        int count = 0;
        if (node.getPlayer().equals("X")) count += 16;
        else count -= 16;

        //contar na vertical e na horizontal:
        for (int j=0; j<7; j++){
            int vX = 0, vO = 0;
            for (int d=0; d<3; d++) {
                for (int i = d; i < 4+d; i++) {
                    if (node.getMatrix()[i][j].equals("X")) vX++;
                    if (node.getMatrix()[i][j].equals("O")) vO++;
                }
                count += evalution(vX,vO);
            }
        }

        for (int j=0; j<6; j++){
            int hX = 0, hO = 0;
            for (int d=0; d<=3; d++) {
                for (int i = d; i < 4+d; i++) {
                    if (node.getMatrix()[j][i].equals("X")) hX++;
                    if (node.getMatrix()[j][i].equals("O")) hO++;
                }
                count += evalution(hX,hO);
            }
        }

        //contar na diagonal, sentido esquerda - direita, abaixo da diagonal principal (incluindo):
        for (int j=0; j<=2; j++) {
            int dX = 0, dO = 0;
            for (int i=j; i<=2; i++){
                for (int d=0; d<=3; d++) {
                    if (node.getMatrix()[i+d][j+d].equals(("X"))) dX++;
                    if (node.getMatrix()[i+d][j+d].equals(("O"))) dO++;
                }
            }
            count += evalution(dX,dO);
        }

        for (int i=0; i<=2; i++) {
            int dX = 0, dO = 0;
            for (int j=i+1; j<=3; j++){
                for (int d=0; d<=3; d++) {
                    if (node.getMatrix()[i+d][j+d].equals(("X"))) dX++;
                    if (node.getMatrix()[i+d][j+d].equals(("O"))) dO++;
                }
            }
            count += evalution(dX,dO);
        }

        //contar na diagonal, sentido direita - esquerda, acima da diagonal principal:
        for (int i=0; i<=2; i++) {
            int dX = 0, dO = 0;
            for (int j=i+1; j<=3; j++){
                for (int d=0; d<=3; d++) {
                    if (node.getMatrix()[i+d][6-j-d].equals(("X"))) dX++;
                    if (node.getMatrix()[i+d][6-j-d].equals(("O"))) dO++;
                }
            }
            count += evalution(dX,dO);
        }

        //contar na diagonal, sentido direita - esquerda, abaixo da diagonal principal inversa (incluindo):
        for (int j=0; j<=2; j++) {
            int dX = 0, dO = 0;
            for (int i=j; i<=2; i++){
                for (int d=0; d<=3; d++) {
                    if (node.getMatrix()[i+d][6-j-d].equals(("X"))) dX++;
                    if (node.getMatrix()[i+d][6-j-d].equals(("O"))) dO++;
                }
            }
            count += evalution(dX,dO);
        }

        //contar na diagonal, sentido direita - esquerda, acima da diagonal principal inversa:
        /*for (int j=5, i=0; j>=3 ; j--){
            int dX = 0, dO = 0;
            for (int d=0; d<6-(5-j); d++){
                if (node.getMatrix()[i+d][j-d].equals(("X"))) dX++;
                if (node.getMatrix()[i+d][j-d].equals(("O"))) dO++;
            }
            count += evalution(dX,dO);
        }*/

        return count;
    }

    public static int evalution(int x, int o){
        int c=0;
        if ( x!=0 && o!=0) return c;
        switch (x){
            case 1: c = 1; break;
            case 2: c = 10; break;
            case 3: c = 50; break;
        }
        switch (o){
            case 1: c = -1; break;
            case 2: c = -10; break;
            case 3: c = -50; break;
        }
        return c;
    }
}
