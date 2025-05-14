package Arrays.M;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersinanArray {


        public ArrayList<Integer> leaders(int[] nums) {
            int max = Integer.MIN_VALUE;
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > max) {
                    list.add(nums[i]);
                    max = nums[i];
                }
            }

            // Reverse to maintain left-to-right order
            Collections.reverse(list);
            return list;
        }


}
