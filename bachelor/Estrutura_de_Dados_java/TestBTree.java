// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.*;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      int N=in.nextInt();
      for (int i=0;i<N;i++){
	  BTree<Integer> t = LibBTree.readIntTree(in);

	  // Escrever resultado de chamada a alguns metodos
	  System.out.println("numberNodes = " + t.numberNodes());
	  System.out.println("depth = " + t.depth());
	  System.out.println("contains(2) = " + t.contains(2));
	  System.out.println("contains(3) = " + t.contains(3));

	  // Escrever nos da arvore seguindo varias ordens possiveis
      
    
	  System.out.println(Arrays.toString(ED240.paths(t)));
      }
      
   }
}
