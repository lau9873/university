// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Implementacao do TAD Pilha usando lista duplamente ligada
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

import java.util.Arrays;
public class LinkedListStack<T> implements MyStack<T> {
    private DoublyLinkedList<T> list;

    LinkedListStack() { list = new DoublyLinkedList<T>();}

    public void push(T v) { list.addFirst(v); }
    public T pop() {
        T ans = list.getFirst();
        list.removeFirst();
        return ans;
    }
    public T top() { return list.getFirst();}
    public int size() {return list.size();}
    public boolean isEmpty() {return list.isEmpty();}

    public String toString() {return list.toString();}


}