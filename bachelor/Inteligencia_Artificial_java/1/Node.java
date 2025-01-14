// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Classe com um no generico
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class Node<T> {
    private T value;      // Valor guardado no no
    private Node<T> dad; // Referencia para o no anterior da lista
    private int depth;

    // Construtor
    Node(T v, Node<T> n, int d) {
        value = v;
        dad = n;
        depth = d;
    }

    // Getters e Setters
    public T getValue() { return value; }
    public int getDepth(){ return depth;}
    public Node<T> getBefore()  { return dad; }
    public void setValue(T v) { value=v; }
    public void setDad(Node<T> n) { dad = n; }
}
