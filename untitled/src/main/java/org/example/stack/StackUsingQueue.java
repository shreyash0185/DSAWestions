package org.example.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();

        // To maintain current number of
        // elements
        static int curr_size;

        static void push(int x){

            //push x first in empty q2
            q2.add(x);

            //push all the remaining
            //element in q1 to q2
            while(!q1.isEmpty()){
                q2.add(q1.peek());
                q1.remove();
            }

//            swap the number of two Queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;

        }

        static void pop(){
            // if no elements are there in q1
            if(q1.isEmpty()) return ;
            q1.remove();
        }

        static int top(){
            if(q1.isEmpty()) return -1;
            return q1.peek();

        }

        static int size(){
            return q1.size();
        }



    }
    // driver code
    public static void main(String[] args)
    {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }
}


//Time Complexity:
//
//Push operation: O(N), As all the elements need to be popped out from the Queue (q1) and push them back to Queue (q2).
//Pop operation: O(1), As we need to remove the front element from the Queue.
//Auxiliary Space: O(N), As we use two queues for the implementation of a Stack
