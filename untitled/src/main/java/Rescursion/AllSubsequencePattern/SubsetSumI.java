package Rescursion.AllSubsequencePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetSumI {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int idx = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        isSubsetSum(arr, arr.length, idx, 0, ans);
        System.out.println(ans);
    }

    //approach 1 - recursion
    public static void isSubsetSum(int[] arr, int n, int idx , int sum,ArrayList<Integer> ans) {


        if(idx == n){
            ans.add(sum);
            return;
        }

        isSubsetSum(arr, n, idx + 1, sum + arr[idx], ans); // include the current element

        isSubsetSum(arr, n, idx + 1, sum, ans); // exclude the current element


    }
}


