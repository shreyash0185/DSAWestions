import java.util.ArrayList;

public class AllKindofPatternsinRecursionSubsequence {


    public static void main(String[] args) {
        System.out.println("Hello World");
    }

//    public static void printAllSubsequencesSumEqualToK(int index, int[] arr, int n, int k, ArrayList<Integer> ds) {
//        if (index == n) {
//            if (k == 0) {
//                System.out.println(ds);
//            }
//            return;
//        }
//
//        // Include the current element
//        ds.add(arr[index]);
//        printAllSubsequencesSumEqualToK(index + 1, arr, n, k - arr[index], ds);
//
//        // Exclude the current element
//        ds.remove(ds.size() - 1);
//        printAllSubsequencesSumEqualToK(index + 1, arr, n, k, ds);
//    }

//    public static boolean printAllSubsequencesSumEqualToK(int index, int[] arr, int n, int k, ArrayList<Integer> ds) {
//        if (index == n) {
//            if (k == 0) {
//                System.out.println(ds);
//                return true
//            }
//            return false;
//        }
//
//        // Include the current element
//        ds.add(arr[index]);
//        if(printAllSubsequencesSumEqualToK(index + 1, arr, n, k - arr[index], ds)) {
//            return true;
//        }
//
//
//        // Exclude the current element
//        ds.remove(ds.size() - 1);
//        if(printAllSubsequencesSumEqualToK(index + 1, arr, n, k, ds)) {
//            return true;
//        }
//       return false;
//    }


    public static int countAllSubsequencesSumEqualToK(int index, int[] arr, int n, int k, ArrayList<Integer> ds) {
        if (index == n) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }

        // Include the current element
        ds.add(arr[index]);
        int include = countAllSubsequencesSumEqualToK(index + 1, arr, n, k - arr[index], ds);

        // Exclude the current element
        ds.remove(ds.size() - 1);
        int exclude = countAllSubsequencesSumEqualToK(index + 1, arr, n, k, ds);

        return include + exclude;
    }
}
