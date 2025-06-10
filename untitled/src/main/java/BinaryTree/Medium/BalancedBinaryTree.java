package BinaryTree.Medium;

public class BalancedBinaryTree {

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


    public boolean isBalanced(TreeNode root) {

        if(helper(root) == -1)return false;

        return true;


    }

    public int helper(TreeNode root){
        if(root == null)return 0;

        int l = helper(root.left);
        int r =helper(root.right);

        if(l == -1 || r ==-1) return -1;


        if (Math.abs(l - r) > 1) return -1;

        return 1+ Math.max( l , r);
    }
}
