package DSAQestions.BinarySearch.BSOnAnswers;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {

        if(k> nums.length){
            return -1;
        }
        int low = max(nums);
        int high = sum(nums);

        while(low <= high ){

            int mid = low +(high-low)/2;

            if(check(nums,mid) > k){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }

    public int check(int[] nums, int mid){
        int student=1;
        int noOfBook = 0;

        for(int num : nums){
            if(noOfBook + num <= mid){
                noOfBook +=num;
            }else{
                student++;
                noOfBook = num;
            }
        }
        return student;
    }

    public static int max(int[]  nums){
        int max =-1;
        for(int num : nums){
            if(num > max){
                max =num;
            }
        }
        return max;
    }

    public static  int sum(int[] nums){
        int ans  = 0;
        for(int num : nums){
            ans +=num;
        }
        return ans;

    }
}
