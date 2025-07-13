package Heap.medium;

import java.util.PriorityQueue;

public class Kthsmallestelementinanarray {


    //Using priority queue
    public int findKthSmallest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
