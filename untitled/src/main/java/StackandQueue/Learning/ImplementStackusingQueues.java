package StackandQueue.Learning;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    Queue<Integer> q = new LinkedList<>();

    public ImplementStackusingQueues() {
    }


    public void push(int x) {
        q.offer(x); // Add to back
        int size = q.size();
        // Rotate all elements except the new one to the back
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
