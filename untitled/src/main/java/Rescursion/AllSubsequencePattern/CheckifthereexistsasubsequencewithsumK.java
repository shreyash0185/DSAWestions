package Rescursion.AllSubsequencePattern;

public class CheckifthereexistsasubsequencewithsumK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 2;
        System.out.println(isSubsequenceSumK(arr, arr.length, k));
    }

    public static boolean isSubsequenceSumK(int[] arr, int n, int k) {
        return isSubsequenceSumKHelper(arr, n - 1, k);
    }

   private static boolean isSubsequenceSumKHelper(int[] arr , int index , int k){

        // Base case: if we have considered all elements
        if (index < 0) {
            return k == 0; // Check if the sum is equal to k
        }

        // Include the current element
       boolean include = isSubsequenceSumKHelper(arr, index - 1, k - arr[index]);

        // Exclude the current element
        boolean exclude = isSubsequenceSumKHelper(arr, index - 1, k);

        return include || exclude; // Return true if either case is true

   }
}


//1, 2, 1   ->   1 include -> k = 1
                        // 2 include -> k = -1
                               // 1 include -> k = -2
                               // 1 exclude -> k = -1
                        // 2 exclude -> k = 1
                                 // 1 include -> k = 1
                                    // 1 exclude -> k = 2
    // 1 exclude -> k = 2
                        // 2 include -> k = 0  // return true
                               // 1 include -> k = -1
                               // 1 exclude -> k = 0
                        // 2 exclude -> k = 2
                                 // 1 include -> k = 1
                                    // 1 exclude -> k = 2


