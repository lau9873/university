public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
	while(!(q.isEmpty())){
	    String pessoa=q.dequeue();
	    String fila=q.dequeue();
	    if (fila.equals("A")){
		a.enqueue(pessoa);
		
	    }
	    else if (fila.equals("B")){
		b.enqueue(pessoa);
		
	    }
	    else if (fila.equals("X")){
		if (a.size()<b.size())
		    a.enqueue(pessoa);
		else if (b.size()<a.size())
		    b.enqueue(pessoa);
		else
		    continue;
		
	    }
	}
    }
    public static void main(String[] args){
	MyQueue<String> q = new LinkedListQueue<>();
	MyQueue<String> a = new LinkedListQueue<>();
	MyQueue<String> b = new LinkedListQueue<>();
	q.enqueue("Luis");
	q.enqueue("B");
	q.enqueue("Pedro");
	q.enqueue("A");
	q.enqueue("Luisa");
	q.enqueue("A");
	q.enqueue("Joao");
	q.enqueue("X");
	q.enqueue("Jose");
	q.enqueue("X");
	q.enqueue("Miguel");
	q.enqueue("X");
	System.out.println(q);
	System.out.println(a);
	System.out.println(b);
	process(q,a,b);
	System.out.println(q);
	System.out.println(a);
	System.out.println(b);
    }
}
