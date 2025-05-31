package StackandQueue.Monotonic;

//LeetCode 277. The Celebrity Problem
public class TheCelebrityProblem {

    //Matrix is given with 1 and zeros
    //if a[i][j] = 1, then i knows j
    //if a[i][j] = 0, then i does not know j
    //celebrity is a person who is known by everyone but does not know anyone

    public int findCelebrity(int[][] a) {
        int n = a.length;
        int candidate = 0;

        // Find a candidate for celebrity
        for (int i = 1; i < n; i++) {
            if (a[candidate][i] == 1) {
                candidate = i; // candidate knows i, so candidate cannot be celebrity
            }
        }

        // Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (a[candidate][i] == 1 || a[i][candidate] == 0)) {
                return -1; // candidate knows someone or someone does not know candidate
            }
        }

        return candidate; // found celebrity
    }
}
