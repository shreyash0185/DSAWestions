package StackandQueue.Monotonic;


import java.util.Stack;

public class NSonRight {
    //using stack  - next smaller ele on right
    public int[] nextSmallerElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() >=arr[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ?-1:stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }
    //main method to test the functionality
    public static void main(String[] args) {
        NSonRight nsonRight = new NSonRight();
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = nsonRight.nextSmallerElement(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
