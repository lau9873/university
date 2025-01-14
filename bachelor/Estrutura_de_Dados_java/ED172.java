import java.util.Scanner;
import java.util.LinkedList;
public class ED172{
    public static void main(String[] args){
	Scanner in= new Scanner(System.in);
	BSTMap<String,Integer> dici= new BSTMap<>();
	while (in.hasNextLine()){
	    String line=in.nextLine();
	    Scanner in2= new Scanner(line);
	    while(in2.hasNext()){
		String word=in2.next();
		if (dici.get(word)==null)
		    dici.put(word,1);
		else
		    dici.put(word,dici.get(word)+1);
	    }
	}
	LinkedList<String> lista=dici.keys();
	for (String key : lista){
	    System.out.printf("%s: %d%n",key,dici.get(key));	    
	}
    }
}
