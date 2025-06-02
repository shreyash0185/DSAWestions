package GreedyAlgorithm;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If we can't reach this index, return false
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update the maximum reachable index
            if (maxReach >= nums.length - 1) {
                return true; // If we can reach or exceed the last index, return true
            }
        }
        return false; // If we finish the loop without reaching the last index
    }
}
