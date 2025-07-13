package DP.TwoD3DandDPonGrids;

public class TriangleDP11 {

    // Recursion

    public int minimumTotal(int[][] triangle) {
        return minimumTotalHelper(0, 0, triangle);
    }
    private int minimumTotalHelper(int i, int j, int[][] triangle) {
        if (i == triangle.length - 1) return triangle[i][j]; // Base case
        int down = minimumTotalHelper(i + 1, j, triangle);
        int downRight = minimumTotalHelper(i + 1, j + 1, triangle);
        return triangle[i][j] + Math.min(down, downRight);
    }

    // Memoization
    public int minimumTotalMemo(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return minimumTotalMemoHelper(0, 0, triangle, dp);
    }
    private int minimumTotalMemoHelper(int i, int j, int[][] triangle, int[][] dp) {
        if (i == triangle.length - 1) return triangle[i][j]; // Base case
        if (dp[i][j] != -1) return dp[i][j]; // Check memoization table
        int down = minimumTotalMemoHelper(i + 1, j, triangle, dp);
        int downRight = minimumTotalMemoHelper(i + 1, j + 1, triangle, dp);
        dp[i][j] = triangle[i][j] + Math.min(down, downRight);
        return dp[i][j];
    }

    // Tabulation
    public int minimumTotalTab(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        // Initialize the last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        // Fill the dp table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0]; // Return the top element which is the minimum path sum
    }


    // Space Optimization

    public int minimumTotalSpaceOpt(int[][] triangle) {
        int n = triangle.length;
        int[] dp = new int[n];

        // Initialize the last row
        for (int j = 0; j < n; j++) {
            dp[j] = triangle[n - 1][j];
        }

        // Fill the dp array from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0]; // Return the top element which is the minimum path sum
    }
}
