package String.EasyLeetcode;
//Link -https://leetcode.com/problems/rotate-string/description/
// Problem - Given two strings s and goal, return true if you can swap two letters in s so that the result is equal to goal, otherwise, return false.
//check whether one string is a rotation of another
public class RotateString796 {

    public boolean rotateString(String s, String goal) {
        String result = s+s;
        return result.contains(goal);
    }

}


//Brute Force Approach
//1. Brute Force Approach
//Logic Steps
//If lengths of s and goal are not equal → return False.
//
//For each rotation from 0 to len(s) - 1:
//
//Perform the rotation by moving the first i characters to the end.
//
//Compare the result with goal.
//
//If match found → return True.
//
//After all rotations, if no match → return False.
//
//Time and Space Complexity
//Time: O(n²) — because for each of n rotations, you build a rotated string of length n.
//
//        Space: O(n) — storing the rotated string.
//

//2. Optimized Approach
//3. Best Approach
//Logic Steps
//If lengths of s and goal differ → return False.
//
//Concatenate s + s → all possible rotations are in this string.
//
//        Check if goal is a substring of s + s.
//
//If yes → return True, else → False.
//
//Time and Space Complexity
//Time: O(n) — substring search in a 2n-length string (efficient substring check).
//
//Space: O(n) — due to s + s.
//
//Dry Run Example
//Input: s = "abcde", goal = "cdeab"
//s + s = "abcdeabcde"
//Check if "cdeab" in "abcdeabcde" → yes → return True


