import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class CombinationSumII40 {


    //Brute force -same as CombinationSumI
    //Time complexity - O(2^n) * k * log(k) - for sorting
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Set<List<Integer>> result = new HashSet<List<Integer>>();
//        List<Integer> ds = new ArrayList<>();
//        Arrays.sort(candidates);
//        function(0,candidates,target,result, ds);
//        return new ArrayList<>(result);
//        // return result;
//
//
//    }
//
//    public void function(int idx , int[] arr, int target, Set<List<Integer>> result , List<Integer> ds){
//
//        if(idx == arr.length){
//            if(target == 0){
//                result.add(new ArrayList<>(ds));
//            }
//            return;
//        }
//
//        if(arr[idx] <=target){
//            ds.add(arr[idx]);
//            function(idx+1,arr,target-arr[idx],result,ds);
//            ds.remove(ds.size()-1);
//
//        }
//        function(idx+1,arr,target,result,ds);
//
//    }


    //Optimized - using backtracking
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        function(0,candidates,target,result, ds);
        return new ArrayList<>(result);
        // return result;


    }

    public void function(int idx , int[] arr, int target, List<List<Integer>> result , List<Integer> ds){


        if(target == 0){
            result.add(new ArrayList<>(ds));
            return ;
        }

        for(int i = idx ;i<arr.length;i++){
            if(i>idx && arr[i] == arr[i-1])continue;

            if(arr[i] > target)break;

            ds.add(arr[i]);
            function(i+1 , arr, target-arr[i],result ,ds);

            ds.remove(ds.size() - 1);
        }
    }




}
