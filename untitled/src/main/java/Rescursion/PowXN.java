package Rescursion;

public class PowXN {

    public double myPow(double x, int n) {

        long N = n;  // Use long to handle Integer.MIN_VALUE

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);


    }
    private double fastPow(double x, long n) {
        if (n == 0) return 1;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}


// // Use long to handle Integer.MIN_VALUE
// The issue with your code arises due to integer overflow when handling n = Integer.MIN_VALUE (which is -2147483648).