package DP.OneD;

public class FrogJump {

    // Recursion
    public int frogJump(int n, int[] heights) {
        if (n == 0) return 0;
        int left = frogJump(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = frogJump(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }
        return Math.min(left, right);
    }

    // Memoization
    public int frogJumpMemo(int n, int[] heights, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int left = frogJumpMemo(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = frogJumpMemo(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }
        dp[n] = Math.min(left, right);
        return dp[n];
    }

    // Tabulation
    public int frogJumpTab(int n, int[] heights) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n];
    }

    // Space Optimization
    public int frogJumpSpaceOpt(int n, int[] heights) {
        if (n == 0) return 0;
        int prev1 = 0, prev2 = 0;
        for (int i = 1; i <= n; i++) {
            int left = prev1 + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int current = Math.min(left, right);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }


}
