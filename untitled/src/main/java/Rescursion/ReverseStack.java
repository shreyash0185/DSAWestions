package Rescursion;

import java.util.Stack;

public class ReverseStack {

    // Insert element at the bottom of the stack
    static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, item);
        stack.push(top);
    }

    // Reverse the entire stack using recursion
    static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
