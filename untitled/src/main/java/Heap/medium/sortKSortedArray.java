package Heap.medium;

import java.util.PriorityQueue;
import java.util.Arrays;

public class sortKSortedArray {

    public static void sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int index = 0;

        // Step 1: Build initial heap with first k+1 items
        for (int i = 0; i <= k && i < arr.length; i++) {
            pq.add(arr[i]);
        }

        // Step 2: Process the remaining elements
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = pq.poll(); // extract min and place it
            pq.add(arr[i]);           // push next element
        }

        // Step 3: Extract remaining elements from heap
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        sortKSortedArray(arr, k);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
