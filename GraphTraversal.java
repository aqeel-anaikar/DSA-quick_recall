import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class GraphTraversal {
    private Map <Integer, List<Integer>> graph = new HashMap<>();    

    public void addEdge(int from, int to){
        graph.putIfAbsent(from,new ArrayList<>());
        graph.get(from).add(to);
    }
    public void printGraph(){
        System.out.print("Graph");
        for(int node : graph.keySet()){
            System.out.print(node+" -> ");
            for(int neighbor:graph.get(node)){
                System.out.print(neighbor+" ");
            }
            System.out.println();
        }
    }

    public void bfs(int start){
        Set <Integer> visited = new HashSet<>();
        Queue <Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);
        System.out.print("BFS ");

        while (!queue.isEmpty()) 
        {
            int current = queue.poll();
            System.out.print(current+ " ");

            for(int neighbor : graph.getOrDefault(current, Collections.emptyList())){
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int start){
        Set <Integer> visited = new HashSet<>();
        Stack <Integer> stack = new Stack<>();

        stack.add(start);
        visited.add(start);
        System.out.print("BFS ");

        while (!stack.isEmpty()) 
        {
            int current = stack.pop();
            System.out.print(current+ " ");

            for(int neighbor : graph.getOrDefault(current, Collections.emptyList())){
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DFS g = new DFS();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        g.printGraph();
        g.bfs(1);
        g.dfs(1);
 
    }
}
