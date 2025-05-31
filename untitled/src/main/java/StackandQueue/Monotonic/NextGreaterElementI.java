package StackandQueue.Monotonic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> ngeMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length-1 ; i>=0;i--){

            int current = nums2[i];

            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            int nextGreater  = stack.isEmpty() ? -1 : stack.peek();

            ngeMap.put(current , nextGreater );

            stack.push(nums2[i]);
        }
        // Build result array for nums1 using the map
        int[] result = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            result[i] = ngeMap.get(nums1[i]);
        }

        return result;




    }
}
