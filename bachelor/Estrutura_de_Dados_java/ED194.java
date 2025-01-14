
public class ED194 {
   public static void reverse(MyStack<Integer> s, int n) {
      	MyStack<Integer> revertido= new LinkedListStack<Integer>();
	MyStack<Integer> normal= new LinkedListStack<Integer>();
	for(int i=0;i<n;i++){
	    revertido.push(s.top());
	    s.pop();
	}
	for(int i=0;i<n;i++){
	    normal.push(revertido.top());
	    revertido.pop();
	}  
	for (int i =0;i<n;i++){
	    s.push(normal.top());
	    normal.pop();
	}
   }
}
