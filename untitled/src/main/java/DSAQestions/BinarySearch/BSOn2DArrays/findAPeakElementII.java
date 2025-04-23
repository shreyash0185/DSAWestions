package DSAQestions.BinarySearch.BSOn2DArrays;

public class findAPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length;
        int m = mat.length;
        int n = mat[0].length;

        while(low<= high){
            int mid = low + (high-low)/2;

            int  row = maxEle(mat, m, mid);

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < n ? mat[row][mid + 1] : -1;

            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row, mid};

            }else if(mat[row][mid] < left){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return new int[]{-1, -1};

    }
    public int maxEle(int[][] mat, int m, int col) {
        int maxRow = 0;
        for (int i = 1; i < m; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
}
