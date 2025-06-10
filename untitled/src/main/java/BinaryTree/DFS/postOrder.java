package BinaryTree.DFS;

public class postOrder {

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

    // Post-order traversal of a binary tree
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left); // Traverse left subtree
        postOrderTraversal(root.right); // Traverse right subtree
        System.out.print(root.val + " "); // Visit node
    }
}
