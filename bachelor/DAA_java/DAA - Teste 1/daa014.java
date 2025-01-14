import java.util.*;
//objetivo: saber qual sapato tratar primeiro de modo a dar menos despesa mas a ser mais rapido
//primeiro os mais longos com menos multa depois pela ordem de chegada
class Sapato implements Comparable<Sapato> {
    public double duracao;
    public double multa;
    public int pos;

    Sapato(double d, double m, int p) {
        duracao = d;
        multa = m;
        pos = p;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public int compareTo(Sapato l) {
        if (duracao / multa < l.duracao / l.multa) return -1;
        if (duracao / multa > l.duracao / l.multa) return +1;
        else if (pos < l.pos)
            return -1;
        return +1;
    }
}
public class daa014 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Sapato[] sap = new Sapato[N];
        for (int i = 0; i < N; i++) {
            double d = in.nextInt();
            double m = in.nextInt();
            sap[i] = new Sapato(d, m, i + 1);
        }
        Arrays.sort(sap);
        for (int i = 0; i < N-1; i++)
            System.out.print(sap[i].getPos()+" ");
        System.out.print(sap[N-1].getPos());
        System.out.println();

    }
}
