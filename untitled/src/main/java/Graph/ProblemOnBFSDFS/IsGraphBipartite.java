package Graph.ProblemOnBFSDFS;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i=0;i<V ;i++){
            if(color[i] == -1){
                if(!dfs(graph , color , i , 0))return false;
            }
        }

        return true;

    }

    private boolean dfs(int[][] graph, int[] color, int node, int currentColor) {

        color[node] = currentColor;

        for(int neighbor  : graph[node]){
            if(color[neighbor] == -1){
                if(!dfs(graph , color , neighbor , 1-currentColor))return false;
            }else if(color[neighbor ] == currentColor){
                return false;
            }

        }

        return true;

    }

}
