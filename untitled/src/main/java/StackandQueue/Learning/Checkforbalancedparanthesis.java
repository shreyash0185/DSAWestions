package StackandQueue.Learning;

import java.util.Stack;

public class Checkforbalancedparanthesis {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);

            if(ch == '(' || ch== '{' || ch== '['){
                st.push(s.charAt(i));
            }else{
                if (st.isEmpty()) return false;
                char top = st.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }

            }


            i++;

        }

        return st.isEmpty();
    }
}
