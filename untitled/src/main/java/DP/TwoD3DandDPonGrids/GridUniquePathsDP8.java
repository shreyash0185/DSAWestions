package DP.TwoD3DandDPonGrids;

public class GridUniquePathsDP8 {

    //Recursion
    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(m - 1, n - 1);
    }
    private int uniquePathsHelper(int m, int n) {
        if (m == 0 || n == 0) return 1; // Base case: only one way to reach the first row or column
        return uniquePathsHelper(m - 1, n) + uniquePathsHelper(m, n - 1); // Move down or right
    }

    //Memoization
    public int uniquePathsMemo(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return uniquePathsMemoHelper(m - 1, n - 1, dp);
    }
    private int uniquePathsMemoHelper(int m, int n, int[][] dp) {
        if (m == 0 || n == 0) return 1; // Base case
        if (dp[m][n] != -1) return dp[m][n]; // Check memoization table
        dp[m][n] = uniquePathsMemoHelper(m - 1, n, dp) + uniquePathsMemoHelper(m, n - 1, dp); // Move down or right
        return dp[m][n];
    }


    //Tabulation
    public int uniquePathsTab(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the first row and first column
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Move down or right
            }
        }

        return dp[m - 1][n - 1]; // Return the bottom-right corner value
    }


    //Space Optimization
    public int uniquePathsSpaceOpt(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1); // Initialize the first row

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // Move down or right
            }
        }

        return dp[n - 1]; // Return the last element which is the bottom-right corner value
    }


}
