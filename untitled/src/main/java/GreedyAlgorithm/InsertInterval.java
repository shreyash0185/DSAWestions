package GreedyAlgorithm;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] result = new int[n + 1][2];
        //use 3 while loop
        int i = 0, j = 0;

        // Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result[j++] = intervals[i++];
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result[j++] = newInterval; // Add the merged interval

        // Add all remaining intervals
        while (i < n) {
            result[j++] = intervals[i++];
        }

        // Resize the result array to the actual number of intervals added
        int[][] finalResult = new int[j][2];
        for (int k = 0; k < j; k++) {
            finalResult[k] = result[k];
        }

        return finalResult;
    }
}
