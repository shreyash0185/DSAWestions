package Arrays.H;

public class NumberofSubarrayswithxorK {

    public int subarraysXor(int[] arr, int k) {
        int count = 0;
        int xor = 0;
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        map.put(0, 1); // Initialize for the case where xor equals k at some point

        for (int num : arr) {
            xor ^= num; // Update the cumulative XOR

            // Check if (xor ^ k) exists in the map
            if (map.containsKey(xor ^ k)) {
                count += map.get(xor ^ k);
            }

            // Update the map with the current xor
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
