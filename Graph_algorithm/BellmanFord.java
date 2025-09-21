package Graph_algorithm;

import java.util.Arrays;

public class BellmanFord {

    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static int[] bellmanFord(int vertices, Edge[] edges, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges |V|-1 times
        for (int i = 1; i < vertices; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                    updated = true;
                }
            }
            if (!updated) break;  // Optimization: stop if no update in an iteration
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains negative weight cycle");
                return null;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int vertices = 5;
        Edge[] edges = new Edge[] {
            new Edge(0, 1, 6),
            new Edge(0, 3, 7),
            new Edge(1, 2, 5),
            new Edge(1, 3, 8),
            new Edge(1, 4, -4),
            new Edge(2, 1, -2),
            new Edge(3, 2, -3),
            new Edge(3, 4, 9),
            new Edge(4, 0, 2),
            new Edge(4, 2, 7)
        };

        int source = 0;
        int[] dist = bellmanFord(vertices, edges, source);

        if (dist != null) {
            System.out.println("Vertex Distance from Source " + source + ":");
            for (int i = 0; i < vertices; i++) {
                System.out.println(i + "\t\t" + dist[i]);
            }
        }
    }
}
