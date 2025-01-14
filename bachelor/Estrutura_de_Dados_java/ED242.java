import java.util.Scanner;
public class ED242{
    static int rows;
    static int cols;           
    static char m[][];         
    static boolean visited[][]; 
    static int t(int y, int x) {
	if (y<0 || y>=rows || x<0 || x>=cols) return 0; 
	if (visited[y][x]) return 0;  
	if (m[y][x] == '#') return 0;
	if (
	int count = 1;        
	visited[y][x] = true;
	count += t(y-1, x);   
	count += t(y+1, x);
	count += t(y, x+1);
	count += t(y, x-1);
	return count;
    }

    public static void main(String[] args){
	Scanner in=new Scanner(System.in);
	int K=in.nextInt();
	in.nextLine();
	LinkedList<String[]> linhas=new LinkedList<>();
	while (in.hasNextLine()){
	    String[] linha=in.next().toCharArray();
	    linhas.add(linha);
	}
	m=linhas.toArray();
	rows=m.lenght;
	cols=m[0].lenght;
	BSMap<Integer,Integer> lagos= new 
	for (int r=0;r<rows;r++)
	    for (int c=0;c<cols;c++)
		if(t(r,c)!=0)
		    lagos.add(t(r,c));
    }
}
