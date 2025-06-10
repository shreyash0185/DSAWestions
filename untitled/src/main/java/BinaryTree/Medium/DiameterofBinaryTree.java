package BinaryTree.Medium;

public class DiameterofBinaryTree {

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

    public int diameterOfBinaryTree(TreeNode root) {
        int  arr[] = new int[1];
        helper(root , arr);
        return arr[0];

    }
    public int helper(TreeNode root, int[] arr) {
        if(root == null)return 0;

        int l = helper(root.left,arr);
        int r = helper(root.right,arr);

        arr[0] = Math.max(arr[0] ,l+r);

        return 1 +  Math.max(l,r);

    }
}
