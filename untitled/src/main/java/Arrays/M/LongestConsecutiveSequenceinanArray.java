package Arrays.M;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceinanArray {

    //Using approach 1

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int lastsmall = Integer.MIN_VALUE;
        int cnt =0;
        int ans =0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastsmall){
                cnt++;
                lastsmall = nums[i];
            }else if(nums[i] != lastsmall){
                cnt =1;
                lastsmall = nums[i];
            }

            ans = Math.max(cnt, ans);
        }
        return ans;

    }

    //using approach 2
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longestStreak = 0;

        for(int num : set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
