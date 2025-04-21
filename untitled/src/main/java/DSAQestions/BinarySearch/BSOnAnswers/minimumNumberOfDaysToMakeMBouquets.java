package DSAQestions.BinarySearch.BSOnAnswers;

public class minimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length){
            return -1;
        }

        int low = min(bloomDay) ;
        int high = max(bloomDay);
        int ans =-1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(possible(bloomDay , mid , m, k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
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
    public int min(int[] nums){
        int min =Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < min){
                min =nums[i];
            }
        }
        return min;
    }

    public boolean possible(int[] bloomDay,int mid , int m, int k) {

        int count =0;  int noOfDays = 0;

        for(int i=0;i<bloomDay.length ; i++){

            if(bloomDay[i] <= mid){
                count++;
            }else{
                noOfDays += count/k;
                count =0;
            }
        }

        noOfDays += count/k;
        if( noOfDays >= m){
            return true;
        }
        return false;

    }



}
