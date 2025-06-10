package BinaryTree.Medium;

public class BinaryTreeMaximumPathSum {

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

    public int maxPathSum(TreeNode root) {
        int[] arr=new int[1];
        arr[0] = Integer.MIN_VALUE;
        int ans =helper(root , arr);
        return arr[0];

    }

    public int helper(TreeNode root , int[] arr){

        if(root == null)return 0;

        int l = Math.max(0,helper(root.left , arr));
        int r = Math.max(0,helper(root.right , arr));

        arr[0] = Math.max(arr[0] , l+r+root.val);

        return Math.max(l , r) + root.val;
    }
}
