package BasicQestions.Maths;

public class PrintallDivisors {

    public static void main(String[] args) {
        int n = 36;
        System.out.println("Divisors of " + n + " are: ");
        printDivisors(n);
    }

    static void printDivisors(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != n / i) {
                    System.out.print(n / i + " ");
                }
            }
        }
    }
}

//N=36

//1 * 36   ->
//2 * 18   ->  2nd is n/2
//3 * 12   ->  3rd is n/3
//4 * 9    ->  4th is n/4
//6 * 6    ->  5th is n/6
////So we can find the divisors of a number by iterating from 1 to sqrt(n) and checking if n is divisible by i