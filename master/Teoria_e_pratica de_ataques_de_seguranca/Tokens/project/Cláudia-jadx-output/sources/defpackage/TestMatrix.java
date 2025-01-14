package defpackage;

import java.util.Scanner;
/* renamed from: TestMatrix  reason: default package */
/* loaded from: TestMatrix.class */
class TestMatrix {
    TestMatrix() {
    }

    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        Matrix identity = Matrix.identity(5);
        System.out.println(identity);
        Matrix matrix = new Matrix(scanner.nextInt(), scanner.nextInt());
        matrix.read(scanner);
        System.out.println(matrix);
        Matrix matrix2 = new Matrix(scanner.nextInt(), scanner.nextInt());
        matrix2.read(scanner);
        System.out.println(matrix2);
        Matrix matrix3 = new Matrix(scanner.nextInt(), scanner.nextInt());
        matrix3.read(scanner);
        System.out.println(matrix3);
        System.out.println(identity.transpose());
        System.out.println(matrix.transpose());
        System.out.println(matrix.sum(matrix2));
        System.out.println(matrix.multiply(matrix3));
    }
}
