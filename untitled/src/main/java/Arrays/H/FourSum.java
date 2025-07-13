package Arrays.H;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum {


    //Brute Force O(N^4)
    public List<List<Integer>> fourSum1(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    for (int l = k + 1; l < n; l++) {

                        long sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            //     List<Integer> temp = new ArrayList<>({nums[i] ,nums[j],nums[k],nums[l]});
                            List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            Collections.sort(temp);

                            set.add(temp);
                        }
                    }
                }
            }
        }

        ans.addAll(set);

        return ans;

    }


    //Better Approach O(N^3)
    public List<List<Integer>> fourSum2(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        HashSet<List<Integer>> set = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> set1 = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    int forth = target - (nums[i] + nums[j] + nums[k]);

                    if (set1.contains(forth)) {
                        long sum = nums[i] + nums[j] + nums[k] + forth;
                        if (sum == target) {
                            List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], forth));
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                    set1.add(nums[k]);


                }
            }
        }

        ans.addAll(set);

        return ans;

    }


    //Optimal Approach O(N^2) with 2 pointers

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        HashSet<List<Integer>> set = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;


                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        ans.add(temp);

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;


                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }


            }
        }


        return ans;

    }


}
