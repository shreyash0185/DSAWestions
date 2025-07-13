package Graph.Learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFSonGraph {

    //number of node given and adjacency list given
    public static void bfs(int n, ArrayList<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(0); // Start BFS from node 0
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

    }
}
