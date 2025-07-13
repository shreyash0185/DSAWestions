package BitManipulation;

public class AllDivisorsofaNumber {

    public static void printAllDivisors(int n) {
        System.out.println("Divisors of " + n + ":");
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != n / i) { // Avoid printing the square root twice
                    System.out.print(n / i + " ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int number = 36; // Example number
        printAllDivisors(number);
    }
}
