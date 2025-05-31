package StackandQueue.Monotonic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode 901. Online Stock Span
public class SlidinWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<nums.length;i++){

            if(!deque.isEmpty() && deque.getFirst() <= i-k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }


            deque.addLast(i);

            if(i>=k-1){
                // ans.add(deque.getFirst());
                ans.add(nums[deque.getFirst()]); // ✅ fix
            }
        }

        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;


    }
}
