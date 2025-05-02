package String.EasyLeetcode;
//Link-https://leetcode.com/problems/remove-outermost-parentheses/description/
public class RemoveOutermostParentheses1021 {

    public String removeOuterParentheses(String s) {
        int balance =0;
        String result ="";

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == '('){
                if(balance >0){
                    result +='(';
                }
                balance++;

            }else{
                balance--;
                if(balance > 0){
                    result +=')';
                }
            }
        }

        return result;
    }

}

//Steps - Brute
//1. Brute Force Approach
//Logic Steps:
//Traverse the string and identify primitive substrings by tracking the balance between opening and closing brackets.
//
//For each primitive, remove the first and last character (outermost parentheses).
//
//Concatenate the results.
//
//Time Complexity:
//O(n) – one pass to split primitives, one to process them.
//
//Space Complexity:
//O(n) – to store substrings and result.
//
//Dry Run Example:
//Input: "(()())(())"
//
//Traversal:
//
//        "(()())" → Primitive 1 → Remove outer → "()()"
//
//        "(())" → Primitive 2 → Remove outer → "()"
//
//Output: "()()()"



//2. Optimized Approach
//2. Better = Best Approach (Optimal Stackless Counter Approach)
//Logic Steps:
//Use a balance counter to track nesting depth:
//
//Increment when '(' seen.
//
//Decrement when ')' seen.
//
//Only add to result if:
//
//        '(' is not the outermost, i.e., balance > 0 before increment.
//
//        ')' is not the outermost, i.e., balance > 1 after decrement.
//
//Time Complexity:
//O(n) – single pass.
//
//Space Complexity:
//O(n) – for output string only (no extra data structures).
//
//Dry Run Example:
//Input: "(()())(())(()(()))"
//
//Track balance while traversing:
//
//        ( → balance = 1 → don't add
//
//        ( → balance = 2 → add '('
//
//        ) → balance = 1 → add ')'
//
//        ( → balance = 2 → add '('
//
//        ) → balance = 1 → add ')'
//
//        ) → balance = 0 → don't add
//
//        ...
//
//Final result: "()()()()(())"
//
//Output: "()()()()(())"
