package Rescursion.AllSubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class PrintallsubsequencesPowerSet {
//
//    public List<List<Integer>> subsets(int[] nums) {
//        int n = nums.length;
//        List<List<Integer>> result = new ArrayList<>();
//
//        int total = 1 << n; // 2^n
//        for (int mask = 0; mask < total; mask++) {
//            List<Integer> subset = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                if ((mask & (1 << i)) != 0) {
//                    subset.add(nums[i]);
//                }
//            }
//            result.add(subset);
//        }
//
//        return result;
//    }



//    //Recursive Approach
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        backtrack(0, nums, new ArrayList<>(), result);
//        return result;
//    }
//
//    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
//        if (index == nums.length) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//
//        // Include
//        current.add(nums[index]);
//        backtrack(index + 1, nums, current, result);
//
//        // Exclude
//        current.remove(current.size() - 1);
//        backtrack(index + 1, nums, current, result);
//    }



    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }

        return result;
    }



}

//Brute Force – Bitmasking
//Generate all combinations using binary representation.
//
//For each index in 0 to 2^n - 1, treat it as a bitmask.
//
//🔧 Time: O(2^n × n)
//🧠 Space: O(1) (ignoring output)



//Brute Force – Recursion
//2. Better – Include/Exclude Recursion (Backtracking)
//🔍 Logic:
//At each index, include or exclude the current element.
//
//        🔧 Time: O(2^n)
//🧠 Space: O(n) recursion stack



//3. Best – Iterative Method
// 🔍 Logic:
//Start from [[]] and for each number, add it to all existing subsets.
//
//🔧 Time: O(2^n × n)
//🧠 Space: O(2^n × n)


