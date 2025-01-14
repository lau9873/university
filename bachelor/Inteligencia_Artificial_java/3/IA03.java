import java.io.*;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;


public class IA03 {
    static ArrayList<String[]> data;
    //static ArrayList<String[]> exs;
    static ArrayList<String[]> tests;
    static ArrayList<Atribute> atrs;
    static ArrayList<Atribute> atrsTest;
    static Atribute Decision;

    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Introduza o path para o ficheiro de treino");
        String train = in.next();

        //File myObj = new File("C:\\Users\\anaca\\Downloads\\restaurant.csv");
        //File myObj = new File("C:\\Users\\anaca\\Downloads\\weather.csv");
        //File myObj = new File("C:\\Users\\anaca\\Downloads\\iris.csv");
        File myObj = new File(train);
        Scanner myReader = new Scanner(myObj);

        data = new ArrayList<>(); atrs = new ArrayList<>(); atrsTest = new ArrayList<>();
        String head = myReader.nextLine();
        String[] h = head.split(",");
        data.add(h);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] d = line.split(",");
            data.add(d);
        }
        myReader.close();

        inicializeAtrs(data.get(0));
        numerical();
        int d = data.get(0).length-1;
        data.sort(new Comparator<String[]>() {
            //@Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals("ID")) return -1;
                if (o2[0].equals("ID")) return 1;
                return o1[d].compareTo(o2[d]);
            }
        });
        /*
        Imprime valores dos atributos apos tratamento de dados
        for (int i=0; i<atrs.size(); i++) {
            System.out.println(atrs.get(i).name);
            System.out.println(Arrays.toString(atrs.get(i).values));
            System.out.println(Arrays.toString(atrs.get(i).exs));
        }
        */
        DT tree = DecisionTreeAlgorithm.start(data,atrs,Decision);
        System.out.println("------------------ Árvore de decisão ------------------");
        print("",tree);

        System.out.println();
        System.out.println("Introduza o path para o ficheiro de teste");
        String test = in.next();
        System.out.println("O ficheiro de teste é o mesmo que o de treino? (Sim = 1, Não = 0)");
        int v = in.nextInt();
        System.out.println();
        boolean value = false;
        if (v == 1) value = true;


        //File myObj1 = new File("C:\\Users\\anaca\\Downloads\\restaurantTest.csv");
        //File myObj1 = new File("C:\\Users\\anaca\\Downloads\\weatherTest.csv");
        //File myObj1 = new File("C:\\Users\\anaca\\Downloads\\irisTest.csv");
        File myObj1 = new File(test);
        Scanner myReader1 = new Scanner(myObj1);

        tests = new ArrayList<>();
        while (myReader1.hasNextLine()) {
            String line = myReader1.nextLine();
            String[] e = line.split(",");
            tests.add(e);
        }
        myReader1.close();
        testTree(tree,value);
    }

    public static void inicializeAtrs(String[] h){
        for (int i=1; i<h.length-1; i++){
            Atribute a = new Atribute(h[i]);
            atrs.add(a);
            atrsTest.add(a);
            a.values(valuesPerAtr(i));
            a.registerI(i, data);
        }
        Decision = new Atribute(h[h.length-1]);
        Decision.values(valuesPerAtr(h.length-1));
        Decision.registerI(h.length-1,data);
    }

    //Apenas descobre quais (e necessariamente quantos) valores possíveis existem para aquele atributo
    public static String[] valuesPerAtr(int k){
        String[] s = new String[data.size()-1];
        int j = 0;
        //Coloca logo as possibilidades no respetivo atributo - chama Atribute.values(v)
        for (int i=1; i< data.size(); i++) {
            if (!contains(s,data.get(i)[k])){
                s[j] = data.get(i)[k];
                j++;
            }
        }
        return Arrays.copyOfRange(s,0,j);
    }

    public static boolean contains(String[] list, String s){
        for (int i=0; i<list.length; i++){
            if (s.equals(list[i])) return true;
        }
        return false;
    }

    public static void numerical(){
        for (int i=0; i< atrs.size(); i++){
            if (atrs.get(i).values.length > 6) {
                char[] c = data.get(1)[i+1].toCharArray();
                boolean value = true;
                for (int j = 0; j < c.length; j++) {
                    if (!Character.isDigit(c[j]) && c[j] != '.') {
                        value = false;
                        break;
                    }
                }
                if (value){
                    discretizing(i);
                    atrs.get(i).discretized = true;
                }
            }
        }
    }

    public static void discretizing(int i){

        data.sort(new Comparator<String[]>() {
            //@Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals("ID")) return -1;
                if (o2[0].equals("ID")) return 1;
                return o1[i+1].compareTo(o2[i+1]);
            }
        });

        Atribute a = atrs.get(i);
        int est = Math.round((float) a.values.length/6);
        while (a.values.length > 6) {
            ArrayList<String> new_values = new ArrayList<>();
            a.regists = new ArrayList<>();
            String next = "";
            for (int j = 1; j < data.size(); j++) {
                String Class = "";
                if (next.equals("")) Class = data.get(j)[i+1];
                else Class = next;
                int count = 0;
                String value = data.get(j)[i+1];
                ArrayList<String[]> conj = new ArrayList<>();
                while (count <= est && j < data.size()) {
                    if (!data.get(j)[i+1].equals(value)) {
                        if (count == est) break;
                        count++;
                        conj.add(data.get(j));
                    } else conj.add(data.get(j));
                    j++;
                }
                j--;
                if (conj.size() > 1){
                    Class += " - " + conj.get(conj.size() - 1)[i+1];
                    //colocar conjuntos disjuntos que representamos em intervalo
                    if (contains(conj.get(conj.size() - 1)[i+1],'.')) next = conj.get(conj.size() - 1)[i+1] + "1";
                    else {
                        String s = conj.get(conj.size() - 1)[i+1];
                        int n = Character.getNumericValue(s.charAt(s.length()-1))  +1 ;
                        s = s.substring(0,s.length()-1) + n;
                        next = s;
                    }
                }
                new_values.add(Class); //atualizar o nome da classe
                //falta inicializar o regists em caso de a variavel ser numerica!
                a.regists.add(conj);
            }
            a.values = new String[new_values.size()];
            new_values.toArray(a.values);
            est++;
        }

        a.exs = new int[a.values.length];
        for (int j=0; j<a.values.length; j++){
            a.exs[j] = a.regists.get(j).size();
        }
    }

    public static boolean contains(String s, char f){
        for (int i=0; i<s.length(); i++){
            if (f == s.charAt(i)) return true;
        }
        return false;
    }

    //retorna exs com aquele valor especifico
    public static ArrayList<String[]> withValue(ArrayList<String[]> new_data, Atribute A, String value){
        ArrayList<String[]> out = new ArrayList<>();
        int at = 0;
        for (int i=1; i<data.get(0).length; i++){
            if (data.get(0)[i].equals(A.name)){
                at = i; break;
            }
        }
        if (!A.discretized) {
            for (int i = 0; i < new_data.size(); i++)
                if (new_data.get(i)[at].equals(value)) out.add(new_data.get(i));
        }
        else{
            String[] interval = value.split(" - ");
            if (!contains(interval[0],'.')) interval[0] += ".0";
            if (interval.length >1 && !contains(interval[1],'.')) interval[1] += ".0";
            for (int i = 0; i < new_data.size(); i++){
                if (!contains(new_data.get(i)[at],'.')) new_data.get(i)[at] += ".0";
                if (new_data.get(i)[at].compareTo(interval[0]) >= 0){
                    if (interval.length == 1)
                        out.add(new_data.get(i));
                    else{
                    if (new_data.get(i)[at].compareTo(interval[1]) <= 0)
                        out.add(new_data.get(i));
                    }
                }
            }
        }
        return out;
    }

    public static void print(String space, DT tree){
        DT cur = tree;
        if (cur.name != null){
            System.out.println();
            //no é um atributo
            System.out.println(space + "<" + cur.name +">");
            space += "  ";
            for (int i=0; i<cur.edges.length; i++){
                System.out.print(space + cur.edges[i] + ":");
                print(space + "  ",cur.subtrees.get(i));
            }
        }
        else{
            //no é terminal
            System.out.println(" " + cur.value + "(" + cur.counter +")");

        }
    }

    //taxa de erro é em funçao do num de exemplos que nao consegue decidir e do num de exemplos
    //cuja classificacao é diferente da registada na tabela inicial
    public static void testTree(DT tree, boolean value){
        data.sort(new Comparator<String[]>() {
            //@Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals("ID")) return -1;
                if (o2[0].equals("ID")) return 1;
                if (o1[0].length() < o2[0].length()) return -1;
                if (o1[0].length() > o2[0].length()) return 1;
                return o1[0].compareTo(o2[0]);
            }
        });

        System.out.println("------------------ Fase de testes ------------------");
        System.out.println();
        int error = 0;
        for (int i=1; i< tests.size(); i++){
            String d = decide(tests.get(i), tree);
            if (d != null){
                System.out.print("[" + i + "] Decisão: " + d);
                if (value){
                    if (d.equals(data.get(i)[data.get(0).length-1]))
                        System.out.println(" -- Decisão correta");
                    else{
                        System.out.println(" -- Decisão incorreta");
                        error++;
                    }
                }
                else System.out.println();
            }
            else{
                System.out.println("Não foi possível decidir.");
                error++;
            }
        }
        System.out.println();
        System.out.println("Taxa de erro = " + ((double) error/ (tests.size()-1)));
    }

    public static String decide(String[] s, DT tree){
        //percorrer a arvore e retornar a folha
        boolean value = true;
        while (tree.value.equals("null") && value){
            int k = 0; //indice do atributo na tabela
            for (int i=0; i< atrsTest.size(); i++){
                if (atrsTest.get(i).name.equals(tree.name)){
                    k = i;
                    break;
                }
            }
            DT new_tree = null;
            for (int i=0; i<tree.edges.length; i++){
                if (!atrsTest.get(k).discretized && tree.edges[i].equals(s[k+1])){
                    new_tree = tree.subtrees.get(i);
                    break;
                }
                else {
                    if (atrsTest.get(k).discretized){
                        String[] interval = tree.edges[i].split(" - ");
                        if (!contains(s[k+1],'.')) s[k+1] += ".0";
                        if (!contains(interval[0],'.')) interval[0] += ".0";
                        if (interval.length >1 && !contains(interval[1],'.')) interval[1] += ".0";
                        if (s[k+1].compareTo(interval[0]) >= 0 && (interval.length == 1 || s[k+1].compareTo(interval[1]) <= 0)) {
                            new_tree = tree.subtrees.get(i);
                            break;
                        }
                    }
                }
            }
            if (new_tree == null) value = false;
            else{
                tree = new_tree;
            }
        }
        if (!value) return null;
        return tree.value;
    }

}
