package DSAQestions.BinarySearch.BSOn1DArray;


//smallest index such that arr[idx] >=x

public class ImplementLowerBound {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

}
