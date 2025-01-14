public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
	MyQueue<Integer> ans = new LinkedListQueue<Integer>();
	while(!(a.isEmpty() && b.isEmpty())){
	    if(!(a.isEmpty() || b.isEmpty())){
		int nra =a.first();
		int nrb =b.first();
		if(nra<nrb){
		    ans.enqueue(a.dequeue());
		    
		}
		else{
		    ans.enqueue(b.dequeue());
		    
		}
	    }
	    else if (a.isEmpty())
		while(!(b.isEmpty()))
		    ans.enqueue(b.dequeue());
	    else if (b.isEmpty())
		while(!(a.isEmpty()))
		    ans.enqueue(a.dequeue());
	}	
	return ans;
    }
}
