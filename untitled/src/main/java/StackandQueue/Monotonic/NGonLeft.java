package StackandQueue.Monotonic;

import java.util.Stack;

public class NGonLeft {
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

       for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }

    //main method for testing
    public static void main(String[] args) {
        NGonLeft ng = new NGonLeft();
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = ng.nextGreaterElement(nums);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
