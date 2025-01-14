// Uma classe muito simples que usa um ciclo para imprimir numeros entre 1 e n

// O ficheiro tem de ter o mesmo nome da classe + a extensão '.java'
public class Numbers {
    public static void main(String[] args) {
	int n = 500; // limite dos numeros
	
	System.out.print("Numeros de 1 a " + n + ": "); // + é o operador de concatenação de strings
	for (int i=1; i<=n-1; i++)
	    System.out.print(i+",");
	System.out.println(n);
	int j=0;
      	for (int i=1; i<=n; i++)
	    j=j+i;
	System.out.println("Soma = "+ j);
	    

	
    }
}
