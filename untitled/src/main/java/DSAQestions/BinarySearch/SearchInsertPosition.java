package DSAQestions.BinarySearch;

//Similer to finding lower bound

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int ans =nums.length;

        while(left <= right){
            int mid  = left + (right - left)/2;

            if(nums[mid] >= target){

                ans = mid;
                right = mid -1;

            }else{
                left = mid +1;
            }
        }
        return left;
        //return ans;
    }

}
