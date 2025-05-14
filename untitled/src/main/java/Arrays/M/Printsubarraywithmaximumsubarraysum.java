package Arrays.M;

public class Printsubarraywithmaximumsubarraysum {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        printSubarrayWithMaxSum(arr);
    }

    public static void printSubarrayWithMaxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maxSum);
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
