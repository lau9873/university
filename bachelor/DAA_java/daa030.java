import java.util.*;

class Node1 {
    public LinkedList<Integer> adj; // Lista de adjacencias
    public boolean visited;         // Valor booleano que indica se foi visitado numa pesquisa
    public int distance;            // Distancia ao no origem da pesquisa

    Node1() {
        adj = new LinkedList<Integer>();
    }
}

// Classe que representa um grafo
class Graph1 {
    int n;           // Numero de nos do grafo
    Node1 nodes[];    // Array para conter os nos

    Graph1(int n) {
        this.n = n;
        nodes = new Node1[n + 1]; // +1 se nos comecam em 1 ao inves de 0
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node1();
    }

    public void addLink(int a, int b) {
        nodes[a].adj.add(b);
        nodes[b].adj.add(a);
    }

    // Algoritmo de pesquisa em largura
    public void bfs(int v, int[][] contagem) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) nodes[i].visited = false;

        q.add(v);
        nodes[v].visited = true;
        nodes[v].distance = 0;

        while (q.size() > 0) {
            int u = q.removeFirst();
            contagem[v][u] = nodes[u].distance;
            for (int w : nodes[u].adj)
                if (!nodes[w].visited) {
                    q.add(w);
                    nodes[w].visited = true;
                    nodes[w].distance = nodes[u].distance + 1;
                }
        }
    }
}

public class daa030 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nos = in.nextInt();
        Graph1 g = new Graph1(nos);
        int e = in.nextInt();
        int[][] contagem = new int[nos + 1][nos + 2];
        for (int i = 0; i < e; i++)
            g.addLink(in.nextInt(), in.nextInt());
        for (int j = 1; j <= nos; j++)
            g.bfs(j, contagem);
        for (int p = 1; p <= nos; p++) {
            int max = 0;
            for (int k = 1; k <= nos; k++) {
                if (contagem[p][k] > max)
                    max = contagem[p][k];
            }
            contagem[p][nos + 1] = max;
        }
        int diametro = 0;
        int raio = Integer.MAX_VALUE;
        for (int p = 1; p <= nos; p++) {
            if (contagem[p][nos + 1] > diametro)
                diametro = contagem[p][nos + 1];
            if (contagem[p][nos + 1] < raio )
                raio = contagem[p][nos + 1];
        }
        System.out.println(diametro);
        System.out.println(raio);
        int count=0;
        for (int p = 1; p <= nos; p++){
            if(contagem[p][nos + 1] == raio) {
                if (count==0) {
                    System.out.print(p);
                    count = 1;
                }
                else
                    System.out.print(" " + p);

            }
        }
        System.out.println();
        int count1=0;
        for (int p = 1; p <= nos; p++){
            if(contagem[p][nos + 1] == diametro) {
                if (count1==0) {
                    System.out.print(p);
                    count1 = 1;
                }
                else
                    System.out.print(" " + p);

            }
        }
        System.out.println();


    }
}

