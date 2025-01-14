// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Classe com um no generico
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class InfoNode<T> implements Comparable<InfoNode<T>>{
    private T value;      // Valor guardado no no
    private InfoNode<T> dad; // Referencia para o no anterior da lista
    private int depth;
    private int h; //valor da heuristica

    // Construtor
    InfoNode(T v, InfoNode<T> n, int d) {
        value = v;
        dad = n;
        depth = d;
        h = Integer.MAX_VALUE;
    }

    // Getters e Setters
    public T getValue() { return value; }
    public int getDepth(){ return depth;}
    public InfoNode<T> getBefore()  { return dad; }
    public void setValue(T v) { value=v; }
    public void setDad(InfoNode<T> n) { dad = n; }
    public int getH(){ return h;}
    public void setH(int heur){h = heur;}

    @Override
    public int compareTo(InfoNode<T> node) {
        if (this.h < node.getH()) return -1;
        return 1;
    }
}
