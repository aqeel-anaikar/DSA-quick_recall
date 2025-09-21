package Graph_algorithm;

import java.util.*;

public class CycleDetectionDirected {

    private int V;
    private List<List<Integer>> adj;

    public CycleDetectionDirected(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private boolean dfs(int u, boolean[] visited, boolean[] recStack) {
        visited[u] = true;
        recStack[u] = true;

        for (int neighbor : adj.get(u)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, recStack)) return true;
            } else if (recStack[neighbor]) {
                return true; // cycle detected
            }
        }

        recStack[u] = false;
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionDirected graph = new CycleDetectionDirected(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        System.out.println("Directed graph has cycle? " + graph.isCyclic());
    }
}