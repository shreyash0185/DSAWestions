package Rescursion.AllSubsequencePattern;

//Check if there exists a subsequence with sum K
public class isSumPossible {

    public boolean isSumPossible(int[] nums, int k) {
        return helper(0, 0, nums, k);
    }


    private boolean helper(int index ,int sum , int[] nums , int k){

        //Base case
        if(index == nums.length){
            return sum == k;
        }


        // Include current element
        if (helper(index + 1, sum + nums[index], nums, k)) return true;

        // Exclude current element
        if (helper(index + 1, sum, nums, k)) return true;

        return false;
    }
}


//Brute Force (Generate all subsequences)
//🔧 Logic:
//Use recursion to include/exclude each element.
//
//Check sum at each leaf.
//
//🧠 Time: O(2^n)
//🧠 Space: O(n) recursion stack



//Better (Memoization / DP on subsequence)
//🔧 Logic:
//Use top-down memoization on (index, currentSum).
//
//        🧠 Time: O(n × k)
//🧠 Space: O(n × k) + recursion
//This is a variation of the Subset Sum Problem.


//Best (Bottom-Up DP / Tabulation)
//🔧 Logic:
//Use a 2D DP table dp[i][j] = true if sum j is possible with first i elements.
//
//🧠 Time: O(n × k)
//🧠 Space: O(n × k)
