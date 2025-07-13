package Graph.ProblemOnBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int cnt=0;

        Queue<Pair1> q = new LinkedList<>();

        for(int i= 0 ;i<m;i++){
            for(int j = 0; j < n ;j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair1(i, j, 0));
                }else if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = 0 ;
        int maxt = 0;

        while(!q.isEmpty()){
            Pair1 p = q.poll();
            int r = p.r;
            int c = p.c;
            int t =p.t;

            for(int i = 0 ;i<dx.length ; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr >= 0 && nr < m  &&  nc >= 0 && nc < n  && vis[nr][nc] != 2 && grid[nr][nc] == 1){
                    vis[nr][nc] = 2;
                    q.add(new Pair1(nr, nc, t + 1));
                    count++;
                    maxt = Math.max(maxt , t + 1);

                }
            }
        }
        return cnt == count ? maxt : -1;

    }


}

