package BitManipulation;

public class SetUnsettherightmostunsetbit {
    public static int setRightmostUnsetBit(int n) {
        // Find the rightmost unset bit and set it
        return n | (n + 1);
    }

    public static int unsetRightmostSetBit(int n) {
        // Find the rightmost set bit and unset it
        return n & (n - 1);
    }

    public static void main(String[] args) {
        int number = 10; // Example number (binary: 1010)

        int setResult = setRightmostUnsetBit(number);
        System.out.println("After setting the rightmost unset bit: " + setResult);

        int unsetResult = unsetRightmostSetBit(number);
        System.out.println("After unsetting the rightmost set bit: " + unsetResult);
    }
}
