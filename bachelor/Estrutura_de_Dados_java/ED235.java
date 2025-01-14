import java.util.Scanner;
public class ED235{
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	char lin;
	for(int i=0;i<N;i++){
	    int t = in.nextInt();
	    for (int j=t;j>0;j--){
		for (int k=0;k<j;k++)
		    System.out.print('#');
		for(int y=0;y<t-j;y++)
		    System.out.print('.');
		System.out.println();
	    }
	}
    }
}
	    
