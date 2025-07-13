package BitManipulation;

public class Countthenumberofsetbits {

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            // Increment count if the least significant bit is set
            count += (n & 1);
            // Right shift n to process the next bit
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 29; // Example number (binary: 11101)
        int setBitsCount = countSetBits(number);
        System.out.println("Number of set bits in " + number + " is: " + setBitsCount);
    }
}
