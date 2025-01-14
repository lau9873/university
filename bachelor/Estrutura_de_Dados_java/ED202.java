import java.util.Scanner;
public class ED202{
    static int N;
    static float minSoFar=1000000;
    static float count;
    static float permutations(float[][] dista, int n) {
	boolean used[] = new boolean[n];
	int perm[] = new int[n];        
	return goPerm(0, dista, used, perm, n);
    }
    
    static float goPerm(int cur, float[][] dista, boolean used[], int perm[],int n ) {
	if (cur == n) {
	    count=dista[perm[0]][perm[n-1]];
	    
	    for (int i=0; i<n-1; i++) {
		count+=dista[perm[i+1]][perm[i]];
	    }
	    if (count<minSoFar)
		minSoFar=count;
	}
	else {
	    for (int i=0; i<n; i++) 
		if (!used[i]) { 
		    used[i] = true;
		    perm[cur] = i;
		    goPerm(cur+1, dista, used, perm,n);
		    used[i] = false;
		}
	}
	return minSoFar;
    }

	
    public static void main(String[] args){
	Scanner in= new Scanner(System.in);
	N=in.nextInt();
	String nada=in.nextLine();
	in.nextLine();
	float dist[][] = new float[N][N];
	for(int i=0;i<N;i++)
	    for(int j=0;j<N;j++)
		dist[i][j]=in.nextFloat();
	System.out.printf("%.2f%n",permutations(dist,N));
    }
}
