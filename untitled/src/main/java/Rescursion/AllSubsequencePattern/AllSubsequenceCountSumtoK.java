package Rescursion.AllSubsequencePattern;

public class AllSubsequenceCountSumtoK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 2;
        System.out.println(countSubsequences(arr, arr.length, k));
    }

    public static int countSubsequences(int[] arr, int n, int k) {
        return countSubsequencesHelper(arr, n - 1, k,0);
    }

    private static int countSubsequencesHelper(int[] arr, int index, int k , int sum) {

        // Base case: if the sum exceeds k, return 0
        if(sum > k)return 0;

        // Base case: if we have considered all elements
        if (index == arr.length) {
            return sum == k ? 1 : 0;
        }


        // Include the current element
        int include = countSubsequencesHelper(arr, index - 1, k , sum + arr[index]);

        // Exclude the current element
        int exclude = countSubsequencesHelper(arr, index - 1, k, sum); ;

        return include + exclude;
    }
}
