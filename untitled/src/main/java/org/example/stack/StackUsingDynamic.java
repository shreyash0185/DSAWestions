package org.example.stack;

import java.util.ArrayList;

public class StackUsingDynamic {
    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>();

        // Push elements
        s.add(10);
        s.add(20);
        s.add(30);

        // Pop and print the top element
        System.out.println(s.get(s.size() - 1) + " popped from stack");
        s.remove(s.size() - 1);

        // Peek at the top element
        System.out.println("Top element is: " + s.get(s.size() - 1));

        // Print all elements in the stack
        System.out.print("Elements present in stack: ");
        while (!s.isEmpty()) {
            System.out.print(s.get(s.size() - 1) + " ");
            s.remove(s.size() - 1);
        }
    }
}
