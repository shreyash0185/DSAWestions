package DSAQestions.BinarySearch.BSOnAnswers;

public class kthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {


        //    range  1  2  3  4  5 ...... 11

        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high - low )/2;
            int miss = arr[mid] - (mid+1);
            if(miss < k){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }

        return low +k;


    }

}
