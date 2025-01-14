import java.util.Scanner;
public class ED005{
    public static void main(String[] args){
	LinkedListStack<Integer> pilha = new LinkedListStack<Integer>();
	Scanner in= new Scanner(System.in);
	int N =in.nextInt();
	boolean tamal;
	in.nextLine();
	for (int i=0;i<N;i++){
	    String expressao= in.nextLine();
	    Scanner in2 = new Scanner(expressao);
	    tamal=false;
	    while(in2.hasNext()){
	        String ch=in2.next();
		char pa=' ';
		for(int j=0;j<ch.length();j++)
		    pa+= ch.charAt(j);
		System.out.println(pa);
		if (Character.isDigit(pa))
		    pilha.push(Character.getNumericValue(pa));
		
		else {
		    if (pilha.size()<2){
			tamal=true;
			break;
		    }
		    if(pa=='+'){
			int resultado=pilha.pop()+pilha.pop();
			pilha.push(resultado);
		    }
		    if(pa=='-'){
			int resultado=pilha.pop()-pilha.pop();
			pilha.push(resultado);
		    }
		    if(pa=='*'){
			int resultado=pilha.pop()*pilha.pop();
			pilha.push(resultado);
		    }
		    if(pa=='/'){
			int resultado=pilha.pop()/pilha.pop();
			pilha.push(resultado);
		    }
		}
		
	    }
	    if (tamal || pilha.size()!=1)
		System.out.println("Expressao Incorrecta");
	    else
		System.out.println(pilha.pop());
	}
    }
}
