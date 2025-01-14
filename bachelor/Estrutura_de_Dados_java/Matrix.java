import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matriz
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }
   public static Matrix identity(int n){
       Matrix v = new Matrix(n,n);
       for (int i=0;i<n;i++)
	   v.data[i][i]=1;
       return (v);
   }
    
    public Matrix transpose() {
	Matrix v = new Matrix(cols,rows);
	for (int i = 0; i<cols; i++)
	    for (int j = 0; j<rows; j++)
		v.data[i][j]=data[j][i];
	return (v);
    }
    public Matrix sum(Matrix m) {
        Matrix v = new Matrix(rows,cols);
	for (int i = 0; i<cols; i++)
	    for (int j = 0; j<rows; j++)
		v.data[j][i]=m.data[j][i]+data[j][i];
        return (v);
    }

    public Matrix multiply(Matrix m) {
	Matrix v = new Matrix(rows,m.cols);
	for (int i = 0; i<rows; i++)
	    for (int j = 0; j<m.cols; j++)
		    for (int r = 0; r<cols; r++)
			v.data[i][j]+=data[i][r]*m.data[r][j];
        return (v);
    }
}
