package BitManipulation;


//Check if the i-th bit is set or not
public class Checkiftheithbitissetornot {

    public static boolean isIthBitSet(int n, int i) {
        // Create a mask with the i-th bit set
        int mask = 1 << i;
        // Use bitwise AND to check if the i-th bit is set
        return (n & mask) != 0;
    }

    public static void main(String[] args) {
        int n = 5; // Binary: 101
        int i = 2; // Check the 2nd bit (0-indexed)

        if (isIthBitSet(n, i)) {
            System.out.println("The " + i + "-th bit is set.");
        } else {
            System.out.println("The " + i + "-th bit is not set.");
        }
    }
}
