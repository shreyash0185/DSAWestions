package Rescursion.AllSubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

//    public static void main(String[] args) {
//        List<String> result = new ArrayList<>();
//        helper(n, "", result);
//        return result;
//    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        helper(n, "", result);
        return result;

    }

    public void helper(int n , String ans , List<String> result) {

        if(ans.length() == 2*n){
            if(isValid(ans)){
                result.add(ans);

            }
            return ;
        }


        helper(n, ans + "(", result);
        helper(n, ans + ")", result);

    }

    private boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;

            if (balance < 0) return false;
        }
        return balance == 0;
    }
}
