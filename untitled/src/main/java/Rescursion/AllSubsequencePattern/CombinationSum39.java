package Rescursion.AllSubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<>();
        function(0,candidates,target,result, ds);
        return result;


    }

    public void function(int idx , int[] arr, int target,List<List<Integer>> result , List<Integer> ds){

        if(idx == arr.length){
            if(target == 0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[idx] <=target){
            ds.add(arr[idx]);
            function(idx,arr,target-arr[idx],result,ds);
            ds.remove(ds.size()-1);

        }
        function(idx+1,arr,target,result,ds);

    }
}
