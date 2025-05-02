package String.EasyLeetcode;
//Link - https://leetcode.com/problems/valid-anagram/description/
//Check if two strings are anagram of each other
public class ValidAnagram242 {

    //First
//    boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        char[] sArray = s.toCharArray();
//        char[] tArray = t.toCharArray();
//
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//
//        for (int i = 0; i < sArray.length; i++) {
//            if (sArray[i] != tArray[i]) return false;
//        }
//
//        return true;
//    }


    //Using Array
    boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){

            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;

        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0) return false;
        }

        return true;
    }


    //Using Map
//    boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        Map<Character, Integer> freq = new HashMap<>();
//
//        for (char c : s.toCharArray()) {
//            freq.put(c, freq.getOrDefault(c, 0) + 1);
//        }
//
//        for (char c : t.toCharArray()) {
//            if (!freq.containsKey(c)) return false;
//
//            freq.put(c, freq.get(c) - 1);
//
//            if (freq.get(c) < 0) return false;
//        }
//
//        return true;
//    }

}

//Brute force approach
//Brute Force
//Sort both strings and compare.
//
//        Steps
//If lengths of s and t are not equal, return false.
//
//Sort both strings.
//
//If sorted versions are equal, return true; else false.
//
//Time & Space
//Time: O(n log n) — for sorting both strings.
//
//        Space: O(n) — for storing sorted strings.
//
//        Dry Run
//s = "rat", t = "car"
//
//        Sorted s = "art", Sorted t = "acr"
//
//Not equal → return false

//Better Approach
//Approach 2: Better — Hash Map (Character Frequency Count)
//Steps
//If lengths are not equal, return false.
//
//Create a dictionary to count frequency of characters in s.
//
//Decrement the same count while iterating over t.
//
//If any count goes negative or key missing, return false.
//
//If all counts are zero in the end, return true.
//
//Time & Space
//Time: O(n)
//
//Space: O(1) (Only 26 letters max if lowercase)
//
//Dry Run
//s = "anagram", t = "nagaram"
//
//Frequency from s:
//        {a:3, n:1, g:1, r:1, m:1}
//
//Decrement with t:
//
//n → 0
//
//a → 2
//
//g → 0
//
//a → 1
//
//r → 0
//
//a → 0
//
//m → 0
//
//All frequencies are 0 → return true



//Using Array as well
//Approach 3: Best — Fixed-size Array (Only lowercase letters)
//Steps
//If lengths differ, return false.
//
//Use a 26-length array to count letters for s, decrement for t.
//
//At the end, check all counts are zero.
//
//        Time & Space
//Time: O(n)
//
//Space: O(1) — fixed array size (26)
//
//Dry Run
//s = "rat", t = "car"
//
//count['r'] += 1
//
//count['a'] += 1
//
//count['t'] += 1
//
//Then for t:
//
//count['c'] -= 1 → not in original → becomes -1 → return false



