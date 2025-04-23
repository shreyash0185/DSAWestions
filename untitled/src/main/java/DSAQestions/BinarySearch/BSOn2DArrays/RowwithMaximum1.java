package DSAQestions.BinarySearch.BSOn2DArrays;

import java.util.ArrayList;

public class RowwithMaximum1 {

    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int max_cnt = 0;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = mat.get(i);
            if (row == null || row.size() == 0) continue;

            int count = m - lowerBound(row, m, 1);
            if (count > max_cnt) {
                max_cnt = count;
                idx = i;
            }
        }

        return idx;
    }

    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
