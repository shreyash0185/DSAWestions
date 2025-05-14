package Sorting;

public class InsertionSortRecursive {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr, arr.length);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void insertionSort(int arr[], int n) {
        // Base case: If the array size is 1 or less, it's already sorted
        if (n <= 1) {
            return;
        }

        // Sort the first n-1 elements
        insertionSort(arr, n - 1);

        // Insert the last element at its correct position in the sorted array
        int last = arr[n - 1];
        int j = n - 2;

        // Move elements of arr[0..n-2], that are greater than last,
        // to one position ahead of their current position
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
}
