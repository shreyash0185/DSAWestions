package Rescursion.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(0 ,s , new HashSet<>(wordDict) );
    }
    public boolean helper(int start , String s , HashSet<String> wordDict){

        if(start == s.length()){
            return true;
        }


        for(int end = start+1 ;end <= s.length() ; end++ ){

            String sub = s.substring(start ,end );

            if(wordDict.contains(sub) && helper(end , s , wordDict)){
                return true;
            }
        }

        return false;
    }


    //Approach 2 DP
    boolean helper2(int start, String s, Set<String> wordSet, Map<Integer, Boolean> memo) {
        if (start == s.length()) return true;
        if (memo.containsKey(start)) return memo.get(start);

        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (wordSet.contains(sub) && helper2(end, s, wordSet, memo)) {
                memo.put(start, true);
                return true;
            }
        }

        memo.put(start, false);
        return false;
    }
}
