// Dijkstra’s Algorithm — Concept
// Maintains a distance array for shortest known distances from source.

// Uses a min-priority queue to pick the next vertex with the smallest tentative distance.

// Updates distances to neighbors if a shorter path is found.

// Continues until all vertices are processed.

// Works only for graphs with non-negative edge weights.

package Graph_algorithm;

import java.util.*;

class Edge {
    int dest;
    int weight;
    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class DijkstraAlgorithm {

    // Graph represented as adjacency list: vertex -> list of Edges
    private int vertices;
    private List<List<Edge>> adjList;

    public DijkstraAlgorithm(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(dest, weight));
        // For undirected graphs, also add reverse edge:
        // adjList.get(dest).add(new Edge(src, weight));
    }

    public int[] dijkstra(int src) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min heap: stores pairs (distance, vertex)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int u = curr[1];

            if (currDist > dist[u]) continue; // out of date entry

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[] {dist[v], v});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        DijkstraAlgorithm graph = new DijkstraAlgorithm(5);

        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);

        int[] distances = graph.dijkstra(0);

        System.out.println("Vertex Distance from Source 0:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To " + i + " = " + distances[i]);
        }
    }
}