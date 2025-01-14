import java.util.*;
import java.io.*;

public class daa026 {
    static int L,C;
    static char matrix[][];
    static boolean visited[][];
    static int floodfill(int x,int y) {
        if(x<0 || y <0 || x>=L || y>=C)
            return 0;

        if(!visited[x][y] && matrix[x][y]=='#') {
            visited[x][y]=true;
            int diagonais=floodfill(x-1,y-1) + floodfill(x+1,y+1)+floodfill(x-1,y+1)+floodfill(x+1,y-1);
            int diretos=floodfill(x + 1, y) + floodfill(x, y + 1) + floodfill(x - 1, y) + floodfill(x, y - 1);
            return (1 + diagonais + diretos);
        }

        return 0;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            L = in.nextInt();
            C = in.nextInt();
            matrix = new char[L][C];
            visited = new boolean[L][C];
            for (int j = 0; j < L; j++) {
                String g = in.next();
                for (int k = 0; k < C; k++)
                    matrix[j][k]=g.charAt(k);
            }
            int max = 0;
            for (int l = 0; l < L; l++)
                for (int c=0;c<C;c++)
                if (!visited[l][c] && matrix[l][c]=='#') {
                    int count = floodfill(l,c);
                    if (count > max)
                        max = count;
                }

            System.out.println(max);


        }

    }
}
