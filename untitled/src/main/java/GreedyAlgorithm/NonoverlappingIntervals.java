package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> res = new ArrayList<int[]>();
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }
        // Sort intervals based on the end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        int count = 1; // Count of non-overlapping intervals
        for (int i = 0; i < intervals.length; i++) {
            // If the current interval starts before the last added interval ends, it overlaps
            if (intervals[i][0] <= end) {
                count++; // Increment count of intervals to remove
                end = intervals[i][1];
            }
        }
        return intervals.length - count; // Return the count of intervals to remove
    }
    public static void main(String[] args) {
        NonoverlappingIntervals solution = new NonoverlappingIntervals();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int result = solution.eraseOverlapIntervals(intervals);
        System.out.println("Number of intervals to remove: " + result); // Output: 1
    }

}
