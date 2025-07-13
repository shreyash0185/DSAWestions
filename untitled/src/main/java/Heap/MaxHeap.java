package Heap;

import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public int remove(){
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if(!heap.isEmpty()){
            heap.set(0,last);
            heapifyDown(0);

        }
        return root;
    }

    private void heapifyUp(int index){
        int pI = (index - 1) / 2;

        while(index >0 && heap.get(index) > heap.get(pI)){
            swap(index, pI);
            index = pI;
            pI = (index - 1) / 2;
        }

    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while(index < size){
            int lc = 2 * index + 1;
            int rc = 2 * index + 2;
            int largest = index;


                if(lc < size && heap.get(lc) > heap.get(largest)) {
                    largest = lc;
                }

                if(rc < size && heap.get(rc) > heap.get(largest)) {
                    largest = rc;
                }

                if(largest == index) {
                    break;
                }

                swap(index, largest);
                index = largest;

        }
    }





    // Swap helper
    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    // Print heap as array
    public void printHeap() {
        System.out.println(heap);
    }



    // main method for testing
    public static void main(String[] args) {
        MaxHeap minHeap = new MaxHeap();
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

        System.out.println("Removed from Mxn Heap: " + minHeap.remove());
        minHeap.printHeap();
        System.out.println("Removed from Mxn Heap: " + minHeap.remove());
        minHeap.printHeap();
        System.out.println("Removed from Mxn Heap: " + minHeap.remove());
        minHeap.printHeap();
    }
}
