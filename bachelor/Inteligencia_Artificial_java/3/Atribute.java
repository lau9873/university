import java.util.ArrayList;
import java.util.Arrays;

public class Atribute {
    String name;
    String[] values;
    int[] exs;
    //Informacao sobre quantos exs existem para cada valor possivel
    ArrayList<ArrayList<String[]>> regists;
    //guarda registos para cada valor possivel
    boolean discretized;

    Atribute(String n){
        name = n;
        regists = new ArrayList<>();
        discretized = false;
    }

    void values(String[] v){
        values = v;
        exs = new int[values.length];
        for (int i=0; i< values.length; i++) {
            ArrayList<String[]> l = new ArrayList<>();
            regists.add(l);
        }
    }

    void registerI(int k, ArrayList<String[]> data){
        for (int i=0; i<regists.size(); i++) regists.get(i).clear();

        for (int j=0; j<data.size(); j++) {
            if (data.get(j)[0].equals("ID")) continue;
            String value = data.get(j)[k];
            for (int i = 0; i < values.length; i++) {
                if (value.equals(values[i])) {
                    exs[i]++;
                    regists.get(i).add(data.get(j));
                }
            }
        }
    }

    void register(int k, ArrayList<String[]> data){
        for (int i=0; i<regists.size(); i++) regists.get(i).clear();

        for (int j=0; j<data.size(); j++) {
            if (data.get(j)[0].equals("ID")) continue;
            String value = data.get(j)[k];
            for (int i = 0; i < values.length; i++) {
                String[] interval = values[i].split(" - ");
                if (!discretized || (discretized && interval.length == 1)) {
                    if (value.equals(values[i])) {
                        //exs[i]++;
                        regists.get(i).add(data.get(j));
                    }
                }
                else{
                    if (value.compareTo(interval[0]) >= 0 && value.compareTo(interval[1]) <= 0)
                        regists.get(i).add(data.get(j));
                }
            }
        }
    }

}