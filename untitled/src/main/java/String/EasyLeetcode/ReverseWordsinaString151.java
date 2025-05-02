package String.EasyLeetcode;

public class ReverseWordsinaString151 {



        public String reverseWords(String s) {
            // Step 1: Trim and normalize spaces
            String[] words = s.trim().split("\\s+");

            // Step 2: Use StringBuilder to reverse words
            StringBuilder sb = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                sb.append(words[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }

            return sb.toString();
        }


}



//Brute Force Approach
//Logic Steps:
//Trim leading and trailing spaces from the string.
//
//Replace multiple spaces between words with a single space.
//
//Split the string into words using space as a delimiter.
//
//Reverse the array of words.
//
//Join the words with a single space.
//
//Time Complexity:
//O(n) — where n is the length of the string (split, reverse, join are all linear operations).
//
//Space Complexity:
//O(n) — for the array of words and the final output string.
//
//Dry Run:
//Input: " hello world "
//Step 1: Trim → "hello world"
//Step 2: Normalize spaces → "hello world"
//Step 3: Split → ["hello", "world"]
//Step 4: Reverse → ["world", "hello"]
//Step 5: Join → "world hello"
//Output: "world hello"



//Optimized Approach
//Best Approach (Optimal / In-place Simulation)
//Note: This is especially meaningful if working with a mutable data structure like a character array.
//
//Logic Steps:
//Convert the string to a character array.
//
//Trim leading/trailing spaces and reduce multiple spaces to a single space in-place.
//
//Reverse the entire cleaned character array.
//
//Reverse each individual word in the reversed array to restore word order.
//
//Time Complexity:
//O(n) — each character is visited a constant number of times.
//
//Space Complexity:
//O(1) — in-place, if done on a character array.
//
//Dry Run:
//Input: " the sky is blue "
//Step 1: Trim and clean → "the sky is blue" → as char array
//Step 2: Reverse all → "eulb si yks eht"
//Step 3: Reverse each word:
//
//        "eulb" → "blue"
//
//        "si" → "is"
//
//        "yks" → "sky"
//
//        "eht" → "the"
//Final Output: "blue is sky the"
//
