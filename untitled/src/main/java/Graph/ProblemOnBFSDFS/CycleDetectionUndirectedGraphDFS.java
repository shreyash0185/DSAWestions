package Graph.ProblemOnBFSDFS;

public class CycleDetectionUndirectedGraphDFS {

    public boolean isCycle(int V , int[][] adj){
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i , -1 , vis , adj)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node , int parent , boolean[] vis , int[][] adj){
        vis[node] = true;

        for(int neighbor : adj[node]){
            if(!vis[neighbor]){
                if(dfs(neighbor , node , vis ,adj)){
                    return true;
                }
            } else if (neighbor != parent) {
                return true;

            }
        }
        return false;

    }
}
