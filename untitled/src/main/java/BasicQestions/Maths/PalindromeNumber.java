package BasicQestions.Maths;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) return false; // negative numbers can't be palindrome

        int rev = 0;
        int org =x;
        while(x !=0){

            int c = x%10;

            // Check for overflow — optional, but good practice
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && c > 7)) {
                return false;
            }

            rev = rev*10 + c;

            x /=10;
        }



        return rev==org ;

    }
}
