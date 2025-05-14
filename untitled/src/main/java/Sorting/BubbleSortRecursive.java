package Sorting;

public class BubbleSortRecursive {

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr, arr.length);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void bubbleSort(int arr[], int n) {
        // Base case: If the array size is 1 or less, it's already sorted
        if (n == 1) {
            return;
        }

        // One pass of bubble sort
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap arr[i] and arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursive call for the remaining elements
        bubbleSort(arr, n - 1);
    }
}
