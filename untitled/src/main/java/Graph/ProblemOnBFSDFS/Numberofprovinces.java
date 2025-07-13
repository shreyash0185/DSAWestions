package Graph.ProblemOnBFSDFS;

import java.util.ArrayList;

public class Numberofprovinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // number of cities
        int[] vis = new int[n];
        int count = 0;

        // Convert adjacency matrix to adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i); // because it's undirected
                }
            }
        }

        // Perform DFS
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adjList, vis);
            }
        }
        return count;

    }


    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis) {
        vis[node] = 1;
        for (Integer neighbor : adjList.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, adjList, vis);
            }
        }
    }

}
