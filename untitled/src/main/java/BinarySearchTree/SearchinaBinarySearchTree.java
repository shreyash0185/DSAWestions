package BinarySearchTree;

public class SearchinaBinarySearchTree {

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

    //Recursive approach

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);

        return searchBST(root.right, val);
    }

    //Iterative approach
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            if (val < root.val) root = root.left;
            else root = root.right;
        }
        return null; // If the value is not found
    }

}
