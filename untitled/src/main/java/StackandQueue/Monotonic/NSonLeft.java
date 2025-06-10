package StackandQueue.Monotonic;

import java.util.Stack;

public class NSonLeft {

    //using stack
    public static int[] NSonLeft(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.peek() >=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1; // No smaller element to the left
            }
            else{
                ans[i] = stack.peek(); // The top of the stack is the nearest smaller element
            }
            stack.push(arr[i]); // Push the current index onto the stack
        }
        return ans;
    }

    //main
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = NSonLeft(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
