import java.util.*;

public class daa035 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                dist[i][j] = Integer.MAX_VALUE / 2;
        }
        for (int i = 0; i < N; i++)
            dist[i][i] = 0;
        for (int i = 0; i < N; i++) {
            String a = in.next();
            int n = in.nextInt();
            for (int j = 0; j < n; j++)
                dist[a.charAt(0) - 'A'][in.next().charAt(0) - 'A'] = 1;
        }
        for (int k = 0; k < N; k++)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if ((dist[i][k] + dist[k][j]) < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
        System.out.print("  A");
        for (int i = 1; i < N; i++) {
            System.out.print(" " + (char) ('A' + i));
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print((char) ('A' + i));
            for (int j = 0; j < N; j++) {
                if (dist[i][j] < 100)
                    System.out.print(" " + 1);
                else
                    System.out.print(" " + 0);
            }
            System.out.println();
        }

    }
}