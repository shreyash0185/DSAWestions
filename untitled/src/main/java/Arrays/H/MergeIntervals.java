package Arrays.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] i : intervals) {
            if (i[0] <= end) {
                // Merge overlapping intervals
                end = Math.max(end, i[1]);
            } else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }

        // Add the last merged interval
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
