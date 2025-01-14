 class Atribute {
    String name;
    String[] values;
    int[] exs;
    //Informacao sobre quantos exs existem para cada valor possivel

    Atribute(String n){
        n = name;
    }

    void values(String[] v){
        values = v;
        exs = new int[values.length];
    }

    void register(String value){
        for (int i=0; i<values.length; i++){
            if (value.equals(values[i])){
                exs[i]++;
                return;
            }
        }
    }

    double entropy(){
        double[] prob = new double[values.length];
        double total = 0, ent = 0;
        for (int i=0; i< values.length; i++) total += exs[i];
        for (int i=0; i< values.length; i++){
            prob[i] = exs[i]/total;
            ent -= prob[i]+Math.log(prob[i]); //Mudar log para base = 2!
        }
        return ent;
    }
}

