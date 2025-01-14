package defpackage;

import java.util.Arrays;
import java.util.Scanner;
/* renamed from: Estatisticas  reason: default package */
/* loaded from: Estatisticas.class */
public class Estatisticas {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        Double[] dArr = new Double[nextInt];
        Double valueOf = Double.valueOf(scanner.nextDouble());
        dArr[0] = valueOf;
        Double d2 = valueOf;
        for (int i2 = 1; i2 < nextInt; i2++) {
            dArr[i2] = Double.valueOf(scanner.nextDouble());
            d2 = Double.valueOf(d2.doubleValue() + dArr[i2].doubleValue());
        }
        Arrays.sort(dArr);
        int doubleValue = (int) (dArr[nextInt - 1].doubleValue() - dArr[0].doubleValue());
        System.out.printf("%.2f \n", Double.valueOf(d2.doubleValue() / nextInt));
        System.out.println(doubleValue);
    }
}
