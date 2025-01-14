package defpackage;

import java.util.Scanner;
/* compiled from: TestMatrix.java */
/* renamed from: Matrix  reason: default package */
/* loaded from: Matrix.class */
class Matrix {
    int[][] data;
    int rows;
    int cols;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix(int i2, int i3) {
        this.data = new int[i2][i3];
        this.rows = i2;
        this.cols = i3;
    }

    public void read(Scanner scanner) {
        for (int i2 = 0; i2 < this.rows; i2++) {
            for (int i3 = 0; i3 < this.cols; i3++) {
                this.data[i2][i3] = scanner.nextInt();
            }
        }
    }

    public String toString() {
        String str = "";
        for (int i2 = 0; i2 < this.rows; i2++) {
            for (int i3 = 0; i3 < this.cols; i3++) {
                str = str + this.data[i2][i3] + " ";
            }
            str = str + "\n";
        }
        return str;
    }

    public static Matrix identity(int i2) {
        Matrix matrix = new Matrix(i2, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            matrix.data[i3][i3] = 1;
        }
        return matrix;
    }

    public Matrix transpose() {
        Matrix matrix = new Matrix(this.cols, this.rows);
        for (int i2 = 0; i2 < this.cols; i2++) {
            for (int i3 = 0; i3 < this.rows; i3++) {
                matrix.data[i2][i3] = this.data[i3][i2];
            }
        }
        return matrix;
    }

    public Matrix sum(Matrix matrix) {
        Matrix matrix2 = new Matrix(this.rows, this.cols);
        for (int i2 = 0; i2 < this.cols; i2++) {
            for (int i3 = 0; i3 < this.rows; i3++) {
                matrix2.data[i3][i2] = matrix.data[i3][i2] + this.data[i3][i2];
            }
        }
        return matrix2;
    }

    public Matrix multiply(Matrix matrix) {
        Matrix matrix2 = new Matrix(this.rows, matrix.cols);
        for (int i2 = 0; i2 < this.rows; i2++) {
            for (int i3 = 0; i3 < matrix.cols; i3++) {
                for (int i4 = 0; i4 < matrix.rows; i4++) {
                    int[] iArr = matrix2.data[i2];
                    int i5 = i3;
                    iArr[i5] = iArr[i5] + (this.data[i2][i4] * matrix.data[i4][i3]);
                }
            }
        }
        return matrix2;
    }
}
