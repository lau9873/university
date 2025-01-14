import java.util.Scanner;
public class ED243 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	int contagem=0;
	int[] hate = new int[N];
	for (int i=0; i<N;i++)
	    hate[i]=in.nextInt();
	in.nextLine();
	int P = in.nextInt();
	in.nextLine();
	boolean naoda= false;
	for (int i=0;i<P;i++){
	    int K=in.nextInt();
	    for(int j =0;j<K;j++){
		int b=in.nextInt();
		for (int h=0;h<N;h++){
		    if (hate[h]==b){
		        naoda=true;
		    }
		}
	    }
	    if(naoda){
		naoda=false;
		contagem++;
	    }   
	}
	System.out.println(P-contagem);
    }
}
	
