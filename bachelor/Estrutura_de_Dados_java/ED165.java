import java.util.Scanner;
public class ED165{
    public static void main(String[] args){
	Scanner in= new Scanner(System.in);
	int N=in.nextInt();
	BSTree<Integer> tree =new BSTree<>();
	int[] lista= new int[N];
	for(int i=0;i<N;i++)
	    lista[i]=in.nextInt();
	for(int k=0;k<N;k++)
	    for(int l=0;l<N;l++)
		tree.insert(lista[k]+lista[l]);
	int P= in.nextInt();
	for (int j=0;j<P;j++){
	    int x=in.nextInt();
	    System.out.print(x);
	    if(tree.contains(x))
		System.out.println(": sim");
	    else
		System.out.println(": nao");	    
	}
    }
}
