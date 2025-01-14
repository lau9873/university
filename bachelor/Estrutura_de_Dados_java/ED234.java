import java.util.Scanner;
/*class avaliacao implements Comparable<avaliacao>{
    static String filme;
    static int nota;
    avaliacao(String f,int n){
	filme=f;
	nota=n;
    }
    public int compareTo(avaliacao nova){
	return filme.compareTo(nova.filme);
    }
    }*/
/*class notaEValor{
    static int nota;
    static int valor;
    notaEValor(int n,int v){
	nota=n;
	valor=v;
    }
    int getNota(){
	return nota;
    }
}*/

public class ED234{
    public static void main(String[] args){
	Scanner in=new Scanner(System.in);
	int F=in.nextInt();
	int N=in.nextInt();
	if (F==1){
	    BSTree<String> arvore = new BSTree<>();
	    for(int i=0;i<N;i++){
		in.nextLine();
		String filme=in.next();
		arvore.insert(filme);
	    }
	    System.out.println(arvore.numberNodes());
	}
	if (F==2){
	    BSTMap<String,Integer> mapa = new BSTMap<>();
	    int maxSoFar=0;
	    String maxFilme="";
	    for(int i=0;i<N;i++){
		in.nextLine();
		String filme=in.next();
		if(mapa.get(filme)!=null)
		    mapa.put(filme,mapa.get(filme)+1);
		if(mapa.get(filme)==null)
		    mapa.put(filme,1);		
		if(mapa.get(filme)>maxSoFar){
		    maxSoFar=mapa.get(filme);
		    maxFilme=filme;
		}
	    }
	    System.out.println(maxFilme+" "+maxSoFar);
	}
	if (F==3){
	    BSTMap<String,LinkedListQueue<Integer>> mapa = new BSTMap<>(); 
	    for(int i=0;i<N;i++){
		in.nextLine();
		String filme=in.next();
		int grade=in.nextInt();		
		
		if (mapa.get(filme)!=null){
		    LinkedListQueue<Integer> n = mapa.get(filme);
		    n.enqueue(grade);
		    mapa.put(filme,n);
		}
		 
		if (mapa.get(filme)==null){
		    LinkedListQueue<Integer> n = new LinkedListQueue<>();
		    n.enqueue(grade);
		    mapa.put(filme,n);		    
		}
		
	    }
	    for(String p:mapa.keys()){
		LinkedListQueue<Integer> ava = mapa.get(p);
		double soma=0.0;
		int numero=ava.size();
		for(int j=0;j<numero;j++)
		    soma+=ava.dequeue();
		double media=soma/numero;	    
		if(media>=5)
		    System.out.println(p);
	    }

	    
	}
    }
}

