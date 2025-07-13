package DP.TwoD3DandDPonGrids;

public class MinimumpathsuminGrid {

    // Recursion
    public int minPathSum(int[][] grid) {
        return minPathSumHelper(grid, grid.length - 1, grid[0].length - 1);
    }
    private int minPathSumHelper(int[][] grid, int i, int j) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE; // Out of bounds
        if (i == 0 && j == 0) return grid[0][0]; // Base case
        int up = minPathSumHelper(grid, i - 1, j);
        int left = minPathSumHelper(grid, i, j - 1);
        return grid[i][j] + Math.min(up, left);
    }

    // Memoization
    public int minPathSumMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return minPathSumMemoHelper(grid, m - 1, n - 1, dp);
    }
    private int minPathSumMemoHelper(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE; // Out of bounds
        if (i == 0 && j == 0) return grid[0][0]; // Base case
        if (dp[i][j] != -1) return dp[i][j]; // Check memoization table
        int up = minPathSumMemoHelper(grid, i - 1, j, dp);
        int left = minPathSumMemoHelper(grid, i, j - 1, dp);
        dp[i][j] = grid[i][j] + Math.min(up, left);
        return dp[i][j];
    }

    // Tabulation
    public int minPathSumTab(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0]; // Start point

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1]; // Return the bottom-right corner value
    }

    // Space Optimization
    public int minPathSumSpaceOpt(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = grid[0][0]; // Start point

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // Fill the rest of the dp array
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0]; // First column
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[n - 1]; // Return the last element which is the bottom-right corner value
    }

}
