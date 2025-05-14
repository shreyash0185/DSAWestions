package Arrays.E;

import java.util.HashSet;
import java.util.Set;

public class RemoveduplicatesfromSortedarray {

    //Approach 1 using set
    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }
        return index;
    }


    //Two pointer approach
    public int removeDuplicates1(int[] nums) {
        int i=0;
        for(int j = 1 ;j<nums.length;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
