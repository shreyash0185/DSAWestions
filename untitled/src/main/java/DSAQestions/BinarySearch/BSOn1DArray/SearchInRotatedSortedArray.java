package DSAQestions.BinarySearch.BSOn1DArray;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }
            //Check if left is sorted
            // then check if ele lies on left
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }

            }
            //Check if right is sorted
            // then check if ele lies on right
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

}
