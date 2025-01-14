import java.util.Scanner;

public class ED231 {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int[] casos = new int[N];	
	int[] aumentos = new int[N];
	float[] percentagem = new float[N];
	int[]  diascons = new int[N];
	sc.nextLine();
	casos[0]=sc.nextInt(); 
	for (int i=1;i<N;i++){
	    casos[i]=sc.nextInt();
	    aumentos[i]=casos[i]-casos[i-1];
	    percentagem[i]=(float)aumentos[i]/casos[i-1]*100;	
	   
	}
	int max =aumentos[1];
	int min=max;
	int dias=0;
	int diascomp=0;
	for (int j=1; j<N;j++){
	    if (max<aumentos[j])
		max=aumentos[j];
	    if(aumentos[j]<min)
		min=aumentos[j];
	    if (percentagem[j]<=5)
		dias++;
	    if (percentagem[j]>5 && dias!=0){
		diascons[j]=dias;
		dias=0;
		diascomp++;
	    }
	}
	if (dias!=0)
	    diascomp++;
	diascons[N-1]=dias;
	int diasmax =0;
	
	for (int h=0; h<N;h++){
	    if (diascons[h]>diasmax)
		diasmax=diascons[h];
	}
	sc.nextLine();
	int flag = sc.nextInt();
	if (flag==1){
	    System.out.println(min+" "+max);
	    
	}
	if (flag==2){
	    System.out.println(diascomp+" "+diasmax);
	}
	if (flag==3){
	    int l=casos[N-1]/100;
	    for (int i=l; i>0;i--){
		for (int j=0;j<N;j++){
		    if (casos[j]/(i*100)!=0)
			System.out.print("#");
		    else
			System.out.print(".");
		}
		System.out.println();
	    }
	}
		       
		
	
	       
      
    }
}
	    
