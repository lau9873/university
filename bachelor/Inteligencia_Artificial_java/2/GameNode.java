// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Classe com um no generico
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

import java.util.Arrays;

public class GameNode {
    private LinkedListStack<String>[] value;      // Valor guardado no no
    private String[][] matrix;
    private String player;
    private LinkedListQueue<GameNode> next; // Referencia para o no anterior da lista
    private int depth; //nº da jogada
    private int move;

    // Construtor
    GameNode(LinkedListStack<String>[] v, String p) {
        value = v;
        player = p;
        passtomatriz();
        next = new LinkedListQueue<GameNode>();
    }

    // Getters e Setters
    public LinkedListStack<String>[] getValue() { return value;}
    public String[][] getMatrix() {return matrix;}
    public int getDepth(){ return depth;}
    public int getMove(){return move;}
    public String getPlayer(){ return player;}
    public void setDepth(int d){ depth = d;}
    public void setMove(int i){move = i;}
    public void setValue(LinkedListStack<String>[] v) {value=v;}
    public void setNext(GameNode n) { next.enqueue(n);}
    public LinkedListQueue<GameNode> getNext() {return next;}

    public void move(int m){
        for (int i=0; i<7; i++)
            if (i==m) value[i].push(player);
        passtomatriz();
    }


    public void passtomatriz() {
        LinkedListStack<String>[] aux = new LinkedListStack[7];
        for (int i=0; i<7; i++)
            aux[i] = new LinkedListStack<>();

        String[][] matriz = new String[6][7];
        for (int i=0; i<6; i++)
            Arrays.fill(matriz[i],"_");

        /*for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                matriz[i][j] = value[j].pop();
                aux[j].push(matriz[i][j]);
            }
        }*/

        for (int j=0; j<7; j++){
            for (int i=5; i>=0; i--){
                while (value[j].size()!=0){
                    matriz[i][j] = value[j].pop();
                    aux[j].push(matriz[i][j]);
                }
            }
        }


        for (int i=0; i<7; i++){
            while (aux[i].size()!=0)
                value[i].push(aux[i].pop());
        }
        matrix =  matriz;
    }
}
