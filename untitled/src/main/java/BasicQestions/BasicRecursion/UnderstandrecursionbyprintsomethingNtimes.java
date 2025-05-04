package BasicQestions.BasicRecursion;

public class UnderstandrecursionbyprintsomethingNtimes {
    public static void main(String[] args) {
        int n = 5;
        printNtimes(n);
    }

    public static void printNtimes(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Hello");
        printNtimes(n - 1);
    }
}
