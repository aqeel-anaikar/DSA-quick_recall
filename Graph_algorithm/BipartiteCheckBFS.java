package Graph_algorithm;

import java.util.*;

public class BipartiteCheckBFS {

    private int V; // Number of vertices
    private List<List<Integer>> adj;

    public BipartiteCheckBFS(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected graph
    }

    public boolean isBipartite() {
        int[] colors = new int[V];
        Arrays.fill(colors, -1); // -1 means uncolored

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) { // If not colored, start BFS
                if (!bfsCheck(i, colors))
                    return false;
            }
        }
        return true;
    }

    private boolean bfsCheck(int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0; // Start with color 0

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int nbr : adj.get(u)) {
                if (colors[nbr] == -1) {
                    colors[nbr] = 1 - colors[u]; // Assign opposite color
                    queue.add(nbr);
                } else if (colors[nbr] == colors[u]) {
                    // Same color adjacent node found — not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteCheckBFS graph = new BipartiteCheckBFS(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        System.out.println("Graph is bipartite? " + graph.isBipartite());

        BipartiteCheckBFS graph2 = new BipartiteCheckBFS(3);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);

        System.out.println("Graph2 is bipartite? " + graph2.isBipartite());
    }
}