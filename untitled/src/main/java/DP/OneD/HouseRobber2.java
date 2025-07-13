package DP.OneD;

public class HouseRobber2 {

    //Recursion
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, nums.length - 2), robHelper(nums, nums.length - 1));
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
        if (nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        return Math.max(robMemoHelper(nums, nums.length - 2, dp1), robMemoHelper(nums, nums.length - 1, dp2));
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
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }

        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < n - 1; i++) {
            dp2[i] = Math.max(nums[i + 1] + dp2[i - 2], dp2[i - 1]);
        }

        return Math.max(dp1[n - 2], dp2[n - 3]);
    }

    //Space Optimization
    public int robSpaceOpt(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;

        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            int current = Math.max(nums[i] + prev1, prev2);
            prev1 = prev2;
            prev2 = current;
        }

        int firstOption = prev2;

        prev1 = nums[1];
        prev2 = Math.max(nums[1], nums[2]);

        for (int i = 3; i < n; i++) {
            int current = Math.max(nums[i] + prev1, prev2);
            prev1 = prev2;
            prev2 = current;
        }

        return Math.max(firstOption, prev2);
    }
}
