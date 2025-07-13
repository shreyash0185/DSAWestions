package DP.DpOnSubsequences;

public class SubsetsumequaltotargetDP14 {

    //Recursion
    public boolean isSubsetSum(int[] arr, int target) {
        return isSubsetSumHelper(arr, target, arr.length - 1);
    }
    private boolean isSubsetSumHelper(int[] arr, int target, int index) {
        if (target == 0) return true; // Found a subset with the target sum
        if (index < 0 || target < 0) return false; // No valid subset found

        // Include the current element or exclude it
        return isSubsetSumHelper(arr, target - arr[index], index - 1) ||
               isSubsetSumHelper(arr, target, index - 1);
    }

    //Memoization
    public boolean isSubsetSumMemo(int[] arr, int target) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        return isSubsetSumMemoHelper(arr, target, n - 1, dp);
    }

    private boolean isSubsetSumMemoHelper(int[] arr, int target, int index, Boolean[][] dp) {
        if (target == 0) return true; // Found a subset with the target sum
        if (index < 0 || target < 0) return false; // No valid subset found
        if (dp[index][target] != null) return dp[index][target]; // Check memoization table

        // Include the current element or exclude it
        boolean include = isSubsetSumMemoHelper(arr, target - arr[index], index - 1, dp);
        boolean exclude = isSubsetSumMemoHelper(arr, target, index - 1, dp);

        dp[index][target] = include || exclude; // Store result in memoization table
        return dp[index][target];
    }

    //Tabulation
    public boolean isSubsetSumTab(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: A sum of 0 can always be achieved with an empty subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target]; // Return whether the target sum can be achieved
    }

    //Space Optimization
    public boolean isSubsetSumSpaceOpt(int[] arr, int target) {
        int n = arr.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // A sum of 0 can always be achieved with an empty subset

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        return dp[target]; // Return whether the target sum can be achieved
    }

    public static void main(String[] args) {
        SubsetsumequaltotargetDP14 solution = new SubsetsumequaltotargetDP14();
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;

        System.out.println("Recursion: " + solution.isSubsetSum(arr, target));
        System.out.println("Memoization: " + solution.isSubsetSumMemo(arr, target));
        System.out.println("Tabulation: " + solution.isSubsetSumTab(arr, target));
        System.out.println("Space Optimization: " + solution.isSubsetSumSpaceOpt(arr, target));
    }
}
