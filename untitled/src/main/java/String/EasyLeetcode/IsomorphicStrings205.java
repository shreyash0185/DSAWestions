package String.EasyLeetcode;

import java.util.HashMap;

public class IsomorphicStrings205 {

    //approache 1
//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        // Try to build character mapping by checking every possibility
//        return canMap(s, t);
//    }
//
//    private boolean canMap(String s, String t) {
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                if (s.charAt(i) == s.charAt(j) && t.charAt(i) != t.charAt(j)) {
//                    return false;
//                }
//                if (s.charAt(i) != s.charAt(j) && t.charAt(i) == t.charAt(j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//

    //approach 2
//    public boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        HashMap<Character, Character> mapST = new HashMap<>();
//        HashMap<Character, Character> mapTS = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//
//            if (mapST.containsKey(c1)) {
//                if (mapST.get(c1) != c2) return false;
//            } else {
//                if (mapTS.containsKey(c2)) return false;
//
//                mapST.put(c1, c2);
//                mapTS.put(c2, c1);
//            }
//        }
//
//        return true;
//    }


    //approach 3
    public boolean isIsomorphic(String s, String t) {
        return encode(s).equals(encode(t));
    }

    private String encode(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, index++);
            }
            sb.append(map.get(c)).append(",");
        }

        return sb.toString();
    }

}


//1. Brute Force Approach
//Logic:
//
//Try every possible mapping from characters in s to characters in t.
//
//For each mapping, check if replacing characters in s gives t.
//
//Ensure no two characters in s map to the same character in t.
//
//        Steps:
//
//Generate all bijective (one-to-one) mappings between characters in s and t.
//
//For each mapping, transform s and compare with t.
//
//If a valid one exists, return true.
//
//Time Complexity:
//
//Exponential: O(n!) due to all permutations of mappings.
//
//Space Complexity:
//
//O(n) for storing the mapping.
//
//        Note: This approach is impractical for large strings due to factorial time.




//2. Optimized Approach (Using One Hash Map)
//Better Approach (Using Two Hash Maps)
//Logic:
//
//Use one map to store mapping from s to t.
//
//Use a second map to track if a character in t has already been mapped (to avoid many-to-one).
//
//Traverse both strings character by character and ensure consistency.
//
//        Steps:
//
//For each character pair (s[i], t[i]):
//
//If s[i] is already mapped, ensure it maps to t[i].
//
//If not mapped, check if t[i] is already mapped by another character.
//
//        If not, create a new mapping from s[i] to t[i].
//
//Time Complexity:
//
//O(n) — linear scan through the strings.
//
//Space Complexity:
//
//O(1) — constant, since character set size is fixed (ASCII = 128 max entries).





//3. Optimized Approach (Using One Hash Map)
//Best Approach (Using Pattern Indexing)
//Logic:
//
//Convert both s and t to a pattern of first occurrences.
//
//        Compare if both patterns are identical.
//
//The idea is: if their structural pattern is the same, they are isomorphic.
//
//Steps:
//
//Convert s to a list like [0, 1, 1] (e.g., for "egg").
//
//Do the same for t, like [0, 1, 1] (e.g., for "add").
//
//If patterns match, they’re isomorphic.
//
//Time Complexity:
//
//O(n) — one pass through both strings.
//
//Space Complexity:
//
//O(1) — constant auxiliary space (excluding output), again because of fixed charset.


