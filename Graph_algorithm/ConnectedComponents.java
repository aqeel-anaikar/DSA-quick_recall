package Graph_algorithm;

import java.util.*;

public class ConnectedComponents {

    private int V; // number of vertices
    private List<List<Integer>> adj; // adjacency list

    public ConnectedComponents(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected graph
    }

    private void dfs(int v, boolean[] visited, List<Integer> component) {
        visited[v] = true;
        component.add(v);

        for (int nbr : adj.get(v)) {
            if (!visited[nbr]) {
                dfs(nbr, visited, component);
            }
        }
    }

    public List<List<Integer>> findConnectedComponents() {
        boolean[] visited = new boolean[V];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    public static void main(String[] args) {
        ConnectedComponents graph = new ConnectedComponents(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);

        List<List<Integer>> components = graph.findConnectedComponents();

        System.out.println("Number of connected components: " + components.size());
        int i = 1;
        for (List<Integer> comp : components) {
            System.out.println("Component " + (i++) + ": " + comp);
        }
    }
}

