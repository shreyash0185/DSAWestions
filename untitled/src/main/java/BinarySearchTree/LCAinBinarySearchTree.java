package BinarySearchTree;

public class LCAinBinarySearchTree {

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

    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null) return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left subtree
        if (n1 < root.val && n2 < root.val) {
            return findLCA(root.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right subtree
        if (n1 > root.val && n2 > root.val) {
            return findLCA(root.right, n1, n2);
        }

        // If we reach here, then root is the LCA
        return root;
    }
}
