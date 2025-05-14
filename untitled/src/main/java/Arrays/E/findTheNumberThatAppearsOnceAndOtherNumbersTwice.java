package Arrays.E;

public class findTheNumberThatAppearsOnceAndOtherNumbersTwice {

    //XOR approach
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result; // The number that appears once
    }
}
