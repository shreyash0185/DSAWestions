package BitManipulation;

public class Checkifanumberisoddornot {

    public static boolean isOdd(int n) {
        // Check if the least significant bit is set
        return (n & 1) != 0;
    }

    public static void main(String[] args) {
        int number = 5; // Example number

        if (isOdd(number)) {
            System.out.println(number + " is odd.");
        } else {
            System.out.println(number + " is even.");
        }
    }
}
