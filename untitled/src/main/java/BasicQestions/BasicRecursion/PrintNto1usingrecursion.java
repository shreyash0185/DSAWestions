package BasicQestions.BasicRecursion;

public class PrintNto1usingrecursion {
    public static void main(String[] args) {
        int n = 5;
        printNto1(n);
    }

    static void printNto1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printNto1(n - 1);
    }
}
