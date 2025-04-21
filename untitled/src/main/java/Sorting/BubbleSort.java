package Sorting;

//Pick the largest Bring to End
//Tc - O(N^2)


public class BubbleSort {

    public int[] sortArray(int[] nums) {
        for(int i=1;i<=nums.length-1;i++){
            for(int j = 0 ; j<nums.length-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] =nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

}
