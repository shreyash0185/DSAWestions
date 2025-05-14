package Arrays.E;
//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
public class MissingNumber {

    //Sum approach
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (n * (n + 1)) / 2; // Sum of first n natural numbers
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        return totalSum - arraySum; // The missing number
    }

    //XOR approach
    public static int missingNumber1(int[] nums) {
        int n = nums.length;
        int xorSum = 0;
        for(int i =0;i<nums.length;i++){
            xorSum ^= nums[i];
        }

        for(int i=0;i<n;i++){
            xorSum ^= i;
        }

        return xorSum;
    }
}
