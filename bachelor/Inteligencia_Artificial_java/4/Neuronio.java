import java.util.Random;
public class Neuronio {
    public String layer;
    public double input;
    public double bias;
    public double sum;
    public double output;

    Neuronio(double in){
        layer = "Input";
        input = in;
    }

    Neuronio(Neuronio[] in, double[] weights, String type){
        if (type.equals("Hidden")) {
            layer = "Hidden";
            bias = new Random().nextDouble();
            sum = sumInW(in,weights);
            output = function(sum + bias);
        }
        else{
            layer = "Output";
            bias = new Random().nextDouble();
            sum = sumHidW(in,weights);
            output = function(sum + bias);
        }
    }

    public double function(double s){
        return 1/(1 + Math.exp(-s));
    }


    //calcula a soma ponderada (+bias) do input, usando a matriz weight
    public double sumInW(Neuronio[] in, double[] weights){
        double out = 0.0;
        for (int i=0; i<in.length; i++){
            out += in[i].input*weights[i];
        }
        return out + bias;
    }

    public double sumHidW(Neuronio[] in, double[] weights){
        double out = 0.0;
        for (int i=0; i<in.length; i++){
            out += in[i].output*weights[i];
        }
        return out + bias;
    }

}
