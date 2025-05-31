package StackandQueue.Monotonic;

import java.util.Stack;
import java.util.Arrays;
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // Initialize result with -1
        Arrays.fill(res, -1);

        for(int i= 2*n -1 ; i>=0;i--){

            int idx = i % n;

            while(!stack.isEmpty() && stack.peek() <= nums[idx]){
                stack.pop();
            }

            if(i<n){
                res[idx] =  stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[idx]);
        }
        return res;
    }
}
