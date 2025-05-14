package Arrays.E;

public class MoveZerostoend {

    //Approach 1 using create temp array push all non zero ele then other are by default zero
//    public static void moveZeroes(int[] arr) {
//        int n = arr.length;
//        int[] temp = new int[n];
//        int j = 0;
//
//        // Copy non-zero elements to temp array
//        for (int i = 0; i < n; i++) {
//            if (arr[i] != 0) {
//                temp[j++] = arr[i];
//            }
//        }
//
//        // Fill the rest of the temp array with zeros
//        while (j < n) {
//            temp[j++] = 0;
//        }
//
//        // Copy the temp array back to the original array
//        for (int i = 0; i < n; i++) {
//            arr[i] = temp[i];
//        }
//    }


    //Approach 2 using two pointer approach

    public static void moveZeroes(int[] arr) {
        int n = arr.length;
        int j = 0; // Pointer for the position to place non-zero elements

        // Traverse the array
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j++] = arr[i]; // Place non-zero element at index j
            }
        }

        // Fill the rest of the array with zeros
        while (j < n) {
            arr[j++] = 0;
        }
    }
}
