package GreedyAlgorithm;

public class ValidParanthesisChecker {

    //Approach: Use a recursive function to check if the string is valid.
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false; // Odd length cannot be valid
        }

        return checkValidity(s, 0, 0);
    }
    private boolean checkValidity(String s, int index, int balance) {
        if (index == s.length()) {
            return balance == 0; // All parentheses must be balanced
        }

        char currentChar = s.charAt(index);

        if (currentChar == '(') {
            return checkValidity(s, index + 1, balance + 1);
        } else if (currentChar == ')') {
            if (balance == 0) {
                return false; // More closing than opening parentheses
            }
            return checkValidity(s, index + 1, balance - 1);
        } else {
            return checkValidity(s, index + 1, balance); // Ignore other characters
        }
    }


    //Approach: Use a DP approach to check if the string is valid.
    public boolean isValidDP(String s) {
        if (s.length() % 2 != 0) {
            return false; // Odd length cannot be valid
        }

        int[][] dp = new int[s.length()][s.length()];

        for (int len = 2; len <= s.length(); len += 2) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == '(' && s.charAt(j) == ')') {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
            }
        }

        return dp[0][s.length() - 1] == s.length();
    }

    //Approach 3 - Min max Range Greedy Algorithm
    public boolean isValidMinMax(String s) {
        int minOpen = 0, maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }

            if (maxOpen < 0) {
                return false; // More closing than opening parentheses
            }
            minOpen = Math.max(minOpen, 0); // Ensure minOpen doesn't go negative
        }

        return minOpen == 0; // All parentheses must be balanced
    }
}
