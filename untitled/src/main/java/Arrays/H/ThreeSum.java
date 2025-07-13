package Arrays.H;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;


public class ThreeSum {


    //Brute Force O(N^3)
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }

        ans.addAll(set);
        return ans;
    }


    //Better Approach O(N^2) with above code only
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set1 = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                int third = -(nums[i] + nums[j]);
                if (set1.contains(third)) {
                    long sum = nums[i] + nums[j] + third;
                    if (sum == 0) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
                set1.add(nums[j]);

            }
        }

        ans.addAll(set);
        return ans;

    }


    //Using Two Pointer Approach O(N^2) with out space complexity
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    ans.add(temp);


                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }


            }


        }


        return ans;

    }


}
