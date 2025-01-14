public class losango1{
    public static void main(String[] args){
	linha(3);
	linha(5);
	linha(7);
	linha(2);
	   
    }
    static void linha(int n){
	if (n%2==0)
	    System.out.println (n+"???? Isso não é ímpar.....");
	else{
	    for (int l=1;l<=(n-1)/2;l++){
	        for (int i=1;i<=(n+1)/2-l;i++)
		    System.out.print(" ");
	        for (int j=1;j<=2*l-1;j++)
		    System.out.print("*");
		for (int g=1;g<(n+1)/2-l;g++)
		    System.out.print(" ");
		System.out.println(" ");
	    }
	    for (int i=1;i<n;i++)
		System.out.print("*");
	    System.out.println("*");
	    for (int l=(n-1)/2;l>0;l--){
		for (int i=1;i<=(n+1)/2-l;i++)
		    System.out.print(" ");
	        for (int j=1;j<=2*l-1;j++)
		    System.out.print("*");
		for (int g=1;g<(n+1)/2-l;g++)
		    System.out.print(" ");
		System.out.println(" ");
	    }
	}
	
	
	    	    
    }
}
