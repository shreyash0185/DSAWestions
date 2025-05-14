//Given an array nums of n integers.Return sum of all subsets of the array nums.
//
//
//
//Output can be printed in any order.

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SubsetSumsI {

    public static void main(String[] args) {
        int[] nums = {3 , 1, 2};
        ArrayList<Integer> ds = new ArrayList<>();// Example input
        subsetSumHelper(nums,0,ds,0);
        Collections.sort(ds);
        System.out.println("Sum of all subsets: " + ds);
    }



    private static void subsetSumHelper(int[] nums , int index , ArrayList<Integer> ds , int sum){

        if(index == nums.length){
            ds.add(sum);
            return ;
        }


            // Include the current element
            subsetSumHelper(nums, index + 1, ds, sum + nums[index]);

            // Exclude the current element
            subsetSumHelper(nums, index + 1, ds, sum);


    }
}

//Time complexity - O(2^n) * k
//Space complexity - O(n) - for recursion stack

//Final Time Complexity:
//Without sorting or any extra operation:
//        👉 Time Complexity = O(2^n)
//
//If sorting the subset sums afterward:
//        👉 Time Complexity = O(2^n * log(2^n)) = O(2^n * n)
//(since log(2^n) = n)