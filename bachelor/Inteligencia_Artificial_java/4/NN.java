import java.util.Random;

public class NN {
    //Class Neural Networks
    public Neuronio[] inputLayer;
    public double[] deltaI;
    public double[][] weight1;
    public Neuronio[] hiddenLayer;
    public double[] deltaH;
    public double[][] weight2;
    public Neuronio[] outputLayer;
    public double[] deltaO;
    public double quadraticError;

    NN(int i, int h, int o){
        inputLayer = new Neuronio[i];
        deltaI = new double[i];
        weight1 = random(i,h);
        weight2 = random(h,o);
        hiddenLayer = new Neuronio[h];
        deltaH = new double[h];
        outputLayer = new Neuronio[o];
        deltaO = new double[o];
    }

    public void setInputLayer(double[] in){
        for (int i=0; i< inputLayer.length; i++)
            inputLayer[i] = new Neuronio(in[i]);
    }

    public void setHiddenLayer(){
        for (int i=0; i< hiddenLayer.length; i++) {
            double[] col = new double[weight1.length];
            for (int j=0; j< weight1.length; j++)
                col[j] = weight1[j][i];
            hiddenLayer[i] = new Neuronio(inputLayer, col, "Hidden");
        }
    }

    public void refreshHiddenLayer(){
        for (int i=0; i< hiddenLayer.length; i++){
            hiddenLayer[i].sum = 0.0;
            for (int k=0; k< inputLayer.length; k++)
                hiddenLayer[i].sum += inputLayer[k].input*weight1[k][i];
            hiddenLayer[i].output = hiddenLayer[i].function(hiddenLayer[i].sum + hiddenLayer[i].bias);
        }
    }

    public void refreshOutputLayer(){
        for (int i=0; i< outputLayer.length; i++){
            outputLayer[i].sum = 0.0;
            for (int k=0; k< hiddenLayer.length; k++)
                outputLayer[i].sum += hiddenLayer[k].output*weight2[k][i];
            outputLayer[i].output = outputLayer[i].function(outputLayer[i].sum + outputLayer[i].bias);
        }
    }

    public void setOutputLayer() {
        for (int i=0; i< outputLayer.length; i++) {
            double[] col = new double[weight2.length];
            for (int j=0; j< weight2.length; j++)
                col[j] = weight2[j][i];
            outputLayer[i] = new Neuronio(hiddenLayer, col, "Output");
        }
    }

    //inicializa matriz de erros aleatorios
    public double[][] random(int length1, int length2){
        double[][] out = new double[length1][length2];
        Random generator = new Random();
        for (int i=0; i<length1; i++){
            for (int j=0; j<length2; j++){
                out[i][j] = generator.nextDouble();
            }
        }
        return out;
    }

    public void getQError(double[] classification, boolean value){
        if (value){
            refreshHiddenLayer();
            refreshOutputLayer();
        }
        double e = 0.0;
        for (int i=0; i< classification.length; i++){
            e += Math.pow(classification[i] - outputLayer[i].output,2);
        }
        quadraticError = e;
    }
}
