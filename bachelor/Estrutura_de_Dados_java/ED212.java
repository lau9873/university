class ED212{
    public static int[] sumLevels(BTree<Integer> t) {
	int d=t.depth()+1;
	int[] list= new int[d];
	for (int i=0;i<d;i++)
	    list[i]=sumLevel(t,i,t.getRoot(),0);
	return list;
    }
    public static int sumLevel(BTree<Integer> t,int k,BTNode<Integer> n,int linha){
	if (n==t.getRoot())
	    linha=0;
	if (n==null)
	    return 0;
	if (linha == k){
	    linha=0;
	    return n.getValue();	    
	}
	return sumLevel(t,k,n.getLeft(),linha+1)+sumLevel(t,k,n.getRight(),linha+1);
    }
}
