package Graph.Learning;

import java.util.ArrayList;
import java.util.List;

public class DFSonGraph {

    public static void dfs(int n, ArrayList<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        ArrayList <Integer> result = new ArrayList<>();

        dfsHelper(0, visited, adj, result);
        // Print the result
        for (int node : result) {
            System.out.print(node + " ");
        }
    }

    private static void dfsHelper(int node, boolean[] visited, ArrayList<List<Integer>> adj, ArrayList<Integer> result) {
        visited[node] =true;
        result.add(node);

        for(int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, adj, result);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        int n = 5; // Number of nodes
        ArrayList<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);

        // Perform DFS
        dfs(n, adj);
    }
}
