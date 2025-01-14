class ED240{
    static String[] path;
    static int min;
    static int count;
    static int pos;
    public static String[] paths(BTree<Integer> t){
	min=t.getRoot().getValue();
	count=0;
	min(t.getRoot());
      	path= new String[count];
	pos=0;
	paths(t,t.getRoot(),"");
	return path;
    }
    public static void min(BTNode<Integer> n){
	if (n==null) return;
	if (n.getValue()<min){
	    min=n.getValue();
	    count=0;
	}
	if(n.getValue()==min)
	    count++;
	min(n.getLeft());
	min(n.getRight());	    
    }
    public static void paths(BTree<Integer> t,BTNode<Integer> n, String caminho){
	if(n==null) return;
	paths(t,n.getLeft(),caminho+"E");
	if (n!=t.getRoot() && n.getValue()==min){
	    path[pos]=caminho;
	    pos++;
	}
	paths(t,n.getRight(),caminho+"D");

	if (n==t.getRoot() && n.getValue()==min){
	    path[pos]="R";
	    pos++;
	}
	
    }
}
