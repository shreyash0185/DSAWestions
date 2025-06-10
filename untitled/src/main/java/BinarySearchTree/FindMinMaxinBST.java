package BinarySearchTree;

public class FindMinMaxinBST {

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

    public int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE; // or throw an exception
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE; // or throw an exception
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
