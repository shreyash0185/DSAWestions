package Graph.ProblemOnBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    class Pair{
        int r ;
        int c ;
        int d ;

        public Pair(int r , int c , int d){
            this.r = r ;
            this.c = c ;
            this.d = d ;

        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i= 0 ;i<m;i++){
            for(int j = 0; j < n ;j++){
                if(mat[i][j] == 0){
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

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] != 1 && mat[nr][nc] != 0){
                    q.add(new Pair(nr, nc, p.d + 1));
                    vis[nr][nc] = 1;

                }

            }

        }

        return ans ;

    }
}

