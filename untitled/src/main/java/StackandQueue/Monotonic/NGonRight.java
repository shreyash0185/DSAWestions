package StackandQueue.Monotonic;

import java.util.Stack;

public class NGonRight {

    public int[] nextGreaterElement(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize result array with -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Traverse the array in reverse order
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            // If the stack is not empty, the top element is the next greater element
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            // Push the current element onto the stack
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NGonRight ng = new NGonRight();
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = ng.nextGreaterElement(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }


}
