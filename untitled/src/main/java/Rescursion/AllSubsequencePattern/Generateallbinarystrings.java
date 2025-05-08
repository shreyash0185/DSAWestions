package Rescursion.AllSubsequencePattern;

public class Generateallbinarystrings {

    public static void main(String[] args) {
        int n = 3;
        generate(n, "");
    }

    public static void generate(int n, String str) {
        // Base case: if the length of the string is equal to n, print it
        if (str.length() == n) {
            System.out.println(str);
            return;
        }

        // Recursive case: add '0' and '1' to the string and call the function recursively
        generate(n, str + "0");
        generate(n, str + "1");
    }
}
