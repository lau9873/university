// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class BTree<T> {   
    private BTNode<T> root; // raiz da arvore

    // Construtor
    BTree() {
	root = null;
    }

    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}

    // Verificar se arvore esta vazia
    public boolean isEmpty() {
	return root == null;
    }

    // --------------------------------------------------------

    // Numero de nos da arvore   
    public int numberNodes() {
	return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n) {
	if (n == null) return 0;
	return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------

    // Altura da arvore
    public int depth() {
	return depth(root);
    }

    private int depth(BTNode<T> n) {
	if (n == null) return -1;
	return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------
   
    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
	return contains(root, value);
    }

    private boolean contains(BTNode<T> n, T value) {
	if (n==null) return false;
	if (n.getValue().equals(value)) return true;
	return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

    // --------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
	System.out.print("PreOrder:");
	printPreOrder(root);
	System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
	if (n==null) return;
	System.out.print(" " + n.getValue() );
	printPreOrder(n.getLeft());
	printPreOrder(n.getRight());
    }

    // --------------------------------------------------------
   
    // Imprimir arvore em InOrder
    public void printInOrder() {
	System.out.print("InOrder:");
	printInOrder(root);
	System.out.println();
    }

    private void printInOrder(BTNode<T> n) {
	if (n==null) return;
	printInOrder(n.getLeft());
	System.out.print(" " + n.getValue());
	printInOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em PostOrder
    public void printPostOrder() {
	System.out.print("PostOrder:");
	printPostOrder(root);
	System.out.println();
    }

    private void printPostOrder(BTNode<T> n) {
	if (n==null) return;
	printPostOrder(n.getLeft());
	printPostOrder(n.getRight());
	System.out.print(" " + n.getValue());
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
	System.out.print("BFS:");
      
	MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
	q.enqueue(root);
	while (!q.isEmpty()) {
	    BTNode<T> cur = q.dequeue();
	    if (cur != null) {
		System.out.print(" " + cur.getValue());
		q.enqueue(cur.getLeft());
		q.enqueue(cur.getRight());
	    }
	}
	System.out.println();
    }

    // --------------------------------------------------------
   
    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
	System.out.print("DFS:");
      
	MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
	q.push(root);
	while (!q.isEmpty()) {
	    BTNode<T> cur = q.pop();
	    if (cur != null) {
		System.out.print(" " + cur.getValue());
		q.push(cur.getLeft());
		q.push(cur.getRight());
	    }
	}
	System.out.println();
    }
    public int numberLeafs(){
	return numberLeafs(root);
    }
    public int numberLeafs(BTNode<T> n){
	if (n==null) return 0;
	if (n.getLeft()==null && n.getRight()==null)
	    return 1+numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
	else return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
    }
    public boolean strict() {
	return strict(root);
	
    }
    public boolean strict(BTNode<T> n) {
	if (n==null) return true;
	if (n.getLeft()==null &&  n.getRight()!=null)
	    return false && strict(n.getLeft()) && strict(n.getRight());
	if (n.getLeft()!=null &&  n.getRight()==null)
	    return false && strict(n.getLeft()) && strict(n.getRight());
	else
	    return true && strict(n.getLeft()) && strict(n.getRight());
    }
    public T path(String s) {	
	if (s.equals("R"))
	    return root.getValue();
	char[] list= s.toCharArray();
	BTNode<T> n =root;
	for (int i=0;i<list.length;i++){
	    if (list[i]=='E')
		n=n.getLeft();
	    if (list[i]=='D')
		n=n.getRight();
	    
	}
	return n.getValue();	    
    }
    public int nodesLevel(int k) {
	return nodesLevel(k,root,0);	    
    }
    public int nodesLevel(int k,BTNode<T> n,int linha) {
	if (n==root)
	    linha=0;
	if (n==null)
	    return 0;
	if (linha == k){
	    linha=0;
	    return 1;	    
	}
	return nodesLevel(k,n.getLeft(),linha+1)+nodesLevel(k,n.getRight(),linha+1);	    
    }
    static int internalNodes;
    public int internal() {
	internalNodes=0;
	internal(root);
	return internalNodes;
    }    
    public void internal(BTNode<T> n){
	if(n==null) return;
	internalNodes++;
	if (n.getLeft()==null && n.getRight()==null)
	    internalNodes--;
	internal(n.getLeft());
	internal(n.getRight());
    }
    public void cut(int d){
	if(d<=0)
	    root=null;
	else
	    cut(d,root,0);
    }
    public void cut(int d,BTNode<T> n,int linha){
	if (n==root)
	    linha=0;
	if (n==null){
	    return;
	}
	if (linha == d-1){
	    n.setLeft(null);
	    n.setRight(null);
	    linha=0;
	    return;
	}
	cut(d,n.getLeft(),linha+1);
	cut(d,n.getRight(),linha+1);	    
    }
    static int maxLevelSoFar;
    static int quant;
    static int d;
    static int[] num;
    static int[] res;
    public int[] maxLevel(){
	maxLevelSoFar=0;
	quant=0;
	d=depth()+1;
	num=new int[d];
	maxLevel(root,0);
	for(int i:num)
	    if(i>maxLevelSoFar)
		maxLevelSoFar=i;
	for(int i:num)
	    if(i==maxLevelSoFar)
		quant++;
	res= new int[2];
	res[0]=maxLevelSoFar;
	res[1]=quant;
	//System.out.println(res[0]+" "+res[1]);
	return res;
    }
    public void maxLevel(BTNode<T> n, int linha){
	if (n==root)
	    linha=0;
	if(n==null){
	    linha=0;
	    return;
	}
	
	num[linha]++;
	maxLevel(n.getLeft(), linha+1);
	maxLevel(n.getRight(), linha+1);
	
    }
    static int count;
    public int count() {
	count=0;
	count(root);
	return count;
    }
    public void count(BTNode<T> n){
	if(n==null) return;
	if((n.getRight()!=null && n.getLeft()==null) ||(n.getRight()==null && n.getLeft()!=null) )
	    count++;
	count(n.getLeft());
	count(n.getRight());
	    
	
    }
    static int resp;
    public int level(T v){
	resp=-1;
        level(v,root,0);
	return resp;
    }
    public void level(T v,BTNode<T> n,int nivel){
	if(n==null) return;
	if(n.getValue()==v && (resp==-1 || resp>nivel)){
	    resp=nivel;
	    return;
	}
	level(v,n.getLeft(),nivel+1);
	level(v,n.getRight(),nivel+1);
	
    }
}
