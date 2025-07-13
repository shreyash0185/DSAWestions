package Graph.ProblemOnBFSDFS;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class G11DetectCycleUndirectedGraphBFS {


    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of(1, 2)); // Node 0 connected to 1 and 2
        graph.add(List.of(0, 3)); // Node 1 connected to 0 and 3
        graph.add(List.of(0));     // Node 2 connected to 0
        graph.add(List.of(1));     // Node 3 connected to 1

        System.out.println(isCycle(graph)); // Output: true or false based on cycle detection

    }

    public static boolean isCycle(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfs(graph, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs(List<List<Integer>> graph, int start, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);

                } else if (neighbor != start) {

                    return true; // Cycle detected


                }

            }


        }
        return false; // No cycle detected

    }

}



