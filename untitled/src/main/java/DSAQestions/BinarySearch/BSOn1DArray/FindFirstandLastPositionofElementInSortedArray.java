package DSAQestions.BinarySearch.BSOn1DArray;

//First -> lower Bound
// last -> upper Bound-1
// if lower bound is not there its -1 then return directly -1 , -1


//Count occurrences of a number in a sorted array with duplicates -> SIMILER AAPROCH qESTION ->
// COUNT =  (LAST Occ - FIRST Occ ) + 1 -> BUT ARRAY MUST BE SORTED

public class FindFirstandLastPositionofElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        arr[0] = findFirst(nums, target);
        if (arr[0] == -1) {
            arr[1] = -1;
            return arr;
        }

        arr[1] = findLast(nums, target);
        return arr;
    }

    public int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}
