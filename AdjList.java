import java.util.*;
public class AdjList {
    private Map<Integer , Map<Integer,Integer>>adjList;

    public AdjList(){
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex){
        adjList.putIfAbsent(vertex,new HashMap<>());
    }
                      //    0   , 1 ,     8
    public void addEdge(int v1 , int v2, int w){
        addVertex(v1);
        addVertex(v2);
        adjList.get(v1).putIfAbsent(v2,w);
        //adjList.get(v2).put(v1,w);
    }

    public void printGraph(){
        for(int vertex : adjList.keySet()){
            System.out.print(vertex + " ->");
            for (Map.Entry<Integer,Integer>edge : adjList.get(vertex).entrySet()){
                System.out.print(edge.getKey()+ ":"+edge.getValue()+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjList graphlist = new AdjList();
        graphlist.addEdge(1,2,8);
        graphlist.addEdge(1,3,2);
        graphlist.addEdge(2,4,4);
        graphlist.addEdge(3,4,6);


        System.out.println("Adjacency List ");
        graphlist.printGraph();
    }

}
