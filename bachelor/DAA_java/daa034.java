import java.util.*;

class Edge3 {
    int to;     // No destino
    int weight; // Peso da aresta

    Edge3(int t, int w) {
        to = t;
        weight = w;
    }
}

// Classe que representa um no
class Node3 {
    public LinkedList<Edge3> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public int distance;         // Distancia ao no origem da pesquisa

    Node3() {
        adj = new LinkedList<>();
    }
}

// Classe que representa um no para ficar na fila de prioridade
class NodeQ3 implements Comparable<NodeQ3> {
    public int cost;
    public int node;

    NodeQ3(int c, int n) {
        cost = c;
        node = n;
    }

    @Override
    public int compareTo(NodeQ3 nq) {
        if (cost < nq.cost) return -1;
        if (cost > nq.cost) return +1;
        if (node < nq.node) return -1;
        if (node > nq.node) return +1;
        return 0;
    }
}

// Classe que representa um grafo
class Graph3 {
    int n;          // Numero de nos do grafo
    Node3[] nodes;   // Array para conter os nos

    Graph3(int n) {
        this.n = n;
        nodes = new Node3[n + 1];  // +1 se os nos comecam em 1 ao inves de 0
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node3();
    }

    //grafo dirigido com pesos negativos
    void addLink(int a, int b, int c) {
        nodes[a].adj.add(new Edge3(b, c));
    }

    // Algoritmo de Bellman-Ford
    boolean bellmanFord(int s) {
        for (int v = 1; v < nodes.length; v++)
            nodes[v].distance = Integer.MAX_VALUE / 2;
        nodes[s].distance = 0;
        for (int i = 1; i < nodes.length-1; i++) {
            for (int u = 1; u < nodes.length; u++) {
                for (Edge3 e : nodes[u].adj) {
                    int v = e.to;
                    int cost = e.weight;
                    if (nodes[u].distance + cost < nodes[v].distance) {
                        nodes[v].distance = nodes[u].distance + cost;
                    }
                }
            }
        }
        for (int u = 1; u < nodes.length; u++) {
            for (Edge3 e : nodes[u].adj) {
                int v = e.to;
                int cost = e.weight;
                if (nodes[u].distance + cost < nodes[v].distance) {
                    return true;
                }

            }
        }
        return false;
    }
}

public class daa034 {
    static int nos;
    static int arestas;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            nos = in.nextInt();
            arestas = in.nextInt();
            Graph3 g = new Graph3(nos);
            for (int j = 0; j < arestas; j++) {
                g.addLink(in.nextInt()+1, in.nextInt()+1, in.nextInt());
            }
            if(g.bellmanFord(1))
                System.out.println("possivel");
            else
                System.out.println("impossivel");


        }

    }
}
