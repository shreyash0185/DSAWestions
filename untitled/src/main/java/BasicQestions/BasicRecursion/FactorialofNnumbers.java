package BasicQestions.BasicRecursion;

public class FactorialofNnumbers {

    public static void main(String[] args) {
        int n = 5; // Example input
        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }

    public static int factorial(int n){
        if(n==0 || n ==1){
            return 1;
        }

        return n*factorial(n-1);
    }
}
