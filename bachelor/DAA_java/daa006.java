import java.util.Scanner;
import java.lang.Math;

//area de intersecao de um circulo com um quadrado por metodos numericos e nao algebricos.
public class daa006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int qx, qy, ql, cx, cy, cr;
        for (int i = 0; i < N; i++) {
            qx = in.nextInt();
            qy = in.nextInt();
            ql = in.nextInt();
            cx = in.nextInt();
            cy = in.nextInt();
            cr = in.nextInt();
            System.out.println(solve(qx, qy, ql, cx, cy, cr));
        }
    }

    public static double distancia(double x1, double y1, double x2, double y2) {
        return (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public static double solve(double qx, double qy, double ql, double cx, double cy, double cr) {
        if (qx < cx - cr && qy < cy - cr && qx + ql > cx + cr && qy + ql > cy + cr) {
            return cr * cr * Math.PI;
        } else if (distancia(cx, cy, qx, qy) < cr && distancia(cx, cy, qx, qy + ql) < cr && distancia(cx, cy, qx + ql, qy) < cr && distancia(cx, cy, qx + ql, qy + ql) < cr) {
            return ql * ql;
        } else if (qx + ql < cx - cr || qy + ql < cy - cr || qx > cx + cr || qy > cy + cr) {
            return 0;
        } else if (ql > 0.001) {
            return solve(qx, qy, ql / 2, cx, cy, cr) + solve(qx + ql / 2, qy, ql / 2, cx, cy, cr) + solve(qx, qy + ql / 2, ql / 2, cx, cy, cr) + solve(qx + ql / 2, qy + ql / 2, ql / 2, cx, cy, cr);
        } else
            return 0;
    }
}
