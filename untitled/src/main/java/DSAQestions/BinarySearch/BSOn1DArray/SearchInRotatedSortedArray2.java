package DSAQestions.BinarySearch.BSOn1DArray;

//Similer to one only but here we only have to skip duplicate from both the side

public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;



            if(nums[mid] == target){
                // return mid;
                return true;
            }

            // Skip duplicates
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low = low+1;
                high = high -1;
                continue;
            }

            //Check if left is sorted
            // then check if ele lies on left
            if(nums[low] <= nums[mid]){
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
        // return -1;
        return false;
    }

}
