package DSAQestions.BinarySearch.BSOn1DArray;

//Similer Qestion ->Find out how many times has an array been rotated -> min index only the times or rotation

public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            //Search space is already sorrted
            //then always arr[low] is will be smaller in that search sapace
            if(nums[low] <= nums[high]){
                if(ans > nums[low]){
                    ans = nums[low];
                }
                break;
            }


            if(nums[low] <= nums[mid]){
                if(ans > nums[low]){
                    ans = nums[low];
                }
                low = mid+1;
            }else{
                if(ans > nums[mid]){
                    ans = nums[mid];
                }
                high = mid-1;
            }
        }
        return ans;
    }

}
