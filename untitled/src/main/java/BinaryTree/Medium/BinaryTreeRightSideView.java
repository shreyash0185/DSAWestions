package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

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

    // Your implementation for the BinaryTreeRightSideView goes here
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root , 0 , ans);
        return ans;
    }

    public void helper(TreeNode root , int level ,  List<Integer> ans){
        if(root == null)return ;

        if(level == ans.size()){
            ans.add(root.val);
        }

        helper(root.right , level+1 , ans);
        helper(root.left , level+1 , ans);
    }






    //Left side view
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helperLeft(root , 0 , ans);
        return ans;
    }
    public void helperLeft(TreeNode root , int level ,  List<Integer> ans){
        if(root == null)return ;

        if(level == ans.size()){
            ans.add(root.val);
        }

        helperLeft(root.left , level+1 , ans);
        helperLeft(root.right , level+1 , ans);
    }
}
