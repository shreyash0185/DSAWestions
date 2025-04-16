package org.example.queue;
import java.util.*;

public class QueueUsingStackII {
static class Queue{

    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    static void enQueue(int x){

        while(!s1.isEmpty()){
            s2.push(s1.pop());

        }
        // Push item into s1
        s1.push(x);

        // Push everything back to s1
        while (!s2.isEmpty())
        {
            s1.push(s2.pop());
            //s2.pop();
        }
    }

    // Dequeue an item from the queue
    static int deQueue()
    {
        // if first stack is empty
        if (s1.isEmpty())
        {
            return -1;
        }

        // Return top of s1
        int x = s1.peek();
        s1.pop();
        return x;
    }

    // Driver code
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
}

//Complexity Analysis:
//
//Time Complexity:
//Push operation: O(N).
//In the worst case we have empty whole of stack 1 into stack 2.
//Pop operation: O(1).
//Same as pop operation in stack.
//Auxiliary Space: O(N).
//Use of stack for storing values.