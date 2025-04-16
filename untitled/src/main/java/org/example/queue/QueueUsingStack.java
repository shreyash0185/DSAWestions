package org.example.queue;

import java.util.Stack;

public class QueueUsingStack{
static class Queue{

    static Stack<Integer> s1 = new Stack<Integer>();


    static void enQueue(int x){


        // Push item into s1
        s1.push(x);

       for(int i=0;i<s1.size();i++) {

           s1.push(s1.pop());
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
        QueueUsingStackII.Queue q = new QueueUsingStackII.Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
}