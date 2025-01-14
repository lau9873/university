import java.util.Scanner;
public class ED164{
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
	BSTree<String> tree=new BSTree<>();
	int N= in.nextInt();
	in.nextLine();
	for (int i=0;i<N;i++){
	    tree.insert(in.next());
	}
	System.out.println(tree.numberNodes());
    }
}
