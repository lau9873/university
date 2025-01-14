import java.util.ArrayList;
import java.util.Comparator;

public class DecisionTreeAlgorithm {
    static Atribute Decision;
    static String[] head;

    public static DT start (ArrayList<String[]> data, ArrayList<Atribute> atrs, Atribute decision) {
        Decision = decision;
        head = data.get(0);
        int j = maxEntropy(atrs, data);
        Atribute a = atrs.get(j);
        DT root = new DT(a);
        for (int i=0; i<a.values.length; i++){
            ArrayList<String[]> exs = a.regists.get(i);
            atrs.remove(a);
            DT t = decisionTreeLearning(exs,atrs,data);
            //aresta(a,t,v) - acrescenta aresta a arvore
            root.add(t);
        }
        return root;
    }
    public static DT decisionTreeLearning(ArrayList<String[]> exs,ArrayList<Atribute> atr,ArrayList<String[]> parentExs){
        if (exs.size() == 0){
            String value = mostCommun(atr,parentExs);
            DT leaf = new DT(value,0);
            return leaf;
        }
        else{
            if (sameValue(exs)){
                String value = exs.get(0)[exs.get(0).length-1];
                DT leaf = new DT(value,count(exs, value));
                return leaf;
            }
            else{
                if (atr.size() == 0) {
                    String value = mostCommun(atr,exs);
                    DT leaf = new DT(value, count(exs, value));
                    return leaf;
                }
            }
        }

        Atribute A = atr.get(maxEntropy(atr,exs));
        DT root = new DT(A);
        for (int i=0; i<A.values.length; i++) {
            ArrayList<String[]> exs1 = IA03.withValue(exs,A,A.values[i]);
            atr.remove(A);
            DT subtree = decisionTreeLearning(exs1,atr,exs);
            root.add(subtree);
            //aresta(A,subtree,v_i)
        }
            return root;
    }

    public static int maxEntropy(ArrayList<Atribute> atrs, ArrayList<String[]> exs){
        int out = 0;
        Atribute best = atrs.get(0);
        double max = Decision.values.length;
        for (int i=0; i<atrs.size(); i++){
            refreshRegists(atrs.get(i),exs);
            int[][] E = new int[atrs.get(i).values.length][Decision.values.length];
            for (int j=0; j<E.length; j++)
                for (int k=0; k<Decision.values.length; k++)
                    if (atrs.get(i).regists.get(j).size() > 0) E[j][k] = count(atrs.get(i).regists.get(j), Decision.values[k]);
            //calcular o num de exemplos em exs que têm aquele valor
            //a entropia vai ser diferente em cada subarvore (mm que tenha os mm atributos)
            double e = entropy(E);
            if (e < max){
                max = e;
                out = i;
                best = atrs.get(i);
            }
            else{
                if (e == max){
                    if (best.values.length > atrs.get(i).values.length){
                        out = i;
                        best = atrs.get(i);
                    }
                }
            }
        }
        return out;
    }

    public static void refreshRegists(Atribute a, ArrayList<String[]> exs){
        int at = 0;
        for (int i=0; i<head.length; i++){
            if (head[i].equals(a.name)){
                at = i;
                break;
            }
        }
        a.register(at,exs);
    }

    //conta quantos exemplos têm o valor especificado
    public static int count(ArrayList<String[]> exs, String value){
        int c = 0, k = exs.get(0).length-1;
        for (int i=0; i<exs.size(); i++){
            if (exs.get(i)[k].equals(value)) c++;
        }
        return c;
    }

    public static double entropy(int[][] exs1){
        int[] total = new int[exs1.length];
        int T = 0;
        for (int i=0; i<exs1.length; i++){
            int t = 0;
            for (int j=0; j<exs1[i].length; j++)
                t += exs1[i][j];
            T += t;
            total[i] = t;
        }

        double ent = 0, out = 0;
        for (int i=0; i< exs1.length; i++){
            ent = 0;
            double e = 0;
            for (int j=0; j<exs1[0].length && total[i] != 0; j++) {
                if (exs1[i][j] == 0) continue;
                e = (double) exs1[i][j] / total[i];
                ent -= e * Math.log(e) / Math.log(2);
            }
            out += ent*total[i]/T;
        }
        return out;
    }

    public static boolean sameValue(ArrayList<String[]> exs){
        //ordenar exs pela decisao
        int j = exs.get(0).length-1;
        exs.sort(new Comparator<String[]>() {
            //@Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals("ID")) return -1;
                if (o2[0].equals("ID")) return 1;
                return o1[j].compareTo(o2[j]);
            }
        });


        int k = exs.get(0).length, count = 0;
        for (int i=1; i<exs.size(); i++){
            if (!exs.get(i)[k-1].equals(exs.get(i-1)[k-1])){
                return false;
            }
        }
        return true;
    }

    public static String mostCommun(ArrayList<Atribute> atrs, ArrayList<String[]> exs){
        if (sameValue(exs)) return exs.get(0)[exs.get(0).length-1];
        //ordenar exs pela decisao

        int l = exs.get(0).length-1;
        exs.sort(new Comparator<String[]>() {
            //@Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals("ID")) return -1;
                if (o2[0].equals("ID")) return 1;
                return o1[l].compareTo(o2[l]);
            }
        });

        int k=0; //num de classes diferentes
        ArrayList<String> dif_values = new ArrayList<>();
        dif_values.add(exs.get(0)[l]);
        for (int i=1; i<exs.size(); i++){
            if (!exs.get(i)[l].equals(exs.get(i-1)[l])){
                k++;
                dif_values.add(exs.get(i)[l]);
            }
        }

        int max = 0;
        String winner = "";
        for (int i=0; i<k; i++){
            int c = 0;
            String value = dif_values.get(i);
            for (int j=0; j<exs.size(); j++){
                if (exs.get(j)[l].equals(value)) c++;
                if (max < c){
                    max = c;
                    winner = value;
                }
            }
        }
        return winner;
    }
}
