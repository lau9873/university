  import java.util.Scanner;
      public class ED198 {

       public static void main (String[] args){
         Scanner stdin = new Scanner(System.in);
         int[] v = new int[100];
         int n = stdin.nextInt();
         int maxSoFar = v[0];

         for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
            v[i] = stdin.nextInt();


         for (int i=0; i<n; i++) // Todas as posicoes iniciais possiveis
            for (int j=i; j<n; j++) { // Todas as posicoes finais possiveis
               int sum = 0;
               for (int k=i; k<=j; k++) // Calcular soma entre posicoes i e j
                  sum += v[k];
               System.out.println("Soma entre " + i + " e " + j + " = " + sum);
               if (sum > maxSoFar) maxSoFar = sum;
            }
	 //programa da Maria Ana Leite
       }
    }
