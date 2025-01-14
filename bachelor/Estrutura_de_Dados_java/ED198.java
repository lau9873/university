import java.util.Scanner;
public class ED198{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int N=in.nextInt();
	int[] v=new int[N];
	in.nextLine();
	for (int i=0;i<N;i++){
	    v[i]=in.nextInt();
	}
	/* O(n³)
	  int maxSoFar = v[0]; 
	  for (int i=0; i<N; i++) 
	  for (int j=i; j<N; j++) {
	  int sum = 0;
	  for (int k=i; k<=j; k++) 
	  sum += v[k];
	  System.out.println("Soma entre " + i + " e " + j + " = " + sum);
	  if (sum > maxSoFar) maxSoFar = sum;
	  }
	  System.out.println(maxSoFar);
	*/
	
	/* O(n²)
	int maxSoFar = v[0]; 
	for (int i=0; i<N; i++){
	    int sum=0;
	    for (int j=i; j<N; j++) {
		sum+=v[j];
		System.out.println("Soma entre " + i + " e " + j + " = " + sum);
		if (sum > maxSoFar) maxSoFar = sum;
	    }
	}
	System.out.println(maxSoFar);
	*/
	
	/* O(n) */
       	int[] best =new int[N];
	int maxSoFar=v[0];
        best[0]=v[0];
	for (int i=1; i<N; i++) {
	    if (best[i-1]>0)
		best[i]=best[i-1]+v[i];
	    if (best[i-1]<=0)
   		best[i]=v[i];
	    if (best[i]>maxSoFar) maxSoFar=best[i];
		    
	}		
	System.out.println(maxSoFar);
    }
}
