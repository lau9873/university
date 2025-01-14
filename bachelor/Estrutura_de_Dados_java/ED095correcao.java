import java.util.Scanner;
class Evento{
    public int name;
    public int needs;
    public int start;
    public int end;
    public MyQueue<Bombeiro> Bomb = new LinkedListQueue<>();

    Evento(int name, int needs, int start){
        this.name=name;
        this.needs=needs;
        this.start=start;
    }

}
class Bombeiro{
    String name;
    int livre;
    int num_eventos;
    int num_horas;

    Bombeiro(String name){ this.name= name; livre=0;}

    public void service(Evento event, int tempo){
        num_eventos++;
        num_horas += event.end - event.start;
        livre = tempo + event.end - event.start;
    }
}

public class ED095 {
    private static  int numBomb;
    private static  int numEvento;
    private static int tempo;
    private static  MyQueue<Bombeiro> Quartel= new LinkedListQueue<>();
    private static  MyQueue<Bombeiro> NotAvailable= new LinkedListQueue<>();
    private static  MyQueue<Evento> emEspera= new LinkedListQueue<>();
    private static  MyQueue<Evento> Done = new LinkedListQueue<>();

    private static void setEnd (int name, int end){
        for (int i=0; i < emEspera.size(); i++){
            Evento cur= emEspera.dequeue();
            if (cur.name==name) cur.end= end;
            emEspera.enqueue(cur);
        }
    }


    private static void lerEventos(Scanner in){
        String action= in.next();
        while (!action.equals("FIM")){
            if (action.equals("PARTIDA")) {
                int name = in.nextInt(), needs = in.nextInt(), start= in.nextInt();
                Evento E = new Evento(name,needs,start);
                emEspera.enqueue(E);
                numEvento++;
            }
            if (action.equals("CHEGADA")){
                int name= in.nextInt(), end= in.nextInt();
                setEnd(name, end);
            }
            action= in.next();
        }
    }

    private static void lerBomb(Scanner in){
        for (int i=0; i<numBomb; i++){
            Bombeiro B = new Bombeiro(in.next());
            Quartel.enqueue(B);
        }
    }

    private static void chamar(Evento event) {
        int k = event.needs;
        for (int i =0; i<numBomb && k>0 && !Quartel.isEmpty(); i++) {
            Bombeiro B= Quartel.dequeue();
            event.Bomb.enqueue(B);
            B.service(event, tempo);
            k--;
            NotAvailable.enqueue(B);

        }
    }

    private static void refresh(){
        int k = NotAvailable.size();
        for (int i=0; i<k; i++){
            Bombeiro B = NotAvailable.dequeue();
            if (B.livre<=tempo) Quartel.enqueue(B);
            else NotAvailable.enqueue(B);
        }
    }

    private static void simular() {
        refresh();
        if (emEspera.isEmpty()) return;
        if (emEspera.first().start> tempo){ return;
            /*if (!NotAvailable.isEmpty()) {
                if (NotAvailable.first().livre > tempo) {
                    tempo = Math.min(emEspera.first().start, NotAvailable.first().livre) - 1;
                    return;
                }
            }
            else tempo = emEspera.first().start-1;
            return;*/
        }
        Evento event = emEspera.dequeue();
        chamar(event);
        Done.enqueue(event);
    }

    private static void mostrarBombByEvent() {
        System.out.println("Bombeiros Destacados");
        for (int i=0; i<numEvento; i++){
            Evento event = Done.dequeue();
            System.out.printf("%s %d%n","EVENTO", event.name);
            if (event.Bomb.isEmpty())
                System.out.println("Nenhum");

            else {for (int j=0; j<event.needs && !event.Bomb.isEmpty(); j++)
                    System.out.println(event.Bomb.dequeue().name);}
        }
    }
    private static void mostrarBombInfo(){
        System.out.println("Listagem de Bombeiros");
        for (int i=0; i<numBomb; i++){
            Bombeiro B = Quartel.dequeue();
            System.out.printf("%s %d %d%n", B.name,B.num_eventos, B.num_horas);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flag   = in.nextInt();
        numBomb = in.nextInt();
        lerBomb(in);
        lerEventos(in);
        if (flag==1) System.out.printf("%s %d %s%n", "Ocorreram", numEvento, "eventos");
        else {
            while (!emEspera.isEmpty()) {
                simular();
                tempo++;
            }
            while (!NotAvailable.isEmpty()) {
                refresh();
                tempo++;
            }
            if (flag == 2) mostrarBombByEvent();
            if (flag == 3) mostrarBombInfo();
        }
    }

}
