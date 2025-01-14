import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IA04Simple {
    static ArrayList<double[]> nn; //conj de layers (4) - contem o valor de cada neuronio agrupado por layer
    static ArrayList<double[]> nn_inputs; //guarda input de cada camada (4), util para backProp
    static ArrayList<double[][]> weights; //conj de pesos (3)
    static ArrayList<double[]> bias; //conj de bias (3)
    static ArrayList<double[]> deltas; //conj de vetores deltas (3)
    //delta é um vetor de erros indexado a cada camada da network
    static double alpha;

    public static void main(String[] args) throws FileNotFoundException {
        //C:\\Users\\anaca\\Downloads\\mnist_train.csv
        //Fase de treino:
        ArrayList<String[]> aux = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("Train file (path)");
        String train = in.next();

        File myObj = new File(train);
        Scanner myReader = new Scanner(myObj);

        int countCol = 0;
        int size = 7500; //numero de exemplos de treino
        while (size>0){
            String line = myReader.nextLine();
            String[] d = line.split(",");
            aux.add(d);
            size--;
            if (countCol < d.length)
                countCol = d.length;
        }
        int countLines = aux.size();
        myReader.close();
        int max = 0;
        double[][] data = new double[countLines][countCol-1];
        double[] outData = new double[countLines];
        for (int i = 0; i < countLines; i++) {
            String[] g = aux.get(i);
            outData[i] = Integer.parseInt(g[0]);
            for (int j = 1; j < g.length; j++) {
                data[i][j-1] = Integer.parseInt(g[j]);
                if (data[i][j-1] > max)
                    max = (int) data[i][j-1];
            }
        }
        for (int i = 0; i < countLines; i++) {
            for (int j = 0; j < countCol-1; j++) {
                data[i][j] = data[i][j] / max;
            }
        }

        int[] layer_sizes = {countCol-1,30,15,10};
        alpha = 0.00025;
        InicializeNN(layer_sizes);
        backProp(data,outData);

        //Fase de teste:

        System.out.println();
        System.out.println("Test file (path)");
        String test = in.next();

        File myObj1 = new File(test);
        Scanner myReader1 = new Scanner(myObj1);

        aux = new ArrayList<>();
        countCol = 0;
        size= 2000; //numero de exemplos de teste
        while (size>0){
            String line = myReader1.nextLine();
            String[] d = line.split(",");
            aux.add(d);
            size--;
            if (countCol < d.length)
                countCol = d.length;
        }
        countLines = aux.size();
        myReader1.close();
        max = 0;
        double[][] tests = new double[countLines][countCol-1];
        double[] outTest = new double[countLines];
        for (int i = 0; i < countLines; i++) {
            String[] g = aux.get(i);
            outTest[i] = Integer.parseInt(g[0]);
            for (int j = 1; j < g.length; j++) {
                tests[i][j-1] = Integer.parseInt(g[j]);
                if (tests[i][j-1] > max)
                    max = (int) tests[i][j-1];
            }
        }
        for (int i = 0; i < countLines; i++) {
            for (int j = 0; j < countCol-1; j++) {
                tests[i][j] = tests[i][j] / max;
            }
        }

        System.out.println("hit rate " + testNN(tests, outTest));
    }

    public static void InicializeNN(int[] layer_sizes){
        nn = new ArrayList<>(); nn_inputs = new ArrayList<>();
        weights = new ArrayList<>(); bias = new ArrayList<>();
        deltas = new ArrayList<>();
        for (int i=0; i< layer_sizes.length; i++){
            nn.add(new double[layer_sizes[i]]);
            nn_inputs.add(new double[layer_sizes[i]]);
            if (i>=1) {
                weights.add(new double[layer_sizes[i-1]][layer_sizes[i]]);
                bias.add(new double[layer_sizes[i]]);
                deltas.add(new double[layer_sizes[i]]);
                for (int j=0; j<layer_sizes[i]; j++)
                    bias.get(i-1)[j] = new Random().nextDouble();
                for (int j=0; j<layer_sizes[i-1]; j++){
                    for (int k=0; k<layer_sizes[i]; k++)
                        weights.get(i-1)[j][k] = new Random().nextDouble();
                }
            }
        }
    }

    public static void feed_forward(double[] input){
        nn.set(0,input);
        nn_inputs.set(0,input);
        for (int i=1; i<nn.size(); i++) {
            nn_inputs.set(i,prod(nn.get(i - 1), weights.get(i - 1)));
            nn.set(i, sigmoid(sum(nn_inputs.get(i), bias.get(i - 1))));
        }
    }

    public static double[] sigmoid(double[] s){
        double[] out = new double[s.length];
        for (int i=0; i<s.length; i++) {
            if (s[i] < 0) s[i] = -s[i];
            out[i] = 1 / (1 + Math.exp(-s[i]));
        }
        return out;
    }

    public static double[] sum(double[] v1, double[] v2){
        //supondo que tem o mm cumprimento
        double[] out = new double[v1.length];
        for (int i=0; i<v1.length; i++)
            out[i] = v1[i] + v2[i];
        return out;
    }

    public static double[] prod(double[] v, double[][] m){
        double[] out = new double[m[0].length];
        //multiplicacao de vetor 1xn por matriz nxm - resultado vetor 1xm
        for (int i=0; i<out.length; i++) {
            for (int j = 0; j < v.length; j++)
                out[i] += v[j] * m[j][i];
        }
        return out;
    }

    public static void backProp(double[][] examples, double[] y){
        long startTime = System.nanoTime();
        //array de respostas esperadas da rede por cada exemplo
        double[][] ny = new double[y.length][10];
        for (int i=0; i<y.length; i++){
            ny[i][(int) y[i]] = 1;
        }
        double e = 0.0;
        int epochs = 1;
        while (epochs<=7) {
            e = 0.0;
            System.out.println("Doing the epoch number " + epochs + "...");
            for (int ex = 0; ex < examples.length; ex++) {
                feed_forward(examples[ex]);
                //deltaO
                for (int j=0; j<deltas.get(deltas.size()-1).length;j++){
                    e += Math.pow((ny[ex][j] - nn.get(nn.size()-1)[j]),2);
                    deltas.get(deltas.size()-1)[j] = derivate(nn.get(nn.size()-1)[j]) * (ny[ex][j] - nn.get(nn.size()-1)[j]);
                }
                //restantes deltas
                for (int l= deltas.size()-2; l>=0; l--){
                    for (int i=0; i<deltas.get(l).length; i++) {
                        deltas.get(l)[i] = derivate(nn.get(l)[i])*sumProd(weights.get(l+1)[i],deltas.get(l+1));
                    }
                }

                //atualizar os pesos
                for (int w= weights.size()-1; w>=0; w--){
                    for (int i=0; i<weights.get(w).length; i++){
                        for (int j=0; j<weights.get(w)[i].length; j++) {
                            weights.get(w)[i][j] += alpha * deltas.get(w)[j] * nn_inputs.get(w)[i];
                            bias.get(w)[j] += alpha* deltas.get(w)[j];
                        }
                    }
                }
            }
            epochs++;
            e = e/ examples.length;
            System.out.println("RMSE = " + e);
        }
        long endTime = System.nanoTime();
        long timeDuration = (endTime - startTime);
        System.out.println("Learning time = " + timeDuration + " ms");
    }

    //derivada de 1/(1 + exp(-x))
    public static double derivate(double x){
        if (x < 0) x = -x;
        return Math.exp(-x)/Math.pow((1+Math.exp(-x)),2);
    }

    public static double sumProd(double[] w, double[] delta){
        double out = 0.0;
        for (int j=0; j<w.length; j++)
            out += w[j]*delta[j];
        return out;
    }


    public static double testNN(double[][] test, double[] outTest){
        int e = 0;
        for (int i=0; i<test.length; i++){
            feed_forward(test[i]);
            //fazer comparaçao do array de double do output com a resposta
            //esperada e se for diferente incrementa e
            double max = 0.0; int activated = 0;
            for (int j=0; j<nn.get(nn.size()-1).length; j++){
                if (nn.get(nn.size()-1)[j] >= max){
                    max = nn.get(nn.size()-1)[j];
                    activated = j;
                }
            }
            //System.out.println(activated + " vs " + outTest[i]);
            if (activated != outTest[i]) e++;
        }
        return (double) e/test.length;
    }
}
