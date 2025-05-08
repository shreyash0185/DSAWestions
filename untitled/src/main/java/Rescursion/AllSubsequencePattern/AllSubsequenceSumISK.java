package Rescursion.AllSubsequencePattern;

public class AllSubsequenceSumISK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 2;
        System.out.println(printAllSubsequences(arr, arr.length, k));
    }

    // Function to print all subsequences of an array whose sum is equal to k
    public static int printAllSubsequences(int[] arr, int n, int k) {
        return printAllSubsequencesHelper(arr, n, k, 0, 0);
    }

    // Helper function to find all subsequences
    private static int printAllSubsequencesHelper(int[] arr, int n, int k, int index, int sum) {
        // Base case: if we reach the end of the array
        if (index == n) {
            if (sum == k) {
                return 1; // Found a valid subsequence
            }
            return 0; // No valid subsequence found
        }

        // Include the current element in the sum
        sum += arr[index];
        int include = printAllSubsequencesHelper(arr, n, k, index + 1, sum);

        // Exclude the current element from the sum
        sum -= arr[index];
        int exclude = printAllSubsequencesHelper(arr, n, k, index + 1, sum);

        return include + exclude; // Return total count of valid subsequences
    }

}
