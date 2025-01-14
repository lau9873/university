import java.util.Scanner;
public class ED201{
    static int duracao;
    static int N;
    static int[] list;
    static int playlist;
    static int maxSoFar;
    static int sets(int v[]) {
	boolean used[] = new boolean[v.length];
	return goSets(0, v, used); 
    }
    static int goSets(int cur, int v[], boolean used[]) {
	if (cur == v.length) {
	    playlist=0;
	    for (int i=0; i<v.length; i++) 
		if (used[i]) {
		    playlist+=v[i];
		}
	    if (maxSoFar<playlist && playlist<=duracao)
		maxSoFar=playlist;	    
	} else {          
	    used[cur] = true;
	    goSets(cur+1, v, used);
	    used[cur] = false;     
	    goSets(cur+1, v, used);
	}
	return maxSoFar;
    }	
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	duracao=in.nextInt();
	N=in.nextInt();
	list = new int[N];
	int count=0;
	maxSoFar=0;
	for(int i=0;i<N;i++){
	    list[i]=in.nextInt();
	    count+=list[i];
	}
	if (count<=duracao)
	    System.out.println(count);	   
       	else{
	    System.out.println(sets(list));
	}	    
    }
}
