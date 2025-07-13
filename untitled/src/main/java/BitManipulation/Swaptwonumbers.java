package BitManipulation;

public class Swaptwonumbers {

    public static void swap(int[] arr, int i, int j) {
        // Swap two numbers using XOR
        if (i != j) { // Check to avoid swapping the same index
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20}; // Example array

        System.out.println("Before swap: " + numbers[0] + ", " + numbers[1]);
        swap(numbers, 0, 1);
        System.out.println("After swap: " + numbers[0] + ", " + numbers[1]);
    }
}
