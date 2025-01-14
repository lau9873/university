public class decomposicao {
    // Verifica se o número n é primo (apenas divisível por 1 e por si próprio)
    // [função ainda por completar]
    static boolean isPrime(int n) {
	for (int i=2; i*i<=n; i++)
	    if (n%i==0)
		return false;
	return true;
    }
    static void decompor(int n){
	if (isPrime(n))
	    System.out.print(n+" é primo!");
	else{
	    System.out.print(n +" = ");
	    for (int j=2; j<=n; j++)
		if(n%j==0)
		    {if (isPrime(j))
			for (int g=j;n%g==0;g=g+g)
			    System.out.print(j+"*");}
		    	    
	    //??esta a dar mais multiplos do que devia....e n devia ter o ultimo 
	   
         }
	System.out.println();
				    
    }
	
    public static void main(String[] args) {
	decompor(20);
	decompor(70);
	decompor(7);
	
    }
}
