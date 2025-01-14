import java.util.*;

public class daa021 {
    public static void main(String args[]) {
        TreeMap<Integer,Integer> set = new TreeMap<>();
        FastScanner in = new FastScanner(System.in);
        int A = in.nextInt();
        int R = in.nextInt();

        for (int i = 0; i < A + R; i++) {
            String S = in.next();
            if (S.equals("BAK")) {
                int E = in.nextInt();
                if (!set.containsKey(E))
                    set.put(E,1);
                else
                    set.replace(E, set.get(E)+1);
            }
            if (S.equals("MIN")) {
                int m = set.firstKey();
                if(set.get(m)==1)
                    set.remove(m);
                else
                    set.replace(m,set.get(m)-1);
                System.out.println(m);
            }
            if (S.equals("MAX")) {
                int m = set.lastKey();
                if(set.get(m)==1)
                    set.remove(m);
                else
                    set.replace(m,set.get(m)-1);
                System.out.println(m);
            }

        }

    }
}

