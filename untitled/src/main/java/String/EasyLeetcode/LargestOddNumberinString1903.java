package String.EasyLeetcode;
//Link -https://leetcode.com/problems/largest-odd-number-in-string/description/
public class LargestOddNumberinString1903 {

    public String largestOddNumber(String num) {

        for(int i =num.length()-1 ; i>=0;i--){

            char c = num.charAt(i);

            if((c -'0') % 2 == 1){
                return num.substring(0,i+1);
            }

        }

        return "";
    }
}

//Approch 1 - Brute
//Brute Force Approach (Naive)
//Generate all possible non-empty substrings of the given string.
//
//Convert each substring to an integer.
//
//Check if it is odd.
//
//Track the maximum odd integer found.
//
//Return it as a string.
//
//Time Complexity: O(n³)
//Space Complexity: O(1) or O(n) for storing max substring.


//Best -
//Better Approach
//Iterate from right to left in the string.
//
//As soon as you find an odd digit, return the substring from the start to that position (inclusive).
//
//This works because appending more digits to the right of an odd number won't change its oddness.
//
//Time Complexity: O(n)
//Space Complexity: O(1)