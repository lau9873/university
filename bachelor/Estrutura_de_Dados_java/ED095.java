import java.util.Scanner;
class Bombeiro{
    String nome;
    int nrEventos;
    int nrMinutos;
    
    Bombeiro(String n, int e, int m){
	 String nome=n;
	 int nrEventos=e;
	 int nrMinutos=m;
    }
}
class Evento{
    int[] listaBombeiros;
    int inicio;
    int fim;

    Evento(int[] l,int i){
	int[] listaBombeiros = int[];
	int inicio=i;
	
    }	   
}


public class ED095{
	public static void main(String[] args);{
	    Scanner in = new Scanner(System.in);
	    MyQueue<Bombeiro> filaBombeiros = new LinkedListDeque<>();
	    int nrDeEventos = 0;
	    int tempo = 0;
	    int flag = in.nextInt();
	    in.nextLine();
	    int N = in.nextInt();
	    in.nextLine();
	    for (int i=0; i<N;i++){
		String pessoa=in.next();
		Bombeiro bomb=new Bombeiro(pessoa,0,0);
		filaBombeiros.enqueue(bomb);
	    }
	    while(!(in.next()=="FIM")){
		String evento=in.nextLine();
		Scanner in2=new Scanner(event);
		String tipoDeEvento=in2.next();
		if (tipoDeEvento=="PARTIDA"){
		    nrDeEventos++;
		    int identificador=in2.next();
		
		
		}
	    
		if (tipoDeEvento=="CHEGADA"){
		
		}


	
	    }
	}
}
