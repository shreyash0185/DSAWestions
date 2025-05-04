package TwoPointers.SlindingWindow;
import java.util.Arrays;

public class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256]; // ASCII size
        Arrays.fill(hash, -1);     // Initialize all to -1

        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If the character was seen and is in the current window
            if (hash[ch] >= left) {
                left = hash[ch] + 1;
            }

            // Update the latest index of the current character
            hash[ch] = right;

            int len = right - left + 1;
            maxLength = Math.max(len, maxLength);
        }

        return maxLength;
    }
}
