public class Adjmat {
    private int [][] adjacencyMatrix;
    private int numVertices;
    
    public Adjmat(int numVertices){
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j, int k){
        adjacencyMatrix[i][j] = k;

    }

    public void removeEdge(int i, int j, int k){
        adjacencyMatrix[i][j] = 0;

    }

    public boolean hasEdge(int i, int j ){
        return adjacencyMatrix [i][j] == 1;
    }

    public void printMatrix(){
        System.out.println("Adjacency Matrix");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Adjmat graph = new Adjmat(5);
        graph.addEdge(1, 2,8);
        graph.addEdge(1, 3,2);
        graph.addEdge(2, 4,4);
        graph.addEdge(3, 4,6);

        graph.printMatrix();

        // System.out.println(graph.hasEdge(3, 2));

    }
}