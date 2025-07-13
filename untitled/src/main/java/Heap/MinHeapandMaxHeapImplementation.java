package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeapandMaxHeapImplementation {

    public static void main(String[] args) {
        Heap minHeap = new Heap(true);
        minHeap.insert(10);
        minHeap.printHeap();
        minHeap.insert(5);
        minHeap.printHeap();
        minHeap.insert(20);
        minHeap.printHeap();
        minHeap.insert(3);
        minHeap.printHeap();
        minHeap.insert(8);
        minHeap.printHeap();

        System.out.println("Min Heap: ");
        minHeap.printHeap();

        System.out.println("Removed from Min Heap: " + minHeap.remove());
        minHeap.printHeap();
        System.out.println("Removed from Min Heap: " + minHeap.remove());
        minHeap.printHeap();
        System.out.println("Removed from Min Heap: " + minHeap.remove());
        minHeap.printHeap();
        System.out.println("Removed from Min Heap: " + minHeap.remove());
        minHeap.printHeap();
        System.out.println("Removed from Min Heap: " + minHeap.remove());
        minHeap.printHeap();
        System.out.println("Removed from Min Heap: " + minHeap.remove());
        minHeap.printHeap();


//        Heap maxHeap = new Heap(false);
//        maxHeap.insert(10);
//        maxHeap.printHeap();
//        maxHeap.insert(5);
//        maxHeap.printHeap();
//        maxHeap.insert(20);
//        maxHeap.printHeap();
//        maxHeap.insert(3);
//        maxHeap.printHeap();
//        maxHeap.insert(8);
//        maxHeap.printHeap();
//
//        System.out.println("Max Heap: ");
//        maxHeap.printHeap();
//
//        System.out.println("Removed from Max Heap: " + maxHeap.remove());
//        maxHeap.printHeap();
    }
}

