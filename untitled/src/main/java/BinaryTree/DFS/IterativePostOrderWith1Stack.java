package BinaryTree.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderWith1Stack {

    // Definition for a binary tree node
public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }


    //With one stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.add(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek();
                if (temp.right != null && lastVisited != temp.right) {
                    curr = temp.right;
                } else {
                    temp = st.pop();
                    list.add(temp.val);
                    lastVisited = temp;
                }
            }
        }

        return list;


    }
}
