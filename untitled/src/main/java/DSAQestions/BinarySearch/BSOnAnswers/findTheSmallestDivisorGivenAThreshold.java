package DSAQestions.BinarySearch.BSOnAnswers;

public class findTheSmallestDivisorGivenAThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 0;
        int high = max(nums);
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(sum(nums ,mid) <= threshold){
                ans = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int sum(int[] nums , int divisor) {
        int sum =0;
        for(int i=0;i<nums.length;i++){
            // sum += Math.ceil(nums[i]/divisor);
            sum += Math.ceil((double) nums[i] / divisor);
        }
        return sum;

    }

    public int max(int[] nums){
        int max =-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                max =nums[i];
            }
        }
        return max;
    }


}
