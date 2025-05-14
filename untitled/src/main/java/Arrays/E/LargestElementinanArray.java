package Arrays.E;

public class LargestElementinanArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8};
        System.out.println("Largest element in the array: " + findLargest(arr));
    }

    public static int findLargest(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}
