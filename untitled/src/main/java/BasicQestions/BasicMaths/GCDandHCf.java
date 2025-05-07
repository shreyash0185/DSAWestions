package BasicQestions.BasicMaths;

public class GCDandHCf {
    public static void main(String[] args) {
       int N1 = 12, N2 = 15;
        System.out.println("GCD of " + N1 + " and " + N2 + " is: " + gcd(N1, N2));
        System.out.println("LCM of " + N1 + " and " + N2 + " is: " + lcm(N1, N2));

    }

    // Function to return GCD of a and b
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Function to return LCM of a and b
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}


//Approach	Time Complexity	Notes
//Euclidean Algorithm	O(log(min(a,b)))	Very efficient (recursive/iterative)
//Dry run for GCD for recursive approch
//Dry Run: gcd(12, 9)
//We follow the recursion calls step-by-step:
//
//matlab
//Copy code
//gcd(12, 9)
//→ b != 0 → call gcd(9, 12 % 9 = 3)
//
//gcd(9, 3)
//→ b != 0 → call gcd(3, 9 % 3 = 0)
//
//gcd(3, 0)
//→ b == 0 → return 3
//        ✅ So, gcd(12, 9) = 3