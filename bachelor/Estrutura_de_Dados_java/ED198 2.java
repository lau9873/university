import java.util.Scanner;
    public class ED198{

     public static void main (String[] args){

      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] v = new int[n];

      for (int i = 0; i < v.length ; i++)
     {
        v[i] = in.nextInt();
     }

          int[] best = new int[n];
            best[0] = v[0];
            int i;
            int max = v[0];
            for (i=0; i<n-1; i++) // Todas as posicoes iniciais possiveis
            {
               if(best[i] >= 0) best[i+1] = best[i] + v[i+1];
               else best[i+1] = v[i+1];
               if(max < best[i]) max = best[i];
            }
            System.out.println(max);
          }

	//programa da maria ana leite
  }
