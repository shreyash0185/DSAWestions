package DSAQestions.BinarySearch.BSOn2DArrays;

public class medianInArowwiseSortedMatrix {


    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int low = getMin(matrix, m);
        int high = getMax(matrix, m, n);
        int req = (m * n) / 2;
        while(low<=high){
            int mid = low + (high-low)/2;

            int smallerEqual = blackBox(matrix , mid );

            if(smallerEqual <= req){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int blackBox(int matrix[][], int mid){
        int count =0;

        for(int i=0;i<matrix.length;i++){
            count += upperBound(matrix[i] , mid);

        }
        return count;
    }

    public static int upperBound(int []arr, int x){
        int n = arr.length;
        int left =0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right - left )/2;

            if(arr[mid] > x){
                right = mid -1;
            }else{
                left = mid+1;
            }

        }
        return left;
    }


    public static int getMin(int[][] matrix, int m) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, matrix[i][0]);
        }
        return min;
    }

    public static int getMax(int[][] matrix, int m, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, matrix[i][n - 1]);
        }
        return max;
    }

}
