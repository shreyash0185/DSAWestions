package BinaryTree.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InterativePreOrder {

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

    //Iterative
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<Integer>();

        if(root == null) return ans;

        Stack<TreeNode> st = new Stack<>();

        st.add(root);

        while(!st.isEmpty()){

            TreeNode top = st.pop();
            ans.add(top.val);

            if(top.right != null){
                st.add(top.right);
            }

            if(top.left != null){
                st.add(top.left);
            }

        }

        return ans;

    }

}
