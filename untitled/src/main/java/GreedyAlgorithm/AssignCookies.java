package GreedyAlgorithm;

//leetcode 455. Assign Cookies
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }

        // Sort the arrays
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;

       while (childIndex<g.length && cookieIndex<s.length){

           if (s[cookieIndex] >= g[childIndex]) {
              childIndex++;
           }
           cookieIndex++;
       }
       return  childIndex; // Return the number of content children


    }
}
