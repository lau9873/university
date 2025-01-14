class ED211{
    static int count;
    public static int countEven(BTree<Integer> t){
	count=0;
	countEven(t.getRoot());
	return count;
    }
    public static void countEven(BTNode<Integer> n){
	if (n==null) return;
	if (n.getValue()%2==0)
	    count++;
	countEven(n.getLeft());
	countEven(n.getRight());
    }
}
