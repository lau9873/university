import java.util.*;

public class Estatisticas{
    public static void main(String[] args) {
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	Double v[] = new Double[n];
	Double var = stdin.nextDouble();
	v[0]=var;
	Double soma = var;
        for (int i=1; i<n;i++){
	    v[i] = stdin.nextDouble();
	    soma+=v[i];
	}
	Arrays.sort(v);
	int amp = (int)(v[n-1]-v[0]);
	System.out.printf("%.2f\n", (soma/n));
	System.out.println(amp);
    }     		       
}
