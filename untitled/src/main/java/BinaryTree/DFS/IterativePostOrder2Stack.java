package BinaryTree.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder2Stack {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        if(root == null)return list;
        st1.add(root);
        while(!st1.isEmpty()){

            TreeNode top = st1.pop();
            st2.add(top);
            if(top.left != null){
                st1.add(top.left);

            }

            if(top.right != null){
                st1.add(top.right);
            }
        }

        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }

        return list;


    }
}
