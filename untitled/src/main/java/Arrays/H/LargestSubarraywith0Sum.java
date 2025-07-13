package Arrays.H;

public class LargestSubarraywith0Sum {


    //Using HashMap
    public int maxLen(int[] arr, int n) {
        int maxLength = 0;
        int sum = 0;
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLength = i + 1;
            } else if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
