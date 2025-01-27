/* -----------------------------------
  Estruturas de Dados 2020/2021
  Jogo da Vida [ED088]  
----------------------------------- */

import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	rows = r;
	cols = c;
	m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
	for (int i=0; i<rows; i++)
	    m[i] = in.next().toCharArray();
    }
    
    // Metodo para escrever a matriz m[][]
    public void write() {
      String ans = "";
   
	   
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += m[i][j];
         ans += "\n";
      }
      System.out.print(ans);
      
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
	int count = 0; 
	    for (int g=y-1; g<y+2; g++)
		for(int i=x-1; i<x+2; i++){
		    if (i<0 || i>cols-1 || g<0 || g>rows-1 ||(g==y && i==x))
			continue;
		    if( m[g][i]==ALIVE)
			count++;
		    
		}  
	return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public Game iterate() {
	Game v= new Game(rows,cols);
	for (int j=0; j<rows; j++)
	    for (int l=0;l<cols;l++){
		if (m[j][l]==ALIVE){
		    if(countAlive(j,l)==2||countAlive(j,l)==3) 
			v.m[j][l]=ALIVE;
		    else
		       v.m[j][l]=DEAD;
		}	
		if (m[j][l]==DEAD){
		    if(countAlive(j,l)==3)
		       v.m[j][l]=ALIVE;
		    else
		       v.m[j][l]=DEAD;
		}
	    }
	  
	return (v);
    }
}

// Classe principal com o main()
public class ED088 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	// Ler linhas, colunas e numero de iteracoes
	int rows = in.nextInt();
	int cols = in.nextInt();
	int n    = in.nextInt();

	// Criar objecto para conter o jogo e ler estado inicial
	Game g = new Game(rows, cols);
	g.read(in);
	for(int k=0;k<n;k++)
	    g=g.iterate();
	    
		
	
	g.write();
	
    }
}
