import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to;     // No destino
    double weight; // Peso da aresta

    Edge(int t, double w) {
        to = t;
        weight = w;
    }
}

// Classe que representa um no
class Node2 {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public double distance;         // Distancia ao no origem da pesquisa

    Node2() {
        adj = new LinkedList<>();
    }
}

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
    public double cost;
    public int node;

    NodeQ(double c, int n) {
        cost = c;
        node = n;
    }

    @Override
    public int compareTo(NodeQ nq) {
        if (cost < nq.cost) return -1;
        if (cost > nq.cost) return +1;
        if (node < nq.node) return -1;
        if (node > nq.node) return +1;
        return 0;
    }
}

// Classe que representa um grafo
class Graph {
    int n;          // Numero de nos do grafo
    Node2[] nodes;   // Array para conter os nos

    Graph(int n) {
        this.n = n;
        nodes = new Node2[n + 1];  // +1 se os nos comecam em 1 ao inves de 0
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node2();
    }

    //grafo nao dirigido
    void addLink(int a, int b, double c) {
        nodes[a].adj.add(new Edge(b, c));
        nodes[b].adj.add(new Edge(a, c));
    }

    // Algoritmo de Dijkstra
    double dijkstra(int s, int d) {

        //Inicializar nos como nao visitados e com distancia infinita
        for (int i = 1; i <= n; i++) {
            nodes[i].distance = Integer.MAX_VALUE;
            nodes[i].visited = false;
        }

        // Inicializar "fila" com no origem
        nodes[s].distance = 0;
        TreeSet<NodeQ> q = new TreeSet<>();
        q.add(new NodeQ(0, s)); // Criar um par (dist=0, no=s)

        // Ciclo principal do Dijkstra
        while (!q.isEmpty()) {

            // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
            NodeQ nq = q.pollFirst();
            int u = nq.node;
            nodes[u].visited = true;
            // System.out.println(u + " [dist=" + nodes[u].distance + "]");
            if (u == d)
                return nodes[u].distance;

            // Relaxar arestas do no retirado
            for (Edge e : nodes[u].adj) {
                int v = e.to;
                double cost = e.weight;
                if (!nodes[v].visited && nodes[u].distance + cost < nodes[v].distance) {
                    q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
                    nodes[v].distance = nodes[u].distance + cost;
                    q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
                }
            }
        }
        return 0;
    }
}

public class daa033 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nos = in.nextInt();
        Graph g = new Graph(nos);
        int edges = in.nextInt();
        String origem = in.next();
        String destino = in.next();
        Map<String, Integer> mapa = new TreeMap<>();
        mapa.put(origem, 1);
        mapa.put(destino, 2);
        int value = 3;
        for (int i = 0; i < edges; i++) {
            String o = in.next();
            String d = in.next();
            if (!mapa.containsKey(o))
                mapa.put(o, value++);
            if (!mapa.containsKey(d))
                mapa.put(d, value++);
            g.addLink(mapa.get(o), mapa.get(d), in.nextDouble());
        }

        double pr= g.dijkstra(1,2);
        System.out.printf("%.1f", pr);
        System.out.println();
    }
}
