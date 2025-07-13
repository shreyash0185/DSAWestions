package Arrays.H;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0;
        int ele1 =0;
        int cnt2=0;
        int ele2=0;

        for(int i=0;i<nums.length;i++){

            if(cnt1 == 0 && nums[i] != ele2){
                cnt1++;
                ele1 = nums[i];
            }else if(cnt2 == 0 && nums[i] != ele1){
                cnt2++;
                ele2 = nums[i];
            }else if(ele1 == nums[i]){
                cnt1++;
            }else if(ele2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        // ✅ Second pass: verify actual counts
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) cnt1++;
            else if (num == ele2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (cnt1 > n / 3) result.add(ele1);
        if (cnt2 > n / 3) result.add(ele2);

        return result;


    }
}
