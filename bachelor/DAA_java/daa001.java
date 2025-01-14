import java.util.Scanner;
public class daa001 {
    public static void main(String[] args){
	Scanner in= new Scanner(System.in);
	int N = in.nextInt();
	int total=0;
	int f=0;
	for (int i=0; i<N; i++){
	    f = in.nextInt();
	    if (f==42)
		total=total+1;
		      
	}
	System.out.println(total);	
    }
}
