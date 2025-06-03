package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }

        // Sort intervals based on the start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the previous one, merge them
            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                // If they do not overlap, add the previous interval to the result
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        res.add(new int[]{start, end});
        // Convert the list to an array and return
        return res.toArray(new int[res.size()][]);

    }
}
