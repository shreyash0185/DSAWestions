package BitManipulation;

public class Checkifanumberispowerof2ornot {

    public static boolean isPowerOfTwo(int n) {
        // A number is a power of two if it is greater than 0 and
        // the bitwise AND of the number and its predecessor is 0
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int number = 8; // Example number

        if (isPowerOfTwo(number)) {
            System.out.println(number + " is a power of 2.");
        } else {
            System.out.println(number + " is not a power of 2.");
        }
    }
}
