// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples
// Ultima alteracao: 01/04/2018
// -----------------------------------------------------------

public class TestSinglyLinkedList {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
      SinglyLinkedList<Integer> listaa = new SinglyLinkedList<>();
      SinglyLinkedList<String> outra = new SinglyLinkedList<>();
      SinglyLinkedList<String> outra2 = new SinglyLinkedList<>();
      // Escrevendo lista (no inicio esta vazia)
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());     
      
      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i=1; i<=5; i++){
         list.addLast(i);
	 listaa.addLast(i);
      }
      System.out.println(list);
      
      System.out.println(listaa);
      // Adicionando numeros de 6 a 10 ao inicio da lista
      for (int i=6; i<=10; i++)
         list.addFirst(i);
      System.out.println(list);

      // Verificando o tamanho da lista
      System.out.println("size = " + list.size());

      // Retirando o primeiro elemento
      list.removeFirst();
      System.out.println(list);

      // Retirando o ultimo elemento
      list.removeLast();
      System.out.println(list);
      list.shift(5);


      
      System.out.println(listaa+"jydjy");
      System.out.println(list);
      list.remove(listaa);
      System.out.println(list);
      System.out.println(listaa);

      outra.addFirst("a");
      outra.addFirst("b");
      outra.addFirst("d");
      outra.addFirst("a");
      outra.addFirst("c");
   
      outra2.addFirst("a");
      
      outra2.addFirst("a");
      outra2.addFirst("b");
      outra2.addFirst("d");
      outra2.addFirst("a");
      outra2.addFirst("c");
   
	   
      System.out.println(outra+"jydjy");
      System.out.println(outra2);
      outra.remove(outra2);
      System.out.println(outra);
      System.out.println(outra2);






	
	//	for (int i=0; i<toRemove.size();i++){
	//  if (occurrences(toRemove.get(i))!=null){
	//	int[] g=occurrences(toRemove.get(i));
	//	for (int j=0; j<g.length;j++){
	//	    g[j]-=j;
	//	    remove(g[j]);
	//	}
	//  }
	//  else continue;
	// }
   }
}
