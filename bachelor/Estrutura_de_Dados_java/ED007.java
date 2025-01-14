import java.util.Scanner;
public class ED007{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	int posicao=0;
	in.nextLine();
	for(int i=0;i<N;i++){
	    posicao=0;
	    MyStack<String> pilha = new LinkedListStack<String>();
	    String pare=in.nextLine();
	    Scanner in2 =new Scanner(pare);
	    boolean erro= false;
	    while(in2.hasNext()){
		posicao+=2;
		String pa=in2.next();
		if (pa.equals("(") || pa.equals("["))
		    pilha.push(pa);
		if (pa.equals(")")){
		    if(pilha.isEmpty()){
			posicao-=2;
			System.out.println("Erro na posicao "+posicao);
			erro=true;
			break;	
		    }
		    else{
			String ultima=pilha.pop();
			if ((ultima.equals("("))){
			    continue;
			}
			if (!(ultima.equals("("))){
			    posicao-=2;
			    System.out.println("Erro na posicao "+posicao);
			    erro=true;
			    break; 
			}
		    }
		}
		if (pa.equals("]")){
		    if(pilha.isEmpty()){
			posicao-=2;
			System.out.println("Erro na posicao "+posicao);
			erro=true;
			break;	
		    }
		    else{
			String ultima=pilha.pop();
		
			if ((ultima.equals("["))){
			   
			    continue;
			} 
			if (!(ultima.equals("["))){
			    posicao-=2;
			    System.out.println("Erro na posicao "+posicao);
			    erro=true;
			    break;
			}
		    }
		}	
	    }   
	    if(!(pilha.isEmpty()) && !(erro))
		System.out.println("Ficam parenteses por fechar");
	    if( pilha.isEmpty() && !(erro))
		System.out.println("Expressao bem formada");    
	}
    }
}
