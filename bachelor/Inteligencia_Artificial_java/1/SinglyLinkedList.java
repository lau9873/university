// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------
/*
public class SinglyLinkedList<T> {
    private Node<T> first;    // Primeiro no da lista
    private int size;         // Tamanho da lista

    // Construtor (cria lista vazia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna o tamanho da lista
    public int size() {
        return size;
    }

    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v ao final da lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty()) return null;
        return first.getValue();
    }

    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
        if (isEmpty()) return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
        if (isEmpty()) return;
        first = first.getNext();
        size--;
    }

    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo com for e uso de de size para mostrar alternativa ao while
            Node<T> cur = first;
            for (int i=0; i<size-2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Converte a lista para uma String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null) str += ",";
        }
        str += "}";
        return str;
    }

    //devolve o valor do nó na posição pos
    public T get(int pos){
        if (pos < 0 || pos > size-1 || isEmpty()) return null;
        Node <T> cur = first;
        for (int i=0; i<size; i++){
            if (i == pos) break;
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    //remove e devolve o elemento na posição pos
    public T remove(int pos){
        if ( isEmpty() ) return null;
        if (pos == 0){
            Node <T> toreturn = first;
            removeFirst();
            return toreturn.getValue();
        }
        if ( pos >= size || pos<0 ) return null;
        Node <T> before = first;
        Node <T> cur = first;
        Node <T> after = first.getNext();
        for (int i=0; i<=pos; i++){
            if (i==pos){
                before.setNext(after);
                size--;
                break;
            }
            if (i != 0 ) before = before.getNext();
            cur = cur.getNext();
            after = after.getNext();
        }
        return cur.getValue();
    }

    //cria e devolve uma nova lista que é uma cópia exacta da lista para a qual foi chamado o método
    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        Node <T> cur = first;
        int size0 = size;
        for (int i=0; i<size0; i++){
            copy.addLast(cur.getValue());
            cur = cur.getNext();
        }
        return copy;
    }

    //duplica cada elemento da lista
    public void duplicate() {
        int size0 = size;
        Node <T> cur = first;
        for (int i=0; i<size0; i++){
            Node <T> toadd = new Node<T>(cur.getValue(),cur.getNext());
            cur.setNext(toadd);
            size++;
            cur = cur.getNext().getNext();
        }
    }

    //conta e devolve o número de ocorrências do valor value
    public int count(T value){
        if (isEmpty()) return 0;
        int count = 0;
        Node <T> cur = first;
        for (int i=0; i<size; i++){
            if (cur.getValue().equals(value)) count++;
            cur = cur.getNext();
        }
        return count;
    }

    //devolver uma nova lista que é uma cópia da lista original, mas apenas dos elementos entre as posições a e b
    public SinglyLinkedList<T> cut(int a, int b){
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        if (!isEmpty()){
            Node <T> cur = first;
            for (int i=0; i<=b; i++){
                if (i >= a) copy.addLast(cur.getValue());
                cur = cur.getNext();
            }
        }
        return copy;
    }

    //"rodar" a lista k elementos para a direita
    //obter lista com os ultimos k elementos
    //remover estes ultimos k da lista original e acrescentar no inicio
    public void shift1(int k){
        if (isEmpty()) return;
        if (k==0) return;
        if (k <= size/2) {
            SinglyLinkedList<T> copylast = cut(size - k, size - 1);
            for (int i = k; i > 0; i--)
                removeLast();
                //remove(size - i);
            for (int i = 0; i < k; i++) {
                addFirst(copylast.getLast());
                copylast.removeLast();
            }
        }
        else{
            SinglyLinkedList<T> copylast = cut(0,size-k-1);
            for (int i = 0; i <copylast.size(); i++)
                removeFirst();
            while (copylast.size() != 0){
                addLast(copylast.getFirst());
                copylast.removeFirst();
            }
        }
    }

    public void shift2(int k){
        if (isEmpty()) return;
        if (k==0) return;
        int n = size;
        SinglyLinkedList<T> copyfirst = new SinglyLinkedList<>();
        for (int i=0; i<n-k; i++) {
            copyfirst.addLast(first.getValue());
            removeFirst();
        }
        while ( !copyfirst.isEmpty() ) {
            this.addLast(copyfirst.first.getValue());
            copyfirst.removeFirst();
        }
    }

    public void shift(int k){
        if ( isEmpty() ) return;
        if ( k == 0 ) return;
        Node<T> last = first.getNext();
        Node<T> before = first;
        for (int i = 1; i < size-1; i++) {
            if (i<size-k) before = before.getNext();
            last = last.getNext();
        }
        Node<T> newfirst = before.getNext();
        before.setNext(null);
        last.setNext(first);
        first = newfirst;
    }

    //Deve devolver uma nova lista que é igual à lista original, mas invertida
    public SinglyLinkedList<T> reverse() {
        SinglyLinkedList<T> out = new SinglyLinkedList<>();
        if (!isEmpty()){
            Node<T> cur = first;
            while (out.size()!=size) {
                out.addFirst(cur.getValue());
                cur = cur.getNext();
            }
        }
        return out;
    }

    //Deve devolver um array contendo as posições (por ordem crescente) de todas as ocorrências do elemento elem na lista
    public int[] occurrences(T elem){
        if (isEmpty()) return null;
        int i = 0,j = 0, k = count(elem);
        if (k==0) return null;
        int[] out = new int[k];
        Node <T> cur = first;
        while (i < k){
            if (cur.getValue().equals(elem)){
                out[i] = j;
                i++;
            }
            j++;
            cur = cur.getNext();
        }
        return out;
    }

    //Deve remover da lista todos os elementos que estão na lista toRemove
    public void remove(SinglyLinkedList<T> toRemove){
        if (this.isEmpty() || toRemove.isEmpty()) return;
        Node<T> toberemove = toRemove.first;
        for (int i=0; i<toRemove.size; i++){
            while (first != null && first.getValue().equals(toberemove.getValue())){
                removeFirst();
            }
            Node<T> cur = first;
            Node<T> sentinela = new Node<T>(null, first);
            while (cur != null){
                if ( cur.getValue().equals(toberemove.getValue())){
                    sentinela.setNext(cur.getNext());
                    size--;
                }
                else sentinela = cur;
                cur = cur.getNext();
            }
            toberemove = toberemove.getNext();
        }
    }

    //remove da lista todas as ocorrências do valor value
    public void removeAll(T value){
        if ( isEmpty() ) return;
        int[] O = occurrences(value);
        if ( O == null ) return;
        while( size>0 && first.getValue().equals(value)){
            removeFirst();
        }
        if ( !isEmpty() ) {
            Node<T> before = first;
            Node<T> cur = before.getNext();
            int n = size;
            while (cur != null) {
                if (cur.getValue().equals(value)) {
                    before.setNext(cur.getNext());
                    size--;
                } else before = before.getNext();
                cur = cur.getNext();
            }
        }
    }

}
*/