public class ED213{
    static int maxSoFar;
    static String bestPath;
    
    public static String maxSum(BTree<Integer> t){
	maxSoFar=0;
	maxSum(t.getRoot(),0,"");
	return bestPath;	    
    }
    public static void maxSum(BTNode<Integer> n,int sum, String path){
	if (n==null) return;
	sum+=n.getValue();
	if (n.getLeft()==null && n.getRight()==null){
	    if(maxSoFar<sum){
		maxSoFar=sum;
		bestPath=path;
	    }
	}
	maxSum(n.getLeft(), sum, path+"E");
	maxSum(n.getRight(), sum, path+"D");		
    }
}
	
