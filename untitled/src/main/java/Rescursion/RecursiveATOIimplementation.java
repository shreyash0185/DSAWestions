package Rescursion;

public class RecursiveATOIimplementation {

    //String into Integer - "123456" -> 123456
    public static int convertStringToInt(String str) {
        return convertStringToIntHelper(str, str.length() - 1);
    }
    private static int convertStringToIntHelper(String str ,int index) {
        // ✅ Correct base case
        if (index < 0) {
            return 0;
        }

        int digit = str.charAt(index) - '0';
        return convertStringToIntHelper(str, index - 1) * 10 + digit;


    }

}
