package BasicQestions.BasicRecursion;

public class SumoffirstNnumbers {
    public static void main(String[] args) {
        int n = 5;
        int result = sumOfFirstNNumbers(n);
        System.out.println("Sum of first " + n + " numbers is: " + result);
    }

    public static int sumOfFirstNNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfFirstNNumbers(n - 1);
    }
}
