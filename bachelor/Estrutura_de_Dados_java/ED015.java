import java.util.Scanner;
class Game {
    final char EMPTY = '.';
    private int rows,cols;
    private char m[][];

    //Construtor
    Game(int r, int c) {
	rows=r;
	cols=c;
	m = new char[r][c];
    }

    //Ler a sopa de letras
    public void read(Scanner in) {
	for(int i=0;i<rows;i++)
	    m[i]=in.next().toCharArray();
    }

    //Imprimir a sopa de letras (alterada)
    public void write() {
	for(int i=0;i<rows;i++) {
	    for(int j=0;j<cols;j++) {
		System.out.print(m[i][j]);
	    }
	    System.out.println();
	}
    }
    //Verificar se a palavra esta a frente/tras/direita/esquerda da letra na posicao(x,y)
    boolean verify(String p, int x, int y, int incx, int incy) {
	for(int k=0,i=x,j=y;k<p.length();i+=incx,j+=incy,k++) {
	    if(p.charAt(k) != m[i][j])
		return false;
	}
	return true;
    }
    //Caso se encontrar a palavra, copia-la nas posiçoes corretas para a matriz (alterada)
    void newMatrix(Game gnew,String p, int x, int y, int incx, int incy) {
	for(int i=x,j=y,k=0;k<p.length();i+=incx,j+=incy,k++){
	   	gnew.m[i][j]=p.charAt(k);
	}
    }
    //Obter a matrix alterada
    void check(String p,Game gnew) {
       	int flag=0,compr=p.length()-1;
	
	for(int i=0;i<rows && flag ==0;i++) {
	    for(int j=0;j<cols && flag == 0;j++) {
		if(j+compr <= cols-1 && verify(p,i,j,0,1)) {
		    newMatrix(gnew,p,i,j,0,1);
		    flag=1;
		}else if(j-compr>=0 && verify(p,i,j,0,-1)) {
		    newMatrix(gnew,p,i,j,0,-1);
		    flag=1;
		} else if(i+compr <= rows-1 && verify(p,i,j,1,0)){
		    newMatrix(gnew,p,i,j,1,0);
		    flag=1;
		}else if(i-compr >= 0 && verify(p,i,j,-1,0)){
		    newMatrix(gnew,p,i,j,-1,0);
		    flag=1;
		}
	    }
	}
    }
    //Na matriz alterada assinalar com '.'  as posições em que certas letras das palavras não se encontraram e trocar a matriz original pela alterada 
    void change(Game gnew) {
	for(int i=0;i<rows;i++) {
	    for(int j=0;j<cols;j++) {
		if(gnew.m[i][j] < 'A' || gnew.m[i][j] >'Z')
		    gnew.m[i][j]=EMPTY;
	    }
	}
	for(int i=0;i<rows;i++) {
	    for(int j=0;j<cols;j++) {
		m[i][j]=gnew.m[i][j];
	    }
	}
    }
}
public class ED015{
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int r = in.nextInt();
    int c = in.nextInt();
    int i = 0;

    while (r!=0 || c!=0) {
	i++;
	Game g = new Game(r,c);
	g.read(in);
	int n = in.nextInt();
	Game gnew = new Game(r,c);
        for(int j=1;j<=n;j++) {
	    String palavra=in.next();
	    g.check(palavra,gnew);
	}
	g.change(gnew);
	System.out.println("Input #" + i);
	g.write();
	r = in.nextInt();
	c = in.nextInt();
    }
    }
}
	
