package Graph_algorithm;

import java.util.*;

public class TopologicalSortDFS {

    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    public TopologicalSortDFS(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int nbr : adj.get(v)) {
            if (!visited[nbr]) {
                topologicalSortUtil(nbr, visited, stack);
            }
        }
        stack.push(v);
    }

    public List<Integer> topologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topoOrder.add(stack.pop());
        }
        return topoOrder;
    }

    public static void main(String[] args) {
        TopologicalSortDFS graph = new TopologicalSortDFS(6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);

        List<Integer> topoOrder = graph.topologicalSort();
        System.out.println("Topological Sort order: " + topoOrder);
    }
}