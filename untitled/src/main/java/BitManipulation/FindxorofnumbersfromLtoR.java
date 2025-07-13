package BitManipulation;

public class FindxorofnumbersfromLtoR {

    public static int findXor(int l, int r) {
        // Calculate the XOR from 0 to r and from 0 to l-1
        return xorFromZero(r) ^ xorFromZero(l - 1);
    }

    private static int xorFromZero(int n) {
        // The result of XOR from 0 to n follows a pattern based on n % 4
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            case 3: return 0;
            default: return -1; // This should never happen
        }
    }

    public static void main(String[] args) {
        int l = 3; // Example lower bound
        int r = 9; // Example upper bound

        int result = findXor(l, r);
        System.out.println("XOR from " + l + " to " + r + " is: " + result);
    }
}
