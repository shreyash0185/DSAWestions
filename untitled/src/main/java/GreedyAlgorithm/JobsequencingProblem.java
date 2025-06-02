package GreedyAlgorithm;
import java.util.Arrays;

public class JobsequencingProblem {

    public class Job {
        int start;
        int end;
        int profit;
        int pos; // position of the job in the original input
    }

    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int n = start.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job();
            jobs[i].start = start[i];
            jobs[i].end = end[i];
            jobs[i].profit = profit[i];
            jobs[i].pos = i + 1; // Store the original position
        }

        // Sort jobs by end time
        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        // Dynamic programming array to store maximum profit at each job
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            // Include current job
            int includeProfit = jobs[i].profit;
            int lastNonConflictIndex = findLastNonConflict(jobs, i);
            if (lastNonConflictIndex != -1) {
                includeProfit += dp[lastNonConflictIndex];
            }
            // Exclude current job
            dp[i] = Math.max(includeProfit, dp[i - 1]);
        }

        return dp[n - 1]; // Maximum profit
    }

    private int findLastNonConflict(Job[] jobs, int index) {
        for (int j = index - 1; j >= 0; j--) {
            if (jobs[j].end <= jobs[index].start) {
                return j; // Return the last non-conflicting job index
            }
        }
        return -1; // No non-conflicting job found
    }
}
