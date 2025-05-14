package Arrays.M;

public class MajorityElement {


    //Majority Element (>n/2 times)
    //Map approach
    public static int majorityElement(int[] nums) {
        java.util.HashMap<Integer, Integer> countMap = new java.util.HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > nums.length / 2) {
                return num; // Found the majority element
            }
        }
        return -1; // No majority element found
    }


    //Boyer-Moore Voting Algorithm
    public static int majorityElementBoyerMoore(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        // Verify that the candidate is indeed the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1; // Return -1 if no majority element found
    }


}
