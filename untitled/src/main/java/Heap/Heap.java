package Heap;


import java.util.ArrayList;

public class Heap{

    private final ArrayList<Integer> heap;
    private final boolean isMinHeap;

    public Heap(boolean isMinHeap) {
        this.heap = new ArrayList<>();
        this.isMinHeap = isMinHeap;
    }


    //Compare function to determine the order of elements
    private boolean compare(int a , int b){
        return isMinHeap ? a<b : a>b;

    }

    public void insert(int value){
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }


    public int remove(){
        if(heap.isEmpty()){
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

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && compare(heap.get(index), heap.get(parentIndex))) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largestOrSmallest = index;

            if (leftChild < size && compare(heap.get(leftChild), heap.get(largestOrSmallest))) {
                largestOrSmallest = leftChild;
            }
            if (rightChild < size && compare(heap.get(rightChild), heap.get(largestOrSmallest))) {
                largestOrSmallest = rightChild;
            }
            if (largestOrSmallest == index) {
                break;
            }
            swap(index, largestOrSmallest);
            index = largestOrSmallest;
        }
    }




    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printHeap() {

        System.out.println(heap);
    }
}
