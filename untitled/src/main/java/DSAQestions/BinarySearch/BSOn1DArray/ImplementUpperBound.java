package DSAQestions.BinarySearch.BSOn1DArray;

//smallest index such that arr[idx] > x

public class ImplementUpperBound {

    public static int upperBound(int []arr, int x, int n){
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
}
