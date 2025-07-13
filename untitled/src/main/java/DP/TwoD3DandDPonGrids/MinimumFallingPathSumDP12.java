package DP.TwoD3DandDPonGrids;

public class MinimumFallingPathSumDP12 {


    // Recursion
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, minFallingPathSumHelper(n - 1, j, matrix));
        }
        return minSum;
    }
    private int minFallingPathSumHelper(int i, int j, int[][] matrix) {
        if (j < 0 || j >= matrix[0].length) return Integer.MAX_VALUE; // Out of bounds
        if (i == 0) return matrix[0][j]; // Base case
        int down = minFallingPathSumHelper(i - 1, j, matrix);
        int downLeft = minFallingPathSumHelper(i - 1, j - 1, matrix);
        int downRight = minFallingPathSumHelper(i - 1, j + 1, matrix);
        return matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
    }

    // Memoization
    public int minFallingPathSumMemo(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, minFallingPathSumMemoHelper(n - 1, j, matrix, dp));
        }
        return minSum;
    }

    private int minFallingPathSumMemoHelper(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length) return Integer.MAX_VALUE; // Out of bounds
        if (i == 0) return matrix[0][j]; // Base case
        if (dp[i][j] != -1) return dp[i][j]; // Check memoization table
        int down = minFallingPathSumMemoHelper(i - 1, j, matrix, dp);
        int downLeft = minFallingPathSumMemoHelper(i - 1, j - 1, matrix, dp);
        int downRight = minFallingPathSumMemoHelper(i - 1, j + 1, matrix, dp);
        dp[i][j] = matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
        return dp[i][j];
    }


    // Tabulation
    public int minFallingPathSumTab(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        // Initialize the first row
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int down = dp[i - 1][j];
                int downLeft = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int downRight = (j < m - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
            }
        }

        // Find the minimum in the last row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }

        return minSum;
    }

    // Space Optimization
    public int minFallingPathSumSpaceOpt(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];

        // Initialize the first row
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        // Fill the dp table
        for (int i = 1; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                int down = prev[j];
                int downLeft = (j > 0) ? prev[j - 1] : Integer.MAX_VALUE;
                int downRight = (j < m - 1) ? prev[j + 1] : Integer.MAX_VALUE;
                curr[j] = matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
            }
            prev = curr; // Move to the next row
        }

        // Find the minimum in the last row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, prev[j]);
        }

        return minSum;
    }
}
