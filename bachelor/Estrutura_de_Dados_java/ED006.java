import java.util.Scanner;
public class ED006 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int frases=in.nextInt(); //numero de jogos diferentes
	for (int o=0; o<frases;o++){
	    in.nextLine();
	    String line = in.nextLine();
	    int palavras = line.split(" ").length;//numero de palavras da frase
	    int pessoas =in.nextInt();//numero de jogadores
	    CircularLinkedList<String> list = new CircularLinkedList<>();
	    for(int i=0; i<pessoas;i++)
		    list.addLast(in.next());
	    for (int y=0;y<pessoas-1;y++){
		for(int i=0; i<palavras-1;i++)
		    list.rotate();
		list.removeFirst();
	    }
	    String m = list.getFirst();
	    if (!(m.equals("Carlos")))
		System.out.printf("O Carlos livrou-se (coitado do %s!)%n", m);
	    if (m.equals("Carlos"))
		System.out.println("O Carlos nao se livrou");
	}
    }
}
