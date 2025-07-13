package DP.TwoD3DandDPonGrids;

public class NinjasTrainingDP7 {

    //not done yet - this is a template for Ninja's Training problem in Dynamic Programming

    // Recursion
    public int ninjaTraining(int n, int[][] points) {
        return ninjaTrainingHelper(n - 1, points, -1);
    }

    private int ninjaTrainingHelper(int day, int[][] points, int lastTask) {
        if (day < 0) return 0;

        int maxPoints = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                maxPoints = Math.max(maxPoints, points[day][task] + ninjaTrainingHelper(day - 1, points, task));
            }
        }
        return maxPoints;
    }

    // Memoization
    public int ninjaTrainingMemo(int n, int[][] points) {
        int[][] dp = new int[n][4]; // 3 tasks + 1 for lastTask
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return ninjaTrainingMemoHelper(n - 1, points, -1, dp);
    }
    private int ninjaTrainingMemoHelper(int day, int[][] points, int lastTask, int[][] dp) {
        if (day < 0) return 0;
        if (dp[day][lastTask + 1] != -1) return dp[day][lastTask + 1];

        int maxPoints = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastTask) {
                maxPoints = Math.max(maxPoints, points[day][task] + ninjaTrainingMemoHelper(day - 1, points, task, dp));
            }
        }
        dp[day][lastTask + 1] = maxPoints;
        return maxPoints;
    }

    // Tabulation
    public int ninjaTrainingTab(int n, int[][] points) {
        int[][] dp = new int[n][4]; // 3 tasks + 1 for lastTask

        for (int task = 0; task < 3; task++) {
            dp[0][task] = points[0][task];
        }
        dp[0][3] = 0; // lastTask not applicable on first day

        for (int day = 1; day < n; day++) {
            for (int task = 0; task < 4; task++) {
                dp[day][task] = 0;
                for (int t = 0; t < 3; t++) {
                    if (t != task) {
                        dp[day][task] = Math.max(dp[day][task], points[day][t] + dp[day - 1][t]);
                    }
                }
            }
        }

        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    // Space Optimization
    public int ninjaTrainingSpaceOpt(int n, int[][] points) {
        int[] prev = new int[4]; // 3 tasks + 1 for lastTask

        for (int task = 0; task < 3; task++) {
            prev[task] = points[0][task];
        }
        prev[3] = 0; // lastTask not applicable on first day

        for (int day = 1; day < n; day++) {
            int[] current = new int[4];
            for (int task = 0; task < 4; task++) {
                current[task] = 0;
                for (int t = 0; t < 3; t++) {
                    if (t != task) {
                        current[task] = Math.max(current[task], points[day][t] + prev[t]);
                    }
                }
            }
            prev = current;
        }

        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }
}
