package Rescursion;

public class CountGoodNumbers {

    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;  // ceil(n/2)
        long odd = n / 2;         // floor(n/2)

        long evenPart = pow(5, even);
        long oddPart = pow(4, odd);

        return (int)((evenPart * oddPart) % MOD);
    }

    // Recursive power function: (base ^ exp) % MOD
    public long pow(long base, long exp) {
        if (exp == 0) return 1;

        long half = pow(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }
}
