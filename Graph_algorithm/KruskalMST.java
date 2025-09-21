package Graph_algorithm;

import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int src, dest, weight;
    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int i) {
        if (parent[i] != i)
            parent[i] = find(parent[i]); // path compression
        return parent[i];
    }

    public boolean union(int x, int y) {
        int xroot = find(x);
        int yroot = find(y);

        if (xroot == yroot)
            return false; // already connected, cycle

        // Union by rank
        if (rank[xroot] < rank[yroot])
            parent[xroot] = yroot;
        else if (rank[yroot] < rank[xroot])
            parent[yroot] = xroot;
        else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
        return true;
    }
}

public class KruskalMST {

    int vertices;
    Edge[] edges;

    public KruskalMST(int vertices, Edge[] edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void kruskal() {
        Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));

        UnionFind uf = new UnionFind(vertices);

        int mstWeight = 0;
        System.out.println("Edges in Minimum Spanning Tree:");

        int edgesUsed = 0;
        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
                mstWeight += edge.weight;
                edgesUsed++;
                if (edgesUsed == vertices - 1) break;
            }
        }

        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        int vertices = 4;
        Edge[] edges = {
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        };

        KruskalMST graph = new KruskalMST(vertices, edges);
        graph.kruskal();
    }
}
