import java.util.*;
import java.io.*;

public class daa027 {
    static int nos;
    static boolean adj[][];
    static int visited[];
    static boolean dfs(int v,int k){
        visited[v] = k;
        for (int i = 0; i < nos; i++) {
            if (adj[v][i] && visited[i] == 0) {
                if (k == 1)
                    return dfs(i, 2);
                if (k == 2)
                    return dfs(i, 1);
            }
            if (adj[v][i] && visited[i] != 0){
                if (k == visited[i])
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        for (int c=0;c<casos;c++) {
            nos = in.nextInt();
            adj= new boolean[nos][nos];
            visited = new int[nos];
            int edges = in.nextInt();
            for (int i = 0; i < edges; i++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                visited[a] = 0;
                adj[a][b] = adj[b][a] = true;
            }
            /*boolean count = true;
            for (int i = 0; i < nos; i++)
                if (visited[i] == 0) {
                    count = dfs(i, 1) && count;
                }

             */
            boolean count = dfs(0,1);
            if (count)
                System.out.println("sim");
            else
                System.out.println("nao");
        }
    }
}
