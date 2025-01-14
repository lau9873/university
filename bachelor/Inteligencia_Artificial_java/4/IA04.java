/*
    Descrição da implementação:
        Para um input com 784 entradas entre 0 e 1, criamos uma rede com 784 neuronios de entrada
        0.5/0.75/1 (*784) neuronios na camada oculta e 10 neuronios de saída, cada um deles correspondendo
        ao digito que foi detetado.

        A estrututra da rede vai ser fixa, exceto para um possivel numero diferente de neuronios entre cada
        camada, e a ligação entre cada camada vai ser descrita através de uma matriz de pesos que será
        atualizada ao longo da aprendizagem da rede. A inicialização da rede pressupõe que os pesos e
        os biás de cada neuronio (se tiver) são numeros aleatórios entre [0,1].

        Depois de criada a rede, vamos passar todos os inputs que temos disponíveis no conjunto de treino
        e obtemos a resposta da rede. A partir do output calculado comparamos com o output esperado (1ª
        coluna do dataset) e calculamos o RMSE da seguinte forma:
            output_obtido = [out0,out1,...,out9], output_esperado = [0,...,0,1,0,...0], n = quantidade de exemplos
            sqrt((sum (para i de 0 a 9) (outi - output_esperado[i])^2) /n)
        Este erro vais ser meramente indicativo da qualidade da classificação de exemplos de treino.

 */
import java.io.*;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class IA04 {
    static NN neuralNetwork;
    static double alpha;

    public static void main(String[] args) throws FileNotFoundException{
        //C:\\Users\\anaca\\Downloads\\mnist_train.csv
        //Fase de treino:
        ArrayList<String[]> aux = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("Train file (path)");
        String train = in.next();

        File myObj = new File(train);
        Scanner myReader = new Scanner(myObj);

        int countCol = 0;
        int size = 15000; //numero de exemplos de treino
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


        int[] layer_sizes = {countCol-1,4*(countCol-1)/4,10};
        alpha = 0.0025;

        InicializeNN(layer_sizes, data);
        BackPropLearning(data,outData);


        //Fase de teste:

        System.out.println();
        System.out.println("Test file (path)");
        String test = in.next();

        File myObj1 = new File(test);
        Scanner myReader1 = new Scanner(myObj1);

        aux = new ArrayList<>();
        countCol = 0;
        size= 10000; //numero de exemplos de teste
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

        System.out.println("Hit rate = " + (1-testNN(tests, outTest)));
    }

    public static void InicializeNN(int[] layer_sizes, double[][] examples){
        //System.out.println("Inicializing the neural network...");
        neuralNetwork = new NN(layer_sizes[0],layer_sizes[1],layer_sizes[2]);
        neuralNetwork.setInputLayer(examples[0]);
        neuralNetwork.setHiddenLayer();
        neuralNetwork.setOutputLayer();
    }


   public static void BackPropLearning(double[][] examples, double[] y){
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
                //feed forward de cada exemplo
                neuralNetwork.setInputLayer(examples[ex]);
                neuralNetwork.refreshHiddenLayer();
                neuralNetwork.refreshOutputLayer();
                //delta é um vetor de erros indexado a cada camada da network
                for (int j = 0; j < neuralNetwork.outputLayer.length; j++) {
                    e += Math.pow((ny[ex][j] - neuralNetwork.outputLayer[j].output),2);
                    neuralNetwork.deltaO[j] = derivate(neuralNetwork.outputLayer[j].output) *
                            (ny[ex][j] - neuralNetwork.outputLayer[j].output);
                }
                for (int i = 0; i < neuralNetwork.hiddenLayer.length; i++) {
                    neuralNetwork.deltaH[i] = derivate(neuralNetwork.hiddenLayer[i].output)*
                           sum(neuralNetwork.weight2,i,neuralNetwork.deltaO);
                }
                for (int i = 0; i < neuralNetwork.inputLayer.length; i++) {
                    neuralNetwork.deltaI[i] = derivate(neuralNetwork.inputLayer[i].input)*
                           sum(neuralNetwork.weight1,i,neuralNetwork.deltaH);
                }

                for (int i = 0; i < neuralNetwork.weight2.length; i++) {
                    for (int j = 0; j < neuralNetwork.weight2[i].length; j++) {
                        neuralNetwork.weight2[i][j] +=
                               alpha*neuralNetwork.hiddenLayer[i].sum*neuralNetwork.deltaO[j];
                        neuralNetwork.outputLayer[j].bias += alpha * neuralNetwork.deltaO[j];
                    }
                }
                for (int i = 0; i < neuralNetwork.weight1.length; i++) {
                    for (int j = 0; j < neuralNetwork.weight1[i].length; j++) {
                        neuralNetwork.weight1[i][j] +=
                                alpha*neuralNetwork.inputLayer[i].input*neuralNetwork.deltaH[j];
                        neuralNetwork.hiddenLayer[j].bias += alpha * neuralNetwork.deltaH[j];
                    }
                }
            }
            e = e/ examples.length;
            System.out.println("RMSE = " + e);
            epochs++;
        }
       long endTime = System.nanoTime();
       long timeDuration = (endTime - startTime);
       System.out.println("Learning time = " + timeDuration + " ms");
    }

    public static double sum(double[][] w, int i, double[] delta){
        //multiplicacao do vetor w[i] (em linha) por delta (em coluna)
        double out = 0.0;
        for (int j=0; j<w[i].length; j++)
            out += w[i][j]*delta[j];
        return out;
    }
    //derivada de 1/(1 + exp(-x))
    public static double derivate(double x){
        return Math.exp(-x)/Math.pow((1+Math.exp(-x)),2);
    }

    public static double testNN(double[][] test, double[] outTest){
        int e = 0;
        for (int i=0; i<test.length; i++){
            neuralNetwork.setInputLayer(test[i]);
            neuralNetwork.refreshHiddenLayer();
            neuralNetwork.refreshOutputLayer();
            //fazer comparacao do array de double do output com a resposta
            //esperada e se for diferente incrementa e
            double max = 0.0; int activated = 0;
            for (int j=0; j<neuralNetwork.outputLayer.length; j++){
                if (neuralNetwork.outputLayer[j].output >= max){
                    max = neuralNetwork.outputLayer[j].output;
                    activated = j;
                }
            }
            //System.out.println(activated + " vs " + outTest[i]);
            if (activated != outTest[i]) e++;
        }
        return (double) e/test.length;
    }
}
