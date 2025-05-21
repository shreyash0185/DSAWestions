package Rescursion.hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        int result =1;
        String[] ops = {"+", "-", "*"};
        helper(num, target, ans, "", 0, 0, 0);
        return ans;
    }

    public void helper(String num, int target, List<String> ans, String path, int pos, long eval, long multed)
    {

        if (pos == num.length()) {
            if (eval == target) {
                ans.add(path);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            // avoid numbers with leading zeros
            if (i != pos && num.charAt(pos) == '0') break;

            String part = num.substring(pos, i + 1);
            long cur = Long.parseLong(part);

            if (pos == 0) {
                // first number, no operator
                helper(num, target, ans, path + part, i + 1, cur, cur);
            } else {
                helper(num, target, ans, path + "+" + part, i + 1, eval + cur, cur);
                helper(num, target, ans, path + "-" + part, i + 1, eval - cur, -cur);
                // for multiplication, subtract last operand and add multed value
                helper(num, target, ans, path + "*" + part, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
