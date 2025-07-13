package Heap;

public class Checkifanarrayrepresentsaminheapornot {

    //main method to check if an array represents a min-heap
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        boolean isMinHeap = checkMinHeap(arr);
        System.out.println("Does the array represent a min-heap? " + isMinHeap);
    }


    public static boolean checkMinHeap(int[] arr) {
        int n = arr.length;

        // Check if each parent node is less than or equal to its children
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            if (leftChildIndex < n && arr[i] > arr[leftChildIndex]) {
                return false; // Parent is greater than left child
            }
            if (rightChildIndex < n && arr[i] > arr[rightChildIndex]) {
                return false; // Parent is greater than right child
            }
        }

        return true; // The array represents a min-heap
    }
}
