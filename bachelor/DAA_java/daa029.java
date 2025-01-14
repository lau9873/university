import java.util.Scanner;
import java.util.*;

public class daa029 {
    static boolean[][] adj;
    static boolean[] visited;
    static Stack<Integer> ordem;

    static void dfs(int v) {
        visited[v] = true;
        for (int i = 0; i < 26; i++)
            if (adj[v][i] && !visited[i])
                dfs(i);
        ordem.push(v);
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        adj = new boolean[26][26];
        visited = new boolean[26];
        ordem = new Stack<Integer>();
        String a = in.next();
        String h = a;
        for(int o=0;o<26;o++)
            visited[o]=true;
        for (int i = 0; i < N - 1; i++) {
            String b = in.next();
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == b.charAt(j))
                    continue;
                else {
                    adj[a.charAt(j) - 'A'][b.charAt(j) - 'A'] = true;
                    visited[a.charAt(j) - 'A']=false;
                    visited[b.charAt(j) - 'A']=false;
                    break;
                }
            }
            a = b;
        }
        //dfs(h.charAt(0) - 'A');
        for (int k=0;k<26;k++)
            if(!visited[k])
                dfs(k);

        int l = 0;
        while (!ordem.isEmpty()) {
            l = ordem.pop();
            System.out.print((char) (l + 'A'));
        }
        System.out.println();
    }
}
