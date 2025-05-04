package BasicQestions.BasicRecursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 10; // Example input
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
