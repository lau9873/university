import java.util.ArrayList;
import java.util.Arrays;

public class DT {
    String value;
    int counter;
    String name;
    String[] edges; //guarda valores das arestas
    ArrayList<DT> subtrees;

    DT(String v, int t){ //construtor das folhas
        value = v;
        counter = t;
    }

    DT(Atribute a){ //construtor dos atributos
        value = "null";
        name = a.name;
        edges = a.values;
        subtrees = new ArrayList<>();
    }

    void add(DT s){
        subtrees.add(s);
    }
}

