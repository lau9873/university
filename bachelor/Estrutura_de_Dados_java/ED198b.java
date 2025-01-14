import java.util.Scanner;
    public class ED198b {

     public static void main (String[] args){
       Scanner stdin = new Scanner(System.in);
       int[] v = new int[100];
       int n = stdin.nextInt();
       int maxSoFar = v[0];
       int sum = 0;
       for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
          v[i] = stdin.nextInt();


       for (int i=0; i<n; i++) {// Todas as posicoes iniciais possiveis
          sum = 0;
          for (int j=i; j<n; j++) { // Todas as posicoes finais possiveis
             sum+= v[j];
             //for (int k=i; k<=j; k++) // Calcular soma entre posicoes i e j
                //sum += v[k];

             System.out.println("Soma entre " + i + " e " + j + " = " + sum);
             if (sum > maxSoFar) maxSoFar = sum;
          }
      }
       //programa da maria ana leite
     }
  }
