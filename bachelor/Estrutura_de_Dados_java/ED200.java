import java.util.Scanner;
public class ED200{
    static int L;
    static int C;
    static char placa[][];
    static boolean visited[][];
    static int t(int y, int x){
	if (y<0 || y>=L || x<0 || x>=C) return 0;	
	if (visited[y][x]) return 0;
	if (placa[y][x]=='.') return 0;
	int count = 1;
	visited[y][x]=true;
	count+=t(y-1,x+1);
	count+=t(y-1,x);
	count+=t(y-1,x-1);
	count+=t(y,x+1);
	count+=t(y,x-1);
	count+=t(y+1,x);
	count+=t(y+1,x+1);
	count+=t(y+1,x-1);
	return count;
    }
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int N=in.nextInt();
	for (int i=0;i<N;i++){
	    L=in.nextInt();
	    C=in.nextInt();
	    in.nextLine();
	    placa=new char[L][C];
	    visited= new boolean[L][C];
	    for(int l=0;l<L;l++){
		placa[l]=in.nextLine().toCharArray();	
	    }
	    int max=0;
	    int k=0;
	    for (int r=0;r<L;r++)
		for (int o=0;o<C;o++){
		    k=t(r,o);
		    
		    if (max<k) max=k;
		}
	    System.out.println(max);
	}
    }
}
