package DP.OneD;

public class HouseRobber1 {

    //Recursion
    public int rob(int[] nums) {
        return robHelper(nums, nums.length - 1);
    }
    private int robHelper(int[] nums, int n) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        int robCurrent = nums[n] + robHelper(nums, n - 2);
        int skipCurrent = robHelper(nums, n - 1);
        return Math.max(robCurrent, skipCurrent);
    }

    //Memoization
    public int robMemo(int[] nums) {
        int[] dp = new int[nums.length];
        java.util.Arrays.fill(dp, -1);
        return robMemoHelper(nums, nums.length - 1, dp);
    }
    private int robMemoHelper(int[] nums, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if (dp[n] != -1) return dp[n];
        int robCurrent = nums[n] + robMemoHelper(nums, n - 2, dp);
        int skipCurrent = robMemoHelper(nums, n - 1, dp);
        dp[n] = Math.max(robCurrent, skipCurrent);
        return dp[n];
    }


    //Tabulation
    public int robTab(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    //Space Optimization
    public int robSpaceOpt(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
