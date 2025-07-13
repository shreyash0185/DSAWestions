package DP.TwoD3DandDPonGrids;
import java.util.Arrays;

public class GridUniquePaths2DP9 {

    //     public int uniquePathsWithObstacles(int[][] obstacleGrid) {

//         int m  = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//        int[][] dp = new int[m][n];
// for (int[] row : dp) {
//     Arrays.fill(row, -1);
// }

//         if( obstacleGrid[0][0] == 1)return 0;

//          helper(m-1 , n-1 , obstacleGrid , dp);
//          return dp[m-1][n-1];

//     }

// public int helper( int i , int j ,int[][] obstacleGrid, int[][]dp) {

//     if(i == 0 && j ==0)return 1;

//     if(i<0 || j < 0)return 0;

//     if(obstacleGrid[i][j] == 1)return 0;

//     if(dp[i][j] != -1 )return dp[i][j];

//     int up = helper(i-1 , j ,obstacleGrid,dp);

//     int left = helper(i , j-1 ,obstacleGrid,dp);

//     dp[i][j] = up + left ;

//     return up + left ;
// }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m  = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        if( obstacleGrid[0][0] == 1)return 0;

        return  helper(m , n , obstacleGrid);


    }

// public int helper( int m , int n,int[][] obstacleGrid, int[][]dp) {

//     for(int i = 0 ;i< m ;i++){

//         for(int j = 0 ;j < n ;j ++){

//             if(obstacleGrid[i][j] == 1){
//                 dp[i][j] =0;
//             }
//             else if(i == 0 && j ==0){dp[i][j] = 1;}
//              else{
//                 int up = 0 ;
//                 int left = 0;

//                 if(i>0){
//                     up = dp[i-1][j];
//                 }

//                 if(j >  0 ){
//                     left = dp[i][j-1];
//                 }

//                 dp[i][j] = up+ left ;
//              }

//         }
//     }

//     return dp[m-1][n-1];


// }


    //Space opti
    public int helper( int m , int n,int[][] obstacleGrid) {

        int[] prev = new int[n];

        for(int i = 0 ;i< m ;i++){

            int[] curr = new int[n];

            for(int j = 0 ;j < n ;j ++){

                if(obstacleGrid[i][j] == 1){
                    curr[j] =0;
                }
                else if(i == 0 && j ==0){curr[j] = 1;}
                else{

                    int left = 0;

                    int up = prev[j];


                    if(j >  0 ){
                        left = curr[j-1];
                    }

                    curr[j] = up+ left ;
                }

            }
            prev = curr;
        }

        return prev[n-1];


    }

}
