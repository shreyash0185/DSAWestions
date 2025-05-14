package Arrays.E;

public class longestSubarrayWithGivenSumKPositives {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
        System.out.println("Length of longest subarray with sum " + k + ": " + longestSubarrayWithSumK(arr, k));
    }


    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int maxLength = 0;
        int currentSum = 0;
        int l = 0;

        for (int r = 0; r < arr.length; r++) {
            currentSum += arr[r];

            while (currentSum > k) {
                currentSum -= arr[l];
                l++;
            }

            if (currentSum == k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }

        return maxLength;
    }
}
