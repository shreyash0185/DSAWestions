package Arrays.E;

import static java.util.Collections.reverse;

public class LeftRotateanarraybyoneplace {

    public static void leftRotate(int[] arr) {
        int n = arr.length;
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;   // prevent division by zero
        k = k % n;            // normalize k to prevent overflow

        // Reverse the parts and then the whole array
        reverse(nums, 0, n - 1);         // Reverse entire array
        reverse(nums, 0, k - 1);         // Reverse first k elements
        reverse(nums, k, n - 1);         // Reverse the rest
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
