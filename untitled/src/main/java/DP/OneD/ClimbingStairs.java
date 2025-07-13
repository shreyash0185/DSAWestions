package DP.OneD;

public class ClimbingStairs {

    //Recursion
    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //Memoization
    public int climbStairsMemo(int n, int[] dp) {
        if (n <= 2) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
        return dp[n];
    }

    //Tabulation
    public int climbStairsTab(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Space Optimization
    public int climbStairsSpaceOpt(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2, current = 0;
        for (int i = 3; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }


}
