import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
// ordena as letras pelo numero de vezes que aparece na sequencia
// usa Arrays.sort();

// Classe para guardar um nome/letra com comparador
class Letra implements Comparable<Letra> {
    public int freq;
    public int pos;
    public char letra;

    Letra(char l,int f, int p) {
        freq = f;
        pos = p;
        letra = l;
    }
    Letra(char l) {
        freq = 0;
        pos = 0;
        letra = l;
    }


    // Definir como comparar dois elementos da classe Person
    // compareTo e uma funcao que compara objecto com outro objecto "p"
    // Esta funcao deve devolver:
    //  - numero < 0 se objecto for menor que objecto "p"
    //  - numero > 0 se objecto for maior que objecto "p"
    //  - zero, se objecto for igual ao objecto "p"
    @Override
    public int compareTo(Letra l) {
        if (freq < l.freq) return + 1;
        if (freq > l.freq) return -1;
        else if (pos<l.pos)
            return -1;
        return +1;
    }
}

public class daa009 {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);

        Letra[] a = new Letra[27];
        for (int i = 0; i < 27; i++) {
            char h = ((char) (i + 'A'));
            a[i] = new Letra(h);
        }
        String n = stdin.next();

        for (int j = 0; j < n.length(); j++) {
            char l = n.charAt(j);
            if (a[l - 'A'].freq == 0)
                a[l - 'A'] = new Letra(l, a[l - 'A'].freq + 1, j);
            else
                a[l - 'A'] = new Letra(l, a[l - 'A'].freq + 1, a[l - 'A'].pos);
        }

        Arrays.sort(a);
        int k = 0;
        while (a[k].freq != 0) {
            System.out.println(a[k].letra + " " + a[k].freq);
            k++;
        }

    }


}



