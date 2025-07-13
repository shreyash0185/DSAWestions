package Heap;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap() {
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

        while(index >0 && heap.get(index) < heap.get(pI)){
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
            int smallest = index;

            while (index < size){

                if(lc < size && heap.get(lc) < heap.get(smallest)) {
                    smallest = lc;
                }

                if(rc < size && heap.get(rc) < heap.get(smallest)) {
                    smallest = rc;
                }

                if(smallest == index) {
                    break;
                }

                swap(index, smallest);
                index = smallest;

            }
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
        MinHeap minHeap = new MinHeap();
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
    }
}
