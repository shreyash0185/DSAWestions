package DSAQestions.BinarySearch.BSOnAnswers;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        // Range - > [1 ...... max -> 11 ]

        // [3,6,7,11]       h =8
        //   1   2 3  4 5 ..... 11  ->



        int low = 1;
        int high = max(piles);
        int ans =-1;
        while(low <= high){
            int mid = low + (high - low)/2;

            int noOfBanana = find(piles,  h , mid);
            if(noOfBanana <= h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;

    }

    public int find(int[] piles, int h , int mid ){
        int ans = 0;
        for(int i=0;i<piles.length ; i++){
            ans  += Math.ceil((double) piles[i] / mid);
        }
        return ans;
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
