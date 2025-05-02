package String.EasyLeetcode;
//Link - https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix14 {


    //Brute Force Approach
//    public static String longestCommonPrefix(String[] strs) {
//        // Step 1: Find the shortest string
//        String minStr = strs[0];
//        for (String s : strs) {
//            if (s.length() < minStr.length()) {
//                minStr = s;
//            }
//        }
//
//        // Step 2: Initialize answer
//        StringBuilder ans = new StringBuilder();
//
//        // Step 3: Check each character index in minStr
//        for (int i = 0; i < minStr.length(); i++) {
//            char c = minStr.charAt(i);
//
//            // Step 4: Compare character at index i in all strings
//            for (String s : strs) {
//                if (s.charAt(i) != c) {
//                    // Mismatch found - return current answer
//                    return ans.toString();
//                }
//            }
//
//            // Step 5: All matched - append character to answer
//            ans.append(c);
//        }
//
//        // Step 6: Return result
//        return ans.toString();
//    }


//    public static String longestCommonPrefix(String[] strs) {
//        // Step 1: Sort the array
//        Arrays.sort(strs);
//
//        // Step 2: Take first and last string after sorting
//        String first = strs[0];
//        String last = strs[strs.length - 1];
//
//        // Step 3: Compare characters of first and last string
//        int i = 0;
//        while (i < first.length() && i < last.length()) {
//            if (first.charAt(i) != last.charAt(i)) {
//                break; // Mismatch found
//            }
//            i++;
//        }
//
//        // Step 4: Return common prefix
//        return first.substring(0, i);
//    }



    //Best Approach
//    public static String longestCommonPrefix(String[] strs) {
//        // Step 1: Loop through each character index of the first string
//        for (int i = 0; i < strs[0].length(); i++) {
//            char c = strs[0].charAt(i);
//
//            // Step 2: Compare character at i with all other strings
//            for (int j = 1; j < strs.length; j++) {
//                // Check if index out of bounds or mismatch
//                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
//                    // Step 3: Return prefix up to this point
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//
//        // Step 4: All characters matched - return full first string
//        return strs[0];
//    }




}


//Brute Force Approach
//Time Complexity:
//Let n = number of strings, m = length of the smallest string
//
//Time: O(m * n) (comparing each character with all strings)
//
//Space Complexity:
//O(1) (excluding output)



//Optimized Approach
//    Better Approach (Sorting)
//    Time Complexity:
//    Sort: O(n log n)
//
//    Compare first and last: O(m)
//
//    Total: O(n log n + m)
//
//    Space Complexity:
//    O(1) (ignoring sort space depending on implementation)



//Best Approach (Vertical Scanning)
//Time Complexity:
//O(m * n) — similar to brute force, but more efficient early exits
//
//Space Complexity:
//O(1)