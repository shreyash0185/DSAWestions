package Graph.ProblemOnBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class GFGDistanceofnearestcellhaving1 {

    // Pair class to hold the row, column and distance.
class Pair {
        int r; // row index
        int c; // column index
        int d; // distance from the nearest 1

        Pair(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;

        }
    }

    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here

        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i= 0 ;i<m;i++){
            for(int j = 0; j < n ;j++){
                if(grid[i][j] == 1){
                    vis[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int[] dx = {-1 , 1 , 0 , 0};
        int[] dy = {0 , 0 , -1 , 1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;


            vis[r][c] = 1;
            ans[r][c] = p.d;
            for(int i = 0 ;i<dx.length ; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] != 1 ){
                    q.add(new Pair(nr, nc, p.d + 1));
                    vis[nr][nc] = 1;

                }

            }

        }

        return ans ;



    }

}


