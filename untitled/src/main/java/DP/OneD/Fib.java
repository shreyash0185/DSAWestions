package DP.OneD;
import java.util.Arrays;

public class Fib {

//Approach 1: Recursion
    public static int fibRec(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }


    //Approach 2: Memoization
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fib(n, dp);

    }

    public int fib(int n, int[] dp) {

        if (n <= 1) return 1;



        if (dp[n] != -1)return dp[n];

        int left = fib(n - 1, dp);

        int right = fib(n - 2, dp);


        return dp[n] = left +right;
    }

    //Approach 3: Tabulation
    public int fibTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Approach 4: Space Optimization
    public int fibSpaceOpt(int n) {
        if (n <= 1) return 1;

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }




}
