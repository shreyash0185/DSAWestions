package BasicQestions.BasicRecursion;

public class Checkifastringispalindromeornot {

    public boolean isPalindrome(String s) {

        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    private boolean isPalindromeHelper(String s, int left, int right) {

        if(left >= right)return true;

        // Move left pointer to next alphanumeric
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }

        //
        while(right > left && !Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }
        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
            return false;
        }

        return  isPalindromeHelper(s,left+1,right-1)  ;
    }
}
