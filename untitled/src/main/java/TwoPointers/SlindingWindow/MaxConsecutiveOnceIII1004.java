package TwoPointers.SlindingWindow;
//Qestion - Given an array of 0s and 1s, you need to find the maximum length of a contiguous subarray that contains at most K 1s. You can flip at most K 0s to 1s.
//At most K 1s mean
//max -K (0,1,2,k) all inculeded
public class MaxConsecutiveOnceIII1004 {

    //Sliding window
    //1.Acquire till valid
    //Release till invalid - O(N) + O(K)
//    public int longestOnes(int[] nums, int k) {
//        int i = 0, j = 0, zc = 0, ans = 0;
//
//        while (i < nums.length) {
//            if (nums[i] == 0) {
//                zc++;
//            }
//
//            while (zc > k) {
//                if (nums[j] == 0) {
//                    zc--;
//                }
//                j++;
//            }
//
//            ans = Math.max(ans, i - j + 1); // corrected window length
//            i++;
//        }
//
//        return ans;
//    }

    //Most Optimized - O(N)
    public int longestOnes(int[] nums, int k) {
        int l = 0, zero = 0, maxLen = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zero++;

            if (zero > k) {
                zero -= nums[l++] == 0 ? 1 : 0;
            }

            maxLen = Math.max(maxLen, r - l + 1);


        }
        return maxLen;

    }

}
