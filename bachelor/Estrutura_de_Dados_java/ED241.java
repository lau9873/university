import java.util.Scanner;
import java.util.LinkedList;
public class ED241{
    public static void main(String[] args){
	Scanner in=new Scanner(System.in);
	int flag=in.nextInt();
	int N= in.nextInt();
	if(flag==1){
	    BSTree<String> arvore=new BSTree<>();
	    for (int i=0;i<N;i++){
		in.nextLine();
		String nome=in.next();
		arvore.insert(nome);
	    }
	    System.out.println(arvore.numberNodes());
	}
	if (flag==2){
	    BSTMap<String,Integer> mapa=new BSTMap<>();
	    for (int i=0;i<N;i++){
		in.nextLine();
		in.next();
		String problema=in.next();
		if(mapa.get(problema)!=null)
		    mapa.put(problema,mapa.get(problema)+1);
		else{
		    mapa.put(problema,1);
		}
	    }
	    String maisSub=mapa.keys().getFirst();
	    for(String problema: mapa.keys())
		if(mapa.get(problema)>mapa.get(maisSub))
		    maisSub=problema;
	    System.out.println(maisSub+" "+mapa.get(maisSub));
	}
	if(flag==3){
	    BSTMap<String,LinkedListQueue<String>> mapa=new BSTMap<>();
	    for (int i=0;i<N;i++){
		in.nextLine();
		in.next();
		String problema=in.next();
		String resultado=in.next();
		if(mapa.get(problema)!=null){
		    LinkedListQueue<String> n= mapa.get(problema);
		    n.enqueue(resultado);
		    mapa.put(problema,n);
		}
		else{
		    LinkedListQueue<String> n=new LinkedListQueue<>();
		    n.enqueue(resultado);
		    mapa.put(problema,n);
		}
	    }
	    for(String prob:mapa.keys()){
		LinkedListQueue<String> res=mapa.get(prob);
		int tam=res.size();
		float acc=0;
		for(int j=0;j<tam;j++){
		    String resp=res.dequeue();
		    if(resp.equals("Accepted"))
			acc++;
		}
		if(acc/tam>=0.5)
		    System.out.println(prob);
	    }
	}
	if(flag==4){
	    BSTMap<String,LinkedList<String>> mapa=new BSTMap<>();
	    for (int i=0;i<N;i++){
		in.nextLine();
		String nome=in.next();
		String problema=in.next();
		String resultado=in.next();
		if(resultado.equals("Accepted")){
		    if(mapa.get(nome)!=null){
			LinkedList<String> n=mapa.get(nome);
			if(!n.contains(problema)){
			    n.add(problema);
			    mapa.put(nome,n);
			}
		    }
		    else{
			LinkedList<String> n= new LinkedList<>();
			n.add(problema);
			mapa.put(nome,n);
		    }		    
		}
	    }
	    int max=0;
	    for(String nome:mapa.keys()){
		max=Math.max(max,mapa.get(nome).size());		
	    }
	    for(String nome:mapa.keys())
		if(mapa.get(nome).size()==max)
		    System.out.println(nome);
	}
    }
}

