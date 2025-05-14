package Arrays.E;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8};
        int target = 7;
        int index = linearSearch(arr, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index of the found element
            }
        }
        return -1; // Element not found
    }
}
