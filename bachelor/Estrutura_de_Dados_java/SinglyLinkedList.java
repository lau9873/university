// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

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
    public T get(int pos) {
	if (isEmpty() || size<=pos || pos<0) return null;
	Node<T> cur = first;
	for (int i=0;i<pos;i++)
	    cur=cur.getNext();	
	return cur.getValue();		    
    }
    public T remove(int pos){
	if (isEmpty() || size<=pos || pos<0) return null;
	T value=get(pos);
	if (pos==size-1){
	    removeLast();
	    return value;
	}
	if(pos==0){
	    removeFirst();
	    return value;
	}
	if(pos==1){	    
	    first.setNext(first.getNext().getNext());
	    size--;
	    return value;
	}
	Node<T> cur = first;
	for (int i=0;i<pos-1;i++)
	    cur=cur.getNext();   
	cur.setNext(cur.getNext().getNext());
	size--;
	return value;
    }
    public SinglyLinkedList<T> copy(){
	SinglyLinkedList<T> copyy= new SinglyLinkedList<>();
	Node<T> cur = first;
	for (int i=0;i<size;i++){
	    copyy.addLast(cur.getValue());
	    cur=cur.getNext();
	}
	return copyy;
    }
    public void duplicate() {
	SinglyLinkedList<T> list = this.copy();
	int s = size;
	for (int i=0; i<s; i++) {
	    removeFirst();      
	}
	Node <T> cur = list.first;
	for (int i=0; i<list.size; i++) {
	    addLast(cur.getValue());
	    addLast(cur.getValue());
	    cur = cur.getNext();        
	}
	return;
    }
    public int count(T value) {
	if (isEmpty()) return 0;
	int nr=0;
	Node<T> cur = first;
	for (int i=0; i<size;i++){
	    if (cur.getValue().equals(value))
		nr++;
	    cur=cur.getNext();
	}
	return nr;
    }
    public void removeAll(T value){
	if (isEmpty()) return;
	Node<T> cur = first;
	for (int i=0; i<size;i++){
	    if (cur.getValue().equals(value)){
		remove(i);
		i--;
	    }
	    cur=cur.getNext();
	}
    }
    public SinglyLinkedList<T> reverse(){
	SinglyLinkedList<T> nova= new SinglyLinkedList<T>();
	Node<T> cur = first;
	for (int i=0; i<size;i++){
	    nova.addFirst(cur.getValue());
	    cur=cur.getNext();
	}
	return nova;
    }
    public int[] occurrences(T elem) {
	Node<T> cur = first;
	SinglyLinkedList<Integer> nova= new SinglyLinkedList<>();
	for (int i=0; i<size;i++){
	    if (cur.getValue().equals(elem))
		nova.addLast(i);
	    cur=cur.getNext();
	}
	int[] posicoes= new int[nova.size()];
	for (int i=0; i<nova.size();i++){
    	    posicoes[i]=nova.get(i);
	}
	if(nova.isEmpty())
	    return null;
	else
	    return posicoes;
    }
    //  public void remove(SinglyLinkedList<T> toRemove) {
    //	Node<T> cur = first;
    //	Node<T> elemento;
    //	
    //	while(cur!=null){	    
    //	    elemento=toRemove.first;
    //	    while(elemento!=null){
    //		if (cur.getValue().equals(elemento.getValue())){
    //		    cur=cur.getNext();
    //		    first=cur;
    ///		    size--;  
    //		}
    //		if(cur.getNext()!=null){
    //		    if (cur.getNext().getValue().equals(elemento.getValue())){
    //			cur.setNext(cur.getNext().getNext());
    //			size--; 
    //		    }
    //		}
    //		elemento=elemento.getNext();
    //	    }
    //	    cur=cur.getNext();
    ///	}
    //}
	    

    
    public SinglyLinkedList<T> cut(int a, int b) {
	SinglyLinkedList<T> nova=new SinglyLinkedList<T>();
	Node<T> cur= first;
	for (int i=0;i<a;i++)
	    cur=cur.getNext();
	for (int j=a;j<=b;j++){
	    nova.addLast(cur.getValue());
	    cur=cur.getNext();
	}
	return nova;
    }
    public void shift(int k) {
	if (size == 1 || size==0 || isEmpty()||k==0||k==size) {return;}
	else{
	    Node<T> inicio= first;
	    Node<T> cur=first;
	    Node<T> fim=first;
	    int ta=size;
	    for (int i=0; i<ta-1;i++){
		cur=cur.getNext();
		if(i==ta-k-2)
		    fim=cur;
		if(i==ta-k-1)
		    inicio=cur;			
	    }
	    fim.setNext(null);
	    cur.setNext(first);
	    first = inicio;
	}
    }
    //----------------------------------//
    public void remove(SinglyLinkedList<T>toRemove) {
    	Node<T> cur = first;
    	Node<T> rem = toRemove.first;
    	Node<T> prev = null;
    	if (isEmpty()) return;
    	while (rem != null) {
    	    while (cur != null) {
    		if (rem.getValue().equals(cur.getValue())) {
    		    if (prev == null)  // Se cur é o primeiro elemento da lista
    			first = cur.getNext();
    		    else
    			prev.setNext(cur.getNext());
    		    size--;
		}
    		else prev = cur;
    		cur = cur.getNext();
    	    }
    	    cur = first;
	    prev = null;
    	    rem = rem.getNext();
    	}
    }

}
