import java.util.Random;
import java.util.LinkedList;
import java.util.Arrays;
public class novo{
    public static void main(String[] args){
	int t=0;
	double a;
	int b;
	Random r= new Random();
	int maxSoFar=0;
	LinkedList<Integer> lista;
	LinkedList<Integer> resp= new LinkedList<>();
	for(int i=2; i<5000;i++){
	    lista= new LinkedList<>();
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(1);
	    t=t+b*243;
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(2);
	    t=t+b*202;
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(3);
	    t=t+b*254;
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(4);
	    t=t+b*502;
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(5);
	    t=t+b*385;
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(6);
	    t=t+b*942;
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(7);
	    t=t+b*237;
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(8);
	    t=t+b*721;
	    a=r.nextDouble();	    	    
	    b=(int)(a+0.5);
	    if(b==1)
		lista.add(9);
	    t=t+b*192;
	    if(t<1300 && t>maxSoFar){
		maxSoFar=t;
		resp=lista;
		
	    }

	    
	    System.out.println(Arrays.toString(resp.toArray())+" "+maxSoFar);
	    t=0;
	    
	}
	
    }
}
