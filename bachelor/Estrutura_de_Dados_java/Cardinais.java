import java.util.*;

public class Cardinais{
    public static void main(String[] args) {
	Scanner stdin = new Scanner(System.in);
	int L = stdin.nextInt();
	int C = stdin.nextInt();
	stdin.nextLine();
	String[] aux=new String[L];
	char[][] v = new char[L][C];
	int[] repeticoes= new int[C*4*L];
	int j=0;
	for (int i =0; i<L; i++){
		aux[i]=stdin.nextLine();
	}
	for (int e =0;e<L;e++){
	    for(int o=0;o<C;o++)
		v[e][o]=aux[e].charAt(o);
	}
	for (int l =0;l<L;l++){
	   for(int h=0;h<C;h++){
		if (v[l][h]=='.')
		    j+=1;
		if (v[l][h]=='#')
		    repeticoes[j]+=1;
	        
	    }
	   j+=1;
	}
	for (int c =0;c<C;c++){
	   for(int g=0;g<L;g++){
		if (v[g][c]=='.')
		    j+=1;
		if (v[g][c]=='#')
		    repeticoes[j]+=1;    
	   }
	   j+=1;
	}
	Arrays.sort(repeticoes);
	int maximo=repeticoes[C*L*4-1];
	int primeiro=0;
	for (int u =0;u<C*L*4;u++)
	    if (repeticoes[u]==maximo){
	       	primeiro=u;
		break;}
	int quantidade = C*L*4-primeiro;
	System.out.print(maximo+" "+quantidade);
	System.out.println();
        	
    }
    
    
}
