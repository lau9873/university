import java.util.Scanner;

class Process{
    private String name;
    private int time;

    Process(String N, int T){
	name = N;
	time = T;
	    }
    public int getTime(){
	return time;
    }
    public String getName(){
	return name;
    }
    public void time(int t){
	time=t;
    }
    public void name(String t){
	name=t;
    }
    
}
public class ED237{
    public static void main(String[] args){
	Scanner in= new Scanner(System.in);
	MyQueue<Process> fila = new LinkedListQueue<>();
	int T = in.nextInt();
	int tempoTerminacao=0;
	int numIteracoes=0;
	int N = in.nextInt();
	for (int i = 0; i<N; i++){
	    String nomeProcesso=in.next();
	    int tempoNecessario=in.nextInt();
	    Process pp=new Process(nomeProcesso,tempoNecessario);
	    fila.enqueue(pp);
	}
	while (!(fila.isEmpty())){
	    Process processo=fila.dequeue();
	    int tempo =processo.getTime();
	    if (T<tempo){
		processo.time(tempo-T);
		tempoTerminacao+=T;
		fila.enqueue(processo);
		numIteracoes++;
	    }
	    if (T==tempo){
		tempoTerminacao+=T;
		numIteracoes++;
		System.out.println(processo.getName()+" "+tempoTerminacao+" "+numIteracoes);
	    }
	    if(T>tempo){
		tempoTerminacao+=tempo;
		numIteracoes++;
		System.out.println(processo.getName()+" "+tempoTerminacao+" "+numIteracoes);
	    }
	}
    }
}
	
    
