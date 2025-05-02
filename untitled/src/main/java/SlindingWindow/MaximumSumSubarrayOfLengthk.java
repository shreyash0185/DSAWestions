package SlindingWindow;

// Problem: Given an array of integers and a number k, find the maximum sum of a subarray of size k.
//LeetCode Problem: 643. Maximum Average Subarray k
public class MaximumSumSubarrayOfLengthk {

    //Length is Fixed - can be solved using the slinding window - as window is fixed
    //Time Complexity - O(n)
    //Window size is fixed - so we can use the slinding window technique here window size is k

    //Acquire the first k elements and find the sum
    //the rest of the elements are added to the window and the first element is removed from the window

    //The sum is updated by adding the new element and removing the first element


    //Code
    public static int maxSum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            return -1; // Not enough elements
        }
        int maxSum = 0;
        int windowSum = 0;

        // Calculate the sum of the first window
        for(int i=0;i<k;i++){
            windowSum += arr[i];

        }
        maxSum = windowSum;

        // Slide the window
        for(int i=k;i<n;i++){
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
