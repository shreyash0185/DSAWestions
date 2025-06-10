package BinaryTree.DFS;

public class PreOrder {

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

    // Pre-order traversal of a binary tree
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " "); // Visit node
        preOrderTraversal(root.left); // Traverse left subtree
        preOrderTraversal(root.right); // Traverse right subtree
    }
}
