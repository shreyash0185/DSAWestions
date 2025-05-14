package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int maxLength = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        while (right < s.length()) {
            charCountMap.put(s.charAt(right), charCountMap.getOrDefault(s.charAt(right), 0) + 1);

            while (charCountMap.size() > k) {
                charCountMap.put(s.charAt(left), charCountMap.get(s.charAt(left)) - 1);
                if (charCountMap.get(s.charAt(left)) == 0) {
                    charCountMap.remove(s.charAt(left));
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
